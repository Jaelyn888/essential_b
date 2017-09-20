package com.essential.find.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.common.constants.SUConstants;
import com.essential.common.utils.StringCommonUtils;
import com.essential.common.utils.TmDateUtil;
import com.essential.find.model.auto.ArticleAuto;
import com.essential.find.model.auto.ArticleProductAuto;
import com.essential.find.model.vo.RequestDetailVo;
import com.essential.find.service.IArticleService;
import com.essential.utils.CommonResponseUtils;

/**
 * 文章（按组别查询）
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "article")
public class ArticleController {

	@Autowired
	@Qualifier("articleServiceImpl")
	IArticleService articleServiceImpl;

	/**
	 * 文章按组别进行查询
	 * 
	 * @param addArticleAutoGroupId
	 * @return
	 */
	@RequestMapping(value = "queryArticleList")
	@ResponseBody
	public Map<String, Object> queryArticleList(ArticleAuto articleAuto) {

		return articleServiceImpl.queryArticleList(articleAuto);
	}

	/**
	 * app端查看文章详情
	 * 
	 * @param articleId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "queryArticleDetail")
	@ResponseBody
	public Map<String, Object> queryArticleDetail(RequestDetailVo requestDetailVo) {

		return articleServiceImpl.queryArticleDetail(requestDetailVo);

	}

	/**
	 * app 查看相关商品
	 * 
	 * @param articleId
	 * @return
	 */
	@RequestMapping(value = "queryRelationProductList")
	@ResponseBody
	public Map<String, Object> queryRelationProductList(Long articleId) {
		if (StringCommonUtils.isInvalidateId(articleId)) {
			return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
		} else {
			return articleServiceImpl.queryRelationProductList(articleId);
		}

	}

	/**
	 * 文章保存
	 * 
	 * @param addArticleAuto
	 * @return
	 */
	@RequestMapping(value = "addArticle")
	@ResponseBody
	public Map<String, Object> addArticle(ArticleAuto articleAuto) {
		try {
			if (articleAuto == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			Long createUserId = articleAuto.getCreateUserId();
			if (StringCommonUtils.isInvalidateId(createUserId)) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			String timeStamp = TmDateUtil.getTimeStamp();
			// 保存文章 的数据封装
			articleAuto.setCreateTime(timeStamp);
			articleAuto.setModifyTime(timeStamp);
			articleAuto.setModifyUserId(createUserId);
			articleAuto.setSendTime(timeStamp);
			articleAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			articleAuto.setReadcount(0L);

			return articleServiceImpl.addArticle(articleAuto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}

	}
	
	/**
	 * 查询文章内容
	 * 
	 * @param addArticleAuto
	 * @return
	 */
	@RequestMapping(value = "queryArticleContent")
	@ResponseBody
	public Map<String, Object> queryArticleContent(ArticleAuto articleAuto) {
		try {
			if (articleAuto == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			Long articleId=articleAuto.getArticleId();
			if (StringCommonUtils.isInvalidateId(articleId)) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}			
			articleAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			return articleServiceImpl.queryArticleContent(articleAuto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}

	}

	/**
	 * 文章修改 基本信息
	 * 
	 * @param addArticleAuto
	 * @return
	 */
	@RequestMapping(value = "updateArticle")
	@ResponseBody
	public Map<String, Object> updateArticle(ArticleAuto articleAuto) {
		try {
			if (articleAuto == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			Long articleId=articleAuto.getArticleId();
			if (StringCommonUtils.isInvalidateId(articleId)) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			String timeStamp = TmDateUtil.getTimeStamp();
			articleAuto.setModifyTime(timeStamp);
			//articleAuto.setModifyUserId(articleAuto.getCreateUserId());
			//articleAuto.setSendTime(TmDateUtil.getTimeStamp());

			return articleServiceImpl.updateArticle(articleAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	}

	/**
	 * 更新相关人或相关商品
	 * @param articleAuto
	 * @return
	 */
	@RequestMapping(value = "updateArticleProductOrUser")
	@ResponseBody
	public Map<String, Object> updateArticleProductOrUser( ArticleAuto articleAuto) {
		try {
			if (articleAuto == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			Long articleId=articleAuto.getArticleId();
			if (StringCommonUtils.isInvalidateId(articleId)) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			String timeStamp = TmDateUtil.getTimeStamp();
			articleAuto.setModifyTime(timeStamp);
			//articleAuto.setModifyUserId(articleAuto.getCreateUserId());
			//articleAuto.setSendTime(TmDateUtil.getTimeStamp());

			return articleServiceImpl.updateArticleProductOrUser(articleAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	}
	/**
	 * 文章删除
	 * 
	 * @param addArticleAutoId
	 * @return
	 */
	@RequestMapping(value = "deleteArticle")
	@ResponseBody
	public Map<String, Object> deleteArticle(ArticleAuto articleAuto) {

		try {
			if (articleAuto == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			Long articleId=articleAuto.getArticleId();
			if(StringCommonUtils.isInvalidateId(articleId)){
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			return articleServiceImpl.deleteArticle(articleAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	}

	/**
	 * 文章查询
	 * 
	 * @param addArticleeId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "queryArticleById")
	@ResponseBody
	public Map<String, Object> queryArticleById(Long articleId) {

		try {
			if (StringCommonUtils.isInvalidateId(articleId)) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			return articleServiceImpl.queryArticleById(articleId);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	}

	
	/**
	 * 平台编辑文章  查询文章详情
	 * 
	 * @param addArticleeId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "queryArticleDetailAndRelationInfoById")
	@ResponseBody
	public Map<String, Object> queryArticleDetailAndRelationInfoById(ArticleAuto articleAuto) {

		try {
			if (StringCommonUtils.isInvalidateId(articleAuto.getArticleId())) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			return articleServiceImpl.queryArticleDetailAndRelationInfoById(articleAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	}

	
	
	
	/**
	 * app 检索查询
	 * 
	 * @param queryParameter
	 * @return
	 */
	@RequestMapping(value = "queryArticleSearchList")
	@ResponseBody
	public Map<String, Object> queryArticleSearchList(@RequestBody ArticleAuto articleAuto) {
		try {
			if (articleAuto == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			articleAuto.setPageSize(SUConstants.PAGE_COUNT);
			articleAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			return articleServiceImpl.queryArticleSearchList(articleAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	}

	/**
	 * 平台 检索查询
	 * 
	 * @param queryParameter
	 * @return
	 */
	@RequestMapping(value = "queryArticleListByPage")
	@ResponseBody
	public Map<String, Object> queryArticleListByPage(ArticleAuto articleAuto) {
		try {
			if (articleAuto == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			Integer pageIndex = articleAuto.getPageIndex();
			if (pageIndex == null || pageIndex < 1) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			return articleServiceImpl.queryArticleListByPage(articleAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	}

	

	
}
