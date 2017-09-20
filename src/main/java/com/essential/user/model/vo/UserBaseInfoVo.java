package com.essential.user.model.vo;

/**
 * 用户基本信息Vo
 * @author Jaelyn
 *
 */
public class UserBaseInfoVo {
	/*** 用户Id */
    private Long userId;
    /**
     * 用户账户
     */
    private String userName;
    /*** 用户昵称 */
    private String userNickname;
    /*** 头像路径 */
    private String userIcon;
    /*** 等级 */
    private Long userLevelId;

    
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public Long getUserLevelId() {
		return userLevelId;
	}
	public void setUserLevelId(Long userLevelId) {
		this.userLevelId = userLevelId;
	}

}
