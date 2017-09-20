package com.essential.bussiness.shop.model.vo;

public class ShopAuditingVo {
	// 店铺Id
	private Long shopId;

	// 店铺审核状态，0-待审核，1-已审核，2-已驳回
	private Integer checkStatus;

	// 驳回原因
	private String rejectReason;

	// 登录用户Id
	private Long logenUser;
	
	// 类别，0-通过，1-驳回
	private Integer type;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Integer getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason == null ? null : rejectReason.trim();
	}

	public Long getLogenUser() {
		return logenUser;
	}

	public void setLogenUser(Long logenUser) {
		this.logenUser = logenUser;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
