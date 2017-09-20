package com.essential.bussiness.product.model.vo;


/**
 * 商品评论vo
 * 
 * @author Jaelyn
 *
 */
public class SaveProductCommentVo extends ProductCommentVo {
	
	/**
	 * 订单id
	 */
	private Long orderId;
	
	/**
	 * 订单商品主键id
	 */
	private Long orderProductId;
	
	private Long productId;
	private Long createUser;
	
	private Long shopId;
	
	

    public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
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

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

}