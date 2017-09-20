package com.essential.logisticscompany.model.vo;

import com.essential.logisticscompany.model.auto.ExpressInformationAuto;

public class ExpressInformationVo extends ExpressInformationAuto {
	// 页数
	private Integer pageIndex;
	// 每页条数
	private Integer pageSize;

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
