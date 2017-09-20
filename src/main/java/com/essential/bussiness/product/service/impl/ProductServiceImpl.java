package com.essential.bussiness.product.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.brand.dao.BrandAutoMapper;
import com.essential.bussiness.brand.model.auto.BrandAuto;
import com.essential.bussiness.product.dao.ProductAutoMapper;
import com.essential.bussiness.product.dao.ProductPicAutoMapper;
import com.essential.bussiness.product.dao.ProductSkuAutoMapper;
import com.essential.bussiness.product.model.auto.ProductAuto;
import com.essential.bussiness.product.model.auto.ProductCommentAuto;
import com.essential.bussiness.product.model.auto.ProductPicAuto;
import com.essential.bussiness.product.model.vo.ProductAutoAddField;
import com.essential.bussiness.product.model.vo.ProductReleaseCommodityVO;
import com.essential.bussiness.product.model.vo.ProductSkuAutoListVO;
import com.essential.bussiness.product.model.vo.ProductSkuAutoVO;
import com.essential.bussiness.product.model.vo.QueryProductListVO;
import com.essential.bussiness.product.model.vo.QueryProductPromotionVo;
import com.essential.bussiness.product.service.IProductCommentService;
import com.essential.bussiness.product.service.IProductService;
import com.essential.bussiness.product.service.IProductSkuService;
import com.essential.bussiness.promotion.controller.PromotionAutoController;
import com.essential.bussiness.promotion.model.vo.PromotionProductInfoVo;
import com.essential.bussiness.shop.dao.ShopAutoMapper;
import com.essential.bussiness.shop.model.auto.ShopAuto;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.upload.controller.PictureOrFilePathController;
import com.essential.user.model.auto.UserCollectionAuto;
import com.essential.user.service.IUserCollectionService;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * 商品业务
 * 
 * @author cpx
 *
 */

@Service
public class ProductServiceImpl implements IProductService {
	private static Logger logger = LoggerFactory
			.getLogger(ProductServiceImpl.class);
	// 商品轮播图
	@Autowired
	ProductPicAutoMapper productPicAutoMapper;
	// 商品
	@Autowired
	ProductAutoMapper productAutoMapper;
	// 店铺
	@Autowired
	ShopAutoMapper shopAutoMapper;
	// 品牌
	@Autowired
	BrandAutoMapper bussinessBrandAutoMapper;

	@Autowired
	IProductCommentService iProductCommentService;

	@Autowired
	IUserCollectionService iUserCollectionService;

	@Autowired
	IProductSkuService productSkuService;

	@Autowired
	PictureOrFilePathController pictureOrFilePathController;

	@Autowired
	ProductSkuAutoMapper productSkuAutoMapper;

	@Autowired
	PromotionAutoController promotionAutoController;

	// 增加一个商品
	@Override
	public Map<String, Object> add(ProductAuto productAuto) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			productAuto.setCreateTime(TmDateUtil.getTimeStamp());
			productAuto.setModifyTime(TmDateUtil.getTimeStamp());

