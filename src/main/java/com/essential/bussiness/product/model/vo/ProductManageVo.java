package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;

import com.essential.bussiness.product.model.auto.ProductAuto;

public class ProductManageVo extends ProductSerchInfoVo {
	// 促销活动类型
	private Integer promotionType;
	// 促销活动名称
	private String promotionName;
	// 促销活动标签
	private String tag;
	// 促销价格
	private BigDecimal discountPrice;
	// 驳回原因
	private String rejectReasonContent;
	// 商品状态名称
	private String saleStatusNume;

	public Integer getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(Integer promotionType) {
		this.promotionType = promotionType;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName == null ? null : promotionName.trim();
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag == null ? null : tag.trim();
	}

	public String getRejectReasonContent() {
		return rejectReasonContent;
	}

	public void setRejectReasonContent(String rejectReasonContent) {
		this.rejectReasonContent = rejectReasonContent == null ? null : rejectReasonContent.trim();
	}

	public String getSaleStatusNume() {
		return saleStatusNume;
	}

	public void setSaleStatusNume(String saleStatusNume) {
		this.saleStatusNume = saleStatusNume == null ? null : saleStatusNume.trim();
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}
}
