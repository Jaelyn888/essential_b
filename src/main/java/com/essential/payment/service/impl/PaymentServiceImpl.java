package com.essential.payment.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.essential.bussiness.order.dao.OrderAutoMapper;
import com.essential.bussiness.order.model.auto.OrderAuto;
import com.essential.bussiness.order.service.IOrderService;
import com.essential.payment.alipay.config.AlipayConfig;
import com.essential.payment.alipay.sign.RSA;
import com.essential.payment.dao.AlipayProcedureAutoMapper;
import com.essential.payment.dao.UnionpayProcedureAutoMapper;
import com.essential.payment.dao.WechatProcedureAutoMapper;
import com.essential.payment.model.AlipayMent;
import com.essential.payment.model.AlipayProcedureAuto;
import com.essential.payment.model.UnionpayProcedureAuto;
import com.essential.payment.model.WeChatPayment;
import com.essential.payment.model.WechatProcedureAuto;
import com.essential.payment.service.IPaymentService;
import com.essential.payment.wechat.WeChatHelper;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.HttpRequest;
import com.essential.utils.MD5Util;
import com.essential.utils.RandomStr;

 @Service(value="paymentService") 
public class PaymentServiceImpl implements IPaymentService {
	 private Logger logger=LoggerFactory.getLogger(PaymentServiceImpl.class);
	@Autowired
	AlipayProcedureAutoMapper alipayProcedureAutoMapper;
	@Autowired
	WechatProcedureAutoMapper wechatProcedureAutoMapper;
	@Autowired
	UnionpayProcedureAutoMapper unionpayProcedureAutoMapper;
	@Autowired
	OrderAutoMapper orderAutoMapper;
	private static WeChatPayment weChatPayment = new WeChatPayment();
	@Autowired
	@Qualifier("orderServiceImpl")
	IOrderService orderService;
	

	// 得到支付宝相关配置信息
	@Override
	public Map<String, Object> aliPayment() {
		try {
			return CommonResponseUtils.successResponse(new AlipayMent());
			
		} catch (Exception e) {
			logger.info("得到支付宝相关配置信息失败");
			throw new RuntimeException(e);
			
		}
		
	}

	// 得到微信的相关配置信息
	@Override
	public Map<String, Object> WeChatPayment() throws RuntimeException {
		try {
			return CommonResponseUtils.successResponse(new WeChatPayment());
			
		} catch (Exception e) {
			logger.info("得到微信的相关配置信息");
			throw new RuntimeException(e);
			
			
		}

		
	}

	// 插入支付宝回调的信息

	@Override
	public boolean insertAlipayInfo(AlipayProcedureAuto alipayProcedureAuto)
			throws RuntimeException {
		try {
			boolean flag = false;

			if (alipayProcedureAutoMapper.insert(alipayProcedureAuto) > 0) {
				flag = true;
			}
			return flag;
			
		} catch (Exception e) {
			logger.info("插入支付宝回调信息失败");
			throw new RuntimeException(e);
		}
		
	}

	// 查询支付宝回调的信息
	@Override
	public boolean queryAlipayInfo(AlipayProcedureAuto alipayProcedureAuto)
			throws RuntimeException {
		
		try {
			
			boolean flag = false;

			AlipayProcedureAuto alipayProcedure = alipayProcedureAutoMapper
					.selectByPrimaryKey(alipayProcedureAuto);
			if (alipayProcedure != null) {
				flag = true;

			}
			return flag;
			
		} catch (Exception e) {
			logger.info("查询支付宝回调的信息");
			throw new RuntimeException(e);
			
		}
		
	}

