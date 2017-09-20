package com.essential.payment.dao;

import com.essential.payment.model.UnionpayProcedureAuto;

public interface UnionpayProcedureAutoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UnionpayProcedureAuto record);

    int insertSelective(UnionpayProcedureAuto record);

    UnionpayProcedureAuto selectByPrimaryKey(UnionpayProcedureAuto unionpayProcedureAuto);

    int updateByPrimaryKeySelective(UnionpayProcedureAuto record);

    int updateByPrimaryKey(UnionpayProcedureAuto record);
}