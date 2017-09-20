package com.essential.bussiness.specification.dao;

import java.util.List;
import java.util.Map;

import com.essential.bussiness.specification.model.auto.SpecificationValueAuto;
import com.essential.bussiness.specification.model.auto.SpecificationkeyAuto;

public interface SpecificationValueAutoMapper {
    int deleteByPrimaryKey(Long specificationValueid);

    int insert(SpecificationValueAuto record);

    int insertSelective(SpecificationValueAuto record);

    SpecificationValueAuto selectByPrimaryKey(Long specificationValueid);

    int updateByPrimaryKeySelective(SpecificationValueAuto record);

    int updateByPrimaryKey(SpecificationValueAuto record);
    List<SpecificationValueAuto> selectkey(Map<String,Object> map);
    List<SpecificationValueAuto> selectNameBykeyId(Map<String,Object> map);
    
    List<SpecificationValueAuto> selectNameBykeyId3(Map<String,Object> map);
    
    Map<String,Object>selectNameBykeyId3unite(Map<String,Object> map);
    
    //通过规格id查询规格的值二级的情况
    List<SpecificationValueAuto> selectNameValue(Map<String,Object> map);  
    //通过规格id查询规格的值三级的情况
    List<Map<String,Object>>selectNameValueI3unite(Map<String,Object> map);
    
   //通过keyid去删除规格value
    int updateByKeyIds(SpecificationValueAuto record);
    //得到全部的values
    List<SpecificationValueAuto> selectAllValues(Long keyId); 
    
    
    
    
    
    
}