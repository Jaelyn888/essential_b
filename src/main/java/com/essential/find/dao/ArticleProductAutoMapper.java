package com.essential.find.dao;

import java.util.List;
import com.essential.find.model.auto.ArticleAuto;
import com.essential.find.model.auto.ArticleProductAuto;

public interface ArticleProductAutoMapper {
    int deleteByPrimaryKey(Long articleproductId);

    int insert(ArticleProductAuto record);

    int insertSelective(ArticleProductAuto record);

    ArticleProductAuto selectByPrimaryKey(Long articleproductId);

    int updateByPrimaryKeySelective(ArticleProductAuto record);

    int updateByPrimaryKey(ArticleProductAuto record);

	List<ArticleProductAuto> queryRelationProductList(ArticleProductAuto articalAuto);

	int insertList(ArticleAuto articleAuto);
}