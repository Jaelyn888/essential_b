package com.essential.bussiness.order.model.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 提交订单业务Vo
 * @author essential-gfs
 *
 */
public class SubmitOrderVo {
	private int payType;
	
	private Long userId;
	
	private Long addressId;
	
	private List<OrderShopVo> shopList = new ArrayList<OrderShopVo>();

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public List<OrderShopVo> getShopList() {
		return shopList;
	}

	public void setShopList(List<OrderShopVo> shopList) {
		this.shopList = shopList;
	}
	
}
