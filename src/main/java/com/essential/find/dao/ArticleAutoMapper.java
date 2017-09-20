package com.essential.find.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.essential.find.model.auto.ArticleAuto;
import com.essential.find.model.vo.ArticleSearchVo;
import com.essential.find.model.vo.ArticleVo;

public interface ArticleAutoMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(ArticleAuto record);

    int insertSelective(ArticleAuto record);

    ArticleAuto selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(ArticleAuto record);

    int updateByPrimaryKey(ArticleAuto record);
     //按分组查询
    List<ArticleVo> queryArticleList(ArticleAuto articalaAuto);
    //查询文章详情
    ArticleAuto queryArticleDetailById(ArticleAuto record);
    //专栏的搜索查询
    List<ArticleSearchVo> queryArticleSearchList(ArticleAuto articalaAuto);

	
	int queryTotleCount(ArticleAuto articleAuto);
	
	// 文章查询（富文本格式转换使用）
	List<ArticleAuto> queryArticalEditor();
}