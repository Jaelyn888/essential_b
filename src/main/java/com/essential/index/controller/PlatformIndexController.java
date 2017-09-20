package com.essential.index.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.index.service.IPlatformIndexService;
import com.essential.utils.CommonResponseUtils;

/**
 * 平台首页
 * @author essential-gfs
 *
 */
@Controller
@RequestMapping(value="platform")
public class PlatformIndexController {

	//注入平台首页service
	@Autowired
	@Qualifier("platformIndexServiceImpl")
	IPlatformIndexService platformIndexService;
	
	/**
	 * 获取商家首页信息
	 * @param shopId
	 * @return
	 */
	@RequestMapping(value="queryIndexInfo")
	@ResponseBody
	public  Map<String, Object> queryIndexInfo() {
		
		try {
			return platformIndexService.queryIndexInfo();
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("获取商家首页信息失败");
		}
	}
}
