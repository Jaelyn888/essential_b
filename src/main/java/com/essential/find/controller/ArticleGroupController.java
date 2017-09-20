/**
 * 
 */
package com.essential.find.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.common.constants.SUConstants;
import com.essential.common.utils.StringCommonUtils;
import com.essential.find.model.auto.ArticleGroupAuto;
import com.essential.find.service.IArticleGroupService;
import com.essential.find.service.impl.ArticleGroupServiceImpl;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.LogUtils;

/**
 * @author Jaelyn 文章分组  controller
 */
@Controller
@RequestMapping(value = "articleGroup")
public class ArticleGroupController {
	private  String TAG = ArticleGroupController.class.getSimpleName();
	@Autowired
	@Qualifier("articleGroupServiceImpl")
	private IArticleGroupService articleGroupServiceImpl;

	/**
	 * 
	 * 获取分组信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "queryGroupById")
	@ResponseBody
	public Map<String, Object> queryGroupById(ArticleGroupAuto findArticalGroupAuto) {
		try {
			return articleGroupServiceImpl.queryArticalGroupById(findArticalGroupAuto);

		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.debug("queryGroupById",e.toString());
			return CommonResponseUtils.failureResponse("分组不存在");
		}
	}

	/**
	 * 保存文章分组
	 * 
	 * @return
	 */
	@RequestMapping(value = "saveGroup")
	@ResponseBody
	public Map<String, Object> saveGroup(ArticleGroupAuto findArticalGroupAuto) {

		try {
			if(findArticalGroupAuto==null){
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			String atticleGroupName=findArticalGroupAuto.getGroupName();
			Long createUserId=findArticalGroupAuto.getCreateUserId();
			if(StringCommonUtils.isEmpty(atticleGroupName)||StringCommonUtils.isInvalidateId(createUserId)){
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			return articleGroupServiceImpl.saveArticalGroup(findArticalGroupAuto);

		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.debug("saveGroup",e.toString());
			return CommonResponseUtils.failureResponse("保存失败");
		}
	}

	/**
	 * 更新分组名称
	 * 
	 * @param groupName
	 *            分组名称
	 * @param ArticalGroupId
	 *            分组id
	 * @param modifyUserId
	 *            修改人id
	 * @return
	 */
	@RequestMapping(value = "updateGroup")
	@ResponseBody
	public Map<String, Object> updateGroup(ArticleGroupAuto findArticalGroupAuto) {
		try {
			if(findArticalGroupAuto==null){
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			String atticleGroupName=findArticalGroupAuto.getGroupName();
			Long createUserId=findArticalGroupAuto.getModifyUserId();
			Long groupId=findArticalGroupAuto.getArticleGroupId();
			if(StringCommonUtils.isEmpty(atticleGroupName)||StringCommonUtils.isInvalidateId(createUserId)||StringCommonUtils.isInvalidateId(groupId)){
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			return articleGroupServiceImpl.updateAritcalGroup(findArticalGroupAuto);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.debug("updateGroup",e.toString());
			return CommonResponseUtils.failureResponse( "更新失败");
		}

	}

	/**
	 * 逻辑删除文章分组
	 * 
	 * @return
	 */
	@RequestMapping(value = "deleteGroup")
	@ResponseBody
	public Map<String, Object> deleteGroup(ArticleGroupAuto findArticalGroupAuto) {
		try {
			return articleGroupServiceImpl.deleteAritcalGroup(findArticalGroupAuto);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.debug("deleteGroup",e.toString());
			return CommonResponseUtils.failureResponse( "删除失败");
		}

	}

	/**
	 * 查询所有数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "queryGroupList")
	@ResponseBody
	public Map<String, Object> queryGroupList() {
		try {
			return articleGroupServiceImpl.queryArticleGroupList();

		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.debug("queryGroupList",e.toString());
			return CommonResponseUtils.failureResponse();
		}
	}

}
