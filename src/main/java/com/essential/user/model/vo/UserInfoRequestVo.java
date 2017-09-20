package com.essential.user.model.vo;

import com.essential.user.model.auto.UserBaseInfoAuto;

/**
 * 用户基本信息Vo
 * @author Jaelyn
 *
 */
public class UserInfoRequestVo extends UserBaseInfoAuto{
	
	/**
	 * 请求类型 0：删除，1：修改昵称，2：修改性别，3：修改出生日期，4：所在地，5：简介 6：头像   7：平台禁用启用用    8:更细环信信息
	 */
	private Integer requestType;

	private String newPwd;
	
	//分页页码
    private Integer pageIndex;
    
    //每页大小
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
	public Integer getRequestType() {
		return requestType;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public void setRequestType(Integer requestType) {
		this.requestType = requestType;
	}
	
	
	
}
