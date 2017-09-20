package com.essential.bussiness.sms.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.essential.bussiness.product.service.impl.ProductServiceImpl;
import com.essential.bussiness.sms.dao.SmsAutoMapper;
import com.essential.bussiness.sms.model.auto.SmsAuto;
import com.essential.bussiness.sms.service.ISmsService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.StringCommonUtils;
import com.essential.common.utils.TmDateUtil;
import com.essential.user.dao.UserBaseInfoAutoMapper;
import com.essential.user.model.auto.UserBaseInfoAuto;
import com.essential.user.model.vo.UserBaseInfoVo;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.HttpRequest;
import com.essential.utils.LogUtils;
import com.essential.utils.MD5Util;
import com.essential.utils.RandomStr;

@Service
public class SmsServiceImpl implements ISmsService {
	private String tag = ProductServiceImpl.class.getSimpleName();

	@Autowired
	private UserBaseInfoAutoMapper userBaseInfoMapper;
	@Autowired
	private SmsAutoMapper smsAutoMapper;
	/**
	 * 失效时间  【奕赏】您的验证码为xxxx，1分钟内有效，请确保是本人操作，否则请忽略此短信
	 */
	private int interval = 1 * 60;// s
	private String[] smsArray = new String[] { "尊敬的用户%s，您好，欢迎注册奕赏app，您的验证码为%s，1分钟内有效，请确保是本人操作，否则请忽略此短信。【奕赏】", 
			"尊敬的用户%s，您好，您的验证码为%s，1分钟内有效，请确保是本人操作，否则请忽略此短信。【奕赏】",
			"您的验证码为%s，1分钟内有效，请确保是本人操作，否则请忽略此短信。【奕赏】" ,
			"尊敬的用户%s，您好，您的验证码为%s，1分钟内有效，请确保是本人操作，否则请忽略此短信。【奕赏】"};

	
	public Map<String, Object> sendSms(SmsAuto smsVo) {
		try {
			String phone = smsVo.getUserPhone();
			
			Integer serviceType = smsVo.getServiceType();
			Long userTypeId=smsVo.getUserTypeId();
			UserBaseInfoAuto userBaseInfoAuto=new UserBaseInfoAuto();
			userBaseInfoAuto.setUserName(phone);
			userBaseInfoAuto.setUserTypeId(userTypeId);
			userBaseInfoAuto.setIsDelete(SUConstants.IS_NOT_DELETE);

			List<UserBaseInfoVo> userBaseInfoVoList = userBaseInfoMapper.queryBaseInfoVoByParams(userBaseInfoAuto);
			int num = userBaseInfoVoList.size();
			String content = smsArray[serviceType];
			String smsCode = RandomStr.getSmsCode();
			smsVo.setSmsCode(smsCode);
			switch (serviceType) {
			case 0://注册
				if(num>0){
					return CommonResponseUtils.failureResponse("手机号已被注册");
				}
				content = String.format(content, phone, smsCode);
				break;
			case 1://忘记密码
				if(num<=0){
					return CommonResponseUtils.failureResponse("手机号未注册");
				}
				content = String.format(content, phone, smsCode);
				break;
			case 2://修改密码
				if(num<=0){
					return CommonResponseUtils.failureResponse("手机号未注册");
				}
				content = String.format(content,smsCode);
				break;
			case 3://解绑手机号
				if(num>0){
					return CommonResponseUtils.failureResponse("手机号已被注册");
				}
				content = String.format(content, phone, smsCode);
				break;
			default:
				break;
			}
		
			smsVo.setSmsContent(content);
			String timeStamp = TmDateUtil.getTimeStamp();
			long effectiveTime=System.currentTimeMillis()+interval*1000;
			Date dateT=new Date(effectiveTime);
			String effectTimeStr=TmDateUtil.dateToString(SUConstants.TIMESTAMP_FOMART, dateT);
			smsVo.setCreateTime(timeStamp);
			smsVo.setModifyTime(timeStamp);
			smsVo.setIsDelete(SUConstants.IS_NOT_DELETE);
			smsVo.setEffectiveTime(effectTimeStr);
			 num = smsAutoMapper.insertSelective(smsVo);
			if (num > 0) {
				try {
					content = URLEncoder.encode(content, "UTF-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				String date = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
				// 得到password加密过后的
				String password = (MD5Util.MD5(MD5Util.MD5("iyrVhXPX").toLowerCase() + date)).toLowerCase();

				String params = "username=shanxiu&password=%s&tkey=%s&mobile=%s&content=%s&productid=95533&xh=";
				params = String.format(params, password, date, phone, content);

				String result = HttpRequest.sendGet("http://www.ztsms.cn/sendNSms.do", params);
				if (StringCommonUtils.isEmpty(result)) {
					throw new MyException("短信发送失败");
				} else {
					Map<String, Object> resultMap = new HashMap<String, Object>();
					resultMap.put(SUConstants.MSG_KEY, "短信已发送到您的手机");
					resultMap.put("smsCode", smsCode);

					return CommonResponseUtils.successResponse("短信已发送到您的手机", resultMap);
				}

			}else{
				throw new MyException("短信发送失败");
			}
		} catch (Exception e) {
			LogUtils.error(tag, e.toString());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse("短信发送失败");
		}
	}
	
	/**
	 * 验证验证码是否有效
	 */
	@Override
	public Map<String, Object> querySmsValidate(SmsAuto smsVo) {
		try {
			int num = qurySms(smsVo);
			if (num > 0) {
				return CommonResponseUtils.successResponse("验证成功");
			}else{
				return CommonResponseUtils.failureResponse("验证失败");
			}
		} catch (Exception e) {
			LogUtils.error(tag, e.toString());
			return CommonResponseUtils.failureResponse("验证失败");
		}
	}
	
	/**
	 * 查询数量  数值大于0有效
	 * @param smsVo
	 * @return
	 */
	
	@Override
	public int qurySms(SmsAuto smsVo){
		try {
			String timeStamp = TmDateUtil.getTimeStamp();
			smsVo.setEffectiveTime(timeStamp);
			smsVo.setIsDelete(SUConstants.IS_NOT_DELETE);
			int num = smsAutoMapper.selectByParams(smsVo);
			return num;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
