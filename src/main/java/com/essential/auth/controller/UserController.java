package com.essential.auth.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.essential.auth.model.User;
import com.essential.auth.model.UserVo;
import com.essential.auth.service.UserService;
import com.essential.common.model.DataTable;
import com.essential.common.utils.JSONUtils;


/**
 * ClassName: UserController Function: 用户管理. date: 2015年2月4日 上午10:21:08
 * 
 * @author xush
 * @version V1.0
 */

@Controller
@RequestMapping("/user/")
public class UserController {

	@Resource
	private UserService UserService;

	/**
	 * accessToken
	 */
	String accessToken = "";

	/**
	 * @Description: 跳转到用户管理页面
	 * @author: xush
	 * @param: @param request
	 * @return: 用户管理页面
	 * @throws
	 */
	@RequestMapping("userManager")
	public ModelAndView userManager(HttpServletRequest request) {
		return new ModelAndView("/auth/user/userManage");
	}


	/**
	 * @Description: 查询用户列表
	 * @author: xush
	 * @param: @param request
	 * @return: String
	 * @throws IOException
	 */
	@RequestMapping("findAllUser")
	@ResponseBody
	public String findAllUser(DataTable<UserVo> dataTable,HttpServletResponse response, User user) throws IOException {
		return JSONUtils.objectToString(UserService.findAllUser(dataTable, user));
	}


	/**
	 * @Description: 校验用户
	 * @author: xush
	 * @param: @param 字段名
	 * @param: @param 字段值
	 * @param: @return
	 * @return: Boolean 无重复用户则为true 否则为false
	 * @throws
	 */
	@RequestMapping("validateUser")
	@ResponseBody
	public Boolean validateUser(String userId, String key, String value) {
		List<UserVo> userList = UserService.findUserByKey(key, value);
		List<UserVo> userListById = UserService.findUserByKey("userId", userId);
		if (userList.size() == 0) {
			return true;
		} else if (userList.size() == 1 && userListById.size() == 1
				&& userList.get(0).getUserId().equals(userId)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @Description: 查询用户
	 * @author: xush
	 * @param: @param id
	 * @param: @return
	 * @return: Map<String,Object>
	 * @throws
	 */
	@RequestMapping("showUserDetail")
	@ResponseBody
	public Map<String, Object> showUserDetail(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserVo> userList = UserService.findUserByKey("userId", id);
		if (userList.size() == 1) {
			map.put("user", userList.get(0));
		}
		return map;
	}

	/**
	 * @Description: 删除用户
	 * @author: xush
	 * @param: @param userId
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	@RequestMapping("deleteUser")
	@ResponseBody
	public String deleteUser(String userId) {
		return UserService.deleteUser(userId);
	}

	/**
	 * 
	 * @Description: 用户登录
	 * @author: panjc
	 * @param: @param user
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	@RequestMapping("findLoginUser")
	@ResponseBody
	public String findLoginUser(HttpServletRequest request, User user) {
		List<UserVo> list = UserService.findLoginUser(user);
		if (list.size() == 1) {
			request.getSession().setAttribute("loginUser", user);
		}
		return JSONUtils.arrayToString(list);
	}

	@RequestMapping("openShop")
	public ModelAndView openShop(HttpServletRequest request,String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userCode", code);
		return new ModelAndView("/auth/user/openShop", map);
	}

	/**  
	 * @Description:同名检查. 
	 * @param @param userName
	 * @param @return.
	 * @author xush  
	 */
	@RequestMapping("checkSamePerson")
	@ResponseBody
	public Map<String,Object> checkSamePerson(String employeeNo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserVo> userList = UserService.findUserByKey("employeeNo", employeeNo);
		map.put("userList", userList);
		return map;
	}
	
}
