package com.essential.payment.unionpay.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.essential.payment.unionpay.sdk.SDKConfig;


public class AutoLoadServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		SDKConfig.getConfig().loadPropertiesFromSrc();// 从classpath加载acp_sdk.properties文件
		
		
		super.init();
	}
}
