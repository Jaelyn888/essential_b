package com.essential.bussiness.specification.model.vo;

import java.util.List;

/**
 * 商品规格业务模型
 * @author cpx
 *
 */
public class ProductSkuSpecificationTwoVo {
	
	private Long specificationNameId;
	
	private String specificationName;
	
	private List<SpecificationValueVo> specificationValueVos;

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

	public List<SpecificationValueVo> getSpecificationValueVos() {
		return specificationValueVos;
	}

	public void setSpecificationValueVos(
			List<SpecificationValueVo> specificationValueVos) {
		this.specificationValueVos = specificationValueVos;
	}
	
}
