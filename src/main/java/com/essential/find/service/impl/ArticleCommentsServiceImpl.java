/**
 * 
 */
package com.essential.find.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.model.vo.ProductCommentVo;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.StringCommonUtils;
import com.essential.common.utils.TmDateUtil;
import com.essential.find.dao.ArticleCommentsAutoMapper;
import com.essential.find.model.auto.ArticleCommentsAuto;
import com.essential.find.model.vo.ArticleCommentVo;
import com.essential.find.service.IArticleCommentsService;
import com.essential.user.dao.UserBaseInfoAutoMapper;
import com.essential.user.model.auto.UserBaseInfoAuto;
import com.essential.user.model.vo.UserBaseInfoVo;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * @author Jaelyn 文章评论
 */
@Service
public class ArticleCommentsServiceImpl implements IArticleCommentsService {

	/**
	 * 文章评论表 mapper
	 */
	@Autowired
	private ArticleCommentsAutoMapper articleCommentsAutoMapper;

	@Autowired
	private UserBaseInfoAutoMapper userBaseInfoMapper;

	/* (non-Javadoc)
	 * @see com.essential.find.service.impl.ArticleCommentsService#queryCommentsByArticleId(java.util.Map)
	 */
	@Override
	public Map<String, Object> queryCommentsByArticleId(ArticleCommentsAuto articleCommentsAuto) {
		try {
			// 请求评论表
			List<ArticleCommentVo> commentsAutoList = articleCommentsAutoMapper.queryCommentsByArticleId(articleCommentsAuto);
			// 循环集合 查找用户信息
//			for (int i = 0; i < commentsAutoList.size(); i++) {
//				// 评论信息
//				ArticleCommentsAuto articleCommentsAutoTmp = commentsAutoList.get(i);
//				ArticleCommentVo commentTmp = queryCommentVo(articleCommentsAutoTmp);
//				if (commentTmp != null) {
//					commentsList.add(commentTmp);
//				}
//			}

			return CommonResponseUtils.successResponse(commentsAutoList);

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}

	/* (non-Javadoc)
	 * @see com.essential.find.service.impl.ArticleCommentsService#saveComments(com.essential.find.model.auto.articleCommentsAuto)
	 */
	@Override
	public Map<String, Object> saveComments(ArticleCommentsAuto ArticleCommentsAuto) {
		try {
			ArticleCommentsAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			ArticleCommentsAuto.setCreateTime(TmDateUtil.getTimeStamp());
			ArticleCommentsAuto.setModifyTime(TmDateUtil.getTimeStamp());
			ArticleCommentsAuto.setModifyUserId(ArticleCommentsAuto.getCreateUserId());
			int num = articleCommentsAutoMapper.insertSelective(ArticleCommentsAuto);

			if (num > 0) {
				return CommonResponseUtils.successResponse("保存成功", null);
			} else {
				return CommonResponseUtils.failureResponse("保存失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}

	/* (non-Javadoc)
	 * @see com.essential.find.service.impl.ArticleCommentsService#updateComments(com.essential.find.model.auto.articleCommentsAuto)
	 */
	@Override
	public Map<String, Object> updateComments(ArticleCommentsAuto ArticleCommentsAuto) {
		try {
			ArticleCommentsAuto.setModifyTime(TmDateUtil.getTimeStamp());
			int num = articleCommentsAutoMapper.updateByPrimaryKeySelective(ArticleCommentsAuto);
			if (num > 0) {
				return CommonResponseUtils.successResponse("更新成功", null);
			} else {
				return CommonResponseUtils.failureResponse();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}

	/* (non-Javadoc)
	 * @see com.essential.find.service.impl.ArticleCommentsService#deleteComments(com.essential.find.model.auto.articleCommentsAuto)
	 */
	@Override
	public Map<String, Object> deleteComments(ArticleCommentsAuto ArticleCommentsAuto) {

		try {
			ArticleCommentsAuto.setModifyTime(TmDateUtil.getTimeStamp());
			ArticleCommentsAuto.setIsDelete(SUConstants.IS_DELETE);
			int num = articleCommentsAutoMapper.updateByPrimaryKeySelective(ArticleCommentsAuto);
			if (num > 0) {
				return CommonResponseUtils.successResponse("删除成功", null);
			} else {
				return CommonResponseUtils.failureResponse("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}

	/* (non-Javadoc)
	 * @see com.essential.find.service.impl.ArticleCommentsService#queryCommentsById(long)
	 */
	@Override
	public Map<String, Object> queryCommentsById(long commentId) {
		try {
			ArticleCommentsAuto commentAuto = articleCommentsAutoMapper.selectByPrimaryKey(commentId);
			ArticleCommentVo articleCommentVo=queryCommentVo(commentAuto);
			if (commentAuto != null) {
				return CommonResponseUtils.successResponse(articleCommentVo);
			} else {
				return CommonResponseUtils.failureResponse();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}

	/**
	 * 根据 评论实体 查找vo 出现异常返回空
	 * 
	 * @param articleCommentsAuto
	 * @return
	 */
	private ArticleCommentVo queryCommentVo(ArticleCommentsAuto articleCommentsAuto) {

		try {
			ArticleCommentVo commentTmp = new ArticleCommentVo();
			DTOUtils.map(articleCommentsAuto, commentTmp);
			// 评论人信息
			long createUserId = articleCommentsAuto.getCreateUserId();
			UserBaseInfoVo createUserBaseInfo = userBaseInfoMapper.selectBaseInfoVoByPrimaryKey(createUserId);
			DTOUtils.map(createUserBaseInfo, commentTmp);
			// 回复人信息
			if (articleCommentsAuto.getToUserId() != null) {
				long toUserId = articleCommentsAuto.getToUserId();
				UserBaseInfoVo toUserBaseInfo = userBaseInfoMapper.selectBaseInfoVoByPrimaryKey(toUserId);
				commentTmp.setToUserNickname(toUserBaseInfo.getUserNickname());
			}
			return commentTmp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Map<String, Object> queryCommentListByPage(ArticleCommentsAuto articleCommentsAuto) {
		try {
			Map<String, Object> resultMap = new HashMap<String, Object>();
			articleCommentsAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			long totleCount = articleCommentsAutoMapper.queryCommentCount(articleCommentsAuto);
			resultMap.put("totalPageCount", totleCount);
			if (totleCount > 0) {
				int pageIndex = articleCommentsAuto.getPageIndex();
				articleCommentsAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
				articleCommentsAuto.setPageIndex((pageIndex - 1) * SUConstants.PAGE_COUNT);
				articleCommentsAuto.setPageSize(SUConstants.PAGE_COUNT);
				List<ArticleCommentVo> commentVoList = articleCommentsAutoMapper.queryCommentsByArticleId(articleCommentsAuto);
				resultMap.put("contentList", commentVoList);
			}
			return CommonResponseUtils.successResponse(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}
}
