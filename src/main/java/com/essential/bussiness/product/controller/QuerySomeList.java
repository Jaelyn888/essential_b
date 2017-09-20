package com.essential.bussiness.product.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.product.service.IQuerySomeList;
import com.essential.utils.CommonResponseUtils;

/**
 * 查询各种列表
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value="querySomeList")
public class QuerySomeList {
	private Logger logger = LoggerFactory.getLogger(QuerySomeList.class);

	@Autowired
	IQuerySomeList querySomeList;

	/**
	 * 商品分类列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "queryCategoryList")
	@ResponseBody
	public Map<String, Object> queryCategoryList() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return querySomeList.queryCategoryList();
		} catch (Exception e) {
			logger.info("=====>>>>>商品分类列表查询失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("商品分类列表查询失败!"));
		}
		return map;
	}

	/**
	 * 商品品牌列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "queryBrandList")
	@ResponseBody
	public Map<String, Object> queryBrandList() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return querySomeList.queryBrandList();
		} catch (Exception e) {
			logger.info("=====>>>>>商品品牌列表查询失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("商品品牌列表查询失败!"));
		}
		return map;
	}

	/**
	 * 商家列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "queryShopList")
	@ResponseBody
	public Map<String, Object> queryShopList() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return querySomeList.queryShopList();
		} catch (Exception e) {
			logger.info("=====>>>>>商家列表查询失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("商家列表查询失败!"));
		}
		return map;
	}
}
