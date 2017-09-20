/**
 * 
 */
package com.essential.find.model.vo;

import com.essential.user.model.vo.UserBaseInfoVo;


/**
 * @author Jaelyn 文章 评论 vo
 */
public class ArticleCommentVo  extends UserBaseInfoVo{

	private Long commentId;

	private String commentContent;

	private Long toUserId;	

	private String createTime;


	/**
	 * 回复人昵称
	 */
	private String toUserNickname;

	/**
	 * @return the toUserName
	 */
	public String getToUserNickname() {
		return toUserNickname;
	}

	/**
	 * @param toUserName
	 *            the toUserName to set
	 */
	public void setToUserNickname(String toUserNickname) {
		this.toUserNickname = toUserNickname;
	}

	/**
	 * @return the commentId
	 */
	public Long getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	/**
	 * @return the commentContent
	 */
	public String getCommentContent() {
		return commentContent;
	}

	/**
	 * @param commentContent the commentContent to set
	 */
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	/**
	 * @return the toUserId
	 */
	public Long getToUserId() {
		return toUserId;
	}

	/**
	 * @param toUserId the toUserId to set
	 */
	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}


	

	/**
	 * @return the sendTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param sendTime the sendTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
