package com.essential.bussiness.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.product.model.auto.ProductCommentAuto;
import com.essential.bussiness.product.model.vo.ProductCommentVo;
import com.essential.bussiness.product.model.vo.SaveProductCommentVo;
import com.essential.bussiness.product.model.vo.SetRecommendCommentVo;
@Service
public interface IProductCommentService {

	/**
	 * 根据商品id 获取推荐的评论表， 如果没有推荐，则获取第一条？
	 * 
	 * @param productId
	 * @return
	 */
	public abstract ProductCommentVo queryRecommendComment(ProductCommentAuto productCommentAuto);

	/**
	 * 查询评论数
	 * 
	 * @param productId
	 * @return
	 */
	public abstract int queryCommentCount(ProductCommentAuto record);

	/**
	 * 分页查询评论列表
	 * 
	 * @param requestMap
	 * @return
	 */
	public abstract Map<String, Object> queryCommentList(ProductCommentAuto productCommentAuto);
	
	/**
	 * 保存订单商品评价
	 * @param productCommentVoList
	 * @return
	 */
	public Map<String,Object> saveProductComment(List<SaveProductCommentVo> productCommentVoList);

	/**
	 * 设置默认推荐
	 * @param productCommentAuto
	 * @return
	 */
	public abstract Map<String, Object> setRecommendComment(SetRecommendCommentVo recommendCommentVo);

	/**
	 * 取消推荐设置
	 * @param productCommentAuto
	 * @return
	 */
	public Map<String, Object> cancleRecommendComment(ProductCommentAuto productCommentAuto);

	/**
	 * 
	 * @param productCommentAuto
	 * @return
	 */
	public Map<String, Object> queryCommentListByPage(ProductCommentAuto queryOrderProductCommentVo);

}