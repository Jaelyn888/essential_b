package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;

public class QueryProductPromotionVo {
	
	private  long  productId;
	private long  discountPercent;
	private String  promotionName;
	private String productName;
	private long brandId;
	private  BigDecimal costPrice;
	private long productTypeId;
	private String path;
	private String brandName;
	private long categoryId;
	private String linkFrom;
	private float activePrice;
	public float getActivePrice() {
		return activePrice;
	}
	public void setActivePrice(float activePrice) {
		this.activePrice = activePrice;
	}
	public String getLinkFrom() {
		return linkFrom;
	}
	public void setLinkFrom(String linkFrom) {
		this.linkFrom = linkFrom;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(long discountPercent) {
		this.discountPercent = discountPercent;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getBrandId() {
		return brandId;
	}
	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	public long getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(long productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	
	
	
	
	

}
