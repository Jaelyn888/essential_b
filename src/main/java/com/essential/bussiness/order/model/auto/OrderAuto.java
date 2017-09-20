package com.essential.bussiness.order.model.auto;

import java.math.BigDecimal;

public class OrderAuto {
    private Long orderId;

    private String orderNumber;

    private String payNumber;

    private Integer orderStatus;

    private String buyerNote;

    private BigDecimal totalPrice;

    private String externalOrderNumber;

    private String paySerialNumber;

    private String orderProductId;

    private Long shopId;

    private BigDecimal finalPrice;

    private Integer isDelete;

    private Integer isComment;

    private Long userId;

    private Integer payType;

    private String address;

    private BigDecimal freight;

    private String zipcode;

    private String addresse;

    private String userPhone;

    private String modifyTime;

    private Long modifyUserId;
    
    private Integer returnRefundCount;
    
    private Integer returnRefundIdentification;
    
    private String attr1;
    
    private String attr2;
    
    private String attr3;
    
    private String attr4;
    
    private String createTime;
    
    private BigDecimal couponAmount;
    
    private BigDecimal mainOrderAmount;
    
    private Integer couponFlag;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getPayNumber() {
        return payNumber;
    }

    public void setPayNumber(String payNumber) {
        this.payNumber = payNumber == null ? null : payNumber.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getBuyerNote() {
        return buyerNote;
    }

    public void setBuyerNote(String buyerNote) {
        this.buyerNote = buyerNote == null ? null : buyerNote.trim();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getExternalOrderNumber() {
        return externalOrderNumber;
    }

    public void setExternalOrderNumber(String externalOrderNumber) {
        this.externalOrderNumber = externalOrderNumber == null ? null : externalOrderNumber.trim();
    }

    public String getPaySerialNumber() {
        return paySerialNumber;
    }

    public void setPaySerialNumber(String paySerialNumber) {
        this.paySerialNumber = paySerialNumber == null ? null : paySerialNumber.trim();
    }

    public String getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(String orderProductId) {
        this.orderProductId = orderProductId == null ? null : orderProductId.trim();
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse == null ? null : addresse.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

	public Integer getReturnRefundCount() {
		return returnRefundCount;
	}

	public void setReturnRefundCount(Integer returnRefundCount) {
		this.returnRefundCount = returnRefundCount;
	}

	public Integer getReturnRefundIdentification() {
		return returnRefundIdentification;
	}

	public void setReturnRefundIdentification(Integer returnRefundIdentification) {
		this.returnRefundIdentification = returnRefundIdentification;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	public String getAttr3() {
		return attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	public String getAttr4() {
		return attr4;
	}

	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(BigDecimal couponAmount) {
		this.couponAmount = couponAmount;
	}

	public BigDecimal getMainOrderAmount() {
		return mainOrderAmount;
	}

	public void setMainOrderAmount(BigDecimal mainOrderAmount) {
		this.mainOrderAmount = mainOrderAmount;
	}

	public Integer getCouponFlag() {
		return couponFlag;
	}

	public void setCouponFlag(Integer couponFlag) {
		this.couponFlag = couponFlag;
	}

}