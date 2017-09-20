package com.essential.bussiness.order.service;


import org.springframework.stereotype.Service;

/**
 * 订单相关定时任务service
 * @author essential-gfs
 *
 */
@Service
public interface IOrderTaskService {
	// 未支付 超过72小时取消订单
 	public boolean canleOrderWhereMoreThanSeventyTwoHour();
 	
 	// 商家发货之后10天 自动确认收货 订单完成
 	public boolean completeOrderWhereMoreThanTenDay();
 	
 	// 买家确认收货 之后15天 不可售后
 	public boolean cannotAfterSaleWhereMoreThanTentyFiveDay();
 	
 	//需要商家的处理动作超过10天 自动同意 
 	public boolean agreeWhereBusinessNoCheckThanTenDay();
}
