package com.essential.bussiness.specification.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.essential.bussiness.specification.model.auto.SpecificationleveloneAuto;
import com.essential.bussiness.specification.model.auto.SpecificationleveloneAutoExample;

public interface SpecificationleveloneAutoMapper {
    int countByExample(SpecificationleveloneAutoExample example);

    int deleteByExample(SpecificationleveloneAutoExample example);

    int deleteByPrimaryKey(Long specificationId);

    int insert(SpecificationleveloneAuto record);

    int insertSelective(SpecificationleveloneAuto record);

    List<SpecificationleveloneAuto> selectByExample(SpecificationleveloneAutoExample example);

    SpecificationleveloneAuto selectByPrimaryKey(Long specificationId);

    int updateByExampleSelective(@Param("record") SpecificationleveloneAuto record, @Param("example") SpecificationleveloneAutoExample example);

    int updateByExample(@Param("record") SpecificationleveloneAuto record, @Param("example") SpecificationleveloneAutoExample example);

    int updateByPrimaryKeySelective(SpecificationleveloneAuto record);

    int updateByPrimaryKey(SpecificationleveloneAuto record);
    List<SpecificationleveloneAuto>selectall(SpecificationleveloneAuto specificationLeveloneAuto);
    List<SpecificationleveloneAuto> selectOneName(Map<String,Object> map);
}