package com.essential.bussiness.order.dao;

import java.util.List;

import com.essential.bussiness.order.model.vo.OrderTaskQueryOrderVo;
import com.essential.bussiness.order.model.vo.QueryOrderAccordingToTheConditionsVo;
import com.essential.bussiness.order.model.vo.QueryReturnRefundOrderAccordingToTheConditionsVo;
import com.essential.bussiness.order.model.vo.ReturnRefundOrderTaskQueryOrderVo;

/**
 * 订单定时任务mapper
 * @author essential-gfs
 *
 */
public interface OrderTaskMapper {
	// 根据条件查询订单信息
	List<OrderTaskQueryOrderVo> selectOrderAccordingToTheConditions(OrderTaskQueryOrderVo orderTaskQueryOrderVo);
	
	// 恢复订单Sku商品的库存 未支付 超过72小时取消订单 
	int updateOrderToAddProductCountWhereMoreThanSeventyTwoHour(QueryOrderAccordingToTheConditionsVo recod);
	
	// 恢复订单Spu商品的库存 未支付 超过72小时取消订单 
	int updateProductCountWhereMoreThanSeventyTwoHour(QueryOrderAccordingToTheConditionsVo recod);
	
	// 更新订单状态 未支付 超过72小时取消订单
	int updateOrderToCancleStatusWhereMoreThanSeventyTwoHour(QueryOrderAccordingToTheConditionsVo recod);
	
	// 订单流水表新增一条订单状态改变记录
	int insertOrderStatus(QueryOrderAccordingToTheConditionsVo recod);
	
	// 商家发货之后10天 自动确认收货 订单完成
	int updateOrderToCompleteStatusWhereMoreThanTenDay(QueryOrderAccordingToTheConditionsVo recod);

	// 查询买家确认收货 之后15天 不可售后
	Long[] selectOrderProductToCannotAfterSaleWhereMoreThanTentyFiveDay(QueryOrderAccordingToTheConditionsVo recod);
	
	// 更新买家确认收货 之后15天 不可售后
	int updateOrderProductToCannotAfterSaleWhereMoreThanTentyFiveDay(QueryOrderAccordingToTheConditionsVo recod);
	
	// 根据条件查询退货退款订单信息
	List<ReturnRefundOrderTaskQueryOrderVo> selectReturnRefundOrderAccordingToTheConditions(ReturnRefundOrderTaskQueryOrderVo returnRefundOrderTaskQueryOrderVo);
	
	// 需要商家处理的动作超过10天 自动同意 
	int updateAgreeWhereBusinessNoCheckThanTenDay(QueryReturnRefundOrderAccordingToTheConditionsVo recod);
	
	// 更新需要商家处理的动作超过10天的退货退款订单商品的退货退款状态
	int updateOrderProductReturnRefundStatus(QueryReturnRefundOrderAccordingToTheConditionsVo recod);
	
	// 退货退款订单流水表新增一条订单状态改变记录
	int insertReturnRefundOrderStatus(QueryReturnRefundOrderAccordingToTheConditionsVo recod);
}
