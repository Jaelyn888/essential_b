package com.essential.bussiness.address.model.vo;

import java.util.List;

public class ProvinceVo {
    private Long provinceId;

    private String name;

    private List<CityVo> cityList;
    
    

    public List<CityVo> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityVo> cityList) {
		this.cityList = cityList;
	}

	public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

}