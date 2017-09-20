package com.essential.bussiness.product.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.product.model.auto.ProductSkuAuto;
import com.essential.bussiness.product.model.vo.ProductSkuAutoVO;

/**
 * 商品sku业务
 * ProductSkuAuto 商品sku实体
 * @author cpx
 *
 *addProductSku 增加一个商品sku
 *deleteProductSku 删除一个商品sku
 *updateProductSku 更新一个商品sku
 *queryProductSku 产讯一个商品sku
 */
@Service
public interface IProductSkuService {

	public Map<String, Object> addProductSku(ProductSkuAutoVO productSkuAutoVO);

	public Map<String, Object> deleteProductSku(ProductSkuAuto productAuto);

	public Map<String, Object> updateProductSku(ProductSkuAutoVO productSkuAutoVO);

	public Map<String, Object> queryProductSku(ProductSkuAuto productAuto, int pageIndex);

}