package com.essential.management.opinon.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.management.opinon.controller.OpinonAutoController;
import com.essential.management.opinon.dao.OpinonAutoMapper;
import com.essential.management.opinon.model.auto.OpinonAuto;
import com.essential.management.opinon.model.vo.CountVo;
import com.essential.management.opinon.model.vo.OpinonAutoVo;
import com.essential.management.opinon.model.vo.OpinonInfoVo;
import com.essential.management.opinon.service.IOpinonAutoService;
import com.essential.utils.CommonResponseUtils;

/**
 * 意见反馈
 * 
 * @author czm
 *
 */
@Service
public class OpinonAutoServiceImpl implements IOpinonAutoService {
	private static Logger logger = LoggerFactory.getLogger(OpinonAutoServiceImpl.class);

	@Autowired
	OpinonAutoMapper opinonAutoMapper;

	/**
	 * 查询意见列表
	 */
	@Override
	public Map<String, Object> queryOpinion(Integer pageIndex, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> inputMap = new HashMap<String, Object>();
		try {
			OpinonInfoVo opinonInfoVo = new OpinonInfoVo();
			if (pageSize == null) {
				pageSize = 20;
			}
			if (pageIndex == null) {
				pageIndex = 1;
			}
			Integer pageIndexs = (pageIndex - 1) * pageSize;
			
			inputMap.put("pageSize", pageSize);
			inputMap.put("pageIndex", pageIndexs);
			inputMap.put("isDelete", SUConstants.IS_NOT_DELETE);

			// 获取意见信息
			List<OpinonAutoVo> opinonList = opinonAutoMapper.queryByPrimaryKey(inputMap);
			// 获取查询总数
			CountVo pageCount = opinonAutoMapper.opinonCount();
			opinonInfoVo.setOpinonList(opinonList);
			opinonInfoVo.setPageCount(pageCount.getCount());
			map.putAll(CommonResponseUtils.successResponse(opinonInfoVo));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>查询意见信息失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * 增加意见
	 */
	@Override
	public Map<String, Object> addOpinion(OpinonAuto opinonAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			opinonAuto.setCreateTime(TmDateUtil.getTimeStamp());
			opinonAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			int i = opinonAutoMapper.insertSelective(opinonAuto);
			if (i <= 0) {
				throw new Exception("提交失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("提交成功!"));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>提交意见信息失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * 更新意见
	 */
	@Override
	public Map<String, Object> updateOpinion(OpinonAuto opinonAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			opinonAuto.setModifyTime(TmDateUtil.getTimeStamp());
			int i = opinonAutoMapper.updateByPrimaryKeySelective(opinonAuto);
			if (i <= 0) {
				throw new Exception("意见信息更新失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("意见信息更新成功!"));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>更新意见信息失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * 删除意见
	 */
	@Override
	public Map<String, Object> deleteOpinion(OpinonAuto opinonAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			opinonAuto.setIsDelete(SUConstants.IS_DELETE);
			int i = opinonAutoMapper.updateByPrimaryKeySelective(opinonAuto);
			if (i <= 0) {
				throw new Exception("删除意见信息失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("删除意见信息成功!"));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>删除意见信息失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
