package com.essential.bussiness.product.model.vo;

import java.util.List;

public class ProductSkuDisplayShopVo {

	// 商品所属店铺id
	private Long shopId;
	// 商品所属店铺名称
	private String shopName;
	// 商店logo
	private String logoPath;
	// 店铺类型id
	private Long shopTypeId;
	// 店铺类型名称
	private String shoptypeName;
	// 商品数组
	private List<ProductSkuDisplayVo> ProductSkuDisplayVos;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public Long getShopTypeId() {
		return shopTypeId;
	}

	public void setShopTypeId(Long shopTypeId) {
		this.shopTypeId = shopTypeId;
	}

	public String getShoptypeName() {
		return shoptypeName;
	}

	public void setShoptypeName(String shoptypeName) {
		this.shoptypeName = shoptypeName;
	}

	public List<ProductSkuDisplayVo> getProductSkuDisplayVos() {
		return ProductSkuDisplayVos;
	}

	public void setProductSkuDisplayVos(
			List<ProductSkuDisplayVo> productSkuDisplayVos) {
		ProductSkuDisplayVos = productSkuDisplayVos;
	}

}
