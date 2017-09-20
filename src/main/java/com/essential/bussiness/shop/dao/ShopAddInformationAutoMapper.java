package com.essential.bussiness.shop.dao;

import com.essential.bussiness.shop.model.auto.ShopAddInformationAuto;

public interface ShopAddInformationAutoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopAddInformationAuto record);

    int insertSelective(ShopAddInformationAuto record);

    ShopAddInformationAuto selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopAddInformationAuto record);

    int updateByPrimaryKey(ShopAddInformationAuto record);
    
    int update(ShopAddInformationAuto record);
}