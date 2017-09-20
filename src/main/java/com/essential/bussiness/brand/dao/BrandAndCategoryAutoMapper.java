package com.essential.bussiness.brand.dao;

import com.essential.bussiness.brand.model.auto.BrandAndCategoryAuto;
import com.essential.bussiness.brand.model.auto.BrandAndCategoryAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandAndCategoryAutoMapper {
    int countByExample(BrandAndCategoryAutoExample example);

    int deleteByExample(BrandAndCategoryAutoExample example);

    int deleteByPrimaryKey(Long brandandcategoryId);

    int insert(BrandAndCategoryAuto record);

    int insertSelective(BrandAndCategoryAuto record);

    List<BrandAndCategoryAuto> selectByExample(BrandAndCategoryAutoExample example);

    BrandAndCategoryAuto selectByPrimaryKey(Long brandandcategoryId);

    int updateByExampleSelective(@Param("record") BrandAndCategoryAuto record, @Param("example") BrandAndCategoryAutoExample example);

    int updateByExample(@Param("record") BrandAndCategoryAuto record, @Param("example") BrandAndCategoryAutoExample example);

    int updateByPrimaryKeySelective(BrandAndCategoryAuto record);

    int updateByPrimaryKey(BrandAndCategoryAuto record);
}