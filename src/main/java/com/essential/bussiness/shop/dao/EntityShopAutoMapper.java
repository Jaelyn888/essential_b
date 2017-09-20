package com.essential.bussiness.shop.dao;

import java.util.List;
import java.util.Map;

import com.essential.bussiness.shop.model.auto.EntityShopAuto;

public interface EntityShopAutoMapper {
    int deleteByPrimaryKey(Long entityshopId);

    int insert(EntityShopAuto record);

    int insertSelective(EntityShopAuto record);

    EntityShopAuto selectByPrimaryKey(Long entityshopId);

    int updateByPrimaryKeySelective(EntityShopAuto record);

    int updateByPrimaryKey(EntityShopAuto record);
    
    //店铺信息查询
    List<EntityShopAuto> queryByPrimaryKey(Map<String, Object> record);
}