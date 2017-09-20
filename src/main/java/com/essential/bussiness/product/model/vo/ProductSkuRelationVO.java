package com.essential.bussiness.product.model.vo;

public class ProductSkuRelationVO {
	/*** sku规格 value id  */
	private Long specificationValueId;
	/*** sku规格 key id  */
	private Long specificationKeyId;
	/*** 层级  */
	private Long type;

	public Long getSpecificationValueId() {
		return specificationValueId;
	}

	public void setSpecificationValueId(Long specificationValueId) {
		this.specificationValueId = specificationValueId;
	}

	public Long getSpecificationKeyId() {
		return specificationKeyId;
	}

	public void setSpecificationKeyId(Long specificationKeyId) {
		this.specificationKeyId = specificationKeyId;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}
}
