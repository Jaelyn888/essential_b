package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;

public class QueryProductListVO {
	private long productId;
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getLinkFrom() {
		return linkFrom;
	}
	public void setLinkFrom(int linkFrom) {
		this.linkFrom = linkFrom;
	}
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	public float getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(float discountPrice) {
		this.discountPrice = discountPrice;
	}
	public int getIsDiscount() {
		return isDiscount;
	}
	public void setIsDiscount(int isDiscount) {
		this.isDiscount = isDiscount;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public long getBrandId() {
		return brandId;
	}
	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	public float getActivePrice() {
		return activePrice;
	}
	public void setActivePrice(float activePrice) {
		this.activePrice = activePrice;
	}
	private String path;
	// 商品图

	private String productName;
	// 商品名称

	private int linkFrom;
	// 是否自营

	private BigDecimal costPrice;
	// 原价

	private float discountPrice;
	// 折扣后的价格

	private int isDiscount;
	// 是否打折

	private String brandName;
	// 品牌名称

	private long  brandId;
	// 品牌id
	private long  categoryId;
	// 大分类id
	private long shopId;
	// 店铺id
	private float activePrice;

	// 如果不打折就是原价如果打折就是打折过后的价格

	
}
