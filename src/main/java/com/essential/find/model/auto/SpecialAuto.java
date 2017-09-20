package com.essential.find.model.auto;

import java.util.Date;

public class SpecialAuto {
    private Long specialId;

    private Long specialGroupId;

    private String specialName;

    private String thumbnailPath;

    private Long readcount;

    private Integer specialType;

    private String videoPath;

    private Integer isvideo;

    private String backgroundPath;

    private String maintitle;

    private String subtitle;

    private String specialContent;

    private String classifyIds;

    private String brandIds;

    private String activiteAddress;

    private Date deadline;

    private String contactUser;

    private String contactPhone;

    private String contactTel;

    private Long createUserId;

    private Date createTime;

    private Long modifyUserId;

    private Date modifyTime;

    private Integer isDelete;

    private String sendTime;

    public Long getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Long specialId) {
        this.specialId = specialId;
    }

    public Long getSpecialGroupId() {
        return specialGroupId;
    }

    public void setSpecialGroupId(Long specialgroupId) {
        this.specialGroupId = specialgroupId;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName == null ? null : specialName.trim();
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath == null ? null : thumbnailPath.trim();
    }

    public Long getReadcount() {
        return readcount;
    }

    public void setReadcount(Long readcount) {
        this.readcount = readcount;
    }

    public Integer getSpecialType() {
        return specialType;
    }

    public void setSpecialType(Integer specialType) {
        this.specialType = specialType;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath == null ? null : videoPath.trim();
    }

    public Integer getIsvideo() {
        return isvideo;
    }

    public void setIsvideo(Integer isvideo) {
        this.isvideo = isvideo;
    }

    public String getBackgroundPath() {
        return backgroundPath;
    }

    public void setBackgroundPath(String backgroundPath) {
        this.backgroundPath = backgroundPath == null ? null : backgroundPath.trim();
    }

    public String getMaintitle() {
        return maintitle;
    }

    public void setMaintitle(String maintitle) {
        this.maintitle = maintitle == null ? null : maintitle.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public String getSpecialContent() {
        return specialContent;
    }

    public void setSpecialContent(String specialContent) {
        this.specialContent = specialContent == null ? null : specialContent.trim();
    }

    public String getClassifyIds() {
        return classifyIds;
    }

    public void setClassifyIds(String classifyIds) {
        this.classifyIds = classifyIds == null ? null : classifyIds.trim();
    }

    public String getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(String brandIds) {
        this.brandIds = brandIds == null ? null : brandIds.trim();
    }

    public String getActiviteAddress() {
        return activiteAddress;
    }

    public void setActiviteAddress(String activiteAddress) {
        this.activiteAddress = activiteAddress == null ? null : activiteAddress.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getContactUser() {
        return contactUser;
    }

    public void setContactUser(String contactUser) {
        this.contactUser = contactUser == null ? null : contactUser.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
    }
}