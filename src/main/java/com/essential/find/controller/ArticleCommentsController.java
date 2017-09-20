/**
 * 
 */
package com.essential.find.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.product.model.auto.ProductCommentAuto;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.StringCommonUtils;
import com.essential.find.model.auto.ArticleCommentsAuto;
import com.essential.find.service.IArticleCommentsService;
import com.essential.user.service.IUserInfoService;
import com.essential.utils.CommonResponseUtils;

/**
 * @author Jaelyn 文章 controller
 */
@Controller
@RequestMapping(value = "articleComments")
public class ArticleCommentsController {

	/**
	 * 文章评论service
	 */
	@Autowired
	@Qualifier("articleCommentsServiceImpl")
	private IArticleCommentsService articleCommentsService;

	/**
	 * 查询用户信息
	 */
	@Autowired
	private IUserInfoService userInfoService;

	/**
	 * 获取文章评论
	 * 
	 * @param articleId
	 *            文章id
	 * @param sendTime
	 *            时间戳
	 * @param requestType
	 *            请求方式 0：第一次请求 1：刷新 2：加载更多
	 * @return
	 */
	@RequestMapping(value = "queryCommentsByArticleId")
	@ResponseBody
	public Map<String, Object> queryCommentsByArticleId(ArticleCommentsAuto articleCommentsAuto) {
		try {
			if (articleCommentsAuto == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			Long articleId = articleCommentsAuto.getArticleId();
			if (StringCommonUtils.isInvalidateId(articleId)) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			articleCommentsAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			articleCommentsAuto.setPageSize(SUConstants.PAGE_COUNT);
			return articleCommentsService.queryCommentsByArticleId(articleCommentsAuto);

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
		}

	}

	/**
	 * 获取文章评论
	 * 
	 * @param articleId
	 *            文章id
	 * @param sendTime
	 *            时间戳
	 * @param requestType
	 *            请求方式 0：第一次请求 1：刷新 2：加载更多
	 * @return
	 */
	/**
	 * web 分页查询评论列表
	 * 
	 * @param requestMap
	 * @return
	 */
	@RequestMapping(value = "queryCommentListByPage")
	@ResponseBody
	public Map<String, Object> queryCommentListByPage(@RequestBody ArticleCommentsAuto articleCommentsAuto) {
		try {
			if (articleCommentsAuto == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			Long articleId = articleCommentsAuto.getArticleId();
			if (StringCommonUtils.isInvalidateId(articleId)) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			articleCommentsAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			articleCommentsAuto.setPageSize(SUConstants.PAGE_COUNT);
			return articleCommentsService.queryCommentListByPage(articleCommentsAuto);

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}

	/**
	 * 保存评论
	 * 
	 * @return
	 */
	@RequestMapping(value = "saveComment")
	@ResponseBody
	public Map<String, Object> saveComment(ArticleCommentsAuto articleCommentsAuto) {
		try {
			if (articleCommentsAuto == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			Long articleId = articleCommentsAuto.getArticleId();
			if (StringCommonUtils.isInvalidateId(articleId)) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			articleCommentsAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			return articleCommentsService.saveComments(articleCommentsAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("保存失败");

		}
	}

	/**
	 * 更新评论
	 * 
	 * @param groupName
	 *            分组名称
	 * @param articleGroupId
	 *            分组id
	 * @param modifyUserId
	 *            修改人id
	 * @return
	 */
	@RequestMapping(value = "updateComments")
	@ResponseBody
	public Map<String, Object> updateGroup(ArticleCommentsAuto articleCommentsAuto) {
		try {
			return articleCommentsService.updateComments(articleCommentsAuto);

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("更新失败");
		}

	}

	/**
	 * 删除评论
	 * 
	 * @return
	 */
	@RequestMapping(value = "deleteComments")
	@ResponseBody
	public Map<String, Object> deleteComments(ArticleCommentsAuto articleCommentsAuto) {
		try {
			return articleCommentsService.deleteComments(articleCommentsAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("删除失败");
		}

	}

}
