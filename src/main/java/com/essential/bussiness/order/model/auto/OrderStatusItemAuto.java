package com.essential.bussiness.order.model.auto;

public class OrderStatusItemAuto {
    private Integer orderStatusItemId;

    private String orderStatusItemName;

    public Integer getOrderStatusItemId() {
        return orderStatusItemId;
    }

    public void setOrderStatusItemId(Integer orderStatusItemId) {
        this.orderStatusItemId = orderStatusItemId;
    }

    public String getOrderStatusItemName() {
        return orderStatusItemName;
    }

    public void setOrderStatusItemName(String orderStatusItemName) {
        this.orderStatusItemName = orderStatusItemName == null ? null : orderStatusItemName.trim();
    }
}