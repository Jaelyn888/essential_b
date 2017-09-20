package com.essential.bussiness.product.model.vo;

import java.util.List;

public class ProductPlatformInfoVo {
	// 总页数
	private Integer pageCount;
	// 商品信息List
	private List<ProductPlatformVo> productPlatformList;

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<ProductPlatformVo> getProductPlatformList() {
		return productPlatformList;
	}

	public void setProductPlatformList(List<ProductPlatformVo> productPlatformList) {
		this.productPlatformList = productPlatformList;
	}
}
