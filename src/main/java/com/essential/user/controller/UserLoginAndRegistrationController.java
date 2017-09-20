package com.essential.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.common.utils.EncryptPassWord;
import com.essential.common.utils.StringCommonUtils;
import com.essential.user.model.auto.UserBaseInfoAuto;
import com.essential.user.model.vo.UserLoginAndRegistrationVo;
import com.essential.user.service.IUserLoginAndRegistrationService;
import com.essential.utils.CommonResponseUtils;

/**
 * 用户登录/注册
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "userLoginAndRegistration")
public class UserLoginAndRegistrationController {
	private static Logger logger = LoggerFactory.getLogger(UserLoginAndRegistrationController.class);

	@Autowired
	IUserLoginAndRegistrationService userRegistrationService;

	/**
	 * 注册用户
	 * 
	 * @param userLoginAndRegistrationVo
	 * @return
	 */
	@RequestMapping(value = "userRegistration")
	@ResponseBody
	public Map<String, Object> userRegistration(UserLoginAndRegistrationVo userLoginAndRegistrationVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String userPwd = userLoginAndRegistrationVo.getUserPwd();
			if (StringCommonUtils.isEmpty(userPwd)) {
				return CommonResponseUtils.failureResponse("密码不能为空");
			}
			userPwd = EncryptPassWord.EncryptStr(userPwd);
			userLoginAndRegistrationVo.setUserPwd(userPwd);
			return userRegistrationService.userRegistration(userLoginAndRegistrationVo);
		} catch (Exception e) {
			logger.info("======>>>>>>注册用户失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("注册用户失败!"));
		}
		return map;
	}

	/**
	 * 用户登录
	 * 
	 * @param userLoginAndRegistrationVo
	 * @return
	 */
	@RequestMapping(value = "userLogin")
	@ResponseBody
	public Map<String, Object> userLogin(UserLoginAndRegistrationVo userLoginAndRegistrationVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String userPwd = userLoginAndRegistrationVo.getUserPwd();
			if (StringCommonUtils.isEmpty(userPwd)) {
				return CommonResponseUtils.failureResponse("密码不能为空");
			}
			userPwd = EncryptPassWord.EncryptStr(userPwd);
			userLoginAndRegistrationVo.setUserPwd(userPwd);

			return userRegistrationService.userLogin(userLoginAndRegistrationVo);
		} catch (Exception e) {
			logger.info("======>>>>>>用户登录失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("用户登录失败!"));
		}
		return map;
	}

	/**
	 * 注册时用户是否已经存在查询
	 * 
	 * @param userNumber
	 * @return
	 */
	@RequestMapping(value = "chackUser")
	@ResponseBody
	public Map<String, Object> chackUser(String userNumber, Long userTypeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (StringUtils.isEmpty(userNumber)) {
				return CommonResponseUtils.failureResponse("用户名为空");
			}
			if (userTypeId == null) {
				return CommonResponseUtils.failureResponse("用户类型为空");
			}
			return userRegistrationService.chackUser(userNumber, userTypeId);
		} catch (Exception e) {
			logger.info("======>>>>>>注册时用户是否已经存在查询失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("用户是否已经存在查询失败!"));
		}
		return map;
	}

	/**
	 * 修改密码
	 * 
	 * @param userNumber
	 * @return
	 */
	@RequestMapping(value = "updatePassword")
	@ResponseBody
	public Map<String, Object> updatePassword(UserLoginAndRegistrationVo userLoginAndRegistrationVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String userPwd = userLoginAndRegistrationVo.getUserPwd();
			String userOldPwd = userLoginAndRegistrationVo.getUserOldPwd();
			if (StringCommonUtils.isEmpty(userPwd)) {
				return CommonResponseUtils.failureResponse("输入的新密码不能为空");
			}
			if (StringCommonUtils.isEmpty(userOldPwd)) {
				return CommonResponseUtils.failureResponse("输入的旧密码不能为空");
			}
			userPwd = EncryptPassWord.EncryptStr(userPwd);
			userOldPwd = EncryptPassWord.EncryptStr(userOldPwd);
			userLoginAndRegistrationVo.setUserPwd(userPwd);
			userLoginAndRegistrationVo.setUserOldPwd(userOldPwd);

			return userRegistrationService.updatePassword(userLoginAndRegistrationVo);
		} catch (Exception e) {
			logger.info("======>>>>>>密码修改失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("密码修改失败!"));
		}
		return map;
	}

	/**
	 * 解绑手机号
	 * 
	 * @param userBaseInfoAuto
	 * @return
	 */
	@RequestMapping(value = "unbundlePhone")
	@ResponseBody
	public Map<String, Object> unbundlePhone(UserBaseInfoAuto userBaseInfoAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String userName = userBaseInfoAuto.getUserName();
			if (StringCommonUtils.isEmpty(userName)) {
				return CommonResponseUtils.failureResponse("手机号不能为空");
			}

			return userRegistrationService.unbundlePhone(userBaseInfoAuto);
		} catch (Exception e) {
			logger.info("======>>>>>>手机号解绑失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("手机号解绑失败!"));
		}
		return map;
	}

	/**
	 * 根据用户Id查询手机号
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "queryPhoneNumber")
	@ResponseBody
	public Map<String, Object> queryPhoneNumber(Long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (userId == null) {
				return CommonResponseUtils.failureResponse("用户Id不能为空");
			}
			return userRegistrationService.queryPhoneNumber(userId);
		} catch (Exception e) {
			logger.info("======>>>>>>手机号查询失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("手机号查询失败!"));
		}
		return map;
	}

	/**
	 * 环信注册
	 * 
	 * @param userId
	 * @param passWord
	 * @return
	 */
	@RequestMapping(value = "emChatSave")
	@ResponseBody
	public Map<String, Object> emChatSave(String username, String passWord, String nikename) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (username == null) {
				return CommonResponseUtils.failureResponse("用户名不能为空");
			}
			if (passWord == null) {
				return CommonResponseUtils.failureResponse("密码不能为空");
			}
			return userRegistrationService.emChatSave(username, passWord, nikename);
		} catch (Exception e) {
			logger.info("======>>>>>>环信注册失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("环信注册失败!"));
		}
		return map;
	}

	/**
	 * 找回密码
	 * 
	 * @param userLoginAndRegistrationVo
	 * @return
	 */
	@RequestMapping(value = "retrievePassword")
	@ResponseBody
	public Map<String, Object> retrievePassword(UserLoginAndRegistrationVo userLoginAndRegistrationVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String userPwd = userLoginAndRegistrationVo.getUserPwd();
			if (StringCommonUtils.isEmpty(userPwd)) {
				return CommonResponseUtils.failureResponse("输入的密码不能为空");
			}
			userPwd = EncryptPassWord.EncryptStr(userPwd);
			userLoginAndRegistrationVo.setUserPwd(userPwd);
			return userRegistrationService.retrievePassword(userLoginAndRegistrationVo);
		} catch (Exception e) {
			logger.info("======>>>>>>密码找回失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("密码找回失败!"));
		}
		return map;
	}
}
