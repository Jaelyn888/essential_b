package com.essential.find.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.find.model.auto.ArticleCommentsAuto;
@Service
public interface IArticleCommentsService {

	/**
	 * all Artical Comment by articalId
	 * 
	 * @param articalId
	 *            文章id
	 * @return
	 */
	public abstract Map<String, Object> queryCommentsByArticleId(ArticleCommentsAuto articleCommentsAuto);

	/**
	 * save articalCommentsAuto
	 * 
	 * @param articalCommentsAuto
	 *            保存评论信息
	 * @return
	 */
	public abstract Map<String, Object> saveComments(ArticleCommentsAuto articalCommentsAuto);

	/**
	 * update articalCommentsAuto
	 * 
	 * @param articalCommentsAuto
	 *            更新后的评论信息
	 * @return
	 */
	public abstract Map<String, Object> updateComments(ArticleCommentsAuto articalCommentsAuto);

	/**
	 * delete articalCommentsAuto
	 * 
	 * @param articalCommentsAuto
	 *            更新后的评论信息
	 * @return
	 */
	public abstract Map<String, Object> deleteComments(ArticleCommentsAuto articalCommentsAuto);

	/**
	 * select by comment id
	 * 
	 * @param articleGroupId
	 * @return
	 */
	public abstract Map<String, Object> queryCommentsById(long commentId);

	public abstract Map<String, Object> queryCommentListByPage(ArticleCommentsAuto articleCommentsAuto);

}