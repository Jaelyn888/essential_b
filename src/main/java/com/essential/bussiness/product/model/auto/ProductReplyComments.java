package com.essential.bussiness.product.model.auto;

public class ProductReplyComments {
    private Long replyId;

    private String commentContent;

    private Long commentId;

    private Long shopId;

    private Long createUser;

    private String createTime;

    private Long modifyUser;

    private String modifyTime;

   

    /**
	 * @return the replyId
	 */
	public Long getReplyId() {
		return replyId;
	}

	/**
	 * @param replyId the replyId to set
	 */
	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}

	public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }
}