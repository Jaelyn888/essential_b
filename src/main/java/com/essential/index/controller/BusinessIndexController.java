package com.essential.index.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.index.service.IBusinessIndexService;
import com.essential.utils.CommonResponseUtils;

/**
 * 商家首页
 * @author essential-gfs
 *
 */
@Controller
@RequestMapping(value="business")
public class BusinessIndexController {

	//注入商家首页service
	@Autowired
	@Qualifier("businessIndexServiceImpl")
	IBusinessIndexService businessIndexService;
	
	/**
	 * 获取商家首页信息
	 * @param shopId
	 * @return
	 */
	@RequestMapping(value="queryIndexInfo")
	@ResponseBody
	public  Map<String, Object> queryIndexInfo(Long shopId) {
		
		try {
			return businessIndexService.queryIndexInfo(shopId);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("获取商家首页信息失败");
		}
	}
}