			int i = productAutoMapper.insert(productAuto);
			if (i > 0) {
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
				return map;
			}

		} catch (Exception e) {
			logger.info("添加商品失败");
			throw new RuntimeException(e);

		}
		return CommonResponseUtils.failureResponse("增加一个商品失败");
	}

	/**
	 * 删除一个商品
	 */
	@Override
	public Map<String, Object> delete(ProductAuto productAuto) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			if (productAuto.getProductId() == null) {
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
				map.put(SUConstants.MSG_KEY, "商品id不能为空");
				return map;

			}

			productAuto.setIsDelete(SUConstants.IS_DELETE);
			int i = productAutoMapper.updateByPrimaryKey(productAuto);
			if (i > 0) {
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
				return map;
			}

		} catch (Exception e) {
			logger.info("删除商品失败");
			throw new RuntimeException(e);

		}
		return CommonResponseUtils.failureResponse("删除一个商品失败");

	}

	/**
	 * 更新一个商品
	 */
	@Override
	public Map<String, Object> update(ProductAuto productAuto) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			if (productAuto.getProductId() == null) {
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
				map.put(SUConstants.MSG_KEY, "商品id不能为空");
				return map;
			}

			productAuto.setModifyTime(TmDateUtil.getTimeStamp());
			int i = productAutoMapper.updateByPrimaryKey(productAuto);
			if (i > 0) {
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
				return map;
			}

		} catch (Exception e) {
			logger.info("修改商品失败");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return CommonResponseUtils.failureResponse("更新一个商品");
	}

	/**
	 * 查询商品
	 */
	@Override
	public Map<String, Object> query(Long[] brandIds, Long[] productTypeIds,
			int pageIndex, int type, int own, ProductAuto productAuto) {

		try {
			// 返回给前段的map
			Map<String, Object> map = new HashMap<String, Object>();
			// 每次请求返回的条数
			int pageSize = 18;
			// 给mybatis的map
			Map<String, Object> inputParameterMap = new HashMap<String, Object>();

			// 把productAuto转换为map

			productAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			inputParameterMap = DTOUtils.beanToMap(productAuto);
			if (brandIds != null && brandIds.length > 0) {
				inputParameterMap.put("brandIds", brandIds);
			}
			if (productTypeIds != null && productTypeIds.length > 0) {
				inputParameterMap.put("productTypeIds", productTypeIds);
			}
			inputParameterMap.put("pageIndex", (pageIndex - 1) * pageSize);
			inputParameterMap.put("pageSize", pageSize);
			inputParameterMap.put("type", type);
			inputParameterMap.put("own", own);
			inputParameterMap.put("isDelete", SUConstants.IS_NOT_DELETE);

			// type=1 价格从低到高
			// type=2价格从高到底
			// type=3按时间降序排列
			// type=4 自营
			// type=5是否有活动

			List<ProductAutoAddField> list = new ArrayList<ProductAutoAddField>();

			// 正常查询商品列表
			if (type == 5) {
				// 活动的查询
				List<QueryProductPromotionVo> productPromotingList = productAutoMapper
						.queryPromotionProductList(inputParameterMap);

				for (int s = 0; s < productPromotingList.size(); s++) {

					ProductAutoAddField productAutoAddField = new ProductAutoAddField();
					productAutoAddField.setProductId(productPromotingList
							.get(s).getProductId());
					productAutoAddField.setIsDiscount("1");

					// 打折价格
					float costPrice = productPromotingList.get(s)
							.getCostPrice().floatValue();// 原价
					float percent = productPromotingList.get(s)
							.getDiscountPercent();// 打折的百分比
					float discountCostprice = (costPrice * percent) / 10;

					discountCostprice = (float) (Math
							.round(discountCostprice * 100)) / 100;
					// 打折价格
					productAutoAddField.setDiscountPrice(discountCostprice);

					productAutoAddField.setProductName(productPromotingList
							.get(s).getProductName());

					productAutoAddField.setCostPrice(productPromotingList
							.get(s).getCostPrice());
					productAutoAddField.setPath(productPromotingList.get(s)
							.getPath());
					productAutoAddField.setBrandName(productPromotingList
							.get(s).getBrandName());

					list.add(productAutoAddField);
				}
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);

				map.put("info", list);
				return map;

			} else {

				list = productAutoMapper.selectAll(inputParameterMap);
				for (int i = 0; i < list.size(); i++) {

					// 查询活动
					Map<String, Object> mappromotion = promotionAutoController
							.productPromotion(list.get(i).getProductId());
					PromotionProductInfoVo promotionProductInfoVo = (PromotionProductInfoVo) mappromotion
							.get("info");

					// code=3就是没有活动
					if (mappromotion.get("code").equals("3")) {

						// 没有活动.
						list.get(i).setIsDiscount("0");

					}
					// code=1就是有活动
					if (mappromotion.get("code").equals("1")) {
						list.get(i).setIsDiscount("1");
						for (String o : mappromotion.keySet())

						{
							float costPrice = list.get(i).getCostPrice()
									.floatValue();// 原价
							float percent = promotionProductInfoVo
									.getDiscountPercent();// 打折的百分比
							float discountCostprice = (costPrice * percent) / 10;

							discountCostprice = (float) (Math
									.round(discountCostprice * 100)) / 100;
							list.get(i).setDiscountPrice(discountCostprice);
						}

					}

				}

				/* DTOUtils.beanToMap(list); */
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
				map.put("info", list);
				return map;

			}

		} catch (Exception e) {
			logger.info("查询商品失败");
			e.printStackTrace();
			throw new RuntimeException(e);

		}

	}

	// 兼容api

	/**
	 * 查询商品
	 */
	@Override
	public Map<String, Object> query(Long[] brandIds, Long[] productTypeIds,
			int pageIndex, int type, int own, int isDiscount,
			ProductAuto productAuto) {

		try {
			// 返回给前段的map
			Map<String, Object> map = new HashMap<String, Object>();
			// 每次请求返回的条数
			int pageSize = 18;
			// 给mybatis的map
			Map<String, Object> inputParameterMap = new HashMap<String, Object>();

			// 把productAuto转换为map

			productAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			inputParameterMap = DTOUtils.beanToMap(productAuto);
			if (brandIds != null && brandIds.length > 0) {
				inputParameterMap.put("brandIds", brandIds);
			}
			if (productTypeIds != null && productTypeIds.length > 0) {
				inputParameterMap.put("productTypeIds", productTypeIds);
			}
			inputParameterMap.put("pageIndex", (pageIndex - 1) * pageSize);
			inputParameterMap.put("pageSize", pageSize);
			inputParameterMap.put("type", type);
			inputParameterMap.put("own", own);
			inputParameterMap.put("isDelete", SUConstants.IS_NOT_DELETE);

			// type=1 价格从低到高
			// type=2价格从高到底
			// type=3按时间降序排列
			// type=4 自营
			// type=5是否有活动

			List<ProductAutoAddField> list = new ArrayList<ProductAutoAddField>();

			// 正常查询商品列表
			if (isDiscount == 1) {
				// 活动的查询
				List<QueryProductPromotionVo> productPromotingList = productAutoMapper
						.queryPromotionProductList(inputParameterMap);

				for (int s = 0; s < productPromotingList.size(); s++) {

					ProductAutoAddField productAutoAddField = new ProductAutoAddField();
					productAutoAddField.setProductId(productPromotingList
							.get(s).getProductId());
					productAutoAddField.setIsDiscount("1");

					// 打折价格
					float costPrice = productPromotingList.get(s)
							.getCostPrice().floatValue();// 原价
					System.out.println("costPrice:" + costPrice);
					float percent = productPromotingList.get(s)
							.getDiscountPercent();// 打折的百分比
					System.out.println("percent:" + percent);
					float discountCostprice = (costPrice * percent) / 10;

					discountCostprice = (float) (Math
							.round(discountCostprice * 100)) / 100;
					System.out
							.println("discountCostprice:" + discountCostprice);
					// 打折价格
					productAutoAddField.setDiscountPrice(discountCostprice);

					productAutoAddField.setProductName(productPromotingList
							.get(s).getProductName());

					productAutoAddField.setCostPrice(productPromotingList
							.get(s).getCostPrice());
					productAutoAddField.setPath(productPromotingList.get(s)
							.getPath());
					productAutoAddField.setBrandName(productPromotingList
							.get(s).getBrandName());
					/* productAutoAddField.setLinkFrom(( own==10)?"1":"0"); */
					productAutoAddField.setLinkFrom(productPromotingList.get(s)
							.getLinkFrom());

					list.add(productAutoAddField);
				}
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);

				map.put("info", list);
				return map;

			} else {

				list = productAutoMapper.selectAll(inputParameterMap);
				for (int i = 0; i < list.size(); i++) {

					// 查询活动
					Map<String, Object> mappromotion = promotionAutoController
							.productPromotion(list.get(i).getProductId());
					PromotionProductInfoVo promotionProductInfoVo = (PromotionProductInfoVo) mappromotion
							.get("info");

					// code=3就是没有活动
					if (mappromotion.get("code").equals("3")) {

						// 没有活动.
						list.get(i).setIsDiscount("0");

					}
					// code=1就是有活动
					if (mappromotion.get("code").equals("1")) {
						list.get(i).setIsDiscount("1");
						for (String o : mappromotion.keySet())

						{
							float costPrice = list.get(i).getCostPrice()
									.floatValue();// 原价
							float percent = promotionProductInfoVo
									.getDiscountPercent();// 打折的百分比
							float discountCostprice = (costPrice * percent) / 10;

							discountCostprice = (float) (Math
									.round(discountCostprice * 100)) / 100;
							list.get(i).setDiscountPrice(discountCostprice);
						}

					}

				}

				/* DTOUtils.beanToMap(list); */
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
				map.put("info", list);
				return map;

			}

		} catch (Exception e) {
			logger.info("查询商品失败");
			e.printStackTrace();
			throw new RuntimeException(e);

		}

	}

	// 兼容api

	/**
	 * 查询商品
	 */
	@Override
	public Map<String, Object> queryLast(Long[] brandIds,
			Long[] productTypeIds, int pageIndex, int type, int own,
			int isDiscount, ProductAuto productAuto) {

		try {
			// 返回给前段的map
			Map<String, Object> map = new HashMap<String, Object>();
			// 每次请求返回的条数
			int pageSize = 18;
			// 给mybatis的map
			Map<String, Object> inputParameterMap = new HashMap<String, Object>();

			// 把productAuto转换为mapjud

			productAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			inputParameterMap = DTOUtils.beanToMap(productAuto);
			if (brandIds != null && brandIds.length > 0) {
				inputParameterMap.put("brandIds", brandIds);
			}
			if (productTypeIds != null && productTypeIds.length > 0) {
				inputParameterMap.put("productTypeIds", productTypeIds);
			}

			inputParameterMap.put("pageIndex", (pageIndex - 1) * pageSize);
			inputParameterMap.put("pageSize", pageSize);

			inputParameterMap.put("own", own);
			inputParameterMap.put("isDelete", SUConstants.IS_NOT_DELETE);

			if (isDiscount == 1) {
				if (type == 1) {

					inputParameterMap.put("discountPriceAsc", 35);

				}
				if (type == 2) {
					inputParameterMap.put("discountPriceDesc", 36);

				}

			}

			else {

				inputParameterMap.put("type", type);
			}

			// type=1 价格从低到高
			// type=2价格从高到底
			// type=3按时间降序排列
			// type=4 自营
			// type=5是否有活动
			List<QueryProductListVO> list = new ArrayList<QueryProductListVO>();

			if (isDiscount == 1) {
				// 活动的查询
				List<QueryProductPromotionVo> productPromotingList = productAutoMapper
						.queryPromotionProductList(inputParameterMap);

				for (int s = 0; s < productPromotingList.size(); s++) {

					QueryProductListVO queryProductListVO = new QueryProductListVO();
					queryProductListVO.setProductId(productPromotingList.get(s)
							.getProductId());
					queryProductListVO.setIsDiscount(1);

					// 打折价格
					/*float costPrice = productPromotingList.get(s)
							.getCostPrice().floatValue();// 原价
					System.out.println("costPrice:" + costPrice);
					float percent = productPromotingList.get(s)
							.getDiscountPercent();// 打折的百分比
					System.out.println("percent:" + percent);
					float discountCostprice = (costPrice * percent) / 10;

					discountCostprice = (float) (Math
							.round(discountCostprice * 100)) / 100;
					System.out
							.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<discountCostprice:"
									+ discountCostprice);*/
					// 打折价格
					queryProductListVO.setDiscountPrice(productPromotingList.get(s).getActivePrice());

					queryProductListVO.setProductName(productPromotingList.get(
							s).getProductName());

					queryProductListVO.setCostPrice(productPromotingList.get(s)
							.getCostPrice());
					queryProductListVO.setPath(productPromotingList.get(s)
							.getPath());
					queryProductListVO.setBrandName(productPromotingList.get(s)
							.getBrandName());
					/* productAutoAddField.setLinkFrom(( own==10)?"1":"0"); */
					queryProductListVO
							.setLinkFrom(Integer.parseInt(productPromotingList
									.get(s).getLinkFrom()));

					list.add(queryProductListVO);
				}
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);

				map.put("info", list);
				return map;

			} else {

				list = productAutoMapper.selectAllLast(inputParameterMap);
				for (int i = 0; i < list.size(); i++) {
					// 查询活动
					Map<String, Object> mappromotion = promotionAutoController
							.productPromotion(list.get(i).getProductId());
					PromotionProductInfoVo promotionProductInfoVo = (PromotionProductInfoVo) mappromotion
							.get("info");

					// code=3就是没有活动
					if (mappromotion.get("code").equals("3")) {

						// 没有活动.
						list.get(i).setIsDiscount(0);
						list.get(i).setDiscountPrice(0);

					}
					// code=1就是有活动
					if (mappromotion.get("code").equals("1")) {
						list.get(i).setIsDiscount(1);
						for (String o : mappromotion.keySet())

						{
							float costPrice = list.get(i).getCostPrice()
									.floatValue();// 原价
							float percent = promotionProductInfoVo
									.getDiscountPercent();// 打折的百分比
							float discountCostprice = (costPrice * percent) / 10;

							System.out.println(discountCostprice);

							discountCostprice = (float) (Math
									.round(discountCostprice * 100)) / 100;
							list.get(i).setDiscountPrice(discountCostprice);
						}

					}
					
					/*list.get(i).setLinkFrom(( own==10)?1:0);*/

				}

			}

			return CommonResponseUtils.successResponse(list);

		} catch (Exception e) {
			logger.info("查询商品失败");
			throw new RuntimeException(e);

		}

	}

	@Override
	public List<ProductAuto> querymap(Map<String, Object> map) {
		Map<String, Object> datamap = new HashMap<String, Object>();
		List<ProductAuto> list = new ArrayList<ProductAuto>();
		// list= productAutoMapper.querymap(map);

		return list;
	}

	/**
	 * 查询商品详情
	 */
	@Override
	public Map<String, Object> queryById(HttpServletRequest request) {
		// 返回的一级map返回状态和msg和一个info实体
		Map<String, Object> map = new HashMap<String, Object>();
		// 返回的二级的map info是封装很多业务的实体
		Map<String, Object> info = new HashMap<String, Object>();
		String productId = request.getParameter("productId");
		Long userId = null;
		if (request.getParameter("userId") != null) {
			userId = Long.parseLong(request.getParameter("userId"));

		}

		try {
			ProductAutoAddField ProductAuto = productAutoMapper
					.selectByPrimaryKey(Long.parseLong(productId));
			// 得到店铺的相关信息 ：店铺名称,店铺描述
			ShopAuto shopAuto = shopAutoMapper.selectByPrimaryKey(ProductAuto
					.getShopId());
			// shop的map
			/* Map<String, Object> mapShop = new HashMap<String, Object>(); */
			info.put("shopName", shopAuto.getName());
			info.put("shopDescribe", shopAuto.getShopDescribe());
			info.put("shopId", shopAuto.getShopId());
			info.put("logoPath", shopAuto.getLogoPath());
			info.put("path", ProductAuto.getPath());
			info.put("spuStock", 563);
			// 大分类id
			info.put("categoryId", ProductAuto.getCategoryId());
			// 一句话描述
			info.put("words", ProductAuto.getWords());
			// 商品详情
			info.put("productDescribe",
					"/pages/busi_platform/business/discovery/productDetails.html?productId="
							+ productId + "&type=0");
			// 售后信息
			info.put("returnProductExplain",
					"/pages/busi_platform/business/discovery/productDetails.html?productId="
							+ productId + "&type=1");
			// 最大值
			info.put("productintro", ProductAuto.getProductintro());

			// 得到轮播图
			List<?> picList = new ArrayList<>();
			picList = productPicAutoMapper.selectByPrimaryKey(Long
					.parseLong(productId));
			if (picList != null) {
				info.put("picList", picList);
			}

			Map<String, Object> maxAndMinPricemapOrigin = productSkuAutoMapper
					.selectMaxMinPriceOrigin(Long.parseLong(productId));

			info.put("minPriceOrigin",
					maxAndMinPricemapOrigin.get("originMinPrices").toString());
			info.put("maxPriceOrigin",
					maxAndMinPricemapOrigin.get("originMaxPrices").toString());

			/*
			 * Map<String, Object> maxAndMinPricemap = productSkuAutoMapper
			 * .selectMaxMinPrice(Long.parseLong(productId));
			 */

			// 得到产品的spu的价格
			// 得到商品的评论数
			ProductCommentAuto productCommentAuto = new ProductCommentAuto();
			// 得到商品推荐的评论
			productCommentAuto.setProductId(Long.parseLong(productId));
			String price = ProductAuto.getPrice().toString();
			// 市场价
			String marketPrice = ProductAuto.getMarketPrice().toString();
			// 得到商品是否已经收藏
			UserCollectionAuto userCollectionAuto = new UserCollectionAuto();

			if (userId == null) {

				info.put("isCollection", 0);

			} else {
				userCollectionAuto.setUserId(userId);
				userCollectionAuto.setContentId(Long.parseLong(productId));
				userCollectionAuto.setCollectionType(3);
				// 0是不收藏 1为收藏，如果userId为空我们不查询，直接设置为0
				info.put("isCollection", iUserCollectionService
						.queryIsCollection(userCollectionAuto));

			}
			// 销售名称
			String salesName = "";
			// 价格原价
			String costPrice = "";
			/* userCollectionServiceImpl.isCollection(collectionMap) */
			if (ProductAuto.getSalesName() != null
					&& ProductAuto.getCostPrice() != null) {
				salesName = ProductAuto.getSalesName().toString();
				costPrice = ProductAuto.getCostPrice().toString();

			}

			// 得到上架下架的状态
			int SaleStatus = ProductAuto.getSaleStatus();
			// 得到库存
			Long spuStock = productSkuAutoMapper.selectSpuStock(Long
					.parseLong(productId));

			if (spuStock == null) {

				info.put("spuStock", 0);
			} else {
				info.put("spuStock", spuStock);
			}
			if (!"".equals(price)) {
				info.put("price", price);
				info.put("salesName", salesName);
				info.put("costPrice", costPrice);
				info.put("SaleStatus", SaleStatus);
				info.put("commentCount", iProductCommentService
						.queryCommentCount(productCommentAuto));
				/* info.put("CommentCount", 6); */
				info.put("recommendComment", iProductCommentService
						.queryRecommendComment(productCommentAuto));

			}
			// 得到商品的品牌

			BrandAuto bussinessBrandAuto = bussinessBrandAutoMapper
					.selectByPrimaryKey(ProductAuto.getBrandId());
			if (!"".equals(bussinessBrandAuto.getBrandName())) {
				info.put("brandName", bussinessBrandAuto.getBrandName());
				info.put("brandDetailedDesc",
						bussinessBrandAuto.getDetailedDesc());
				info.put("brandId", bussinessBrandAuto.getBrandId());
				info.put("PageDesc", bussinessBrandAuto.getPageDesc());
			}
			// 得到活动

			Map<String, Object> mappromotion = promotionAutoController
					.productPromotion(Long.parseLong(productId));
			{
				// code=3就是没有活动
				if (mappromotion.get("code").equals("3")) {

					info.put("isPromotion", "0");// 没有活动

				}
				// code=1就是有活动
				if (mappromotion.get("code").equals("1")) {

					for (String o : mappromotion.keySet()) {

						info.put("isPromotion", "1");// 有活动

						PromotionProductInfoVo promotionProductInfoVo = (PromotionProductInfoVo) mappromotion
								.get("info");
						info.put("promotionId",
								promotionProductInfoVo.getPromotionId());
						info.put("promotionName",
								promotionProductInfoVo.getPromotionName());
						info.put("promotinStartTime",
								promotionProductInfoVo.getStartTime());
						info.put("promotinEndTime",
								promotionProductInfoVo.getEndTime());
						info.put("tag", promotionProductInfoVo);
						float percent = promotionProductInfoVo
								.getDiscountPercent();// 打折的百分比

						float discountCostprice = ((Float.parseFloat(costPrice) * percent) / 10);

						// 折扣过后的最小值
						float discountMinPrice = ((Float
								.parseFloat(maxAndMinPricemapOrigin.get(
										"originMinPrices").toString()) * percent) / 10);

						discountMinPrice = (float) (Math
								.round(discountMinPrice * 100)) / 100;
						// 折扣过后的最小值

						// 折扣过后的最大值
						float discountMaxPrice = ((Float
								.parseFloat(maxAndMinPricemapOrigin.get(
										"originMaxPrices").toString()) * percent) / 10);

						discountMaxPrice = (float) (Math
								.round(discountMaxPrice * 100)) / 100;
						// 折扣过后的最大值

						discountCostprice = (float) (Math
								.round(discountCostprice * 100)) / 100;
						info.put("discountPrice", discountCostprice);// 打折过后的价格

						info.put("discountMinPrice", discountMinPrice);
						info.put("discountMaxPrice", discountMaxPrice);

					}

				}

			}

			map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
			map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
			map.put("info", info);
			return map;

		} catch (Exception e) {
			logger.info("查询商品详情失败");
			throw new RuntimeException(e);

		}

	}

	// 发布商品

	@Override
	public Map<String, Object> addReleaseCommodity(
			ProductReleaseCommodityVO productReleaseCommodityVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> productMap = new HashMap<String, Object>();
		try {
			// 登录用户
			long loginUser = productReleaseCommodityVO.getLoginUser();
			// 获取店铺Id
			long shopId = productReleaseCommodityVO.getShopId();
			// 时间戳
			String dateTime = TmDateUtil.getTimeStamp();
			// 库存
			Long stock = productReleaseCommodityVO.getTotalStoreNum();

			int k = 0;

			List<ProductSkuAutoListVO> productSkuAutoListVO = productReleaseCommodityVO
					.getProductSkuAutoList();
			// 获取SKU最大价格
			String maxPriceSKU = serchMaxPric(productSkuAutoListVO);

			// 插入商品信息
			ProductAuto productAuto = new ProductAuto();
			DTOUtils.map(productReleaseCommodityVO, productAuto);
			// 创建用户
			productAuto.setCreateUser(loginUser);
			// 创建时间
			productAuto.setCreateTime(dateTime);
			// 库存
			productAuto.setStock(stock);
			// 最大价格
			productAuto.setProductintro(maxPriceSKU);
			// 价格
			productAuto.setPrice(productReleaseCommodityVO.getCostPrice());
			// 是否删除
			productAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			int i = productAutoMapper.insertSelective(productAuto);

			// 获取商品Id
			long productId = productAuto.getProductId();

			if (i > 0) {
				// 插入规格信息
				ProductSkuAutoVO productSkuAutoVO = new ProductSkuAutoVO();
				// 登录用户
				productSkuAutoVO.setLoginUser(loginUser);
				for (int j = 0; j < productSkuAutoListVO.size(); j++) {
					// 商品Id
					productSkuAutoListVO.get(j).setProductId(productId);
				}
				// sku list
				productSkuAutoVO.setProductSkuAutoList(productSkuAutoListVO);

				map = productSkuService.addProductSku(productSkuAutoVO);

				if ("1".equals(map.get(SUConstants.CODE_KEY))) {
					// 获取远程图片路径
					List<String> remotePictuerPathList = productReleaseCommodityVO
							.getPicturePathList();
					// 插入图片路径
					if (remotePictuerPathList != null
							&& remotePictuerPathList.size() > 0) {
						ProductPicAuto productPicAuto = new ProductPicAuto();
						// 商品Id
						productPicAuto.setProductId(productId);
						// 创建用户
						productPicAuto.setCreateIser(loginUser);
						// 创建时间
						productPicAuto.setCreateTime(dateTime);
						// 是否删除
						productPicAuto.setStatus(SUConstants.IS_NOT_DELETE);
						for (int j = 0; j < remotePictuerPathList.size(); j++) {
							if (j == 0) {
								productPicAuto.setType(1);
								productPicAuto.setMainpic(1);
							} else {
								productPicAuto.setType(0);
								productPicAuto.setMainpic(0);
							}
							productPicAuto
									.setPath(remotePictuerPathList.get(j));
							k = productPicAutoMapper
									.insertSelective(productPicAuto);
							if (k < 0) {
								throw new Exception("商品图片添加失败!");
							}
						}
					}
				} else {
					throw new Exception("商品规格添加失败!");
				}
				if ("1".equals(map.get(SUConstants.CODE_KEY)) && k > 0) {
					productMap.putAll(CommonResponseUtils
							.successResponse("添加成功!"));
				}
			} else {
				throw new Exception("商品添加失败!");
			}
			return productMap;
		} catch (Exception e) {
			logger.info("=======>>>>>>>>>>发布商品失败" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * 根据运费模板组 查询是否有商品在使用
	 * 
	 * @param productAuto
	 * @return
	 */
	@Override
	public List<ProductAuto> queryProductByFreightGroupId(Long freightGroupId) {
		try {
			ProductAuto productAuto = new ProductAuto();
			productAuto.setFreightGroupId(freightGroupId);
			productAuto.setFreightType(1);
			productAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			return productAutoMapper.queryProductByFreightGroupId(productAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * 商品详情/售后详情
	 * 
	 * @param productAuto
	 * @param type
	 *            0-商品详情，1-售后详情
	 * @return
	 * 
	 */
	@Override
	public Map<String, Object> queryProductDetails(Long productId, int type) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ProductAuto productAuto = new ProductAuto();
			productAuto.setProductId(productId);
			productAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			if (type == 0) {
				// 商品详情
				ProductAutoAddField productAutoAddField = productAutoMapper
						.queryByPrimaryKey(productAuto);
				String productDescribe = productAutoAddField
						.getProductDescribe();
				map.putAll(CommonResponseUtils.successResponse("商品详情查询成功!",
						productDescribe));
			} else {
				// 售后详情
				ProductAutoAddField productAutoAddField = productAutoMapper
						.queryByPrimaryKey(productAuto);
				String returnProductExplain = productAutoAddField
						.getReturnProductExplain();
				map.putAll(CommonResponseUtils.successResponse("售后详情查询成功!",
						returnProductExplain));
			}
			return map;
		} catch (Exception e) {
			if (type == 0) {
				logger.info("=======>>>>>>>>>>商品详情查询失败" + e);
			} else {
				logger.info("=======>>>>>>>>>>售后详情查询失败" + e);
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// 获取SKU最大价格
	public String serchMaxPric(List<ProductSkuAutoListVO> productSkuList) {
		String price = null;
		if (productSkuList != null && productSkuList.size() > 0) {
			BigDecimal maxPrice = productSkuList.get(0).getPrices();
			for (int i = 1; i < productSkuList.size(); i++) {
				ProductSkuAutoListVO list = productSkuList.get(i);
				BigDecimal prices = list.getPrices();
				if (maxPrice.compareTo(prices) < 0) {
					maxPrice = prices;
				}
			}
			price = maxPrice.toString();
		}
		return price;
	}
}
