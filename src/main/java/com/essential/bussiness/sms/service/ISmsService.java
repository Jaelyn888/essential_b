package com.essential.bussiness.sms.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.essential.bussiness.sms.model.auto.SmsAuto;

@Service
public interface ISmsService {
	// 发送短信通过 通过手机号和内容

	public Map<String, Object> sendSms(SmsAuto smsVo);

	public Map<String, Object> querySmsValidate(SmsAuto smsVo);

	public int qurySms(SmsAuto smsVo);

}
