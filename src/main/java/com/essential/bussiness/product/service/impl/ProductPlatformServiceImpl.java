package com.essential.bussiness.product.service.impl;

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
import com.essential.bussiness.product.dao.ProductPicAutoMapper;
import com.essential.bussiness.product.dao.ProductSkuAutoMapper;
import com.essential.bussiness.product.dao.ProductSkuRelationAutoMapper;
import com.essential.bussiness.product.model.auto.ProductAuto;
import com.essential.bussiness.product.model.auto.ProductPicAuto;
import com.essential.bussiness.product.model.auto.ProductSkuAuto;
import com.essential.bussiness.product.model.auto.ProductSkuRelationAuto;
import com.essential.bussiness.product.model.vo.Count;
import com.essential.bussiness.product.model.vo.ProductAutoAddField;
import com.essential.bussiness.product.model.vo.ProductDetaileInfoPlatformVo;
import com.essential.bussiness.product.model.vo.ProductPlatformInfoVo;
import com.essential.bussiness.product.model.vo.ProductPlatformVo;
import com.essential.bussiness.product.model.vo.ProductSKUInfoPlatformVo;
import com.essential.bussiness.product.model.vo.ProductSKURelationInfoPlatformVo;
import com.essential.bussiness.product.model.vo.RejectProductReasonVo;
import com.essential.bussiness.product.service.IProductPlatformService;
import com.essential.bussiness.promotion.controller.PromotionAutoController;
import com.essential.bussiness.promotion.model.vo.PromotionProductInfoVo;
import com.essential.bussiness.rejectreason.dao.RejectReasonAutoMapper;
import com.essential.bussiness.rejectreason.model.auto.RejectReasonAuto;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;

@Service
public class ProductPlatformServiceImpl implements IProductPlatformService {
	private static Logger logger = LoggerFactory.getLogger(ProductPlatformServiceImpl.class);

	// 商品
	@Autowired
	ProductAutoMapper productAutoMapper;

	// 原因表
	@Autowired
	RejectReasonAutoMapper rejectReasonAutoMapper;

	// 商品图片表
	@Autowired
	ProductPicAutoMapper productPicAutoMapper;

	// 商品规格表（SKU）
	@Autowired
	ProductSkuAutoMapper productSkuAutoMapper;

	// 商品规格关系表（SKU Relation）
	@Autowired
	ProductSkuRelationAutoMapper productSkuRelationAutoMapper;

	// 活动
	@Autowired
	PromotionAutoController promotionAutoController;

