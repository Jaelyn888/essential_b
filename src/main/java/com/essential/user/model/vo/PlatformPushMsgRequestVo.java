package com.essential.user.model.vo;

import com.essential.user.model.auto.PushMsgAuto;

public class PlatformPushMsgRequestVo extends PushMsgAuto {
	 //接受用户id
    private Long userId;
    //分页页码
    private int pageIndex;
    
    //每页大小
    private int pageSize;
    
    //平台查询推送开始时间
    private String startTime;
    //平台查询推送结束时间
    private String endTime;

    
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

    
    public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
