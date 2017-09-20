
<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ page import="java.util.*"%>
<%@ page import="com.essential.payment.alipay.util.*"%>
<%@ page import="com.essential.payment.alipay.config.*"%>
<%@ page import="com.essential.payment.service.impl.*"%>
<%@ page import="com.essential.payment.model.*"%>
<%@ page import="com.essential.payment.model.*"%>
<%@ page import="com.essential.payment.service.IPaymentService"%>
<%@ page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.essential.bussiness.order.service.IOrderService"%>
<%@ page import="com.essential.bussiness.order.model.auto.OrderAuto"%>

<%
	//获取支付宝POST过来反馈信息
	Map<String, String> params = new HashMap<String, String>();
	Map requestParams = request.getParameterMap();
	for (Iterator iter = requestParams.keySet().iterator();

	iter.hasNext();) {
		String name = (String) iter.next();
		String[] values = (String[]) requestParams.get(name);
		String valueStr = "";
		for (int i = 0; i < values.length; i++) {
			valueStr = (i == values.length - 1) ? valueStr + values[i]
					: valueStr + values[i] + ",";
		}
		//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
		//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
		params.put(name, valueStr);
	}

	//获取支付宝的通知返回参数，

	String trade_status = new String(request.getParameter(
			"trade_status").getBytes("ISO-8859-1"), "GBK");
	System.out.println(trade_status + "//////////////////////////////");

	if (AlipayNotify.verify(params)) {//验证成功				

		//得到bean
		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this
						.getServletContext());
		//得到service
		IPaymentService paymentService = (IPaymentService) wac
				.getBean("paymentService");

		IOrderService buyOrder = (IOrderService) wac
				.getBean("orderServiceImpl");
		OrderAuto oa = new OrderAuto();//订单实体
		AlipayProcedureAuto alipayProcedureAuto = new AlipayProcedureAuto();//阿里信息的实体

		String out_trade_no = new String(request.getParameter(
				"out_trade_no").getBytes("ISO-8859-1"), "GBK");//我们系统的订单号
		String trade_no = new String(request.getParameter("trade_no")
				.getBytes("ISO-8859-1"), "GBK"); //支付宝交易号（唯一）
		String buyer_id = new String(request
				.getParameter("buyer_email").getBytes("ISO-8859-1"),
				"GBK"); //买家支付宝账户
		String total_fee = new String(request.getParameter("total_fee")
				.getBytes("ISO-8859-1"), "GBK");// 交易金额
		String gmt_create = new String(request.getParameter(
				"gmt_create").getBytes("ISO-8859-1"), "GBK");//交易创建时间

		if (trade_status.equals("TRADE_FINISHED")) {
			System.out.println(trade_no + "..................");

			out.println("success"); //返回给支付宝的信息	
		}

		if (trade_status.equals("TRADE_SUCCESS")) {
			System.out.println("TRADE_SUCCESS");
			//先验证trade_no是否已经存在如果存在就直接success

			alipayProcedureAuto.setTradeNo(trade_no);
			if (paymentService.queryAlipayInfo(alipayProcedureAuto))
			//如果存在就直接打印日志然后给支付宝打印success返回		

			{

				Logger.getLogger(this.getClass()).info(
						"out_trade_no:" + out_trade_no);
				Logger.getLogger(this.getClass()).info(
						"trade_no:" + trade_no);
				Logger.getLogger(this.getClass()).info(
						"buyer_id:" + buyer_id);
				Logger.getLogger(this.getClass()).info(
						"total_fee" + total_fee);
				Logger.getLogger(this.getClass()).info(
						"gmt_create:" + gmt_create);

				out.println("success"); //返回给支付宝的信息		
			} else {
				alipayProcedureAuto.setOutTradeNo(out_trade_no);
				alipayProcedureAuto.setTradeNo(trade_no);
				alipayProcedureAuto.setBuyer(buyer_id);
				alipayProcedureAuto.setTotalFee(total_fee);
				alipayProcedureAuto.setGmtCreate(gmt_create);

				paymentService.insertAlipayInfo(alipayProcedureAuto);

				//第一次提交更改订单状态订单
				
				System.out.println("打印订单号:" + out_trade_no);
				//oa.setOrderId(ordId);
				oa.setExternalOrderNumber(out_trade_no);//对外订单号
				oa.setPayType(1);//支付类型 支付类型，1：支付宝，2：微信，3：银联
				
				oa.setPayNumber(trade_no); //流水号
				oa.setPaySerialNumber(trade_no);
				buyOrder.updateOrderPay(oa);
				System.out.println("更改订单状态成功");

				System.out.println(out_trade_no);
				System.out.println(trade_no);
				System.out.println(buyer_id);
				System.out.println(total_fee);
				System.out.println(gmt_create); //交易创建时间

				/* System.out.println(gmt_payment);  */
				/* System.out.println(notify_type); */
				System.out.println("支付成功");
				out.println("success"); //返回给支付宝的信息	
			}

		}

	} else {//验证失败
		out.println("fail");//返回给支付宝的信息
	}
%>
