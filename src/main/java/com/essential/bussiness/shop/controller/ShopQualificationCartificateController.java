package com.essential.bussiness.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.shop.model.vo.ShopQualificationCartificateVO;
import com.essential.bussiness.shop.service.IShopQualificationCartificateService;
import com.essential.utils.CommonResponseUtils;

/**
 * 结算/资质
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "shopQualificationCartificateController")
public class ShopQualificationCartificateController {
	private static Logger logger = LoggerFactory.getLogger(ShopQualificationCartificateController.class);
	
	@Autowired
	IShopQualificationCartificateService shopQualificationCartificateService;

	/**
	 * 增加
	 * 
	 * @param shopQualificationCartificateVO
	 * @return
	 */
	@RequestMapping(value = "addShopQualificationCartificate")
	@ResponseBody
	public Map<String, Object> addShopQualificationCartificate(ShopQualificationCartificateVO shopQualificationCartificateVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return shopQualificationCartificateService.addShopQualificationCartificate(shopQualificationCartificateVO);
		} catch (Exception e) {
			logger.info("====>>>>结算/资质信息添加失败:"+e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("结算/资质信息添加失败!"));
		}
		return map;
	}

	/**  
	 * 更新
	 * 
	 * @param shopQualificationCartificateVO
	 * @return
	 */
	@RequestMapping(value = "updateShopQualificationCartificate")
	@ResponseBody
	public Map<String, Object> updateShopQualificationCartificate(ShopQualificationCartificateVO shopQualificationCartificateVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return shopQualificationCartificateService.updateShopQualificationCartificate(shopQualificationCartificateVO);
		} catch (Exception e) {
			logger.info("====>>>>结算/资质信息更新失败:"+e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("结算/资质信息更新添加失败!"));
		}
		return map;
	}

	/**
	 * 删除
	 * 
	 * @param shopId
	 * @return
	 */
	@RequestMapping(value = "deleteShopQualificationCartificate")
	@ResponseBody
	public Map<String, Object> deleteShopQualificationCartificate(long shopId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return shopQualificationCartificateService.deleteShopQualificationCartificate(shopId);
		} catch (Exception e) {
			logger.info("====>>>>结算/资质信息删除失败:"+e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("结算/资质信息删除失败!"));
		}
		return map;
	}

	/**
	 * 查询
	 * 
	 * @param shopId
	 * @return
	 */
	@RequestMapping(value = "queryShopQualificationCartificate")
	@ResponseBody
	public Map<String, Object> queryShopQualificationCartificate(long shopId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return shopQualificationCartificateService.queryShopQualificationCartificate(shopId);
		} catch (Exception e) {
			logger.info("====>>>>结算/资质信息查询失败:"+e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("结算/资质信息查询失败!"));
		}
		return map;
	}
}
