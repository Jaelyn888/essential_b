package com.essential.bussiness.brand.dao;

import java.util.List;
import java.util.Map;

import com.essential.bussiness.brand.model.auto.ShopandbrandAuto;

public interface ShopandbrandAutoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopandbrandAuto record);

    int insertSelective(ShopandbrandAuto record);

    ShopandbrandAuto selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopandbrandAuto record);

    int updateByPrimaryKey(ShopandbrandAuto record);
    //根据shopId去查询品牌列表
    List<Map<String,Object>> selectByShopId (Map<String,Object> map);
    
    //得到总条数
    Long selectByShopIdPageCount(Map<String,Object> map); 
    //通过shopId和categoryId得到品牌的list
   List<Map<String,Object>> selectByShopIdCategoryId(Map<String,Object> map);
   //品牌审核
   int updateChecked(ShopandbrandAuto record);
    
}