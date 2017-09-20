package com.essential.user.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.essential.bussiness.brand.dao.BrandAutoMapper;
import com.essential.bussiness.brand.model.auto.BrandAuto;
import com.essential.bussiness.product.model.vo.Count;
import com.essential.bussiness.product.model.vo.ProductBaseInfoVo;
import com.essential.bussiness.product.model.vo.ProductInfoWithPromotionVo;
import com.essential.bussiness.product.model.vo.ProductOrShopCountVo;
import com.essential.bussiness.promotion.model.vo.PromotionProductInfoVo;
import com.essential.bussiness.promotion.service.IPromotionAutoService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.StringCommonUtils;
import com.essential.common.utils.TmDateUtil;
import com.essential.user.dao.UserBaseInfoAutoMapper;
import com.essential.user.dao.UserCollectionAutoMapper;
import com.essential.user.model.auto.UserCollectionAuto;
import com.essential.user.service.IUserCollectionService;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * @author Jaelyn
 *
 *         用户基本信息
 */
@Service
public class UserCollectionServiceImpl implements IUserCollectionService {

	/**
	 * 用户收藏
	 */
	@Autowired
	private UserCollectionAutoMapper userCollectionAutoMapper;

	/**
	 * 
	 */
	@Autowired
	private BrandAutoMapper brandAutoMapper;

	@Autowired
	private UserBaseInfoAutoMapper userBaseInfoAutoMapper;

	@Autowired
	@Qualifier("promotionAutoServiceImpl")
	private IPromotionAutoService promotionAutoServiceImple;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.essential.user.service.impl.IUserCollectionService#selectByPrimaryKey
	 * (java.lang.Long)
	 */
	@Override
	public UserCollectionAuto selectByPrimaryKey(Long collectionId) {
		return userCollectionAutoMapper.selectByPrimaryKey(collectionId);
	}

