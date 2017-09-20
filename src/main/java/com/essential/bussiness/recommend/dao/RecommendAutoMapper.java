package com.essential.bussiness.recommend.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.essential.bussiness.recommend.model.auto.RecommendAuto;
import com.essential.bussiness.recommend.model.auto.RecommendAutoExample;
import com.essential.bussiness.recommend.model.vo.QueryRecommendCarouselVo;
import com.essential.bussiness.recommend.model.vo.QueryRecommendVo;
import com.essential.bussiness.recommend.model.vo.RecommendInputParamVo;
import com.essential.bussiness.recommend.model.vo.RelatedProductVo;

public interface RecommendAutoMapper {
	int countByExample(RecommendAutoExample example);

	int deleteByExample(RecommendAutoExample example);

	int deleteByPrimaryKey(Long recommendId);

	int insert(RecommendAuto record);

	int insertSelective(RecommendAuto record);

	List<RecommendAuto> selectByExample(RecommendAutoExample example);

	RecommendAuto selectByPrimaryKey(Long recommendId);

	int updateByExampleSelective(@Param("record") RecommendAuto record,
			@Param("example") RecommendAutoExample example);

	int updateByExample(@Param("record") RecommendAuto record,
			@Param("example") RecommendAutoExample example);

	int updateByPrimaryKeySelective(RecommendAuto record);

	int updateByPrimaryKey(RecommendAuto record);

	
	int selectBySelectiveCount(QueryRecommendVo record);
	
	List<RecommendAuto> selectBySelective(QueryRecommendVo record);

	// 查询推荐轮播图
	List<QueryRecommendCarouselVo> selectRecommendCarousel();

	// 查询推荐列表
	List<QueryRecommendCarouselVo> selectRecommendListForAPP(RecommendInputParamVo recommendInputParamVo);
	
	//查询推荐相关商品
	List<Map<String, Object>>selectRcommendProduct(Map<String,Object> map);
	
	//查询推荐商品在推荐列表的位置limit6
	List<RelatedProductVo>selectProductListToApp(Map<String,Object> map);
}