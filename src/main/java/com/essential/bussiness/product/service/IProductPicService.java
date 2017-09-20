package com.essential.bussiness.product.service;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 
 * @author cpx
 *query 通过商品的id查询商品的轮播图
 */
@Service
public interface IProductPicService {
	public Map<String, Object> query(String productId);

}
