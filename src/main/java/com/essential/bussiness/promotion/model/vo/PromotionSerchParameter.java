package com.essential.bussiness.promotion.model.vo;

public class PromotionSerchParameter {
	/*** 店铺Id */
	private Long shopId;
	/*** 活动名称 */
	private String promotionName;
	/*** 当前页数 */
	private Integer pageIndex;
	/*** 每页显示条数 */
	private Integer pageSize;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName == null ? null : promotionName.trim();
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
