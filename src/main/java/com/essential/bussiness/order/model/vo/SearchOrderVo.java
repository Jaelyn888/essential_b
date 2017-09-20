package com.essential.bussiness.order.model.vo;

/**
 * 搜索订单返回的结果Vo
 * @author essential-gfs
 *
 */
public class SearchOrderVo {
	private String productName;
	
	private Long orderId;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
}
