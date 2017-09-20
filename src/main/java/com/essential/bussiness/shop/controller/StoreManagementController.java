package com.essential.bussiness.shop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.shop.model.auto.EntityShopAuto;
import com.essential.bussiness.shop.service.IStoreManagementService;
import com.essential.utils.CommonResponseUtils;

/**
 * 门店管理（商家后台）
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "storeManagementController")
public class StoreManagementController {
	private static Logger logger = LoggerFactory.getLogger(StoreManagementController.class);

	@Autowired
	IStoreManagementService storeManagementService;

	/**
	 * 添加线下店铺地址
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "addStoreAddressInfo")
	@ResponseBody
	public Map<String, Object> addStoreAddressInfo(EntityShopAuto entityshopAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return storeManagementService.addStoreAddressInfo(entityshopAuto);
		} catch (Exception e) {
			logger.info("=====>>>>>:添加线下店铺地址失败" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("添加线下店铺地址失败!"));
		}
		return map;

	}

	/**
	 * 查询门店信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "queryStoreInfo")
	@ResponseBody
	public Map<String, Object> queryStoreInfo(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return storeManagementService.queryStoreInfo(request);
		} catch (Exception e) {
			logger.info("=====>>>>>:查询门店信息失败" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查询门店信息失败!"));
		}
		return map;
	}

	/**
	 * 删除门店信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "deleteStoreAddressInfo")
	@ResponseBody
	public Map<String, Object> deleteStoreAddressInfo(Long[] entityshopId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return storeManagementService.deleteStoreAddressInfo(entityshopId);
		} catch (Exception e) {
			logger.info("=====>>>>>:删除门店信息失败" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("删除门店信息失败!"));
		}
		return map;
	}
}
