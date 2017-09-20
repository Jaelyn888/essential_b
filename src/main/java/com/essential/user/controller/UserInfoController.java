package com.essential.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.common.constants.SUConstants;
import com.essential.common.utils.EncryptPassWord;
import com.essential.common.utils.StringCommonUtils;
import com.essential.user.model.auto.UserBaseInfoAuto;
import com.essential.user.model.vo.RegisterVo;
import com.essential.user.model.vo.UserInfoRequestVo;
import com.essential.user.service.IUserInfoService;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.LogUtils;

/**
 * @author Jaelyn 用户信息接口
 */
@Controller
@RequestMapping(value = "userInfo")
public class UserInfoController {
	private String TAG = UserCollectionController.class.getSimpleName();
	@Autowired
	@Qualifier("userInfoServiceImpl")
	private IUserInfoService userInfoServiceImpl;

	/**
	 * 根据id 查找对应基本信息 不论状态
	 */
	@RequestMapping(value = "queryVoById")
	@ResponseBody
	public Map<String, Object> queryUserInfoByPrimaryKey(UserBaseInfoAuto userBaseInfo) {
		try {
			return userInfoServiceImpl.queryById(userBaseInfo.getUserId());

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("用户不存在");
		}
	}

	/**
	 * 登录 不论状态
	 */
	@RequestMapping(value = "checkLogin")
	@ResponseBody
	public Map<String, Object> checkLogin(UserInfoRequestVo userBaseInfo) {
		try {
			if (userBaseInfo == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			String userPwd = userBaseInfo.getUserPwd();
			if (StringCommonUtils.isEmpty(userPwd)) {
				return CommonResponseUtils.failureResponse("密码不能为空");
			}
			userPwd = EncryptPassWord.EncryptStr(userPwd);
			userBaseInfo.setUserPwd(userPwd);
			return userInfoServiceImpl.checkLogin(userBaseInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("用户名或密码不正确");
		}
	}

	/**
	 * 第三方登录
	 */
	@RequestMapping(value = "thirdPartyLogin")
	@ResponseBody
	public Map<String, Object> thirdPartyLogin(@RequestBody UserInfoRequestVo userBaseInfo) {
		try {
			if (userBaseInfo == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}

			Integer platform=userBaseInfo.getPlatform();
			String userName = userBaseInfo.getTag();
			// String userNameTmp=userName;
			if (platform == null || StringCommonUtils.isEmpty(userName)) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			if (platform == SUConstants.PLATFORM_QQ||platform == SUConstants.PLATFORM_WECHAT||platform == SUConstants.PLATFORM_WEIBO) {
				
			} else {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}

			return userInfoServiceImpl.thirdPartyLogin(userBaseInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("登录失败");
		}
	}

	/**
	 * 通过用户id 修改昵称等基本信息
	 */
	@RequestMapping(value = "modUserBaseInfo")
	@ResponseBody
	public Map<String, Object> modUserBaseInfo(UserInfoRequestVo userBaseInfo) {
		try {
			if (userBaseInfo == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			Long userId = userBaseInfo.getUserId();
			if (userId == null || userId == 0) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			return userInfoServiceImpl.updateUserBaseInfo(userBaseInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("用户名或密码不正确");
		}
	}

	/**
	 * 通过 用户账户 修改密码等基本信息
	 * 
	 * @param userBaseInfo
	 * @return
	 */
	@RequestMapping(value = "updateInfoByUserName")
	@ResponseBody
	public Map<String, Object> updateInfoByUserName(@RequestBody UserInfoRequestVo userBaseInfo) {
		try {
			if (userBaseInfo == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			String userName = userBaseInfo.getUserName();
			if (StringCommonUtils.isPhone(userName)) {
				return userInfoServiceImpl.updateInfoByUserName(userBaseInfo);
			} else {
				return CommonResponseUtils.failureResponse("用户名非法");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("用户名或密码不正确");
		}
	}

	@RequestMapping(value = "appRegister")
	@ResponseBody
	public Map<String, Object> appRegister(@RequestBody RegisterVo userBaseInfoAuto) {
		try {
			if (userBaseInfoAuto == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			String userName = userBaseInfoAuto.getUserName();
			String userPwd = userBaseInfoAuto.getUserPwd();
			String userNickname = userBaseInfoAuto.getUserNickname();
			String smsCode = userBaseInfoAuto.getSmsCode();
			if (!StringCommonUtils.isPhone(userName) || StringCommonUtils.isEmpty(userNickname) || StringCommonUtils.isEmpty(userPwd) || StringCommonUtils.isEmpty(smsCode)) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			} else {
				userPwd = EncryptPassWord.EncryptStr(userPwd);
				userBaseInfoAuto.setUserPwd(userPwd);
				return userInfoServiceImpl.appRegister(userBaseInfoAuto);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.debug(TAG, e.toString());
			return CommonResponseUtils.failureResponse("注册异常");
		}
	}

	/**
	 * 环信与用户绑定
	 * 
	 * @param userBaseInfoAuto
	 * @return
	 */
	@RequestMapping(value = "ringSignalAndUser")
	@ResponseBody
	public Map<String, Object> ringSignalAndUser(UserBaseInfoAuto userBaseInfoAuto) {
		try {
			return userInfoServiceImpl.ringSignalAndUser(userBaseInfoAuto);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.debug(TAG, e.toString());
			return CommonResponseUtils.failureResponse("环信与用户绑定失败");
		}
	}
	
	@RequestMapping(value = "queryUserList")
	@ResponseBody
	public Map<String, Object> queryUserList(UserInfoRequestVo userManageRequest) {
		try {
			return userInfoServiceImpl.queryUserList(userManageRequest);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.debug(TAG, e.toString());
			return CommonResponseUtils.failureResponse("查询失败");
		}
	}

}
