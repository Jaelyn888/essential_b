package com.essential.bussiness.address.model.vo;

import java.util.List;

public class CityVo {
	private Long cityId;

	private String name;

	private Long parentId;

	private List<DistrictVo> districtVoList;

	public List<DistrictVo> getDistrictVoList() {
		return districtVoList;
	}

	public void setDistrictVoList(List<DistrictVo> districtVoList) {
		this.districtVoList = districtVoList;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}