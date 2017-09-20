package com.essential.payment.dao;

import com.essential.payment.model.WechatProcedureAuto;

public interface WechatProcedureAutoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WechatProcedureAuto record);

    int insertSelective(WechatProcedureAuto record);
    //通过trsationId(微信交易号)查询
    WechatProcedureAuto selectByTransationId( WechatProcedureAuto wechatProcedureAuto);

    int updateByPrimaryKeySelective(WechatProcedureAuto record);

    int updateByPrimaryKey(WechatProcedureAuto record);
}