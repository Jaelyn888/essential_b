package com.essential.bussiness.returns.dao;

import java.util.List;
import java.util.Map;

import com.essential.bussiness.returns.model.auto.ReturnAddressAuto;

public interface ReturnAddressAutoMapper {
	int deleteByPrimaryKey(Long returnaddressId);

	int insert(ReturnAddressAuto record);

	// 新增退货地址信息
	int insertSelective(ReturnAddressAuto record);

	ReturnAddressAuto selectByPrimaryKey(Long returnaddressId);

	int updateByPrimaryKeySelective(ReturnAddressAuto record);

	int updateByPrimaryKey(ReturnAddressAuto record);

	// 查询退货地址信息
	List<ReturnAddressAuto> queryReturnRightsAddress(Map<String, Object> record);

	// 更新Status状态
	int updateStatusByPrimaryKeySelective(ReturnAddressAuto record);

	// 查询默认地址
	ReturnAddressAuto queryDefaultAddress(ReturnAddressAuto returnAddressAuto);

	// 查询最新的收货地址
	ReturnAddressAuto queryNewestAddress(ReturnAddressAuto returnAddressAuto);

	// 删除默认地址时先自动设置默认地址
	int updateStatusWhendeleteByShopId(Long shopId);
	
}