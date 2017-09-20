package com.essential.bussiness.rejectreason.dao;

import com.essential.bussiness.rejectreason.model.auto.RejectReasonAuto;

public interface RejectReasonAutoMapper {
    int deleteByPrimaryKey(Long rejectReasonId);

    int insert(RejectReasonAuto record);

    int insertSelective(RejectReasonAuto record);

    RejectReasonAuto selectByPrimaryKey(Long rejectReasonId);

    int updateByPrimaryKeySelective(RejectReasonAuto record);

    int updateByPrimaryKey(RejectReasonAuto record);
    
    //根据事务Id查询原因内容
    RejectReasonAuto queryByPrimaryKey(RejectReasonAuto record);
    //逻辑删除
    int updateByProductId(RejectReasonAuto record);
}