
<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ page import="java.util.*"%>
<%@ page import="com.essential.payment.wechat.WeChatHelper"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="org.dom4j.Document"%>
<%@ page import="com.essential.payment.service.IPaymentService"%>
<%@ page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.essential.payment.model.*"%>
<%@ page import="com.essential.bussiness.order.service.IOrderService"%>
<%@ page import="com.essential.bussiness.order.model.auto.OrderAuto"%>
<%
	//声明一个bytes存放读到的内容
	byte[] bytes = new byte[1024 * 1024];
	//得到一个输入流
	InputStream is = request.getInputStream();

	int nRead = 1;
	//流total
	int nTotalRead = 0;
	while (nRead > 0) {
		nRead = is.read(bytes, nTotalRead, bytes.length - nTotalRead);
		if (nRead > 0)
			nTotalRead = nTotalRead + nRead;
	}

	//把流转换为String 微信post过来的是xml文件
	String str = new String(bytes, 0, nTotalRead, "utf-8");

	WeChatHelper wehelper = new WeChatHelper();
	//把从流中读来的伪xml字符串装换为document
	Document doc = WeChatHelper.StringToxml(str);

	// 解析xml文件,返回map
	Map<String, Object> xmlMap = wehelper.ProcudureXml(doc);
	//对key键值按字典升序排序

	//进行签名
	Boolean flag = wehelper.weChatSignProcedure(xmlMap);
	System.out.println(flag);
	//微信实体
	WechatProcedureAuto wechatProcedureAuto = new WechatProcedureAuto();

	WebApplicationContext wac = WebApplicationContextUtils
			.getRequiredWebApplicationContext(this.getServletContext());
	//得到service
	IPaymentService paymentService = (IPaymentService) wac
			.getBean("paymentService");
	//得到订单的service
	IOrderService buyOrder = (IOrderService) wac
			.getBean("orderServiceImpl");
	OrderAuto oa = new OrderAuto();//订单实体
	if (flag) {

		

		//得到以下参数进行自己业务的判断
		wechatProcedureAuto.setTransactionId(xmlMap.get(
				"transaction_id").toString());
		wechatProcedureAuto.setMchId(xmlMap.get("mch_id").toString());
		wechatProcedureAuto.setBankType(xmlMap.get("bank_type")
				.toString());
		wechatProcedureAuto.setTotalFee(xmlMap.get("total_fee")
				.toString());
		wechatProcedureAuto.setOutTradeNo(xmlMap.get("out_trade_no")
				.toString());
		wechatProcedureAuto.setPayendTime(xmlMap.get("time_end")
				.toString());

		//存在这条数据写日志不处理
		if (paymentService.queryWechatInfo(wechatProcedureAuto)) {
			response.getWriter()
					.write("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA['OK']]></return_msg></xml>");
			Logger.getLogger(this.getClass()).info(
					"mch_id:" + xmlMap.get("mch_id"));
			Logger.getLogger(this.getClass()).info(
					"bank_type:" + xmlMap.get("bank_type"));
			Logger.getLogger(this.getClass()).info(
					"total_fee:" + xmlMap.get("total_fee"));
			Logger.getLogger(this.getClass()).info(
					"transaction_id" + xmlMap.get("transaction_id"));
			Logger.getLogger(this.getClass()).info(
					"time_end:" + xmlMap.get("time_end"));
			Logger.getLogger(this.getClass()).info(
					"out_trade_no:" + xmlMap.get("out_trade_no"));

		}
		//不存在第一次处理这个请求就插入数据库
		else {
			//第一次提交更改订单状态订单

			oa.setExternalOrderNumber(wechatProcedureAuto
					.getOutTradeNo());
			oa.setPayType(2);//支付类型 支付类型，1：支付宝，2：微信，3：银联
			oa.setPayNumber(wechatProcedureAuto.getTransactionId()); //流水号
			oa.setPaySerialNumber(wechatProcedureAuto
					.getTransactionId());
			
			if (xmlMap.get("result_code").toString().equals("SUCCESS")) {
				
				buyOrder.updateOrderPay(oa);
				System.out.println("更改订单状态成功");
				response.getWriter()
				.write("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA['OK']]></return_msg></xml>");

			}
			

			
			if (paymentService.insertWechatInfo(wechatProcedureAuto))//成功插入数据库
			{

				System.out.println("插入数据库");
				//打印成功信息给微信

			}

		}

		//商户订单号  out_trade_no  商户订单号
		//微信支付订单号  transaction_id   //是否已经处理过在这判断
		//现金支付金额  cash_fee    支付金额需要建表进行判断

	}

	else {

		//响应微信输入失败的信号
		response.getWriter()
				.write("<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA['签名失败']]></return_msg></xml>");
	}
%>


