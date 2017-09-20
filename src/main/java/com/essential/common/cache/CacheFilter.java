package com.essential.common.cache;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.essential.auth.model.UserInfo;
import com.essential.common.enums.PageCacheEnums;

public class CacheFilter implements Filter, ApplicationContextAware {
	private static final Logger log = LoggerFactory.getLogger(CacheFilter.class);
	
    private static ApplicationContext ctx; // 必须声明为static
    
    @Override
    public void init(FilterConfig config) throws ServletException {
    }
 
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    	HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        
        visitingInfo(req);
        
        Properties prop = new Properties();
		prop.load(this.getClass().getClassLoader()
				.getResourceAsStream("conf/jdbc.properties"));
		String access_allow = prop.getProperty("access_allow").trim();
		if(access_allow !=null && access_allow!="" && !access_allow.equals("")){
			resp.addHeader("Access-Control-Allow-Origin",access_allow);
	        resp.addHeader("Access-Control-Allow-Credentials", "true");
//	        resp.addHeader("Access-Control-Allow-Headers","X-Requested-With,X_Requested_With");
	        resp.addHeader("Access-Control-Allow-Headers","X-Requested-With,X_Requested_With,Content-Type");

		}
        
//        resp.addHeader("Access-Control-Allow-Origin","http://10.0.1.186:8081");
        resp.addHeader("Access-Control-Expose-Headers","sessionstatus");
        
//         如果不是访问主页，放行
        PageCacheEnums page = isFilter(req.getRequestURI());
        if (page == null) {
            filterChain.doFilter(servletRequest, resp);
            return;
        }
 
 
        // 访问的是主页
        // 从缓存中得到主页html
        String html = getHtmlFromCache(req.getRequestURI());
        if (null == html) {
            // 缓存中没有
            // 截取生成的html并放入缓存
            log.info("缓存不存在，生成缓存");
            ResponseWrapper wrapper = new ResponseWrapper(resp);
            // ***** 以上代码在请求被处理之前执行 *****
 
            filterChain.doFilter(servletRequest, wrapper);
 
            // ***** 以下代码在请求被处理后前执行 *****
 
            // 放入缓存
            html = wrapper.getResult();
            putIntoCache(html,req.getRequestURI(),page.getCacheMinutes());
 
        }
        
        // 返回响应
//        resp.setContentType("text/html; charset=utf-8");
//        if(req.getRequestURI().startsWith("/essential/index")){
//        	filterChain.doFilter(servletRequest, resp);
//            return;
//        }
//        try {
//        	Subject currentUser = SecurityUtils.getSubject();  
//        	if(currentUser.isAuthenticated()){
//        		filterChain.doFilter(servletRequest, resp);
//                return;
//            }
//		} catch (Exception e) {
//			// TODO: handle exception
//			resp.getWriter().print("登陆失效，请重新登陆");
//		}
        
        
        
//        resp.getWriter().print(html);
 
    }

	private void visitingInfo(HttpServletRequest req) {
		String ua = req.getHeader("User-Agent");
        log.info("客户端IP："+getIpAddr(req)+"||请求地址："+req.getRequestURI()+"||客户端类型:"+ua);
	}
 
    @Override
    public void destroy() {
 
    }
 
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CacheFilter.ctx = applicationContext; // 保存spring容器到static变量中
    }
    
    public PageCacheEnums isFilter(String url){
    	for(PageCacheEnums page : PageCacheEnums.values()){
    		if(url.startsWith(page.getUrl())){
    			return page;
    		}
    	}
    	return null;
    }
    
    private String getHtmlFromCache(String cacheKey) {
        StringRedisTemplate redis = (StringRedisTemplate)ctx.getBean("redisTemplate");
        return redis.opsForValue().get(cacheKey);
    }
 
    private void putIntoCache(String html,String cacheKey,long cacheMinutes) {
        StringRedisTemplate redis = (StringRedisTemplate)ctx.getBean("redisTemplate");
        redis.opsForValue().set(cacheKey, html);
        //失效时间为0，则永远有效
        if(cacheMinutes!=0){
        	redis.expire(cacheKey, cacheMinutes, TimeUnit.MINUTES);
        }
    }
    
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (null != ip && !"".equals(ip.trim())
				&& !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (null != ip && !"".equals(ip.trim())
				&& !"unknown".equalsIgnoreCase(ip)) {
			// get first ip from proxy ip
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		return request.getRemoteAddr();
	}
}