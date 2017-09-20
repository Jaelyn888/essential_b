package com.essential.bussiness.order.model.vo;

import java.math.BigDecimal;

import com.essential.bussiness.order.model.auto.OrderProductAuto;

/**
 * 查询退货退款订单vo
 * 
 * @author essential-gfs
 *
 */
public class ReturnRfundOrderProductVo extends OrderProductAuto {
	// 退款退回id
	private Long returnRefundOrderId;
	// 退款退货单号
	private String returnRefundOrderNumber;
	// 退款退货状态名称
	private String returnRefundStatusItemName;
	// 申请退款退货时间
	private String createTime;
	// 退款退货类型，1：退货，2退款
	private Integer returnRefundType;
	// 申请退款退货总金额
	private BigDecimal refundTotalMoney;
	// 买家备注
	private String returnRefundAttr1;
	// 商家备注
	private String returnRefundAttr2;
	// 买家名称
	private String userNickname;
	// 开始时间
	private String modifyStartTime;
	// 结束时间
	private String modifyEndTime;
	// 订单号
	private String orderNumber;
	// 店铺id
	private Long shopId;
	// userId
	private Long userId;
	// 删除标识
	private Integer isDelete;
	// 订单状态
	private Integer orderStatus;
	// 更新时间
	private String modifyTime;

	public Long getReturnRefundOrderId() {
		return returnRefundOrderId;
	}

	public void setReturnRefundOrderId(Long returnRefundOrderId) {
		this.returnRefundOrderId = returnRefundOrderId;
	}

	public String getReturnRefundOrderNumber() {
		return returnRefundOrderNumber;
	}

	public void setReturnRefundOrderNumber(String returnRefundOrderNumber) {
		this.returnRefundOrderNumber = returnRefundOrderNumber;
	}

	public String getReturnRefundStatusItemName() {
		return returnRefundStatusItemName;
	}

	public void setReturnRefundStatusItemName(String returnRefundStatusItemName) {
		this.returnRefundStatusItemName = returnRefundStatusItemName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getReturnRefundType() {
		return returnRefundType;
	}

	public void setReturnRefundType(Integer returnRefundType) {
		this.returnRefundType = returnRefundType;
	}

	public BigDecimal getRefundTotalMoney() {
		return refundTotalMoney;
	}

	public void setRefundTotalMoney(BigDecimal refundTotalMoney) {
		this.refundTotalMoney = refundTotalMoney;
	}

	public String getReturnRefundAttr1() {
		return returnRefundAttr1;
	}

	public void setReturnRefundAttr1(String returnRefundAttr1) {
		this.returnRefundAttr1 = returnRefundAttr1;
	}

	public String getReturnRefundAttr2() {
		return returnRefundAttr2;
	}

	public void setReturnRefundAttr2(String returnRefundAttr2) {
		this.returnRefundAttr2 = returnRefundAttr2;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getModifyStartTime() {
		return modifyStartTime;
	}

	public void setModifyStartTime(String modifyStartTime) {
		this.modifyStartTime = modifyStartTime;
	}

	public String getModifyEndTime() {
		return modifyEndTime;
	}

	public void setModifyEndTime(String modifyEndTime) {
		this.modifyEndTime = modifyEndTime;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

}
