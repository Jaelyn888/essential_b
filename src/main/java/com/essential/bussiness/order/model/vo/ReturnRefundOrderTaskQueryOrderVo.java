package com.essential.bussiness.order.model.vo;

import com.essential.bussiness.order.model.auto.ReturnRefundOrderAuto;

/**
 * 订单定时任务 查询退货退款订单信息Vo
 * @author essential-gfs
 *
 */
public class ReturnRefundOrderTaskQueryOrderVo extends ReturnRefundOrderAuto {
	private String dbNowDateTime;
	
	private Integer updateReturnRefundOrderStatus1;
	
	private String updateReturnRefundOrderStatusStr1;
	
	private Integer updateReturnRefundOrderStatus2;
	
	private String updateReturnRefundOrderStatusStr2;
	
	private Integer updateReturnRefundOrderStatus3;
	
	private String updateReturnRefundOrderStatusStr3;
	
	private Integer queryReturnRefundOrderStatus1;
	
	private Integer queryReturnRefundOrderStatus2;
	
	private Integer queryReturnRefundOrderStatus3;
	
	private Integer limitDateTime;
	
	private Integer subDateTime;
	
	private String queryField;
	
	private Integer returnRefundTimes;

	public String getDbNowDateTime() {
		return dbNowDateTime;
	}

	public void setDbNowDateTime(String dbNowDateTime) {
		this.dbNowDateTime = dbNowDateTime;
	}

	public Integer getUpdateReturnRefundOrderStatus1() {
		return updateReturnRefundOrderStatus1;
	}

	public void setUpdateReturnRefundOrderStatus1(
			Integer updateReturnRefundOrderStatus1) {
		this.updateReturnRefundOrderStatus1 = updateReturnRefundOrderStatus1;
	}

	public String getUpdateReturnRefundOrderStatusStr1() {
		return updateReturnRefundOrderStatusStr1;
	}

	public void setUpdateReturnRefundOrderStatusStr1(
			String updateReturnRefundOrderStatusStr1) {
		this.updateReturnRefundOrderStatusStr1 = updateReturnRefundOrderStatusStr1;
	}

	public Integer getUpdateReturnRefundOrderStatus2() {
		return updateReturnRefundOrderStatus2;
	}

	public void setUpdateReturnRefundOrderStatus2(
			Integer updateReturnRefundOrderStatus2) {
		this.updateReturnRefundOrderStatus2 = updateReturnRefundOrderStatus2;
	}

	public String getUpdateReturnRefundOrderStatusStr2() {
		return updateReturnRefundOrderStatusStr2;
	}

	public void setUpdateReturnRefundOrderStatusStr2(
			String updateReturnRefundOrderStatusStr2) {
		this.updateReturnRefundOrderStatusStr2 = updateReturnRefundOrderStatusStr2;
	}

	public Integer getUpdateReturnRefundOrderStatus3() {
		return updateReturnRefundOrderStatus3;
	}

	public void setUpdateReturnRefundOrderStatus3(
			Integer updateReturnRefundOrderStatus3) {
		this.updateReturnRefundOrderStatus3 = updateReturnRefundOrderStatus3;
	}

	public String getUpdateReturnRefundOrderStatusStr3() {
		return updateReturnRefundOrderStatusStr3;
	}

	public void setUpdateReturnRefundOrderStatusStr3(
			String updateReturnRefundOrderStatusStr3) {
		this.updateReturnRefundOrderStatusStr3 = updateReturnRefundOrderStatusStr3;
	}

	public Integer getQueryReturnRefundOrderStatus1() {
		return queryReturnRefundOrderStatus1;
	}

	public void setQueryReturnRefundOrderStatus1(
			Integer queryReturnRefundOrderStatus1) {
		this.queryReturnRefundOrderStatus1 = queryReturnRefundOrderStatus1;
	}

	public Integer getQueryReturnRefundOrderStatus2() {
		return queryReturnRefundOrderStatus2;
	}

	public void setQueryReturnRefundOrderStatus2(
			Integer queryReturnRefundOrderStatus2) {
		this.queryReturnRefundOrderStatus2 = queryReturnRefundOrderStatus2;
	}

	public Integer getQueryReturnRefundOrderStatus3() {
		return queryReturnRefundOrderStatus3;
	}

	public void setQueryReturnRefundOrderStatus3(
			Integer queryReturnRefundOrderStatus3) {
		this.queryReturnRefundOrderStatus3 = queryReturnRefundOrderStatus3;
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

	public Integer getReturnRefundTimes() {
		return returnRefundTimes;
	}

	public void setReturnRefundTimes(Integer returnRefundTimes) {
		this.returnRefundTimes = returnRefundTimes;
	}

}
