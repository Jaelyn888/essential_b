package com.essential.bussiness.product.model.vo;

import java.util.List;

public class ProductSkuAutoVO {
	/*** 登陆用户 */
	private Long loginUser;
	/*** sku List */
	private List<ProductSkuAutoListVO> productSkuAutoList;
	
	public Long getLoginUser() {
		return loginUser;
	}
	
	public void setLoginUser(Long loginUser) {
		this.loginUser = loginUser;
	}

	public List<ProductSkuAutoListVO> getProductSkuAutoList() {
		return productSkuAutoList;
	}

	public void setProductSkuAutoList(List<ProductSkuAutoListVO> productSkuAutoList) {
		this.productSkuAutoList = productSkuAutoList;
	}
}
