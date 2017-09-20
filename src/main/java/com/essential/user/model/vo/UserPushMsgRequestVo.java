package com.essential.user.model.vo;

import com.essential.user.model.auto.PushMsgAuto;

public class UserPushMsgRequestVo extends PushMsgAuto {
	// 接受用户id
	private Long userId;

	// 每页大小
	private int pageSize;

	// 请求类型
	private int requestType;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getRequestType() {
		return requestType;
	}

	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
