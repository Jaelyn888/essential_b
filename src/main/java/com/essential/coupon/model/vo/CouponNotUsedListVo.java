package com.essential.coupon.model.vo;

import java.util.List;

public class CouponNotUsedListVo {
	private Integer pageCount;
	private List<CouponNotUsedVo> couponList;

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<CouponNotUsedVo> getCouponList() {
		return couponList;
	}

	public void setCouponList(List<CouponNotUsedVo> couponList) {
		this.couponList = couponList;
	}
}
