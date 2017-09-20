package com.essential.bussiness.promotion.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.product.model.vo.ProductAutoAddField;
import com.essential.bussiness.promotion.model.vo.PromotionAutoVo;
import com.essential.bussiness.promotion.model.vo.PromotionEditeProductVo;
import com.essential.bussiness.promotion.model.vo.PromotionProductVo;
import com.essential.bussiness.promotion.model.vo.PromotionRevokeProductVo;
import com.essential.bussiness.promotion.model.vo.PromotionSerchParameter;

@Service
public interface IPromotionAutoService {

	public Map<String, Object> addPromotion(PromotionAutoVo promotionAutoVo);
	
	public Map<String, Object> addPromotionProduct(PromotionAutoVo promotionAutoVo);

	public Map<String, Object> updatePromotionProduct(PromotionAutoVo promotionAutoVo);

	public Map<String, Object> queryPromotionProduct(PromotionEditeProductVo promotionEditeProductVo);

	public Map<String, Object> deletePromotion(Long promotionId, Long loginUser);

	// 查询所有促销活动
	public Map<String, Object> queryAllPromotion(PromotionSerchParameter promotionSerchParameter);

	// 查询未开始的促销活动
	public Map<String, Object> queryNotStartPromotion(Long shopId, int pageIndex, Integer pageSize);

	// 查询进行中的促销活动
	public Map<String, Object> queryStartPromotion(Long shopId, int pageIndex, Integer pageSize);

	// 查询已结束的促销活动
	public Map<String, Object> queryEndPromotion(Long shopId, int pageIndex, Integer pageSize);

	// 促销活动失效
	public Map<String, Object> invalidPromotion(Long promotionId);

	// 编辑促销活动
	 public Map<String, Object> editePromotion(PromotionEditeProductVo promotionEditeProductVo);

	// 查询商品参加的促销活动
	public Map<String, Object> productPromotion(Long productId);
	
	//  编辑活动的设置折扣接口
	public Map<String, Object> setupEditePromotion(PromotionEditeProductVo promotionEditeProductVo);
	
	// 撤销参加活动的商品
	public Map<String, Object> revokePromotionProduct(PromotionRevokeProductVo promotionRevokeProductVo);
	
	// 设置折扣商品列表
	public Map<String, Object> installPromotionProduct(PromotionRevokeProductVo promotionRevokeProductVo);
	
	// 更新商品折扣信息
	public Map<String, Object> updatePromotionProductInfo(PromotionProductVo promotionProductVo);
	
	// 编辑促销活动(新方案的)
	public Map<String, Object> queryPromotion(PromotionEditeProductVo promotionEditeProductVo);
}
