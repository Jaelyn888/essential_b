package com.essential.bussiness.sms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.sms.model.auto.SmsAuto;
import com.essential.bussiness.sms.service.ISmsService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.StringCommonUtils;
import com.essential.utils.CommonResponseUtils;

@Controller
@RequestMapping(value = "sms")
public class SmsController {

	@Autowired
	private ISmsService iSmsService;

	@RequestMapping(value = "sendSms")
	@ResponseBody
	public Map<String, Object> sendSms(SmsAuto smsVo) {
		if (smsVo == null) {
			return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
		}
		String phone = smsVo.getUserPhone();
		Integer serviceType = smsVo.getServiceType();
		Long userType = smsVo.getUserTypeId();
		if (!StringCommonUtils.isPhone(phone)||userType==null||userType<0||serviceType==null||serviceType<0) {
			return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
		} else {
			return iSmsService.sendSms(smsVo);
		}
	}

	/**
	 * 验证验证码
	 * @param smsVo
	 * @return
	 */
	@RequestMapping(value = "querySmsValidate")
	@ResponseBody
	public Map<String, Object> querySmsValidate(SmsAuto smsVo) {
		if (smsVo == null) {
			return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
		}
		String phone = smsVo.getUserPhone();
		Integer serviceType = smsVo.getServiceType();
		Long userType = smsVo.getUserTypeId();
		String smsCode=smsVo.getSmsCode();
		if (StringCommonUtils.isEmpty(smsCode)||!StringCommonUtils.isPhone(phone)||userType==null||userType<0||serviceType==null||serviceType<0) {
			return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
		} else {
			return iSmsService.querySmsValidate(smsVo);
		}
	}
}
