package com.essential.find.model.auto;

public class ArticleProductAuto {
    private Long articleproductId;

    private Long articleId;

    private Long productId;

    private Integer isDelete;

    private Long createUserId;

    private String createTime;

    private Long modifyUserId;

    private String modifyTime;

    private Integer isLinkProduct;

    private String var1;

    private String var2;

    private String var3;

    public Long getArticleproductId() {
        return articleproductId;
    }

    public void setArticleproductId(Long articleproductId) {
        this.articleproductId = articleproductId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
        this.createTime = createTime == null ? null : createTime.trim();
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
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public Integer getIsLinkProduct() {
        return isLinkProduct;
    }

    public void setIsLinkProduct(Integer isLinkProduct) {
        this.isLinkProduct = isLinkProduct;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1 == null ? null : var1.trim();
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2 == null ? null : var2.trim();
    }

    public String getVar3() {
        return var3;
    }

    public void setVar3(String var3) {
        this.var3 = var3 == null ? null : var3.trim();
    }
}