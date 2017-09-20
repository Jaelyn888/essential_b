package com.essential.bussiness.product.model.auto;

public class ProductPicAuto {
    private Long id;

    private Integer type;

    private String path;

    private Long productId;

    private String createTime;

    private Long createIser;

    private Long modifyUser;

    private String modifyTime;

    private Integer status;

    private Integer mainpic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Long getCreateIser() {
        return createIser;
    }

    public void setCreateIser(Long createIser) {
        this.createIser = createIser;
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMainpic() {
        return mainpic;
    }

    public void setMainpic(Integer mainpic) {
        this.mainpic = mainpic;
    }
}