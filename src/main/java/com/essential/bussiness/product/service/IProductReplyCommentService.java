package com.essential.bussiness.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.essential.bussiness.product.model.vo.ProductReplyVo;
@Service
public interface IProductReplyCommentService {

	/**
	 * 
	 * @param commentId
	 * @return
	 */
	public abstract List<ProductReplyVo> queryReplyVoListByCommentId(Long commentId);

}