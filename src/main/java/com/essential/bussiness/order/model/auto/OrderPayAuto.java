package com.essential.bussiness.order.model.auto;

public class OrderPayAuto {
    private Long orderPayId;

    private Long orderId;

    private String orderTradeNumber;

    private Integer payType;

    private String createTime;

    private Long createUser;

    private String modifyTime;

    private Long mofifyUser;

    private Integer isDelete;

    private String attr1;

    private String attr2;

    public Long getOrderPayId() {
        return orderPayId;
    }

    public void setOrderPayId(Long orderPayId) {
        this.orderPayId = orderPayId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderTradeNumber() {
        return orderTradeNumber;
    }

    public void setOrderTradeNumber(String orderTradeNumber) {
        this.orderTradeNumber = orderTradeNumber;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
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