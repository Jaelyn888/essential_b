package com.essential.management.system.dao;

import com.essential.management.system.model.auto.AboutAuto;

public interface AboutAutoMapper {
    int deleteByPrimaryKey(Long aboutId);

    int insert(AboutAuto record);

    int insertSelective(AboutAuto record);

    AboutAuto selectByPrimaryKey(Long aboutId);

    int updateByPrimaryKeySelective(AboutAuto record);

    int updateByPrimaryKey(AboutAuto record);
    
    //查询关于我们信息
    AboutAuto queryByPrimaryKey(AboutAuto record);
}