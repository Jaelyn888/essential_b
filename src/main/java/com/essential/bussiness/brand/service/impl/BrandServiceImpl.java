package com.essential.bussiness.brand.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.brand.dao.BrandAndCategoryAutoMapper;
import com.essential.bussiness.brand.dao.BrandAutoMapper;
import com.essential.bussiness.brand.dao.ShopandbrandAutoMapper;
import com.essential.bussiness.brand.model.auto.BrandAndCategoryAuto;
import com.essential.bussiness.brand.model.auto.BrandAndCategoryAutoExample;
import com.essential.bussiness.brand.model.auto.BrandAuto;
import com.essential.bussiness.brand.model.auto.BrandAutoExample;
import com.essential.bussiness.brand.model.auto.ShopandbrandAuto;
import com.essential.bussiness.brand.model.vo.BrandVo;
import com.essential.bussiness.brand.service.IBrandService;
import com.essential.bussiness.product.dao.ProductAutoMapper;
import com.essential.bussiness.product.dao.ProductTypeAutoMapper;
import com.essential.bussiness.product.model.auto.ProductTypeAuto;
import com.essential.bussiness.product.model.vo.ProductAutoAddField;
import com.essential.bussiness.promotion.controller.PromotionAutoController;
import com.essential.bussiness.promotion.model.vo.PromotionProductInfoVo;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.StringCommonUtils;
import com.essential.user.model.auto.UserCollectionAuto;
import com.essential.user.service.IUserCollectionService;
import com.essential.utils.CommonResponseUtils;

/**
 * 商品品牌
 * 
 * @author essential-gfs
 *
 */
@Service
public class BrandServiceImpl implements IBrandService {

