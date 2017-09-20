package com.essential.bussiness.promotion.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.dao.ProductAutoMapper;
import com.essential.bussiness.product.model.auto.ProductAuto;
import com.essential.bussiness.product.model.vo.ProductAutoAddField;
import com.essential.bussiness.product.model.vo.ProductPromotionVo;
import com.essential.bussiness.promotion.dao.PromotionAutoMapper;
import com.essential.bussiness.promotion.dao.PromotionProductAutoMapper;
import com.essential.bussiness.promotion.model.auto.PromotionAuto;
import com.essential.bussiness.promotion.model.auto.PromotionProductAuto;
import com.essential.bussiness.promotion.model.vo.PromotionAutoInfoVo;
import com.essential.bussiness.promotion.model.vo.PromotionAutoVo;
import com.essential.bussiness.promotion.model.vo.PromotionCount;
import com.essential.bussiness.promotion.model.vo.PromotionEditeProductVo;
import com.essential.bussiness.promotion.model.vo.PromotionEditeVo;
import com.essential.bussiness.promotion.model.vo.PromotionProductAutoVo;
import com.essential.bussiness.promotion.model.vo.PromotionProductInfoVo;
import com.essential.bussiness.promotion.model.vo.PromotionProductVo;
import com.essential.bussiness.promotion.model.vo.PromotionRevokeProductVo;
import com.essential.bussiness.promotion.model.vo.PromotionSerchParameter;
import com.essential.bussiness.promotion.service.IPromotionAutoService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

@Service
public class PromotionAutoServiceImpl implements IPromotionAutoService {

	private Logger logger = LoggerFactory.getLogger(PromotionAutoServiceImpl.class);

	// 促销活动MAPPER
	@Autowired
	PromotionAutoMapper promotionAutoMapper;

	// 促销活动与商品关系MAPPER
	@Autowired
	PromotionProductAutoMapper promotionProductAutoMapper;

	// 商品MAPPER
	@Autowired
	ProductAutoMapper productAutoMapper;

	/**
	 * 添加折扣活动
	 */
	@Override
	public Map<String, Object> addPromotion(PromotionAutoVo promotionAutoVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取时间戳
			String dateTime = TmDateUtil.getTimeStamp();
			// 活动Id
			Long promotionId = promotionAutoVo.getPromotionId();
			// 登录用户
			Long loginUser = promotionAutoVo.getLoginUser();
			PromotionAuto promotionAuto = new PromotionAuto();
			// 活动Id
			promotionAuto.setPromotionId(promotionId);
			// 活动类型
			promotionAuto.setPromotionType(promotionAutoVo.getPromotionType());
			// 活动名称
			promotionAuto.setPromotionName(promotionAutoVo.getPromotionName());
			// 生效开始时间
			promotionAuto.setStartTime(promotionAutoVo.getStartTime());
			// 生效结束时间
			promotionAuto.setEndTime(promotionAutoVo.getEndTime());
			// 店铺Id
			promotionAuto.setShopId(promotionAutoVo.getShopId());
			// 活动标签
			promotionAuto.setTag(promotionAutoVo.getTag());
			// 是否失效
			promotionAuto.setIsValidate(0);
			// 是否删除
			promotionAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);
			// 登录用户
			promotionAuto.setCreateUser(loginUser);
			// 创建时间
			promotionAuto.setCreatTime(dateTime);

