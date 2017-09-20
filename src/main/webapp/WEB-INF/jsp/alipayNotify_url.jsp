
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
	//��ȡ֧����POST����������Ϣ
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
		//����������δ����ڳ�������ʱʹ�á����mysign��sign�����Ҳ����ʹ����δ���ת��
		//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
		params.put(name, valueStr);
	}

	//��ȡ֧������֪ͨ���ز�����

	String trade_status = new String(request.getParameter(
			"trade_status").getBytes("ISO-8859-1"), "GBK");
	System.out.println(trade_status + "//////////////////////////////");

	if (AlipayNotify.verify(params)) {//��֤�ɹ�				

		//�õ�bean
		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this
						.getServletContext());
		//�õ�service
		IPaymentService paymentService = (IPaymentService) wac
				.getBean("paymentService");

		IOrderService buyOrder = (IOrderService) wac
				.getBean("orderServiceImpl");
		OrderAuto oa = new OrderAuto();//����ʵ��
		AlipayProcedureAuto alipayProcedureAuto = new AlipayProcedureAuto();//������Ϣ��ʵ��

		String out_trade_no = new String(request.getParameter(
				"out_trade_no").getBytes("ISO-8859-1"), "GBK");//����ϵͳ�Ķ�����
		String trade_no = new String(request.getParameter("trade_no")
				.getBytes("ISO-8859-1"), "GBK"); //֧�������׺ţ�Ψһ��
		String buyer_id = new String(request
				.getParameter("buyer_email").getBytes("ISO-8859-1"),
				"GBK"); //���֧�����˻�
		String total_fee = new String(request.getParameter("total_fee")
				.getBytes("ISO-8859-1"), "GBK");// ���׽��
		String gmt_create = new String(request.getParameter(
				"gmt_create").getBytes("ISO-8859-1"), "GBK");//���״���ʱ��

		if (trade_status.equals("TRADE_FINISHED")) {
			System.out.println(trade_no + "..................");

			out.println("success"); //���ظ�֧��������Ϣ	
		}

		if (trade_status.equals("TRADE_SUCCESS")) {
			System.out.println("TRADE_SUCCESS");
			//����֤trade_no�Ƿ��Ѿ�����������ھ�ֱ��success

			alipayProcedureAuto.setTradeNo(trade_no);
			if (paymentService.queryAlipayInfo(alipayProcedureAuto))
			//������ھ�ֱ�Ӵ�ӡ��־Ȼ���֧������ӡsuccess����		

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

				out.println("success"); //���ظ�֧��������Ϣ		
			} else {
				alipayProcedureAuto.setOutTradeNo(out_trade_no);
				alipayProcedureAuto.setTradeNo(trade_no);
				alipayProcedureAuto.setBuyer(buyer_id);
				alipayProcedureAuto.setTotalFee(total_fee);
				alipayProcedureAuto.setGmtCreate(gmt_create);

				paymentService.insertAlipayInfo(alipayProcedureAuto);

				//��һ���ύ���Ķ���״̬����
				
				System.out.println("��ӡ������:" + out_trade_no);
				//oa.setOrderId(ordId);
				oa.setExternalOrderNumber(out_trade_no);//���ⶩ����
				oa.setPayType(1);//֧������ ֧�����ͣ�1��֧������2��΢�ţ�3������
				
				oa.setPayNumber(trade_no); //��ˮ��
				oa.setPaySerialNumber(trade_no);
				buyOrder.updateOrderPay(oa);
				System.out.println("���Ķ���״̬�ɹ�");

				System.out.println(out_trade_no);
				System.out.println(trade_no);
				System.out.println(buyer_id);
				System.out.println(total_fee);
				System.out.println(gmt_create); //���״���ʱ��

				/* System.out.println(gmt_payment);  */
				/* System.out.println(notify_type); */
				System.out.println("֧���ɹ�");
				out.println("success"); //���ظ�֧��������Ϣ	
			}

		}

	} else {//��֤ʧ��
		out.println("fail");//���ظ�֧��������Ϣ
	}
%>
