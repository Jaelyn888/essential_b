package com.essential.bussiness.order.model.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 查看订单评价Vo
 * @author essential-gfs
 *
 */
public class QueryOrderCommentVo {
	private Long shopId;

	private String shopName;
	
	private Long orderId;
	
	private String logoPath;
	
	

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	private List<OrderCommentVo> orderCommentVos = new ArrayList<OrderCommentVo>();

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public List<OrderCommentVo> getOrderCommentVos() {
		return orderCommentVos;
	}

	public void setOrderCommentVos(List<OrderCommentVo> orderCommentVos) {
		this.orderCommentVos = orderCommentVos;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
