package com.essential.bussiness.brand.model.vo;

import com.essential.bussiness.brand.model.auto.BrandAuto;

/**
 * 查询店铺品牌业务Vo
 * @author essential-gfs
 *
 */
public class ShopBrandVo extends BrandAuto {
	private Long shopId;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	
}
