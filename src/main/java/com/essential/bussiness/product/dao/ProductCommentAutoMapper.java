package com.essential.bussiness.product.dao;

import java.util.List;

import com.essential.bussiness.order.model.vo.OrderCommentVo;
import com.essential.bussiness.product.model.auto.ProductCommentAuto;
import com.essential.bussiness.product.model.vo.BusinessProductCommentVo;
import com.essential.bussiness.product.model.vo.ProductCommentVo;

public interface ProductCommentAutoMapper {
    int deleteByPrimaryKey(Long commentId);

    int insert(ProductCommentAuto record);

    int insertSelective(ProductCommentAuto record);

    ProductCommentAuto selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(ProductCommentAuto record);

    int updateByPrimaryKey(ProductCommentAuto record);
    
    /**
     * 根据条件查询评论列表
     * @param map
     * @return
     */
    List<ProductCommentVo> queryCommentList(ProductCommentAuto productCommentAuto);
    
    /**
     * 查询推荐的评论
     * @param map
     * @return
     */
    ProductCommentVo queryRecommendComment(ProductCommentAuto record);
    ProductCommentVo queryFirstComment(ProductCommentAuto record);  
    /**
     * 商品评论数
     * @param productId 状态
     * @return
     */
    int queryCommentCount(ProductCommentAuto record);
    
   
    //查询商家评论
    List<BusinessProductCommentVo> queryBusinessProductCommentVoForList(ProductCommentAuto productCommentAuto);
    //查询商家评论总数量
    int queryBusinessProductCommentVoForListCount(ProductCommentAuto productCommentAuto);
    
    int updateByProductIdSelective(ProductCommentAuto record);
    //查看订单评论
    List<OrderCommentVo> queryOrderCommentForList(ProductCommentAuto record);
}