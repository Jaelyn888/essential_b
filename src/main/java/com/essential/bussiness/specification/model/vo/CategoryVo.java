package com.essential.bussiness.specification.model.vo;

import java.util.List;

public class CategoryVo {
	
	private String Name;
	private String Id;
	List<SpecificationKeyVoItem> SpecificationKeyVoItemList;
	public List<SpecificationKeyVoItem> getSpecificationKeyVoItemList() {
		return SpecificationKeyVoItemList;
	}
	public void setSpecificationKeyVoItemList(
			List<SpecificationKeyVoItem> specificationKeyVoItemList) {
		SpecificationKeyVoItemList = specificationKeyVoItemList;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	

}
