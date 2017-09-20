package com.essential.utils;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 功能描述
 * 特殊说明
 *  扩展传入参数
 */

public class ExtendsUsernamePasswordToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 1L;

	private Long userType = null;



	public ExtendsUsernamePasswordToken(String usernameParam, String passwordParam, Long userType) {
		super(usernameParam, passwordParam);
		this.userType = userType;
	}

	public Long getUserType() {
		return userType;
	}
	
	public void setUserType(Long userType) {
		this.userType = userType;
	}

}
