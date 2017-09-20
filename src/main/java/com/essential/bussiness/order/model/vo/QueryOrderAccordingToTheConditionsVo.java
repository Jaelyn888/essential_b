package com.essential.bussiness.order.model.vo;

import java.util.ArrayList;
import java.util.List;


/**
 * 定时任务根据条件查询返回的订单Vo
 * @author essential-gfs
 *
 */
public class QueryOrderAccordingToTheConditionsVo {
	private List<OrderTaskQueryOrderVo> orderTaskQueryOrderVos = new ArrayList<OrderTaskQueryOrderVo>();

	public List<OrderTaskQueryOrderVo> getOrderTaskQueryOrderVos() {
		return orderTaskQueryOrderVos;
	}

	public void setOrderTaskQueryOrderVos(
			List<OrderTaskQueryOrderVo> orderTaskQueryOrderVos) {
		this.orderTaskQueryOrderVos = orderTaskQueryOrderVos;
	}

}
