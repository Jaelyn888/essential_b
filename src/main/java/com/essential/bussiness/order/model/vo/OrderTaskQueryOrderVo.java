package com.essential.bussiness.order.model.vo;

import com.essential.bussiness.order.model.auto.OrderAuto;

/**
 * 订单定时任务 查询订单信息Vo
 * @author essential-gfs
 *
 */
public class OrderTaskQueryOrderVo extends OrderAuto {
	private String dbNowDateTime;
	
	private Integer updateOrderStatus1;
	
	private String updateOrderStatusStr1;
	
	private Integer updateOrderStatus2;
	
	private String updateOrderStatusStr2;
	
	private Integer updateOrderStatus3;
	
	private String updateOrderStatusStr3;
	
	private Integer queryOrderStatus1;
	
	private Integer queryOrderStatus2;
	
	private Integer queryOrderStatus3;
	
	private Integer limitDateTime;
	
	private Integer subDateTime;
	
	private String queryField;

	public String getDbNowDateTime() {
		return dbNowDateTime;
	}

	public void setDbNowDateTime(String dbNowDateTime) {
		this.dbNowDateTime = dbNowDateTime;
	}

	public Integer getUpdateOrderStatus1() {
		return updateOrderStatus1;
	}

	public void setUpdateOrderStatus1(Integer updateOrderStatus1) {
		this.updateOrderStatus1 = updateOrderStatus1;
	}

	public String getUpdateOrderStatusStr1() {
		return updateOrderStatusStr1;
	}

	public void setUpdateOrderStatusStr1(String updateOrderStatusStr1) {
		this.updateOrderStatusStr1 = updateOrderStatusStr1;
	}

	public Integer getUpdateOrderStatus2() {
		return updateOrderStatus2;
	}

	public void setUpdateOrderStatus2(Integer updateOrderStatus2) {
		this.updateOrderStatus2 = updateOrderStatus2;
	}

	public String getUpdateOrderStatusStr2() {
		return updateOrderStatusStr2;
	}

	public void setUpdateOrderStatusStr2(String updateOrderStatusStr2) {
		this.updateOrderStatusStr2 = updateOrderStatusStr2;
	}

	public Integer getUpdateOrderStatus3() {
		return updateOrderStatus3;
	}

	public void setUpdateOrderStatus3(Integer updateOrderStatus3) {
		this.updateOrderStatus3 = updateOrderStatus3;
	}

	public String getUpdateOrderStatusStr3() {
		return updateOrderStatusStr3;
	}

	public void setUpdateOrderStatusStr3(String updateOrderStatusStr3) {
		this.updateOrderStatusStr3 = updateOrderStatusStr3;
	}

	public Integer getQueryOrderStatus1() {
		return queryOrderStatus1;
	}

	public void setQueryOrderStatus1(Integer queryOrderStatus1) {
		this.queryOrderStatus1 = queryOrderStatus1;
	}

	public Integer getQueryOrderStatus2() {
		return queryOrderStatus2;
	}

	public void setQueryOrderStatus2(Integer queryOrderStatus2) {
		this.queryOrderStatus2 = queryOrderStatus2;
	}

	public Integer getQueryOrderStatus3() {
		return queryOrderStatus3;
	}

	public void setQueryOrderStatus3(Integer queryOrderStatus3) {
		this.queryOrderStatus3 = queryOrderStatus3;
	}

	public Integer getLimitDateTime() {
		return limitDateTime;
	}

	public void setLimitDateTime(Integer limitDateTime) {
		this.limitDateTime = limitDateTime;
	}

	public Integer getSubDateTime() {
		return subDateTime;
	}

	public void setSubDateTime(Integer subDateTime) {
		this.subDateTime = subDateTime;
	}

	public String getQueryField() {
		return queryField;
	}

	public void setQueryField(String queryField) {
		this.queryField = queryField;
	}
	
}
