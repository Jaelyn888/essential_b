package com.essential.bussiness.product.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface IQuerySomeList {

	public Map<String, Object> queryCategoryList();
	
	public Map<String, Object> queryBrandList();
	
	public Map<String, Object> queryShopList();
}
