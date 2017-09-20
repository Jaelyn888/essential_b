package com.essential.bussiness.product.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.product.service.IProductRelatedGoodsService;
import com.essential.bussiness.product.service.impl.ProductManageServiceImpl;
import com.essential.utils.CommonResponseUtils;

/**
 * 相关商品
 * @author czm
 *
 */
@Controller
@RequestMapping(value="productRelatedGoodsController")
public class ProductRelatedGoodsController {
	private static Logger logger = LoggerFactory.getLogger(ProductRelatedGoodsController.class);
	
	@Autowired
	IProductRelatedGoodsService productRelatedGoodsService;

	/**
	 * 相关商品的查询
	 * 
	 * @param req
	 * @return
	 * 
	 */
	@RequestMapping(value="queryRelatedGoods")
	@ResponseBody
	public Map<String, Object> queryRelatedGoods(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return productRelatedGoodsService.queryRelatedGoodsService(req);
		} catch (Exception e) {
			logger.info("=====>>>>>相关商品查询失败:"+e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("相关商品查询失败!"));
		}
		return map;
	}

}
