package com.essential.bussiness.freighttemplate.model.vo;

import java.math.BigDecimal;

/**
 * 运费模板运费信息
 * 
 * @author Jaelyn
 *
 */
public class FreightTemplateVo {
	private Long freightId;

	private String name;

	private Integer startNum;

	private BigDecimal startFreightCost;

	private Integer nextNum;

	private BigDecimal nextFreightCost;

	private String addressStr;

	/**
	 * @return the freightId
	 */
	public Long getFreightId() {
		return freightId;
	}

	/**
	 * @param freightId the freightId to set
	 */
	public void setFreightId(Long freightId) {
		this.freightId = freightId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the startNum
	 */
	public Integer getStartNum() {
		return startNum;
	}

	/**
	 * @param startNum the startNum to set
	 */
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	/**
	 * @return the startFreightCost
	 */
	public BigDecimal getStartFreightCost() {
		return startFreightCost;
	}

	/**
	 * @param startFreightCost the startFreightCost to set
	 */
	public void setStartFreightCost(BigDecimal startFreightCost) {
		this.startFreightCost = startFreightCost;
	}

	/**
	 * @return the nextNum
	 */
	public Integer getNextNum() {
		return nextNum;
	}

	/**
	 * @param nextNum the nextNum to set
	 */
	public void setNextNum(Integer nextNum) {
		this.nextNum = nextNum;
	}

	/**
	 * @return the nextFreightCost
	 */
	public BigDecimal getNextFreightCost() {
		return nextFreightCost;
	}

	/**
	 * @param nextFreightCost the nextFreightCost to set
	 */
	public void setNextFreightCost(BigDecimal nextFreightCost) {
		this.nextFreightCost = nextFreightCost;
	}

	/**
	 * @return the addressStr
	 */
	public String getAddressStr() {
		return addressStr;
	}

	/**
	 * @param addressStr the addressStr to set
	 */
	public void setAddressStr(String addressStr) {
		this.addressStr = addressStr;
	}

	
}
