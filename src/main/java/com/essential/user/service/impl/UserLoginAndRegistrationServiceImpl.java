package com.essential.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.common.constants.SUConstants;
import com.essential.common.utils.EncryptPassWord;
import com.essential.common.utils.TmDateUtil;
/*import com.essential.emChat.api.IMUserAPI;
import com.essential.emChat.comm.ClientContext;
import com.essential.emChat.comm.EasemobRestAPIFactory;
import com.essential.emChat.comm.body.IMUserBody;
import com.essential.emChat.comm.wrapper.BodyWrapper;*/
import com.essential.user.dao.UserBaseInfoAutoMapper;
import com.essential.user.model.auto.UserBaseInfoAuto;
import com.essential.user.model.vo.UserLoginAndRegistrationVo;
import com.essential.user.service.IUserLoginAndRegistrationService;
import com.essential.utils.CommonResponseUtils;

/**
 * 
 * @author czm
 *
 */
@Service
public class UserLoginAndRegistrationServiceImpl implements IUserLoginAndRegistrationService {
	private static Logger logger = LoggerFactory.getLogger(UserLoginAndRegistrationServiceImpl.class);

	@Autowired
	UserBaseInfoAutoMapper userBaseInfoAutoMapper;

	EncryptPassWord encryptPassWord;

	/**
	 * 注册用户
	 */
	@Override
	public Map<String, Object> userRegistration(UserLoginAndRegistrationVo userLoginAndRegistrationVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			UserBaseInfoAuto userBaseInfoAuto = new UserBaseInfoAuto();

			// 用户名
			userBaseInfoAuto.setUserName(userLoginAndRegistrationVo.getUserName());
			// 用户类别
			userBaseInfoAuto.setUserTypeId(userLoginAndRegistrationVo.getUserTypeId());
			userBaseInfoAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			// 查询用户名是否已存在
			userBaseInfoAuto = userBaseInfoAutoMapper.selectByPrimary(userBaseInfoAuto);
			if (userBaseInfoAuto != null) {
				map.putAll(CommonResponseUtils.failureResponse("用户名已存在!"));
			} else {
				UserBaseInfoAuto userBaseInfo = new UserBaseInfoAuto();
				// 用户名
				userBaseInfo.setUserName(userLoginAndRegistrationVo.getUserName());
				// 用户类别
				userBaseInfo.setUserTypeId(userLoginAndRegistrationVo.getUserTypeId());
				// 用户级别
				// userBaseInfoAuto.setUserLevelId(userLoginAndRegistrationVo.getUserLevelId());
				// 用户密码(加密后密码)
				userBaseInfo.setUserPwd(userLoginAndRegistrationVo.getUserPwd());
				// 创建时间戳
				userBaseInfo.setCreateTime(TmDateUtil.getTimeStamp());
				// 是否删除
				userBaseInfo.setIsDelete(SUConstants.IS_NOT_DELETE);
				int i = userBaseInfoAutoMapper.insertSelective(userBaseInfo);
				if (i > 0) {
					map.putAll(CommonResponseUtils.successResponse("注册成功!"));
				} else {
					map.putAll(CommonResponseUtils.failureResponse("注册失败!"));
				}
			}
		} catch (Exception e) {
			logger.info("==========>>>>>>>>>>>注册失败 :" + e);
			e.printStackTrace();
			throw new RuntimeException(e);

		}

