package com.essential.bussiness.product.model.vo;

public class ProductOrShopCountVo {
	private Long id;
	// 出售中的商品数
	private Integer productInSaleCount;
	// 仓库中的商品数
	private Integer productInStorehouseCount;
	// 已售罄的商品数
	private Integer productSaleOutCount;
	// 商家数
	private Integer shopCount;
	// 用户数
	private Integer userCount;

	public Integer getProductInSaleCount() {
		return productInSaleCount;
	}

	public void setProductInSaleCount(Integer productInSaleCount) {
		this.productInSaleCount = productInSaleCount;
	}

	public Integer getProductInStorehouseCount() {
		return productInStorehouseCount;
	}

	public void setProductInStorehouseCount(Integer productInStorehouseCount) {
		this.productInStorehouseCount = productInStorehouseCount;
	}

	public Integer getProductSaleOutCount() {
		return productSaleOutCount;
	}

	public void setProductSaleOutCount(Integer productSaleOutCount) {
		this.productSaleOutCount = productSaleOutCount;
	}

	public Integer getShopCount() {
		return shopCount;
	}

	public void setShopCount(Integer shopCount) {
		this.shopCount = shopCount;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