			int i = promotionAutoMapper.updateByPrimaryKeySelective(promotionAuto);
			if (i <= 0) {
				throw new Exception("添加促销活动失败!");
			}
			// 修改商品关联表状态
			
			
			PromotionProductAuto promotionProductAuto = new PromotionProductAuto();
			promotionProductAuto.setPromotionId(promotionId);
			promotionProductAuto.setIsValidate(0);
			promotionProductAuto.setRemark3(loginUser.toString());
			promotionProductAuto.setRemark4(dateTime);
			int j = promotionProductAutoMapper.updateByPromtionId(promotionProductAuto);
			if (j <= 0) {
				throw new Exception("商品与活动关联的状态修改失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("促销活动添加成功!"));
		} catch (Exception e) {
			logger.info("======>>>>>>添加折扣商品失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return map;
	}

	/**
	 * 添加折扣商品
	 */
	@Override
	public Map<String, Object> addPromotionProduct(PromotionAutoVo promotionAutoVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> outputMap = new HashMap<String, Object>();
		try {
			// 获取时间戳
			String dateTime = TmDateUtil.getTimeStamp();
			// 活动Id
			Long promotionId = promotionAutoVo.getPromotionId();
			// 登录用户
			Long loginUser = promotionAutoVo.getLoginUser();
			if (promotionId == null) {
				PromotionAuto promotionAuto = new PromotionAuto();
				// 是否失效 0-否，1-是，2-未发布
				promotionAuto.setIsValidate(2);
				// 是否删除
				promotionAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);
				// 活动类型
				promotionAuto.setPromotionType(0);
				// 登录用户
				promotionAuto.setCreateUser(loginUser);
				// 创建时间
				promotionAuto.setCreatTime(dateTime);

				int j = promotionAutoMapper.insertSelective(promotionAuto);
				if (j <= 0) {
					throw new Exception("添加促销活动失败!");
				}
				// 获取促销Id
				promotionId = promotionAuto.getPromotionId();
			}

			// 商品折扣信息List
			List<PromotionProductAuto> promotionProductList = promotionAutoVo.getPromotionList();

			for (int i = 0; i < promotionProductList.size(); i++) {
				PromotionProductAuto promotionProductAuto = promotionProductList.get(i);
				// 活动类型
				promotionProductAuto.setPromotionType(promotionAutoVo.getPromotionType());
				// 促销活动id
				promotionProductAuto.setPromotionId(promotionId);

//				// 先更新以前该产品的状态
//				// 是否失效（主动），0-否，1-是,2-未发布
//				promotionProductAuto.setIsValidate(1);
//				promotionProductAuto.setRemark3(loginUser.toString());
//				promotionProductAuto.setRemark4(dateTime);
//				int q = promotionProductAutoMapper.updateByProductId(promotionProductAuto);
//				// 在新增
//				promotionProductAuto.setRemark3(null);
//				promotionProductAuto.setRemark4(null);
				// 创建用户
				promotionProductAuto.setRemark1(loginUser.toString());
				// 创建时间
				promotionProductAuto.setRemark2(dateTime);
				// 是否失效 0-否，1-是,2-未发布
				promotionProductAuto.setIsValidate(2);
				promotionProductAuto.setPromotionType(0);

				int k = promotionProductAutoMapper.insertSelective(promotionProductAuto);

				if (k <= 0) {
					throw new Exception("商品参加的促销活动参加失败!");
				}
			}
			outputMap.put("promotionId", promotionId);
			map.putAll(CommonResponseUtils.successResponse(outputMap));

		} catch (Exception e) {
			logger.info("======>>>>>>添加折扣商品失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return map;
	}

	/**
	 * 撤销折扣商品
	 */
	@Override
	public Map<String, Object> revokePromotionProduct(PromotionRevokeProductVo promotionRevokeProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> inputMap = new HashMap<String, Object>();
		try {
			// 获取时间戳
			String dateTime = TmDateUtil.getTimeStamp();
			// 活动Id
			Long promotionId = promotionRevokeProductVo.getPromotionId();
			// 登录用户
			Long loginUser = promotionRevokeProductVo.getLoginUser();

			// 商品Id List
			List<PromotionProductAuto> revokeProductIdList = promotionRevokeProductVo.getRevokeProductIdList();
//			List<Long> productIds = new ArrayList<Long>();
//			for (int i = 0; i < revokeProductIdList.size(); i++) {
//				PromotionProductAuto promotionProductAuto = revokeProductIdList.get(i);
//				
//				productIds[i] = promotionProductAuto.getProductOrShopId();
////				// 促销活动id
////				promotionProductAuto.setPromotionId(promotionId);
////				// 是否失效 0-否，1-是,2-未发布
////				promotionProductAuto.setIsValidate(1);
////				promotionProductAuto.setRemark3(loginUser.toString());
////				promotionProductAuto.setProductOrShopId(productOrShopId);
////				promotionProductAuto.setRemark4(dateTime);
//			}
			revokeProductIdList.toArray();
			String[] productIds = listToString(revokeProductIdList,',');
				inputMap.put("promotionId", promotionId);
				inputMap.put("productOrShopIds", productIds);
				inputMap.put("isValidate", 1);
				inputMap.put("remark3", loginUser);
				inputMap.put("remark4", dateTime);

//				int k = promotionProductAutoMapper.updateByProductIdAndPromotionId(promotionProductAuto);
				int k = promotionProductAutoMapper.updateIsValidateByProductIdAndPromotionId(inputMap);

				if (k <= 0) {
					throw new Exception("商品参加的促销活动参加失败!");
				}
			
			map.putAll(CommonResponseUtils.successResponse("撤销折扣商品成功!"));

		} catch (Exception e) {
			logger.info("======>>>>>>撤销折扣商品失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return map;
	}

	/**
	 * 设置折扣商品列表
	 */
	@Override
	public Map<String, Object> installPromotionProduct(PromotionRevokeProductVo promotionRevokeProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> inputMap = new HashMap<String, Object>();
		try {
			List<ProductPromotionVo> producList = new ArrayList<ProductPromotionVo>();
			// 活动Id
			Long promotionId = promotionRevokeProductVo.getPromotionId();
			if (promotionId != null) {

				inputMap.put("promotionId", promotionId);
				producList = productAutoMapper.queryByPromotionId(inputMap);

			}
			map.putAll(CommonResponseUtils.successResponse(producList));

		} catch (Exception e) {
			logger.info("======>>>>>>添加折扣商品失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return map;
	}

	/**
	 * 更新商品折扣信息
	 */
	@Override
	public Map<String, Object> updatePromotionProductInfo(PromotionProductVo promotionProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PromotionProductAuto promotionProductAuto = new PromotionProductAuto();
			// 折扣价
			promotionProductAuto.setDiscountMoney(promotionProductVo.getDiscountMoney());
			// 折扣
			promotionProductAuto.setDiscountPercent(promotionProductVo.getDiscountPercent());
			// 商品Id
			promotionProductAuto.setProductOrShopId(promotionProductVo.getProductId());
			// 活动Id
			promotionProductAuto.setPromotionId(promotionProductVo.getPromotionId());
			promotionProductAuto.setRemark3(promotionProductVo.getLoginUser().toString());
			promotionProductAuto.setRemark4(TmDateUtil.getTimeStamp());
			int i = promotionProductAutoMapper.updateByProductIdAndPromotionId(promotionProductAuto);
			if (i <= 0) {
				throw new Exception("更新商品折扣信息失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("更新商品折扣信息成功!"));
		} catch (Exception e) {
			logger.info("======>>>>>>更新商品折扣信息失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return map;
	}
	
	/**
	 * 编辑促销活动(新方案的)
	 */
	@Override
	public Map<String, Object> queryPromotion(PromotionEditeProductVo promotionEditeProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 活动Id
			Long promotionId = promotionEditeProductVo.getPromotionId();

			PromotionAuto promotionAuto = new PromotionAuto();
			promotionAuto.setPromotionId(promotionId);
			promotionAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);
			promotionAuto = promotionAutoMapper.queryPromotion(promotionAuto);
			if (promotionAuto == null) {
				return CommonResponseUtils.failureResponse("活动查询失败!");
			}
			map.putAll(CommonResponseUtils.successResponse(promotionAuto));
		} catch (Exception e) {
			logger.info("======>>>>>>编辑促销活动失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return map;
	}

	/**
	 * 删除限时折扣
	 */
	@Override
	public Map<String, Object> deletePromotion(Long promotionId, Long loginUser) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取当前时间
			String dateTime = TmDateUtil.getTimeStamp();
			// 促销活动数据封装
			PromotionAuto PromotionAuto = new PromotionAuto();
			// 促销活动Id
			PromotionAuto.setPromotionId(promotionId);
			// 修改用户
			PromotionAuto.setModifyUser(loginUser);
			// 修改时间
			PromotionAuto.setModifyTime(dateTime);
			// 是否删除
			PromotionAuto.setIsDelelte(SUConstants.IS_DELETE);
			int i = promotionAutoMapper.updateByPrimaryKeySelective(PromotionAuto);
			if (i <= 0) {
				throw new Exception("限时折扣删除失败!");
			}

			PromotionProductAuto promotionProductAuto = new PromotionProductAuto();
			// 促销活动Id
			promotionProductAuto.setPromotionId(promotionId);

			// 促销活动与商品关系表数据封装
			// 是否失效（主动），0-否，1-是
			promotionProductAuto.setIsValidate(1);
			promotionProductAuto.setRemark3(loginUser.toString());
			promotionProductAuto.setRemark4(dateTime);
			int j = promotionProductAutoMapper.updateIsValidate(promotionProductAuto);
			if (j <= 0) {
				throw new Exception("限时折扣与商品关联删除失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("删除限时折扣成功!"));
			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>删除折扣商品失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 更新折扣商品
	 */
	@Override
	public Map<String, Object> updatePromotionProduct(PromotionAutoVo promotionAutoVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取时间戳
			String dateTime = TmDateUtil.getTimeStamp();

			PromotionAuto promotionAuto = new PromotionAuto();
			// 促销活动Id
			promotionAuto.setPromotionId(promotionAutoVo.getPromotionId());
			// 活动类型
			promotionAuto.setPromotionType(promotionAutoVo.getPromotionType());
			// 活动名称
			promotionAuto.setPromotionName(promotionAutoVo.getPromotionName());
			// 生效开始时间
			promotionAuto.setStartTime(promotionAutoVo.getStartTime());
			// 生效结束时间
			promotionAuto.setEndTime(promotionAutoVo.getEndTime());
			// 店铺Id
			promotionAuto.setShopId(promotionAutoVo.getShopId());
			// 活动标签
			promotionAuto.setTag(promotionAutoVo.getTag());
			// 修改用户
			promotionAuto.setModifyUser(promotionAutoVo.getLoginUser());
			// 修改时间
			promotionAuto.setModifyTime(dateTime);

			int j = promotionAutoMapper.updateByPrimaryKeySelective(promotionAuto);
			if (j <= 0) {
				throw new Exception("更新促销活动失败!");
			}

			// 商品折扣信息List
			List<PromotionProductAuto> promotionProductList = promotionAutoVo.getPromotionList();

			for (int i = 0; i < promotionProductList.size(); i++) {
				PromotionProductAuto promotionProductAuto = promotionProductList.get(i);
				// 活动类型
				promotionProductAuto.setPromotionType(promotionAutoVo.getPromotionType());
				// 促销活动id
				promotionProductAuto.setPromotionId(promotionAutoVo.getPromotionId());
				// 是否失效
				promotionProductAuto.setIsValidate(0);

				int k = promotionProductAutoMapper.updateByPromotionPrimary(promotionProductAuto);

				if (k <= 0) {
					throw new Exception("更新商品促销活动失败!");
				}
			}
			map.putAll(CommonResponseUtils.successResponse("更新折扣商品成功!"));
		} catch (Exception e) {
			logger.info("======>>>>>>更新折扣商品失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return map;
	}

	/**
	 * 查询所有促销
	 */
	@Override
	public Map<String, Object> queryAllPromotion(PromotionSerchParameter promotionSerchParameter) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> inputMap = new HashMap<String, Object>();
		try {
			// 店铺Id
			Long shopId = promotionSerchParameter.getShopId();
			// 活动名称
			String promotionName = promotionSerchParameter.getPromotionName();
			// 每页条数
			Integer pageSize = promotionSerchParameter.getPageSize();
			// 当前页书
			Integer pageIndex = promotionSerchParameter.getPageIndex();
			if (pageSize == null) {
				pageSize = 20;
			}
			if (pageIndex == null) {
				pageIndex = 1;
			}
			Integer pageIndexs = (pageIndex - 1) * pageSize;

			PromotionAutoInfoVo promotionAutoInfoVo = new PromotionAutoInfoVo();
			PromotionAuto promotionAuto = new PromotionAuto();
			// 店铺Id
			promotionAuto.setShopId(shopId);
			// 是否删除
			promotionAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);
			inputMap.put("shopId", shopId);
			inputMap.put("isDelelte", SUConstants.IS_NOT_DELETE);
			inputMap.put("pageIndex", pageIndexs);
			inputMap.put("pageSize", pageSize);
			inputMap.put("type", 0);
			if (promotionName != null && !"".equals(promotionName)) {
				inputMap.put("promotionName", promotionName);
			}

			List<PromotionAuto> promotionAutoList = promotionAutoMapper.queryByPrimaryKey(inputMap);
			PromotionCount promotionCount = promotionAutoMapper.queryCount(inputMap);
			for (int i = 0; i < promotionAutoList.size(); i++) {

				if (promotionAutoList.get(i).getIsValidate() == 0) {

					// 促销开始时间
					String startTime = promotionAutoList.get(i).getStartTime();
					// 促销结束时间
					String endTime = promotionAutoList.get(i).getEndTime();
					// 系统现在时间
					String nowTime = TmDateUtil.getTimeStamp();

					// 比较系统时间与开始时间
					int k = nowTime.compareTo(startTime);
					// 比较系统时间与结束时间
					int j = nowTime.compareTo(endTime);
					if (k < 0) {
						// 限时促销未开始
						promotionAutoList.get(i).setPromotionStatus(SUConstants.PROMOTION_NOT_START);
					}
					if (k >= 0 && j < 0) {
						// 限时促销进行中
						promotionAutoList.get(i).setPromotionStatus(SUConstants.PROMOTION_START);
					}
					if (j >= 0) {
						// 限时促销已结束
						promotionAutoList.get(i).setPromotionStatus(SUConstants.PROMOTION_END);
					}
				} else {
					// 限时促销已结束
					promotionAutoList.get(i).setPromotionStatus(SUConstants.PROMOTION_END);
				}
			}
			promotionAutoInfoVo.setPageCount(promotionCount.getCount());
			promotionAutoInfoVo.setPromotionAutoList(promotionAutoList);
			map.putAll(CommonResponseUtils.successResponse(promotionAutoInfoVo));
			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>查询所有促销失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询店铺商品
	 */
	@Override
	public Map<String, Object> queryPromotionProduct(PromotionEditeProductVo promotionEditeProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> inputParameterMap = new HashMap<String, Object>();
		try {
			// 每页存储条数
			Integer pageSize = promotionEditeProductVo.getPageSize();
			// 当前页数
			Integer pageIndex = promotionEditeProductVo.getPageIndex();
			// 商品名称
			String productName = promotionEditeProductVo.getProductName();
			// 商品代码
			String articleNumber = promotionEditeProductVo.getArticleNumber();
			// 店铺Id
			Long shopId = promotionEditeProductVo.getShopId();
			// 活动Id
			Long promotionId = promotionEditeProductVo.getPromotionId();
			if (pageSize == null) {
				pageSize = 10;
			}
			if (pageIndex == null) {
				pageIndex = 1;
			}
			Integer pageIndexs = (pageIndex - 1) * pageSize;
			PromotionProductAutoVo promotionProductAutoVo = new PromotionProductAutoVo();
			List<PromotionProductVo> promotionProductVoList = new ArrayList<PromotionProductVo>();
			if (productName != null && !"".equals(productName)) {
				// 商品名称
				inputParameterMap.put("productName", productName);
			}
			if (articleNumber != null && !"".equals(articleNumber)) {
				// 商品代码
				inputParameterMap.put("articleNumber", articleNumber);
			}
			// 店铺Id
			inputParameterMap.put("shopId", shopId);
			// 是否删除
			inputParameterMap.put("isDelete", SUConstants.IS_NOT_DELETE);
			inputParameterMap.put("pageIndex", pageIndexs);
			inputParameterMap.put("pageSize", pageSize);
			if(promotionId != null){
				inputParameterMap.put("promotionId", promotionId);
			}

			List<PromotionProductVo> promotionProductList = productAutoMapper.queryPromotionProductByShopId(inputParameterMap);
			PromotionCount promotionCount = productAutoMapper.queryPromotionProductCount(inputParameterMap);
//			if (promotionProductList != null && promotionProductList.size() > 0) {
//				for (int i = 0; i < promotionProductList.size(); i++) {
//					PromotionProductVo promotionProductVo = new PromotionProductVo();
//					ProductAutoAddField productAddField = promotionProductList.get(i);
//					// 商品Id
//					promotionProductVo.setProductId(productAddField.getProductId());
//					// 商品代码
//					promotionProductVo.setArticleNumber(productAddField.getArticleNumber());
//					// 原价
//					promotionProductVo.setCostPrice(productAddField.getCostPrice());
//					// 商品图片
//					promotionProductVo.setPath(productAddField.getPath());
//					// 商品信息
//					promotionProductVo.setProductintro(productAddField.getProductintro());
//					// 商品名称
//					promotionProductVo.setProductName(productAddField.getProductName());
//					// 库存
//					promotionProductVo.setStock(productAddField.getStock());
//
//					// 查询商品是否参加活动
//					PromotionProductAuto promotionProductAuto = new PromotionProductAuto();
//					// 商品Id
//					promotionProductAuto.setProductOrShopId(productAddField.getProductId());
//
//					List<PromotionProductAuto> promotionProduct = promotionProductAutoMapper.queryByProductId(promotionProductAuto);
//					if (promotionProduct != null && promotionProduct.size() > 1) {
//						throw new Exception("商品:" + promotionProduct.get(0).getProductOrShopId() + "有" + promotionProduct.size() + "个活动");
//					} else if (promotionProduct != null && promotionProduct.size() == 1) {
//						// 活动关联表的活动Id
//						Long promotionIdP = promotionProduct.get(0).getPromotionId();
//						if (promotionIdP == promotionId) {
//							// 促销活动类型（满减送，打折），0-打折，1-满减送,如果为空就是没有参加活动
//							promotionProductVo.setPromotionType(promotionProduct.get(0).getPromotionType());
//							// 商品活动状态名
//							promotionProductVo.setProducteStatusName(SUConstants.PROMOTION_PRODUCT_STATUS_JOIN_NAME);
//						} else {
//							PromotionAuto promotionAuto = promotionAutoMapper.selectByPrimaryKey(promotionProduct.get(0).getPromotionId());
//							if (promotionAuto != null) {
//
//								// 系统当前时间
//								String nowDate = TmDateUtil.getTimeStamp();
//								// 促销活动开始时间
//								// String startTime =
//								// PromotionAuto.getStartTime();
//								// 促销活动结束时间
//								String endTime = promotionAuto.getEndTime();
//
//								if (promotionProduct.get(0).getIsValidate() != 2) {
//									// 系统时间与活动开始时间比较
//									// int k = nowDate.compareTo(startTime);
//									// 系统时间与活动结束时间比较
//									int j = nowDate.compareTo(endTime);
//
//									// if(k >=0 && j < 0){
//									// // 促销活动类型（满减送，打折），0-打折，1-满减送
//									// promotionProductVo.setPromotionType(promotionProduct.getPromotionType());
//									// }
//									// 商品参加活动
//									if (j <= 0) {
//										// 促销活动类型（满减送，打折），0-打折，1-满减送,如果为空就是没有参加活动
//										promotionProductVo.setPromotionType(promotionProduct.get(0).getPromotionType());
//										// 商品活动状态名
//										promotionProductVo.setProducteStatusName(SUConstants.PROMOTION_PRODUCT_STATUS_OTHER_NAME);
//
//									}
//								}
//							}
//						}
//					}
//					promotionProductVoList.add(promotionProductVo);
//				}
//			}
			promotionProductAutoVo.setPageCount(promotionCount.getCount());
			promotionProductAutoVo.setPromotionProductVoList(promotionProductList);
			map.putAll(CommonResponseUtils.successResponse(promotionProductAutoVo));
			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>查询店铺商品失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询限时促销活动未开始
	 */
	@Override
	public Map<String, Object> queryNotStartPromotion(Long shopId, int pageIndex, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> inputMap = new HashMap<String, Object>();
		try {
			if (pageSize == null) {
				pageSize = 20;
			}
			int pageIndexs = (pageIndex - 1) * pageSize;

			// 查询结果返回值
			List<PromotionAuto> promotionList = new ArrayList<PromotionAuto>();

			PromotionAuto promotionAuto = new PromotionAuto();
			PromotionAutoInfoVo promotionAutoInfoVo = new PromotionAutoInfoVo();
			// // 店铺Id
			// promotionAuto.setShopId(shopId);
			// // 是否删除
			// promotionAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);

			// 系统现在时间
			String nowTime = TmDateUtil.getTimeStamp();

			inputMap.put("shopId", shopId);
			inputMap.put("isDelelte", SUConstants.IS_NOT_DELETE);
			inputMap.put("pageIndex", pageIndexs);
			inputMap.put("pageSize", pageSize);
			inputMap.put("type", 1);
			inputMap.put("nowTime", nowTime);

			List<PromotionAuto> promotionAutoList = promotionAutoMapper.queryByPrimaryKey(inputMap);
			PromotionCount promotionCount = promotionAutoMapper.queryCount(inputMap);
			for (int i = 0; i < promotionAutoList.size(); i++) {
				promotionAuto = promotionAutoList.get(i);
				if (promotionAuto.getIsValidate() == 0) {

					// 促销开始时间
					String startTime = promotionAuto.getStartTime();
					// 促销结束时间
					String endTime = promotionAuto.getEndTime();

					// 比较系统时间与开始时间
					int k = nowTime.compareTo(startTime);
					// 比较系统时间与结束时间
					int j = nowTime.compareTo(endTime);
					if (k < 0 && j < 0) {
						// 限时促销未开始
						promotionAuto.setPromotionStatus(SUConstants.PROMOTION_NOT_START);

						promotionList.add(promotionAuto);
					}
				}
			}
			promotionAutoInfoVo.setPromotionAutoList(promotionList);
			promotionAutoInfoVo.setPageCount(promotionCount.getCount());
			map.putAll(CommonResponseUtils.successResponse(promotionAutoInfoVo));
			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>查询未开始的限时促销活动失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询限时促销活动进行中
	 */
	@Override
	public Map<String, Object> queryStartPromotion(Long shopId, int pageIndex, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> inputMap = new HashMap<String, Object>();
		try {
			if (pageSize == null) {
				pageSize = 20;
			}
			int pageIndexs = (pageIndex - 1) * pageSize;

			// 查询结果返回值
			List<PromotionAuto> promotionList = new ArrayList<PromotionAuto>();

			PromotionAutoInfoVo promotionAutoInfoVo = new PromotionAutoInfoVo();
			PromotionAuto promotionAuto = new PromotionAuto();
			// // 店铺Id
			// promotionAuto.setShopId(shopId);
			// // 是否删除
			// promotionAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);

			// 系统现在时间
			String nowTime = TmDateUtil.getTimeStamp();

			inputMap.put("shopId", shopId);
			inputMap.put("isDelelte", SUConstants.IS_NOT_DELETE);
			inputMap.put("pageIndex", pageIndexs);
			inputMap.put("pageSize", pageSize);
			inputMap.put("type", 2);
			inputMap.put("nowTime", nowTime);

			List<PromotionAuto> promotionAutoList = promotionAutoMapper.queryByPrimaryKey(inputMap);
			PromotionCount promotionCount = promotionAutoMapper.queryCount(inputMap);
			for (int i = 0; i < promotionAutoList.size(); i++) {
				promotionAuto = promotionAutoList.get(i);
				if (promotionAuto.getIsValidate() == 0) {

					// 促销开始时间
					String startTime = promotionAuto.getStartTime();
					// 促销结束时间
					String endTime = promotionAuto.getEndTime();

					// 比较系统时间与开始时间
					int k = nowTime.compareTo(startTime);
					// 比较系统时间与结束时间
					int j = nowTime.compareTo(endTime);
					if (k >= 0 && j < 0) {
						// 限时促销进行中
						promotionAuto.setPromotionStatus(SUConstants.PROMOTION_START);

						promotionList.add(promotionAuto);
					}
				}
			}
			promotionAutoInfoVo.setPageCount(promotionCount.getCount());
			promotionAutoInfoVo.setPromotionAutoList(promotionList);
			map.putAll(CommonResponseUtils.successResponse(promotionAutoInfoVo));
			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>查询进行中的限时促销活动失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询限时促销活动已结束
	 */
	@Override
	public Map<String, Object> queryEndPromotion(Long shopId, int pageIndex, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> inputMap = new HashMap<String, Object>();
		try {
			if (pageSize == null) {
				pageSize = 20;
			}
			int pageIndexs = (pageIndex - 1) * pageSize;

			// 查询结果返回值
			List<PromotionAuto> promotionList = new ArrayList<PromotionAuto>();

			PromotionAutoInfoVo promotionAutoInfoVo = new PromotionAutoInfoVo();
			PromotionAuto promotionAuto = new PromotionAuto();
			// // 店铺Id
			// promotionAuto.setShopId(shopId);
			// // 是否删除
			// promotionAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);
			// 系统现在时间
			String nowTime = TmDateUtil.getTimeStamp();

			inputMap.put("shopId", shopId);
			inputMap.put("isDelelte", SUConstants.IS_NOT_DELETE);
			inputMap.put("pageIndex", pageIndexs);
			inputMap.put("pageSize", pageSize);
			inputMap.put("type", 3);
			inputMap.put("nowTime", nowTime);

			List<PromotionAuto> promotionAutoList = promotionAutoMapper.queryByPrimaryKey(inputMap);
			PromotionCount promotionCount = promotionAutoMapper.queryCount(inputMap);
			for (int i = 0; i < promotionAutoList.size(); i++) {
				promotionAuto = promotionAutoList.get(i);
				if (promotionAuto.getIsValidate() == 0) {

					// 促销开始时间
					String startTime = promotionAuto.getStartTime();
					// 促销结束时间
					String endTime = promotionAuto.getEndTime();

					// 比较系统时间与开始时间
					int k = nowTime.compareTo(startTime);
					// 比较系统时间与结束时间
					int j = nowTime.compareTo(endTime);
					if (k > 0 && j > 0) {
						// 限时促销已结束
						promotionAuto.setPromotionStatus(SUConstants.PROMOTION_END);

						promotionList.add(promotionAuto);
					}
				} else {
					// 限时促销已结束
					promotionAuto.setPromotionStatus(SUConstants.PROMOTION_END);

					promotionList.add(promotionAuto);
				}
			}
			promotionAutoInfoVo.setPageCount(promotionCount.getCount());
			promotionAutoInfoVo.setPromotionAutoList(promotionList);
			map.putAll(CommonResponseUtils.successResponse(promotionAutoInfoVo));
			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>查询已结束的限时促销活动失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 促销活动更改成失效状态
	 */
	@Override
	public Map<String, Object> invalidPromotion(Long promotionId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PromotionAuto promotionAuto = new PromotionAuto();
			// 促销活动Id
			promotionAuto.setPromotionId(promotionId);
			// 是否失效，0-否，1-是
			promotionAuto.setIsValidate(1);
			int i = promotionAutoMapper.updateByPrimaryKeySelective(promotionAuto);
			if (i <= 0) {
				throw new Exception("促销活动更改成失效状态失败!");
			}
			PromotionProductAuto promotionProductAuto = new PromotionProductAuto();
			// 促销活动Id
			promotionProductAuto.setPromotionId(promotionId);

			// 更新商品是否有活动状态
			// 是否失效（主动），0-否，1-是
			promotionProductAuto.setIsValidate(0);
			List<PromotionProductAuto> productList = promotionProductAutoMapper.queryProduct(promotionProductAuto);
			if (productList != null) {
				for (int k = 0; k < productList.size(); k++) {
					Long productId = productList.get(k).getProductOrShopId();
					// 更新SPU是否有活动字段（link_url）
					ProductAuto productAuto = new ProductAuto();
					productAuto.setProductId(productId);
					productAuto.setLinkUrl("0");
					int p = productAutoMapper.updateByPrimaryKeySelective(productAuto);
					if (p <= 0) {
						throw new Exception("SPU是否有活动字段更新失败!");
					}
				}
			}

			// 是否失效，0-否，1-是
			promotionProductAuto.setIsValidate(1);
			int j = promotionProductAutoMapper.updateIsValidate(promotionProductAuto);
			if (j <= 0) {
				throw new Exception("促销活动与商品关联更改成失效状态失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("促销活动失效成功!"));
			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>促销活动更改成失效状态失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * 编辑促销活动
	 */
	@Override
	public Map<String, Object> editePromotion(PromotionEditeProductVo promotionEditeProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> inputParameterMap = new HashMap<String, Object>();
		try {
			PromotionEditeVo promotionEditeVo = new PromotionEditeVo();
			List<PromotionProductVo> promotionProductList = new ArrayList<PromotionProductVo>();
			// 活动Id
			Long promotionId = promotionEditeProductVo.getPromotionId();

			PromotionAuto promotionAuto = new PromotionAuto();
			promotionAuto.setPromotionId(promotionId);
			promotionAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);
			promotionAuto = promotionAutoMapper.queryPromotion(promotionAuto);
			if (promotionAuto == null) {
				return CommonResponseUtils.failureResponse("活动查询失败!");
			}
			// 活动开始时间
			String startTime = promotionAuto.getStartTime();
			// 活动结束时间
			String endTime = promotionAuto.getEndTime();

			// 活动Id
			promotionEditeVo.setPromotionId(promotionAuto.getPromotionId());
			// 活动名称
			promotionEditeVo.setPromotionName(promotionAuto.getPromotionName());
			// 活动开始时间
			promotionEditeVo.setStartTime(startTime);
			// 活动结束时间
			promotionEditeVo.setEndTime(endTime);
			// 活动标签
			promotionEditeVo.setTag(promotionAuto.getTag());

			// 获取商品列表
			// 商品名称
			String productName = promotionEditeProductVo.getProductName();
			// 商品代码
			String articleNumber = promotionEditeProductVo.getArticleNumber();
			// 店铺Id
			Long shopId = promotionAuto.getShopId();
			// 当前页数
			Integer pageIndex = promotionEditeProductVo.getPageIndex();
			// 页面显示条数
			Integer pageSize = promotionEditeProductVo.getPageSize();
			if (pageIndex == null) {
				pageIndex = 1;
			}
			if (pageSize == null) {
				pageSize = 10;
			}

			// 商品名称
			if (productName != null && !"".equals(productName)) {
				inputParameterMap.put("productName", productName);
			}
			// 商品代码
			if (articleNumber != null && !"".equals(articleNumber)) {
				inputParameterMap.put("articleNumber", articleNumber);
			}
			// 店铺Id
			inputParameterMap.put("shopId", shopId);
			// 是否删除
			inputParameterMap.put("isDelete", SUConstants.IS_NOT_DELETE);
			inputParameterMap.put("pageIndex", (pageIndex - 1) * pageSize);
			inputParameterMap.put("pageSize", pageSize);

			List<PromotionProductVo> productAutoList = productAutoMapper.queryPromotionProductByShopId(inputParameterMap);
			PromotionCount promotionCount = productAutoMapper.queryPromotionProductCount(inputParameterMap);
//			if (productAutoList != null && productAutoList.size() > 0) {
//				for (int i = 0; i < productAutoList.size(); i++) {
//					PromotionProductVo promotionProductVo = new PromotionProductVo();
//					ProductAutoAddField productAddField = productAutoList.get(i);
//					// 商品Id
//					promotionProductVo.setProductId(productAddField.getProductId());
//					// 商品代码
//					promotionProductVo.setArticleNumber(productAddField.getArticleNumber());
//					// 原价
//					promotionProductVo.setCostPrice(productAddField.getCostPrice());
//					// 商品图片
//					promotionProductVo.setPath(productAddField.getPath());
//					// 商品信息
//					promotionProductVo.setProductintro(productAddField.getProductintro());
//					// 商品名称
//					promotionProductVo.setProductName(productAddField.getProductName());
//					// 库存
//					promotionProductVo.setStock(productAddField.getStock());
//
//					// 查询商品是否参加活动
//					PromotionProductAuto promotionProductAuto = new PromotionProductAuto();
//					// 商品Id
//					promotionProductAuto.setProductOrShopId(productAddField.getProductId());
//					// 是否失效
//					promotionProductAuto.setIsValidate(0);
//
//					List<PromotionProductAuto> promotionProduct = promotionProductAutoMapper.queryByPrimaryKey(promotionProductAuto);
//					if (promotionProduct != null && promotionProduct.size() > 1) {
//						throw new Exception("商品:" + promotionProduct.get(0).getProductOrShopId() + "有" + promotionProduct.size() + "个活动");
//					} else if (promotionProduct != null && promotionProduct.size() == 1) {
//
//						PromotionAuto PromotionAuto = promotionAutoMapper.selectByPrimaryKey(promotionProduct.get(0).getPromotionId());
//						if (PromotionAuto != null) {
//							// 系统当前时间
//							String nowDate = TmDateUtil.getTimeStamp();
//							// 促销活动结束时间
//							String endTime1 = PromotionAuto.getEndTime();
//
//							// 系统时间与活动结束时间比较
//							int j = nowDate.compareTo(endTime1);
//
//							// 商品参加活动
//							if (j <= 0) {
//								// 促销活动类型（满减送，打折），0-打折，1-满减送,如果为空就是没有参加活动
//								promotionProductVo.setPromotionType(promotionProduct.get(0).getPromotionType());
//								// 商品活动关联Id
//								promotionProductVo.setProductRomotionId(promotionProduct.get(0).getProductRomotionId());
//							}
//							if (promotionId == promotionProduct.get(0).getPromotionId()) {
//								// 商品活动状态名称
//								promotionProductVo.setProducteStatusName("已参加");
//							} else {
//								// 商品活动状态名称
//								promotionProductVo.setProducteStatusName("该商品已参加其他活动");
//							}
//							// 折扣
//							Float discountPercent = promotionProduct.get(0).getDiscountPercent();
//							promotionProductVo.setDiscountPercent(discountPercent);
//							// 折扣价
//							String discount = discountPercent.toString();
//
//							// promotionProductVo.setDiscountPrice(discountPrice);
//						}
//					}
//					promotionProductList.add(promotionProductVo);
//				}
//			}
			promotionEditeVo.setPageCount(promotionCount.getCount());
			promotionEditeVo.setPromotionProductList(promotionProductList);
			map.putAll(CommonResponseUtils.successResponse(promotionEditeVo));
			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>编辑促销活动失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询商品参加的促销活动
	 */
	@Override
	public Map<String, Object> productPromotion(Long productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PromotionProductAuto promotionProductAuto = new PromotionProductAuto();
			promotionProductAuto.setProductOrShopId(productId);
			promotionProductAuto.setIsValidate(0);
			List<PromotionProductInfoVo> promotionProductInfoVoList = promotionProductAutoMapper.queryProuctPromotion(promotionProductAuto);
			if (promotionProductInfoVoList != null && promotionProductInfoVoList.size() > 1) {
				map.putAll(CommonResponseUtils.failureResponse("商品：" + promotionProductAuto.getProductOrShopId() + "有" + promotionProductInfoVoList.size() + "个活动！"));
			} else if (promotionProductInfoVoList == null || promotionProductInfoVoList.size() <= 0) {
				map.put(SUConstants.CODE_KEY, "3");
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
			} else {
				map.putAll(CommonResponseUtils.successResponse(promotionProductInfoVoList.get(0)));
			}
			// if (promotionProductInfoVo != null) {
			// if (promotionProductInfoVo.getIsValidate() == 0) {
			// // 系统当前时间
			// String nowTime = TmDateUtil.getTimeStamp();
			// // 活动开始时间
			// String startTime = promotionProductInfoVo.getStartTime();
			// // 活动结束时间
			// String endTime = promotionProductInfoVo.getEndTime();
			// // 系统当前时间与活动开始时间比较
			// int i = nowTime.compareTo(startTime);
			// // 系统当前时间与活动结束时间比较
			// int j = nowTime.compareTo(endTime);
			// if (i < 0 || j >= 0) {
			//
			// }
			// if (i >= 0 && j < 0) {
			//
			// }
			// }
			//
			// } else {
			// // 未参加活动
			// map.put(SUConstants.CODE_KEY, "3");
			// map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
			// }
			return map;
		} catch (Exception e) {
			logger.info("=======>>>>>>>查询商品参加的促销活动失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 编辑活动的设置折扣接口
	 */
	@Override
	public Map<String, Object> setupEditePromotion(PromotionEditeProductVo promotionEditeProductVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PromotionEditeVo promotionEditeVo = new PromotionEditeVo();
			List<PromotionProductVo> promotionProductList = new ArrayList<PromotionProductVo>();
			// 活动Id
			Long promotionId = promotionEditeProductVo.getPromotionId();

			PromotionAuto promotionAuto = new PromotionAuto();
			promotionAuto.setPromotionId(promotionId);
			promotionAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);
			promotionAuto = promotionAutoMapper.queryPromotion(promotionAuto);
			if (promotionAuto == null) {
				return CommonResponseUtils.failureResponse("活动查询失败!");
			}
			// 系统当前时间
			String nowDate = TmDateUtil.getTimeStamp();
			// 活动开始时间
			String startTime = promotionAuto.getStartTime();
			// 活动结束时间
			String endTime = promotionAuto.getEndTime();
			// 是否失效（主动），0-否，1-是
			Integer isValidate = promotionAuto.getIsValidate();

			// 活动Id
			promotionEditeVo.setPromotionId(promotionAuto.getPromotionId());
			// 活动名称
			promotionEditeVo.setPromotionName(promotionAuto.getPromotionName());
			// 活动开始时间
			promotionEditeVo.setStartTime(startTime);
			// 活动结束时间
			promotionEditeVo.setEndTime(endTime);
			// 活动标签
			promotionEditeVo.setTag(promotionAuto.getTag());

			if (isValidate == 0) {
				int i = nowDate.compareTo(startTime);
				int j = nowDate.compareTo(endTime);
				if (j < 0) {
					Map<String, Object> inputMap = new HashMap<String, Object>();
					inputMap.put("promotionId", promotionId);
					List<ProductPromotionVo> producList = productAutoMapper.queryByPromotionId(inputMap);
					if (producList != null && producList.size() > 0) {
						for (int k = 0; k < producList.size(); k++) {
							PromotionProductVo promotionProductVo = new PromotionProductVo();
							ProductPromotionVo productPromotionVo = producList.get(k);
							DTOUtils.map(productPromotionVo, promotionProductVo);
							// 原价
							BigDecimal costPrice = promotionProductVo.getCostPrice();
							// 折扣
							String discount = promotionProductVo.getDiscountPercent().toString();
							//

							promotionProductList.add(promotionProductVo);
						}
					}
					// TODO

					// TODO
				}

			}

			return map;
		} catch (Exception e) {
			logger.info("=======>>>>>>>查询商品参加的促销活动失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public String[] listToString(List<PromotionProductAuto> list, char separator) {
		
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < list.size(); i++) {
//			PromotionProductAuto promotionProductAuto = list.get(i);
//			sb.append(promotionProductAuto.getProductOrShopId()).append(separator);
//		}
		String[] sb = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			PromotionProductAuto promotionProductAuto = list.get(i);
//			sb.append(promotionProductAuto.getProductOrShopId()).append(separator);
			sb[i]= promotionProductAuto.getProductOrShopId().toString();
		}
		return sb;
	}
}
