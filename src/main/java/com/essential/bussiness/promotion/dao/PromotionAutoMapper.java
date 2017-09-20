package com.essential.bussiness.promotion.dao;

import java.util.List;
import java.util.Map;

import com.essential.bussiness.promotion.model.auto.PromotionAuto;
import com.essential.bussiness.promotion.model.vo.PromotionCount;

public interface PromotionAutoMapper {
	int deleteByPrimaryKey(Long promotionId);

	int insert(PromotionAuto record);

	int insertSelective(PromotionAuto record);

	PromotionAuto selectByPrimaryKey(Long promotionId);

	int updateByPrimaryKeySelective(PromotionAuto record);

	int updateByPrimaryKey(PromotionAuto record);

	// 查询所有促销
	List<PromotionAuto> queryByPrimaryKey(Map<String, Object> record);

	// 查询总条数
	PromotionCount queryCount(Map<String, Object> record);

	// 查询活动
	PromotionAuto queryPromotion(PromotionAuto record);
}