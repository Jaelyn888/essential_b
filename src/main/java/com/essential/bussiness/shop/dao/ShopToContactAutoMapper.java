package com.essential.bussiness.shop.dao;

import com.essential.bussiness.shop.model.auto.ShopToContactAuto;

public interface ShopToContactAutoMapper {
    int deleteByPrimaryKey(Long contactId);

    int insert(ShopToContactAuto record);

    int insertSelective(ShopToContactAuto record);

    ShopToContactAuto selectByPrimaryKey(Long contactId);

    int updateByPrimaryKeySelective(ShopToContactAuto record);

    int updateByPrimaryKey(ShopToContactAuto record);
    
    ShopToContactAuto queryInfoByShopId(Long shopId);
}