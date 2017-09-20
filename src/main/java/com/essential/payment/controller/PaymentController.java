package com.essential.payment.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.essential.payment.model.AlipayProcedureAuto;
import com.essential.payment.model.WechatProcedureAuto;
import com.essential.payment.service.IPaymentService;
import com.essential.utils.CommonResponseUtils;

@Controller
@RequestMapping(value = "payment")
public class PaymentController {
	private Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	IPaymentService iPaymentService;

	// 通过支付宝进行支付
	@RequestMapping(value = "aliPayMent")
	@ResponseBody
	public Map<String, Object> alipay() {
		try {
			return iPaymentService.aliPayment();
		} catch (Exception e) {
			logger.info("通过支付宝进行支付失败");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("通过支付宝进行支付失败");

		}

	}

	// 通过微信进行支付
	@RequestMapping(value = "weChatPayment")
	@ResponseBody
	public Map<String, Object> weChat() {

		try {
			return iPaymentService.aliPayment();

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("通过微信进行支付失败");

			return CommonResponseUtils.failureResponse("通过微信进行支付失败");

		}

	}

	// 回调页面微信
	@RequestMapping(value = "weChatNotifyjsp")
	@ResponseBody
	public ModelAndView weChatNotifyjsp() {
		return new ModelAndView("weChatNotify");
	}

	// 回调页面支付宝
	@RequestMapping(value = "aliPayNotifyjsp")
	@ResponseBody
	public ModelAndView aliPayNotifyjsp(HttpServletRequest request) {
		return new ModelAndView("alipayNotify_url");
	}

	// 插入支付宝相关信息
	@RequestMapping(value = "insertAlipayInfo")
	@ResponseBody
	public boolean insertAlipayInfo(AlipayProcedureAuto alipayProcedureAuto) {
		alipayProcedureAuto.setTradeNo("ff");
		try {

			return iPaymentService.insertAlipayInfo(alipayProcedureAuto);

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("插入支付宝相关信息失败");
			return false;

		}

	}

	// 查询支付宝相关信息
	@RequestMapping(value = "queryAlipayInfro")
	@ResponseBody
	public boolean queryAlipayMent(AlipayProcedureAuto alipayProcedureAuto) {
		try {

			return iPaymentService.queryAlipayInfo(alipayProcedureAuto);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("查询支付宝相关信息失败");
			return false;
		}

	}

	// 查询微信预支付单号
	@RequestMapping(value = "queryWeChatPreNum")
	@ResponseBody
	public Map<String, Object> queryWeChatPreNum(String orderNum,
			String amount, String createIp, String orderId) {
		try {

			return iPaymentService.queryWeChatPreNumber(orderNum, amount,
					createIp, orderId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("查询微信预支付单号失败");
			return CommonResponseUtils.failureResponse("查询微信预支付单号失败");

		}

	}

	// 通过微信订单去查询微信info
	@RequestMapping(value = "queryWechatInfo")
	@ResponseBody
	public boolean queryWechat(WechatProcedureAuto wechatProcedureAuto) {
		try {
			return iPaymentService.queryWechatInfo(wechatProcedureAuto);

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("通过微信订单去查询微信info失败");
			return false;

		}

	}

	// 插入微信的info
	@RequestMapping(value = "insertWechatInfo")
	@ResponseBody
	public boolean insertWechat(WechatProcedureAuto wechatProcedureAuto) {
		try {
			return iPaymentService.insertWechatInfo(wechatProcedureAuto);

		} catch (Exception e) {

			e.printStackTrace();
			logger.info("插入微信的info失败");
			return false;
		}

	}

	// 查询银联的tn号
	@RequestMapping(value = "queryUnionNum")
	@ResponseBody
	public Map<String, Object> queryUnionNumber(String orderId, String amount,
			String orderNum) {

		try {

			return iPaymentService.queryUnionPay(orderId, amount, orderNum);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("查询银联的tn号失败");
			return CommonResponseUtils.failureResponse("查询银联的tn号失败");
		}

	}

	// 获得阿里的支付信息
	@RequestMapping(value = "obtainAlipaySign")
	@ResponseBody
	public Map<String, Object> obtainAlipaySign(String orderId, String orderNum) {
		try {
			return iPaymentService.obtainAlipaySign(orderId, orderNum);

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("获得阿里的支付信息失败");
			return CommonResponseUtils.failureResponse("获得阿里的支付信息失败");
		}

	}

}
