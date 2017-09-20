package com.essential.bussiness.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.essential.bussiness.product.model.auto.ProductCommentPicAuto;
import com.essential.bussiness.product.model.vo.ProductCommentPicVo;

@Service
public interface IProductCommentPicService {

	/**
	 * 查询商品评论附件图
	 * @param commentId
	 * @return
	 */
	public  List<ProductCommentPicVo> queryPicVoListByCommentId(long commentId);

	/**
	 * 批量插入图片
	 * @param productCommentPicAutoList
	 * @return
	 */
	public  int insertProductCommentPicList(List<ProductCommentPicAuto> productCommentPicAutoList);

}