	/**
	 * 查询商品
	 */
	@Override
	public Map<String, Object> queryProductPlatform(ProductPlatformVo productPlatformVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer type = productPlatformVo.getType();
		try {
			Integer pageIndxs = productPlatformVo.getPageIndex();
			Integer pageSize = productPlatformVo.getPageSize();
			if (pageSize == null) {
				pageSize = 20;
			}
			if (pageIndxs == null) {
				pageIndxs = 1;
			}
			if ("".equals(productPlatformVo.getLinkFrom())) {
				productPlatformVo.setLinkFrom(null);
			}
			if ("".equals(productPlatformVo.getProductName())) {
				productPlatformVo.setProductName(null);
			}
			if ("".equals(productPlatformVo.getArticleNumber())) {
				productPlatformVo.setArticleNumber(null);
			}
			if ("".equals(productPlatformVo.getShopName())) {
				productPlatformVo.setShopName(null);
			}
			if ("".equals(productPlatformVo.getLinkUrl())) {
				productPlatformVo.setLinkUrl(null);
			}
			Integer pageIndx = (pageIndxs - 1) * pageSize;
			productPlatformVo.setPageIndex(pageIndx);
			productPlatformVo.setPageSize(pageSize);
			productPlatformVo.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<ProductPlatformVo> productPlatformList = productAutoMapper.queryProductPlatform(productPlatformVo);
			for (int i = 0; i < productPlatformList.size(); i++) {
				ProductPlatformVo productPlatform = productPlatformList.get(i);
				// 是否活动 0-没有活动，1-有活动
				// String linkUrl = productPlatform.getLinkUrl();
				// if ("1".equals(linkUrl)) {
				Map<String, Object> promotionMap = promotionAutoController.productPromotion(productPlatform.getProductId());
				if (SUConstants.CODE_SUCCESS_VALUE.equals(promotionMap.get(SUConstants.CODE_KEY))) {
					PromotionProductInfoVo promotionProductInfoVo = (PromotionProductInfoVo) promotionMap.get(SUConstants.INFO_KEY);
					String tag = promotionProductInfoVo.getTag();
					Integer promotionType = promotionProductInfoVo.getPromotionType();
					if (promotionType == 0) {
						BigDecimal promotionPrice = new BigDecimal(promotionProductInfoVo.getDiscountPercent()).multiply(productPlatform.getCostPrice()).divide(new BigDecimal(10));
						BigDecimal discountPrice = promotionPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
						// 活动价格
						productPlatform.setDiscountPrice(discountPrice);
					}
					// 活动标签
					productPlatform.setTag(tag);
					// 是否有活动 0-没有活动，1-有活动
					productPlatform.setLinkUrl("1");
				}else{
					// 是否有活动 0-没有活动，1-有活动
					productPlatform.setLinkUrl("0");
				}
				// }

				// 是否自营
				String linkFrom = productPlatform.getLinkFrom();
				if ("1".equals(linkFrom)) {
					productPlatform.setSelfName("是");
				} else {
					productPlatform.setSelfName("否");
				}
				// 商品状态
				Integer saleStatus = productPlatform.getSaleStatus();
				if (saleStatus == 0) {
					productPlatform.setProductStatusName("下架");
				} else if (saleStatus == 1) {
					productPlatform.setProductStatusName("上架");
				} else {
					productPlatform.setProductStatusName("强制下架");
				}
			}
			// 获取总条数
			Count pageCount = productAutoMapper.queryCount(productPlatformVo);
			ProductPlatformInfoVo productPlatformInfoVo = new ProductPlatformInfoVo();
			productPlatformInfoVo.setProductPlatformList(productPlatformList);
			productPlatformInfoVo.setPageCount(pageCount.getCount());
			map.putAll(CommonResponseUtils.successResponse(productPlatformInfoVo));
			return map;
		} catch (Exception e) {
			if (type == 0) {
				logger.info("======>>>>>>查询商品失败:" + e);
			} else {
				logger.info("======>>>>>>查询强制下架商品失败:" + e);
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 强制下架/撤销强制下架
	 * 
	 * type 0-撤销强制下架，1-强制下架
	 */
	@Override
	public Map<String, Object> forceOrRevokeProductPlatform(RejectProductReasonVo rejectProductReasonVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer type = rejectProductReasonVo.getType();
		try {
			// 商品Id
			Long productId = rejectProductReasonVo.getProductId();
			// 登录用户Id
			Long logenUserId = rejectProductReasonVo.getLogenUserId();

			ProductAuto productAuto = new ProductAuto();
			productAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			productAuto.setProductId(productId);

			RejectReasonAuto rejectReasonAuto = new RejectReasonAuto();
			// 商品Id
			rejectReasonAuto.setRejectWorkId(productId);
			// 原因类型
			rejectReasonAuto.setRejectType(0);

			if (type == 0) {
				// 是否删除
				rejectReasonAuto.setIsDelelte(SUConstants.IS_DELETE);
				rejectReasonAuto.setModifyTime(TmDateUtil.getTimeStamp());
				rejectReasonAuto.setModifyUser(logenUserId);
				// 根据商品Id进行逻辑删除
				int k = rejectReasonAutoMapper.updateByProductId(rejectReasonAuto);
				if (k <= 0) {
					throw new Exception("原因删除失败!");
				}
				// 先放到仓库中
				productAuto.setSaleStatus(0);
			} else {
				// 原因
				rejectReasonAuto.setRejectReasonContent(rejectProductReasonVo.getRejectReasonContent());
				// 是否删除
				rejectReasonAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);
				rejectReasonAuto.setCreateUser(logenUserId);
				rejectReasonAuto.setCreatTime(TmDateUtil.getTimeStamp());
				int j = rejectReasonAutoMapper.insertSelective(rejectReasonAuto);
				if (j <= 0) {
					throw new Exception("原因添加失败!");
				}
				// 强制下架
				productAuto.setSaleStatus(2);
				// 是否活动 0-没有活动，1-有活动
				productAuto.setLinkUrl("0");

			}
			int i = productAutoMapper.updateByPrimaryKeySelective(productAuto);
			if (i <= 0) {
				if (type == 0) {
					throw new Exception("撤销强制下架失败!");
				} else {
					throw new Exception("强制下架失败!");
				}
			}
			if (type == 0) {
				map.putAll(CommonResponseUtils.successResponse("撤销强制下架成功!"));
			} else {
				map.putAll(CommonResponseUtils.successResponse("强制下架成功!"));
			}

			return map;
		} catch (Exception e) {
			if (type == 0) {
				logger.info("======>>>>>>撤销强制下架失败:" + e);
			} else {
				logger.info("======>>>>>>强制下架失败:" + e);
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 设置自营/取消自营
	 * 
	 * 0-取消自营，1-设置自营
	 */
	@Override
	public Map<String, Object> selfProductPlatform(Long productId, Integer type) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ProductAuto productAuto = new ProductAuto();
			productAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			productAuto.setProductId(productId);
			if (type == 0) {
				// 取消自营
				productAuto.setLinkFrom("0");
			} else {
				// 设置自营
				productAuto.setLinkFrom("1");
			}
			int i = productAutoMapper.updateByPrimaryKeySelective(productAuto);
			if (i <= 0) {
				if (type == 0) {
					throw new Exception("取消自营失败!");
				} else {
					throw new Exception("设置自营失败!");
				}
			}
			if (type == 0) {
				map.putAll(CommonResponseUtils.successResponse("取消自营成功!"));
			} else {
				map.putAll(CommonResponseUtils.successResponse("设置自营失败!"));
			}

			return map;
		} catch (Exception e) {
			if (type == 0) {
				logger.info("======>>>>>>取消自营失败:" + e);
			} else {
				logger.info("======>>>>>>设置自营失败:" + e);
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查看商品详情
	 */
	@Override
	public Map<String, Object> queryProductDetaileInfo(Long productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ProductDetaileInfoPlatformVo productDetaileInfoPlatform = new ProductDetaileInfoPlatformVo();

			// 查询商品
			ProductAutoAddField productAutoAddField = new ProductAutoAddField();
			// 商品Id
			productAutoAddField.setProductId(productId);
			// 是否删除
			productAutoAddField.setIsDelete(SUConstants.IS_NOT_DELETE);

			productDetaileInfoPlatform = productAutoMapper.queryProductDetaileInfo(productId);

			// 查询商品图片
			ProductPicAuto productPicAuto = new ProductPicAuto();
			// 商品Id
			productPicAuto.setProductId(productId);
			// 是否删除
			productPicAuto.setStatus(SUConstants.IS_NOT_DELETE);
			List<ProductPicAuto> productPicList = productPicAutoMapper.queryByPrimaryKey(productPicAuto);
			List<String> picturePathList = new ArrayList<String>();
			for (int i = 0; i < productPicList.size(); i++) {
				picturePathList.add(productPicList.get(i).getPath());
			}
			productDetaileInfoPlatform.setPicturePathList(picturePathList);

			// 商品SKU
			List<ProductSKUInfoPlatformVo> productSkuList = new ArrayList<ProductSKUInfoPlatformVo>();

			// 查询商品规格(SKU)
			ProductSkuAuto productSkuAuto = new ProductSkuAuto();
			productSkuAuto.setProductId(productId);
			productSkuAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<ProductSkuAuto> productSkuAutoList = productSkuAutoMapper.queryByPrimaryKey(productSkuAuto);
			for (int i = 0; i < productSkuAutoList.size(); i++) {
				ProductSKUInfoPlatformVo productSkuAutoListVO = new ProductSKUInfoPlatformVo();
				ProductSkuAuto productSku = productSkuAutoList.get(i);

				// SKU id
				productSkuAutoListVO.setProductskuId(productSku.getProductskuId());
				// 商品代码
				productSkuAutoListVO.setArticleNumber(productSku.getArticleNumber());
				// 商品价格
				productSkuAutoListVO.setPrices(productSku.getPrices());
				// 商品库存
				productSkuAutoListVO.setProductskuCount(productSku.getProductskuCount());

				// 查询商品规格关系（SKU Relation）
				ProductSkuRelationAuto productSkuRelationAuto = new ProductSkuRelationAuto();
				// 商品Id
				productSkuRelationAuto.setProductId(productSku.getProductId());
				// SKU id
				productSkuRelationAuto.setProductskuId(productSku.getProductskuId());
				List<ProductSKURelationInfoPlatformVo> productSkuRelationList = productSkuRelationAutoMapper.querySkuRelationPlatformInfo(productSkuRelationAuto);

				productSkuAutoListVO.setProductSkuRelationList(productSkuRelationList);
				productSkuList.add(productSkuAutoListVO);
			}
			productDetaileInfoPlatform.setProductSkuList(productSkuList);
			map.putAll(CommonResponseUtils.successResponse(productDetaileInfoPlatform));

			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>商品详情查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
