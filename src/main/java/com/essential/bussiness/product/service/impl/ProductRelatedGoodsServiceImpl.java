package com.essential.bussiness.product.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.dao.ProductAutoMapper;
import com.essential.bussiness.product.model.vo.ProductBaseInfoVo;
import com.essential.bussiness.product.model.vo.ProductInfoWithPromotionVo;
import com.essential.bussiness.product.service.IProductRelatedGoodsService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.StringCommonUtils;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * 相关商品类Service
 * 
 * @author czm
 *
 */
@Service
public class ProductRelatedGoodsServiceImpl implements IProductRelatedGoodsService {
	private static Logger logger = LoggerFactory.getLogger(ProductRelatedGoodsServiceImpl.class);

	@Autowired
	ProductAutoMapper productAutoMapper;

	@Override
	public Map<String, Object> queryRelatedGoodsService(HttpServletRequest request) {
		Map<String, Object> inputMap = new HashMap<String, Object>();
		try {
			// 商品Id
			String productId = request.getParameter("productId");
			// 页数
			Integer pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
			if (pageIndex == null || pageIndex.intValue() < 0) {
				pageIndex = 1;
			}
			// 请求返回的条数
			Integer pageSize = 12;
			inputMap.put("pageSize", pageSize);
			inputMap.put("pageIndex", (pageIndex - 1) * pageSize);
			inputMap.put("isDelete", SUConstants.IS_NOT_DELETE);
			inputMap.put("productId", productId);
			ArrayList<ProductInfoWithPromotionVo> productCategoryList = (ArrayList<ProductInfoWithPromotionVo>) productAutoMapper.queryProductRelatedGoods(inputMap);
			ArrayList<ProductBaseInfoVo> productBaseInfoVos = queryProductPromotionInfo(productCategoryList);
			return CommonResponseUtils.successResponse(productBaseInfoVos);

		} catch (Exception e) {
			logger.info("==========>>>>>>>>>>>相关商品查询失败" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private ArrayList<ProductBaseInfoVo> queryProductPromotionInfo(ArrayList<ProductInfoWithPromotionVo> dataList) {
		ArrayList<ProductBaseInfoVo> productList = new ArrayList<ProductBaseInfoVo>();
		for (int i = 0; i < dataList.size(); i++) {
			ProductBaseInfoVo productBaseInfoVo = new ProductBaseInfoVo();
			try {
				ProductInfoWithPromotionVo promotionProductInfoVo = dataList.get(i);
				DTOUtils.map(promotionProductInfoVo, productBaseInfoVo);
				Integer isValidate = promotionProductInfoVo.getIsValidate();
				String startTime = promotionProductInfoVo.getStartTime();
				String endTime = promotionProductInfoVo.getEndTime();
				String timeStamp = TmDateUtil.getTimeStamp();
				if (StringCommonUtils.isEmpty(startTime) || StringCommonUtils.isEmpty(endTime) || isValidate == null || isValidate.intValue() == 1 || startTime.compareTo(timeStamp) > 0
						|| endTime.compareTo(timeStamp) < 0) {
					// 没有折扣
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
}
