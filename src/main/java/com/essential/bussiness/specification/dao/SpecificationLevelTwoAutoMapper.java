package com.essential.bussiness.specification.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.essential.bussiness.specification.model.auto.SpecificationLevelTwoAuto;
import com.essential.bussiness.specification.model.auto.SpecificationLevelTwoAutoExample;

public interface SpecificationLevelTwoAutoMapper {
    int countByExample(SpecificationLevelTwoAutoExample example);

    int deleteByExample(SpecificationLevelTwoAutoExample example);

    int deleteByPrimaryKey(Long specificationIdTwolevel);

    int insert(SpecificationLevelTwoAuto record);

    int insertSelective(SpecificationLevelTwoAuto record);

    List<SpecificationLevelTwoAuto> selectByExample(SpecificationLevelTwoAutoExample example);

    SpecificationLevelTwoAuto selectByPrimaryKey(Long specificationIdTwolevel);

    int updateByExampleSelective(@Param("record") SpecificationLevelTwoAuto record, @Param("example") SpecificationLevelTwoAutoExample example);

    int updateByExample(@Param("record") SpecificationLevelTwoAuto record, @Param("example") SpecificationLevelTwoAutoExample example);

    int updateByPrimaryKeySelective(SpecificationLevelTwoAuto record);

    int updateByPrimaryKey(SpecificationLevelTwoAuto record);
    
    List<SpecificationLevelTwoAuto> queryList(SpecificationLevelTwoAuto record);
    List<SpecificationLevelTwoAuto>  selectOneId(Map<String,Object>  map);
}