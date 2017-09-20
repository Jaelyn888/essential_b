package com.essential.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.auth.model.UserInfo;
import com.essential.auth.service.UserService;

public class ExtendFormAuthenticationFilter extends FormAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(FormAuthenticationFilter.class);
    
    private String userTypeParam = null;
    
    public String getUserTypeParam() { 
        return userTypeParam; 
     } 

    public String getUserTypeParam(ServletRequest request) {
		return WebUtils.getCleanParam(request, getUserTypeParam());
	}

	public void setUserTypeParam(String userTypeParam) {
		this.userTypeParam = userTypeParam;
	}

	@Autowired
	UserService userService;
    
    /**
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    @ResponseBody
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    	HttpServletResponse httpServletResponse = setCharacter(response);
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    	String ua = httpServletRequest.getHeader("User-Agent");

        if(this.isLoginRequest(request, response)) {
            if(this.isLoginSubmission(request, response)) {
                if(log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }
                return this.executeLogin(request, response);
            } else {
                if(log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                return true;
            }
        } else {
            if(log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the Authentication url [" + this.getLoginUrl() + "]");
            }
            if(TerminalUtils.checkAgentIsMobile(ua)){
        		return true;
        	}
//            this.saveRequestAndRedirectToLogin(request, response);
            if(SecurityUtils.getSubject().isAuthenticated()){
            	return true;
            }
//            return this.executeLogin(request, response);
            
            httpServletResponse.setHeader("sessionstatus", "timeout");
            PrintWriter out = httpServletResponse.getWriter();
            
//            out.println("{\"code\":\"false\",\"msg\":\"请重新登陆\"}");
            out.println(new JSONObject(CommonResponseUtils.failureResponse("请重新登陆")));
            out.flush();
            out.close();
            return false;
        }
    }

	private HttpServletResponse setCharacter(ServletResponse response) {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    	httpServletResponse.setCharacterEncoding("UTF-8");
    	httpServletResponse.setContentType("application/json;charset=utf-8");
		return httpServletResponse;
	}

    /**
     * 当登录成功
     * @param token
     * @param subject
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    @ResponseBody
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
    	HttpServletResponse httpServletResponse = setCharacter(response);
    	//将user对象放入session，这里你可能用不到，可以删除
        Map<String,Object> map = new HashMap<String,Object>();
        
//        Serializable sessionId = subject.getSession().getId();
        UserInfo userInfo = (UserInfo)subject.getPrincipal();
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>登陆后的sessionId ："+sessionId);
        
        map.put("userId", userInfo.getUserId());
//        JSONObject responseJSONObject = new JSONObject(map);
        PrintWriter out = httpServletResponse.getWriter();
        out.println(new JSONObject(CommonResponseUtils.successResponse("登陆成功",map)));
        out.flush();
        out.close();
        return false;
    }

    /**
     * 当登录失败
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    @ResponseBody
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
    	HttpServletResponse httpServletResponse = setCharacter(response);
    	
        try {
            PrintWriter out = httpServletResponse.getWriter();
            String message = e.getClass().getSimpleName();
            if ("IncorrectCredentialsException".equals(message)) {
//                out.println("{\"code\":\"false\",\"msg\":\"用户名或密码错误\"}");
                out.println(new JSONObject(CommonResponseUtils.failureResponse("用户名或密码错误")));
            } else if ("UnknownAccountException".equals(message)) {
//                out.println("{\"code\":\"false\",\"msg\":\"用户名或密码错误\"}");
                out.println(new JSONObject(CommonResponseUtils.failureResponse("用户名或密码错误")));
            } else if ("LockedAccountException".equals(message)) {
//                out.println("{\"code\":\"false\",\"msg\":\"账号被锁定\"}");
                out.println(new JSONObject(CommonResponseUtils.failureResponse("账号被锁定")));
            } else {
//                out.println("{\"code\":\"false\",\"msg\":\"登陆失败，请重新登陆\"}");
                out.println(new JSONObject(CommonResponseUtils.failureResponse("登陆失败，请重新登陆")));
            }
            out.flush();
            out.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return false;
    }
    
    /** 
     * 创建自定义的令牌 
     */  
    @Override  
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {  
    	String usernameParam = getUsername(request);
    	String passwordParam = getPassword(request);
    	String userTypeParam = getUserTypeParam(request);
        return new ExtendsUsernamePasswordToken(usernameParam, passwordParam, userTypeParam==null?-1L:Long.valueOf(userTypeParam));  
    }  
}