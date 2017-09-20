/**
 * 
 */
package com.essential.find.model.vo;

/**
 * @author Jaelyn
 *
 */
public class ArticleGroupVo {

	private Integer articleGroupId;

	private String groupName;

	public Integer getArticleGroupId() {
		return articleGroupId;
	}

	public void setArticleGroupId(Integer articleGroupId) {
		this.articleGroupId = articleGroupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName == null ? null : groupName.trim();
	}

}
