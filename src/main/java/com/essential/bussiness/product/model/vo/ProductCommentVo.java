package com.essential.bussiness.product.model.vo;

import java.util.List;

import com.essential.user.model.vo.UserBaseInfoVo;

/**
 * 商品评论vo
 * 
 * @author Jaelyn
 *
 */
public class ProductCommentVo extends UserBaseInfoVo {
	private Long commentId;

	private String commentContent;


	private String productSpecification;

	private Integer grade;

	private String createTime;

	private Integer status;
	
    private Integer isRecommand;


	private List<ProductReplyVo> replyList;
	
	private List<ProductCommentPicVo> attachPicList;
	
	
	
	public Integer getIsRecommand() {
		return isRecommand;
	}
	public void setIsRecommand(Integer isRecommand) {
		this.isRecommand = isRecommand;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getProductSpecification() {
		return productSpecification;
	}
	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<ProductReplyVo> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<ProductReplyVo> replyList) {
		this.replyList = replyList;
	}
	public List<ProductCommentPicVo> getAttachPicList() {
		return attachPicList;
	}
	public void setAttachPicList(List<ProductCommentPicVo> attachPicList) {
		this.attachPicList = attachPicList;
	}
	
	
}