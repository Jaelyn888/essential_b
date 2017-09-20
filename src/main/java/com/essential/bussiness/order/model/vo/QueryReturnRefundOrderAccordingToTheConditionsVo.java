package com.essential.bussiness.order.model.vo;

import java.util.ArrayList;
import java.util.List;


/**
 * 定时任务根据条件查询返回的退货退款订单Vo
 * @author essential-gfs
 *
 */
public class QueryReturnRefundOrderAccordingToTheConditionsVo {
	private Integer updateReturnRefundOrderStatus;
	
	private Integer returnRefundTimes;
	
	private List<ReturnRefundOrderTaskQueryOrderVo> returnRefundOrderTaskQueryOrderVos = new ArrayList<ReturnRefundOrderTaskQueryOrderVo>();

	public Integer getUpdateReturnRefundOrderStatus() {
		return updateReturnRefundOrderStatus;
	}

	public void setUpdateReturnRefundOrderStatus(
			Integer updateReturnRefundOrderStatus) {
		this.updateReturnRefundOrderStatus = updateReturnRefundOrderStatus;
	}

	public Integer getReturnRefundTimes() {
		return returnRefundTimes;
	}

	public void setReturnRefundTimes(Integer returnRefundTimes) {
		this.returnRefundTimes = returnRefundTimes;
	}

	public List<ReturnRefundOrderTaskQueryOrderVo> getReturnRefundOrderTaskQueryOrderVos() {
		return returnRefundOrderTaskQueryOrderVos;
	}

	public void setReturnRefundOrderTaskQueryOrderVos(
			List<ReturnRefundOrderTaskQueryOrderVo> returnRefundOrderTaskQueryOrderVos) {
		this.returnRefundOrderTaskQueryOrderVos = returnRefundOrderTaskQueryOrderVos;
	}

}
