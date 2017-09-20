package com.essential.bussiness.shop.model.vo;

import com.essential.bussiness.shop.model.auto.ShopAuto;

public class ShopInformationPlatformVo extends ShopAuto {
	// 审核状态
	private Integer checkStatus;
	// 审核状态名称
	private String checkStatusName;
	// 店铺状态
	private Integer shopStatus;
	// 店铺状态名称
	private String shopStatusName;
	// 驳回原因
	private String rejectReason;
	// 联系人手机
	private String contactPhone;
	// 当前页数
	private Integer pageIndex;
	// 页面条数
	private Integer pageSize;

	public Integer getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Integer getShopStatus() {
		return shopStatus;
	}

	public void setShopStatus(Integer shopStatus) {
		this.shopStatus = shopStatus;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason == null ? null : rejectReason.trim();
	}

	public String getCheckStatusName() {
		return checkStatusName;
	}

	public void setCheckStatusName(String checkStatusName) {
		this.checkStatusName = checkStatusName == null ? null : checkStatusName.trim();
	}

	public String getShopStatusName() {
		return shopStatusName;
	}

	public void setShopStatusName(String shopStatusName) {
		this.shopStatusName = shopStatusName == null ? null : shopStatusName.trim();
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone == null ? null : contactPhone.trim();
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
}
