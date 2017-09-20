package com.essential.bussiness.recommend.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.promotion.model.vo.PromotionProductInfoVo;
import com.essential.bussiness.recommend.model.auto.RecommendAuto;
import com.essential.bussiness.recommend.model.vo.RecommendInputParamVo;

/**
 * 推荐接口
 * @author essential-gfs
 *
 */
@Service
public interface IRecommendService {
	public Map<String, Object> saveRecommend(RecommendAuto recommend,Long[] relatedProducts);
	
	public Map<String, Object> queryRecommend(String recommendTitle,
			Integer status, Long loginUserId, Integer pageNo, Integer pageCount);

	//查询推荐轮播图(app前段)
	public Map<String,Object> queryRecommendCarouselPic();

	
	public Map<String, Object> updateRecommend(RecommendAuto recommend, Long[] relatedProducts);
	
	public Map<String, Object> queryRecommendRelatedProduct(Long recommendId, Integer pageNo, Integer pageCount);
	
	//查询推荐列表（app前段）
	public Map<String,Object> queryRecommendListForApp(RecommendInputParamVo recommendInputParamVo);
	
	//查询推荐详情(app前段)
	public Map<String,Object> queryRecommendDetail(long recommendId,int pageIndex);
	
	public Map<String, Object> updateRecommendAdvertisingPosition(Long recommendId, Integer flag, Integer type);
	
	public Map<String, Object> queryAdvertisingForList(String recommendTitle,
			Integer status, Long loginUserId, Integer pageNo, Integer pageCount);
	
	public PromotionProductInfoVo buildActivityPrice(Long productId) throws Exception;

}
