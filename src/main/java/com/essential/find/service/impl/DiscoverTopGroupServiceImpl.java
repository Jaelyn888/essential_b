/**
 * 
 */
package com.essential.find.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.essential.find.dao.ArticleGroupAutoMapper;
import com.essential.find.dao.SpecialAutoMapper;
import com.essential.find.dao.SpecialGroupAutoMapper;
import com.essential.find.model.auto.ArticleCommentsAuto;
import com.essential.find.model.auto.ArticleGroupAuto;
import com.essential.find.model.auto.SpecialGroupAuto;
import com.essential.find.model.vo.ArticleGroupVo;
import com.essential.find.model.vo.SpecialGroupVo;
import com.essential.find.service.IArticleGroupService;
import com.essential.find.service.IArticleService;
import com.essential.find.service.IDiscoverTopGroupService;
import com.essential.find.service.ISpecialGroupService;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * @author Jaelyn
 * 发现页顶部分组
 */

@Service
public class DiscoverTopGroupServiceImpl implements IDiscoverTopGroupService {

	@Autowired
	@Qualifier("articleGroupServiceImpl")
	private IArticleGroupService articleGroupServiceImpl;
	@Autowired
	@Qualifier("specialGroupServiceImpl")
	private ISpecialGroupService specialGroupServiceImpl;
	

	/* (non-Javadoc)
	 * @see com.essential.find.service.impl.IFindTopGroupService#queryFindTopGroup()
	 */
	@Override
	public Map<String, Object> queryFindTopGroup() {
		try {
			Map<String, Object> mapData = new HashMap<String, Object>();
			List<ArticleGroupVo> articleGroupVoList = articleGroupServiceImpl.queryArticleGroupVoList();
			mapData.put("articleGroup",articleGroupVoList);
			List<SpecialGroupVo>specialGroupData = specialGroupServiceImpl.querySpecialGroupVoList();
			mapData.put("specialGroup", specialGroupData);
			return CommonResponseUtils.successResponse(mapData);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	
	}

}
