package com.essential.find.dao;

import java.util.List;

import com.essential.find.model.auto.SpecialGroupAuto;

public interface SpecialGroupAutoMapper {
    int deleteByPrimaryKey(Long specialGroupId);

    int insert(SpecialGroupAuto record);

    int insertSelective(SpecialGroupAuto record);

    SpecialGroupAuto selectByPrimaryKey(Long specialGroupId);

    int updateByPrimaryKeySelective(SpecialGroupAuto record);

    int updateByPrimaryKey(SpecialGroupAuto record);
    
    /**
     * query all special group
     * @return
     */
    List<SpecialGroupAuto> selectAllSpecialGroup();
}