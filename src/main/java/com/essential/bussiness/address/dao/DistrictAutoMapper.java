package com.essential.bussiness.address.dao;

import java.util.List;
import java.util.Map;

import com.essential.bussiness.address.model.auto.DistrictAuto;

public interface DistrictAutoMapper {
    int deleteByPrimaryKey(Long districtId);

    int insert(DistrictAuto record);

    int insertSelective(DistrictAuto record);

    DistrictAuto selectByPrimaryKey(Long districtId);

    int updateByPrimaryKeySelective(DistrictAuto record);

    int updateByPrimaryKey(DistrictAuto record);
    
    List<DistrictAuto> queryDistrictListByParentId(DistrictAuto districtAuto);
}