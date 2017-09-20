package com.essential.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class MyMutipartResolver extends CommonsMultipartResolver{
	  
	
	@Override  
	    public boolean isMultipart(HttpServletRequest request) {  
	        if (request.getRequestURI().contains("test")) {  
	            return false;  
	        } else {  
	            return super.isMultipart(request);  
	        }  
	    }  
}
