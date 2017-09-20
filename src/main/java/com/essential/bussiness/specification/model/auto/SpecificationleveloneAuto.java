package com.essential.bussiness.specification.model.auto;

import java.util.Date;

public class SpecificationleveloneAuto {
    private Long specificationId;

    private String levelOneName;

    private String aliasname;

    private Integer isDeleted;

    private String createTime;

    private Long createUser;

    private String modifyTime;

    private Long modifyUser;

    private Integer status;

    private Integer levelTwoIs;

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }

    public String getLevelOneName() {
        return levelOneName;
    }

    public void setLevelOneName(String levelOneName) {
        this.levelOneName = levelOneName == null ? null : levelOneName.trim();
    }

    public String getAliasname() {
        return aliasname;
    }

    public void setAliasname(String aliasname) {
        this.aliasname = aliasname == null ? null : aliasname.trim();
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String string) {
        this.createTime = string;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLevelTwoIs() {
        return levelTwoIs;
    }

    public void setLevelTwoIs(Integer levelTwoIs) {
        this.levelTwoIs = levelTwoIs;
    }
}