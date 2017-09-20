package com.essential.bussiness.order.controller;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.order.model.auto.OrderAuto;
import com.essential.bussiness.order.model.auto.OrderLogisticAuto;
import com.essential.bussiness.order.model.vo.SubmitOrderVo;
import com.essential.bussiness.order.service.IOrderService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;

/**
 * 购买订单业务
 * @author essential-gfs
 *
 */
@Controller
@RequestMapping(value="buyOrder")
public class BuyOrderController {
	
	private Logger logger = LoggerFactory.getLogger(BuyOrderController.class);
	
	// 装配订单业务service
	@Autowired
	@Qualifier("orderServiceImpl")
	IOrderService orderService;
		

	/**
	 * 新增(提交)订单
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="add")
	@ResponseBody
	public Map<String, Object> saveOrder(@RequestBody SubmitOrderVo submitOrderVo) {
		logger.debug("=========>>>>>>提交订单开始："+TmDateUtil.getTimeStamp());
		if(submitOrderVo.getUserId() == null){
			return CommonResponseUtils.failureResponse("订单提交失败,用户id为空");
		}
		try {
			return orderService.saveOrder(submitOrderVo);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			logger.info("新增订单及订单关系维护失败:"+e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("订单提交失败");
		}
			
		
	}
	
	/**
	 * 确认订单页
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="confirm")
	@ResponseBody
	public Map<String, Object> confirmOrder(Long userId) {
		if(userId == null){
			return CommonResponseUtils.failureResponse("查询确认订单信息失败，用户id为空");
		}
		try {
			return orderService.confirmOrder(userId);
		} catch (Exception e) {
			logger.info("确认订单页，查询购买产品、用户地址或运费信息失败：" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询购买产品、用户地址或运费信息失败");
		}
			
		
	}
	
	
	/**
	 * App取消订单
	 * @param orderId 订单号
	 * @return
	 */
	@RequestMapping(value="cancel")
	@ResponseBody
	public Map<String, Object> cancelOrderForApp(Long orderId, Long loginUserId) {
		if(orderId == null){
			return CommonResponseUtils.failureResponse("订单号不能为空");
		}
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		
		try {
			OrderAuto order = new OrderAuto();
			order.setOrderId(orderId);
			order.setOrderStatus(0);
			order.setModifyTime(TmDateUtil.getTimeStamp());
			order.setModifyUserId(loginUserId);
			
			return orderService.cancelOrderApp(order, loginUserId);
		} catch (Exception e) {
			logger.info("取消订单失败：" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("取消订单失败");
		}
			
		
	}
	
	
	/**
	 * 商家取消订单
	 * @param orderId 订单号
	 * @return
	 */
	@RequestMapping(value="bussiness/cancel")
	@ResponseBody
	public Map<String, Object> cancelOrderForBussiness(Long orderId, Long loginUserId) {
		if(orderId == null){
			return CommonResponseUtils.failureResponse("订单号不能为空");
		}
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		
		try {
			OrderAuto order = new OrderAuto();
			order.setOrderId(orderId);
			order.setOrderStatus(0);
			order.setModifyTime(TmDateUtil.getTimeStamp());
			order.setModifyUserId(loginUserId);
			
			return orderService.cancelOrderBussiness(order, loginUserId);
		} catch (Exception e) {
			logger.info("取消订单失败：" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("取消订单失败");
		}
			
		
	}
	
	
	
	/**
	 * App更新订单状态
	 * @param orderId 订单号
	 * @param orderStatus 订单状态
	 * @return
	 */
	@RequestMapping(value="updateOrderStatus")
	@ResponseBody
	public Map<String, Object> updateOrderForApp(Long orderId, int orderStatus, Long loginUserId) {
		if(orderId == null){
			return CommonResponseUtils.failureResponse("订单号不能为空");
		}
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		
		try {
			OrderAuto order = new OrderAuto();
			order.setOrderId(orderId);
			order.setOrderStatus(orderStatus);
			order.setModifyTime(TmDateUtil.getTimeStamp());
			order.setModifyUserId(loginUserId);
			
			return orderService.updateOrderForApp(order,"维护订单状态",loginUserId);
		} catch (Exception e) {
			logger.info("维护订单状态失败：" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("维护订单状态失败");
		}
			
	}
	
	
	/**
	 * 平台更新订单状态
	 * @param orderId 订单号
	 * @param orderStatus 订单状态
	 * @return
	 */
	@RequestMapping(value="platform/updateOrderStatus")
	@ResponseBody
	public Map<String, Object> updateOrderForPlatform(Long orderId, int orderStatus, Long loginUserId) {
		if(orderId == null){
			return CommonResponseUtils.failureResponse("订单号不能为空");
		}
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		
		try {
			OrderAuto order = new OrderAuto();
			order.setOrderId(orderId);
			order.setOrderStatus(orderStatus);
			order.setModifyTime(TmDateUtil.getTimeStamp());
			order.setModifyUserId(loginUserId);
			
			return orderService.updateOrderForPlatform(order,"维护订单状态",loginUserId);
		} catch (Exception e) {
			logger.info("维护订单状态失败：" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("维护订单状态失败");
		}
			
	}
	
	
	/**
	 * App更新订单信息
	 * @param OrderAuto 订单实体
	 * @return
	 */
	@RequestMapping(value="updateOrder")
	@ResponseBody
	public Map<String, Object> updateOrder(OrderAuto orderAuto, Long loginUserId) {
		if(orderAuto.getOrderId() == null){
			return CommonResponseUtils.failureResponse("订单号不能为空");
		}
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		
		try {
			orderAuto.setModifyTime(TmDateUtil.getTimeStamp());
			orderAuto.setModifyUserId(loginUserId);
			
			return orderService.updateOrderForApp(orderAuto,"维护订单状态",loginUserId);
		} catch (Exception e) {
			logger.info("维护订单状态失败：" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("维护订单状态失败");
		}
			
	}
	
	
	/**
	 * 商家更新订单信息
	 * @param OrderAuto 订单实体
	 * @return
	 */
	@RequestMapping(value="bussiness/updateOrder")
	@ResponseBody
	public Map<String, Object> updateOrderForBussiness(OrderAuto orderAuto, Long loginUserId) {
		if(orderAuto.getOrderId() == null){
			return CommonResponseUtils.failureResponse("订单号不能为空");
		}
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		
		try {
			orderAuto.setModifyTime(TmDateUtil.getTimeStamp());
			orderAuto.setModifyUserId(loginUserId);
			
			return orderService.updateOrderForApp(orderAuto,"维护订单状态",loginUserId);
		} catch (Exception e) {
			logger.info("维护订单状态失败：" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("维护订单状态失败");
		}
			
	}
	
	
	/**
	 * 商家发货
	 * @param orderId 订单id
	 * @param orderStatus 订单状态
	 * @param logisticNumber 物流单号
	 * @param logisticsCompany 物流公司
	 * @return
	 */
	@RequestMapping(value="delivery")
	@ResponseBody
	public Map<String, Object> delivery(Long orderId, String logisticNumber, String consignor, 
			String deliveryTime, String logisticsCompany, Long loginUserId) {
		if(orderId == null || loginUserId == null
				|| StringUtils.isEmpty(logisticNumber)
				|| StringUtils.isEmpty(logisticsCompany)
				|| StringUtils.isEmpty(consignor)
				|| StringUtils.isEmpty(deliveryTime)){
			return CommonResponseUtils.failureResponse("发货请求参数异常，请确认参数");
		}
		
		try {
			String nowDate = TmDateUtil.getTimeStamp();
			
			OrderAuto orderAuto = new OrderAuto();
			orderAuto.setOrderId(orderId);
			orderAuto.setOrderStatus(SUConstants.ORDER_STATUS_THREE);
			orderAuto.setModifyTime(deliveryTime);
			orderAuto.setModifyUserId(loginUserId);
			orderAuto.setAttr2(consignor);
			
			OrderLogisticAuto orderLogisticAuto = new OrderLogisticAuto();
			orderLogisticAuto.setOrderId(orderId);
			orderLogisticAuto.setLogisticNumber(logisticNumber);
			orderLogisticAuto.setLogisticsCompany(logisticsCompany);
			orderLogisticAuto.setCreateTime(nowDate);
			orderLogisticAuto.setCreateUser(loginUserId);
			orderLogisticAuto.setModifyTime(nowDate);
			orderLogisticAuto.setMofifyUser(loginUserId);
			orderLogisticAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			
			return orderService.delivery(orderAuto,orderLogisticAuto,loginUserId);
		} catch (Exception e) {
			logger.info("发货失败：" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("发货失败");
		}
			
	}
	
	
	/**
	 * 确认订单页--查询用户优惠券
	 * @param loginUserId
	 * @return
	 */
	@RequestMapping(value="queryUserCoupon")
	@ResponseBody
	public Map<String, Object> queryUserCoupon(Long loginUserId, Integer queryCouponType,
			BigDecimal orderMoney, Integer pageNo, Integer pageCount) {
		if(loginUserId == null || queryCouponType == null || orderMoney == null){
			return CommonResponseUtils.failureResponse("参数异常，请确认参数");
		}
		if(orderMoney.compareTo(BigDecimal.ZERO) <= 0){
			return CommonResponseUtils.failureResponse("订单金额异常");
		}
		
		try {
			
			return orderService.queryUserCoupon(loginUserId, queryCouponType, orderMoney, pageNo, pageCount);
		} catch (Exception e) {
			logger.info("查询用户可用优惠券失败：" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询可用优惠券失败");
		}
			
	}
	
}
