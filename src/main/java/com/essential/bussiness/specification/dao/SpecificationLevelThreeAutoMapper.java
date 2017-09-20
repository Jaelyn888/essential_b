package com.essential.bussiness.specification.dao;

import java.util.List;

import com.essential.bussiness.specification.model.auto.SpecificationLevelThreeAuto;

public interface SpecificationLevelThreeAutoMapper {
    int deleteByPrimaryKey(Long specificationValueid);

    int insert(SpecificationLevelThreeAuto record);

    int insertSelective(SpecificationLevelThreeAuto record);

    SpecificationLevelThreeAuto selectByPrimaryKey(Long specificationValueid);

    int updateByPrimaryKeySelective(SpecificationLevelThreeAuto record);

    int updateByPrimaryKey(SpecificationLevelThreeAuto record);
    
    List<SpecificationLevelThreeAuto> queryAll(SpecificationLevelThreeAuto specificationLevelThreeAuto);
}