	// 得到微信的预支付单号
	@Override
	public Map<String, Object> queryWeChatPreNumber(String orderNum,
			String totalFee, String createIp,String orderId) {
		
	OrderAuto orderAuto	=orderAutoMapper.selectByPrimaryKey(Long.parseLong(orderId));
	//判断客户端传来的价格是否订单中的价格相等
	
	//String转deciaml
	   BigDecimal decimalTotalFee= new BigDecimal(totalFee);
	   decimalTotalFee=decimalTotalFee.movePointLeft(2);
	    
	if(!((orderAuto.getFinalPrice().compareTo(decimalTotalFee))==0))
	{
		return   CommonResponseUtils.failureResponse("客户端传的价格不真实，服务端拒绝支付");
		
		
	}		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paraMap = new HashMap<String, Object>();
		String appid = weChatPayment.getAppId();
		paraMap.put("appid", appid);
		// 商户号
		String mch_id = weChatPayment.getPartnerId();
		paraMap.put("mch_id", mch_id);
		// 随机字符串（不少于32位）
		String nonce_str = RandomStr.getRandomString(25);
		paraMap.put("nonce_str", nonce_str);

		// 商品描述
		String body = "EssentialTrade";
		/*try {
			body = new String(body.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		try {
			body = URLEncoder.encode(body, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		paraMap.put("body", body);
		// 订单编号
		String out_trade_no = orderNum;
		paraMap.put("out_trade_no", out_trade_no);
		// 金额
		String total_fee = totalFee;
		paraMap.put("total_fee", total_fee);
		// 服务器Ip
		String spbill_create_ip = createIp;
		paraMap.put("spbill_create_ip", spbill_create_ip);
		// 通知地址
		String notify_url ="http://b.essential01.com.cn/essential/payment/weChatNotifyjsp";
		paraMap.put("notify_url", notify_url);
		// 交易类型
		String trade_type = "APP";
		paraMap.put("trade_type", trade_type);
		// 按字典升序排列
		String signStr = WeChatHelper.ByAscii(paraMap);
		signStr = signStr + "&" + "key=" + new WeChatPayment().getPartnerKey();
		// 进行Md5加密
		signStr = MD5Util.MD5(signStr).toUpperCase();

		String strXML = "<xml>" + "<appid>" + appid + "</appid>" + "<body>"
				+ body + "</body>" + "<mch_id>" + mch_id + "</mch_id>"
				+ "<nonce_str>" + nonce_str + "</nonce_str>" + "<notify_url>"
				+ notify_url + "</notify_url>" + "<out_trade_no>"
				+ out_trade_no + "</out_trade_no>" + "<spbill_create_ip>"
				+ spbill_create_ip + "</spbill_create_ip>" + "<total_fee>"
				+ total_fee + "</total_fee>" + "<trade_type>" + trade_type
				+ "</trade_type>" + "<sign>" + signStr + "</sign>" + "</xml> ";

		String prePayNumber = "";
		/*  return new String(xmlstring.toString().getBytes(), "ISO8859-1");*/
		String result = HttpRequest.sendPost(
				"https://api.mch.weixin.qq.com/pay/unifiedorder", strXML);
		try {
			result = new String(result.getBytes("gbk"), "utf-8");

			try {
				// 把字符串转换为document文档
				Document doc = WeChatHelper.StringToxml(result);
				// 把document文档转换为map
				Map<String, Object> xmlMap = WeChatHelper.ProcudureXml(doc);
				// 得到预支付单号
				prePayNumber = xmlMap.get("prepay_id").toString();
				System.out.println(prePayNumber);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
           logger.info("查询微信预支付单号失败");
           throw new RuntimeException(e);
		}
		System.out.println(result);
        map.put("weChatCofig",weChatPayment);
		map.put("preNumber", prePayNumber);
		return CommonResponseUtils.successResponse(map);
	}

	//通过transactionId(微信订单号)
	@Override
	public boolean queryWechatInfo(WechatProcedureAuto wechatProcedureAuto) throws RuntimeException  {
		
		try {
			WechatProcedureAuto wechatProcedure=wechatProcedureAutoMapper.selectByTransationId(wechatProcedureAuto);
			if(wechatProcedure!=null)
			{
				
			return true;
				
			}
			return false;
			
		} catch (Exception e) {
			logger.info("通过transactionId(微信订单号)失败");
			throw new RuntimeException(e);
		}
		
	}
//插入微信的
	@Override
	public boolean insertWechatInfo(WechatProcedureAuto wechatProcedureAuto)throws RuntimeException {
		try {
			
			if(wechatProcedureAutoMapper.insertSelective(wechatProcedureAuto)>0)
			{
				return true;
				
			}
			return false;
			
		} catch (Exception e) {
			logger.info("插入微信日志失败");
			throw new RuntimeException(e);
			
		}
		
	}
//得到银联预支付单号
	@Override
	public Map<String, Object> queryUnionPay( String orderId,
			String amount,String orderNum) {
		try {
			
			
			Map<String,Object> map=new HashMap<String,Object>();
			OrderAuto orderAuto	=orderAutoMapper.selectByPrimaryKey(Long.parseLong(orderId));
			//判断客户端传来的价格是否订单中的价格相等
			
			//String转deciaml
			   BigDecimal decimalTotalFee= new BigDecimal(amount);
			   decimalTotalFee=decimalTotalFee.movePointLeft(2);
			    
			if(!((orderAuto.getFinalPrice().compareTo(decimalTotalFee))==0))
			{
				return   CommonResponseUtils.failureResponse("客户端传的价格不真实，服务端拒绝支付");
				
			}		
			
		String txnAmt=amount;
		String tn=HttpRequest.sendPost("http://localhost:8080/essential/form05_6_2_AppConsume", "orderId="+orderNum+"&"+"txnAmt="+txnAmt);
		if(tn=="")
		{
			
			 return CommonResponseUtils.failureResponse(map);
			
		}
		else
		{
			map.put("tn", tn);
		 return CommonResponseUtils.successResponse(map);
			
		}
		
	   
		} catch (Exception e) {
			
		logger.info("得到银联预支付单号失败");
		throw new RuntimeException(e);
			
		}
		
		
	}
//查询银联是否这条记录
	@Override
	public boolean queryUnionOrderId(UnionpayProcedureAuto unionpayProcedureAuto) throws RuntimeException{
		try {
			boolean flag=false;
			UnionpayProcedureAuto unionpay=	unionpayProcedureAutoMapper.selectByPrimaryKey(unionpayProcedureAuto);
			if(unionpay!=null)
			{
				flag=true;	
				
			}
			
			return flag;
		} catch (Exception e) {
			logger.info("查询演练是否存在这条记录失败");
			throw new RuntimeException("查询演练是否存在这条记录失败");
		}
		
	}
//插入银联支付记录
	@Override
	public boolean insertUnionPay(UnionpayProcedureAuto unionpayProcedureAuto) throws RuntimeException {
		try {
			
			boolean	flag=false;
			if (unionpayProcedureAutoMapper.insert(unionpayProcedureAuto)>0)
			{
				flag=true;
				
			}
			return flag;
			
		} catch (Exception e) {
			logger.info("插入银联支付记录失败");
			throw new RuntimeException(e);
			
		}
	
	}
//获取支付宝参数加密过程
	@Override
	public Map<String, Object> obtainAlipaySign(String orderId,String OrderNum) {
		Map<String,Object> returnMap=new HashMap<String, Object>();
		AlipayMent alipayMent=new  AlipayMent();
		//最终返还给客户端的签名结果
		String finalContent="";
		
		try{
			
			
			//通过订单得到价格
			OrderAuto orderAuto	=orderAutoMapper.selectByPrimaryKey(Long.parseLong(orderId));
			orderAuto.getFinalPrice();
			StringBuilder sb = new StringBuilder();
			sb.append("partner=\"");
			sb.append(alipayMent.getPartnerId());
			sb.append("\"&seller_id=\"");
			sb.append(alipayMent.getSellerAccount());
			// 网址需要做URL编码
			sb.append("\"&notify_url=\"");
			try {
				sb.append(URLEncoder.encode(alipayMent.getNotifyPage(),"UTF-8"));
			}catch (Exception e){
				sb.append(alipayMent.getNotifyPage());
			}
			sb.append("\"&service=\"mobile.securitypay.pay");
			sb.append("\"&out_trade_no=\"");
			sb.append(OrderNum);
			sb.append("\"&subject=\"");
			sb.append("奕赏订单");
			sb.append("\"&body=\"");
			sb.append("奕赏订单");
			sb.append("\"&total_fee=\"");
			sb.append(orderAuto.getFinalPrice());

			sb.append("\"&_input_charset=\"UTF-8");
			
			sb.append("\"&payment_type=\"1");

			// 	// 设置未付款交易的超时时间
			// 默认30分钟，一旦超时，该笔交易就会自动被关闭。
			// 取值范围：1m～15d。
			// m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
			// 该参数数值不接受小数点，如1.5h，可转换为90m。
			sb.append("\"&it_b_pay=\"1m");
			sb.append("\"");
			// 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
			// orderInfo += "&paymethod=\"expressGateway\"";
			String contentSign=sb.toString();
			System.out.println(contentSign);
		String sign=RSA.sign(contentSign,alipayMent.getPrivateKey(),AlipayConfig.input_charset);
	   sign=URLEncoder.encode(sign,"UTF-8");
		
		
		contentSign += "&sign=\"" + sign + "\"&" + "sign_type=\"RSA\"";
		finalContent=contentSign;
		System.out.println("fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"+finalContent);
			
			
		}
		catch(Exception e)
		{
			logger.info("支付宝支付失败");
			throw new RuntimeException(e);	
		}
		returnMap.put("signContent", finalContent);
   return 	CommonResponseUtils.successResponse(returnMap);

	}

	@Override
	public Map<String, Object> updateOrderPay(String orderId,String queryId) {
		OrderAuto order = new OrderAuto();
		
		order.setExternalOrderNumber(orderId);
		order.setPayType(3);//支付类型 支付类型，1：支付宝，2：微信，3：银联
		order.setPayNumber(queryId); //流水号
		order.setPaySerialNumber(queryId);
		
		Map<String, Object> resMap = orderService.updateOrderPay(order);
		return resMap;
	}

}
