package com.essential.bussiness.product.model.vo;

import com.essential.bussiness.product.model.auto.ProductAuto;

public class ProductAutoAddField extends ProductAuto{
	private String path;
	private String brandName;
	private float discountPrice;
	public float getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(float discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(String isDiscount) {
		this.isDiscount = isDiscount;
	}

	private String isDiscount;
	

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	


	
	

}
