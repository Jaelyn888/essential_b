package com.essential.user.dao;

import com.essential.user.model.auto.PushMsgUserAuto;

public interface PushMsgUserAutoMapper {
    int deleteByPrimaryKey(Long msgUserId);

    int insert(PushMsgUserAuto record);

    int insertSelective(PushMsgUserAuto record);

    PushMsgUserAuto selectByPrimaryKey(Long msgUserId);

    int updateByPrimaryKeySelective(PushMsgUserAuto record);

    int updateByPrimaryKey(PushMsgUserAuto record);
    
    int updateByParams(PushMsgUserAuto record);

	int queryUnReadCountByUserId(PushMsgUserAuto record);
}