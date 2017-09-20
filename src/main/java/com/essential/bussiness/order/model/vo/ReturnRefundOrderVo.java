package com.essential.bussiness.order.model.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.essential.bussiness.order.model.auto.OrderAuto;
import com.essential.bussiness.order.model.auto.OrderProductAuto;

/**
 * 退货退款Vo
 * @author essential-gfs
 *
 */
public class ReturnRefundOrderVo extends OrderAuto {
	private Integer orderStatusItemId;

    private String orderStatusItemName;
    
    private String userNickname;
    
    private String modifyStartTime;
    
    private String modifyEndTime;
    
    private String name;
    
    private int orderProductCount;
    
    private String logoPath;
    
    // 退款退回id
 	private Long returnRefundOrderId;
 	// 退款退货单号
 	private String returnRefundOrderNumber;
 	// 退款退货状态名称
 	private String returnRefundStatusItemName;
 	
 	// 退款退货类型，1：退货，2退款
 	private Integer returnRefundType;
 	// 申请退款退货总金额
 	private BigDecimal refundTotalMoney;
 	// 买家备注
 	private String returnRefundAttr1;
 	// 商家备注
 	private String returnRefundAttr2;
 	
    private List<OrderProductAuto> orderProducts = new ArrayList<OrderProductAuto>();

    private Integer returnRefundLatestStatus;
    
    private String createTime;
    //页码
    private Integer pageNo;
    //每页数量
    private Integer pageCount;
    //总页数
    private Integer totalPageCount;
    
    private String returnRefundReason;

    private String returnRefundRejectReason;
    
    private String logistic;

    private String logisticNumber;
    
    private Integer picIdentity;
    
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
		this.orderStatusItemName = orderStatusItemName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public List<OrderProductAuto> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProductAuto> orderProducts) {
		this.orderProducts = orderProducts;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrderProductCount() {
		return orderProductCount;
	}

	public void setOrderProductCount(int orderProductCount) {
		this.orderProductCount = orderProductCount;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

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

	public Integer getReturnRefundLatestStatus() {
		return returnRefundLatestStatus;
	}

	public void setReturnRefundLatestStatus(Integer returnRefundLatestStatus) {
		this.returnRefundLatestStatus = returnRefundLatestStatus;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public String getReturnRefundReason() {
		return returnRefundReason;
	}

	public void setReturnRefundReason(String returnRefundReason) {
		this.returnRefundReason = returnRefundReason;
	}

	public String getReturnRefundRejectReason() {
		return returnRefundRejectReason;
	}

	public void setReturnRefundRejectReason(String returnRefundRejectReason) {
		this.returnRefundRejectReason = returnRefundRejectReason;
	}

	public String getLogistic() {
		return logistic;
	}

	public void setLogistic(String logistic) {
		this.logistic = logistic;
	}

	public String getLogisticNumber() {
		return logisticNumber;
	}

	public void setLogisticNumber(String logisticNumber) {
		this.logisticNumber = logisticNumber;
	}

	public Integer getPicIdentity() {
		return picIdentity;
	}

	public void setPicIdentity(Integer picIdentity) {
		this.picIdentity = picIdentity;
	}
	
}
