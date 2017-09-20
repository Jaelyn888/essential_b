
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
	//����һ��bytes��Ŷ���������
	byte[] bytes = new byte[1024 * 1024];
	//�õ�һ��������
	InputStream is = request.getInputStream();

	int nRead = 1;
	//��total
	int nTotalRead = 0;
	while (nRead > 0) {
		nRead = is.read(bytes, nTotalRead, bytes.length - nTotalRead);
		if (nRead > 0)
			nTotalRead = nTotalRead + nRead;
	}

	//����ת��ΪString ΢��post��������xml�ļ�
	String str = new String(bytes, 0, nTotalRead, "utf-8");

	WeChatHelper wehelper = new WeChatHelper();
	//�Ѵ����ж�����αxml�ַ���װ��Ϊdocument
	Document doc = WeChatHelper.StringToxml(str);

	// ����xml�ļ�,����map
	Map<String, Object> xmlMap = wehelper.ProcudureXml(doc);
	//��key��ֵ���ֵ���������

	//����ǩ��
	Boolean flag = wehelper.weChatSignProcedure(xmlMap);
	System.out.println(flag);
	//΢��ʵ��
	WechatProcedureAuto wechatProcedureAuto = new WechatProcedureAuto();

	WebApplicationContext wac = WebApplicationContextUtils
			.getRequiredWebApplicationContext(this.getServletContext());
	//�õ�service
	IPaymentService paymentService = (IPaymentService) wac
			.getBean("paymentService");
	//�õ�������service
	IOrderService buyOrder = (IOrderService) wac
			.getBean("orderServiceImpl");
	OrderAuto oa = new OrderAuto();//����ʵ��
	if (flag) {

		

		//�õ����²��������Լ�ҵ����ж�
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

		//������������д��־������
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
		//�����ڵ�һ�δ����������Ͳ������ݿ�
		else {
			//��һ���ύ���Ķ���״̬����

			oa.setExternalOrderNumber(wechatProcedureAuto
					.getOutTradeNo());
			oa.setPayType(2);//֧������ ֧�����ͣ�1��֧������2��΢�ţ�3������
			oa.setPayNumber(wechatProcedureAuto.getTransactionId()); //��ˮ��
			oa.setPaySerialNumber(wechatProcedureAuto
					.getTransactionId());
			
			if (xmlMap.get("result_code").toString().equals("SUCCESS")) {
				
				buyOrder.updateOrderPay(oa);
				System.out.println("���Ķ���״̬�ɹ�");
				response.getWriter()
				.write("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA['OK']]></return_msg></xml>");

			}
			

			
			if (paymentService.insertWechatInfo(wechatProcedureAuto))//�ɹ��������ݿ�
			{

				System.out.println("�������ݿ�");
				//��ӡ�ɹ���Ϣ��΢��

			}

		}

		//�̻�������  out_trade_no  �̻�������
		//΢��֧��������  transaction_id   //�Ƿ��Ѿ�����������ж�
		//�ֽ�֧�����  cash_fee    ֧�������Ҫ��������ж�

	}

	else {

		//��Ӧ΢������ʧ�ܵ��ź�
		response.getWriter()
				.write("<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA['ǩ��ʧ��']]></return_msg></xml>");
	}
%>


