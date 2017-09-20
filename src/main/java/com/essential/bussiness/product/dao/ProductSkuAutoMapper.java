package com.essential.bussiness.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.essential.bussiness.product.model.auto.ProductSkuAuto;
import com.essential.bussiness.shopcart.model.vo.ShopCartProductSkuVo;

public interface ProductSkuAutoMapper {
	int deleteByPrimaryKey(Long productskuId);

	int insert(ProductSkuAuto record);

	int insertSelective(ProductSkuAuto record);

	ProductSkuAuto selectByPrimaryKey(Long productskuId);

	int updateByPrimaryKeySelective(ProductSkuAuto record);

	int updateByPrimaryKey(ProductSkuAuto record);

	List<ProductSkuAuto> queryAll(Map<String, Object> map);

	List<ProductSkuAuto> selectByProductId(Long productId);

	List<ProductSkuAuto> querySkuByProductId(Long productId);

	Long[] selectByProductIdFor2(Long productId);

	Long[] selectSkuIdByProductId(Long productId);

	// 通过产品id查询spu库存
	Long selectSpuStock(Long productId);

	ShopCartProductSkuVo selectProductSkuVoByPrimaryKey(@Param("productskuId") Long productskuId);

	// 逻辑删除
	int updateByProductIdPrimaryKey(ProductSkuAuto record);

	// 通过商品Id查询SKU
	List<ProductSkuAuto> queryByPrimaryKey(ProductSkuAuto record);
	//查询spu最大值和最小值
	Map<String,Object> selectMaxMinPrice(Long productId);
	//查询spu最大值和最小值原价
	Map<String,Object> selectMaxMinPriceOrigin(Long productId);
	
}