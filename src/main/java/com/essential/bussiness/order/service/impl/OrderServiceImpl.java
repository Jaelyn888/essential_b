package com.essential.bussiness.order.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.essential.bussiness.freighttemplate.service.IFreightTemplateService;
import com.essential.bussiness.order.dao.OrderAutoMapper;
import com.essential.bussiness.order.dao.OrderLogisticAutoMapper;
import com.essential.bussiness.order.dao.OrderPayAutoMapper;
import com.essential.bussiness.order.dao.OrderProductAutoMapper;
import com.essential.bussiness.order.dao.OrderProductPromotionAutoMapper;
import com.essential.bussiness.order.dao.OrderStatusAutoMapper;
import com.essential.bussiness.order.model.auto.OrderAuto;
import com.essential.bussiness.order.model.auto.OrderAutoExample;
import com.essential.bussiness.order.model.auto.OrderLogisticAuto;
import com.essential.bussiness.order.model.auto.OrderPayAuto;
import com.essential.bussiness.order.model.auto.OrderProductAuto;
import com.essential.bussiness.order.model.auto.OrderProductAutoExample;
import com.essential.bussiness.order.model.auto.OrderProductPromotionAuto;
import com.essential.bussiness.order.model.auto.OrderStatusAuto;
import com.essential.bussiness.order.model.vo.OrderShopVo;
import com.essential.bussiness.order.model.vo.SubmitOrderVo;
import com.essential.bussiness.order.service.IOrderService;
import com.essential.bussiness.product.dao.ProductAutoMapper;
import com.essential.bussiness.product.dao.ProductSkuAutoMapper;
import com.essential.bussiness.product.model.auto.ProductAuto;
import com.essential.bussiness.product.model.auto.ProductSkuAuto;
import com.essential.bussiness.promotion.model.vo.PromotionProductInfoVo;
import com.essential.bussiness.promotion.service.IPromotionAutoService;
import com.essential.bussiness.shopcart.dao.ShopCartAutoMapper;
import com.essential.bussiness.shopcart.model.auto.ShopCartAutoExample;
import com.essential.bussiness.shopcart.model.vo.ShopCartProductSkuVo;
import com.essential.bussiness.shopcart.model.vo.ShopCartVo;
import com.essential.bussiness.shopcart.model.vo.SkuShopCartVo;
import com.essential.bussiness.shopcart.service.IShopCartService;
import com.essential.bussiness.specification.service.ISpecificationsService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.TmDateUtil;
import com.essential.coupon.model.vo.CouponAutoVo;
import com.essential.coupon.service.ICouponAutoService;
import com.essential.user.dao.UserBaseInfoAutoMapper;
import com.essential.user.dao.UserReceiptAddressAutoMapper;
import com.essential.user.model.auto.UserBaseInfoAuto;
import com.essential.user.model.auto.UserReceiptAddressAuto;
import com.essential.user.model.vo.PlatformPushMsgRequestVo;
import com.essential.user.model.vo.UserReceiptAddressVo;
import com.essential.user.service.IPushMsgService;
import com.essential.user.service.IUserReceiptAddressService;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.OrderUtils;

/**
 * 订单业务处理service
 * @author essential-gfs
 *
 */
@Service
public class OrderServiceImpl implements IOrderService {

