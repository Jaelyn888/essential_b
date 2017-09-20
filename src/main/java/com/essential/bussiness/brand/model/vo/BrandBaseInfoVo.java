package com.essential.bussiness.brand.model.vo;

/**
 * 品牌基本信息
 * 
 * @author Jaelyn
 *
 */
public class BrandBaseInfoVo {

	/**
	 * id
	 */
	private Long brandId;

	/**
	 * 品牌名称
	 */
	private String brandName;

	/**
	 * 品牌logo
	 */
	private String logoPath;

	/**
	 * 品牌短描述
	 */
	private String pageDesc;
	
    /**
     * 创建时间
     */
    private String createTime;
    
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getPageDesc() {
		return pageDesc;
	}

	public void setPageDesc(String pageDesc) {
		this.pageDesc = pageDesc;
	}

}
