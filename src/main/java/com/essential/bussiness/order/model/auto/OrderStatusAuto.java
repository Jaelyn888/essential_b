package com.essential.bussiness.order.model.auto;

public class OrderStatusAuto {
    private Long orderStatusId;

    private Long orderId;

    private String orderStatusTime;

    private Integer operator;

    private Integer orderStatusItemId;

    public Long getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Long orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatusTime() {
        return orderStatusTime;
    }

    public void setOrderStatusTime(String orderStatusTime) {
        this.orderStatusTime = orderStatusTime == null ? null : orderStatusTime.trim();
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Integer getOrderStatusItemId() {
        return orderStatusItemId;
    }

    public void setOrderStatusItemId(Integer orderStatusItemId) {
        this.orderStatusItemId = orderStatusItemId;
    }
}