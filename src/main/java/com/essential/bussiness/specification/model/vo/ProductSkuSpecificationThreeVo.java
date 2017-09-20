package com.essential.bussiness.specification.model.vo;

import java.util.List;

public class ProductSkuSpecificationThreeVo {

	private Long specificationNameId;
	
	private String specificationName;
	
	private List<ProductSkuSpecificationTwoVo> productSkuSpecificationTwoVos;

	public Long getSpecificationNameId() {
		return specificationNameId;
	}

	public void setSpecificationNameId(Long specificationNameId) {
		this.specificationNameId = specificationNameId;
	}

	public String getSpecificationName() {
		return specificationName;
	}

	public void setSpecificationName(String specificationName) {
		this.specificationName = specificationName;
	}

	public List<ProductSkuSpecificationTwoVo> getProductSkuSpecificationTwoVos() {
		return productSkuSpecificationTwoVos;
	}

	public void setProductSkuSpecificationTwoVos(
			List<ProductSkuSpecificationTwoVo> productSkuSpecificationTwoVos) {
		this.productSkuSpecificationTwoVos = productSkuSpecificationTwoVos;
	}
	
}
