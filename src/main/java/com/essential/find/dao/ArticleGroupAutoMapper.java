package com.essential.find.dao;

import java.util.List;

import com.essential.find.model.auto.ArticleGroupAuto;

public interface ArticleGroupAutoMapper {
    int deleteByPrimaryKey(Long articleGroupId);

    int insert(ArticleGroupAuto record);

    int insertSelective(ArticleGroupAuto record);

    ArticleGroupAuto selectByPrimaryKey(Long articleGroupId);

    int updateByPrimaryKeySelective(ArticleGroupAuto record);

    int updateByPrimaryKey(ArticleGroupAuto record);
    
	/**
	 * 返回 所有分组
	 * @param articalGroupAuto 
	 * 
	 * @return
	 */
	List<ArticleGroupAuto> queryArticleGroupList(ArticleGroupAuto articalGroupAuto);
    
}