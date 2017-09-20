package com.essential.bussiness.order.service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.order.model.auto.OrderAuto;
import com.essential.bussiness.order.model.auto.OrderLogisticAuto;
import com.essential.bussiness.order.model.vo.SubmitOrderVo;

/**
 * 订单接口
 * @author essential-gfs
 *
 */
@Service
public interface IOrderService {

	public Map<String,Object> saveOrder(SubmitOrderVo submitOrderVo);
	
	public Map<String,Object> deleteOrder(OrderAuto orderModel, Long loginUserId);
	
	public Map<String,Object> confirmOrder(Long userId);
	
	public Map<String,Object> updateOrderForApp(OrderAuto orderModel, String msg, Long loginUserId);
	
	public Map<String,Object> updateOrderForPlatform(OrderAuto orderModel, String msg, Long loginUserId);
	
	public Map<String, Object> updateOrderPay(OrderAuto orderModel);
	
	public Map<String, Object> cancelOrderApp(OrderAuto orderModel, Long loginUserId);
	
	public Map<String, Object> cancelOrderBussiness(OrderAuto orderModel, Long loginUserId);
	
	public Map<String, Object> cancelOrderPlatform(OrderAuto orderModel, Long loginUserId);
	
	public Map<String, Object> delivery(OrderAuto orderModel, OrderLogisticAuto orderLogisticModel, Long loginUserId);
	
	public void pushOrderMessage(Long userId,String orderId,int pushTypeId,String orderStatus,String msg);
	
	public void pushDeliverOrderMessage(Long userId,String orderId,int pushTypeId,
			String orderStatus,String msg,String logisticsNo,String logisticsCompany);
	
	public Map<String, Object> queryUserCoupon(Long loginUserId, Integer queryCouponType,
			BigDecimal orderMoney, Integer pageNo, Integer pageCount);
}
