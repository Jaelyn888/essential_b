package com.essential.bussiness.shop.dao;

import java.util.List;

import com.essential.bussiness.shop.model.auto.ShopBankCardAuto;

public interface ShopBankCardAutoMapper {
	int deleteByPrimaryKey(Long id);

	int insert(ShopBankCardAuto record);

	int insertSelective(ShopBankCardAuto record);

	ShopBankCardAuto selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(ShopBankCardAuto record);

	int updateByPrimaryKey(ShopBankCardAuto record);

	// 查询结算/资质信息
	List<ShopBankCardAuto> queryByPrimaryKey(ShopBankCardAuto record);
	
	// 逻辑删除结算/资质信息
	int updateIsDeleteKey(ShopBankCardAuto record);
}