package com.essential.find.model.vo;

import java.util.List;

import com.essential.user.model.vo.UserBaseInfoVo;

public class ArticleDetailVo {

	private String groupName;

	private String articleName;

	private String thumbnailPath;

	private String articleAbstract;

	private String createTime;

	private int isCollected;

	private String authorIcon;

	private String author;

	public String getAuthorIcon() {
		return authorIcon;
	}

	public void setAuthorIcon(String authorIcon) {
		this.authorIcon = authorIcon;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * 相关商品数量
	 */
	private int relationProductCount;

	/**
	 * 相关人数量
	 */
	private int relationUserCount;

	private List<UserBaseInfoVo> relationUserList;

	public int getRelationUserCount() {
		return relationUserCount;
	}

	public void setRelationUserCount(int relationUserCount) {
		this.relationUserCount = relationUserCount;
	}

	public int getRelationProductCount() {
		return relationProductCount;
	}

	public void setRelationProductCount(int relationProductCount) {
		this.relationProductCount = relationProductCount;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public String getArticleAbstract() {
		return articleAbstract;
	}

	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getIsCollected() {
		return isCollected;
	}

	public void setIsCollected(int isCollected) {
		this.isCollected = isCollected;
	}

	public List<UserBaseInfoVo> getRelationUserList() {
		return relationUserList;
	}

	public void setRelationUserList(List<UserBaseInfoVo> relationUserList) {
		this.relationUserList = relationUserList;
	}

}
