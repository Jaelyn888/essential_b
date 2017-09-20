package com.essential.bussiness.recommend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.essential.bussiness.recommend.model.auto.RecommendRelatedProductAuto;
import com.essential.bussiness.recommend.model.auto.RecommendRelatedProductAutoExample;
import com.essential.bussiness.recommend.model.vo.QueryRecommendRelatedProductVo;
import com.essential.bussiness.recommend.model.vo.RecommendRelatedProductVo;

public interface RecommendRelatedProductAutoMapper {
    int countByExample(RecommendRelatedProductAutoExample example);

    int deleteByExample(RecommendRelatedProductAutoExample example);

    int deleteByPrimaryKey(Long recommendRelatedProductId);

    int insert(RecommendRelatedProductAuto record);

    int insertSelective(RecommendRelatedProductAuto record);

    List<RecommendRelatedProductAuto> selectByExample(RecommendRelatedProductAutoExample example);

    RecommendRelatedProductAuto selectByPrimaryKey(Long recommendRelatedProductId);

    int updateByExampleSelective(@Param("record") RecommendRelatedProductAuto record, @Param("example") RecommendRelatedProductAutoExample example);

    int updateByExample(@Param("record") RecommendRelatedProductAuto record, @Param("example") RecommendRelatedProductAutoExample example);

    int updateByPrimaryKeySelective(RecommendRelatedProductAuto record);

    int updateByPrimaryKey(RecommendRelatedProductAuto record);
    
    List<RecommendRelatedProductVo> selectRecommendRelatedProduct(QueryRecommendRelatedProductVo queryRecommendRelatedProductVo);
    
    int selectRecommendRelatedProductCount(QueryRecommendRelatedProductVo queryRecommendRelatedProductVo);
}