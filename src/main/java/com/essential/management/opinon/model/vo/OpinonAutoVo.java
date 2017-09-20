package com.essential.management.opinon.model.vo;

import com.essential.management.opinon.model.auto.OpinonAuto;

public class OpinonAutoVo extends OpinonAuto{

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}
}
