package com.essential.bussiness.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.shop.model.auto.ShopAuto;
import com.essential.bussiness.shop.model.vo.ShopAutoVO;
import com.essential.bussiness.shop.service.IShopBackstageInfoService;
import com.essential.bussiness.shop.service.impl.ShopBackstageInfoServiceImpl;
import com.essential.utils.CommonResponseUtils;

/**
 * 店铺信息（商家后台）
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "shopBackstageInfoController")
public class ShopBackstageInfoController {
	private static Logger logger = LoggerFactory.getLogger(ShopBackstageInfoController.class);
	@Autowired
	IShopBackstageInfoService shopBackstageInfoService;

	/**
	 * 注册店铺
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "addShop")
	@ResponseBody
	public Map<String, Object> addShop(long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return shopBackstageInfoService.addShop(userId);
		} catch (Exception e) {
			logger.info("=====>>>>店铺注册失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("店铺注册失败!"));
		}
		return map;
	}

	/**
	 * 店铺信息查询
	 * 
	 * @param shopAuto
	 * @return
	 */
	@RequestMapping(value = "queryShopInfo")
	@ResponseBody
	public Map<String, Object> queryShopInfo(long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return shopBackstageInfoService.queryShopInfo(userId);
		} catch (Exception e) {
			logger.info("=====>>>>获取店铺信息失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("获取店铺信息失败!"));
		}
		return map;
	}

	/**
	 * 店铺信息更新
	 * 
	 * @param shopAutoVO
	 * @return
	 */
	@RequestMapping(value = "updateShopInfo")
	@ResponseBody
	public Map<String, Object> updateShopInfo(ShopAutoVO shopAutoVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return shopBackstageInfoService.updateShopInfo(shopAutoVO);
		} catch (Exception e) {
			logger.info("======>>>>>>店铺信息更新:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("店铺信息更新失败!"));
		}
		return map;
	}

	/**
	 * 商家统计
	 * 
	 * @param shopAutoVO
	 * @return
	 */
	@RequestMapping(value = "shopCount")
	@ResponseBody
	public Map<String, Object> shopCount() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return shopBackstageInfoService.shopCount();
		} catch (Exception e) {
			logger.info("======>>>>>>商家统计失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("商家统计失败!"));
		}
		return map;
	}
}