	/*
	 * 根据用户id，类别 和 类别id 等查找收藏的信息 可以根据返回的个数 判断是否收藏
	 * 
	 * @see
	 * com.essential.user.service.impl.IUserCollectionService#selectByParamSelective
	 * (java.util.Map)
	 */
	@Override
	public Map<String, Object> queryByParamSelective(UserCollectionAuto userCollectionAuto) {
		try {

			Integer collectionType = userCollectionAuto.getCollectionType();
			Long userId = userCollectionAuto.getUserId();

			if (collectionType == null || StringCommonUtils.isInvalidateId(userId)) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			userCollectionAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			if (userCollectionAuto.getPageSize() == null) {
				userCollectionAuto.setPageSize(SUConstants.PAGE_COUNT);
			}
			ArrayList dataList = new ArrayList();
			switch (collectionType) {
			case 0:// 文章
				dataList = userCollectionAutoMapper.queryArticleList(userCollectionAuto);
				break;
			case 1:// 精选
				dataList = userCollectionAutoMapper.querySpecialList(userCollectionAuto);
				break;
			case 2:// 店铺
				dataList = userCollectionAutoMapper.queryShopList(userCollectionAuto);
				break;
			case 3:// 商品
				userCollectionAuto.setPageSize(12);
				dataList = userCollectionAutoMapper.queryProductList(userCollectionAuto);
				dataList = queryProductPromotionInfo(dataList);
				break;
			case 4:// 日志
				dataList = userCollectionAutoMapper.queryBlogList(userCollectionAuto);
				break;
			case 5:// 品牌
				dataList = userCollectionAutoMapper.queryBrandList(userCollectionAuto);
				break;
			default:
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			return CommonResponseUtils.successResponse(dataList);

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}

	private ArrayList queryProductPromotionInfo(ArrayList dataList) {
		ArrayList productList = new ArrayList();
		for (int i = 0; i < dataList.size(); i++) {
			ProductBaseInfoVo productBaseInfoVo = new ProductBaseInfoVo();
			try {
				ProductInfoWithPromotionVo promotionProductInfoVo = (ProductInfoWithPromotionVo) dataList.get(i);
				DTOUtils.map(promotionProductInfoVo, productBaseInfoVo);
				Integer isValidate = promotionProductInfoVo.getIsValidate();
				String startTime = promotionProductInfoVo.getStartTime();
				String endTime = promotionProductInfoVo.getEndTime();
				String timeStamp = TmDateUtil.getTimeStamp();
				if (StringCommonUtils.isEmpty(startTime) || StringCommonUtils.isEmpty(endTime) || isValidate == null || isValidate == 1 || startTime.compareTo(timeStamp) > 0
						|| endTime.compareTo(timeStamp) < 0) {// 有折扣
					productBaseInfoVo.setIsDiscount(SUConstants.PROMOTION_TYPE_NONE);
				} else {
					Integer promotionType = promotionProductInfoVo.getPromotionType();
					if (promotionType != null && promotionType == SUConstants.PROMOTION_TYPE_DISCOUNT) {
						BigDecimal promotionPrice = new BigDecimal(productBaseInfoVo.getCostPrice() * promotionProductInfoVo.getDiscountPercent() / 10);
						BigDecimal discountPrice = promotionPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
						productBaseInfoVo.setDiscountPrice(discountPrice.doubleValue());
						productBaseInfoVo.setTag(promotionProductInfoVo.getTag());
						productBaseInfoVo.setIsDiscount(SUConstants.PROMOTION_TYPE_PROMOTION);

					} else {
						productBaseInfoVo.setIsDiscount(SUConstants.PROMOTION_TYPE_NONE);
					}

				}
			} catch (Exception e) {

			}
			productList.add(productBaseInfoVo);
		}
		return productList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.essential.user.service.impl.IUserCollectionService#saveCollection
	 * (java.util.HashMap)
	 */
	@Override
	public Map<String, Object> saveCollection(UserCollectionAuto userCollectionAuto) {
		try {
			String timeStamp = TmDateUtil.getTimeStamp();
			userCollectionAuto.setCreateTime(timeStamp);
			userCollectionAuto.setModifyTime(timeStamp);
			int num = userCollectionAutoMapper.insert(userCollectionAuto);
			if (num > 0) {
				return CommonResponseUtils.successResponse("收藏成功");
			} else {
				return CommonResponseUtils.successResponse("收藏失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.essential.user.service.impl.IUserCollectionService#isCollection(java
	 * .util.HashMap)
	 */
	@Override
	public int queryIsCollection(UserCollectionAuto userCollectionAuto) {
		try {
			userCollectionAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<UserCollectionAuto> userCollectionAutoList = userCollectionAutoMapper.selectByParamSelective(userCollectionAuto);
			return userCollectionAutoList.size() > 0 ? SUConstants.IS_COLLECTED : SUConstants.IS_NOT_COLLECTED;
		} catch (Exception e) {
			e.printStackTrace();
			return SUConstants.IS_NOT_COLLECTED;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.essential.user.service.impl.IUserCollectionService#savaOrCancelCollection
	 * (java.util.Map)
	 */
	@Override
	public Map<String, Object> savaOrCancelCollection(UserCollectionAuto userCollectionAuto) {
		// 已经存在 删除
		try {
			Long contentId = userCollectionAuto.getContentId();
			Integer collectionType = userCollectionAuto.getCollectionType();
			Long userId = userCollectionAuto.getUserId();
			if (contentId == null || contentId <= 0 || collectionType == null || collectionType < 0 || userId == null || userId <= 0) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			String msg = "";
			Map<String, Object> responseMap = new HashMap<String, Object>();
			userCollectionAuto.setPageSize(1);
			List<UserCollectionAuto> userCollectionAutoList = userCollectionAutoMapper.selectByParamSelective(userCollectionAuto);
			if (userCollectionAutoList.size() > 0) {
				UserCollectionAuto userCollectionAuto1 = userCollectionAutoMapper.selectByParamSelective(userCollectionAuto).get(0);
				int num = userCollectionAutoMapper.deleteByPrimaryKey(userCollectionAuto1.getCollectionId());
				if (num > 0) {
					responseMap.put(SUConstants.KEY_IS_COLLECTED, SUConstants.IS_NOT_COLLECTED);
					responseMap.put("contentId", contentId);
					responseMap.put(SUConstants.MSG_KEY, "取消成功");
					msg = "取消成功";
				} else {
					throw new MyException("取消失败");
				}
			} else {
				String timeStamp = TmDateUtil.getTimeStamp();
				userCollectionAuto.setCreateTime(timeStamp);
				userCollectionAuto.setModifyTime(timeStamp);
				userCollectionAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
				int num = userCollectionAutoMapper.insert(userCollectionAuto);
				if (num > 0) {
					responseMap.put(SUConstants.KEY_IS_COLLECTED, SUConstants.IS_COLLECTED);
					responseMap.put(SUConstants.MSG_KEY, "收藏成功");
					responseMap.put("contentId", contentId);
					if (collectionType == 5) {
						msg = "关注成功";
					} else {
						msg = "收藏成功";
					}
				} else {
					throw new MyException("收藏失败");
				}

			}
			try {
				UserCollectionAuto userCollectionAuto1 = new UserCollectionAuto();
				userCollectionAuto1.setContentId(contentId);
				userCollectionAuto1.setCollectionType(collectionType);
				userCollectionAuto1.setIsDelete(SUConstants.IS_NOT_DELETE);
				switch (collectionType) {
				case 0:// 文章
					break;
				case 1:// 精选
					break;
				case 2:// 店铺
					break;
				case 3:// 商品
					break;
				case 4:// 日志
					break;
				case 5:// 品牌
					Integer count = userCollectionAutoMapper.queryCount(userCollectionAuto1);
					BrandAuto brandAuto = new BrandAuto();
					brandAuto.setBrandId(contentId);
					brandAuto.setCollectionCount(count);
					brandAutoMapper.updateByPrimaryKeySelective(brandAuto);
					break;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return CommonResponseUtils.successResponse(responseMap);
		} catch (MyException e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse();
		}

	}

	/**
	 * 用户统计
	 * 
	 * @return
	 */
	@Override
	public Map<String, Object> userCount() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ProductOrShopCountVo productOrShopCountVo = userBaseInfoAutoMapper.userCount();
			map.putAll(CommonResponseUtils.successResponse(productOrShopCountVo));
		} catch (Exception e) {
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("用户同时失败!"));
		}
		return map;
	}
}