	private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	//装配订单dao
	@Autowired
	OrderAutoMapper orderDao;
	//装配订单商品dao
	@Autowired
	OrderProductAutoMapper orderProductDao;
	//装配订单状态dao
	@Autowired
	OrderStatusAutoMapper orderStatusDao;
	//装配订单支付dao
	@Autowired
	OrderPayAutoMapper orderPayDao;
	//装配订单物流dao
	@Autowired
	OrderLogisticAutoMapper orderLogisticDao;
	//装配订单商品活动dao
	@Autowired
	OrderProductPromotionAutoMapper orderProductPromotionDao;
	//装配购物袋dao
	@Autowired
	ShopCartAutoMapper shopCartDao;
	//购物袋service 实现类
	@Autowired
	@Qualifier("shopCartServiceImpl")
	IShopCartService shopCartservice;
	//装配商品dao
	@Autowired
	ProductAutoMapper productDao;
	//装配商品sku dao
	@Autowired
	ProductSkuAutoMapper productSkuDao;
	//装配用户地址 dao
	@Autowired
	UserReceiptAddressAutoMapper userReceiptAddressDao;
	//装配用户地址 service
	@Autowired
	@Qualifier("userReceiptAddressServiceImpl")
	IUserReceiptAddressService userReceiptAddressService;
	//装配运费service
	@Autowired
	@Qualifier("freightTemplateServiceImpl")
	IFreightTemplateService freightTemplateService;
	//注入规格service
	@Autowired
	@Qualifier("specificationsImpl")
	ISpecificationsService specificationsService;
	//注入优惠活动service
	@Autowired
	IPromotionAutoService promotionAutoService;
	//注入用户基础信息dao
	@Autowired
	UserBaseInfoAutoMapper userDao;
	// 装配推送消息service
	@Autowired
	@Qualifier("pushMsgServiceImpl")
	IPushMsgService pushMsgService;
	// 注入优惠券service
	@Autowired
	@Qualifier("couponAutoServiceImpl")
	ICouponAutoService couponService;
	
	
	/**
	 * 提交订单
	 */
	@Override
	public Map<String, Object> saveOrder(SubmitOrderVo submitOrderVo){
		Map<String,Object> orderMap = new HashMap<String, Object>();
		
		try {
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(submitOrderVo.getUserId());
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null 
					||  SUConstants.USERTYPE_APP != userBaseInfo.getUserTypeId()){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			int i = 0;
			//规格Map
			Map<String, Object> speciMap = new HashMap<String, Object>();
					
			//根据addressId查询用户地址信息
			UserReceiptAddressAuto userReceiptAddress = userReceiptAddressDao.selectByPrimaryKey(submitOrderVo.getAddressId());
			if(userReceiptAddress == null){
				orderMap.putAll(CommonResponseUtils.failureResponse("提交订单失败,未搜索到当前用户的地址信息"));
				return orderMap;
			}
			//对外订单号
			String externalOrderNumber = OrderUtils.getExternalOrderNumber(submitOrderVo.getUserId().toString(),"ES");
			//购物袋list  根据userId查询购物袋选中的商品
//			List<SkuShopCartVo> skuShopCartVoList = querySkuShopCartVoList(submitOrderVo.getUserId());
			if(submitOrderVo.getShopList() == null || submitOrderVo.getShopList().size() <= 0){
				orderMap.putAll(CommonResponseUtils.failureResponse("提交订单失败,购物袋中无选中商品信息,请刷新确认商品信息"));
				return orderMap;
			}
			//把购物袋按店铺分组
//			Map<Long,List<SkuShopCartVo>> shopCartGroupMap = shopCartListGroupByShopId(skuShopCartVoList);
			Map<Long,OrderShopVo> shopCartGroupMap = shopCartListGroupByShopId(submitOrderVo);
			//flag 1：单个订单，0：多个订单
			orderMap.put("flag", shopCartGroupMap.entrySet().size() > 1?0 : 1);
			//根据店铺分单
			int orderIndex = 0;
			for (Entry<Long, OrderShopVo> orderShopVoEntry : shopCartGroupMap.entrySet()) {
				OrderAuto orderModel = new OrderAuto();
				orderModel.setBuyerNote(orderShopVoEntry.getValue().getBuyerNote());
				OrderStatusAuto orderStatusModel = new OrderStatusAuto();
				//封装订单及订单状态实体
				setOrderAndOrderStatus(submitOrderVo.getUserId(),submitOrderVo.getPayType(),orderModel,orderStatusModel,externalOrderNumber,orderIndex);
				orderIndex++;
				orderModel.setShopId(orderShopVoEntry.getKey());
				//购物袋各店铺商品集合
				List<SkuShopCartVo> shopCartOrderList = orderShopVoEntry.getValue().getSkuShopCartVos();
				BigDecimal totalPrice = new BigDecimal(0);
				BigDecimal totalActivityPrice = new BigDecimal(0);
				for (SkuShopCartVo skuShopCartVo : shopCartOrderList) {
					ShopCartProductSkuVo productSkuVo = productSkuDao.selectProductSkuVoByPrimaryKey(skuShopCartVo.getProductSkuId());
					if(productSkuVo.getProductskuId() == null){
						logger.info("=========>>>>>>提交订单失败,未查到订单中商品skuid:"+skuShopCartVo.getProductSkuId()+"的信息");
						throw new MyException("提交订单失败,未查到订单中商品skuid:"+skuShopCartVo.getProductSkuId()+"的信息");
					}
					if(productSkuVo.getIsDelete() != null 
							&& productSkuVo.getIsDelete().intValue() == SUConstants.IS_DELETE){
						logger.info("=========>>>>>>提交订单失败,商品skuid:"+skuShopCartVo.getProductSkuId()+"的信息改变,请刷新商品信息");
						throw new MyException("提交订单失败,商品skuid:"+skuShopCartVo.getProductSkuId()+"的信息改变,请刷新商品信息");
					}
					if(productSkuVo.getSaleStatus() == null
							|| productSkuVo.getSaleStatus().intValue() == 0){
						logger.info("=========>>>>>>提交订单失败,商品skuid:"+skuShopCartVo.getProductSkuId()+"已下架,请刷新商品信息");
						throw new MyException("提交订单失败,商品skuid:"+skuShopCartVo.getProductSkuId()+"已下架,请刷新商品信息");
					}
					//查询优惠活动
					skuShopCartVo.setPrices(productSkuVo.getPrices());
					PromotionProductInfoVo promotionProductInfoVo = shopCartservice.buildActivityPrice(skuShopCartVo);
					//购买商品活动价
					BigDecimal productCount = new BigDecimal(skuShopCartVo.getProductCount());
					if(promotionProductInfoVo != null){
						totalActivityPrice = totalActivityPrice.add(skuShopCartVo.getActivityPrices()
								.multiply(productCount));
					}else{
						totalActivityPrice = totalActivityPrice.add(skuShopCartVo.getPrices().multiply(productCount));
					}
					totalPrice = totalPrice.add(productSkuVo.getPrices().multiply(productCount));
					
					//更新商品sku库存信息
					productSkuVo.setModifyUser(orderModel.getModifyUserId());
					productSkuVo.setModifyTime(orderModel.getModifyTime());
					Long subProdutSkuCount = productSkuVo.getProductskuCount() - skuShopCartVo.getProductCount();
					if(subProdutSkuCount < 0){
						logger.info("=========>>>>>>提交订单失败，商品库存不足，商品skuid："+skuShopCartVo.getProductSkuId()+"的库存为："
								+productSkuVo.getProductskuCount()+"，购买数量为："+skuShopCartVo.getProductCount());
						throw new MyException("提交订单失败，商品库存不足");
					}
					productSkuVo.setProductskuCount(subProdutSkuCount);
					i = 0;
					i= productSkuDao.updateByPrimaryKey(productSkuVo);
					if(i < 0){
						logger.info("=========>>>>>>提交订单失败，更新商品库存失败，update返回影响行i为：" + i);
						throw new MyException("提交订单失败，更新商品库存失败");
					}
					
					//更新商品销量及库存信息
					ProductAuto spuProductAuto = productDao.selectByProductId(skuShopCartVo.getProductId());
					spuProductAuto.setSaleNum(spuProductAuto.getSaleNum()+skuShopCartVo.getProductCount().longValue());
					if(spuProductAuto.getStock().longValue() - skuShopCartVo.getProductCount().longValue() < 0){
						logger.info("=========>>>>>>提交订单失败，商品spu库存不足，商品productId："+skuShopCartVo.getProductId()+"的库存为："
								+spuProductAuto.getStock()+"，购买数量为："+skuShopCartVo.getProductCount());
						throw new MyException("库存异常");
					}
					spuProductAuto.setStock(spuProductAuto.getStock().longValue() - skuShopCartVo.getProductCount().longValue());
					i = 0;
					i= productDao.updateByPrimaryKeySelective(spuProductAuto);
					if(i < 0){
						logger.info("=========>>>>>>提交订单失败，更新商品销量及库存信息失败，update返回影响行i为：" + i);
						throw new MyException("提交订单失败");
					}
				}
				
				//邮费
				totalPrice = totalPrice.add(orderShopVoEntry.getValue().getShopFreight());
				totalActivityPrice = totalActivityPrice.add(orderShopVoEntry.getValue().getShopFreight());
				//新增订单
				orderModel.setFreight(orderShopVoEntry.getValue().getShopFreight());
				orderModel.setTotalPrice(totalPrice);
				orderModel.setFinalPrice(totalActivityPrice);
				orderModel.setAddress(userReceiptAddress.getConsigneeAddress());
				orderModel.setAddresse(userReceiptAddress.getConsignee());
				orderModel.setUserPhone(userReceiptAddress.getPhone());
				
				i = orderDao.insert(orderModel);
				if(i <= 0){
					logger.info("=========>>>>>>新增订单失败");
					throw new MyException("新增订单失败");
				}
				if("1".equals(orderMap.get("flag").toString())){
					orderMap.put("orderId", orderModel.getOrderId());
				}
				
				//新增订单商品关联关系(现存订单表主键id,可存订单号优化)
				for (SkuShopCartVo tempSkuShopCartVo : shopCartOrderList) {
					speciMap.clear();
					OrderProductAuto orderProductAuto = orderProductDao.selectProductInfoByProductSkuId(tempSkuShopCartVo.getProductSkuId());
					if(orderProductAuto == null){
						logger.info("=========>>>>>>新增订单失败，未查到订单商品productSkuid为："+tempSkuShopCartVo.getProductSkuId()+"的商品信息");
						throw new MyException("根据商品skuId查询商品信息为空");
					}
					orderProductAuto.setOrderId(orderModel.getOrderId());
					orderProductAuto.setProductCount(tempSkuShopCartVo.getProductCount());
//						orderProductAuto.setProductSpecification("颜色：你猜    中国码：你猜猜猜");
					
					speciMap = specificationsService.querySpecificationBySkuId(tempSkuShopCartVo.getProductSkuId());
					if(speciMap != null && speciMap.containsKey(SUConstants.INFO_KEY) 
							&& speciMap.get(SUConstants.INFO_KEY) != null){
						orderProductAuto.setProductSpecification(speciMap.get(SUConstants.INFO_KEY).toString());
					}
//						orderProductAuto.setUserConponId(userConponId);//用户优惠券
					//查询优惠活动
					tempSkuShopCartVo.setPrices(orderProductAuto.getProductPrice());
					PromotionProductInfoVo promotionProductInfoVo = shopCartservice.buildActivityPrice(tempSkuShopCartVo);
					//活动信息
					if(promotionProductInfoVo != null){
						orderProductAuto.setOrderPromotionId(promotionProductInfoVo.getPromotionId().intValue());//活动id
					}
					orderProductAuto.setProductActivityPrice(tempSkuShopCartVo.getActivityPrices());
					orderProductAuto.setReturnRefundStatus(999);
					
					ShopCartProductSkuVo tempProductSkuVo = productSkuDao.selectProductSkuVoByPrimaryKey(tempSkuShopCartVo.getProductSkuId());
					orderProductAuto.setArticleNumber(tempProductSkuVo.getArticleNumber());
					orderProductAuto.setCategoryId(tempProductSkuVo.getCategoryId());
					orderProductAuto.setCategoryName(tempProductSkuVo.getCategoryName());
					orderProductAuto.setProductTypeId(tempProductSkuVo.getProductTypeId());
					orderProductAuto.setProductTypeName(tempProductSkuVo.getProductTypeName());
					orderProductAuto.setBrandId(tempProductSkuVo.getBrandId());
					orderProductAuto.setBrandName(tempProductSkuVo.getBrandName());
					
					i = 0;
					i = orderProductDao.insert(orderProductAuto);
					if(i <= 0){
						logger.info("=========>>>>>>新增订单商品关联关系失败，orderProductDao的数据表影响行数i为："+i);
						throw new MyException("新增订单商品关联关系失败");
					}
					
					//新增订单商品活动信息
					if(promotionProductInfoVo != null){
						OrderProductPromotionAuto orderProductPromotionAuto = new OrderProductPromotionAuto();
						orderProductPromotionAuto.setOrderProductId(orderProductAuto.getOrderProductId());
						orderProductPromotionAuto.setOrderPromotionName(promotionProductInfoVo.getPromotionName());
						orderProductPromotionAuto.setPromotionId(promotionProductInfoVo.getPromotionId());
						orderProductPromotionAuto.setPromotionType(promotionProductInfoVo.getPromotionType());
						if(promotionProductInfoVo.getPromotionType() != null){
							if(promotionProductInfoVo.getPromotionType().intValue() == 0){//打折
								orderProductPromotionAuto.setPromotionMoneyOrDiscount(promotionProductInfoVo.getDiscountPercent().toString());
							}else if(promotionProductInfoVo.getPromotionType().intValue() == 1){//满减送
								orderProductPromotionAuto.setPromotionMoneyOrDiscount(promotionProductInfoVo.getDiscountMoney().toString());
							}
						}
						
						i = 0;
						i = orderProductPromotionDao.insert(orderProductPromotionAuto);
						if(i <= 0){
							logger.info("=========>>>>>>新增订单商品活动关联关系失败，orderProductPromotionDao.insert的数据表影响行数i为："+i);
							throw new MyException("新增订单商品活动关联关系失败");
						}
					}
					
					//删除购物袋选中商品
					i = 0;
					tempSkuShopCartVo.setShopcartId(tempSkuShopCartVo.getShopcartId());
					tempSkuShopCartVo.setIsDeleted(SUConstants.IS_DELETE);
					
					i = shopCartDao.updateByPrimaryKeySelective(tempSkuShopCartVo);
					if(i <= 0){
						logger.info("=========>>>>>>删除购物袋信息失败，shopCartDao的数据表影响行数i为："+i);
						throw new MyException("删除购物袋信息失败");
					}
				}
				
				//新增订单状态信息
				i = 0;
				orderStatusModel.setOrderId(orderModel.getOrderId());
				orderStatusModel.setOrderStatusItemId(1);
				orderStatusModel.setOperator(orderModel.getUserId().intValue());
				orderStatusModel.setOrderStatusTime(orderModel.getModifyTime());
				i = orderStatusDao.insert(orderStatusModel);
				if(i <= 0){
					logger.info("=========>>>>>>新增订单状态信息失败，orderStatusDao的数据表影响行数i为："+i);
					throw new MyException("新增订单状态信息失败");
				}
			}
			orderMap.put("externalOrderNumber", externalOrderNumber);
			logger.debug("=========>>>>>>提交订单结束："+TmDateUtil.getTimeStamp());
			return CommonResponseUtils.successResponse("订单提交成功", orderMap);
		} catch (Exception e) {
			logger.info("=========>>>>>>新增订单及订单关系维护失败");
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除订单
	 */
	@Override
	public Map<String, Object> deleteOrder(OrderAuto orderModel, Long loginUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 确认订单页
	 */
	@Override
	public Map<String, Object> confirmOrder(Long userId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		try {
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(userId);
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null 
					||  SUConstants.USERTYPE_APP != userBaseInfo.getUserTypeId()){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			
			//临时存储数据map
			Map<String, Object> tempMap = new HashMap<String, Object>();
			
			//组装用户信息模型
			buildUserAddr(userId, tempMap);
			
			//查询总运费和各个店铺运费
			buildShopAndTotalFreight(tempMap);
			
			//根据userid 查询该用户选择购买的商品
			List<SkuShopCartVo> skuShopCartVoList = querySkuShopCartVoList(userId);
			if(skuShopCartVoList == null || skuShopCartVoList.size() <= 0){
				return CommonResponseUtils.failureResponse("购买商品为空");
			}
			
//				//组装购物袋(确认订单页)商品模型
//				buildSkuShopCart(skuShopCartVoList, tempMap);
			
			//存放商品图片查询条件
			Map<String,Object> productPicMap = new HashMap<String,Object>();
			
			//购物袋商品sku分组Map
			Map<Long, ShopCartVo> skuShopCartVoGroupMap = new HashMap<Long,ShopCartVo>();
			
			//按店铺分组购物袋Vo 集合
			List<ShopCartVo> shopCartVoList = new ArrayList<ShopCartVo>();
//				StringBuilder specificationStr = new StringBuilder();
			
			//规格Map
			Map<String, Object> speciMap = new HashMap<String, Object>();
			
			//封装购物袋业务实体
			shopCartservice.buildShopCartVo(skuShopCartVoList,speciMap,productPicMap,skuShopCartVoGroupMap,shopCartVoList,1);
			
			buildFreightAndPrice(tempMap, shopCartVoList, skuShopCartVoGroupMap, userId);
			
			resMap.putAll(CommonResponseUtils.successResponse(tempMap));
		} catch (Exception e) {
			logger.info("=========>>>>>>确认订单页，查询购买产品、用户地址或运费信息失败");
			throw new RuntimeException(e);
		}
		
		return resMap;
	}
	
	
	
	/**
	 * App更新订单信息
	 */
	@Override
	public Map<String, Object> updateOrderForApp(OrderAuto orderModel, String msg, Long loginUserId) {
		
		try {
			//查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(loginUserId);
			//校验当前用户权限
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null 
					||  SUConstants.USERTYPE_APP != userBaseInfo.getUserTypeId()){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			if(orderModel.getOrderStatus() == null){
				return CommonResponseUtils.failureResponse("请求订单状态为空");
			}
			//查询订单信息
			OrderAuto orderAutoDb = orderDao.selectByPrimaryKey(orderModel.getOrderId());
			//校验当前用户对订单的操作权限
			if(orderModel.getOrderStatus().intValue() != SUConstants.ORDER_STATUS_FOUR){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			if(orderModel.getOrderStatus().intValue()==SUConstants.ORDER_STATUS_FOUR
					&& (orderAutoDb.getOrderStatus() == null 
					|| (orderAutoDb.getOrderStatus().intValue() != SUConstants.ORDER_STATUS_THREE
					&& orderAutoDb.getOrderStatus().intValue() != SUConstants.ORDER_STATUS_FOUR))){
				return CommonResponseUtils.failureResponse("订单状态异常，不能确认收货");
			}
			//校验订单中的商品是否有未完成售后状态
			OrderProductAutoExample orderProductAutoExample = new OrderProductAutoExample();
			orderProductAutoExample.createCriteria().andOrderIdEqualTo(orderModel.getOrderId());
			List<OrderProductAuto> orderProductAutoList = orderProductDao.selectByExample(orderProductAutoExample);
			for (OrderProductAuto tempOrderProductAuto : orderProductAutoList) {
				if(tempOrderProductAuto.getReturnRefundStatus() != SUConstants.ORDER_STATUS_ZERO
						&& tempOrderProductAuto.getReturnRefundStatus()%10 != SUConstants.RETURN_REFUND_ORDER_STATUS_TWO
						&& tempOrderProductAuto.getReturnRefundStatus()%10 != SUConstants.RETURN_REFUND_ORDER_STATUS_FIVE
						&& tempOrderProductAuto.getReturnRefundStatus()%10 != SUConstants.RETURN_REFUND_ORDER_STATUS_SIX
						&& tempOrderProductAuto.getReturnRefundStatus()%10 != SUConstants.RETURN_REFUND_ORDER_STATUS_NINE){
					return CommonResponseUtils.failureResponse("当前订单中有商品正在售后中，不能确认收货");
				}
			}
			
			return updateOrder(orderModel,msg,loginUserId,orderAutoDb.getUserId(),true,orderAutoDb.getOrderNumber());
		} catch (Exception e) {
			logger.info(msg+"失败");
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 平台更新订单信息
	 */
	@Override
	public Map<String, Object> updateOrderForPlatform(OrderAuto orderModel, String msg, Long loginUserId) {
		
		try {
			//查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(loginUserId);
			//校验当前用户权限
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null 
					||  SUConstants.USERTYPE_PATFORM != userBaseInfo.getUserTypeId()){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			
			//查询订单信息
			OrderAuto orderAutoDb = orderDao.selectByPrimaryKey(orderModel.getOrderId());
			//校验当前用户对订单的操作权限
			if(orderModel.getOrderStatus() == null || orderModel.getOrderStatus() != 1000011){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			if(orderModel.getOrderStatus().intValue() == SUConstants.ORDER_STATUS_ZERO
					&& (orderAutoDb.getOrderStatus().intValue() != SUConstants.ORDER_STATUS_ONE
					|| (orderAutoDb.getOrderStatus().intValue() == SUConstants.ORDER_STATUS_ONE
					&& TmDateUtil.getPreDate("H",-72).after(TmDateUtil.stringToDate("yyyy-MM-dd HH:mm:ss.SSS",orderAutoDb.getCreateTime()))))){
				return CommonResponseUtils.failureResponse("订单状态异常或下单时间超过72小时，不能取消");
			}
			
			return updateOrder(orderModel,msg,loginUserId,orderAutoDb.getUserId(),true,orderAutoDb.getOrderNumber());
		} catch (Exception e) {
			logger.info(msg+"失败");
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * App取消订单
	 */
	@Override
	public Map<String, Object> cancelOrderApp(OrderAuto orderModel, Long loginUserId) {
		
		try {
			//查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(loginUserId);
			//校验当前用户权限
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null 
					||  SUConstants.USERTYPE_APP != userBaseInfo.getUserTypeId()){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			
			//查询订单信息
			OrderAuto orderAutoDb = orderDao.selectByPrimaryKey(orderModel.getOrderId());
			//校验当前用户对订单的操作权限
			if(orderModel.getOrderStatus() == null || orderModel.getOrderStatus().intValue() != SUConstants.ORDER_STATUS_ZERO){
				return CommonResponseUtils.failureResponse("请求参数异常");
			}
			if(orderModel.getOrderStatus().longValue() == SUConstants.ORDER_STATUS_ZERO
					&& (orderAutoDb.getOrderStatus().longValue() != SUConstants.ORDER_STATUS_ONE
					|| (orderAutoDb.getOrderStatus().longValue() == SUConstants.ORDER_STATUS_ONE
					&& TmDateUtil.getPreDate("H",-72).after(TmDateUtil.stringToDate("yyyy-MM-dd HH:mm:ss.SSS",orderAutoDb.getCreateTime()))))){
				return CommonResponseUtils.failureResponse("订单状态异常或下单时间超过72小时，不能取消");
			}
			
			return cancelOrder(orderModel, loginUserId, orderAutoDb.getUserId(),orderAutoDb.getOrderNumber());
		} catch (Exception e) {
			logger.info("取消订单失败");
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * 商家取消订单
	 */
	@Override
	public Map<String, Object> cancelOrderBussiness(OrderAuto orderModel, Long loginUserId) {
		
		try {
			//查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(loginUserId);
			//校验当前用户权限
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null 
					||  SUConstants.USERTYPE_SHOP != userBaseInfo.getUserTypeId()){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			
			//查询订单信息
			OrderAuto orderAutoDb = orderDao.selectByPrimaryKey(orderModel.getOrderId());
			//校验当前用户对订单的操作权限
			if(orderModel.getOrderStatus() == null || orderModel.getOrderStatus().intValue() != SUConstants.ORDER_STATUS_ZERO){
				return CommonResponseUtils.failureResponse("请求参数异常");
			}
			if(orderModel.getOrderStatus().intValue() == SUConstants.ORDER_STATUS_ZERO
					&& (orderAutoDb.getOrderStatus().intValue() != SUConstants.ORDER_STATUS_ONE)){
				return CommonResponseUtils.failureResponse("订单状态异常，不能取消");
			}
			
			return cancelOrder(orderModel, loginUserId, orderAutoDb.getUserId(),orderAutoDb.getOrderNumber());
		} catch (Exception e) {
			logger.info("取消订单失败");
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * 平台取消订单
	 */
	@Override
	public Map<String, Object> cancelOrderPlatform(OrderAuto orderModel, Long loginUserId) {
		
		try {
			//查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(loginUserId);
			//校验当前用户权限
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null 
					||  SUConstants.USERTYPE_PATFORM != userBaseInfo.getUserTypeId()){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			
			//查询订单信息
			OrderAuto orderAutoDb = orderDao.selectByPrimaryKey(orderModel.getOrderId());
			//校验当前用户对订单的操作权限
			if(orderModel.getOrderStatus() == null || orderModel.getOrderStatus().intValue() != SUConstants.ORDER_STATUS_ZERO){
				return CommonResponseUtils.failureResponse("请求参数异常");
			}
			if(orderModel.getOrderStatus().intValue() == SUConstants.ORDER_STATUS_ZERO
					&& (orderAutoDb.getOrderStatus().intValue() != SUConstants.ORDER_STATUS_ONE)){
				return CommonResponseUtils.failureResponse("订单状态异常，不能取消");
			}
			
			return cancelOrder(orderModel, loginUserId, orderAutoDb.getUserId(),orderAutoDb.getOrderNumber());
		} catch (Exception e) {
			logger.info("取消订单失败");
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 订单支付
	 */
	@Override
	public Map<String, Object> updateOrderPay(OrderAuto orderModel) {
		
		try {
			logger.info("=========>>>>>>对外订单号："+orderModel.getExternalOrderNumber());
			orderModel.setModifyTime(TmDateUtil.getTimeStamp());
			orderModel.setOrderStatus(SUConstants.ORDER_STATUS_TWO);
			if(StringUtils.isEmpty(orderModel.getExternalOrderNumber())){
				return CommonResponseUtils.failureResponse("支付失败，订单号为空");
			}
			OrderAutoExample orderExample = new OrderAutoExample();
			orderExample.createCriteria().andExternalOrderNumberEqualTo(orderModel.getExternalOrderNumber())
						.andIsDeleteEqualTo(SUConstants.IS_NOT_DELETE);
			List<OrderAuto> orderAutoList = orderDao.selectByExample(orderExample);
			logger.info("=========>>>>>>查询到订单数："+orderAutoList.size());
			int i = orderDao.updateByExampleSelective(orderModel, orderExample);
			if(i <= 0){
				logger.info("订单支付失败，维护订单信息失败");
				throw new MyException("订单支付失败");
			}
			
			for (OrderAuto orderAuto : orderAutoList) {
				OrderStatusAuto orderStatusAuto = new OrderStatusAuto();
				orderStatusAuto.setOrderId(orderAuto.getOrderId());
//				orderStatusAuto.setOperator(orderModel.getUserId().intValue());
				orderStatusAuto.setOrderStatusItemId(orderModel.getOrderStatus());
				orderStatusAuto.setOrderStatusTime(orderModel.getModifyTime());
				i = 0;
				
				i = orderStatusDao.insert(orderStatusAuto);
				if(i <= 0){
					logger.info("订单支付失败，维护订单状态信息失败");
					throw new MyException("订单支付失败");
				}
				OrderPayAuto orderPay = new OrderPayAuto();
				orderPay.setOrderId(orderAuto.getOrderId());
				orderPay.setOrderTradeNumber(orderModel.getPayNumber());
				orderPay.setPayType(orderModel.getPayType());
				orderPay.setCreateTime(orderModel.getModifyTime());
				orderPay.setModifyTime(orderModel.getModifyTime());
				orderPay.setIsDelete(SUConstants.IS_NOT_DELETE);
				
				i = 0;
				
				i = orderPayDao.insert(orderPay);
				if(i <= 0){
					logger.info("订单支付失败，新增支付订单失败");
					throw new MyException("订单支付失败");
				}
				OrderProductAuto  orderProductAuto = new  OrderProductAuto();
				orderProductAuto.setReturnRefundStatus(0);
				OrderProductAutoExample orderProductAutoExample = new OrderProductAutoExample();
				orderProductAutoExample.createCriteria().andOrderIdEqualTo(orderAuto.getOrderId());
				i = 0;
				
				i = orderProductDao.updateByExampleSelective(orderProductAuto, orderProductAutoExample);
				if(i <= 0){
					logger.info("订单支付失败，更新订单商品是否可退货退款状态失败");
					throw new MyException("订单支付失败");
				}
			}
			
			return CommonResponseUtils.successResponse();
		} catch (Exception e) {
			logger.info("订单支付失败");
			throw new RuntimeException(e);
		}
		
	}
	
	
	/**
	 * 发货
	 */
	@Override
	public Map<String, Object> delivery(OrderAuto orderModel,
			OrderLogisticAuto orderLogisticModel, Long loginUserId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		try {
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(loginUserId);
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null 
					|| SUConstants.USERTYPE_SHOP != userBaseInfo.getUserTypeId()){
				return CommonResponseUtils.failureResponse("当前用户无此操作权限");
			}
			
			//查询订单信息
			OrderAuto orderAutoDb = orderDao.selectByPrimaryKey(orderModel.getOrderId());
			//校验当前用户对订单的操作权限
			if(orderModel.getOrderStatus() == null || orderModel.getOrderStatus().intValue() != SUConstants.ORDER_STATUS_THREE){
				return CommonResponseUtils.failureResponse("请求参数异常");
			}
			if(orderModel.getOrderStatus().intValue() == SUConstants.ORDER_STATUS_THREE
					&& orderAutoDb.getOrderStatus().intValue() != SUConstants.ORDER_STATUS_TWO){
				return CommonResponseUtils.failureResponse("订单状态异常，不能发货");
			}
			OrderProductAutoExample orderProductAutoExample = new OrderProductAutoExample();
			orderProductAutoExample.createCriteria().andOrderIdEqualTo(orderModel.getOrderId());
			List<OrderProductAuto> orderProductAutoList = orderProductDao.selectByExample(orderProductAutoExample);
			for (OrderProductAuto tempOrderProductAuto : orderProductAutoList) {
				if(tempOrderProductAuto.getReturnRefundStatus() != SUConstants.ORDER_STATUS_ZERO
						&& tempOrderProductAuto.getReturnRefundStatus()%10 != SUConstants.RETURN_REFUND_ORDER_STATUS_TWO 
						&& tempOrderProductAuto.getReturnRefundStatus()%10 != SUConstants.RETURN_REFUND_ORDER_STATUS_FIVE
						&& tempOrderProductAuto.getReturnRefundStatus()%10 != SUConstants.RETURN_REFUND_ORDER_STATUS_SIX
						&& tempOrderProductAuto.getReturnRefundStatus()%10 != SUConstants.RETURN_REFUND_ORDER_STATUS_NINE){
					return CommonResponseUtils.failureResponse("订单中的有商品正在售后中，不能发货");
				}
			}
			updateOrder(orderModel, "发货", loginUserId, orderAutoDb.getUserId(), false, null);
			
			int i = 0;
			i = orderLogisticDao.insert(orderLogisticModel);
			if(i <= 0){
				throw new MyException("发货失败");
			}
			resMap.putAll(CommonResponseUtils.successResponse());
			
			pushDeliverOrderMessage(orderAutoDb.getUserId(), orderModel.getOrderId().toString(), 8, 
					orderModel.getOrderStatus().toString(), "您的订单号为："+orderAutoDb.getOrderNumber()+"的订单,"+"已发货", orderLogisticModel.getLogisticNumber(), orderLogisticModel.getLogisticsCompany());
		} catch (Exception e) {
			logger.info("发货失败");
			throw new RuntimeException(e);
		}
		
		return resMap;
	}
	
	
	/**
	 * 确认订单页--查询用户优惠券
	 */
	@Override
	public Map<String, Object> queryUserCoupon(Long loginUserId, Integer queryCouponType,
			BigDecimal orderMoney, Integer pageNo, Integer pageCount) {
		try {
			CouponAutoVo couponAutoVo = new CouponAutoVo();
			if(pageNo == null){
				pageNo = 1;
			}
			
			if(pageCount == null){
				pageCount = 10;
			}
			
			couponAutoVo.setPageIndex(pageNo);
			couponAutoVo.setPageSize(pageCount);
			
			couponAutoVo.setUserId(loginUserId);
			couponAutoVo.setIsAvailable(1);
			couponAutoVo.setQueryCouponType(queryCouponType);
			couponAutoVo.setOrderMoney(orderMoney);
			
			return couponService.queryCouponNotUsed(couponAutoVo);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	
	
	
	/**
	 * 购物袋按店铺分组
	 * @param shopCarts 购物袋集合
	 * @return
	 */
	public Map<Long,OrderShopVo> shopCartListGroupByShopId(SubmitOrderVo submitOrderVo) throws Exception{
		Map<Long,OrderShopVo> shopCartMap = new HashMap<Long,OrderShopVo>();
		
		List<OrderShopVo> shopList = submitOrderVo.getShopList();
		
		for (OrderShopVo orderShopVo : shopList) {
			if(orderShopVo.getSkuShopCartVos() == null || orderShopVo.getSkuShopCartVos().size() <= 0){
				logger.info("======>>>>>>未购买商品");
				throw new MyException("未购买商品");
			}
			List<SkuShopCartVo> skuShopCartVoList = new ArrayList<SkuShopCartVo>();
			for (SkuShopCartVo tempSkuShopCartVo : orderShopVo.getSkuShopCartVos()) {
				//根据shopcartId查询购物袋选中的商品
				SkuShopCartVo skuShopCartVo = shopCartDao.selectSkuShopCartVoByPrimaryKey(tempSkuShopCartVo.getShopcartId());
				if(skuShopCartVo.getIsDeleted() != null && skuShopCartVo.getIsDeleted().intValue() == SUConstants.IS_DELETE){
					logger.info("======>>>>>>购物袋已删除shopcartId:"+tempSkuShopCartVo.getShopcartId()+"的商品");
					throw new MyException("购物袋已删除该商品");
				}
				if(skuShopCartVo.getUserId() == null || submitOrderVo.getUserId() == null
						|| skuShopCartVo.getUserId().longValue() != submitOrderVo.getUserId().longValue()){
					logger.info("======>>>>>>购物袋userId："+skuShopCartVo.getUserId()+"与当前订单userId："+submitOrderVo.getUserId()+"不一致");
					throw new MyException("购物袋userId："+skuShopCartVo.getUserId()+"与当前订单userId："+submitOrderVo.getUserId()+"不一致，请确认");
				}
				skuShopCartVoList.add(skuShopCartVo);
			}
			orderShopVo.setSkuShopCartVos(skuShopCartVoList);
			shopCartMap.put(orderShopVo.getShopId(), orderShopVo);
		}
		
		return shopCartMap;
	}
	
	/**
	 * 组装订单及订单业务模型
	 * @param userId 用户id
	 * @param payType 支付类型
	 * @param orderModel 订单实体
	 * @param orderStatusModel 订单状态实体
	 */
	public void setOrderAndOrderStatus(Long userId, int payType,OrderAuto orderModel,OrderStatusAuto orderStatusModel,
			String externalOrderNumber, int orderIndex) throws Exception{
		//组装订单model
		String nowDate = TmDateUtil.getTimeStamp();
		String orderNumber = OrderUtils.getOrderNumber(userId.toString(), orderIndex);
		orderModel.setOrderNumber(orderNumber);
		orderModel.setIsDelete(SUConstants.IS_NOT_DELETE);
		orderModel.setOrderStatus(1);
		orderModel.setExternalOrderNumber(externalOrderNumber);
		orderModel.setIsComment(0);
		orderModel.setModifyTime(nowDate);
		orderModel.setModifyUserId(userId);
		orderModel.setUserId(userId);
		orderModel.setPayType(payType);
		orderModel.setCreateTime(nowDate);
		
		//组装订单状态model
		orderStatusModel.setOrderStatusTime(nowDate);
		orderStatusModel.setOperator(orderModel.getUserId().intValue());
	}
	
	/**
	 * 根据用户id 查询用户选择购买的商品
	 * @param userId 用户id
	 * @return
	 */
	public List<SkuShopCartVo> querySkuShopCartVoList(Long userId) throws Exception{
		//根据userId查询购物袋选中的商品
		ShopCartAutoExample example = new ShopCartAutoExample();
		example.createCriteria().andUserIdEqualTo(userId)
								.andIsDeletedEqualTo(SUConstants.IS_NOT_DELETE)
								.andIsSelectedEqualTo(SUConstants.IS_SELECT);
		//购物袋list
		return shopCartDao.selectSkuShopCartVoByExample(example);
	}
	
	
	/**
	 * 组装购物袋(确认订单页)商品模型
	 * @param shopCartList 购物袋数组
	 * @throws Exception 
	 */
	public void buildSkuShopCart(List<SkuShopCartVo> skuShopCartVoList, Map<String, Object> tempMap) throws Exception{
		//规格字符串map
		Map<String, Object> speciMap = new HashMap<String, Object>();
		//产品图片map
		Map<String,Object> productPicMap = new HashMap<String, Object>();
		//总价格
		BigDecimal totalPrice = new BigDecimal(0);
		//遍历商品
		for (int i = 0; i < skuShopCartVoList.size(); i++) {
			//封装购物袋商品信息
			shopCartservice.buildProductVo(skuShopCartVoList.get(i), speciMap, productPicMap,1);
			totalPrice = totalPrice.add(skuShopCartVoList.get(i).getPrices().multiply(new BigDecimal(skuShopCartVoList.get(i).getProductCount())));
		}
		tempMap.put("totalPrice", totalPrice);
		tempMap.put("productList", skuShopCartVoList);
	}
	
	/**
	 * 组装用户地址、电话信息
	 * @param userId 用户id
	 * @param tempMap 存放用户信息map
	 */
	public void buildUserAddr(Long userId, Map<String, Object> tempMap) throws Exception{
		//查询用户默认地址
		UserReceiptAddressVo userReceiptAddressVo = userReceiptAddressService.queryDefaultOrRecommendAddress(userId);
		
		tempMap.put("userReceiptAddress", userReceiptAddressVo);
	}
	
	/**
	 * 组装购买各店铺的邮费及总邮费
	 * @param tempMap 包含用户地址UserReceiptAddressVo模型的map
	 */
	@SuppressWarnings("unchecked")
	public void buildShopAndTotalFreight(Map<String, Object> tempMap) throws Exception{
		//查询总运费和各个店铺运费
		if(tempMap.get("userReceiptAddress") != null || tempMap.get("userReceiptAddress") instanceof UserReceiptAddressVo){
			Map<String, Object> userReceiptAddressMap = freightTemplateService.queryFreightByAddressId((UserReceiptAddressVo) tempMap.get("userReceiptAddress"));
			if("1".equals(userReceiptAddressMap.get(SUConstants.CODE_KEY))){
				Map<String, Object> userReceiptAddressInfoMap = (Map<String, Object>) userReceiptAddressMap.get(SUConstants.INFO_KEY);
				tempMap.put("totalFreight", userReceiptAddressInfoMap.get("totleFreight"));
				if(userReceiptAddressInfoMap.get("shopFreight") != null || userReceiptAddressInfoMap.get("shopFreight") instanceof HashMap){
					tempMap.put("shopFreight", userReceiptAddressInfoMap.get("shopFreight"));
				}
			}else{
				tempMap.put("totalFreight", "");
			}
		}else{
			tempMap.put("totalFreight", "");
		}
	}
	
	
	/** 
	 * 查询购买各店铺的商品总价格、及所有商品总价格
	 * 封装shopCartVo shopFreight店铺邮费属性值
	 * 封装返回tempMap
	 * @param tempMap 存放地址、及返回信息的map
	 * @param shopCartVoList 购物袋业务模型
	 * @param skuShopCartVoGroupMap 购物袋商品分组map
	 * @param userId 用户id
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void buildFreightAndPrice(Map<String, Object> tempMap, List<ShopCartVo> shopCartVoList,
			Map<Long,ShopCartVo> skuShopCartVoGroupMap, Long userId) throws Exception{
		
		BigDecimal productTotalPrice = new BigDecimal(0);
		BigDecimal productTotalActivityPrice = new BigDecimal(0);
		//封装shopCartVo shopFreight店铺邮费属性值
		for (int i = 0; i < shopCartVoList.size(); i++) {
			productTotalPrice = productTotalPrice.add(shopCartVoList.get(i).getShopSelectedProductPrice());
			productTotalActivityPrice = productTotalActivityPrice.add(shopCartVoList.get(i).getShopSelectedTotalActivityPrice());
			
			if(tempMap.get("shopFreight") != null){
				shopCartVoList.get(i).setShopFreight(((Map<Long,Object>)tempMap.get("shopFreight")).get(shopCartVoList.get(i).getShopId())==null?0:(double) ((Map<Long,Object>)tempMap.get("shopFreight")).get(shopCartVoList.get(i).getShopId()));
			}
		}
		if(tempMap.get("shopFreight") != null){
			tempMap.remove("shopFreight");
		}
		//购买商品总价格(原价)
		tempMap.put("productTotalPrice", productTotalPrice);
		//购买商品总价格(活动价)
		tempMap.put("productTotalActivityPrice", productTotalActivityPrice);
		//商品模型
		tempMap.put("shopCartVoList", shopCartVoList);
	}
	
	/**
	 * 更新订单状态、维护订单流水表
	 */
	private Map<String, Object> updateOrder(OrderAuto orderModel, String msg, 
			Long loginUserId, Long pushUserId,boolean flag,String orderNumber) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		orderModel.setModifyUserId(loginUserId);
		int i = orderDao.updateByPrimaryKeySelective(orderModel);
		if(i <= 0){
			throw new MyException(msg+"失败");
		}
		OrderStatusAuto orderStatusAuto = new OrderStatusAuto();
		orderStatusAuto.setOrderId(orderModel.getOrderId());
		orderStatusAuto.setOperator(loginUserId.intValue());
		orderStatusAuto.setOrderStatusItemId(orderModel.getOrderStatus());
		orderStatusAuto.setOrderStatusTime(orderModel.getModifyTime());
		i = 0;
		i = orderStatusDao.insert(orderStatusAuto);
		if(i <= 0){
			throw new MyException(msg+"失败");
		}
		resMap.putAll(CommonResponseUtils.successResponse());
		if(flag && orderModel.getOrderStatus().intValue() == SUConstants.ORDER_STATUS_THREE){
			pushOrderMessage(pushUserId, orderModel.getOrderId().toString(),  8, 
					orderModel.getOrderStatus().toString(), "您的订单号为："+orderNumber+"的订单,"+SUConstants.ORDER_STATUS_MAP.get(orderModel.getOrderStatus()));
		}
		
		return resMap;
	}
	
	
	
	/**
	 * 取消订单
	 */
	private Map<String, Object> cancelOrder(OrderAuto orderModel, Long loginUserId, Long pushUerId, String orderNumber) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		updateOrder(orderModel, "取消订单", loginUserId, pushUerId, false,orderNumber);
		OrderProductAuto orderProductAuto = new OrderProductAuto();
		orderProductAuto.setOrderId(orderModel.getOrderId());
		List<OrderProductAuto> orderProductAutos = orderProductDao.selectForList(orderProductAuto);
		
		for (OrderProductAuto tempOrderProductAuto : orderProductAutos) {
			int i = 0;
			ProductSkuAuto productSkuAuto = productSkuDao.selectByPrimaryKey(tempOrderProductAuto.getProductskuId());
			if(productSkuAuto == null){
				continue;
			}
			productSkuAuto.setProductskuId(tempOrderProductAuto.getProductskuId());
			productSkuAuto.setProductskuCount(productSkuAuto.getProductskuCount()+tempOrderProductAuto.getProductCount());
			i = productSkuDao.updateByPrimaryKeySelective(productSkuAuto);
			if(i <= 0){
				logger.info("取消订单失败,释放商品库存失败");
				throw new MyException("取消订单失败");
			}
			ProductAuto productAuto = productDao.selectByProductId(productSkuAuto.getProductId());
			productAuto.setStock(productAuto.getStock()+tempOrderProductAuto.getProductCount());
			i = productDao.updateByPrimaryKeySelective(productAuto);
			if(i <= 0){
				logger.info("取消订单失败,释放商品库存失败");
				throw new MyException("取消订单失败");
			}
		}
		
		resMap.putAll(CommonResponseUtils.successResponse());
//		pushOrderMessage(pushUerId, orderModel.getOrderId().toString(),  8, 
//				orderModel.getOrderStatus().toString(), "订单已取消");
		
		return resMap;
	}
	
	
	/**
	 * 订单推送消息(除发货)
	 * @param userId
	 * @param orderId
	 * @param orderStatus
	 */
	@Override
	public void pushOrderMessage(Long userId,String orderId,int pushTypeId,String orderStatus,String msg){
		
		String nowDate = TmDateUtil.getTimeStamp();
		PlatformPushMsgRequestVo pushMsgAuto = new PlatformPushMsgRequestVo();
		pushMsgAuto.setUserId(userId);
		pushMsgAuto.setCreateTime(nowDate);
		pushMsgAuto.setCreateUserId(userId);
		pushMsgAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
		pushMsgAuto.setMainId(orderId);
		pushMsgAuto.setModifyTime(nowDate);
		pushMsgAuto.setModifyUserId(userId);
		pushMsgAuto.setMsgContent(msg);
		pushMsgAuto.setPushTime(nowDate);
		pushMsgAuto.setPushTypeId(pushTypeId);
		pushMsgAuto.setSecondId(orderStatus);
		pushMsgAuto.setPushStrategy(1);
		pushMsgAuto.setThreeId(orderStatus);
		
		pushMsgService.saveUserPushMsg(pushMsgAuto);
	}
	
	/**
	 * 订单推送消息(除发货)
	 * @param userId
	 * @param orderId
	 * @param orderStatus
	 */
	@Override
	public void pushDeliverOrderMessage(Long userId,String orderId,int pushTypeId,
			String orderStatus,String msg,String logisticsNo,String logisticsCompany){
		
		String nowDate = TmDateUtil.getTimeStamp();
		PlatformPushMsgRequestVo pushMsgAuto = new PlatformPushMsgRequestVo();
		pushMsgAuto.setUserId(userId);
		pushMsgAuto.setCreateTime(nowDate);
		pushMsgAuto.setCreateUserId(userId);
		pushMsgAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
		pushMsgAuto.setMainId(orderId);
		pushMsgAuto.setModifyTime(nowDate);
		pushMsgAuto.setModifyUserId(userId);
		pushMsgAuto.setMsgContent(msg);
		pushMsgAuto.setPushTime(nowDate);
		pushMsgAuto.setPushTypeId(pushTypeId);
		pushMsgAuto.setSecondId(orderStatus);
		pushMsgAuto.setPushStrategy(1);
		pushMsgAuto.setThreeId(logisticsNo);
		pushMsgAuto.setAttr1(logisticsCompany);
		
		pushMsgService.saveUserPushMsg(pushMsgAuto);
	}

}
