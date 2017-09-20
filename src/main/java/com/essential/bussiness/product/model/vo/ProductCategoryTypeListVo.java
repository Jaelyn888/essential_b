package com.essential.bussiness.product.model.vo;

import java.util.List;

public class ProductCategoryTypeListVo {
	
	private  String  categoryId;
	private  String  categoryName;
	private  String  categoryImgPath;
	public String getCategoryImgPath() {
		return categoryImgPath;
	}
	public void setCategoryImgPath(String categoryImgPath) {
		this.categoryImgPath = categoryImgPath;
	}
	private  String  productType;
	private List<ProductTypeVo> productTypeVoList;
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryNam) {
		this.categoryName = categoryNam;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public List<ProductTypeVo> getProductTypeVoList() {
		return productTypeVoList;
	}
	public void setProductTypeVoList(List<ProductTypeVo> productTypeVoList) {
		this.productTypeVoList = productTypeVoList;
	}
	
	

	 

		 
		 
	 
}
