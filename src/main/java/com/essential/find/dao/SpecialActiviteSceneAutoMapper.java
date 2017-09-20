package com.essential.find.dao;

import com.essential.find.model.auto.SpecialActiviteSceneAuto;

public interface SpecialActiviteSceneAutoMapper {
    int deleteByPrimaryKey(Long activitesceneId);

    int insert(SpecialActiviteSceneAuto record);

    int insertSelective(SpecialActiviteSceneAuto record);

    SpecialActiviteSceneAuto selectByPrimaryKey(Long activitesceneId);

    int updateByPrimaryKeySelective(SpecialActiviteSceneAuto record);

    int updateByPrimaryKey(SpecialActiviteSceneAuto record);
}