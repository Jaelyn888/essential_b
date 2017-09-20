package com.essential.bussiness.statistics.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrderStatisticsMapper {
	//商家待处理订单   数组索引为0的map数据为：goodsCount-订单待发货、moneyCount-待付款   索引1的map数据为：goodsCount-退货退款订单待退货、moneyCount-待退款
	List<Integer> businessPendingProccessOrders(@Param("shopId") Long shopId);
	
	//商家运营数据   map数据为：todayOrderNumber-今日下单数、todayTransactionAmount-今日成交金额   nearlySevenDaysTransactionAmount-近七日成交金额、nearlyThirtyDaysTransactionAmount-近30日成交金额
	Map<String, Integer> businessOperationData(@Param("shopId") Long shopId);
	
	//平台待处理订单   数组索引为0的map数据为：goodsCount-订单待发货、moneyCount-待付款   索引1的map数据为：goodsCount-退货退款订单待退货、moneyCount-待退款
	List<Integer> platformPendingProccessOrders();
	
	//平台运营数据   map数据为：todayOrderNumber-今日下单数、todayTransactionAmount-今日成交金额   nearlySevenDaysTransactionAmount-近七日成交金额、nearlyThirtyDaysTransactionAmount-近30日成交金额
	Map<String, Integer> platformOperationData();
}
