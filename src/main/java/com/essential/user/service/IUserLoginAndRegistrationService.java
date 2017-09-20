package com.essential.user.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.user.model.auto.UserBaseInfoAuto;
import com.essential.user.model.vo.UserLoginAndRegistrationVo;

/**
 * 
 * @author czm
 *
 */
@Service
public interface IUserLoginAndRegistrationService {

	/*** 注册用户 **/
	public Map<String, Object> userRegistration(UserLoginAndRegistrationVo userRegistrationVo);

	/*** 用户登录 **/
	public Map<String, Object> userLogin(UserLoginAndRegistrationVo userLoginAndRegistrationVo);

	/*** 注册时用户是否已经存在查询 ****/
	public Map<String, Object> chackUser(String userNumber, Long userTypeId);

	/*** 修改密码 ****/
	public Map<String, Object> updatePassword(UserLoginAndRegistrationVo userLoginAndRegistrationVo);

	/*** 找回密码 ****/
	public Map<String, Object> retrievePassword(UserLoginAndRegistrationVo userLoginAndRegistrationVo);

	/*** 解绑手机号 ****/
	public Map<String, Object> unbundlePhone(UserBaseInfoAuto userBaseInfoAuto);

	/*** 根据用户Id查询手机号 ****/
	public Map<String, Object> queryPhoneNumber(Long userId);

	/*** 环信注册 ****/
	public Map<String, Object> emChatSave(String username, String passWord, String nikename);

}
