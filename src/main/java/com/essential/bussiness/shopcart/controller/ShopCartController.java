package com.essential.bussiness.shopcart.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.shopcart.model.auto.ShopCartAuto;
import com.essential.bussiness.shopcart.service.IShopCartService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;

/**
 * 购物袋controller
 * @author essential-gfs
 *
 */
@Controller
@RequestMapping(value="shopCart")
public class ShopCartController {
	private static Logger logger = LoggerFactory.getLogger(ShopCartController.class);
	
	//装配购物袋service业务类
	@Autowired
	@Qualifier("shopCartServiceImpl")
	IShopCartService shopCartService;
	
	/**
	 * 获取购物袋(存在就获取，不存在新建)
	 * @param shopCart购物袋实体
	 * @return
	 */
	@RequestMapping(value="query")
	@ResponseBody
	public Map<String,Object> queryShopCartForList(ShopCartAuto shopCart){
		logger.info("=========>>>>>>获取购物袋信息开始："+TmDateUtil.getTimeStamp());
		try{
			return shopCartService.queryShopCart(shopCart);
		} catch (Exception e) {
			logger.info("=========>>>>>>获取购物袋信息失败:"+e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("获取购物袋信息失败");
		}
	}
	
	/**
	 * 删除购物袋商品
	 * @param shopList 购物袋商品集合
	 * @return
	 */
	@RequestMapping(value="delete")
	@ResponseBody

	public Map<String,Object> deleteShopCarts(Long[] shopcartIds){
		try {
			return shopCartService.deleteShopCart(shopcartIds);
		} catch (Exception e) {
			logger.info("=========>>>>>>删除购物袋商品失败:"+e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("删除购物袋商品失败");
		}
	}

	
	/**
	 * 商品添加到购物袋
	 * @param shopCart 购物袋实体
	 * @return
	 */
	@RequestMapping(value="add")
	@ResponseBody
	public Map<String,Object> saveShopCarts(ShopCartAuto shopCart){
		
		try {
			String nowDate = TmDateUtil.getTimeStamp();

			
			
			shopCart.setCreateTime(nowDate);
			shopCart.setModifyUser(shopCart.getUserId());
			shopCart.setCreateUser(shopCart.getUserId());
			shopCart.setIsSelected(SUConstants.IS_NOT_SELECT);
			shopCart.setModifyTime(nowDate);
			shopCart.setIsDeleted(SUConstants.IS_NOT_DELETE);
			
			return shopCartService.saveShopCart(shopCart);
		} catch (Exception e) {
			logger.info("=========>>>>>>商品添加购物袋失败:"+e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("加入购物袋失败");
		}
	}
	
	/**
	 * 更新商品信息(增加/减少数量)
	 * @param shopcartId 购物袋id
	 * @param productCount 商品数量
	 * @return
	 */
	@RequestMapping(value="updateShopCartCount")
	@ResponseBody
	public Map<String, Object> updateShopCart(Long shopcartId, int productCount){
		try {
			ShopCartAuto shopCart = new ShopCartAuto();
			
			shopCart.setShopcartId(shopcartId);
			shopCart.setProductCount(productCount);
			shopCart.setModifyTime(TmDateUtil.getTimeStamp());
			
			return shopCartService.updateShopCart(shopCart);
		} catch (Exception e) {
			logger.info("=========>>>>>>更新购物袋商品信息失败:"+e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("更新购物袋商品信息失败");
		}
	}
	
	
	/**
	 * 修改购物袋商品选中状态
	 * @param userId 用户id
	 * @param shopId 店铺id
	 * @param shopCartId 选中购物袋id
	 * @param isSelect  是否选中 1：选中，0未选中
	 * @param type 1：全选，2：店铺全选，3：单选
	 * @return
	 */
	@RequestMapping(value="updateIsOrNotIsSelect")
	@ResponseBody
	public Map<String, Object> updateIsOrNotIsSelect(Long userId, Long shopId, Long shopCartId, Integer isSelect, int type){
		
		try {
			if(userId == null){
				return CommonResponseUtils.failureResponse("用户id为空");
			}
			return shopCartService.updateShopCartIsSelectStatus(userId, shopId, shopCartId, isSelect, type);
		} catch (Exception e) {
			logger.info("=========>>>>>>更新购物袋商品选中状态失败:"+e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("更新购物袋商品选中状态失败");
		}
	}
}
