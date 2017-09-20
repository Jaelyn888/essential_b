package com.essential.bussiness.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.essential.bussiness.product.model.auto.ProductSkuRelationAuto;
import com.essential.bussiness.product.model.vo.ProductSKURelationInfoPlatformVo;

public interface ProductSkuRelationAutoMapper {
    int deleteByPrimaryKey(Long productskuRelation);

    int insert(ProductSkuRelationAuto record);

    int insertSelective(ProductSkuRelationAuto record);

    ProductSkuRelationAuto selectByPrimaryKey(Long productskuRelation);

    int updateByPrimaryKeySelective(ProductSkuRelationAuto record);

    int updateByPrimaryKey(ProductSkuRelationAuto record);
    
    Long[] selectKeyidBySkuid(Map<String,Object> map);
    
    Long[] selectValueidBySkuid(Map<String,Object> map);
    
    List<Long> selectValueIdsBySkuSingle (Map<String,Object> map);
    
    List<Map<String, Object>> selectSpecificationBySkuIds(@Param("productskuIds") Long[] productskuIds);
    Map<String,Object> selectskuCount(Map<String,Object> map);
    //逻辑删除
    int updateIsdeleteByProductId(ProductSkuRelationAuto record);
    // 查询商品规格关系
    List<ProductSkuRelationAuto> queryByPrimaryKey(ProductSkuRelationAuto record);
    
    List<ProductSkuRelationAuto> querySkuRelationByProductId(Long productId);
    
    List<ProductSKURelationInfoPlatformVo> querySkuRelationPlatformInfo(ProductSkuRelationAuto record);
    
}