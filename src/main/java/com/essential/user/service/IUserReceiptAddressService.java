package com.essential.user.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.user.model.auto.UserReceiptAddressAuto;
import com.essential.user.model.vo.UserReceiptAddressVo;
@Service
public interface IUserReceiptAddressService {

	/**
	 * query all UserReceiptAddressAuto
	 * 
	 * @param userReceiptAddressAuto
	 *            获取所有收货信息
	 * @return
	 */
	public abstract Map<String, Object> queryAllAddressByUserId(UserReceiptAddressAuto userReceiptAddressAuto);
	
	/**
	 * 保存/更新 用户收货地址
	 * 
	 * @param userReceiptAddressAuto
	 * @return
	 */
	public abstract Map<String, Object> saveOrUpdateAddress(UserReceiptAddressAuto userReceiptAddressAuto);


	/**
	 * 保存 用户收货地址
	 * 
	 * @param userReceiptAddressAuto
	 * @return
	 */
	public abstract Map<String, Object> saveAddress(UserReceiptAddressAuto userReceiptAddressAuto);

	/**
	 * update userReceiptAddressAuto
	 * 
	 * @param userReceiptAddressAuto
	 *            更新后收货地址
	 * @return
	 */
	public abstract Map<String, Object> updateAddress(UserReceiptAddressAuto userReceiptAddressAuto);

	/**
	 * delete userReceiptAddressAuto
	 * 
	 * @param userReceiptAddressAuto
	 *            删除收货地址
	 * @return
	 */
	public abstract Map<String, Object> deleteAddress(UserReceiptAddressAuto userReceiptAddressAuto);

	/**
	 * select by userReceiptAddressAuto id
	 * 
	 * @param addressId
	 * @return
	 */
	public abstract Map<String, Object> queryAddressById(long addressId);

	/**
	 * 默认收货地址 或者推荐地址 确认订单页接口
	 * 
	 * @param userId
	 * @return vo 返回null或者地址vo
	 */
	public abstract UserReceiptAddressVo queryDefaultOrRecommendAddress(Long userId);

	/**
	 * 设置默认收货地址 0：不是默认，1：默认
	 * 
	 * @param userReceiptAddressAuto
	 * @return
	 */
	public abstract Map<String, Object> setDefaultAddress(UserReceiptAddressAuto userReceiptAddressAuto);

	/**
	 * 取消默认地址
	 * 
	 * @param userId
	 */
	public abstract void cancelDefaultAddress(Long userId);

}