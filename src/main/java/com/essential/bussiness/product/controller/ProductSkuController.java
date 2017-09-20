package com.essential.bussiness.product.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.product.model.auto.ProductSkuAuto;
import com.essential.bussiness.product.model.vo.ProductSkuAutoVO;
import com.essential.bussiness.product.service.IProductSkuService;

@Controller
@RequestMapping(value = "productSku")
public class ProductSkuController {

	@Autowired
	IProductSkuService ProductSkuService;

	/**
	 * 
	 * @param ProductSkuAuto
	 *            商品sku实体 增加一个商品sku
	 * @return
	 */
	@RequestMapping(value = "addProductSku")
	@ResponseBody
	public Map<String, Object> addProductSku(ProductSkuAutoVO productSkuAutoVO) {

		return ProductSkuService.addProductSku(productSkuAutoVO);

	}   

	/**
	 * 
	 * @param ProductSkuAuto
	 *            商品sku实体 删除一个商品sku
	 * @return
	 */
	@RequestMapping(value = "deleteProductSku")
	@ResponseBody
	public Map<String, Object> deleteProductSku(ProductSkuAuto ProductSkuAuto) {

		return ProductSkuService.deleteProductSku(ProductSkuAuto);

	}

	/**
	 * 
	 * @param ProductSkuAuto
	 *            商品sku实体 修改一个商品sku
	 * @return
	 */
	@RequestMapping(value = "updateProductSku")
	@ResponseBody
	public Map<String, Object> updateProductSku(ProductSkuAutoVO productSkuAutoVO) {

		return ProductSkuService.updateProductSku(productSkuAutoVO);

	}

	/**
	 * 
	 * @param ProductSkuAuto
	 *            商品sku实体 查询一个商品sku
	 * @return
	 */
	@RequestMapping(value = "queryProductSku")
	@ResponseBody
	public Map<String, Object> queryProductSku(ProductSkuAuto ProductSkuAuto, int pageIndex) {

		return ProductSkuService.queryProductSku(ProductSkuAuto,pageIndex);

	}
}
