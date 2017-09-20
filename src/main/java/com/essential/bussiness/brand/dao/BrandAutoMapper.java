package com.essential.bussiness.brand.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.essential.bussiness.brand.model.auto.BrandAuto;
import com.essential.bussiness.brand.model.auto.BrandAutoExample;
import com.essential.bussiness.brand.model.vo.BrandCategoryVo;
import com.essential.bussiness.brand.model.vo.BrandVo;
import com.essential.bussiness.product.model.vo.Count;

public interface BrandAutoMapper {
    int countByExample(BrandAutoExample example);

    int deleteByExample(BrandAutoExample example);

    int deleteByPrimaryKey(Long brandId);

    int insert(BrandAuto record);

    int insertSelective(BrandAuto record);

    List<BrandAuto> selectByExample(BrandAutoExample example);

    BrandAuto selectByPrimaryKey(Long brandId);

    int updateByExampleSelective(@Param("record") BrandAuto record, @Param("example") BrandAutoExample example);

    int updateByExample(@Param("record") BrandAuto record, @Param("example") BrandAutoExample example);

    int updateByPrimaryKeySelective(BrandAuto record);

    int updateByPrimaryKey(BrandAuto record);
    
    List<BrandAuto> queryForListByCategoryId(BrandAuto bussinessBrandModel);
    
    List<BrandVo> queryBrandTotal(BrandVo brandVo);
    
    int queryBrandTotalCount(BrandVo brandVo);
    
    List<BrandCategoryVo> queryCategroyByBrandId(BrandVo record);
    
    List<BrandAuto> queryTotalAndHotForListByCategoryId(BrandAuto bussinessBrandModel);
    
    List<BrandAuto> queryAllBrand(BrandAuto record);
    
    // 店铺所销售的品牌
    List<BrandAuto> queryShopBrand(Map<String, Object> record);
    Count queryShopBrandCount(Map<String, Object> record);
}