package com.essential.bussiness.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.dao.ProductReplyCommentsMapper;
import com.essential.bussiness.product.model.auto.ProductReplyComments;
import com.essential.bussiness.product.model.vo.ProductReplyVo;
import com.essential.bussiness.product.service.IProductReplyCommentService;
import com.essential.utils.DTOUtils;
/**
 * 商家回复商品评论
 * @author Jaelyn
 *
 */
@Service
public class ProductReplyCommentServiceImpl implements IProductReplyCommentService {

	@Autowired
	private ProductReplyCommentsMapper replyCommentsMapper;
	
	/* (non-Javadoc)
	 * @see com.essential.bussiness.product.service.impl.IProductReplyCommentService#queryReplyVoListByCommentId(java.lang.Long)
	 */
	@Override
	public List<ProductReplyVo> queryReplyVoListByCommentId(Long commentId){
		List<ProductReplyComments> replyList = replyCommentsMapper.queryReplyListByCommentId(commentId);
		List<ProductReplyVo> replyVoList = new ArrayList<ProductReplyVo>();
		if (replyList != null && replyList.size() > 0) {
			replyVoList=DTOUtils.map(replyList, ProductReplyVo.class);
		}
		return replyVoList;
	}
}
