package com.essential.bussiness.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.essential.bussiness.product.model.auto.ProductAuto;
import com.essential.bussiness.product.model.auto.ProductAutoExample;
import com.essential.bussiness.product.model.vo.Count;
import com.essential.bussiness.product.model.vo.ProductAutoAddField;
import com.essential.bussiness.product.model.vo.ProductBaseInfoVo;
import com.essential.bussiness.product.model.vo.ProductDetaileInfoPlatformVo;
import com.essential.bussiness.product.model.vo.ProductInfoWithPromotionVo;
import com.essential.bussiness.product.model.vo.ProductOrShopCountVo;
import com.essential.bussiness.product.model.vo.ProductPlatformVo;
import com.essential.bussiness.product.model.vo.ProductPromotionVo;
import com.essential.bussiness.product.model.vo.ProductSerchInfoVo;
import com.essential.bussiness.product.model.vo.QueryProductListVO;
import com.essential.bussiness.product.model.vo.QueryProductPromotionVo;
import com.essential.bussiness.promotion.model.vo.PromotionCount;
import com.essential.bussiness.promotion.model.vo.PromotionProductVo;

public interface ProductAutoMapper {
	int countByExample(ProductAutoExample example);

	int deleteByExample(ProductAutoExample example);

	int deleteByPrimaryKey(Long productId);

	int insert(ProductAuto record);

	int insertSelective(ProductAuto record);

	List<ProductAuto> selectByExample(ProductAutoExample example);

	ProductAuto selectByProductId(Long productId);

	ProductAutoAddField selectByPrimaryKey(Long productId);

	int updateByExampleSelective(@Param("record") ProductAuto record, @Param("example") ProductAutoExample example);

	int updateByExample(@Param("record") ProductAuto record, @Param("example") ProductAutoExample example);

	int updateByPrimaryKeySelective(ProductAuto record);

	int updateByPrimaryKey(ProductAuto record);

	// 通过品牌和分类查询产品列表
	/* List<ProductAuto> selectAll(Map<String,Object> record); */
	//
	List<ProductAutoAddField> selectAll(Map<String, Object> record);
	
	List<QueryProductListVO> selectAllLast(Map<String, Object> record);
	

	// 相关商品的详细信息获取
	ProductBaseInfoVo queryProductBaseInfoById(ProductAuto record);

	// 相关商品的商品获取
	List<ProductInfoWithPromotionVo> queryProductRelatedGoods(Map<String, Object> record);

	// 查询商品列表通过品牌id
	List<ProductAutoAddField> selectByBrandId(Map<String, Object> record);

	/**
	 * 根据运费模板组 查询是否有商品在使用
	 * 
	 * @param productAuto
	 * @return
	 */
	List<ProductAuto> queryProductByFreightGroupId(ProductAuto productAuto);

	// 商品查询,通过shopId查询
	List<ProductSerchInfoVo> queryProductByShopId(Map<String, Object> record);

	// 促销活动商品查询
	List<PromotionProductVo> queryPromotionProductByShopId(Map<String, Object> record);

	// 查询商品信息
	ProductAutoAddField queryByPrimaryKey(ProductAuto productAuto);

	// 通过shopID的查询商品总条数
	ProductSerchInfoVo queryProductByShopIdCount(Map<String, Object> record);

	// 促销活动商品总条数
	PromotionCount queryPromotionProductCount(Map<String, Object> record);

	// 商品KPI统计数量
	ProductOrShopCountVo productCount(Map<String, Object> record);

	// 查询商品（平台）
	List<ProductPlatformVo> queryProductPlatform(ProductPlatformVo record);
	Count queryCount(ProductPlatformVo record);

	// 查询数据（数据迁移使用）
	List<ProductAutoAddField> queryInfo(ProductAuto record);

	// 查看商品详情
	ProductDetaileInfoPlatformVo queryProductDetaileInfo(Long productId);

	// 通过shopID更新商品状态
	int updateProductStatusByShopId(ProductAuto record);
	
	// 通过shopId查询商品（平台）
	List<ProductAutoAddField> queryProductList(ProductAuto record);
	
	//查询活动商品列表
	List<QueryProductPromotionVo> queryPromotionProductList(Map<String, Object> record);
	
	// 通过活动id查询参加活动商品（设置商品折扣）
	List<ProductPromotionVo> queryByPromotionId(Map<String, Object> record);
}