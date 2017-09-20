package com.essential.bussiness.product.dao;

import java.util.List;
import java.util.Map;

import com.essential.bussiness.product.model.auto.ProductCommentPicAuto;

public interface ProductCommentPicAutoMapper {
    int deleteByPrimaryKey(Long picId);

    int insert(ProductCommentPicAuto record);

    int insertSelective(ProductCommentPicAuto record);

    ProductCommentPicAuto selectByPrimaryKey(Long picId);

    int updateByPrimaryKeySelective(ProductCommentPicAuto record);

    int updateByPrimaryKey(ProductCommentPicAuto record);
    
    /**
     * 根据评论id 查找附件图 空是所有
     * @param commentId
     * @return
     */
    List<ProductCommentPicAuto> queryCommentPicByCommentId(ProductCommentPicAuto record);

	int insertProductCommentPicList(List<ProductCommentPicAuto> productCommentPicAutoList);
}