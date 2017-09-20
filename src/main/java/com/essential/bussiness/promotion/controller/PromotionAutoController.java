package com.essential.bussiness.promotion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.product.model.vo.ProductAutoAddField;
import com.essential.bussiness.promotion.model.auto.PromotionProductAuto;
import com.essential.bussiness.promotion.model.vo.PromotionAutoVo;
import com.essential.bussiness.promotion.model.vo.PromotionEditeProductVo;
import com.essential.bussiness.promotion.model.vo.PromotionProductVo;
import com.essential.bussiness.promotion.model.vo.PromotionRevokeProductVo;
import com.essential.bussiness.promotion.model.vo.PromotionSerchParameter;
import com.essential.bussiness.promotion.service.IPromotionAutoService;
import com.essential.utils.CommonResponseUtils;

/**
 * 促销活动
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "promotionAutoController")
public class PromotionAutoController {

	private Logger logger = LoggerFactory.getLogger(PromotionAutoController.class);

	@Autowired
	IPromotionAutoService promotionAutoService;

	/**
	 * 添加折扣活动
	 * 
	 * @param promotionAutoVo
	 * @return
	 */
	@RequestMapping(value = "addPromotion")
	@ResponseBody
	public Map<String, Object> addPromotion(PromotionAutoVo promotionAutoVo) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 活动Id
			Long promotionId = promotionAutoVo.getPromotionId();
			// 活动名称
			String promotionName = promotionAutoVo.getPromotionName();
			// 活动开始时间
			String startTime = promotionAutoVo.getStartTime();
			// 活动结束时间
			String endTime = promotionAutoVo.getEndTime();
			// 活动标签
			String tag = promotionAutoVo.getTag();
			if(promotionId == null){
				return CommonResponseUtils.failureResponse("活动Id不能为空!");
			}
			if (promotionName == null || "".equals(promotionName)) {
				return CommonResponseUtils.failureResponse("活动名称不能为空!");
			}
			if (startTime == null || "".equals(startTime)) {
				return CommonResponseUtils.failureResponse("活动开始时间不能为空!");
			}
			if (endTime == null || "".equals(endTime)) {
				return CommonResponseUtils.failureResponse("活动结束时间不能为空!");
			}
			if (tag == null || "".equals(tag)) {
				return CommonResponseUtils.failureResponse("活动标签不能为空!");
			}
			return promotionAutoService.addPromotion(promotionAutoVo);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>添加折扣商品失败:" + e);

			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("添加折扣商品失败!"));
		}
		return map;
	}

	/**
	 * 添加折扣商品
	 * 
	 * @param promotionAutoVo
	 * @return
	 */
	@RequestMapping(value = "addPromotionProduct")
	@ResponseBody
	public Map<String, Object> addPromotionProduct(PromotionAutoVo promotionAutoVo) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (promotionAutoVo.getPromotionList() == null) {
				return CommonResponseUtils.failureResponse("请选择折扣商品!");
			}
			return promotionAutoService.addPromotionProduct(promotionAutoVo);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>添加折扣商品失败:" + e);

			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("添加折扣商品失败!"));
		}
		return map;
	}

	/**
	 * 编辑促销活动
	 * 
	 * @param promotionEditeProductVo
	 * @return
	 */
	@RequestMapping(value = "editePromotion")
	@ResponseBody
	public Map<String, Object> editePromotion(PromotionEditeProductVo promotionEditeProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (promotionEditeProductVo.getPromotionId() == null) {
				return CommonResponseUtils.failureResponse("促销活动Id不能为空!");
			}
			return promotionAutoService.editePromotion(promotionEditeProductVo);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>更新折扣商品失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("更新折扣商品失败!"));
		}
		return map;
	}
	
	/**
	 * 编辑促销活动(新方案的)
	 * 
	 * @param promotionEditeProductVo
	 * @return
	 */
	@RequestMapping(value = "queryPromotion")
	@ResponseBody
	public Map<String, Object> queryPromotion(PromotionEditeProductVo promotionEditeProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (promotionEditeProductVo.getPromotionId() == null) {
				return CommonResponseUtils.failureResponse("促销活动Id不能为空!");
			}
			return promotionAutoService.queryPromotion(promotionEditeProductVo);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>更新折扣商品失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("更新折扣商品失败!"));
		}
		return map;
	}
	/**
	 * 查询折扣商品
	 * 
	 * @param productAutoAddField
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "queryPromotionProduct")
	@ResponseBody
	public Map<String, Object> queryPromotionProduct(PromotionEditeProductVo promotionEditeProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return promotionAutoService.queryPromotionProduct(promotionEditeProductVo);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>查询折扣商品失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查询折扣商品失败!"));
		}
		return map;
	}

	/**
	 * 撤销折扣商品
	 * 
	 * @param promotionEditeProductVo
	 * @return
	 */
	@RequestMapping(value = "revokePromotionProduct")
	@ResponseBody
	public Map<String, Object> revokePromotionProduct(PromotionRevokeProductVo promotionRevokeProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(promotionRevokeProductVo.getPromotionId() == null){
				return CommonResponseUtils.failureResponse("请传入活动Id");
			}
			List<PromotionProductAuto> revokeProductIdList = promotionRevokeProductVo.getRevokeProductIdList();
			if(revokeProductIdList == null || revokeProductIdList.size() <= 0){
				return CommonResponseUtils.failureResponse("请选择撤销折扣的商品");
			}
			return promotionAutoService.revokePromotionProduct(promotionRevokeProductVo);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>撤销折扣商品失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("撤销折扣商品失败!"));
		}
		return map;
	}

	/**
	 * 设置折扣商品列表
	 * 
	 * @param promotionEditeProductVo
	 * @return
	 */
	@RequestMapping(value = "installPromotionProduct")
	@ResponseBody
	public Map<String, Object> installPromotionProduct(PromotionRevokeProductVo promotionRevokeProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			return promotionAutoService.installPromotionProduct(promotionRevokeProductVo);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>撤销折扣商品失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("撤销折扣商品失败!"));
		}
		return map;
	}
	
	/**
	 * 更新商品折扣信息
	 * 
	 * @param promotionEditeProductVo
	 * @return
	 */
	@RequestMapping(value = "updatePromotionProductInfo")
	@ResponseBody
	public Map<String, Object> updatePromotionProductInfo(PromotionProductVo promotionProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(promotionProductVo.getProductId()== null){
				return CommonResponseUtils.failureResponse("请输入商品Id");
			}
			if(promotionProductVo.getPromotionId()== null){
				return CommonResponseUtils.failureResponse("请输入活动Id");
			}
			return promotionAutoService.updatePromotionProductInfo(promotionProductVo);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>更新商品折扣信息失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("更新商品折扣信息失败!"));
		}
		return map;
	}
	
	
	/**
	 * 删除限时折扣活动
	 * 
	 * @param promotionId
	 * @param loginUser
	 * @return
	 */
	@RequestMapping(value = "deletePromotion")
	@ResponseBody
	public Map<String, Object> deletePromotion(long promotionId, long loginUser) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return promotionAutoService.deletePromotion(promotionId, loginUser);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>删除限时折扣活动失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("删除限时折扣活动失败!"));
		}
		return map;
	}

	/**
	 * 查询所有促销活动
	 * 
	 * @param shopId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "queryAllPromotion")
	@ResponseBody
	public Map<String, Object> queryAllPromotion(PromotionSerchParameter promotionSerchParameter) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return promotionAutoService.queryAllPromotion(promotionSerchParameter);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>查询所有促销活动失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查询所有促销活动失败!"));
		}
		return map;
	}

	/**
	 * 查询未开始的促销活动
	 * 
	 * @param shopId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "queryNotStartPromotion")
	@ResponseBody
	public Map<String, Object> queryNotStartPromotion(Long shopId, int pageIndex, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return promotionAutoService.queryNotStartPromotion(shopId, pageIndex, pageSize);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>查询未开始的促销活动失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查询未开始的促销活动失败!"));
		}
		return map;
	}

	/**
	 * 查询进行中的促销活动
	 * 
	 * @param shopId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "queryStartPromotion")
	@ResponseBody
	public Map<String, Object> queryStartPromotion(Long shopId, int pageIndex, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return promotionAutoService.queryStartPromotion(shopId, pageIndex, pageSize);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>查询进行中的促销活动失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查询进行中的促销活动失败!"));
		}
		return map;
	}

	/**
	 * 查询已结束的促销活动
	 * 
	 * @param shopId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "queryEndPromotion")
	@ResponseBody
	public Map<String, Object> queryEndPromotion(Long shopId, int pageIndex, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return promotionAutoService.queryEndPromotion(shopId, pageIndex, pageSize);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>查询已结束的促销活动失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查询已结束的促销活动失败!"));
		}
		return map;
	}

	/**
	 * 促销活动失效
	 * 
	 * @param promotionId
	 * @return
	 */
	@RequestMapping(value = "invalidPromotion")
	@ResponseBody
	public Map<String, Object> invalidPromotion(Long promotionId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return promotionAutoService.invalidPromotion(promotionId);
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>>>促销活动更改成失效状态失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("促销活动更改成失效状态失败!"));
		}
		return map;
	}

	/**
	 * 查询商品参加的促销活动
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "productPromotion")
	@ResponseBody
	public Map<String, Object> productPromotion(Long productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return promotionAutoService.productPromotion(productId);
		} catch (Exception e) {
			logger.info("======>>>>>>查询商品参加的促销活动失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查询商品参加的促销活动失败!"));
		}
		return map;
	}

	/**
	 * 编辑活动的设置折扣接口
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "setupEditePromotion")
	@ResponseBody
	public Map<String, Object> setupEditePromotion(PromotionEditeProductVo promotionEditeProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return promotionAutoService.setupEditePromotion(promotionEditeProductVo);
		} catch (Exception e) {
			logger.info("======>>>>>>查询商品参加的促销活动失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查询商品参加的促销活动失败!"));
		}
		return map;
	}

}