	private Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);

	// 装配商品品牌dao
	@Autowired
	BrandAutoMapper brandDao;
	// 装配商品品牌和商品品类dao
	@Autowired
	BrandAndCategoryAutoMapper brandAndCategoryDao;
	// 装配商品分类dao
	@Autowired
	ProductTypeAutoMapper productTypeDao;
	// 注入商品dao
	@Autowired
	ProductAutoMapper productAutoMapper;
	// 注入店铺品牌关联dao
	@Autowired
	ShopandbrandAutoMapper shopandbrandAutoMapper;
	// 注入用户收藏service
	@Autowired
	IUserCollectionService userCollectionService;
	// 是否得到活动
	@Autowired
	PromotionAutoController promotionAutoController;

	/**
	 * 查询全部商品品牌列表(分页)
	 */
	@Override
	public Map<String, Object> queryTotalBrandForPage(BrandVo brandVo) {

		try {
			if (brandVo.getPageNo() == null) {
				brandVo.setPageNo(1);
			}
			if (brandVo.getPageCount() == null) {
				brandVo.setPageCount(SUConstants.PAGE_COUNT);
			}

			brandVo.setPageNo((brandVo.getPageNo() - 1)
					* brandVo.getPageCount());

			Map<String, Object> resMap = new HashMap<String, Object>();
			// 查询全部品牌
			resMap.put("totalPageCount", brandDao.queryBrandTotalCount(brandVo));
			if (Integer.parseInt(resMap.get("totalPageCount").toString()) > 0) {
				List<BrandVo> brandVoList = brandDao.queryBrandTotal(brandVo);
				for (int i = 0; i < brandVoList.size(); i++) {
					brandVoList.get(i)
							.setBrandCategoryVoList(
									brandDao.queryCategroyByBrandId(brandVoList
											.get(i)));
				}
				resMap.put("brandVoList", brandVoList);
			} else {
				resMap.put("brandVoList", null);
			}

			return CommonResponseUtils.successResponse(resMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 查询全部商品品牌列表(不分页)
	 */
	@Override
	public Map<String, Object> queryTotalBrand(BrandVo brandVo) {

		try {
			
			Map<String, Object> resMap = new HashMap<String, Object>();
			// 查询全部品牌
			List<BrandAuto> brandAutoList = brandDao.selectByExample(null);
			
			resMap.put("brandVoList", brandAutoList);
			
			return CommonResponseUtils.successResponse(resMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询全部商品品牌列表或查询全部商品品牌及热门品牌列表
	 */
	@Override
	public Map<String, Object> queryTotalBrandOrHotBrandForList(
			BrandAuto bussinessBrandModel, String requestType) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 全部品牌
		List<BrandAuto> totalBrandList = new ArrayList<BrandAuto>();

		try {
			// 封装全部及热门品牌集合
			Map<String, Object> brandMap = new HashMap<String, Object>();

			// 查询全部品牌
			totalBrandList = brandDao
					.queryTotalAndHotForListByCategoryId(bussinessBrandModel);
			brandMap.put("totalBrandList", totalBrandList);
			if ("2".equals(requestType)) {
				// 热门品牌
				List<BrandAuto> hotBrandList = new ArrayList<BrandAuto>();

				// 遍历全部品牌,解析并组装热门品牌
				if (totalBrandList != null && totalBrandList.size() > 0) {
					for (BrandAuto brand : totalBrandList) {
						if (brand.getAction() == 1) {
							hotBrandList.add(brand);
						}
					}
				}
				brandMap.put("hotBrandList", hotBrandList);
			}

			resultMap.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
			resultMap.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
			resultMap.put(SUConstants.INFO_KEY, brandMap);
			return resultMap;
		} catch (Exception e) {
			logger.info("=============>>>>>>查询商品品牌失败");
			throw new RuntimeException(e);
		}

	}

	/**
	 * 新增商品品牌信息
	 */
	@Override
	public Map<String, Object> saveBussinessBrand(
			BrandAuto bussinessBrandModel, Long[] categoryIds) {
		Map<String, Object> bussinessBrandMap = new HashMap<String, Object>();

		try {
			if (bussinessBrandModel.getAction() == null) {
				bussinessBrandModel.setAction(2l);
			}

			// 新增一条商品品牌信息
			int j = brandDao.insert(bussinessBrandModel);
			if (j <= 0) {
				bussinessBrandMap.put(SUConstants.CODE_KEY,
						SUConstants.CODE_FAIL_VALUE);
				bussinessBrandMap.put(SUConstants.MSG_KEY, "新增商品品牌失败,数据库服务异常");
				return bussinessBrandMap;
			}

			// 遍历商品品类
			for (Long categoryId : categoryIds) {
				// 新增一条商品品牌及商品品类关联信息
				BrandAndCategoryAuto brandAndCategoryModel = new BrandAndCategoryAuto();
				// 组装商品品牌及商品品类实体
				brandAndCategoryModel.setBrandId(bussinessBrandModel
						.getBrandId());
				brandAndCategoryModel.setCategoryId(categoryId);
				brandAndCategoryModel
						.setStatus(bussinessBrandModel.getStatus());
				brandAndCategoryModel.setCreateTime(bussinessBrandModel
						.getCreateTime());
				brandAndCategoryModel.setCreateUser(bussinessBrandModel
						.getCreateUser());
				brandAndCategoryModel.setModifyTime(bussinessBrandModel
						.getModifyTime());
				brandAndCategoryModel.setModifyUser(bussinessBrandModel
						.getModifyUser());
				int i = brandAndCategoryDao.insert(brandAndCategoryModel);
				if (i <= 0) {
					throw new Exception("新增商品品牌失败,数据或数据库服务异常");
				}
			}
			bussinessBrandMap.put(SUConstants.CODE_KEY,
					SUConstants.CODE_SUCCESS_VALUE);
			bussinessBrandMap.put(SUConstants.MSG_KEY,
					SUConstants.CODE_SUCCESS_VALUE);

			return bussinessBrandMap;
		} catch (Exception e) {
			logger.info("=============>>>>>>新增商品品牌失败:", e);
			throw new MyException("新增商品品牌失败");
		}
	}

	/**
	 * 修改商品品牌信息
	 */
	@Override
	public Map<String, Object> updateBussinessBrand(
			BrandAuto bussinessBrandModel, Long[] categoryIds) {
		Map<String, Object> bussinessBrandMap = new HashMap<String, Object>();

		try {
			// 修改一条商品品牌信息
			int j = brandDao.updateByPrimaryKeySelective(bussinessBrandModel);
			if (j <= 0) {
				bussinessBrandMap.put(SUConstants.CODE_KEY,
						SUConstants.CODE_FAIL_VALUE);
				bussinessBrandMap.put(SUConstants.MSG_KEY, "修改商品品牌失败,数据库服务异常");
				return bussinessBrandMap;
			}

			// 删除当前品牌和商品品类的关联信息
			BrandAndCategoryAutoExample brandAndCategoryExample = new BrandAndCategoryAutoExample();
			brandAndCategoryExample.createCriteria().andBrandIdEqualTo(
					bussinessBrandModel.getBrandId());
			int m = brandAndCategoryDao
					.deleteByExample(brandAndCategoryExample);
			if (m < 0) {
				throw new Exception("修改商品品牌失败,删除商品失败");
			}
			// 遍历商品品类
			for (Long categoryId : categoryIds) {
				// 修改一条商品品牌及商品品类关联信息
				BrandAndCategoryAuto brandAndCategoryModel = new BrandAndCategoryAuto();
				// 组装商品品牌及商品品类实体
				brandAndCategoryModel.setBrandId(bussinessBrandModel
						.getBrandId());
				brandAndCategoryModel.setCategoryId(categoryId);
				brandAndCategoryModel
						.setStatus(bussinessBrandModel.getStatus());
				brandAndCategoryModel.setCreateTime(bussinessBrandModel
						.getCreateTime());
				brandAndCategoryModel.setCreateUser(bussinessBrandModel
						.getCreateUser());
				brandAndCategoryModel.setModifyTime(bussinessBrandModel
						.getModifyTime());
				brandAndCategoryModel.setModifyUser(bussinessBrandModel
						.getModifyUser());
				int i = brandAndCategoryDao.insert(brandAndCategoryModel);
				if (i <= 0) {
					throw new Exception("修改商品品牌失败,数据或数据库服务异常");
				}
			}
			bussinessBrandMap.put(SUConstants.CODE_KEY,
					SUConstants.CODE_SUCCESS_VALUE);
			bussinessBrandMap.put(SUConstants.MSG_KEY,
					SUConstants.CODE_SUCCESS_VALUE);

			return bussinessBrandMap;
		} catch (Exception e) {
			logger.info("=============>>>>>>修改商品品牌失败:", e);
			throw new MyException("修改商品品牌失败");
		}
	}

	/**
	 * 根据主键查询商品品牌信息
	 */
	@Override
	public Map<String, Object> queryBussinessBrandByPrimaryKey(Long brandId) {
		Map<String, Object> bussinessBrandMap = new HashMap<String, Object>();
		BrandAuto brand = new BrandAuto();
		try {
			brand = brandDao.selectByPrimaryKey(brandId);
			bussinessBrandMap.put(SUConstants.CODE_KEY,
					SUConstants.CODE_SUCCESS_VALUE);
			bussinessBrandMap.put(SUConstants.MSG_KEY,
					SUConstants.MSG_SUCCESS_VALUE);
			bussinessBrandMap.put("info", brand);
			return bussinessBrandMap;
		} catch (Exception e) {
			logger.info("=============>>>>>>通过主键查询商品品牌失败:", e);
			throw new MyException("查询商品品牌失败");
		}

	}

	/**
	 * 查询商品分类和商品品牌列表
	 */
	@Override
	public Map<String, Object> queryBrandAndProductTypeForList(
			BrandAuto brandModel, ProductTypeAuto productTypeModel) {
		// 商品品牌集合
		List<BrandAuto> brandList = new ArrayList<BrandAuto>();
		// 商品分类集合
		List<ProductTypeAuto> productTypeList = new ArrayList<ProductTypeAuto>();

		try {
			// 封装返回数据
			Map<String, Object> brandAndProductTypeMap = new HashMap<String, Object>();

			// 查询商品品牌列表
			brandList = brandDao.queryForListByCategoryId(brandModel);
			brandAndProductTypeMap.put("brandList", brandList);
			// 查询商品分类列表
			productTypeList = productTypeDao.queryForList(productTypeModel);
			brandAndProductTypeMap.put("productTypeList", productTypeList);

			return CommonResponseUtils.successResponse(brandAndProductTypeMap);
		} catch (Exception e) {
			logger.info("=============>>>>>>查询商品品牌和商品分类列表失败:");
			throw new RuntimeException(e);
		}
	}

	/**
	 * 通过品牌id得到品牌的详情
	 */
	@Override
	public Map<String, Object> queryBrandandProductList(BrandAuto BrandAuto,
			Integer pageIndex, Integer pageSize, Long userId) {

		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			// 查询品牌
			BrandAuto brandAuto = brandDao.selectByPrimaryKey(BrandAuto
					.getBrandId());
			// 查询商品
			Map<String, Object> mybatisMap = new HashMap<String, Object>();
			// brandId pageSize pageIndex
			mybatisMap.put("brandId", brandAuto.getBrandId());
			if (pageSize == null) {
				pageSize = SUConstants.PAGE_COUNT;
			}
			mybatisMap.put("pageSize", pageSize);
			mybatisMap.put("pageIndex", ((pageIndex - 1) * pageSize));
			List<ProductAutoAddField> productList = productAutoMapper
					.selectByBrandId(mybatisMap);

			for (int i = 0; i < productList.size(); i++) {

				// 查询活动
				Map<String, Object> mappromotion = promotionAutoController
						.productPromotion(productList.get(i).getProductId());
				PromotionProductInfoVo promotionProductInfoVo = (PromotionProductInfoVo) mappromotion
						.get("info");

				// code=3就是没有活动
				if (mappromotion.get("code").equals("3")) {

					// 没有活动
					productList.get(i).setIsDiscount("0");

				}
				// code=1就是有活动
				if (mappromotion.get("code").equals("1")) {
					productList.get(i).setIsDiscount("1");
					for (String o : mappromotion.keySet())

					{
						float costPrice = productList.get(i).getCostPrice()
								.floatValue();// 原价
						float percent = promotionProductInfoVo
								.getDiscountPercent();// 打折的百分比
						float discountCostprice = (costPrice * percent) / 10;
						
					   discountCostprice=(float)(Math.round(discountCostprice*100))/100;
						
						productList.get(i).setDiscountPrice(discountCostprice);
					}

				}

			}

			// 查询用户是否关注当前品牌
			if (StringCommonUtils.isInvalidateId(userId)) {
				returnMap.put("collectionFlag", 0);
			} else {
				UserCollectionAuto userCollectionAuto = new UserCollectionAuto();
				userCollectionAuto.setCollectionType(5);
				userCollectionAuto.setUserId(userId);
				userCollectionAuto.setContentId(brandAuto.getBrandId());
				// 1：收藏 0：未收藏
				int collectionFlag = userCollectionService
						.queryIsCollection(userCollectionAuto);
				returnMap.put("collectionFlag", collectionFlag);
			}

			returnMap.put("brand", brandAuto);
			returnMap.put("productList", productList);
			return CommonResponseUtils.successResponse(returnMap);
		} catch (Exception e) {
			logger.info("查询品牌详情和商品列表失败");
			throw new RuntimeException(e);

		}

	}

	// 根据shopId查询品牌的列表
	@Override
	public Map<String, Object> queryBrandandList(Long shopId, Long pageIndex,
			Long checked, String brandName) throws RuntimeErrorException {

		try {

			Map<String, Object> returnMap = new HashMap<String, Object>();
			int pageSize = 10;
			// 给mybatis的map
			Map<String, Object> inputParameterMap = new HashMap<String, Object>();
			inputParameterMap.put("shopId", shopId);
			inputParameterMap.put("pageIndex", (pageIndex - 1) * pageSize);
			inputParameterMap.put("pageSize", pageSize);
			inputParameterMap.put("checked", checked);
			inputParameterMap.put("brandName", brandName);

			List<Map<String, Object>> mapList = shopandbrandAutoMapper
					.selectByShopId(inputParameterMap);
			inputParameterMap.remove("pageIndex");
			/* inputParameterMap.remove("brandName"); */
			Long pageCounts = shopandbrandAutoMapper
					.selectByShopIdPageCount(inputParameterMap);
			int pageCount = (int) Math.ceil((double) pageCounts / pageSize);
			if (mapList.size() > 0) {
				returnMap.put("brandList", mapList);
				returnMap.put("pageCount", pageCount);
				return CommonResponseUtils.successResponse(returnMap);

			}
			return CommonResponseUtils.successResponse();

		} catch (Exception e) {
			logger.info(" 根据shopId查询品牌的列表");
			throw new RuntimeException(e);

		}

	}

	/**
	 * 修改热门品牌
	 */
	@Override
	public Map<String, Object> updateHotBrand(BrandAuto bussinessBrandModel) {
		Map<String, Object> bussinessBrandMap = new HashMap<String, Object>();

		try {
			if (bussinessBrandModel.getAction() == 1) {
				BrandAutoExample brandAutoExample = new BrandAutoExample();
				brandAutoExample.createCriteria().andActionEqualTo(1L);
				int i = brandDao.countByExample(brandAutoExample);
				if (i >= 8) {
					return CommonResponseUtils
							.failureResponse("修改热门品牌失败，热门品牌已达8个");
				}
			}

			// 修改一条商品品牌信息
			int j = brandDao.updateByPrimaryKeySelective(bussinessBrandModel);
			if (j <= 0) {
				bussinessBrandMap.put(SUConstants.CODE_KEY,
						SUConstants.CODE_FAIL_VALUE);
				bussinessBrandMap.put(SUConstants.MSG_KEY, "修改热门品牌失败,数据库服务异常");
				return bussinessBrandMap;
			}

			bussinessBrandMap.put(SUConstants.CODE_KEY,
					SUConstants.CODE_SUCCESS_VALUE);
			bussinessBrandMap.put(SUConstants.MSG_KEY,
					SUConstants.CODE_SUCCESS_VALUE);

			return bussinessBrandMap;
		} catch (Exception e) {
			logger.info("=============>>>>>>修改热门品牌失败:", e);
			throw new MyException("修改热门品牌失败");
		}
	}

	/**
	 * 通过店铺id和shopid得到品牌列表 web前端（曹萌）
	 */
	@Override
	public Map<String, Object> queryBrandbyCategoryidShopId(Long shopId,
			Long categoryId) {
		try {

			Map<String, Object> inputMap = new HashMap<String, Object>();
			inputMap.put("shopId", shopId);
			inputMap.put("categoryId", categoryId);

			List<Map<String, Object>> returnMap = shopandbrandAutoMapper
					.selectByShopIdCategoryId(inputMap);

			return CommonResponseUtils.successResponse(returnMap);

		} catch (Exception e) {
			logger.info("通过店铺id和shopid得到品牌列表 web前端（曹萌）失败");
			throw new RuntimeException(e);

		}

	}

	/**
	 * 品牌申请(web前段王思雨)
	 */
	@Override
	public Map<String, Object> brandApply(ShopandbrandAuto shopandbrandAuto) {

		try {
			// 把品牌的状态更改为待审核状态 2为待审核
			shopandbrandAuto.setChecked(2);
			if (shopandbrandAutoMapper.insertSelective(shopandbrandAuto) > 0) {

				return CommonResponseUtils.successResponse();

			} else {
				return CommonResponseUtils.failureResponse("品牌申请失败");

			}

		} catch (Exception e) {

			logger.info("品牌申请失败");
			throw new RuntimeException(e);

		}

	}

	/**
	 * 品牌审核
	 */
	@Override
	public Map<String, Object> brandAudit(ShopandbrandAuto shopandbrandAuto) {
		try {

			SimpleDateFormat simpleDate = new SimpleDateFormat(
					"yyyy-MM-dd H:m:s");
			Date date = new Date();
			shopandbrandAuto.setCheckedTime(simpleDate.format(date));

			// 审核状态(0:已经通过，1拒绝，2等待审核)
			if (shopandbrandAutoMapper.updateChecked(shopandbrandAuto) > 0) {

				return CommonResponseUtils.successResponse("审核成功");

			} else {
				return CommonResponseUtils.failureResponse("审核失败，");

			}

		} catch (Exception e) {

			logger.info("订单审核失败");

			throw new RuntimeException(e);

		}

	}

}
