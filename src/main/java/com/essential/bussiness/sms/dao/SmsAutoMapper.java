package com.essential.bussiness.sms.dao;

import com.essential.bussiness.sms.model.auto.SmsAuto;

public interface SmsAutoMapper {
    int deleteByPrimaryKey(Long smsId);

    int insert(SmsAuto record);

    int insertSelective(SmsAuto record);

    SmsAuto selectByPrimaryKey(Long smsId);

    int updateByPrimaryKeySelective(SmsAuto record);

    int updateByPrimaryKey(SmsAuto record);

	int selectByParams(SmsAuto smsVo);
}