package com.essential.bussiness.product.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.product.model.auto.ProductAuto;
import com.essential.bussiness.product.model.vo.ProductReleaseCommodityVO;
import com.essential.bussiness.product.model.vo.ProductSkuAutoListVO;
import com.essential.bussiness.product.service.IProductService;
import com.essential.bussiness.shopcart.controller.ShopCartController;
import com.essential.utils.CommonResponseUtils;

@Controller
@RequestMapping(value = "product")
public class ProductController {
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	/*
	 * @Autowired IProductService ProductService;
	 */
	@Autowired
	IProductService productService;

	/**
	 * 
	 * @param productAutoWithBLOBs
	 *            商品实体继承自 productAuto 添加商品
	 * @return
	 */
	@RequestMapping(value = "add")
	@ResponseBody
	public Map<String, Object> add(ProductAuto productAutoWithBLOBs) {
		try {
			return productService.add(productAutoWithBLOBs);

		} catch (Exception e) {
			logger.info("");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("增加商品失败");

		}

	}

	/**
	 * 
	 * @param productAuto
	 *            商品实体 删除商品
	 * @return
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public Map<String, Object> delete(ProductAuto productAuto) {
		try {
			return productService.delete(productAuto);

		} catch (Exception e) {
			logger.info("删除商品失败");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("删除商品失败");

		}

	}

	/**
	 * 
	 * @param 商品实体类
	 *            productAut 更新商品
	 * 
	 * @return
	 */
	@RequestMapping(value = "update")
	@ResponseBody
	public Map<String, Object> update(ProductAuto productAuto) {
		try {
			return productService.update(productAuto);

		} catch (Exception e) {

			logger.info("更新商品失败");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("更新商品失败");
		}

	}

	/**
	 * 
	 * @param productAutoWithBLOBs
	 *            商品实体继承自 productAuto 查询商品
	 * @return
	 */
	@RequestMapping(value = "query")
	@ResponseBody
	public Map<String, Object> queryc(@RequestParam(value = "brandIds") Long[] brandIds, @RequestParam(value = "productTypeIds") Long[] productTypeIds,
			@RequestParam(value = "pageIndex") int pageIndex, int type, int own, ProductAuto productAuto) {

		try {

			return productService.query(brandIds, productTypeIds, pageIndex, type, own, productAuto);

		} catch (Exception e) {

			logger.info("查询商品列表失败");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询商品列表失败");

		}

	}
	
	
	/**兼容API
	 * 
	 * @param productAutoWithBLOBs
	 *            商品实体继承自 productAuto 查询商品
	 * @return
	 */
	@RequestMapping(value = "query2")
	@ResponseBody
	public Map<String, Object> queryc(@RequestParam(value = "brandIds") Long[] brandIds, @RequestParam(value = "productTypeIds") Long[] productTypeIds,
			@RequestParam(value = "pageIndex") int pageIndex, int type, int own,int isDiscount,ProductAuto productAuto) {

		try {

			return productService.query(brandIds, productTypeIds, pageIndex, type, own,isDiscount, productAuto);

		} catch (Exception e) {

			logger.info("查询商品列表失败");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询商品列表失败");

		}

	}
	/**兼容API
	 * 
	 * @param productAutoWithBLOBs
	 *            商品实体继承自 productAuto 查询商品
	 * @return
	 */
	@RequestMapping(value = "queryLast")
	@ResponseBody
	public Map<String, Object> queryLast(@RequestParam(value = "brandIds") Long[] brandIds, @RequestParam(value = "productTypeIds") Long[] productTypeIds,
			@RequestParam(value = "pageIndex") int pageIndex, int type, int own,int isDiscount,ProductAuto productAuto) {

		try {

			return productService.queryLast(brandIds, productTypeIds, pageIndex, type, own,isDiscount, productAuto);

		} catch (Exception e) {

			logger.info("查询商品列表失败");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询商品列表失败");

		}

	}
	
	/**
	 * 查询商品详情
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "queryByProductId")
	@ResponseBody
	public Map<String, Object> queryById(HttpServletRequest req) {
		try {
			return productService.queryById(req);

		} catch (Exception e) {
			logger.info("查询商品详情失败");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询商品详情失败");

		}

	}

	/**
	 * 发布商品 的 商品信息
	 * 
	 * @param productReleaseCommodityVO
	 * @return
	 */
	@RequestMapping(value = "addReleaseCommodity")
	@ResponseBody
	public Map<String, Object> addReleaseCommodity(ProductReleaseCommodityVO productReleaseCommodityVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer saleStatus = productReleaseCommodityVO.getSaleStatus();
		try {
			// 判断是否有商品主图
			List<String> picturePathList = productReleaseCommodityVO.getPicturePathList();
			if (picturePathList == null) {
				return CommonResponseUtils.failureResponse("商品主图不能为空!");
			}

			// 判断是否有商品规格
			List<ProductSkuAutoListVO> productSkuAutoList = productReleaseCommodityVO.getProductSkuAutoList();
			if (productSkuAutoList == null || productSkuAutoList.size() <= 0) {
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

			return productService.addReleaseCommodity(productReleaseCommodityVO);
		} catch (Exception e) {
			if (saleStatus == 1) {
				logger.info("======>>>>>>>>>>发布商品失败:" + e);
			} else {
				logger.info("======>>>>>>>>>>商品添加仓库失败:" + e);
			}
			e.printStackTrace();
			if (saleStatus == 1) {
				map.putAll(CommonResponseUtils.failureResponse("发布商品失败!"));
			} else {
				map.putAll(CommonResponseUtils.failureResponse("商品添加仓库失败!"));
			}
			return map;
		}

	}

	/**
	 * 商品详情/售后详情
	 * 
	 * @param productId
	 * @param type
	 *            0-商品详情，1-售后详情
	 * @return
	 */
	@RequestMapping(value = "queryProductDetails")
	@ResponseBody
	public Map<String, Object> queryProductDetails(Long productId, int type) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return productService.queryProductDetails(productId, type);
		} catch (Exception e) {
			if (type == 0) {
				logger.info("======>>>>>>>>>>商品详情查询失败:" + e);
				map.putAll(CommonResponseUtils.failureResponse("商品详情查询失败!"));
			} else {
				logger.info("======>>>>>>>>>>售后详情查询失败:" + e);
				map.putAll(CommonResponseUtils.failureResponse("售后详情查询失败!"));
			}
			e.printStackTrace();
		}
		return map;
	}
}
