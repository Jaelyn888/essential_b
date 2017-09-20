package com.essential.user.model.vo;


public class UserInfoVo extends UserBaseInfoVo{

	    private Long status;

	    private String userDiscri;

	    private Integer isDelete;

	    private String createTime;
	    
	    private String chatId;

	    private String chatPwd;

	    private String userPhone;

	    private String userEmail;

	    private String birthday;

	    private String provinceName;

	    private Long provinceId;

	    private Integer userSex;

	    private String lastLogintime;

	    private Integer platform;

	    private Integer loginType;

	    private String customPhone;
	    
	    /**
	     * 未读消息数量
	     */
	    private int unReadCount;

	    
		public int getUnReadCount() {
			return unReadCount;
		}

		public void setUnReadCount(int unReadCount) {
			this.unReadCount = unReadCount;
		}

		public Long getStatus() {
			return status;
		}

		public void setStatus(Long status) {
			this.status = status;
		}

		public String getUserDiscri() {
			return userDiscri;
		}

		public void setUserDiscri(String userDiscri) {
			this.userDiscri = userDiscri;
		}

		public Integer getIsDelete() {
			return isDelete;
		}

		public void setIsDelete(Integer isDelete) {
			this.isDelete = isDelete;
		}

		public String getCreateTime() {
			return createTime;
		}

		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}

		public String getChatId() {
			return chatId;
		}

		public void setChatId(String chatId) {
			this.chatId = chatId;
		}

		public String getChatPwd() {
			return chatPwd;
		}

		public void setChatPwd(String chatPwd) {
			this.chatPwd = chatPwd;
		}

	
		public String getUserPhone() {
			return userPhone;
		}

		public void setUserPhone(String userPhone) {
			this.userPhone = userPhone;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}

		public String getBirthday() {
			return birthday;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}

		public String getProvinceName() {
			return provinceName;
		}

		public void setProvinceName(String provinceName) {
			this.provinceName = provinceName;
		}

		public Long getProvinceId() {
			return provinceId;
		}

		public void setProvinceId(Long provinceId) {
			this.provinceId = provinceId;
		}

		public Integer getUserSex() {
			return userSex;
		}

		public void setUserSex(Integer userSex) {
			this.userSex = userSex;
		}

		public String getLastLogintime() {
			return lastLogintime;
		}

		public void setLastLogintime(String lastLogintime) {
			this.lastLogintime = lastLogintime;
		}

		public Integer getPlatform() {
			return platform;
		}

		public void setPlatform(Integer platform) {
			this.platform = platform;
		}

		public Integer getLoginType() {
			return loginType;
		}

		public void setLoginType(Integer loginType) {
			this.loginType = loginType;
		}

		public String getCustomPhone() {
			return customPhone;
		}

		public void setCustomPhone(String customPhone) {
			this.customPhone = customPhone;
		}

	    
}
