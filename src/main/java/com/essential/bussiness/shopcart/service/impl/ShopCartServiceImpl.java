package com.essential.bussiness.shopcart.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.dao.ProductAutoMapper;
import com.essential.bussiness.product.dao.ProductPicAutoMapper;
import com.essential.bussiness.product.dao.ProductSkuAutoMapper;
import com.essential.bussiness.product.model.auto.ProductAuto;
import com.essential.bussiness.product.model.auto.ProductSkuAuto;
import com.essential.bussiness.promotion.model.vo.PromotionProductInfoVo;
import com.essential.bussiness.promotion.service.IPromotionAutoService;
import com.essential.bussiness.recommend.service.IRecommendService;
import com.essential.bussiness.shop.dao.ShopAutoMapper;
import com.essential.bussiness.shopcart.dao.ShopCartAutoMapper;
import com.essential.bussiness.shopcart.model.auto.ShopCartAuto;
import com.essential.bussiness.shopcart.model.auto.ShopCartAutoExample;
import com.essential.bussiness.shopcart.model.vo.ShopCartProductSkuVo;
import com.essential.bussiness.shopcart.model.vo.ShopCartShopVo;
import com.essential.bussiness.shopcart.model.vo.ShopCartVo;
import com.essential.bussiness.shopcart.model.vo.SkuShopCartVo;
import com.essential.bussiness.shopcart.service.IShopCartService;
import com.essential.bussiness.specification.dao.SpecificationLevelThreeAutoMapper;
import com.essential.bussiness.specification.dao.SpecificationLevelTwoAutoMapper;
import com.essential.bussiness.specification.dao.SpecificationleveloneAutoMapper;
import com.essential.bussiness.specification.model.auto.SpecificationLevelThreeAuto;
import com.essential.bussiness.specification.model.auto.SpecificationLevelTwoAuto;
import com.essential.bussiness.specification.model.auto.SpecificationleveloneAuto;
import com.essential.bussiness.specification.service.ISpecificationsService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * 购物袋service业务实现类
 * @author essential-gfs
 *
 */
@Service
public class ShopCartServiceImpl implements IShopCartService {
	private static Logger logger = LoggerFactory.getLogger(ShopCartServiceImpl.class); 
	
