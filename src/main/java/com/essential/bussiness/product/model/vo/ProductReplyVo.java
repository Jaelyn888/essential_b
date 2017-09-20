package com.essential.bussiness.product.model.vo;
/**
 * 商家回复vo
 * @author Jaelyn
 *
 */
public class ProductReplyVo {

    private String commentContent;

    private String createTime;

   

  
	public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

   
}