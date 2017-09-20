package com.essential.bussiness.statistics.service;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 购买订单统计service接口
 * @author essential-gfs
 *
 */
@Service
public interface IBuyOrderStatisticsService {
	//商家待处理订单统计
	public Map<String, Object> businessPendingProccessOrders(Long shopId);
	
	//商家运营数据
	public Map<String, Object> businessOperationData(Long shopId);
	
	//平台待处理订单统计
	public Map<String, Object> platformPendingProccessOrders();
	
	//平台运营数据
	public Map<String, Object> platformOperationData();
}
