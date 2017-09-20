package com.essential.bussiness.statistics.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.statistics.dao.OrderStatisticsMapper;
import com.essential.bussiness.statistics.service.IBuyOrderStatisticsService;
import com.essential.utils.CommonResponseUtils;

/**
 * 购买订单统计service
 * @author essential-gfs
 *
 */
@Service
public class BuyOrderStatisticsServiceImpl implements IBuyOrderStatisticsService {

	//注入订单统计dao
	@Autowired
	OrderStatisticsMapper orderStatisticsDao;
	
	/**
	 * 商家待处理订单统计
	 */
	@Override
	public Map<String, Object> businessPendingProccessOrders(Long shopId) {
		try {
			if(shopId == null){
				return CommonResponseUtils.failureResponse("订单统计失败，店铺id不能为空");
			}
			
			return CommonResponseUtils.successResponse(orderStatisticsDao.businessPendingProccessOrders(shopId));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 商家运营数据
	 */
	@Override
	public Map<String, Object> businessOperationData(Long shopId) {
		try {
			Map<String, Integer> businessOperationDataMap = orderStatisticsDao.businessOperationData(shopId);
			if(businessOperationDataMap.get("todayTransactionAmount") == null){
				businessOperationDataMap.put("todayTransactionAmount",0);
			}
			if(businessOperationDataMap.get("nearlySevenDaysTransactionAmount") == null){
				businessOperationDataMap.put("nearlySevenDaysTransactionAmount",0);
			}
			if(businessOperationDataMap.get("nearlyThirtyDaysTransactionAmount") == null){
				businessOperationDataMap.put("nearlyThirtyDaysTransactionAmount",0);
			}
			return CommonResponseUtils.successResponse(businessOperationDataMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * 平台待处理订单统计
	 */
	@Override
	public Map<String, Object> platformPendingProccessOrders() {
		try {
			return CommonResponseUtils.successResponse(orderStatisticsDao.platformPendingProccessOrders());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 平台运营数据
	 */
	@Override
	public Map<String, Object> platformOperationData() {
		try {
			Map<String, Integer> platformOperationDataMap = orderStatisticsDao.platformOperationData();
			if(platformOperationDataMap.get("todayTransactionAmount") == null){
				platformOperationDataMap.put("todayTransactionAmount",0);
			}
			if(platformOperationDataMap.get("nearlySevenDaysTransactionAmount") == null){
				platformOperationDataMap.put("nearlySevenDaysTransactionAmount",0);
			}
			if(platformOperationDataMap.get("nearlyThirtyDaysTransactionAmount") == null){
				platformOperationDataMap.put("nearlyThirtyDaysTransactionAmount",0);
			}
			return CommonResponseUtils.successResponse(platformOperationDataMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
