package com.essential.bussiness.recommend.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.dao.ProductAutoMapper;
import com.essential.bussiness.product.model.auto.ProductAuto;
import com.essential.bussiness.promotion.controller.PromotionAutoController;
import com.essential.bussiness.promotion.model.vo.PromotionProductInfoVo;
import com.essential.bussiness.promotion.service.IPromotionAutoService;
import com.essential.bussiness.recommend.dao.RecommendAutoMapper;
import com.essential.bussiness.recommend.dao.RecommendPicAutoMapper;
import com.essential.bussiness.recommend.dao.RecommendRelatedProductAutoMapper;
import com.essential.bussiness.recommend.model.auto.RecommendAuto;
import com.essential.bussiness.recommend.model.auto.RecommendAutoExample;
import com.essential.bussiness.recommend.model.auto.RecommendRelatedProductAuto;
import com.essential.bussiness.recommend.model.auto.RecommendRelatedProductAutoExample;
import com.essential.bussiness.recommend.model.vo.QueryRecommendCarouselVo;
import com.essential.bussiness.recommend.model.vo.QueryRecommendRelatedProductForAppVO;
import com.essential.bussiness.recommend.model.vo.QueryRecommendRelatedProductVo;
import com.essential.bussiness.recommend.model.vo.QueryRecommendVo;
import com.essential.bussiness.recommend.model.vo.RecommendInputParamVo;
import com.essential.bussiness.recommend.model.vo.RecommendRelatedProductVo;
import com.essential.bussiness.recommend.model.vo.RelatedProductVo;
import com.essential.bussiness.recommend.service.IRecommendService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.TmDateUtil;
import com.essential.user.dao.UserBaseInfoAutoMapper;
import com.essential.user.model.auto.UserBaseInfoAuto;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * 推荐接口实现类
 * 
 * @author essential-gfs
 *
 */
@Service
public class RecommendServiceImpl implements IRecommendService {
	private Logger logger = LoggerFactory.getLogger(RecommendServiceImpl.class);

	// 注入推荐dao
	@Autowired
	RecommendAutoMapper recommendDao;
	// 注入推荐图片dao
	@Autowired
	RecommendPicAutoMapper recommendPicDao;
	// 注入推荐相关商品dao
	@Autowired
	RecommendRelatedProductAutoMapper recommendRelatedProductDao;
	// 注入用户基础信息dao
	@Autowired
	UserBaseInfoAutoMapper userDao;
	// 装配商品 dao
	@Autowired
	ProductAutoMapper productDao;
	// 注入优惠活动service
	@Autowired
	IPromotionAutoService promotionAutoService;
	@Autowired
	PromotionAutoController promotionAutoController;

