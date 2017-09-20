package com.essential.find.dao;

import java.util.HashMap;
import java.util.List;

import com.essential.find.model.auto.SpecialAuto;

public interface SpecialAutoMapper {
    int deleteByPrimaryKey(Long specialId);

    int insert(SpecialAuto record);

    int insertSelective(SpecialAuto record);

    SpecialAuto selectByPrimaryKey(Long specialId);

    int updateByPrimaryKeySelective(SpecialAuto record);

    int updateByPrimaryKey(SpecialAuto record);
    
    List<Object> selectSpecialList(HashMap<String, Object> map);
    
}