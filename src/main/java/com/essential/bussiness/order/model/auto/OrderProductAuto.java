package com.essential.bussiness.order.model.auto;

import java.math.BigDecimal;

public class OrderProductAuto {
    private Long orderProductId;

    private Long orderId;

    private Integer productCount;

    private BigDecimal productPrice;

    private String productName;

    private String productPic;

    private Long productId;

    private Integer orderPromotionId;

    private String productSpecification;

    private Long userConponId;
    
    private Integer returnRefundStatus;
    
    private String articleNumber;
    
    private String attr1;
    
    private String attr2;
    
    private String attr3;
    
    private String attr4;
    
    private Long productskuId;
    
    private BigDecimal productActivityPrice;
    
    private Long categoryId;
    
    private String categoryName;
    
    private Long productTypeId;
    
    private String productTypeName;
    
    private Long brandId;
    
    private String brandName;
    
    private BigDecimal productRefundPrice;
    
    private Integer couponFlag;

    public Long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic == null ? null : productPic.trim();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getOrderPromotionId() {
        return orderPromotionId;
    }

    public void setOrderPromotionId(Integer orderPromotionId) {
        this.orderPromotionId = orderPromotionId;
    }

    public String getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(String productSpecification) {
        this.productSpecification = productSpecification == null ? null : productSpecification.trim();
    }

    public Long getUserConponId() {
        return userConponId;
    }

    public void setUserConponId(Long userConponId) {
        this.userConponId = userConponId;
    }

	public Integer getReturnRefundStatus() {
		return returnRefundStatus;
	}

	public void setReturnRefundStatus(Integer returnRefundStatus) {
		this.returnRefundStatus = returnRefundStatus;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
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

	public Long getProductskuId() {
		return productskuId;
	}

	public void setProductskuId(Long productskuId) {
		this.productskuId = productskuId;
	}

	public BigDecimal getProductActivityPrice() {
		return productActivityPrice;
	}

	public void setProductActivityPrice(BigDecimal productActivityPrice) {
		this.productActivityPrice = productActivityPrice;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public BigDecimal getProductRefundPrice() {
		return productRefundPrice;
	}

	public void setProductRefundPrice(BigDecimal productRefundPrice) {
		this.productRefundPrice = productRefundPrice;
	}

	public Integer getCouponFlag() {
		return couponFlag;
	}

	public void setCouponFlag(Integer couponFlag) {
		this.couponFlag = couponFlag;
	}
	
}