package com.essential.bussiness.product.dao;

import com.essential.bussiness.product.model.auto.ProductTypeAuto;
import com.essential.bussiness.product.model.auto.ProductTypeAutoExample;
import com.essential.bussiness.product.model.vo.CategoryTypeListVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProductTypeAutoMapper {
    int countByExample(ProductTypeAutoExample example);

    int deleteByExample(ProductTypeAutoExample example);

    int deleteByPrimaryKey(Long productTypeId);

    int insert(ProductTypeAuto record);

    int insertSelective(ProductTypeAuto record);

    List<ProductTypeAuto> selectByExample(ProductTypeAutoExample example);

    ProductTypeAuto selectByPrimaryKey(Long productTypeId);

    int updateByExampleSelective(@Param("record") ProductTypeAuto record, @Param("example") ProductTypeAutoExample example);

    int updateByExample(@Param("record") ProductTypeAuto record, @Param("example") ProductTypeAutoExample example);

    int updateByPrimaryKeySelective(ProductTypeAuto record);

    int updateByPrimaryKey(ProductTypeAuto record);
    
    List<ProductTypeAuto> queryForList(ProductTypeAuto record);
    //查询大分类和小分类的列表
    List<CategoryTypeListVo> selectCategoryProductTypeList();
}