		return map;
	}

	/**
	 * 登录用户
	 */
	@Override
	public Map<String, Object> userLogin(UserLoginAndRegistrationVo userLoginAndRegistrationVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			UserBaseInfoAuto userBaseInfoAuto = new UserBaseInfoAuto();
			// 用户名
			userBaseInfoAuto.setUserName(userLoginAndRegistrationVo.getUserName());
			// 用户类别
			userBaseInfoAuto.setUserTypeId(userLoginAndRegistrationVo.getUserTypeId());
			// 用户密码(加密后密码)
			userBaseInfoAuto.setUserPwd(userLoginAndRegistrationVo.getUserPwd());
			// 是否删除
			userBaseInfoAuto.setIsDelete(SUConstants.IS_NOT_DELETE);

			userBaseInfoAuto = userBaseInfoAutoMapper.selectByPrimary(userBaseInfoAuto);
			if (userBaseInfoAuto == null) {
				map.putAll(CommonResponseUtils.failureResponse("用户名或密码错误!"));
			} else {
				map.putAll(CommonResponseUtils.successResponse("登录成功!"));
			}
			return map;
		} catch (Exception e) {
			logger.info("==========>>>>>>>>>>>登录失败 :" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * 注册时用户是否已经存在查询
	 */
	@Override
	public Map<String, Object> chackUser(String userName, Long userTypeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			UserBaseInfoAuto userBaseInfo = new UserBaseInfoAuto();
			userBaseInfo.setUserName(userName);
			userBaseInfo.setUserTypeId(userTypeId);
			UserBaseInfoAuto userBaseInfoAuto = userBaseInfoAutoMapper.selectByPrimary(userBaseInfo);
			if (userBaseInfoAuto != null) {
				map.putAll(CommonResponseUtils.successResponse("用户名已存在!"));
			} else {
				map.putAll(CommonResponseUtils.failureResponse("用户名不存在!"));
			}
			return map;
		} catch (Exception e) {
			logger.info("====>>>>注册时用户是否已经存在查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * 修改密码
	 */
	@Override
	public Map<String, Object> updatePassword(UserLoginAndRegistrationVo userLoginAndRegistrationVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			UserBaseInfoAuto userBaseInfoAuto = new UserBaseInfoAuto();
			// 用户名
			userBaseInfoAuto.setUserName(userLoginAndRegistrationVo.getUserName());
			// 用户类别
			userBaseInfoAuto.setUserTypeId(userLoginAndRegistrationVo.getUserTypeId());
			//旧密码
			userBaseInfoAuto.setUserPwd(userLoginAndRegistrationVo.getUserOldPwd());
			UserBaseInfoAuto userBaseInfo= userBaseInfoAutoMapper.selectByPrimary(userBaseInfoAuto);
			if(userBaseInfo == null){
				return CommonResponseUtils.failureResponse("输入的旧密码错误");
			}
			
			// 用户新密码(加密后密码)
			userBaseInfoAuto.setUserPwd(userLoginAndRegistrationVo.getUserPwd());
			// 修改时间戳
			userBaseInfoAuto.setModifyTime(TmDateUtil.getTimeStamp());
			// 修改用户
			userBaseInfoAuto.setModifyUserId(userLoginAndRegistrationVo.getUserId());
			
			int i = userBaseInfoAutoMapper.updateByPrimaryPassword(userBaseInfoAuto);
			if (i <= 0) {
				throw new Exception("密码修改失败!");
			} else {
				map.putAll(CommonResponseUtils.successResponse("密码修改成功!"));
			}
			return map;
		} catch (Exception e) {
			logger.info("==========>>>>>>>>>>>密码修改失败 :" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 解绑手机号
	 */
	@Override
	public Map<String, Object> unbundlePhone(UserBaseInfoAuto userBaseInfoAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			userBaseInfoAuto.setModifyTime(TmDateUtil.getTimeStamp());
			userBaseInfoAuto.setModifyUserId(userBaseInfoAuto.getUserId());
			int i = userBaseInfoAutoMapper.updateByPrimaryKeySelective(userBaseInfoAuto);
			if (i <= 0) {
				throw new Exception("解绑手机号失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("手机号解绑成功!"));
			return map;
		} catch (Exception e) {
			logger.info("==========>>>>>>>>>>>解绑手机号失败 :" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据用户Id查询手机号
	 */
	@Override
	public Map<String, Object> queryPhoneNumber(Long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> outputMap = new HashMap<String, Object>();
		try {
			UserBaseInfoAuto userBaseInfoAuto  = new UserBaseInfoAuto();
			userBaseInfoAuto.setUserId(userId);
			userBaseInfoAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			UserBaseInfoAuto userBaseInfo= userBaseInfoAutoMapper.queryUserInfo(userBaseInfoAuto);
			if(userBaseInfo != null){
				outputMap.put("userName", userBaseInfo.getUserName());
			}
			map.putAll(CommonResponseUtils.successResponse(outputMap));
			return map;
		} catch (Exception e) {
			logger.info("==========>>>>>>>>>>>手机号查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 环信注册
	 */
	@Override
	public Map<String, Object> emChatSave(String username, String password,String nikename) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			/*EasemobRestAPIFactory factory = ClientContext.getInstance().init(ClientContext.INIT_FROM_PROPERTIES).getAPIFactory();
			IMUserAPI user = (IMUserAPI)factory.newInstance(EasemobRestAPIFactory.USER_CLASS);
			
			//注册用户
			BodyWrapper userBody = new IMUserBody(username, password, nikename);
			map.putAll(CommonResponseUtils.successResponse(user.createNewIMUserSingle(userBody)));*/

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 找回密码
	 */
	@Override
	public Map<String, Object> retrievePassword(UserLoginAndRegistrationVo userLoginAndRegistrationVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			UserBaseInfoAuto userBaseInfoAuto = new UserBaseInfoAuto();
			// 用户名
			userBaseInfoAuto.setUserName(userLoginAndRegistrationVo.getUserName());
			// 用户类别
			userBaseInfoAuto.setUserTypeId(userLoginAndRegistrationVo.getUserTypeId());
			// 用户新密码(加密后密码)
			userBaseInfoAuto.setUserPwd(userLoginAndRegistrationVo.getUserPwd());
			// 修改时间戳
			userBaseInfoAuto.setModifyTime(TmDateUtil.getTimeStamp());
			// 修改用户
			userBaseInfoAuto.setModifyUserId(userLoginAndRegistrationVo.getUserId());
			
			int i = userBaseInfoAutoMapper.updateByPrimaryPassword(userBaseInfoAuto);
			if (i <= 0) {
				throw new Exception("找回密码失败!");
			} else {
				map.putAll(CommonResponseUtils.successResponse("密码修改成功!"));
			}
			return map;
		} catch (Exception e) {
			logger.info("==========>>>>>>>>>>>找回密码失败 :" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
