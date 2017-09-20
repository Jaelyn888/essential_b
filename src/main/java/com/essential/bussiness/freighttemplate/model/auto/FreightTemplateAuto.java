package com.essential.bussiness.freighttemplate.model.auto;

import java.math.BigDecimal;

public class FreightTemplateAuto {
    private Long freightId;

    private String name;

    private Long freightGroupId;

    private Integer startNum;

    private BigDecimal startFreightCost;

    private Integer nextNum;

    private BigDecimal nextFreightCost;

    private String addressStr;

    private Long shopId;

    private String createTime;

    private Long createUser;

    private String modifyTime;

    private Long modifyUser;

    private Integer isDelete;

    public Long getFreightId() {
        return freightId;
    }

    public void setFreightId(Long freightId) {
        this.freightId = freightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getFreightGroupId() {
        return freightGroupId;
    }

    public void setFreightGroupId(Long freightGroupId) {
        this.freightGroupId = freightGroupId;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public BigDecimal getStartFreightCost() {
        return startFreightCost;
    }

    public void setStartFreightCost(BigDecimal startFreightCost) {
        this.startFreightCost = startFreightCost;
    }

    public Integer getNextNum() {
        return nextNum;
    }

    public void setNextNum(Integer nextNum) {
        this.nextNum = nextNum;
    }

    public BigDecimal getNextFreightCost() {
        return nextFreightCost;
    }

    public void setNextFreightCost(BigDecimal nextFreightCost) {
        this.nextFreightCost = nextFreightCost;
    }

    public String getAddressStr() {
        return addressStr;
    }

    public void setAddressStr(String addressStr) {
        this.addressStr = addressStr == null ? null : addressStr.trim();
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
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