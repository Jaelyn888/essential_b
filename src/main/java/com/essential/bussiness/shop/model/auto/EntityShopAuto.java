package com.essential.bussiness.shop.model.auto;

public class EntityShopAuto {
    private Long entityshopId;

    private Long shopId;

    private String entityshopName;

    private String entityshopAddress;

    private String phone;

    private String contractPerson;

    private String detail;

    private String servicesTime;

    private Integer status;

    private String createTime;

    private Long createUser;

    private String modifyTime;

    private Long modifyUser;

    private Integer isDelete;

    public Long getEntityshopId() {
        return entityshopId;
    }

    public void setEntityshopId(Long entityshopId) {
        this.entityshopId = entityshopId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getEntityshopName() {
        return entityshopName;
    }

    public void setEntityshopName(String entityshopName) {
        this.entityshopName = entityshopName == null ? null : entityshopName.trim();
    }

    public String getEntityshopAddress() {
        return entityshopAddress;
    }

    public void setEntityshopAddress(String entityshopAddress) {
        this.entityshopAddress = entityshopAddress == null ? null : entityshopAddress.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getContractPerson() {
        return contractPerson;
    }

    public void setContractPerson(String contractPerson) {
        this.contractPerson = contractPerson == null ? null : contractPerson.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getServicesTime() {
        return servicesTime;
    }

    public void setServicesTime(String servicesTime) {
        this.servicesTime = servicesTime == null ? null : servicesTime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
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
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}