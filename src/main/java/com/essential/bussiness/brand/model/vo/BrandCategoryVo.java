package com.essential.bussiness.brand.model.vo;

/**
 * 查询品牌商品品类Vo
 * @author essential-gfs
 *
 */
public class BrandCategoryVo {
	private Long categoryId;

    private String categoryName;

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
    
}
