package com.essential.find.model.auto;

import java.util.Date;

public class SpecialActiviteSceneAuto {
    private Long activitesceneId;

    private Long specialId;

    private Date activiteDate;

    private Date activitePeriod;

    private Integer maxjoin;

    private Integer currentjoin;

    private Integer isDelete;

    private Long createUserId;

    private Date createTime;

    private Long modifyUserId;

    private Date modifyTime;

    public Long getActivitesceneId() {
        return activitesceneId;
    }

    public void setActivitesceneId(Long activitesceneId) {
        this.activitesceneId = activitesceneId;
    }

    public Long getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Long specialId) {
        this.specialId = specialId;
    }

    public Date getActiviteDate() {
        return activiteDate;
    }

    public void setActiviteDate(Date activiteDate) {
        this.activiteDate = activiteDate;
    }

    public Date getActivitePeriod() {
        return activitePeriod;
    }

    public void setActivitePeriod(Date activitePeriod) {
        this.activitePeriod = activitePeriod;
    }

    public Integer getMaxjoin() {
        return maxjoin;
    }

    public void setMaxjoin(Integer maxjoin) {
        this.maxjoin = maxjoin;
    }

    public Integer getCurrentjoin() {
        return currentjoin;
    }

    public void setCurrentjoin(Integer currentjoin) {
        this.currentjoin = currentjoin;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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