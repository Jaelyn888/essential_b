package com.essential.bussiness.promotion.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.product.model.vo.ProductAutoAddField;
import com.essential.bussiness.promotion.model.vo.PromotionEditeProductVo;
import com.essential.bussiness.promotion.service.IPromotionAutoService;
import com.essential.utils.CommonResponseUtils;

/**
 * 促销活动
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "promotion")
public class PromotionController {
	private Logger logger = LoggerFactory.getLogger(PromotionController.class);
	
	@Autowired
	IPromotionAutoService promotionAutoService;
	
	/**
	 * 查询折扣商品
	 * 
	 * @param productAutoAddField
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "queryPromotionProduct")
	@ResponseBody
	public Map<String, Object> queryPromotionProduct(PromotionEditeProductVo promotionEditeProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return promotionAutoService.queryPromotionProduct(promotionEditeProductVo);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>查询折扣商品失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查询折扣商品失败!"));
		}
		return map;
	}
	
}
