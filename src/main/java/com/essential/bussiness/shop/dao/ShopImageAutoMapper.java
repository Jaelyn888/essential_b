package com.essential.bussiness.shop.dao;

import com.essential.bussiness.shop.model.auto.ShopImageAuto;

public interface ShopImageAutoMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(ShopImageAuto record);

	int insertSelective(ShopImageAuto record);

	ShopImageAuto selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ShopImageAuto record);

	int updateByPrimaryKey(ShopImageAuto record);

	// 逻辑删除
	int updateIsDelete(ShopImageAuto record);
}