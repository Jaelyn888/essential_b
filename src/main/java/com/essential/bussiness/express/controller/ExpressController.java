package com.essential.bussiness.express.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.essential.bussiness.express.model.vo.Express;
import com.essential.bussiness.express.service.IExpressService;
import com.essential.utils.CommonResponseUtils;



/**
 * 
 * @author cpx
 * 查询物流信息通过运单号和快递公司名称
 *
 */
@Controller
@RequestMapping(value="express")
public class ExpressController {
	private Logger logger = LoggerFactory.getLogger(ExpressController.class);
	
	@Autowired
	IExpressService expressService;
	@RequestMapping(value="query")
	@ResponseBody
	public Map<String,Object> queryExpress(Express express)
	
	{
		try {
			//return到epxress接口层
			return expressService.queryExpress(express);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("查询物流失败");
			return 	CommonResponseUtils.failureResponse("查询物流失败");
		}
		
		
		
	}
	//企业版查询物流
	@RequestMapping(value="enterPriseQuery")
	@ResponseBody
	public Map<String,Object> queryExpressEnterprise(Express express)
	
	{
		try {
			//return到epxress接口层
			return expressService.queryExpressEnterprise(express);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("查询物流失败");
			return 	CommonResponseUtils.failureResponse("查询物流失败");
		}
		
		
	}
	//订阅通知
	@RequestMapping(value="subscribeExpress")
	@ResponseBody
	public Map<String,Object> subscribeExpress()
	
	{
		try {
			//return到epxress接口层
			return expressService.subscribeExpress();
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("查询物流失败");
			return 	CommonResponseUtils.failureResponse("查询物流失败");
		}
		
		
		
	}
	
	
	
	

}
