package com.essential.bussiness.order.model.auto;

public class OrderLogisticAuto {
    private Long orderLogisticId;

    private Long orderId;

    private String logisticNumber;

    private String logisticsCompany;

    private String orderLogisticGoods;

    private String createTime;

    private Long createUser;

    private String modifyTime;

    private Long mofifyUser;

    private Integer isDelete;

    private String attr1;

    private String attr2;

    public Long getOrderLogisticId() {
        return orderLogisticId;
    }

    public void setOrderLogisticId(Long orderLogisticId) {
        this.orderLogisticId = orderLogisticId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getLogisticNumber() {
        return logisticNumber;
    }

    public void setLogisticNumber(String logisticNumber) {
        this.logisticNumber = logisticNumber == null ? null : logisticNumber.trim();
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany == null ? null : logisticsCompany.trim();
    }

    public String getOrderLogisticGoods() {
        return orderLogisticGoods;
    }

    public void setOrderLogisticGoods(String orderLogisticGoods) {
        this.orderLogisticGoods = orderLogisticGoods == null ? null : orderLogisticGoods.trim();
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

    public Long getMofifyUser() {
        return mofifyUser;
    }

    public void setMofifyUser(Long mofifyUser) {
        this.mofifyUser = mofifyUser;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1 == null ? null : attr1.trim();
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2 == null ? null : attr2.trim();
    }
}