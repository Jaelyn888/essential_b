package com.essential.bussiness.shop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.essential.bussiness.shop.model.auto.ShopAuto;
import com.essential.bussiness.shop.service.IShopService;

/**
 * 店铺 Controller
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "shopController")
public class ShopController {
	@Autowired
	IShopService shopService;

	/**
	 * 获取店铺商品
	 * 
	 * @param shopAuto
	 *            店铺实体
	 * @return
	 */
	@RequestMapping(value = "queryShopInformation")
	public Map<String, Object> queryShopInformation(ShopAuto shopAuto) {

		return shopService.queryShopInformation(shopAuto);
	}

}
