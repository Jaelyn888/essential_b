package com.essential.payment.dao;

import com.essential.payment.model.AlipayProcedureAuto;

public interface AlipayProcedureAutoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AlipayProcedureAuto record);

    int insertSelective(AlipayProcedureAuto record);
//通过trade_no
    AlipayProcedureAuto selectByPrimaryKey(AlipayProcedureAuto alipayProcedureAuto);

    int updateByPrimaryKeySelective(AlipayProcedureAuto record);

    int updateByPrimaryKey(AlipayProcedureAuto record);
}