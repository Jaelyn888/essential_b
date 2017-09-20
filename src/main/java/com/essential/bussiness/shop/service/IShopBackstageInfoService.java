package com.essential.bussiness.shop.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.shop.model.auto.ShopAuto;
import com.essential.bussiness.shop.model.vo.ShopAutoVO;

/**
 * 店铺信息（商家后台）
 * 
 * @author czm
 *
 */
@Service
public interface IShopBackstageInfoService {

	// 查询
	public Map<String, Object> queryShopInfo(long shopId);

	// 更新
	public Map<String, Object> updateShopInfo(ShopAutoVO shopAutoVO);
	
	// 注册
	public Map<String, Object> addShop(long userId);
	
	// 商家统计 
	public Map<String, Object> shopCount();
}
