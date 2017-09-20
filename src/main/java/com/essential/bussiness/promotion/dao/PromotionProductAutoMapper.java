package com.essential.bussiness.promotion.dao;

import java.util.List;
import java.util.Map;

import com.essential.bussiness.promotion.model.auto.PromotionProductAuto;
import com.essential.bussiness.promotion.model.vo.PromotionProductInfoVo;

public interface PromotionProductAutoMapper {
	int deleteByPrimaryKey(Long productRomotionId);

	int insert(PromotionProductAuto record);

	int insertSelective(PromotionProductAuto record);

	PromotionProductAuto selectByPrimaryKey(Long productRomotionId);

	int updateByPrimaryKeySelective(PromotionProductAuto record);

	int updateByPrimaryKey(PromotionProductAuto record);

	// 商品参加的促销活动更新
	int updateByPromotionPrimary(PromotionProductAuto record);

	// 促销活动失效
	int updateIsValidate(PromotionProductAuto record);

	// 查询商品
	List<PromotionProductAuto> queryByPrimaryKey(PromotionProductAuto record);

	// 查询商品参加的促销活动
	List<PromotionProductInfoVo> queryProuctPromotion(PromotionProductAuto record);

	// 根据活动Id查询商品
	List<PromotionProductAuto> queryProduct(PromotionProductAuto record);

	List<PromotionProductAuto> queryByProductId(PromotionProductAuto record);
	
	int updateByProductId(PromotionProductAuto record);
	
	int updateByProductIdAndPromotionId(PromotionProductAuto record);
	
	int updateByPromtionId(PromotionProductAuto record);
	
	// 批量撤销活动商品
	int updateIsValidateByProductIdAndPromotionId(Map<String, Object> record);
}