package com.essential.bussiness.specification.dao;

import java.util.List;
import java.util.Map;

import com.essential.bussiness.specification.model.auto.SpecificationkeyAuto;
import com.essential.bussiness.specification.model.vo.SpecificationListVo;

public interface SpecificationkeyAutoMapper {
    int deleteByPrimaryKey(Long specificationId);
//增加规格键
    int insert(SpecificationkeyAuto record);

    int insertSelective(SpecificationkeyAuto record);

    SpecificationkeyAuto selectByPrimaryKey(Long specificationId);

    int updateByPrimaryKeySelective(SpecificationkeyAuto record);

    int updateByPrimaryKey(SpecificationkeyAuto record);
    List<SpecificationkeyAuto> selectkey(Map<String,Object> map);
    List<SpecificationkeyAuto> selectkey2(Map<String,Object> map);
    List<SpecificationkeyAuto> selectupIds(Map<String,Object> map);
    SpecificationkeyAuto  selectKeyName(Map<String,Object> map);
    //判断是二级还是三级，如果是三级就把三级的值取出来
    Long  selectKeyLevel(Long valueId);
    //如果是二级   
    Map<String,Object> selectKeyLevel2(Long valueId);
    //如果是三级的情况
    Map<String,Object> selectKeyLevel3(Long valueId);
    
    //得到三级中顶级的名字
    String   selectTopKeyName(Long valueId);
    
    //得到全部的key
    List<SpecificationkeyAuto> selectAllKey(); 
    
    //得到规格列表
    
    List<SpecificationListVo> selectSpecificationList();
   
    
    
    
    
}