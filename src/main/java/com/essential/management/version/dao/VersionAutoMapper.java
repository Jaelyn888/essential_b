package com.essential.management.version.dao;

import java.util.List;
import java.util.Map;

import com.essential.management.version.model.auto.VersionAuto;

public interface VersionAutoMapper {
    int deleteByPrimaryKey(Long versionId);

    int insert(VersionAuto record);

    int insertSelective(VersionAuto record);

    VersionAuto selectByPrimaryKey(Long versionId);

    int updateByPrimaryKeySelective(VersionAuto record);

    int updateByPrimaryKey(VersionAuto record);
    
    //查询版本信息
    List<VersionAuto> queryByPrimaryKey(Map<String, Object> record);
    
    //查询最新版本信息
    VersionAuto queryNewVersion(VersionAuto record);
}