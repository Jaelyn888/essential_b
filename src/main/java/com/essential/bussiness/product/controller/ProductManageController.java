package com.essential.bussiness.product.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.product.model.vo.ProductManageSerchInfo;
import com.essential.bussiness.product.model.vo.ProductReleaseCommodityVO;
import com.essential.bussiness.product.model.vo.ProductSkuAutoListVO;
import com.essential.bussiness.product.service.IProductManageService;
import com.essential.utils.CommonResponseUtils;

/**
 * 商品管理（出售中的，已售罄的，仓库中的）
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "productManageController")
public class ProductManageController {
	private static Logger logger = LoggerFactory.getLogger(ProductManageController.class);

	@Autowired
	IProductManageService productManageService;

	/**
	 * 查询商品信息
	 * 
	 * @param shopId
	 *            店铺Id
	 * @param type
	 *            0-仓库中的商品，1-已售罄的商品，2-出售中的商品，3-上架的商品列表
	 * @param pageIndex
	 *            页数
	 * @return
	 */
	@RequestMapping(value = "queryProductInfo")
	@ResponseBody
	public Map<String, Object> queryProductInfo(ProductManageSerchInfo productManageSerchInfo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			return productManageService.queryProductInfo(productManageSerchInfo);
		} catch (Exception e) {
			logger.info("======>>>>>>商品信息查询失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("商品信息查询失败!"));
		}
		return map;
	}

	/**
	 * 商品上架
	 * 
	 * @param productId
	 *            商品Id
	 * @return
	 */
	@RequestMapping(value = "addProductShelves")
	@ResponseBody
	public Map<String, Object> addProductShelves(Long[] productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return productManageService.addProductShelves(productId);
		} catch (Exception e) {
			logger.info("======>>>>>>商品上架失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("商品上架失败!"));
		}
		return map;
	}

	/**
	 * 删除商品
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "deleteProducts")
	@ResponseBody
	public Map<String, Object> deleteProducts(Long[] productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return productManageService.deleteProducts(productId);
		} catch (Exception e) {
			logger.info("======>>>>>>删除商品失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("删除商品失败!"));
		}
		return map;
	}

	/**
	 * 查询需要编辑的商品信息
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "editeProducts")
	@ResponseBody
	public Map<String, Object> editeProducts(Long productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return productManageService.editeProducts(productId);
		} catch (Exception e) {
			logger.info("======>>>>>>编辑商品失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("编辑商品失败!"));
		}
		return map;
	}

	/**
	 * 更新商品
	 * 
	 * @param productReleaseCommodityVO
	 * @return
	 */
	@RequestMapping(value = "updateProduct")
	@ResponseBody
	public Map<String, Object> updateProduct(ProductReleaseCommodityVO productReleaseCommodityVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 判断是否有商品Id
			Long productId = productReleaseCommodityVO.getProductId();
			if (productId == null) {
				return CommonResponseUtils.failureResponse("商品Id不能为空!");
			}

			// 判断是否有商品主图
			List<String> picturePathList = productReleaseCommodityVO.getPicturePathList();
			if (picturePathList == null) {
				return CommonResponseUtils.failureResponse("商品主图不能为空!");
			}

			// 判断是否有商品规格
			List<ProductSkuAutoListVO> productSkuAutoList = productReleaseCommodityVO.getProductSkuAutoList();
			if (productSkuAutoList == null) {
				return CommonResponseUtils.failureResponse("商品规格不能为空!");
			}

			// 判断是否选择运费类型
			// 运费类型
			Integer freightType = productReleaseCommodityVO.getFreightType();
			// 运费
			BigDecimal freightPrice = productReleaseCommodityVO.getFreightPrice();
			// 运费模板
			Long freightGroupId = productReleaseCommodityVO.getFreightGroupId();
			if (freightType == null) {
				return CommonResponseUtils.failureResponse("请填写物流信息!");
			} else if (freightType == 0) {
				if (freightPrice == null) {
					return CommonResponseUtils.failureResponse("请填写物流运费!");
				}
			} else if (freightType == 1) {
				if (freightGroupId == null) {
					return CommonResponseUtils.failureResponse("请选择物流模板类型!");
				}
			}

			// 商品代码
			String articleNumber = productReleaseCommodityVO.getArticleNumber();
			if (articleNumber == null || "".equals(articleNumber)) {
				return CommonResponseUtils.failureResponse("请填写商品代码!");
			}

			// 商品名称
			String productName = productReleaseCommodityVO.getProductName();
			if (productName == null || "".equals(productName)) {
				return CommonResponseUtils.failureResponse("请填写商品名称!");
			}

			// 价格
			BigDecimal costPrice = productReleaseCommodityVO.getCostPrice();
			if (costPrice == null) {
				return CommonResponseUtils.failureResponse("请填写商品价格!");
			}

			// 一句话描述
			String words = productReleaseCommodityVO.getWords();
			if (words == null || "".equals(words)) {
				return CommonResponseUtils.failureResponse("请填写一句话描述!");
			}

			// 商品详情描述
			String productDescribe = productReleaseCommodityVO.getProductDescribe();
			if (productDescribe == null || "".equals(productDescribe)) {
				return CommonResponseUtils.failureResponse("请填写商品详情描述!");
			}

			// 商品退换货说明
			String returnProductExplain = productReleaseCommodityVO.getReturnProductExplain();
			if (returnProductExplain == null || "".equals(returnProductExplain)) {
				return CommonResponseUtils.failureResponse("请填写商品退换货说明!");
			}

			return productManageService.updateProduct(productReleaseCommodityVO);
		} catch (Exception e) {
			logger.info("======>>>>>>编辑商品失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("编辑商品失败!"));
		}
		return map;
	}

	/**
	 * 商品下架
	 * 
	 * @param productId
	 *            商品Id
	 * @return
	 */
	@RequestMapping(value = "downloadProductShelves")
	@ResponseBody
	public Map<String, Object> downloadProductShelves(Long[] productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return productManageService.downloadProductShelves(productId);
		} catch (Exception e) {
			logger.info("======>>>>>>商品下架失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("商品下架失败!"));
		}
		return map;
	}

	/**
	 * 商品统计
	 * 
	 * @param type
	 * @param shopId
	 * @return
	 */
	@RequestMapping(value = "productCount")
	@ResponseBody
	public Map<String, Object> productCount(Long shopId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return productManageService.productCount(shopId);
		} catch (Exception e) {
			logger.info("======>>>>>>商品下架失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("商品下架失败!"));
		}
		return map;
	}

	/**
	 * 平台商品统计
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(value = "productCountPlatform")
	@ResponseBody
	public Map<String, Object> productCountPlatform() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return productManageService.productCountPlatform();
		} catch (Exception e) {
			logger.info("======>>>>>>商品下架失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("商品下架失败!"));
		}
		return map;
	}
}
