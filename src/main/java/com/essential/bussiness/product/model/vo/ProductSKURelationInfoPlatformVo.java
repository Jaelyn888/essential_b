package com.essential.bussiness.product.model.vo;

public class ProductSKURelationInfoPlatformVo {
	/*** SKU规格 value Id */
	private Long specificationValueId;
	/*** SKU规格 value Name */
	private String valueName;
	/*** SKU规格 key Id */
	private Long specificationKeyId;
	/*** SKU规格 key Name */
	private String keyname;
	/*** 层级 */
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

	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

}
