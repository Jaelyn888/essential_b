package com.essential.bussiness.shop.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.shop.model.auto.ShopAuto;

/**
 * 店铺接口类
 * 
 * @author czm
 *
 */
@Service
public interface IShopService {
	public Map<String, Object> queryShopInformation(ShopAuto shopAuto);

}
