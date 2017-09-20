package com.essential.find.model.auto;

import java.util.List;

import com.essential.bussiness.product.model.vo.ProductInfoOrLinkProductInfoVo;

public class ArticleAuto {
    private Long articleId;

    private Long articleGroupId;
    
    private String groupName;

    private String articleName;

    private String mainPath;

    private Long readcount;

    private String thumbnailPath;

    private String articleAbstract;

    private String articleContent;
    
    private String authorIcon;
    
    private String author;

    private Long createUserId;

    private String createTime;

    private Long modifyUserId;

    private String modifyTime;

    private Integer isDelete;

    private String sendTime;
    
    /**
     * 相关商品数量
     */
    private Integer relationProductCount;
    
    /**
     * 相关人数量
     */
    private Integer relationUserCount; 
    
    
    
    /**
     * 请求类型
     */
    private int requestType;
    
    private Integer pageSize;
    
    private Integer pageIndex;

	/**
     * 相关人
     */
    private List<ArticleUserAuto> articleUserAutoList;

    /**
     * 相关商品
     */
    private List<ArticleProductAuto> articleProductAutoList;
    
    private List<ProductInfoOrLinkProductInfoVo> productInfoOrLinkProductInfoVos;
    



	public List<ProductInfoOrLinkProductInfoVo> getProductInfoOrLinkProductInfoVos() {
		return productInfoOrLinkProductInfoVos;
	}

	public void setProductInfoOrLinkProductInfoVos(List<ProductInfoOrLinkProductInfoVo> productInfoOrLinkProductInfoVos) {
		this.productInfoOrLinkProductInfoVos = productInfoOrLinkProductInfoVos;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

    
    public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<ArticleProductAuto> getArticleProductAutoList() {
		return articleProductAutoList;
	}

	public void setArticleProductAutoList(List<ArticleProductAuto> articleProductAutoList) {
		this.articleProductAutoList = articleProductAutoList;
	}

	public List<ArticleUserAuto> getArticleUserAutoList() {
		return articleUserAutoList;
	}

	public void setArticleUserAutoList(List<ArticleUserAuto> articleUserAutoList) {
		this.articleUserAutoList = articleUserAutoList;
	}

	public int getRequestType() {
		return requestType;
	}

	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}

	
	
	
	
    public Integer getRelationProductCount() {
		return relationProductCount;
	}

	public void setRelationProductCount(Integer relationProductCount) {
		this.relationProductCount = relationProductCount;
	}

	public Integer getRelationUserCount() {
		return relationUserCount;
	}

	public void setRelationUserCount(Integer relationUserCount) {
		this.relationUserCount = relationUserCount;
	}

	public String getAuthorIcon() {
		return authorIcon;
	}

	public void setAuthorIcon(String authorIcon) {
		this.authorIcon = authorIcon;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getArticleGroupId() {
        return articleGroupId;
    }

    public void setArticleGroupId(Long articleGroupId) {
        this.articleGroupId = articleGroupId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName == null ? null : articleName.trim();
    }

    public String getMainPath() {
        return mainPath;
    }

    public void setMainPath(String mainPath) {
        this.mainPath = mainPath == null ? null : mainPath.trim();
    }

    public Long getReadcount() {
        return readcount;
    }

    public void setReadcount(Long readcount) {
        this.readcount = readcount;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath == null ? null : thumbnailPath.trim();
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract == null ? null : articleAbstract.trim();
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
    }
}