	//装配购物袋dao
	@Autowired
	ShopCartAutoMapper shopCartDao;
	//装配商品sku dao
	@Autowired
	ProductSkuAutoMapper productSkuDao;
	//装配商品图片dao
	@Autowired
	ProductPicAutoMapper productPicDao;
	//装配一级规格dao
	@Autowired
	SpecificationleveloneAutoMapper specificationlevelOneDao;
	//装配二级规格dao
	@Autowired
	SpecificationLevelTwoAutoMapper specificationlevelTowDao;
	//装配三级规格dao
	@Autowired
	SpecificationLevelThreeAutoMapper specificationlevelThreeDao;
	//装配店铺dao
	@Autowired
	ShopAutoMapper shopDao;
	//装配商品 dao
	@Autowired
	ProductAutoMapper productDao;
	//注入规格service
	@Autowired
	@Qualifier("specificationsImpl")
	ISpecificationsService specificationsService;
	//注入优惠活动service
	@Autowired
	IPromotionAutoService promotionAutoService;
	//注入推荐service
	@Autowired
	@Qualifier("recommendServiceImpl")
	IRecommendService recommendService;
	
	
	/**
	 * 获取购物袋
	 */
	@Override
	public Map<String, Object> queryShopCart(ShopCartAuto shopCartModel) {
		//购物袋Map
		Map<String,Object> shopCartMap = new HashMap<String, Object>();
		//购物袋集合
		List<SkuShopCartVo> skuShopCartVoList = new ArrayList<SkuShopCartVo>();
		//规格Map
		Map<String, Object> speciMap = new HashMap<String, Object>();
		try {
			ShopCartAuto shopCart = new ShopCartAuto();
			
			shopCart.setUserId(shopCartModel.getUserId());
			shopCart.setIsDeleted(SUConstants.IS_NOT_DELETE);
			
			shopCartDao.updateNoSalingProduct(shopCart);
			
			skuShopCartVoList = shopCartDao.selectSkuShopCartVoByUserId(shopCart);
			
			if(skuShopCartVoList != null && skuShopCartVoList.size() > 0){
				//存放商品图片查询条件
				Map<String,Object> productPicMap = new HashMap<String,Object>();
				
				//购物袋商品sku分组Map
				Map<Long,ShopCartVo> skuShopCartVoGroupMap = new HashMap<Long,ShopCartVo>();
				
				//按店铺分组购物袋Vo 集合
				List<ShopCartVo> shopCartVoList = new ArrayList<ShopCartVo>();
//				StringBuilder specificationStr = new StringBuilder();
				
				//封装购物袋业务实体
				shopCartMap = buildShopCartVo(skuShopCartVoList,speciMap,productPicMap,skuShopCartVoGroupMap,shopCartVoList,0);
				
				//商品价格及返回信息
				buildPriceAndShopInfo(shopCartModel.getUserId(), shopCartVoList, shopCartMap, skuShopCartVoGroupMap);
				
				shopCartMap.put("shopCartVoList",shopCartVoList);
				logger.info("=========>>>>>>获取购物袋信息结束："+TmDateUtil.getTimeStamp());
				return CommonResponseUtils.successResponse(shopCartMap);
			}else{
				logger.info("=========>>>>>>获取购物袋信息结束："+TmDateUtil.getTimeStamp());
				return CommonResponseUtils.successResponse();
			}
		} catch (Exception e) {
			logger.info("=========>>>>>>获取购物袋信息失败");
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除购物袋中商品信息
	 */
	@Override
	public Map<String, Object> deleteShopCart(Long[] shopcartIds) {
		Map<String,Object> shopCartMap = new HashMap<String, Object>();
		try {
			for (Long shopcartId : shopcartIds) {
				ShopCartAuto shopCart = new ShopCartAuto();
				shopCart.setShopcartId(shopcartId);
				shopCart.setIsDeleted(SUConstants.IS_DELETE);
				int i = shopCartDao.updateByPrimaryKeySelective(shopCart);
				if(i <= 0){
					throw new Exception("=========>>>>>>修改购物袋商品状态失败");
				}
			}
			shopCartMap.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
			shopCartMap.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
		} catch (Exception e) {
			logger.info("=========>>>>>>删除购物袋商品失败");
			throw new RuntimeException(e);
		}
		return shopCartMap;
	}

	/**
	 * 商品添加到购物袋
	 */
	@Override
	public Map<String, Object> saveShopCart(ShopCartAuto shopCartModel) {
		Map<String,Object> shopCartMap = new HashMap<String, Object>();
		
		try {
			ProductAuto productAuto = productDao.selectByProductId(shopCartModel.getProductId());
			if(productAuto.getIsDelete() == SUConstants.IS_DELETE){
				logger.info("商品id为："+shopCartModel.getProductId()+"的商品已删除");
				return CommonResponseUtils.failureResponse("该商品已删除");
			}else if(productAuto.getSaleStatus() != 1){
				logger.info("商品id为："+shopCartModel.getProductId()+"的商品已下架");
				return CommonResponseUtils.failureResponse("该商品已下架");
			}
			if(shopCartModel.getProductCount() == null || shopCartModel.getProductCount() <= 0){
				shopCartMap.putAll(CommonResponseUtils.failureResponse("未选择正确的商品数量"));
				return shopCartMap;
			}
			//查询商品库存
			Map<String, Object> productCountDBMap = queryProductSkuCount(shopCartModel.getProductSkuId());
			if(productCountDBMap.get(SUConstants.INFO_KEY) == null || 
					Integer.parseInt(productCountDBMap.get(SUConstants.INFO_KEY).toString())-shopCartModel.getProductCount() < 0){
				logger.info("商品库存不足，商品剩余数量为" + productCountDBMap.get(SUConstants.INFO_KEY));
				shopCartMap.putAll(CommonResponseUtils.failureResponse("商品库存不足"));
				return shopCartMap;
			}
			//查询购物袋是否存在该商品skuid
			ShopCartAutoExample shopCartexample = new ShopCartAutoExample();
			shopCartexample.createCriteria().andProductSkuIdEqualTo(shopCartModel.getProductSkuId())
							.andUserIdEqualTo(shopCartModel.getUserId())
							.andIsDeletedNotEqualTo(SUConstants.IS_DELETE);
			List<ShopCartAuto> shopCartList = shopCartDao.selectByExample(shopCartexample);
			if(shopCartList == null || shopCartList.size() == 0){//不存在新增一条购物袋记录
				int i = shopCartDao.insert(shopCartModel);
				if(i <=0){
					throw new Exception("商品添加购物袋失败");
				}else{
					shopCartMap.putAll(CommonResponseUtils.successResponse("商品添加购物袋成功", "商品添加购物袋成功"));
				}
			}else if(shopCartList.size() == 1){//存在更改该购物袋商品数量
				if(Integer.parseInt(productCountDBMap.get(SUConstants.INFO_KEY).toString())-(shopCartModel.getProductCount()+shopCartList.get(0).getProductCount()) < 0){
					logger.info("商品库存不足，商品剩余数量为："
							+ productCountDBMap.get(SUConstants.INFO_KEY)+"本次购买数量为："
							+shopCartModel.getProductCount()+"购物袋该商品数量为："+shopCartList.get(0).getProductCount());
					shopCartMap.putAll(CommonResponseUtils.failureResponse("商品库存不足"));
					return shopCartMap;
				}
				Map<String,Object> updateShopCartMap = new HashMap<String, Object>();
				
				updateShopCartMap.put("shopcartId", shopCartList.get(0).getShopcartId());
				updateShopCartMap.put("productCount", shopCartList.get(0).getProductCount()+shopCartModel.getProductCount());
				updateShopCartMap.put("modifyTime", shopCartModel.getModifyTime());
				updateShopCartMap.put("modifyUser", shopCartModel.getModifyUser());
				//更新购物袋商品数量
				int i = shopCartDao.updateProductCountByPrimaryKey(updateShopCartMap);
				if(i <=0){
					throw new Exception("加入购物袋失败");
				}else{
					shopCartMap.putAll(CommonResponseUtils.successResponse("商品添加购物袋成功", "商品添加购物袋成功"));
				}
			}else{
				throw new Exception("加入购物袋失败,购物袋商品信息异常,请联系客服");
			}
			
		} catch (Exception e) {
			logger.info("=========>>>>>>商品添加购物袋失败");
			throw new RuntimeException(e);
		}
		return shopCartMap;
	}
	
	
	/**
	 * 更新购物袋商品数量
	 */
	@Override
	public Map<String, Object> updateShopCart(ShopCartAuto shopCartModel) {
		Map<String,Object> shopCartMap = new HashMap<String, Object>();
		
		try {
			ProductSkuAuto productSku = shopCartDao.selectProductCountByShopCartId(shopCartModel.getShopcartId());
			if(productSku == null){
				shopCartMap.putAll(CommonResponseUtils.failureResponse("查询商品信息为空"));
				return shopCartMap;
			}
			
			//查询商品sku信息
			ShopCartProductSkuVo productSkuVo = productSkuDao.selectProductSkuVoByPrimaryKey(productSku.getProductskuId());
			if(productSkuVo.getIsDelete() != null &&(productSkuVo.getIsDelete() == 1 || productSkuVo.getSaleStatus() == 0)){//订单确认页
				throw new Exception("商品已删除或已下架");
			}
			
			Long subProdutSkuCount = productSku.getProductskuCount() - shopCartModel.getProductCount();
			if(subProdutSkuCount < 0){
				logger.info("=========>>>>>>更新购物袋商品信息失败，商品库存不足，购物袋商品skuid为："+productSku.getProductskuId()+"的库存为："
						+productSku.getProductskuCount()+"，购买数量为："+shopCartModel.getProductCount());
				Map<String, Object> temMap = new HashMap<String, Object>();
				temMap.put("productSkuCount", productSku.getProductskuCount());
				shopCartMap.putAll(CommonResponseUtils.failureResponse("购买数量超过商品最大数量", temMap));
				return shopCartMap;
			}
			
			int i = shopCartDao.updateByPrimaryKeySelective(shopCartModel);
			if(i <=0){
				throw new Exception("更新购物袋商品信息失败，update返回影响行i为：" + i);
			}else{
				shopCartMap.putAll(CommonResponseUtils.successResponse("更新购物袋商品信息成功", "更新购物袋商品信息成功"));
			}
		} catch (Exception e) {
			logger.info("=========>>>>>>更新购物袋商品信息失败");
			throw new RuntimeException(e);
		}
		
		return shopCartMap;
	}
	
	/**
	 * 更新购物袋商品选中状态
	 */
	@Override
	public Map<String, Object> updateShopCartIsSelectStatus(Long userId, Long shopId, Long shopCartId, Integer isSelect, int type) {
		Map<String,Object> shopCartMap = new HashMap<String, Object>();
		Map<String,Object> map = new HashMap<String, Object>();
		
		try {
			
			ShopCartAuto shopCart = new ShopCartAuto();
			ShopCartAutoExample example = new ShopCartAutoExample();
			map.put("isDeleted", SUConstants.IS_NOT_DELETE);
			
			if(type == 1){
				shopCart.setModifyTime(TmDateUtil.getTimeStamp());
				shopCart.setModifyUser(userId);
				shopCart.setIsSelected(isSelect);
				example.createCriteria().andUserIdEqualTo(userId).andIsDeletedEqualTo(SUConstants.IS_NOT_DELETE);
				map.put("userId", userId);
			}else if(type == 2){
				shopCart.setModifyTime(TmDateUtil.getTimeStamp());
				shopCart.setModifyUser(userId);
				shopCart.setIsSelected(isSelect);
				example.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId)
				.andIsDeletedEqualTo(SUConstants.IS_NOT_DELETE);
				map.put("userId", userId);
				map.put("shopId", shopId);
			}else if(type == 3){
				shopCart.setModifyTime(TmDateUtil.getTimeStamp());
				shopCart.setModifyUser(userId);
				shopCart.setIsSelected(isSelect);
				example.createCriteria().andShopcartIdEqualTo(shopCartId)
						.andIsDeletedEqualTo(SUConstants.IS_NOT_DELETE);
				map.put("shopcartId", shopCartId);
			}else{
				return CommonResponseUtils.failureResponse("请求参数异常");
			}
			
			int i = shopCartDao.updateByExampleSelective(shopCart, example);
			if(i <= 0){
				throw new Exception("修改购物袋商品状态失败");
			}
			
			ShopCartAuto shopCartNoSalingProduct = new ShopCartAuto();
			
			shopCartNoSalingProduct.setUserId(userId);
			
			i = shopCartDao.updateNoSalingProduct(shopCartNoSalingProduct);
			
			List<Map<String, Object>> shopCartList = shopCartDao.selectProductIsSelect(map);
			
			BigDecimal productTotalPrice = new BigDecimal(0);
			BigDecimal productTotalActivityPrice = new BigDecimal(0);
			if(shopCartList != null && shopCartList.size() > 0){
				for(int j = 0; j < shopCartList.size(); j++){
					BigDecimal prices = new BigDecimal(shopCartList.get(j).get("prices").toString());
					BigDecimal productCount = new BigDecimal(shopCartList.get(j).get("productCount").toString());
					
					productTotalPrice = productTotalPrice.add(prices.multiply(productCount));
					
					//查询优惠信息
					PromotionProductInfoVo promotionProductInfoVo = recommendService.buildActivityPrice(Long.parseLong(shopCartList.get(j).get("productId").toString()));
					
					if(promotionProductInfoVo != null){
						if(promotionProductInfoVo.getPromotionType() == 0){//打折
							productTotalActivityPrice = productTotalActivityPrice.add(prices
									.multiply(new BigDecimal(Float.toString(promotionProductInfoVo.getDiscountPercent()))
									.divide(new BigDecimal(10))).multiply(productCount));
						}else if(promotionProductInfoVo.getPromotionType() == 1){//满减送
							productTotalActivityPrice = productTotalActivityPrice.add(prices
									.multiply(productCount).subtract(promotionProductInfoVo.getDiscountMoney()));
						}
					}else{
						productTotalActivityPrice = productTotalActivityPrice.add(prices
								.multiply(productCount));
					}
					
				}
			}
			shopCartMap.put("productTotalPrice", productTotalPrice);
			shopCartMap.put("productTotalActivityPrice", productTotalActivityPrice);
			shopCartMap.put("shopCartList", shopCartList);
			return CommonResponseUtils.successResponse(shopCartMap);
		} catch (Exception e) {
			logger.info("=========>>>>>>更新购物袋商品选中状态失败");
			throw new RuntimeException(e);
		}
		
	}
	
	
	/**
	 * 根据规格类型查询对应规格表中规格信息
	 * @param productSku 商品sku信息
	 * @param specificationStr 前端显示规格字符串
	 * @throws Exception
	 */
	public void getSpecificationStr(ProductSkuAuto productSku,StringBuilder specificationStr) throws Exception{
			if(productSku.getSpecificationType() == SUConstants.SPECIFICATION_TWO){//二级规格id
				//二级规格信息
				SpecificationLevelTwoAuto specificationLevelTwo = specificationlevelTowDao.selectByPrimaryKey(productSku.getSpecificationid1());
				//一级规格信息
				SpecificationleveloneAuto specificationLevelOne = specificationlevelOneDao.selectByPrimaryKey(specificationLevelTwo.getLevelTwoIs().longValue());
				specificationStr.append(specificationLevelOne.getLevelOneName());
				specificationStr.append(":");
				specificationStr.append(specificationLevelTwo.getLevelTwoName());
			}else if(productSku.getSpecificationType() == SUConstants.SPECIFICATION_THREE){//三级规格id
				//三级规格信息
				SpecificationLevelThreeAuto specificationLevelThree = specificationlevelThreeDao.selectByPrimaryKey(productSku.getSpecificationid1());
				//二级规格信息
				SpecificationLevelTwoAuto specificationLevelTwo = specificationlevelTowDao.selectByPrimaryKey(specificationLevelThree.getSpecificationId().longValue());
				specificationStr.append(specificationLevelTwo.getLevelTwoName());
				specificationStr.append(":");
				specificationStr.append(specificationLevelThree.getValueName());
			}
	}
	
	/**
	 * 封装前端展示购物袋业务规格模型
	 * @param productSku 商品sku实体
	 * @param specificationStr 规格字符串
	 * @param shopCartVo
	 * @throws Exception
	 */
	public String setSpecificationValue(ProductSkuAuto productSku,StringBuilder specificationStr) throws Exception{
		//规格一
		if(productSku.getSpecificationid1() != null){
			//根据规格类型查询对应规格表中规格信息
			getSpecificationStr(productSku, specificationStr);
		}
		//规格二
		if(productSku.getSpecificationid2() != null){
			if(specificationStr.length() > 0){
				specificationStr.append("  ");
			}
			//根据规格类型查询对应规格表中规格信息
			getSpecificationStr(productSku, specificationStr);
		}
		//规格三
		if(productSku.getSpecificationid3() != null){
			if(specificationStr.length() > 0){
				specificationStr.append("  ");
			}
			//根据规格类型查询对应规格表中规格信息
			getSpecificationStr(productSku, specificationStr);
		}
		//规格四
		if(productSku.getSpecificationid4() != null){
			if(specificationStr.length() > 0){
				specificationStr.append("  ");
			}
			//根据规格类型查询对应规格表中规格信息
			getSpecificationStr(productSku, specificationStr);
		}
		return specificationStr.toString();
	}

	
	/**
	 * 组装购物袋业务模型
	 * @param skuShopCartVoList 购物袋商品业务实体集合
	 * @param speciMap	商品sku规格信息map
	 * @param productPicMap 产品图片map
	 * @param skuShopCartVoGroupMap 购物袋商品业务实体按店铺分组map
	 * @param shopCartVoList 购物袋业务模型
	 * @param type 0：购物袋调用，1：订单确认页调用
	 * @throws Exception
	 */
	@Override
	public Map<String,Object> buildShopCartVo(List<SkuShopCartVo> skuShopCartVoList, Map<String, Object> speciMap,
			Map<String,Object> productPicMap, Map<Long,ShopCartVo> skuShopCartVoGroupMap,
			List<ShopCartVo> shopCartVoList, int type) throws Exception {
		Map<String,Object> totalPriceMap = new HashMap<String, Object>();
		//选中商品总原价
		BigDecimal productTotalPrice = new BigDecimal(0);
		//选中商品总活动价
		BigDecimal productTotalActivityPrice = new BigDecimal(0);
		//按店铺分组查询当前用户购物袋商品
		for (SkuShopCartVo skuShopCartVo : skuShopCartVoList) {
			//封装购物袋商品信息
			buildProductVo(skuShopCartVo,speciMap,productPicMap,type);
			//查询优惠信息
			PromotionProductInfoVo promotionProductInfoVo = buildActivityPrice(skuShopCartVo);
			
//			按店铺分组
			List<SkuShopCartVo> tempSkuShopCartVoList;
			ShopCartVo shopCartVo;
			if(!skuShopCartVoGroupMap.containsKey(skuShopCartVo.getShopId())){
//				tempSkuShopCartVoList = new ArrayList<SkuShopCartVo>();
				
				//通过shopid查询店铺信息
				ShopCartShopVo shopModel = shopDao.selectShopCartShopVoByPrimaryKey(skuShopCartVo.getShopId());
				if(shopModel == null){
					throw new Exception("未查到购物袋中shopId为:"+skuShopCartVo.getShopId()+"店铺信息");
				}
				//转换实体
				shopCartVo = new ShopCartVo();
				DTOUtils.map(skuShopCartVo, shopCartVo);
				shopCartVo.setShopId(shopModel.getShopId());
				shopCartVo.setName(shopModel.getName());
				shopCartVo.setLogoPath(shopModel.getLogoPath());
				shopCartVo.setShoptypeName(shopModel.getShoptypeName());
				shopCartVo.setShopSelectedTotalActivityPrice(new BigDecimal((int)0));
				shopCartVo.setShopSelectedProductPrice(shopCartVo.getShopSelectedTotalActivityPrice());
				
				skuShopCartVoGroupMap.put(skuShopCartVo.getShopId(),shopCartVo);
				shopCartVoList.add(shopCartVo);
			}
			
			shopCartVo = skuShopCartVoGroupMap.get(skuShopCartVo.getShopId());
			if(skuShopCartVo.getIsSelected() == 1){
				shopCartVo.setShopProductCount(shopCartVo.getShopProductCount()+skuShopCartVo.getProductCount());
				BigDecimal productCount = new BigDecimal(skuShopCartVo.getProductCount());
				//店铺选中商品原价
				shopCartVo.setShopSelectedProductPrice(shopCartVo.getShopSelectedProductPrice()
						.add(skuShopCartVo.getPrices()
								.multiply(productCount)));
				productTotalPrice = productTotalPrice.add(skuShopCartVo.getPrices().multiply(productCount));
				//店铺选中商品活动价
				if(promotionProductInfoVo != null){
					shopCartVo.setShopSelectedTotalActivityPrice(shopCartVo.getShopSelectedTotalActivityPrice()
							.add(skuShopCartVo.getActivityPrices()
									.multiply(productCount)));
					productTotalActivityPrice = productTotalActivityPrice.add(skuShopCartVo.getActivityPrices()
							.multiply(productCount));
				}else{
					shopCartVo.setShopSelectedTotalActivityPrice(shopCartVo.getShopSelectedTotalActivityPrice()
							.add(skuShopCartVo.getPrices()
									.multiply(productCount)));
					productTotalActivityPrice = productTotalActivityPrice.add(skuShopCartVo.getPrices().multiply(productCount));
				}
				
			}
			
			tempSkuShopCartVoList = shopCartVo.getSkuShopCartVo();
			tempSkuShopCartVoList.add(skuShopCartVo);
			
		}
		totalPriceMap.put("productTotalPrice", productTotalPrice);
		totalPriceMap.put("productTotalActivityPrice", productTotalActivityPrice);
		return totalPriceMap;
	}
	
	
	/**
	 * 封装购物袋商品信息
	 * @param skuShopCartVo 商品sku模型
	 * @param speciMap	规格map
	 * @param productPicMap	产品图片map
	 * @throws Exception
	 */
	@Override
	public void buildProductVo(SkuShopCartVo skuShopCartVo, Map<String, Object> speciMap, 
			Map<String,Object> productPicMap,int type) throws Exception {
		//清空规格Map信息
		speciMap.clear();
		//清空规格字符串信息
//		specificationStr.delete(0, specificationStr.length());
		//从商品sku,查询购物袋商品规格/售价等信息
		if(skuShopCartVo.getShopcartId() == null){
			throw new Exception("商品信息有误，请刷新商品确认信息");
		}
		if(skuShopCartVo.getShopId() == null){
			throw new Exception("该商品信息有误");
		}
		//查询商品sku信息
		ShopCartProductSkuVo productSkuVo = productSkuDao.selectProductSkuVoByPrimaryKey(skuShopCartVo.getProductSkuId());
		if(type == 1 && (productSkuVo.getIsDelete() != null &&(productSkuVo.getIsDelete() == 1 || productSkuVo.getSaleStatus() == 0))){//订单确认页
			throw new Exception("商品已删除或已下架");
		}
		if(productSkuVo != null){
			//转换实体
			DTOUtils.map(productSkuVo, skuShopCartVo);
			//封装规格
//			skuShopCartVo.setSpecificationValue(setSpecificationValue(productSku,specificationStr));
			speciMap = specificationsService.querySpecificationBySkuId(skuShopCartVo.getProductSkuId());
			if(speciMap != null && speciMap.containsKey(SUConstants.INFO_KEY) 
					&& speciMap.get(SUConstants.INFO_KEY) != null){
				skuShopCartVo.setSpecificationValue(speciMap.get(SUConstants.INFO_KEY).toString());
			}
		}
		//查询商品图片信息
		productPicMap.put("productId", skuShopCartVo.getProductId());
		productPicMap.put("status", SUConstants.IS_NOT_DELETE);
		productPicMap.put("mainpic", 1);
		List<SkuShopCartVo> pathList = productPicDao.selectProductPathAndNameByProductIdAndType(productPicMap);
		for (SkuShopCartVo productPathAndName : pathList) {
			skuShopCartVo.setPath(productPathAndName.getPath());
			skuShopCartVo.setProductName(productPathAndName.getProductName());
		}
	}
	
	
	/**
	 * 组装购物袋商品价格及返回数据模型
	 * @param userId 用户id
	 * @param shopCartVoList 购物袋vo模型 list
	 * @param shopCartMap 临时存储数据的map
	 * @param skuShopCartVoGroupMap 购物袋商品vo模型分组map
	 * @throws Exception
	 */
	public void buildPriceAndShopInfo(Long userId, List<ShopCartVo> shopCartVoList, Map<String,Object> shopCartMap,
			Map<Long,ShopCartVo> skuShopCartVoGroupMap) throws Exception {
		
		int isNotSelectedCount;
		int isSelectedCount = 0;
		//封装shopCartVo shopid属性值、店铺价格及总价格
		for (ShopCartVo shopCartVo : shopCartVoList) {
			isNotSelectedCount = 0;
			
			//查询是否全选
			isNotSelectedCount = shopCartDao.selectCountIsSeelctForShopByUserId(userId,shopCartVo.getShopId());
			isSelectedCount = isSelectedCount + (shopCartVo.getSkuShopCartVo().size() - isNotSelectedCount);
			shopCartVo.setIsAllSelected(isNotSelectedCount > 0 ? 0 : 1);
		}
		shopCartMap.put("isSelectedCount", isSelectedCount);
	}
	
	/**
	 * 查询商品库存
	 * @param productskuId
	 * @return
	 */
	public Map<String, Object> queryProductSkuCount(Long productskuId){
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		ProductSkuAuto productSku = productSkuDao.selectByPrimaryKey(productskuId);
		if(productSku == null){
			resMap.putAll(CommonResponseUtils.failureResponse("未查到该商品信息"));
			return resMap;
		}else if(productSku.getIsDelete() == SUConstants.IS_DELETE){
			resMap.putAll(CommonResponseUtils.failureResponse("该商品信息已删除，不可购买"));
			return resMap;
		}
		
		resMap.putAll(CommonResponseUtils.successResponse(productSku.getProductskuCount()));
		
		return resMap;
	}
	
	@Override
	public PromotionProductInfoVo buildActivityPrice(SkuShopCartVo skuShopCartVo) throws Exception {
		//查询商品优惠价格
		Map<String, Object> activityPriceMap = promotionAutoService.productPromotion(skuShopCartVo.getProductId());
		if("1".equals(activityPriceMap.get(SUConstants.CODE_KEY))){
			PromotionProductInfoVo promotionProductInfoVo = (PromotionProductInfoVo) activityPriceMap.get(SUConstants.INFO_KEY);
			if(promotionProductInfoVo.getPromotionType() == 0){//打折
				skuShopCartVo.setActivityPrices(skuShopCartVo.getPrices()
						.multiply(new BigDecimal(Float.toString(promotionProductInfoVo.getDiscountPercent()))
						.divide(new BigDecimal(10))));
			}else if(promotionProductInfoVo.getPromotionType() == 1){//满减送
				skuShopCartVo.setActivityPrices(skuShopCartVo.getPrices()
						.subtract(promotionProductInfoVo.getDiscountMoney()));
			}else{
				logger.info("=========>>>>>>查询productId:"+skuShopCartVo.getProductId()+"商品优惠价格失败,未知的活动类型，活动类型为："+promotionProductInfoVo.getPromotionType());
				throw new MyException("查询商品优惠价格失败，未知的活动类型");
			}
			return promotionProductInfoVo;
		}else if("0".equals(activityPriceMap.get(SUConstants.CODE_KEY))){
			logger.info("=========>>>>>>查询productId:"+skuShopCartVo.getProductId()+"商品优惠价格失败");
			throw new MyException("查询商品优惠价格失败");
		}
		return null;
	}
	
}
