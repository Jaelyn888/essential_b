/**
 * 
 */
package com.essential.find.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.TmDateUtil;
import com.essential.find.dao.ArticleGroupAutoMapper;
import com.essential.find.model.auto.ArticleGroupAuto;
import com.essential.find.model.vo.ArticleGroupVo;
import com.essential.find.service.IArticleGroupService;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;
import com.essential.utils.LogUtils;

/**
 * @author Jaelyn 文章分组 service
 */

@Service
public class ArticleGroupServiceImpl implements IArticleGroupService {
	/**
	 * log日志
	 */
	private String TAG=ArticleCommentsServiceImpl.class.getSimpleName();

	@Autowired
	private ArticleGroupAutoMapper findArticalGroupAutoMapper;

	/* (non-Javadoc)
	 * @see com.essential.find.service.impl.IArticalGroupService#queryArticalGroupList()
	 */
	@Override
	public Map<String, Object> queryArticleGroupList() {
		try {
			List<ArticleGroupVo> articalGroupVoList = queryArticleGroupVoList();
			return CommonResponseUtils.successResponse(articalGroupVoList);

		} catch (Exception e) {
			LogUtils.debug("queryArticleGroupList", e.getCause());
			return CommonResponseUtils.failureResponse();
		}

	}

	/* (non-Javadoc)
	 * @see com.essential.find.service.impl.IArticalGroupService#saveArticalGroup(com.essential.find.model.auto.FindArticalGroupAuto)
	 */
	@Override
	public Map<String, Object> saveArticalGroup(ArticleGroupAuto findArticalGroupAuto) {

		try {
			String timeStamp=TmDateUtil.getTimeStamp();
			findArticalGroupAuto.setCreateTime(timeStamp);
			findArticalGroupAuto.setModifyTime(timeStamp);
			findArticalGroupAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			findArticalGroupAuto.setModifyUserId(findArticalGroupAuto.getCreateUserId());
			int num = findArticalGroupAutoMapper.insertSelective(findArticalGroupAuto);
			if (num > 0) {
				return CommonResponseUtils.successResponse("保存成功", null);
			} else {
				throw new MyException();
			}
		} catch (Exception e) {
			LogUtils.debug("selectArticalGroupList", e.getCause());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse("保存失败");
		}

	}

	/* (non-Javadoc)
	 * @see com.essential.find.service.impl.IArticalGroupService#updateAritcalGroup(com.essential.find.model.auto.FindArticalGroupAuto)
	 */
	@Override
	public Map<String, Object> updateAritcalGroup(ArticleGroupAuto findArticalGroupAuto) {
		try {
			String timeStamp=TmDateUtil.getTimeStamp();
			findArticalGroupAuto.setModifyTime(timeStamp);
			int num = findArticalGroupAutoMapper.updateByPrimaryKeySelective(findArticalGroupAuto);

			if (num > 0) {
				return CommonResponseUtils.failureResponse("更新成功");
			} else {
				throw new MyException();
			}

		} catch (Exception e) {
			LogUtils.debug("updateAritcalGroup", e.getCause());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse("更新失败");
		}
	}

	/* (non-Javadoc)
	 * @see com.essential.find.service.impl.IArticalGroupService#deleteAritcalGroup(com.essential.find.model.auto.FindArticalGroupAuto)
	 */
	@Override
	public Map<String, Object> deleteAritcalGroup(ArticleGroupAuto findArticalGroupAuto) {
		try {
			findArticalGroupAuto.setModifyTime(TmDateUtil.getTimeStamp());
			findArticalGroupAuto.setIsDelete(SUConstants.IS_DELETE);
			int num = findArticalGroupAutoMapper.updateByPrimaryKeySelective(findArticalGroupAuto);
			if (num > 0) {
				return CommonResponseUtils.successResponse("删除成功",null);
			} else {
				throw new MyException();
			}
		} catch (Exception e) {
			LogUtils.debug("deleteAritcalGroup", e.getCause());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse("删除失败");
		}
	}

	/* (non-Javadoc)
	 * @see com.essential.find.service.impl.IArticalGroupService#queryArticalGroupById(com.essential.find.model.auto.FindArticalGroupAuto)
	 */
	@Override
	public Map<String, Object> queryArticalGroupById(ArticleGroupAuto findArticalGroupAuto) {

		try {
			findArticalGroupAuto = findArticalGroupAutoMapper.selectByPrimaryKey(findArticalGroupAuto.getArticleGroupId());
			if (findArticalGroupAuto != null) {
				return CommonResponseUtils.successResponse(findArticalGroupAuto);
			} else {
				return CommonResponseUtils.failureResponse("分组不存在");
			}

		} catch (Exception e) {
			LogUtils.debug("queryArticalGroupById", e.getCause());
			return CommonResponseUtils.failureResponse("分组不存在");
		}

	}

	/**
	 * 查询分类vo
	 */
	@Override
	public List<ArticleGroupVo> queryArticleGroupVoList() {
		try {
			ArticleGroupAuto articalGroupAuto=new ArticleGroupAuto();
			articalGroupAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<ArticleGroupAuto> articalGroupAutoList = findArticalGroupAutoMapper.queryArticleGroupList(articalGroupAuto);
			List<ArticleGroupVo> articalGroupVoList = DTOUtils.map(articalGroupAutoList, ArticleGroupVo.class);
			return articalGroupVoList;

		} catch (Exception e) {
			LogUtils.debug("queryArticleGroupVoList", e.getCause());
			return new ArrayList<ArticleGroupVo>();
		}
	}

}
