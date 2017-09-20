package com.essential.logisticscompany.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.logisticscompany.model.auto.ExpressInformationAuto;
import com.essential.logisticscompany.model.vo.ExpressInformationVo;
import com.essential.logisticscompany.service.IExpressInformationService;
import com.essential.utils.CommonResponseUtils;

/**
 * 快递信息(物流公司信息)
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "expressInformation")
public class ExpressInformationController {
	private static Logger logger = LoggerFactory.getLogger(ExpressInformationController.class);

	@Autowired
	IExpressInformationService expressInformationService;

	/**
	 * 查询快递公司信息列表
	 * 
	 * @param expressInformationAuto
	 * @return
	 */
	@RequestMapping(value = "queryExpressInfo")
	@ResponseBody
	public Map<String, Object> queryExpressInfo(ExpressInformationVo expressInformationVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return expressInformationService.queryExpressInfo(expressInformationVo);
		} catch (Exception e) {
			logger.info("======>>>>>>查询快递公司信息失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查询快递公司信息失败!"));
		}
		return map;
	}

	/**
	 * 添加快递公司信息
	 * 
	 * @param expressInformationAuto
	 * @return
	 */
	@RequestMapping(value = "addExpressInfo")
	@ResponseBody
	public Map<String, Object> addExpressInfo(ExpressInformationAuto expressInformationAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return expressInformationService.addExpressInfo(expressInformationAuto);
		} catch (Exception e) {
			logger.info("======>>>>>>添加快递公司信息失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("添加快递公司信息失败!"));
		}
		return map;
	}

	/**
	 * 更新快递公司信息
	 * 
	 * @param expressInformationAuto
	 * @return
	 */
	@RequestMapping(value = "updateExpressInfo")
	@ResponseBody
	public Map<String, Object> updateExpressInfo(ExpressInformationAuto expressInformationAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return expressInformationService.updateExpressInfo(expressInformationAuto);
		} catch (Exception e) {
			logger.info("======>>>>>> 更新快递公司信息失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse(" 更新快递公司信息失败!"));
		}
		return map;
	}

	/**
	 * 删除快递公司信息
	 * 
	 * @param expressInformationAuto
	 * @return
	 */
	@RequestMapping(value = "deleteExpressInfo")
	@ResponseBody
	public Map<String, Object> deleteExpressInfo(Long[] expressId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return expressInformationService.deleteExpressInfo(expressId);
		} catch (Exception e) {
			logger.info("======>>>>>>删除快递公司信息失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("删除快递公司信息失败!"));
		}
		return map;
	}
}
