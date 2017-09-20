package com.essential.bussiness.address.dao;

import java.util.List;
import java.util.Map;

import com.essential.bussiness.address.model.auto.CityAuto;

public interface CityAutoMapper {
    int deleteByPrimaryKey(Long cityId);

    int insert(CityAuto record);

    int insertSelective(CityAuto record);

    CityAuto selectByPrimaryKey(Long cityId);

    int updateByPrimaryKeySelective(CityAuto record);

    int updateByPrimaryKey(CityAuto record);
    
    List<CityAuto> selectCityListByParentId(CityAuto cityAuto);
}