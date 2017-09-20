package com.essential.management.system.dao;

import com.essential.management.system.model.auto.HelpAuto;

public interface HelpAutoMapper {
    int deleteByPrimaryKey(Long helpId);

    int insert(HelpAuto record);

    int insertSelective(HelpAuto record);

    HelpAuto selectByPrimaryKey(Long helpId);

    int updateByPrimaryKeySelective(HelpAuto record);

    int updateByPrimaryKey(HelpAuto record);
    
    //查询帮助中心信息
    HelpAuto queryByPrimaryKey(HelpAuto record);
    
    // 删除
    int updateIsDeleteKey(HelpAuto record);
}