	/**
	 * 新建推荐
	 */
	@Override
	public Map<String, Object> saveRecommend(RecommendAuto recommend,
			Long[] relatedProducts) {
		try {
			// 查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao
					.selectByPrimaryKey(recommend.getCreateUser());
			// 校验当前用户权限
			if (userBaseInfo == null
					|| userBaseInfo.getUserTypeId() == null
					|| SUConstants.USERTYPE_PATFORM != userBaseInfo
							.getUserTypeId()) {
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			// 组装推荐数据类型
			recommend.setCreateTime(TmDateUtil.getTimeStamp());
			recommend.setModifyTime(recommend.getCreateTime());
			recommend.setModifyUser(recommend.getCreateUser());
			recommend.setIsDelete(SUConstants.IS_NOT_DELETE);
			recommend.setAdvertisingPositionFlag(0);
			recommend.setStatus(0);

			// 数据库新增一条推荐记录
			int i = recommendDao.insert(recommend);
			if (i <= 0) {
				logger.info("新建推荐失败，insert返回i值为:" + i);
				throw new MyException("新建推荐失败");
			}

			// 遍历推荐相关商品数组
			for (Long relatedProductId : relatedProducts) {
				// 查询商品信息
				ProductAuto productAuto = productDao
						.selectByProductId(relatedProductId);
				if (productAuto == null) {
					logger.info("=========>>>>>>商品信息异常,未查到productId为："
							+ relatedProductId + "的商品信息");
					throw new MyException("未查到商品信息");
				}

				if (productAuto == null
						|| productAuto.getIsDelete() == SUConstants.IS_DELETE
						|| productAuto.getSaleStatus() != 1) {
					throw new MyException("商品" + productAuto.getProductName()
							+ "已删除或已下架");
				}

				// 组装推荐相关商品数据模型
				RecommendRelatedProductAuto recommendRelatedProductAuto = new RecommendRelatedProductAuto();
				recommendRelatedProductAuto.setCreateTime(recommend
						.getCreateTime());
				recommendRelatedProductAuto.setCreateUser(recommend
						.getCreateUser());
				recommendRelatedProductAuto.setModifyTime(recommend
						.getCreateTime());
				recommendRelatedProductAuto.setModifyUser(recommend
						.getCreateUser());
				recommendRelatedProductAuto
						.setIsDelete(SUConstants.IS_NOT_DELETE);
				recommendRelatedProductAuto.setProductId(relatedProductId);
				recommendRelatedProductAuto.setRecommendId(recommend
						.getRecommendId());
				recommendRelatedProductAuto.setShopId(productAuto.getShopId());

				// 新增一条推荐的相关商品记录
				i = 0;
				i = recommendRelatedProductDao
						.insert(recommendRelatedProductAuto);
				if (i <= 0) {
					logger.info("=========>>>>>>新建推荐失败，新增一条推荐的相关商品记录失败，insert返回i值为:"
							+ i);
					throw new MyException("新建推荐失败");
				}
			}

		} catch (Exception e) {
			logger.info("=========>>>>>>新建推荐异常");
			throw new RuntimeException(e);
		}
		return CommonResponseUtils.successResponse();
	}

	/**
	 * 查询推荐列表
	 */
	@Override
	public Map<String, Object> queryRecommend(String recommendTitle,
			Integer status, Long loginUserId, Integer pageNo, Integer pageCount) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		try {
			// 查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao
					.selectByPrimaryKey(loginUserId);
			// 校验当前用户权限
			if (userBaseInfo == null
					|| userBaseInfo.getUserTypeId() == null
					|| SUConstants.USERTYPE_PATFORM != userBaseInfo
							.getUserTypeId()) {
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			// 组装推荐数据类型
			// RecommendAuto recommend = new RecommendAuto();
			// recommend.setRecommendTitle(recommendTitle);
			// recommend.setStatus(status);
			// recommend.setIsDelete(SUConstants.IS_NOT_DELETE);

			if (StringUtils.isEmpty(recommendTitle)) {
				recommendTitle = null;
			}

			// 查询满足条件的推荐信息
			QueryRecommendVo queryRecommendVo = new QueryRecommendVo();
			queryRecommendVo.setRecommendTitle(recommendTitle);
			queryRecommendVo.setStatus(status);
			queryRecommendVo.setIsDelete(SUConstants.IS_NOT_DELETE);

			int totalCount = recommendDao
					.selectBySelectiveCount(queryRecommendVo);
			if (totalCount > 0) {
				if (pageNo != null) {
					if (pageCount == null) {
						pageCount = SUConstants.PAGE_COUNT;
					}
					queryRecommendVo.setPageCount(pageCount);
					queryRecommendVo.setPageNo((pageNo - 1)
							* queryRecommendVo.getPageCount());
				} else {
					queryRecommendVo.setPageNo(0);
					queryRecommendVo.setPageCount(SUConstants.PAGE_COUNT);
				}

				resMap.put("totalCount", totalCount);
				resMap.put("recommendList",
						recommendDao.selectBySelective(queryRecommendVo));
			} else {
				resMap.put("totalCount", totalCount);
				resMap.put("recommendList", null);
			}

			return CommonResponseUtils.successResponse(resMap);
		} catch (Exception e) {
			logger.info("=========>>>>>>新建推荐异常");
			throw new RuntimeException(e);
		}
	}

	/**
	 * 编辑推荐
	 */
	@Override
	public Map<String, Object> updateRecommend(RecommendAuto recommend,
			Long[] relatedProducts) {
		try {
			if (recommend.getRecommendId() == null) {
				return CommonResponseUtils.failureResponse("推荐编号不能为空");
			}

			// 查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao
					.selectByPrimaryKey(recommend.getModifyUser());
			// 校验当前用户权限
			if (userBaseInfo == null
					|| userBaseInfo.getUserTypeId() == null
					|| SUConstants.USERTYPE_PATFORM != userBaseInfo
							.getUserTypeId()) {
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}

			// 组装推荐数据类型
			recommend.setModifyTime(TmDateUtil.getTimeStamp());

			// 数据库新增一条推荐记录
			int i = recommendDao.updateByPrimaryKeySelective(recommend);
			if (i <= 0) {
				logger.info("编辑推荐失败，update返回i值为:" + i);
				throw new MyException("编辑推荐失败");
			}

			// 删除当前推荐的相关商品
			RecommendRelatedProductAutoExample recommendRelatedProductAutoExample = new RecommendRelatedProductAutoExample();
			recommendRelatedProductAutoExample.createCriteria()
					.andRecommendIdEqualTo(recommend.getRecommendId());
			i = 0;
			i = recommendRelatedProductDao
					.deleteByExample(recommendRelatedProductAutoExample);
			if (i < 0) {
				logger.info("编辑推荐失败，删除当前推荐的相关商品失败，delete返回i值为:" + i);
				throw new MyException("编辑推荐失败");
			}

			// 遍历推荐相关商品数组
			for (Long relatedProductId : relatedProducts) {
				// 查询商品信息
				ProductAuto productAuto = productDao
						.selectByProductId(relatedProductId);
				if (productAuto == null) {
					logger.info("=========>>>>>>商品信息异常,未查到productId为："
							+ relatedProductId + "的商品信息");
					throw new MyException("未查到商品信息");
				}

				if (productAuto == null
						|| productAuto.getIsDelete() == SUConstants.IS_DELETE
						|| productAuto.getSaleStatus() != 1) {
					throw new MyException("商品" + productAuto.getProductName()
							+ "已删除或已下架");
				}

				// 组装推荐相关商品数据模型
				RecommendRelatedProductAuto recommendRelatedProductAuto = new RecommendRelatedProductAuto();
				recommendRelatedProductAuto.setCreateTime(recommend
						.getCreateTime());
				recommendRelatedProductAuto.setCreateUser(recommend
						.getCreateUser());
				recommendRelatedProductAuto.setModifyTime(recommend
						.getCreateTime());
				recommendRelatedProductAuto.setModifyUser(recommend
						.getCreateUser());
				recommendRelatedProductAuto
						.setIsDelete(SUConstants.IS_NOT_DELETE);
				recommendRelatedProductAuto.setProductId(relatedProductId);
				recommendRelatedProductAuto.setRecommendId(recommend
						.getRecommendId());
				recommendRelatedProductAuto.setShopId(productAuto.getShopId());

				// 新增一条推荐的相关商品记录
				i = 0;
				i = recommendRelatedProductDao
						.insert(recommendRelatedProductAuto);
				if (i <= 0) {
					logger.info("=========>>>>>>编辑推荐失败，新增一条推荐的相关商品记录失败，insert返回i值为:"
							+ i);
					throw new MyException("编辑推荐失败");
				}
			}

		} catch (Exception e) {
			logger.info("=========>>>>>>编辑推荐异常");
			throw new RuntimeException(e);
		}
		return CommonResponseUtils.successResponse();
	}

	/**
	 * 查询推荐轮播图
	 */
	@Override
	public Map<String, Object> queryRecommendCarouselPic() {
		try {

			List<QueryRecommendCarouselVo> queryRecommendCarouselVoList = recommendDao
					.selectRecommendCarousel();
			return CommonResponseUtils
					.successResponse(queryRecommendCarouselVoList);
		} catch (Exception e) {
			logger.info("查询推荐轮播图失败");
			throw new RuntimeException(e);
		}

	}

	/**
	 * 查询推荐的相关商品
	 */
	@Override
	public Map<String, Object> queryRecommendRelatedProduct(Long recommendId,
			Integer pageNo, Integer pageCount) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		try {
			// 查询满足条件推荐的相关商品
			QueryRecommendRelatedProductVo queryRecommendRelatedProductVo = new QueryRecommendRelatedProductVo();
			queryRecommendRelatedProductVo.setRecommendId(recommendId);
			queryRecommendRelatedProductVo
					.setIsDelete(SUConstants.IS_NOT_DELETE);

			int totalCount = recommendRelatedProductDao
					.selectRecommendRelatedProductCount(queryRecommendRelatedProductVo);
			if (totalCount > 0) {
				if (pageNo != null) {
					if (pageCount == null) {
						pageCount = SUConstants.PAGE_COUNT;
					}
					queryRecommendRelatedProductVo.setPageCount(pageCount);

					queryRecommendRelatedProductVo.setPageNo((pageNo - 1)
							* queryRecommendRelatedProductVo.getPageCount());
				} 

				List<RecommendRelatedProductVo> relatedProductList = recommendRelatedProductDao
						.selectRecommendRelatedProduct(queryRecommendRelatedProductVo);
				for (int i = 0; i < relatedProductList.size(); i++) {

					PromotionProductInfoVo promotionProductInfoVo = buildActivityPrice(relatedProductList
							.get(i).getProductId());

					if (promotionProductInfoVo != null) {
						if (promotionProductInfoVo.getPromotionType() == 0) {// 打折
							relatedProductList.get(i).setActivityFlag(1);
							relatedProductList
									.get(i)
									.setActivityPrice(
											relatedProductList
													.get(i)
													.getCostPrice()
													.multiply(
															new BigDecimal(
																	Float.toString(promotionProductInfoVo
																			.getDiscountPercent()))
																	.divide(new BigDecimal(
																			10))));
						} else if (promotionProductInfoVo.getPromotionType() == 1) {// 满减送
							relatedProductList.get(i).setActivityFlag(2);
							relatedProductList
									.get(i)
									.setActivityPrice(
											relatedProductList
													.get(i)
													.getCostPrice()
													.subtract(
															promotionProductInfoVo
																	.getDiscountMoney()));

						}

					} else {
						relatedProductList.get(i).setActivityFlag(0);
					}
				}

				resMap.put("totalCount", totalCount);
				resMap.put("relatedProducts", relatedProductList);
			} else {
				resMap.put("totalCount", totalCount);
				resMap.put("relatedProducts", null);
			}
			return CommonResponseUtils.successResponse(resMap);

		} catch (Exception e) {
			logger.info("=========>>>>>>查询推荐的相关商品异常");
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询推荐列表(app前段)
	 */
	@Override
	public Map<String, Object> queryRecommendListForApp(
			RecommendInputParamVo recommendInputParamVo) {
		/*System.out.println(recommendInputParamVo.getStatusTime());
		System.out.println(recommendInputParamVo.getRequestType());*/
		Map<String,Object> inputParameterMap=new HashMap<String, Object>();
		List<QueryRecommendRelatedProductForAppVO> queryRecommendRelatedProductForAppVOList = new ArrayList<QueryRecommendRelatedProductForAppVO>();
		List<RelatedProductVo> RelatedProductVoList=new ArrayList<RelatedProductVo>();
		
		try {
			List<QueryRecommendCarouselVo> list = recommendDao
					.selectRecommendListForAPP(recommendInputParamVo);

			for (int i = 0; i < list.size(); i++) {
				QueryRecommendRelatedProductForAppVO queryRecommendRelatedProductForAppVO = new QueryRecommendRelatedProductForAppVO();
				DTOUtils.map(list.get(i),queryRecommendRelatedProductForAppVO);
				queryRecommendRelatedProductForAppVOList.add(queryRecommendRelatedProductForAppVO);

			}
			for (int i = 0; i < queryRecommendRelatedProductForAppVOList.size(); i++) {
				
				if(queryRecommendRelatedProductForAppVOList.get(i).getRecommendType().equals(3))
				{
					
					inputParameterMap.put("recommendId", queryRecommendRelatedProductForAppVOList.get(i).getRecommendId());
					RelatedProductVoList=recommendDao.selectProductListToApp(inputParameterMap);
					
					//活动内容
					
					/* 华丽分割线下面是查活动的内容 */

					for (int k = 0; k < RelatedProductVoList.size(); k++) {
						
						// 查询活动
						Map<String, Object> mappromotion = promotionAutoController
								.productPromotion(Long.parseLong(RelatedProductVoList.get(k).getProductId()));
						/*System.out.println(Long.parseLong(RelatedProductVoList.get(k).getProductId()));*/
						PromotionProductInfoVo promotionProductInfoVo = (PromotionProductInfoVo) mappromotion
								.get("info");

						// code=3就是没有活动
						if (mappromotion.get("code").equals("3")) {

							// 没有活动
							RelatedProductVoList.get(k).setIsDiscount("0");
							RelatedProductVoList.get(k).setDiscountPrice(0);
				
							
							
						}
						// code=1就是有活动
						if (mappromotion.get("code").equals("1")) {
							RelatedProductVoList.get(k).setIsDiscount("1");
							for (String o : mappromotion.keySet())

							{
								float costPrice = Float.parseFloat(RelatedProductVoList.get(k).getCostPrice());
							/*	System.out.println(costPrice);*/
								// 原价
								float percent = promotionProductInfoVo
										.getDiscountPercent();// 打折的百分比
								float discountCostprice = (costPrice * percent) / 10;

								discountCostprice = (float) (Math.round(discountCostprice * 100))/100;
								
								RelatedProductVoList.get(k).setDiscountPrice(discountCostprice);

							}

						}

					}
					
					//活动内容
					queryRecommendRelatedProductForAppVOList.get(i).setRelatedProductList(RelatedProductVoList);
				}
				
				

			}

			return CommonResponseUtils.successResponse(queryRecommendRelatedProductForAppVOList);

		} catch (Exception e) {
			logger.info("查询推荐列表失败");
			throw new RuntimeException(e);

		}
	}

	/**
	 * 上下线设置及广告位管理
	 * 
	 * @param type
	 *            设置类型 1：置顶设置，2：广告位设置，3：上下线设置
	 * @param flag
	 *            1：是，0：否
	 */
	@Override
	public Map<String, Object> updateRecommendAdvertisingPosition(
			Long recommendId, Integer flag, Integer type) {
		try {
			if (recommendId == null || flag == null || (flag != 1 && flag != 0)
					|| type == null || (type != 1 && type != 2 && type != 3)) {
				return CommonResponseUtils.failureResponse("参数异常");
			}

			RecommendAuto recommend = new RecommendAuto();
			recommend.setRecommendId(recommendId);

			if (type == 1) {
				if (flag == 1) {
					RecommendAuto record = new RecommendAuto();
					record.setRecommendSort(0);
					RecommendAutoExample example = new RecommendAutoExample();
					example.createCriteria().andRecommendSortEqualTo(1);

					int j = recommendDao.updateByExampleSelective(record,
							example);
					if (j <= 0) {
						logger.info("=========>>>>>>置顶失败");
						throw new MyException("置顶失败");
					}
					recommend.setRecommendSort(1);
				} else {
					recommend.setRecommendSort(0);
				}
			} else if (type == 2) {
				if (flag == 1) {
					RecommendAutoExample example = new RecommendAutoExample();
					example.createCriteria().andAdvertisingPositionFlagEqualTo(1)
						.andIsDeleteNotEqualTo(SUConstants.IS_DELETE);
					List<RecommendAuto> adcerts = recommendDao.selectByExample(example);
					if(adcerts != null && adcerts.size() >= 8){
						return CommonResponseUtils.failureResponse("广告位最多可设置8个");
					}
					
					recommend.setAdvertisingPositionFlag(1);
				} else {
					recommend.setAdvertisingPositionFlag(0);
				}
			} else if (type == 3) {
				if (flag == 1) {
					recommend.setStatus(1);
				} else {
					recommend.setStatus(0);
				}
				recommend.setStatusTime(TmDateUtil.getTimeStamp());
			} else {
				return CommonResponseUtils.failureResponse("参数异常");
			}
			int i = recommendDao.updateByPrimaryKeySelective(recommend);
			if (i <= 0) {
				logger.info(type == 3 ? "上下线设置失败" : "广告位设置失败");
				throw new MyException(type == 3 ? "上下线设置失败" : "广告位设置失败");
			}

			return CommonResponseUtils.successResponse();
		} catch (Exception e) {
			logger.info(type == 3 ? "上下线设置失败" : "广告位设置失败");
			throw new RuntimeException(e);

		}
	}

	/**
	 * 查询优惠活动
	 * 
	 * @param productId
	 *            商品id
	 * @return
	 * @throws Exception
	 */
	@Override
	public PromotionProductInfoVo buildActivityPrice(Long productId)
			throws Exception {
		// 查询商品优惠价格
		Map<String, Object> activityPriceMap = promotionAutoService
				.productPromotion(productId);
		if ("1".equals(activityPriceMap.get(SUConstants.CODE_KEY))) {
			PromotionProductInfoVo promotionProductInfoVo = (PromotionProductInfoVo) activityPriceMap
					.get(SUConstants.INFO_KEY);
			return promotionProductInfoVo;
		} else if ("0".equals(activityPriceMap.get(SUConstants.CODE_KEY))) {
			throw new Exception("查询商品优惠价格失败");
		}
		return null;
	}

	/**
	 * 查询推荐详情通过推荐id
	 */
	@Override
	public Map<String, Object> queryRecommendDetail(long recommendId,
			int pageIndex) {
		try {
			// 查询推荐的详情
			Map<String, Object> returnMap = new HashMap<String, Object>();
			RecommendAuto recommendAuto = recommendDao
					.selectByPrimaryKey(recommendId);
			// 查询推荐的相关商品
			Map<String, Object> intputParamterMap = new HashMap<String, Object>();
			String recommendI0d = String.valueOf(recommendId);
			intputParamterMap.put("pageIndex", (pageIndex - 1)
					*12);
			intputParamterMap.put("pageSize",12);
			intputParamterMap.put("recommendId", Integer.parseInt(recommendI0d));
			List<Map<String, Object>> list = recommendDao
					.selectRcommendProduct(intputParamterMap);

			/* 华丽分割线下面是查活动的内容 */

			for (int i = 0; i < list.size(); i++) {

				list.get(i).put("productId", list.get(i).get("product_id"));
				list.get(i).remove("product_id");

				list.get(i).put("brandName", list.get(i).get("brand_name"));
				list.get(i).remove("brand_name");

				list.get(i).put("productName", list.get(i).get("product_name"));
				list.get(i).remove("product_name");

				list.get(i).put("costPrice", list.get(i).get("cost_price"));
				list.get(i).remove("cost_price");

				// 查询活动
				Map<String, Object> mappromotion = promotionAutoController
						.productPromotion(Long.parseLong(list.get(i)
								.get("productId").toString()));
				PromotionProductInfoVo promotionProductInfoVo = (PromotionProductInfoVo) mappromotion
						.get("info");

				// code=3就是没有活动
				if (mappromotion.get("code").equals("3")) {

					// 没有活动.
					list.get(i).put("IsDiscount", "0");
					list.get(i).put("DiscountPrice","0");

				}
				// code=1就是有活动
				if (mappromotion.get("code").equals("1")) {
					list.get(i).put("IsDiscount", "1");
					for (String o : mappromotion.keySet())

					{
						float costPrice = Float.parseFloat(list.get(i)
								.get("costPrice").toString());
						// 原价
						float percent = promotionProductInfoVo
								.getDiscountPercent();// 打折的百分比
						float discountCostprice = (costPrice * percent) / 10;

						discountCostprice = (float) (Math.round(discountCostprice * 100))/100;
						list.get(i).put("DiscountPrice", discountCostprice);

					}

				}

			}

			returnMap.put("recommendDetail", recommendAuto);
			returnMap.put("relatedProduct", list);
			/* 华丽分割线上面是活动的内容 */
			return CommonResponseUtils.successResponse(returnMap);
			

		} catch (Exception e) {
			logger.info("查询推荐详情失败");
			throw new RuntimeException(e);

		}

	}
	
	
	
	/**
	 * 查询广告管理列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> queryAdvertisingForList(String recommendTitle,
			Integer status, Long loginUserId, Integer pageNo, Integer pageCount) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		try {
			resMap = queryRecommend(recommendTitle, status, loginUserId, pageNo, pageCount);
			
			if(SUConstants.CODE_SUCCESS_VALUE.equals(resMap.get(SUConstants.CODE_KEY))){
				QueryRecommendVo queryRecommendVo = new QueryRecommendVo();
				queryRecommendVo.setIsDelete(SUConstants.IS_NOT_DELETE);
				queryRecommendVo.setAdvertisingPositionFlag(1);
				
				Map<String, Object> infoMap = (Map<String, Object>) resMap.get(SUConstants.INFO_KEY);
				infoMap.put("advertList", recommendDao.selectBySelective(queryRecommendVo));
			}
			
			return resMap;
		} catch (Exception e) {
			logger.info("=========>>>>>>查询广告管理列表异常");
			throw new RuntimeException(e);
		}
	}

}
