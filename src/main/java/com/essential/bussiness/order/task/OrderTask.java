package com.essential.bussiness.order.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.essential.bussiness.order.service.IOrderTaskService;

/**
 * 未支付 超过72小时取消订单定时任务
 * @author essential-gfs
 *
 */
@Component("orderTask")
public class OrderTask {
	private static final Logger logger = LoggerFactory.getLogger(OrderTask.class);

	//注入订单定时任务serivce
	@Autowired
	@Qualifier("orderTaskServiceImpl")
	IOrderTaskService orderTaskService;
	
	/**
	 * 未支付 超过72小时取消订单
	 */
	@Transactional
	public void executeCanleOrder() {
		try {
			logger.info("=========>>>>>>>>>未支付 超过72小时取消订单 定时任务开始");
			orderTaskService.canleOrderWhereMoreThanSeventyTwoHour();
			logger.info("=========>>>>>>>>>未支付 超过72小时取消订单 定时任务结束");
		} catch (Exception e) {
			logger.info("=========>>>>>>>>>未支付 超过72小时取消订单 定时任务异常");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 买家确认收货 之后15天 不可售后
	 */
	@Transactional
	public void executeCannotAfterSale() {
		try {
			logger.info("=========>>>>>>>>>买家确认收货 之后15天 不可售后 定时任务开始");
			orderTaskService.cannotAfterSaleWhereMoreThanTentyFiveDay();
			logger.info("=========>>>>>>>>>买家确认收货 之后15天 不可售后 定时任务结束");
		} catch (Exception e) {
			logger.info("=========>>>>>>>>>买家确认收货 之后15天 不可售后 定时任务异常");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 商家发货之后10天 自动确认收货 订单完成
	 */
	@Transactional
	public void executeCompleteOrder() {
		try {
			logger.info("=========>>>>>>>>>商家发货之后10天 自动确认收货 订单完成 定时任务开始");
			orderTaskService.completeOrderWhereMoreThanTenDay();
			logger.info("=========>>>>>>>>>商家发货之后10天 自动确认收货 订单完成 定时任务结束");
		} catch (Exception e) {
			logger.info("=========>>>>>>>>>商家发货之后10天 自动确认收货 订单完成 定时任务异常");
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 需要商家处理的动作超过10天 自动同意 
	 */
	@Transactional
	public void executeAgreeReturnRefundOrder() {
		try {
			logger.info("=========>>>>>>>>>需要商家处理的动作超过10天 自动同意  定时任务开始");
			orderTaskService.agreeWhereBusinessNoCheckThanTenDay();
			logger.info("=========>>>>>>>>>需要商家处理的动作超过10天 自动同意  定时任务结束");
		} catch (Exception e) {
			logger.info("=========>>>>>>>>>需要商家处理的动作超过10天 自动同意  定时任务异常");
			e.printStackTrace();
		}
		
	}
}
