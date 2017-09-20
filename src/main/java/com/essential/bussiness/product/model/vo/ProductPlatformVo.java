package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;

import com.essential.bussiness.product.model.auto.ProductAuto;

public class ProductPlatformVo extends ProductAuto {
	// 品牌名称
	private String brandName;
	// 分类名称
	private String categoryName;
	// 店铺名称
	private String shopName;
	// 是否自营名称
	private String selfName;
	// 商品图片路径
	private String path;
	// 商品状态名称
	private String productStatusName;
	// 价格（第一个）
	private BigDecimal firstPrice;
	// 价格（第二个）
	private BigDecimal secondPrice;
	// 活动价格
	private BigDecimal discountPrice; 
	// 活动标签
	private String tag;
	// 0-商品列表，1-强制下架商品列表
	private Integer type;
	// 页数
	private Integer pageIndex;
	// 每页条数
	private Integer pageSize;

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName == null ? null : brandName.trim();
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName == null ? null : categoryName.trim();
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName == null ? null : shopName.trim();
	}

	public String getSelfName() {
		return selfName;
	}

	public void setSelfName(String selfName) {
		this.selfName = selfName == null ? null : selfName.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path == null ? null : path.trim();
	}

	public BigDecimal getFirstPrice() {
		return firstPrice;
	}

	public void setFirstPrice(BigDecimal firstPrice) {
		this.firstPrice = firstPrice;
	}

	public BigDecimal getSecondPrice() {
		return secondPrice;
	}

	public void setSecondPrice(BigDecimal secondPrice) {
		this.secondPrice = secondPrice;
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

	public String getProductStatusName() {
		return productStatusName;
	}

	public void setProductStatusName(String productStatusName) {
		this.productStatusName = productStatusName == null ? null : productStatusName.trim();
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag == null ? null : tag.trim();
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}
}
