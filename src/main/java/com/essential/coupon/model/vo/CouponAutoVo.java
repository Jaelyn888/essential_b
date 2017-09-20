package com.essential.coupon.model.vo;

import java.math.BigDecimal;

public class CouponAutoVo {
	// 优惠券Id
	private Long couponId;
	// 用户Id
	private Long userId;
	// 页数
	private Integer pageIndex;
	// 条数
	private Integer pageSize;
	// 优惠券名称
	private String couponName;
	// 类型
	private Integer type;
	
	// 有效标识--确认订单使用
	private Integer isAvailable;
	
	// 查询优惠券类型标识--确认订单使用
	private Integer queryCouponType;
	
	// 订单金额--确认订单使用
	private BigDecimal orderMoney;

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName == null ? null : couponName.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Integer isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Integer getQueryCouponType() {
		return queryCouponType;
	}

	public void setQueryCouponType(Integer queryCouponType) {
		this.queryCouponType = queryCouponType;
	}

	public BigDecimal getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}

}
