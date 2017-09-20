package com.essential.bussiness.product.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.product.model.vo.ProductManageSerchInfo;
import com.essential.bussiness.product.model.vo.ProductReleaseCommodityVO;

/**
 * 商品管理（出售中的，已售罄的，仓库中的）
 * 
 * @author czm
 *
 */
@Service
public interface IProductManageService {
	// 查询商品信息
	public Map<String, Object> queryProductInfo(ProductManageSerchInfo productManageSerchInfo);

	// 商品上架
	public Map<String, Object> addProductShelves(Long[] productId);

	// 删除商品
	public Map<String, Object> deleteProducts(Long[] productId);

	// 编辑商品
	public Map<String, Object> editeProducts(Long productId);
	
	//更新商品
	public Map<String, Object> updateProduct(ProductReleaseCommodityVO productReleaseCommodityVO);

	// 商品下架
	public Map<String, Object> downloadProductShelves(Long[] productId);
	
	// 店铺商品统计
	public Map<String, Object> productCount(Long shopId);
	
	// 平台商品统计
	public Map<String, Object> productCountPlatform();
}
