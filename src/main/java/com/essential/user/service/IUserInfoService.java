package com.essential.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.user.model.auto.UserBaseInfoAuto;
import com.essential.user.model.vo.RegisterVo;
import com.essential.user.model.vo.UserBaseInfoVo;
import com.essential.user.model.vo.UserInfoRequestVo;
import com.essential.user.model.vo.UserInfoVo;

@Service
public interface IUserInfoService {

	/**
	 * 根据id 查找对应基本信息
	 */
	public Map<String, Object> queryById(Long userId);

	/**
	 * 基于用户名和密码等查找用户，
	 * 
	 * @param data
	 * @return
	 */
	public Map<String, Object> checkLogin(UserInfoRequestVo userBaseInfo);

	/**
	 * 根据用户id 查询用户基本信息
	 * 
	 * @param userId
	 * @return
	 */
	public UserBaseInfoVo queryUserInfoVoByUserId(Long userId);

	/**
	 * 修改用户基本信息
	 * 
	 * @param userBaseInfoAuto
	 * @return
	 */
	public Map<String, Object> updateUserBaseInfo(UserInfoRequestVo userBaseInfoAuto);

	/**
	 * 第三方登录
	 * 
	 * @param userBaseInfo
	 * @return
	 */
	public Map<String, Object> thirdPartyLogin(UserInfoRequestVo userBaseInfo);

	/**
	 * 通过用户名修改基本信息
	 * 
	 * @param userBaseInfo
	 * @return
	 */
	public Map<String, Object> updateInfoByUserName(UserInfoRequestVo userBaseInfo);

	public Map<String, Object> appRegister(RegisterVo userBaseInfoAuto);

	public List<UserInfoVo> queryUserInfoByParams(UserInfoRequestVo userBaseInfo);

	/**
	 * 环信与用户绑定
	 * 
	 * @param userBaseInfoAuto
	 * @return
	 */
	public Map<String, Object> ringSignalAndUser(UserBaseInfoAuto userBaseInfoAuto);

	public Map<String, Object> queryUserList(UserInfoRequestVo userManageRequest);

}