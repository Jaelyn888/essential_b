
package com.essential.base.controller;

/*****************************************************
 * HISTORY
 * 
 * 2015/01/29 欧阳俊伟 
 * 创建文件
 * 
 *****************************************************/

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.essential.auth.model.User;
import com.essential.auth.model.UserInfo;
import com.essential.auth.service.UserService;
import com.essential.common.model.DataTable;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.ExtendsUsernamePasswordToken;



/**
 * @ClassName: BaseController
 * @Description: 基本控制类
 * @author: 欧阳俊伟
 * @date: 2015年1月29日 下午4:16:20
 *
 */ 
@Controller
@RequestMapping("/")
public class BaseController {
	
	@Resource
	private UserService UserService;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	/**
	 * @Description: 登录
	 * @author: 欧阳俊伟
	 * @param: user
	 * @param: @return
	 * @return: ModelAndView
	 * @throws
	 */ 
	@RequestMapping("login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	/**  
	 * @Description:网站欢迎页面. 
	 * @param @param request
	 * @param @return.
	 * @author yinyi  
	 */
	@RequestMapping("welcomeIndex")
	public ModelAndView welcomeIndex(HttpServletRequest request) {
		return new ModelAndView("helloWorld");
	}
	
	/**  
	 * @Description:
	 * @param @param request
	 * @param @param userId
	 * @param @return.
	 * @author xush  
	 * @throws IOException 
	 */
	@RequestMapping("welcome")
	public ModelAndView welcome(HttpServletRequest request,HttpServletResponse response,String userId) throws IOException {
		User user = UserService.findUserByKey("userId", userId).get(0);
		request.getSession().setAttribute("user", user);
		return new ModelAndView("welcome");
	}
	
	/**
	 * @Description: 主页  添加登录
	 * @author: 欧阳俊伟    
	 * @param: user
	 * @param: @return
	 * @return: ModelAndView
	 * @throws
	 */ 
	@RequestMapping("/index")
	@ResponseBody
	public Map<String, Object> index(User user,Long userType,HttpSession session, HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			Subject currentUser = SecurityUtils.getSubject();
			if(currentUser != null){
				currentUser.logout();
			}
			ExtendsUsernamePasswordToken token = new ExtendsUsernamePasswordToken(
					user.getUserCode(),user.getPassword(),userType);
			token.setRememberMe(true);
			//shiro权限验证
			currentUser.login(token);
			Map<String,Object> map = new HashMap<String,Object>();
			UserInfo userInfo =getCurrentUser();
			map.put("userId", userInfo.getUserId());
			return CommonResponseUtils.successResponse("登陆成功",map);
		}catch (IncorrectCredentialsException ice) {
			return CommonResponseUtils.failureResponse("用户名或密码错误");
		}catch (UnknownAccountException uae) {
			return CommonResponseUtils.failureResponse("用户名或密码错误");
		}catch (AuthenticationException e) {
			return CommonResponseUtils.failureResponse("用户名或密码错误");
		}
		
	}
	
	@RequestMapping("/indexLogin")
	public Object indexLogin(User user,HttpSession session, HttpServletRequest request) {
		ModelAndView modelView = new ModelAndView();
		String message = null;
		Subject currentUser = SecurityUtils.getSubject();
		//判断用户是否已登录
		if(currentUser.isAuthenticated()){
			UserInfo userInfo =getCurrentUser();
			modelView.addObject("userName", userInfo.getUserName());
			modelView.setViewName("/index");
		}else{
			try {
				UsernamePasswordToken token = new UsernamePasswordToken(
						user.getUserCode(),user.getPassword());
				token.setRememberMe(true);
				//shiro权限验证
				currentUser.login(token);
				UserInfo userInfo =getCurrentUser();
				modelView.addObject("userName", userInfo.getUserName());
				modelView.setViewName("/index");
			}catch (IncorrectCredentialsException ice) {
				message ="密码错误！";
				modelView.addObject("message", message);
				modelView.setViewName("/login");
				
			}catch (UnknownAccountException uae) {
				message="用户名错误！";
				modelView.addObject("message", message);
				modelView.setViewName("/login");
			}catch (AuthenticationException e) {
				modelView.setViewName("/login");
			}
		}
		return modelView;
	}
	
	/**
	 * 
	 * @Description:用户登出
	 * @author: 王超
	 * @param: 
	 * @return: void
	 * @throws
	 */
	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView modelView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();
		try {
			currentUser.logout();
			redisTemplate.delete(request.getSession().getId());
		} catch (AuthenticationException e) {
			e.printStackTrace();

		}
		 modelView.setViewName("/login");
		 return modelView;
	}
	/**
	 * @Description: 首页
	 * @author: 欧阳俊伟
	 * @param: @return
	 * @return: ModelAndView
	 * @throws
	 */ 
	@RequestMapping("home")
	public ModelAndView home() {
		return new ModelAndView("home");
		
	}
	
	/**
	 * @Description: datatables服务器端分页示范
	 * @author: 欧阳俊伟
	 * @param: @param request
	 * @param: @return
	 * @return: ModelAndView
	 * @throws
	 */ 
	@RequestMapping("ajaxTable")
	public ModelAndView ajaxTable(HttpServletRequest request) {
		return new ModelAndView("ajax-table");
	}
	
	/**
	 * @Description: ajax分页查询示范
	 * @author: 欧阳俊伟
	 * @param: @param request
	 * @param: @return
	 * @return: String    
	 * @throws
	 */ 
	@RequestMapping("queryAjaxTable")
	@ResponseBody
	public String queryAjaxTable(HttpServletRequest request, DataTable<User> dt, User queryUser) {
		System.out.println("当前第 " + dt.getDraw() + " 次请求数据");
		System.out.println("当前页的第一条纪录的索引号为： " + dt.getStart());
		List<User> data = new ArrayList<User>();
		for (int i=0; i < ((dt.getLength()>0) ? dt.getLength() : 50) ; i++) { //自动造数据
			User user = new User();
			user.setUserName("测试" + i);
			user.setUserCode("ceshi" + i);
			user.setSex("男");
			data.add(user);
		}
		dt.setData(data);
		//dt.setRecordsTotal(100);
		dt.setRecordsFiltered(50);//总条数
		//dt.setStart(2);
		return JSONObject.fromObject(dt).toString();
	}
	
	/**
	 * @Description: form提交
	 * @author: 欧阳俊伟
	 * @param: @param request
	 * @param: @return
	 * @return: String
	 * @throws
	 */ 
	@RequestMapping("userEdit")
	@ResponseBody
	public String updateUser(HttpServletRequest request, User user) {
		return "测试";
	}
	
	/**
	 * @description:    取出Shiro中的当前用户LoginName.                                                                                                               
	 * @author：			wangchao                                      
	 * @createDate：		2015-3-12 
	 * @return
	 */
	private UserInfo getCurrentUser() {
		return (UserInfo) SecurityUtils.getSubject().getPrincipal();
	}
	
	
	/**  
	 * @Description:员工接收模板消息. 
	 * @param @return.
	 * @author xush  
	 */
	@RequestMapping("receiverSetting")
	public ModelAndView receiverSetting() {
		return new ModelAndView("common/receiverSetting");
		
	}
	
	@RequestMapping("loginUser")
	@ResponseBody
	public void loginUser(HttpServletRequest request){
//		User user = (User)request.getSession().getAttribute("current_user");
//		System.out.println(user.getUserCode());
//		System.out.println(user.getUserName());
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+request.getSession().getId());
		UserInfo userInfo = getCurrentUser();
		System.out.println(userInfo.getUserName());
	}
	
}
