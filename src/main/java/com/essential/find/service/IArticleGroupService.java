package com.essential.find.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.find.model.auto.ArticleGroupAuto;
import com.essential.find.model.vo.ArticleGroupVo;
@Service
public interface IArticleGroupService {

	/**
	 * all group
	 * 
	 * @return
	 */
	public abstract Map<String, Object> queryArticleGroupList();

	/**
	 * save group
	 * 
	 * @return
	 */
	public abstract Map<String, Object> saveArticalGroup(ArticleGroupAuto findArticalGroupAuto);

	/**
	 * update
	 * 
	 * @return
	 */
	public abstract Map<String, Object> updateAritcalGroup(ArticleGroupAuto findArticalGroupAuto);

	/**
	 * delete
	 * 
	 * @return
	 */
	public abstract Map<String, Object> deleteAritcalGroup(ArticleGroupAuto findArticalGroupAuto);

	/**
	 * query by id
	 * 
	 * @param articleGroupId
	 * @return
	 */
	public abstract Map<String, Object> queryArticalGroupById(ArticleGroupAuto findArticalGroupAuto);

	public abstract List<ArticleGroupVo> queryArticleGroupVoList();

}