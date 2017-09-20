package com.essential.bussiness.product.dao;

import com.essential.bussiness.product.model.auto.ProductCategoryAuto;
import com.essential.bussiness.product.model.auto.ProductCategoryAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductCategoryAutoMapper {
    int countByExample(ProductCategoryAutoExample example);

    int deleteByExample(ProductCategoryAutoExample example);

    int deleteByPrimaryKey(Long categoryId);

    int insert(ProductCategoryAuto record);

    int insertSelective(ProductCategoryAuto record);

    List<ProductCategoryAuto> selectByExample(ProductCategoryAutoExample example);

    ProductCategoryAuto selectByPrimaryKey(Long categoryId);

    int updateByExampleSelective(@Param("record") ProductCategoryAuto record, @Param("example") ProductCategoryAutoExample example);

    int updateByExample(@Param("record") ProductCategoryAuto record, @Param("example") ProductCategoryAutoExample example);

    int updateByPrimaryKeySelective(ProductCategoryAuto record);

    int updateByPrimaryKey(ProductCategoryAuto record);
    
    List<ProductCategoryAuto> queryForList(ProductCategoryAuto record);
    int updatePic(ProductCategoryAuto record);
    
}