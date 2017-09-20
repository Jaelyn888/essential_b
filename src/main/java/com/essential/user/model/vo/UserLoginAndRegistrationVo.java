package com.essential.user.model.vo;

public class UserLoginAndRegistrationVo {
	/*** 用户Id */
	private Long userId;
	/*** 用户名 */
	private String userName;
	/*** 密码 */
	private String userPwd;
	/*** 旧密码 */
	private String userOldPwd;
	/*** 验证码 */
	private String verificationCode;
	/*** 用户级别 */
	private Long userLevelId;
	/*** 用户类别 */
	private Long userTypeId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd == null ? null : userPwd.trim();
	}

	public Long getUserLevelId() {
		return userLevelId;
	}

	public void setUserLevelId(Long userLevelId) {
		this.userLevelId = userLevelId;
	}

	public Long getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode == null ? null : verificationCode.trim();
	}

	public String getUserOldPwd() {
		return userOldPwd;
	}

	public void setUserOldPwd(String userOldPwd) {
		this.userOldPwd = userOldPwd == null ? null : userOldPwd.trim();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
