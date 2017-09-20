package com.essential.bussiness.freighttemplate.dao;

import java.util.List;
import java.util.Map;

import com.essential.bussiness.freighttemplate.model.auto.FreightGroupNameAuto;

public interface FreightGroupNameAutoMapper {
    int deleteByPrimaryKey(Long freightGroupId);

    int insert(FreightGroupNameAuto record);

    int insertSelective(FreightGroupNameAuto record);

    FreightGroupNameAuto selectByPrimaryKey(Long freightGroupId);

    int updateByPrimaryKeySelective(FreightGroupNameAuto record);

    int updateByPrimaryKey(FreightGroupNameAuto record);
    
    /**
     * 购物袋和商品表  分组查询
     * @param map
     * @return
     */
    List<Map<String,Object>> queryShopCartByGroupList(Map<String,Object>map);
    
    /**
     * 查询运费模板租
     * @param freightGroupNameAuto
     * @return
     */
    List<FreightGroupNameAuto> queryFreightGroupList(Map<String,Object>map);

    /**
     * 运费模板组合模板地址信息
     * @param requestMap
     * @return
     */
	int  insertSelectiveMap(Map<String, Object> requestMap);
}