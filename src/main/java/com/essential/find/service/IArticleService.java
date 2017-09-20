package com.essential.find.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.product.model.auto.LinkProductAuto;
import com.essential.find.model.auto.ArticleAuto;
import com.essential.find.model.vo.RequestDetailVo;

@Service
public interface IArticleService {

	// 查询
	public Map<String, Object> queryArticleList(ArticleAuto articleAuto);

	public Map<String, Object> queryArticleDetail(RequestDetailVo requestDetailVo);

	// 保存
	public Map<String, Object> addArticle(ArticleAuto articleAuto);

	// 更新
	public Map<String, Object> updateArticle(ArticleAuto articleAuto);

	// 删除
	public Map<String, Object> deleteArticle(ArticleAuto articalaAuto);

	// 查询
	public Map<String, Object> queryArticleById(Long articalAutoId);

	// 搜索查询
	public Map<String, Object> queryArticleSearchList(ArticleAuto articleAuto);

	public Map<String, Object> queryRelationProductList(Long articaleId);

	/**
	 * 查询文章内容
	 * @param articleId
	 * @return
	 */
	public Map<String, Object> queryArticleContent(ArticleAuto articalAuto);

	/**
	 * web  分页查询文章
	 * @param articleAuto
	 * @return
	 */
	public Map<String, Object> queryArticleListByPage(ArticleAuto articleAuto);

	public Map<String, Object> updateArticleProductOrUser(ArticleAuto articleAuto);

	/**
	 * 品台查询 编辑文章
	 * @param articleAuto
	 * @return
	 */
	public Map<String, Object> queryArticleDetailAndRelationInfoById(ArticleAuto articleAuto);


}
