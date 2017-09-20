package com.essential.bussiness.order.model.auto;

public class ReturnRefundOrderPicAuto {
    private Long returnRefundOrderPicId;

    private Long returnRefundOrderId;

    private String pic;

    private String createTime;

    private String modifyTime;

    private Long createUser;

    private Long mofifyUser;

    private Integer isDelete;

    public Long getReturnRefundOrderPicId() {
        return returnRefundOrderPicId;
    }

    public void setReturnRefundOrderPicId(Long returnRefundOrderPicId) {
        this.returnRefundOrderPicId = returnRefundOrderPicId;
    }

    public Long getReturnRefundOrderId() {
        return returnRefundOrderId;
    }

    public void setReturnRefundOrderId(Long returnRefundOrderId) {
        this.returnRefundOrderId = returnRefundOrderId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
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