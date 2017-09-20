package com.essential.bussiness.returns.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.returns.model.auto.ReturnAddressAuto;

/**
 * 退货维权 （商家后台）interface
 * 
 * @author czm
 *
 */
@Service
public interface IReturnRightsAddressService {

	// 增加
	public Map<String, Object> addReturnRightsAddress(ReturnAddressAuto returnAddressAuto);

	// 查询
	public Map<String, Object> queryReturnRightsAddress(ReturnAddressAuto returnAddressAuto);

	// 更新
	public Map<String, Object> updateReturnRightsAddress(ReturnAddressAuto returnAddressAuto);

	// 删除
	public Map<String, Object> deleteReturnRightsAddress(Long returnaddressIds);
	
	//默认地址设置
	public Map<String, Object> defaultAddress(long returnaddressId,long shopId);

	public Map<String, Object> queryDefaultAddress(ReturnAddressAuto returnAddressAuto);
}
