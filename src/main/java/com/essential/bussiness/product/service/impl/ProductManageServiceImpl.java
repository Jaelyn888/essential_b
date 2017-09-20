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
import com.essential.bussiness.product.model.vo.ProductAutoAddField;
import com.essential.bussiness.product.model.vo.ProductManageInfoVo;
import com.essential.bussiness.product.model.vo.ProductManageSerchInfo;
import com.essential.bussiness.product.model.vo.ProductManageVo;
import com.essential.bussiness.product.model.vo.ProductOrShopCountVo;
import com.essential.bussiness.product.model.vo.ProductReleaseCommodityVO;
import com.essential.bussiness.product.model.vo.ProductSerchInfoVo;
import com.essential.bussiness.product.model.vo.ProductSkuAutoListVO;
import com.essential.bussiness.product.model.vo.ProductSkuAutoVO;
import com.essential.bussiness.product.model.vo.ProductSkuRelationVO;
import com.essential.bussiness.product.service.IProductManageService;
import com.essential.bussiness.product.service.IProductSkuService;
import com.essential.bussiness.promotion.controller.PromotionAutoController;
import com.essential.bussiness.promotion.model.vo.PromotionProductInfoVo;
import com.essential.bussiness.rejectreason.dao.RejectReasonAutoMapper;
import com.essential.bussiness.rejectreason.model.auto.RejectReasonAuto;
import com.essential.bussiness.shop.service.IShopBackstageInfoService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.user.service.IUserCollectionService;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * 商品管理（出售中的，已售罄的，仓库中的）
 * 
 * @author czm
 *
 */
@Service
public class ProductManageServiceImpl implements IProductManageService {
	private static Logger logger = LoggerFactory.getLogger(ProductManageServiceImpl.class);

	// 商品表
	@Autowired
	ProductAutoMapper productAutoMapper;

	// 商品图片表
	@Autowired
	ProductPicAutoMapper productPicAutoMapper;

	// 商品规格表（SKU）
	@Autowired
	ProductSkuAutoMapper productSkuAutoMapper;

	// 商品规格关系表（SKU Relation）
	@Autowired
	ProductSkuRelationAutoMapper productSkuRelationAutoMapper;

	// 促销活动表
	@Autowired
	PromotionAutoController promotionAutoController;

	// 驳回信息表
	@Autowired
	RejectReasonAutoMapper rejectReasonAutoMapper;

	// 店铺
	@Autowired
	IShopBackstageInfoService shopBackstageInfoService;

	// 用户
	@Autowired
	IUserCollectionService userCollectionService;

	// 商品规格
	@Autowired
	IProductSkuService productSkuService;

