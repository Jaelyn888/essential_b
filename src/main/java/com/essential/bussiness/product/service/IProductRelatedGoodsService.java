package com.essential.bussiness.product.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

/**
 * 相关商品
 * @author czm
 *
 * queryRelatedGoodsService 查询相关商品
 *
 *
 */

@Service
public interface IProductRelatedGoodsService {
	//相关商品
	public Map<String, Object> queryRelatedGoodsService(HttpServletRequest request);
}
