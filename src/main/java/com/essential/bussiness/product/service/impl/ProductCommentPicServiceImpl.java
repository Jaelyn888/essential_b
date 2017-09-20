package com.essential.bussiness.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.dao.ProductCommentPicAutoMapper;
import com.essential.bussiness.product.model.auto.ProductCommentPicAuto;
import com.essential.bussiness.product.model.vo.ProductCommentPicVo;
import com.essential.bussiness.product.service.IProductCommentPicService;
import com.essential.common.constants.SUConstants;
import com.essential.utils.DTOUtils;

/**
 * 
 * @author Jaelyn
 *
 */
@Service
public class ProductCommentPicServiceImpl implements IProductCommentPicService {

	@Autowired
	private ProductCommentPicAutoMapper commentPicAutoMapper;
	
	/**
	 * 查询商品评论附件图
	 * @param commentId
	 * @return
	 */
	@Override
	public List<ProductCommentPicVo> queryPicVoListByCommentId(long commentId){
		ProductCommentPicAuto productCommentPicAuto = new ProductCommentPicAuto();
		productCommentPicAuto.setCommitId(commentId);
		productCommentPicAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
		List<ProductCommentPicAuto> commentPicList = commentPicAutoMapper.queryCommentPicByCommentId(productCommentPicAuto);
		List<ProductCommentPicVo> picVoList = new ArrayList<ProductCommentPicVo>();
		if (commentPicList != null && commentPicList.size() > 0) {
			picVoList=DTOUtils.map(commentPicList, ProductCommentPicVo.class);
		}
		return picVoList;
	}

	/**
	 * 批量插入图片
	 * @param productCommentPicAutoList
	 * @return
	 */
	@Override
	public int insertProductCommentPicList(List<ProductCommentPicAuto> productCommentPicAutoList) {
		int num=commentPicAutoMapper.insertProductCommentPicList(productCommentPicAutoList);
		return num;
	}
}
