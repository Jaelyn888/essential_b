package com.essential.bussiness.order.model.auto;

public class ReturnRefundStatusItemAuto {
    private Integer returnRefundStatusItemId;

    private String returnRefundStatusItemName;

    private String createTime;

    private String modifyTime;

    private Long createUser;

    private Long mofifyUser;

    private Integer isDelete;

    public Integer getReturnRefundStatusItemId() {
        return returnRefundStatusItemId;
    }

    public void setReturnRefundStatusItemId(Integer returnRefundStatusItemId) {
        this.returnRefundStatusItemId = returnRefundStatusItemId;
    }

    public String getReturnRefundStatusItemName() {
        return returnRefundStatusItemName;
    }

    public void setReturnRefundStatusItemName(String returnRefundStatusItemName) {
        this.returnRefundStatusItemName = returnRefundStatusItemName == null ? null : returnRefundStatusItemName.trim();
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