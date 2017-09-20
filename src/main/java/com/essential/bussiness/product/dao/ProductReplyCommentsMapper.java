package com.essential.bussiness.product.dao;

import java.util.List;
import java.util.Map;

import com.essential.bussiness.product.model.auto.ProductReplyComments;

public interface ProductReplyCommentsMapper {
	int deleteByPrimaryKey(Long applyId);

	int insert(ProductReplyComments record);

	int insertSelective(ProductReplyComments record);

	ProductReplyComments selectByPrimaryKey(Long applyId);

	int updateByPrimaryKeySelective(ProductReplyComments record);

	int updateByPrimaryKey(ProductReplyComments record);

	List<ProductReplyComments> queryReplyListByCommentId(Long commentId);
}