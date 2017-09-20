package com.essential.find.model.vo;

import java.util.Date;

public class SpecialGroupVo {
    private Long specialGroupId;

    private String groupName;

    private Integer isDelete;

    private Integer sortLevel;

    private Long createUserId;

    private Date createTime;

    private Long modifyUserId;

    private Date modifyTime;

    public Long getSpecialGroupId() {
        return specialGroupId;
    }

    public void setSpecialGroupId(Long specialGroupId) {
        this.specialGroupId = specialGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSortlevel() {
        return sortLevel;
    }

    public void setSortlevel(Integer sortlevel) {
        this.sortLevel = sortlevel;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}