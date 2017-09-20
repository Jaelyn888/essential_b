package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;

public class ProductManageSerchInfo {
	// 店铺Id
	private Long shopId;
	// 商品名称
	private String productName;
	// 价格
	private BigDecimal firstPrice;
	// 价格
	private BigDecimal secondPrice;
	// 商品代码
	private String articleNumber;
	// 商品品牌
	private Long brandId;
	// 商品分类
	private Long categoryId;
	// 商品状态
	private Integer saleStatus;
	// 类别，0-仓库中，1-已售罄，2-出售中，3-上架的商品列表
	private Integer type;
	// 页码
	private Integer pageIndex;
	// 每页条数
	private Integer pageSize;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
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

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber == null ? null : articleNumber.trim();
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(Integer saleStatus) {
		this.saleStatus = saleStatus;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
