package com.essential.bussiness.product.model.vo;

public class CategoryTypeListVo {
	
	 private Long productTypeId;

	    private String productypeName;

	    private Long categoryId;

	    private String createTime;

	    private Long createUser;

	    private String modifyTime;

	    private Long modifyUser;

	    private String keyWord;

	    private Integer isDeleted;
	    private String pic;

	    public String getPic() {
			return pic;
		}

		public void setPic(String pic) {
			this.pic = pic;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		private String categoryName;

	    public Long getProductTypeId() {
	        return productTypeId;
	    }

	    public void setProductTypeId(Long productTypeId) {
	        this.productTypeId = productTypeId;
	    }

	    public String getProductypeName() {
	        return productypeName;
	    }

	    public void setProductypeName(String productypeName) {
	        this.productypeName = productypeName == null ? null : productypeName.trim();
	    }

	    public Long getCategoryId() {
	        return categoryId;
	    }

	    public void setCategoryId(Long categoryId) {
	        this.categoryId = categoryId;
	    }

	    public String getCreateTime() {
	        return createTime;
	    }

	    public void setCreateTime(String createTime) {
	        this.createTime = createTime;
	    }

	    public Long getCreateUser() {
	        return createUser;
	    }

	    public void setCreateUser(Long createUser) {
	        this.createUser = createUser;
	    }

	    public String getModifyTime() {
	        return modifyTime;
	    }

	    public void setModifyTime(String modifyTime) {
	        this.modifyTime = modifyTime;
	    }

	    public Long getModifyUser() {
	        return modifyUser;
	    }

	    public void setModifyUser(Long modifyUser) {
	        this.modifyUser = modifyUser;
	    }

	    public String getKeyWord() {
	        return keyWord;
	    }

	    public void setKeyWord(String keyWord) {
	        this.keyWord = keyWord == null ? null : keyWord.trim();
	    }

	    public Integer getIsDeleted() {
	        return isDeleted;
	    }

	    public void setIsDeleted(Integer isDeleted) {
	        this.isDeleted = isDeleted;
	    }

}
