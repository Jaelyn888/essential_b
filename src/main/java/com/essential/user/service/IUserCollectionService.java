package com.essential.user.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.user.model.auto.UserCollectionAuto;

@Service
public interface IUserCollectionService {

	/**
	 * 根据id 查找对应基本信息
	 */
	public UserCollectionAuto selectByPrimaryKey(Long collectionId);

	/**
	 * 根据用户id，类别 和 类别id 等查找收藏的信息 可以根据返回的个数 判断是否收藏
	 * 
	 * @param <T>
	 * 
	 * @return
	 */
	public Map<String, Object> queryByParamSelective(UserCollectionAuto userCollectionAuto);

	/**
	 * 保存
	 * 
	 * @param requestMap
	 * @return
	 */
	public Map<String, Object> saveCollection(UserCollectionAuto userCollectionAuto);

	/**
	 * 是否已收藏
	 * 
	 * @param requestMap
	 * @return 1：收藏 0：未收藏
	 */
	public int queryIsCollection(UserCollectionAuto userCollectionAuto);

	/**
	 * 取消收藏、收藏
	 * 
	 * @param requestMap
	 * @return
	 */
	public Map<String, Object> savaOrCancelCollection(UserCollectionAuto userCollectionAuto);
	
	/**
	 * 用户统计
	 * @return
	 */
	public Map<String, Object> userCount();

}