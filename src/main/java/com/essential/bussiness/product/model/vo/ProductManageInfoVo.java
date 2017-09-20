package com.essential.bussiness.product.model.vo;

import java.util.List;

public class ProductManageInfoVo {
	// 总页数
	private Integer pageCount;
	// 商品信息List
	private List<ProductManageVo> productManageVoList;

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<ProductManageVo> getProductManageVoList() {
		return productManageVoList;
	}

	public void setProductManageVoList(List<ProductManageVo> productManageVoList) {
		this.productManageVoList = productManageVoList;
	}

}
