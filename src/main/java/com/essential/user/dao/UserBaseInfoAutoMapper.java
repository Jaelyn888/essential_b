package com.essential.user.dao;

import java.util.List;

import com.essential.bussiness.product.model.vo.ProductOrShopCountVo;
import com.essential.user.model.auto.UserBaseInfoAuto;
import com.essential.user.model.vo.UserInfoRequestVo;
import com.essential.user.model.vo.UserBaseInfoVo;
import com.essential.user.model.vo.UserInfoVo;

public interface UserBaseInfoAutoMapper {
	int deleteByPrimaryKey(Long userId);

	int insert(UserBaseInfoAuto record);

	int insertSelective(UserBaseInfoAuto record);

	UserBaseInfoAuto selectByPrimaryKey(Long userId);

	/**
	 * 修改用户基本信息
	 * 
	 * @param userBaseInfoAuto
	 * @return
	 */
	int updateByPrimaryKeySelective(UserBaseInfoAuto record);

	int updateByPrimaryKey(UserBaseInfoAuto record);

	UserBaseInfoVo selectBaseInfoVoByPrimaryKey(Long userId);

	List<UserInfoVo> queryUserInfoByParams(UserInfoRequestVo userBaseInfo);

	/**
	 * 根据条件 查询用户基本信息列表
	 * 
	 * @param record
	 * @return
	 */
	List<UserBaseInfoVo> queryBaseInfoVoByParams(UserBaseInfoAuto record);

	// 登录/注册查询用户是否存在所用
	UserBaseInfoAuto selectByPrimary(UserBaseInfoAuto record);

	// 修改密码
	int updateByPrimaryPassword(UserBaseInfoAuto record);
	
	//用户统计
	ProductOrShopCountVo userCount();
	List<UserInfoVo> queryUserInfoByLikeParams(UserInfoRequestVo userBaseInfo);
	int queryCountByParams(UserInfoRequestVo userManageRequest);
	
	//y用户信息
	UserBaseInfoAuto queryUserInfo(UserBaseInfoAuto record);
}