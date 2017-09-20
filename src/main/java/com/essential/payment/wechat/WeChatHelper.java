package com.essential.payment.wechat;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Branch;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.essential.bussiness.specification.service.impl.SpecificationleveloneServiceImpl;
import com.essential.payment.model.WeChatPayment;
import com.essential.utils.MD5Util;

public class WeChatHelper {
	private static Logger logger = LoggerFactory
			.getLogger(SpecificationleveloneServiceImpl.class);
	/**
	 * 
	 * @param doc
	 *            文档对象
	 * @param ele
	 *            节点
	 * @throws SAXException
	 *             抛出的sax异常
	 * @throws IOException
	 *             抛出的io异常
	 * @throws ParserConfigurationException
	 *             解析配置文件异常
	 */
	public static Map<String, String> DomProcedure(Document doc, String[] ele)
			throws SAXException, IOException, ParserConfigurationException {
		Map<String, String> valueMap = new HashMap<String, String>();
		org.w3c.dom.Element root = ((org.w3c.dom.Document) doc)
				.getDocumentElement();
		for (int i = 0; i < ele.length; i++) {

			String value = root.getElementsByTagName(ele[i]).toString();

			valueMap.put(ele[i], value);
		}

		return valueMap;
	}

	/**
	 * String 转换为 Document 对象
	 * 
	 * @param xml
	 *            字符串
	 * @return Document 对象  暂时不用这个方法s
	 */  
	public static Document string2Doc(String xml) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document doc = null;
		InputSource source = null;
		StringReader reader = null;
		try {
			builder = factory.newDocumentBuilder();
			reader = new StringReader(xml);
			source = new InputSource(reader);// 使用字符流创建新的输入源
			doc = (Document) builder.parse(source);
			return doc;
		} catch (Exception e) {
			return null;
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	// 验证签名
	public static boolean weChatSignProcedure(Map<String, Object> map) {
		boolean flag = false;

		// 从微信得到的sign
		String weChatsign = map.get("sign").toString();
		// 验证签名需要把sign去掉
		map.remove("sign");

		// 得到用按字段升序排列的str
		String signStr = ByAscii(map);
		// 拼出apisecret;
		signStr = signStr + "&" + "key=" + new WeChatPayment().getPartnerKey();
		// 进行Md5加密
		signStr = MD5Util.MD5(signStr).toUpperCase();

		if (weChatsign.equals(signStr)) {

			flag = true;

		} else {
			flag = false;

		}

		return flag;
	}

	// //对key键值按字典升序排序第三步
	public static String ByAscii(Map<String, Object> map) {
		String returnStr = "";
		Collection<String> keyset = map.keySet();
		List<String> list = new ArrayList<String>(keyset);

		// 对key键值按字典升序排序
		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println("key键---值: " + list.get(i) + ","
					+ map.get(list.get(i)));
			/* returnStr+=((list.get(i)+"="+maptest.get(list.get(i)+"&"))); */
			returnStr += (list.get(i) + "=" + map.get(list.get(i)) + "&");

		}
		System.out.println(returnStr);
		returnStr = returnStr.substring(0, returnStr.lastIndexOf("&"));

		System.out.println(returnStr);
		return returnStr;
	}

	// 把StringXml转化为documenet 第一步
	public static org.dom4j.Document StringToxml(String str) throws DocumentException {
		str=str.replace("","");
		System.out.print("StringtoXml");
		String text = "<xml><appid><![CDATA[wx2421b1c4370ec43b]]></appid><attach><![CDATA[支付测试]]></attach><bank_type><![CDATA[CFT]]></bank_type><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[10000100]]></mch_id><nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str><openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid><out_trade_no><![CDATA[1409811653]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign><sub_mch_id><![CDATA[10000100]]></sub_mch_id><time_end><![CDATA[20140903131540]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id></xml>";
		org.dom4j.Document document = DocumentHelper.parseText(str);
		logger.info("ffffffffffff");
		return document;
	}

	// 解析xml文件,返回map 第二步
	public static Map<String, Object> ProcudureXml(org.dom4j.Document doc)

	{
		Map<String, Object> xmlMap = new HashMap<String, Object>();

		// 获得根节点
		org.dom4j.Element root = doc.getRootElement();
		
		  for(java.util.Iterator it=root.elementIterator();it.hasNext();){      
		        Element element = (Element) it.next(); 
		       
		        xmlMap.put(element.getName(),element.getText());
		       // do something   
		 }  
		return xmlMap;
	}
	

}
