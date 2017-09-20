package com.essential.find.dao;

import com.essential.find.model.auto.SpecialProductAuto;

public interface SpecialProductAutoMapper {
    int deleteByPrimaryKey(Long specialproductId);

    int insert(SpecialProductAuto record);

    int insertSelective(SpecialProductAuto record);

    SpecialProductAuto selectByPrimaryKey(Long specialproductId);

    int updateByPrimaryKeySelective(SpecialProductAuto record);

    int updateByPrimaryKey(SpecialProductAuto record);
}