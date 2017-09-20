package com.essential.bussiness.address.dao;

import java.util.List;
import java.util.Map;

import com.essential.bussiness.address.model.auto.ProvinceAuto;
import com.essential.bussiness.address.model.vo.ProvinceVo;

public interface ProvinceAutoMapper {
    int deleteByPrimaryKey(Long provinceId);

    int insert(ProvinceAuto record);

    int insertSelective(ProvinceAuto record);

    ProvinceAuto selectByPrimaryKey(Long provinceId);

    int updateByPrimaryKeySelective(ProvinceAuto record);

    int updateByPrimaryKey(ProvinceAuto record);
    
    
    List<ProvinceAuto> queryProvinceList(Map<String,Object> map);

	List<ProvinceVo> queryAreaList(Map<String,Object> map);
}