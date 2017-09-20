package com.essential.bussiness.shopcart.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.promotion.model.vo.PromotionProductInfoVo;
import com.essential.bussiness.shopcart.model.auto.ShopCartAuto;
import com.essential.bussiness.shopcart.model.vo.ShopCartVo;
import com.essential.bussiness.shopcart.model.vo.SkuShopCartVo;

/**
 * 购物袋service接口
 * @author essential-gfs
 *
 */
@Service
public interface IShopCartService {

	public Map<String,Object> queryShopCart(ShopCartAuto shopCartModel);
	
	public Map<String,Object> deleteShopCart(Long[] shopcartIds);
	
	public Map<String,Object> saveShopCart(ShopCartAuto shopCartModel);
	
	public Map<String,Object> updateShopCart(ShopCartAuto shopCartModel);
	
	public Map<String,Object> updateShopCartIsSelectStatus(Long userId, Long shopId, Long shopCartId, Integer isSelect, int type);
	
	public void buildProductVo(SkuShopCartVo skuShopCartVo, Map<String, Object> speciMap, 
			Map<String,Object> productPicMap, int type) throws Exception;
	
	public Map<String, Object> buildShopCartVo(List<SkuShopCartVo> skuShopCartVoList, Map<String, Object> speciMap,
			Map<String,Object> productPicMap, Map<Long,ShopCartVo> skuShopCartVoGroupMap,
			List<ShopCartVo> shopCartVoList, int type) throws Exception;
	
	public PromotionProductInfoVo buildActivityPrice(SkuShopCartVo skuShopCartVo) throws Exception;
}
