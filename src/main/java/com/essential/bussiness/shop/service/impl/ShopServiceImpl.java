package com.essential.bussiness.shop.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.shop.dao.ShopAutoMapper;
import com.essential.bussiness.shop.model.auto.ShopAuto;
import com.essential.bussiness.shop.service.IShopService;
import com.essential.common.constants.SUConstants;

/**
 * 店铺 ShopServiceImpl
 * 
 * @author czm
 *
 */
@Service
public class ShopServiceImpl implements IShopService{

	@Autowired
	ShopAutoMapper shopAutoMapper;
	
	/**
	 * 查询店铺
	 */
	@Override
	public Map<String, Object> queryShopInformation(ShopAuto shopAuto){
		//返回信息Map
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> shopProductMAp = new HashMap<String, Object>();
		ShopAuto shopAutoInfo = new ShopAuto();
		try{
			shopAutoInfo = shopAutoMapper.selectByPrimaryKey(shopAuto.getShopId());
			shopProductMAp.put("shopDetial", shopAutoInfo);
		}catch(Exception e){
			e.printStackTrace();
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
			map.put(SUConstants.MSG_KEY, "查询失败");
		}
		
		return null;
	}

}
