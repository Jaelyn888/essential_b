package com.essential.management.opinon.model.vo;

import java.util.List;

public class OpinonInfoVo {
	// 总条数
	private Integer pageCount;
	// 意见信息List
	List<OpinonAutoVo> opinonList;

	public List<OpinonAutoVo> getOpinonList() {
		return opinonList;
	}

	public void setOpinonList(List<OpinonAutoVo> opinonList) {
		this.opinonList = opinonList;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
}
