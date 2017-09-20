package com.essential.bussiness.order.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.essential.bussiness.order.model.auto.OrderAuto;
import com.essential.bussiness.order.model.auto.OrderProductAuto;

/**
 * 查询订单  订单Vo
 * @author essential-gfs
 *
 */
public class OrderProductVo extends OrderAuto {
	private Integer orderStatusItemId;

    private String orderStatusItemName;
    
    private String userNickname;
    
    private String modifyStartTime;
    
    private String modifyEndTime;
    
    private String name;
    
    private int orderProductCount;
    
    private String logoPath;
    
    //页码
    private Integer pageNo;
    //每页数量
    private Integer pageCount;
    //总页数
    private Integer totalPageCount;
    
    private String logisticNumber;

    private String logistic;
    
    private String productName;
    
    private List<OrderProductAuto> orderProducts = new ArrayList<OrderProductAuto>();

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

	public String getLogisticNumber() {
		return logisticNumber;
	}

	public void setLogisticNumber(String logisticNumber) {
		this.logisticNumber = logisticNumber;
	}

	public String getLogistic() {
		return logistic;
	}

	public void setLogistic(String logistic) {
		this.logistic = logistic;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
