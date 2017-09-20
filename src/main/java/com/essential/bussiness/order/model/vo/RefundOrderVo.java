package com.essential.bussiness.order.model.vo;

import java.math.BigDecimal;

import com.essential.bussiness.product.model.vo.ProductSkuDisplayShopVo;

/**
 * 退款订单业务模型
 * @author essential-gfs
 *
 */
public class RefundOrderVo extends ProductSkuDisplayShopVo {

	private String refunStatusItemName;
	
	private Long refundOrderid;

    private String refundOrderNumber;

    private Long orderId;

    private Integer refundLatestStatus;

    private BigDecimal refundTotalMoney;

    private BigDecimal refundFinalMoney;

    private Long userId;

    private String refundSerialNumber;

    private String refundRejectReason;

    private Long returnOrderId;

    private String modifyTime;

    private String refundReason;

    private String desiredResult;

    private String refundInstructions;

    private Integer picIdentity;

	public String getRefunStatusItemName() {
		return refunStatusItemName;
	}

	public void setRefunStatusItemName(String refunStatusItemName) {
		this.refunStatusItemName = refunStatusItemName;
	}

	public Long getRefundOrderid() {
		return refundOrderid;
	}

	public void setRefundOrderid(Long refundOrderid) {
		this.refundOrderid = refundOrderid;
	}

	public String getRefundOrderNumber() {
		return refundOrderNumber;
	}

	public void setRefundOrderNumber(String refundOrderNumber) {
		this.refundOrderNumber = refundOrderNumber;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getRefundLatestStatus() {
		return refundLatestStatus;
	}

	public void setRefundLatestStatus(Integer refundLatestStatus) {
		this.refundLatestStatus = refundLatestStatus;
	}

	public BigDecimal getRefundTotalMoney() {
		return refundTotalMoney;
	}

	public void setRefundTotalMoney(BigDecimal refundTotalMoney) {
		this.refundTotalMoney = refundTotalMoney;
	}

	public BigDecimal getRefundFinalMoney() {
		return refundFinalMoney;
	}

	public void setRefundFinalMoney(BigDecimal refundFinalMoney) {
		this.refundFinalMoney = refundFinalMoney;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRefundSerialNumber() {
		return refundSerialNumber;
	}

	public void setRefundSerialNumber(String refundSerialNumber) {
		this.refundSerialNumber = refundSerialNumber;
	}

	public String getRefundRejectReason() {
		return refundRejectReason;
	}

	public void setRefundRejectReason(String refundRejectReason) {
		this.refundRejectReason = refundRejectReason;
	}

	public Long getReturnOrderId() {
		return returnOrderId;
	}

	public void setReturnOrderId(Long returnOrderId) {
		this.returnOrderId = returnOrderId;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getDesiredResult() {
		return desiredResult;
	}

	public void setDesiredResult(String desiredResult) {
		this.desiredResult = desiredResult;
	}

	public String getRefundInstructions() {
		return refundInstructions;
	}

	public void setRefundInstructions(String refundInstructions) {
		this.refundInstructions = refundInstructions;
	}

	public Integer getPicIdentity() {
		return picIdentity;
	}

	public void setPicIdentity(Integer picIdentity) {
		this.picIdentity = picIdentity;
	}

}
