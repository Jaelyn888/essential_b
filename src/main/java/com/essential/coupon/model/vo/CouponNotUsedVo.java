package com.essential.coupon.model.vo;

import java.math.BigDecimal;

public class CouponNotUsedVo {
	// 优惠券Id
	private Long couponId;

	// 优惠券名称
	private String couponName;

	// 是否显示优惠券名称，0-不显示，1-显示
	private Integer couponIsDisplay;

	// 开始时间
	private String startTime;

	// 结束时间
	private String endTime;

	// 优惠券类别，1-满减送，2-代金券
	private Integer couponType;

	// 满减送活动所满足的最低金额
	private BigDecimal minimumAmount;

	// 优惠金额
	private BigDecimal couponAmount;
	
    private Integer issuingScope;

    private String redeemCode;
	
	private Long loginUser;

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName == null ? null : couponName.trim();
	}

	public Integer getCouponIsDisplay() {
		return couponIsDisplay;
	}

	public void setCouponIsDisplay(Integer couponIsDisplay) {
		this.couponIsDisplay = couponIsDisplay;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime == null ? null : startTime.trim();
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime == null ? null : endTime.trim();
	}

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	public BigDecimal getMinimumAmount() {
		return minimumAmount;
	}

	public void setMinimumAmount(BigDecimal minimumAmount) {
		this.minimumAmount = minimumAmount;
	}

	public BigDecimal getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(BigDecimal couponAmount) {
		this.couponAmount = couponAmount;
	}

	public Long getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Long loginUser) {
		this.loginUser = loginUser;
	}

	public Integer getIssuingScope() {
		return issuingScope;
	}

	public void setIssuingScope(Integer issuingScope) {
		this.issuingScope = issuingScope;
	}

	public String getRedeemCode() {
		return redeemCode;
	}

	public void setRedeemCode(String redeemCode) {
		this.redeemCode = redeemCode == null ? null : redeemCode.trim();
	}
}