	/**
	 * 查询商品信息
	 */
	@Override
	public Map<String, Object> queryProductInfo(ProductManageSerchInfo productManageSerchInfo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> promotionMap = new HashMap<String, Object>();
		Map<String, Object> inputParameterMap = new HashMap<String, Object>();
		try {

			ProductManageInfoVo productManageInfoVo = new ProductManageInfoVo();
			Integer pageSize = productManageSerchInfo.getPageSize();
			if (pageSize == null) {
				pageSize = 20;
			}
			int pageIndexs = (productManageSerchInfo.getPageIndex() - 1) * pageSize;
			List<ProductManageVo> productManageVoList = new ArrayList<ProductManageVo>();

			Long shopId = productManageSerchInfo.getShopId();

			int pageCount = 0;

			int type = productManageSerchInfo.getType();

			// 页面显示条数
			inputParameterMap.put("pageSize", pageSize);
			// 页数
			inputParameterMap.put("pageIndex", pageIndexs);
			// 店铺Id
			inputParameterMap.put("shopId", shopId);
			// 是否删除
			inputParameterMap.put("isDelete", SUConstants.IS_NOT_DELETE);
			// 商品名称
			String productName = productManageSerchInfo.getProductName();
			if (productName != null && !"".equals(productName)) {

				inputParameterMap.put("productName", productName);
			}
			// 价格
			inputParameterMap.put("firstPrice", productManageSerchInfo.getFirstPrice());
			// 价格
			inputParameterMap.put("secondPrice", productManageSerchInfo.getSecondPrice());
			// 商品代码
			String articleNumber = productManageSerchInfo.getArticleNumber();
			if (articleNumber != null && !"".equals(articleNumber)) {

				inputParameterMap.put("articleNumber", articleNumber);
			}
			// 商品品牌
			inputParameterMap.put("brandId", productManageSerchInfo.getBrandId());
			// 商品分类
			inputParameterMap.put("categoryId", productManageSerchInfo.getCategoryId());
			// 商品状态
			inputParameterMap.put("saleStatus", productManageSerchInfo.getSaleStatus());
			// 类型
			inputParameterMap.put("type", type);

			List<ProductSerchInfoVo> productAutoList = productAutoMapper.queryProductByShopId(inputParameterMap);

			for (int i = 0; i < productAutoList.size(); i++) {
				ProductManageVo productManageVo = new ProductManageVo();

				ProductSerchInfoVo productSerchInfoVo = productAutoList.get(i);
				DTOUtils.map(productSerchInfoVo, productManageVo);
				// 商品Id
				long productId = productSerchInfoVo.getProductId();
				// productManageVo.setPromotionType(3);
				// // 促销活动名称
				// productManageVo.setPromotionName("");
				// // 促销活动标签
				// productManageVo.setTag("");
				// productManageVo.setPromotionPrice(new BigDecimal(0));

				promotionMap = promotionAutoController.productPromotion(productId);
				if (SUConstants.CODE_FAIL_VALUE.equals(promotionMap.get(SUConstants.CODE_KEY))) {
					throw new Exception("查询商品是否参加促销活动!");
				}
				if (SUConstants.CODE_SUCCESS_VALUE.equals(promotionMap.get(SUConstants.CODE_KEY))) {
					PromotionProductInfoVo promotionProductInfoVo = (PromotionProductInfoVo) promotionMap.get(SUConstants.INFO_KEY);
					// 促销活动类型
					Integer promotionType = promotionProductInfoVo.getPromotionType();
					productManageVo.setPromotionType(promotionType);
					// 促销活动名称
					productManageVo.setPromotionName(promotionProductInfoVo.getPromotionName());
					// 促销活动标签
					productManageVo.setTag(promotionProductInfoVo.getTag());
					// // 减满送
					// BigDecimal discountMoney =
					// promotionProductInfoVo.getDiscountMoney();
					// 折扣
					BigDecimal discountPercent = new BigDecimal(promotionProductInfoVo.getDiscountPercent() / 10);

					// 促销活动价格
					BigDecimal discountPrice = null;
					if (promotionType == 0) {
						BigDecimal promotionPrice = productSerchInfoVo.getCostPrice().multiply(discountPercent);
						discountPrice = promotionPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
					}
					// else if (promotionType == 1) {
					// promotionPrice =
					// productSerchInfoVo.getCostPrice().subtract(discountMoney);
					// }
					productManageVo.setDiscountPrice(discountPrice);
					// 是否有活动 0-没有活动，1-有活动
					productManageVo.setLinkUrl("1");
				}
				// 未参加活动
				if ("3".equals(promotionMap.get(SUConstants.CODE_KEY))) {
					productManageVo.setPromotionType(3);
					// 是否有活动 0-没有活动，1-有活动
					productManageVo.setLinkUrl("0");
				}
				// 上下架
				int saleStatus = productManageVo.getSaleStatus();
				// 剩余库存
				// long stock = productManageVo.getStock();

				if (saleStatus == 0) {
					productManageVo.setSaleStatusNume("下架");
				}
				if (saleStatus == 1) {
					productManageVo.setSaleStatusNume("上架");
				}
				if (saleStatus == 2) {
					productManageVo.setSaleStatusNume("强制下架");
				}

				// 仓库中的商品
				if (type == 0 && saleStatus == 0 || saleStatus == 2) {
					if (saleStatus == 2) {
						// 获取强制下架原因
						RejectReasonAuto rejectReasonAuto = new RejectReasonAuto();
						rejectReasonAuto.setRejectWorkId(productId);
						rejectReasonAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);
						rejectReasonAuto = rejectReasonAutoMapper.queryByPrimaryKey(rejectReasonAuto);
						if (rejectReasonAuto != null) {
							productManageVo.setRejectReasonContent(rejectReasonAuto.getRejectReasonContent());
						}
					}
					// productManageVoList.add(productManageVo);
				}
				// // 已售罄的商品
				// if (type == 1 && saleStatus == 1 && stock == 0) {
				// productManageVoList.add(productManageVo);
				// }
				// // 出售中的商品
				// if (type == 2 && saleStatus == 1 && stock > 0) {
				// productManageVoList.add(productManageVo);
				// }
				// // 上架的商品
				// if (type == 3 && saleStatus == 1) {
				// productManageVoList.add(productManageVo);
				// }
				productManageVoList.add(productManageVo);
			}
			ProductSerchInfoVo productCount = productAutoMapper.queryProductByShopIdCount(inputParameterMap);

			// 总数
			pageCount = productCount.getCount();
			productManageInfoVo.setPageCount(pageCount);
			// 商品信息List
			productManageInfoVo.setProductManageVoList(productManageVoList);
			map.putAll(CommonResponseUtils.successResponse(productManageInfoVo));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>>商品信息查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 商品上架
	 */
	@Override
	public Map<String, Object> addProductShelves(Long[] productIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			for (int i = 0; i < productIds.length; i++) {
				long productId = productIds[i];
				ProductAuto productAuto = new ProductAuto();
				productAuto.setProductId(productId);
				productAuto.setSaleStatus(1);

				int j = productAutoMapper.updateByPrimaryKeySelective(productAuto);
				if (j <= 0) {
					throw new Exception("商品上架失败!");
				}
			}
			map.putAll(CommonResponseUtils.successResponse("商品上架成功"));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>商品上架失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除商品
	 */
	@Override
	public Map<String, Object> deleteProducts(Long[] productIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (productIds == null || productIds.length <= 0) {
				throw new Exception("删除商品失败!");
			}
			for (int i = 0; i < productIds.length; i++) {
				long productId = productIds[i];
				// 删除商品
				ProductAuto productAuto = new ProductAuto();
				// 商品Id
				productAuto.setProductId(productId);
				// 是否删除
				productAuto.setIsDelete(SUConstants.IS_DELETE);

				int j = productAutoMapper.updateByPrimaryKeySelective(productAuto);
				if (j <= 0) {
					throw new Exception("删除商品失败!");
				}

				// 删除商品图片
				ProductPicAuto productPicAuto = new ProductPicAuto();
				// 商品Id
				productPicAuto.setProductId(productId);
				// 是否删除
				productPicAuto.setStatus(SUConstants.IS_DELETE);
				int k = productPicAutoMapper.updateByProductIdPrimary(productPicAuto);
				if (k <= 0) {
					throw new Exception("删除商品图片失败!");
				}

				// 删除商品规格
				ProductSkuAuto productSkuAuto = new ProductSkuAuto();
				// 商品Id
				productSkuAuto.setProductId(productId);
				// 是否删除
				productSkuAuto.setIsDelete(SUConstants.IS_DELETE);
				int q = productSkuAutoMapper.updateByProductIdPrimaryKey(productSkuAuto);
				if (q <= 0) {
					throw new Exception("删除商品规格失败!");
				}

				// 删除商品规格关系（SKU Relation）
				ProductSkuRelationAuto productSkuRelationAuto = new ProductSkuRelationAuto();
				// 商品Id
				productSkuRelationAuto.setProductId(productId);
				// 是否删除
				productSkuRelationAuto.setIsDelete(SUConstants.IS_DELETE);
				productSkuRelationAuto.setModifyTime(TmDateUtil.getTimeStamp());

				int p = productSkuRelationAutoMapper.updateIsdeleteByProductId(productSkuRelationAuto);
				if (p <= 0) {
					throw new Exception("删除商品规格关系失败!");
				}
			}
			map.putAll(CommonResponseUtils.successResponse("删除商品成功!"));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>删除商品失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 编辑商品
	 */
	@Override
	public Map<String, Object> editeProducts(Long productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ProductReleaseCommodityVO productReleaseCommodityVO = new ProductReleaseCommodityVO();

			// 查询商品
			ProductAutoAddField productAutoAddField = new ProductAutoAddField();
			// 商品Id
			productAutoAddField.setProductId(productId);
			// 是否删除
			productAutoAddField.setIsDelete(SUConstants.IS_NOT_DELETE);

			ProductAutoAddField ProductAutoAddField = productAutoMapper.selectByPrimaryKey(productId);
			DTOUtils.map(ProductAutoAddField, productReleaseCommodityVO);

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
			productReleaseCommodityVO.setPicturePathList(picturePathList);

			// 商品SKU
			List<ProductSkuAutoListVO> productSkuAutoList = new ArrayList<ProductSkuAutoListVO>();

			// 查询商品规格(SKU)
			ProductSkuAuto productSkuAuto = new ProductSkuAuto();
			productSkuAuto.setProductId(productId);
			productSkuAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<ProductSkuAuto> productSkuList = productSkuAutoMapper.queryByPrimaryKey(productSkuAuto);
			for (int i = 0; i < productSkuList.size(); i++) {
				ProductSkuAutoListVO productSkuAutoListVO = new ProductSkuAutoListVO();
				ProductSkuAuto productSku = productSkuList.get(i);

				productSkuAutoListVO.setArticleNumber(productSku.getArticleNumber());
				// 商品价格
				productSkuAutoListVO.setPrices(productSku.getPrices());
				// 商品Id
				productSkuAutoListVO.setProductId(productSku.getProductId());
				// 商品库存
				productSkuAutoListVO.setProductskuCount(productSku.getProductskuCount());
				// SKU id
				productSkuAutoListVO.setProductskuId(productSku.getProductskuId());

				// 查询商品规格关系（SKU Relation）
				ProductSkuRelationAuto productSkuRelationAuto = new ProductSkuRelationAuto();
				// 商品Id
				productSkuRelationAuto.setProductId(productSku.getProductId());
				// SKU id
				productSkuRelationAuto.setProductskuId(productSku.getProductskuId());
				// 是否删除
				productSkuRelationAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
				List<ProductSkuRelationAuto> productSkuRelationList = productSkuRelationAutoMapper.queryByPrimaryKey(productSkuRelationAuto);
				List<ProductSkuRelationVO> productSkuRelationVOList = new ArrayList<ProductSkuRelationVO>();
				for (int j = 0; j < productSkuRelationList.size(); j++) {
					ProductSkuRelationAuto productSkuRelation = productSkuRelationList.get(j);
					ProductSkuRelationVO productSkuRelationVO = new ProductSkuRelationVO();
					// Key id
					productSkuRelationVO.setSpecificationKeyId(productSkuRelation.getSpecificationKeyId());
					// Value id
					productSkuRelationVO.setSpecificationValueId(productSkuRelation.getSpecificationValueId());
					// 层级
					productSkuRelationVO.setType(productSkuRelation.getType());
					productSkuRelationVOList.add(productSkuRelationVO);

				}
				productSkuAutoListVO.setProductSkuRelationList(productSkuRelationVOList);
				productSkuAutoList.add(productSkuAutoListVO);
			}
			productReleaseCommodityVO.setProductSkuAutoList(productSkuAutoList);
			map.putAll(CommonResponseUtils.successResponse(productReleaseCommodityVO));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>编辑商品失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 更新商品
	 */
	@Override
	public Map<String, Object> updateProduct(ProductReleaseCommodityVO productReleaseCommodityVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> productMap = new HashMap<String, Object>();
		try {
			// 商品Id
			Long productId = productReleaseCommodityVO.getProductId();
			// 登录用户
			long loginUser = productReleaseCommodityVO.getLoginUser();
			// 时间戳
			String dateTime = TmDateUtil.getTimeStamp();
			// 库存
			Long stock = productReleaseCommodityVO.getTotalStoreNum();

			ProductServiceImpl productServiceImpl = new ProductServiceImpl();
			List<ProductSkuAutoListVO> productSkuAutoListVO = productReleaseCommodityVO.getProductSkuAutoList();
			String maxPrice = productServiceImpl.serchMaxPric(productSkuAutoListVO);
			// 更新商品信息
			ProductAuto productAuto = new ProductAuto();
			DTOUtils.map(productReleaseCommodityVO, productAuto);
			// 库存
			productAuto.setStock(stock);
			// 最大价格
			productAuto.setProductintro(maxPrice);
			// 价格
			productAuto.setPrice(productReleaseCommodityVO.getCostPrice());
			// 修改用户
			productAuto.setModifyUser(loginUser);
			// 修改时间
			productAuto.setModifyTime(dateTime);
			int i = productAutoMapper.updateByPrimaryKeySelective(productAuto);

			if (i <= 0) {
				throw new Exception("更新商品SPU失败!");
			}
			int k = 0;
			// 更新规格信息
			// 先查询商品是否存在规格信息，若存在则删除更新前的规格规格信息
			List<ProductSkuAuto> productSku = productSkuAutoMapper.querySkuByProductId(productId);
			if (productSku != null && productSku.size() > 0) {
				ProductSkuAuto productSkuAuto = new ProductSkuAuto();
				productSkuAuto.setModifyTime(TmDateUtil.getTimeStamp());
				productSkuAuto.setModifyUser(loginUser);
				productSkuAuto.setProductId(productId);
				productSkuAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
				k = productSkuAutoMapper.updateByProductIdPrimaryKey(productSkuAuto);
				if (k <= 0) {
					throw new Exception("删除更新前的规格规格信息失败!");
				}
			}

			// 先查询商品是否存在规格关系信息，若存在则删除更新前的规格规格关系表信息
			List<ProductSkuRelationAuto> productSkuRelationList = productSkuRelationAutoMapper.querySkuRelationByProductId(productId);
			if (productSkuRelationList != null && productSkuRelationList.size() > 0) {
				ProductSkuRelationAuto productSkuRelationAuto = new ProductSkuRelationAuto();
				productSkuRelationAuto.setModifyTime(TmDateUtil.getTimeStamp());
				productSkuRelationAuto.setModifyUser(loginUser);
				productSkuRelationAuto.setProductId(productId);
				productSkuRelationAuto.setIsDelete(SUConstants.IS_DELETE);
				int y = productSkuRelationAutoMapper.updateIsdeleteByProductId(productSkuRelationAuto);
				if (y <= 0) {
					throw new Exception("删除更新前的规格规格关系表信息失败!");
				}
			}
			for (int q = 0; q < productSkuAutoListVO.size(); q++) {

				ProductSkuAutoListVO productSkuVO = productSkuAutoListVO.get(q);
				// 规格Id
				Long productSkuId = productSkuVO.getProductskuId();

				ProductSkuAuto productSkuInfo = new ProductSkuAuto();
				ProductSkuRelationAuto productSkuRelationAuto = new ProductSkuRelationAuto();

				// 获取规格关系List
				List<ProductSkuRelationVO> productSkuRelation = productSkuVO.getProductSkuRelationList();

				// 向SKU表插入数据
				// 因在插入数据时会返回主键，新插入时把主键设置空以防主键冲突
				productSkuInfo.setProductskuId(productSkuId);
				// 商品代码
				productSkuInfo.setArticleNumber(productSkuVO.getArticleNumber());
				// 价格
				productSkuInfo.setPrices(productSkuVO.getPrices());
				// 商品Id
				productSkuInfo.setProductId(productId);
				// 库存
				productSkuInfo.setProductskuCount(productSkuVO.getProductskuCount());
				if (productSkuId == null) {
					// 创建用户
					productSkuInfo.setCreateIser(loginUser);
					// 创建时间
					productSkuInfo.setCreateTime(dateTime);
					// 是否删除
					productSkuInfo.setIsDelete(SUConstants.IS_NOT_DELETE);
					k = productSkuAutoMapper.insertSelective(productSkuInfo);

					// 插入失败 跳出循环
					if (k <= 0) {
						throw new Exception("商品规格添加失败!");
					}
					// 获取SKU Id
					long productskuId = productSkuInfo.getProductskuId();

					// 规格关系Id
					productSkuRelationAuto.setProductskuId(productskuId);

				} else {
					// 创建用户
					productSkuInfo.setModifyUser(loginUser);
					// 创建时间
					productSkuInfo.setModifyTime(dateTime);
					// 是否删除
					productSkuInfo.setIsDelete(SUConstants.IS_NOT_DELETE);
					int y = productSkuAutoMapper.updateByPrimaryKeySelective(productSkuInfo);
					if (y <= 0) {
						throw new Exception("商品规格更新失败!");
					}
					// 规格关系Id
					productSkuRelationAuto.setProductskuId(productSkuId);

				}

				// 向SKU关系表插入数据
				// 商品Id
				productSkuRelationAuto.setProductId(productId);
				// 创建用户
				productSkuRelationAuto.setCreateUser(loginUser);
				// 是否删除
				productSkuRelationAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
				// 创建时间
				productSkuRelationAuto.setCreateTime(dateTime);

				for (int t = 0; t < productSkuRelation.size(); t++) {
					ProductSkuRelationVO productSkuRelationInfo = productSkuRelation.get(t);
					// keyId
					productSkuRelationAuto.setSpecificationKeyId(productSkuRelationInfo.getSpecificationKeyId());
					// valueId
					productSkuRelationAuto.setSpecificationValueId(productSkuRelationInfo.getSpecificationValueId());
					// 层级
					productSkuRelationAuto.setType(productSkuRelationInfo.getType());
					// 因在插入数据时会返回主键，新插入时把主键设置空以防主键冲突
					productSkuRelationAuto.setProductskuRelation(null);

					int y = productSkuRelationAutoMapper.insertSelective(productSkuRelationAuto);
					if (y <= 0) {
						throw new Exception("商品规格关系添加失败!");
					}

				}
			}

			// 先查询商品是否存在图片信息，若有删除更新前的商品主图图片
			ProductPicAuto productPicPath = new ProductPicAuto();
			productPicPath.setProductId(productId);

			productPicPath.setStatus(SUConstants.IS_NOT_DELETE);
			List<ProductPicAuto> productPicList = productPicAutoMapper.queryByPrimaryKey(productPicPath);
			if (productPicList != null && productPicList.size() > 0) {
				productPicPath.setStatus(SUConstants.IS_DELETE);
				int q = productPicAutoMapper.updateByProductIdPrimary(productPicPath);
				if (q <= 0) {
					throw new Exception("删除更新前的商品主图图片失败!");
				}
			}

			// 获取远程图片路径
			List<String> remotePictuerPathList = productReleaseCommodityVO.getPicturePathList();
			// 插入图片路径
			if (remotePictuerPathList != null && remotePictuerPathList.size() > 0) {
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
					productPicAuto.setPath(remotePictuerPathList.get(j));
					k = productPicAutoMapper.insertSelective(productPicAuto);
					if (k <= 0) {
						throw new Exception("商品图片更新失败!");
					}
				}
			}

			productMap.putAll(CommonResponseUtils.successResponse("更新成功!"));
			return productMap;
		} catch (Exception e) {
			logger.info("=====>>>>>更新商品失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 商品下架
	 */
	@Override
	public Map<String, Object> downloadProductShelves(Long[] productIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			for (int i = 0; i < productIds.length; i++) {
				long productId = productIds[i];
				ProductAuto productAuto = new ProductAuto();
				// 商品Id
				productAuto.setProductId(productId);
				// 上架下架,0为下架，1为上架，2-强行下架
				productAuto.setSaleStatus(0);
				// 是否活动 0-没有活动，1-有活动
				productAuto.setLinkUrl("0");

				int j = productAutoMapper.updateByPrimaryKeySelective(productAuto);
				if (j <= 0) {
					throw new Exception("商品下架失败!");
				}
			}
			map.putAll(CommonResponseUtils.successResponse("商品下架成功"));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>商品下架失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 店铺商品统计
	 */
	@Override
	public Map<String, Object> productCount(Long shopId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> inputMap = new HashMap<String, Object>();
		Map<String, Object> outputMap = new HashMap<String, Object>();
		try {
			// 0:商店KPI统计，1:平台KPI统计
			inputMap.put("type", 0);
			inputMap.put("shopId", shopId);
			inputMap.put("isDelete", SUConstants.IS_NOT_DELETE);

			ProductOrShopCountVo productOrShopCount = productAutoMapper.productCount(inputMap);

			outputMap.put("productInSaleCount", productOrShopCount.getProductInSaleCount());
			outputMap.put("productInStorehouseCount", productOrShopCount.getProductInStorehouseCount());
			outputMap.put("productSaleOutCount", productOrShopCount.getProductSaleOutCount());

			map.putAll(CommonResponseUtils.successResponse(outputMap));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>商品下架失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 平台商品/商家/用户统计
	 */
	@Override
	public Map<String, Object> productCountPlatform() {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> inputMap = new HashMap<String, Object>();
		Map<String, Object> outputMap = new HashMap<String, Object>();
		try {
			// 0:商店KPI统计，1:平台KPI统计
			inputMap.put("type", 1);
			inputMap.put("isDelete", SUConstants.IS_NOT_DELETE);
			ProductOrShopCountVo productOrShopCount = productAutoMapper.productCount(inputMap);
			// 商家统计
			Map<String, Object> shopCountMap = shopBackstageInfoService.shopCount();
			ProductOrShopCountVo shopCount = (ProductOrShopCountVo) shopCountMap.get(SUConstants.INFO_KEY);
			// 用户数
			Map<String, Object> userCountMasp = userCollectionService.userCount();
			ProductOrShopCountVo userCount = (ProductOrShopCountVo) userCountMasp.get(SUConstants.INFO_KEY);

			outputMap.put("productInSaleCount", productOrShopCount.getProductInSaleCount());
			outputMap.put("shopCount", shopCount.getShopCount());
			outputMap.put("userCount", userCount.getUserCount());

			map.putAll(CommonResponseUtils.successResponse(outputMap));
		} catch (Exception e) {
			logger.info("=====>>>>>商品下架失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("平台商品/商家/用户统计失败!"));
		}
		return map;
	}
}
