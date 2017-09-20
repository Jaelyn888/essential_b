package com.essential.find.dao;

import java.util.List;
import java.util.Map;

import com.essential.find.model.auto.ArticleCommentsAuto;
import com.essential.find.model.auto.ArticleGroupAuto;
import com.essential.find.model.vo.ArticleCommentVo;

public interface ArticleCommentsAutoMapper {
    int deleteByPrimaryKey(Long commentId);

    int insert(ArticleCommentsAuto record);

    int insertSelective(ArticleCommentsAuto record);

    ArticleCommentsAuto selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(ArticleCommentsAuto record);

    int updateByPrimaryKey(ArticleCommentsAuto record);
    
	/**
	 * 查找评论信息
	 * @param articleCommentsAuto
	 * @return
	 */
	List<ArticleCommentVo> queryCommentsByArticleId(ArticleCommentsAuto articleCommentsAuto);

	/**
	 * 查询所有数量
	 * @param articleCommentsAuto
	 * @return
	 */
	long queryCommentCount(ArticleCommentsAuto articleCommentsAuto);
}