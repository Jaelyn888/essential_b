package com.essential.bussiness.shopcart.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.essential.bussiness.product.model.auto.ProductSkuAuto;
import com.essential.bussiness.shopcart.model.auto.ShopCartAuto;
import com.essential.bussiness.shopcart.model.auto.ShopCartAutoExample;
import com.essential.bussiness.shopcart.model.vo.SkuShopCartVo;

public interface ShopCartAutoMapper {
   
    int countByExample(ShopCartAutoExample example);

    int deleteByExample(ShopCartAutoExample example);

    int deleteByPrimaryKey(Long shopcartId);

    int insert(ShopCartAuto record);

    int insertSelective(ShopCartAuto record);

    List<ShopCartAuto> selectByExample(ShopCartAutoExample example);

    ShopCartAuto selectByPrimaryKey(Long shopcartId);

    int updateByExampleSelective(@Param("record") ShopCartAuto record, @Param("example") ShopCartAutoExample example);

    int updateByExample(@Param("record") ShopCartAuto record, @Param("example") ShopCartAutoExample example);

    int updateByPrimaryKeySelective(ShopCartAuto record);

    int updateByPrimaryKey(ShopCartAuto record);
    
    int updateProductCountByPrimaryKey(Map<String,Object> map);
    
    ProductSkuAuto selectProductCountByShopCartId(@Param("shopcartId") Long shopcartId);
    
    List<Map<String, Object>> queryTotalAndShopSelectedProductPriceByUserId(@Param("userId") Long userId);
    
    int selectCountIsSeelctForShopByUserId(@Param("userId") Long userId,@Param("shopId") Long shopId);
    
    List<Map<String, Object>> selectProductIsSelect(Map<String, Object> map);
    
    List<SkuShopCartVo> selectSkuShopCartVoByExample(ShopCartAutoExample example);
    
    List<SkuShopCartVo> selectSkuShopCartVoByUserId(ShopCartAuto record);
    
    SkuShopCartVo selectSkuShopCartVoByPrimaryKey(Long shopcartId);
    
    int updateBySkuShopCartVoPrimaryKeySelective(SkuShopCartVo record);
    
    int updateNoSalingProduct(ShopCartAuto record);
}