package com.essential.find.model.vo;


public class ArticleVo {
	/*** 文章Id */
    private Long articleId;
    /*** 文章名 */
    private String articleName;
    /*** 分组名 */
    private String groupName;
    /*** 大图地址 */
    private String mainPath;
    /*** 浏览数 */
    private Long readcount;
    /*** 文章创建时间 */
    private String createTime;
    
    private String sendTime;
    
    private String authorIcon;
    
    private String author;
    
    
    
	public String getAuthorIcon() {
		return authorIcon;
	}
	public void setAuthoIcon(String authorIcon) {
		this.authorIcon = authorIcon;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
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
	public String getMainPath() {
		return mainPath;
	}
	public void setMainPath(String mainPath) {
		this.mainPath = mainPath;
	}
	public Long getReadcount() {
		return readcount;
	}
	public void setReadcount(Long readcount) {
		this.readcount = readcount;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
