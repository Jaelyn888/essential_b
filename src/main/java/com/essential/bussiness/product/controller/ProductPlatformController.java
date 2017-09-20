package com.essential.bussiness.product.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.product.model.vo.ProductPlatformVo;
import com.essential.bussiness.product.model.vo.RejectProductReasonVo;
import com.essential.bussiness.product.service.IProductPlatformService;
import com.essential.utils.CommonResponseUtils;

/**
 * 商品管理（平台）
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "productPlatform")
public class ProductPlatformController {

	private static Logger logger = LoggerFactory.getLogger(ProductPlatformController.class);

	@Autowired
	IProductPlatformService productPlatformService;

	/**
	 * 查询商品
	 * 
	 * @param productPlatformVo
	 * @param type
	 *            0-上架商品，1-强制下架商品
	 * @return
	 */
	@RequestMapping(value = "queryProductPlatform")
	@ResponseBody
	public Map<String, Object> queryProductPlatform(ProductPlatformVo productPlatformVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer type = productPlatformVo.getType();
		try {
			return productPlatformService.queryProductPlatform(productPlatformVo);
		} catch (Exception e) {
			if (type == 0) {
				logger.info("======>>>>>>查询商品失败:" + e);
			} else {
				logger.info("======>>>>>>查询强制下架商品失败:" + e);
			}
			e.printStackTrace();
			if (type == 0) {
				map.putAll(CommonResponseUtils.failureResponse("查询商品失败!"));
			} else {
				map.putAll(CommonResponseUtils.failureResponse("查询强制下架商品失败!"));
			}
		}
		return map;
	}

	/**
	 * 强制下架/撤销强制下架
	 * 
	 * @param productId
	 * @param type
	 *            0-撤销强制下架，1-强制下架
	 * @return
	 */
	@RequestMapping(value = "forceOrRevokeProductPlatform")
	@ResponseBody
	public Map<String, Object> forceOrRevokeProductPlatform(RejectProductReasonVo rejectProductReasonVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer type = rejectProductReasonVo.getType();
		try {
			Long productId = rejectProductReasonVo.getProductId();
			if (productId == null) {

				return CommonResponseUtils.failureResponse("商品Id不能为空");
			}
			if(type == 1){
				String rejectReason = rejectProductReasonVo.getRejectReasonContent();
				if(rejectReason == null || "".equals(rejectReason)){
					return CommonResponseUtils.failureResponse("商品强制下架原因不能为空");
				}
			}
			return productPlatformService.forceOrRevokeProductPlatform(rejectProductReasonVo);
		} catch (Exception e) {
			if (type == 0) {
				logger.info("======>>>>>>撤销强制下架失败:" + e);
			} else {
				logger.info("======>>>>>>强制下架失败:" + e);
			}
			e.printStackTrace();
			if (type == 0) {
				map.putAll(CommonResponseUtils.failureResponse("撤销强制下架失败!"));
			} else {
				map.putAll(CommonResponseUtils.failureResponse("强制下架失败!"));
			}
		}
		return map;
	}

	/**
	 * 设置自营/取消自营
	 * 
	 * @param productId
	 * @param type
	 *            0-取消自营，1-设置自营
	 * @return
	 */
	@RequestMapping(value = "selfProductPlatform")
	@ResponseBody
	public Map<String, Object> selfProductPlatform(Long productId, Integer type) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return productPlatformService.selfProductPlatform(productId, type);
		} catch (Exception e) {
			if (type == 0) {
				logger.info("======>>>>>>取消自营失败:" + e);
			} else {
				logger.info("======>>>>>>设置自营失败:" + e);
			}
			e.printStackTrace();
			if (type == 0) {
				map.putAll(CommonResponseUtils.failureResponse("取消自营失败!"));
			} else {
				map.putAll(CommonResponseUtils.failureResponse("设置自营失败!"));
			}
		}
		return map;
	}

	/**
	 * 查看商品详情
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "queryProductDetaileInfo")
	@ResponseBody
	public Map<String, Object> queryProductDetaileInfo(Long productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return productPlatformService.queryProductDetaileInfo(productId);
		} catch (Exception e) {
			logger.info("======>>>>>>查看商品详情失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查看商品详情失败!"));

		}
		return map;
	}
}
