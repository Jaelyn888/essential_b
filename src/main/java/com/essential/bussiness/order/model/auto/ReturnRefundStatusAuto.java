package com.essential.bussiness.order.model.auto;

public class ReturnRefundStatusAuto {
    private Long returnRefundStatusId;

    private Long returnRefundOrderId;

    private String returnRefundStatusTime;

    private Integer operator;

    private Integer returnRefundStatusItemId;

    private String createTime;

    private String modifyTime;

    private Long createUser;

    private Long mofifyUser;

    private Integer isDelete;

    public Long getReturnRefundStatusId() {
        return returnRefundStatusId;
    }

    public void setReturnRefundStatusId(Long returnRefundStatusId) {
        this.returnRefundStatusId = returnRefundStatusId;
    }

    public Long getReturnRefundOrderId() {
        return returnRefundOrderId;
    }

    public void setReturnRefundOrderId(Long returnRefundOrderId) {
        this.returnRefundOrderId = returnRefundOrderId;
    }

    public String getReturnRefundStatusTime() {
        return returnRefundStatusTime;
    }

    public void setReturnRefundStatusTime(String returnRefundStatusTime) {
        this.returnRefundStatusTime = returnRefundStatusTime == null ? null : returnRefundStatusTime.trim();
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Integer getReturnRefundStatusItemId() {
        return returnRefundStatusItemId;
    }

    public void setReturnRefundStatusItemId(Integer returnRefundStatusItemId) {
        this.returnRefundStatusItemId = returnRefundStatusItemId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
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
}