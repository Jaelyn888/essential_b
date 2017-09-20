package com.essential.find.model.auto;


public class ArticleGroupAuto {
    private Long articleGroupId;

    private String groupName;

    private Integer sortlevel;

    private Long createUserId;

    private String createTime;

    private Long modifyUserId;

    private String modifyTime;

    private Integer isDelete;

    public Long getArticleGroupId() {
        return articleGroupId;
    }

    public void setArticleGroupId(Long articleGroupId) {
        this.articleGroupId = articleGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getSortlevel() {
        return sortlevel;
    }

    public void setSortlevel(Integer sortlevel) {
        this.sortlevel = sortlevel;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}