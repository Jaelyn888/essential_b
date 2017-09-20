package com.essential.bussiness.product.model.auto;

public class ProductCommentAuto {
    private Long commentId;

    private String commentContent;

    private Long productId;
   
	private String productSpecification;
	/**
	 * 订单id
	 */
	private Long orderId;
	
	/**
	 * 订单商品主键id
	 */
	private Long orderProductId;
	

	private Integer grade;

    private String createTime;

    private String modifyTime;

    private Long createUser;

    private Long modifyUser;

    private Integer isRecommand;

    private Integer status;

    private Integer isDelete;

    private Integer requestType;
    
    private Integer pageSize;
    
    private Integer pageIndex;
    
    private Long shopId;
    
    public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getRequestType() {
		return requestType;
	}

	public void setRequestType(Integer requestType) {
		this.requestType = requestType;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(Long orderProductId) {
		this.orderProductId = orderProductId;
	}

    
    /**
	 * @return the productSpecification
	 */
	public String getProductSpecification() {
		return productSpecification;
	}

	/**
	 * @param productSpecification the productSpecification to set
	 */
	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}

	public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
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

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Integer getIsRecommand() {
        return isRecommand;
    }

    public void setIsRecommand(Integer isRecommand) {
        this.isRecommand = isRecommand;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
}