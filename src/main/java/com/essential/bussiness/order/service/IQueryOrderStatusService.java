package com.essential.bussiness.order.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.order.model.auto.OrderStatusAuto;
import com.essential.bussiness.order.model.vo.ReturnRefundOrderStatusVo;

/**
 * 查询订单状态流水service接口
 * @author essential-gfs
 *
 */
@Service
public interface IQueryOrderStatusService {
	
	public Map<String, Object> queryReturnRefundOrderStatusForList(ReturnRefundOrderStatusVo returnRefundOrderStatusVo);
	
	public Map<String, Object> queryOrderStatusForList(OrderStatusAuto orderStatusAuto);
	
}
