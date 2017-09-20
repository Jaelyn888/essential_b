package com.essential.management.system.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.management.system.controller.HelpAutoController;
import com.essential.management.system.dao.HelpAutoMapper;
import com.essential.management.system.model.auto.HelpAuto;
import com.essential.management.system.service.IHelpAutoService;
import com.essential.utils.CommonResponseUtils;

@Service
public class HelpAutoServiceImpl implements IHelpAutoService {
	private static Logger logger = LoggerFactory.getLogger(HelpAutoServiceImpl.class);

	@Autowired
	HelpAutoMapper helpAutoMapper;

	/**
	 * 添加帮助中心信息
	 */
	@Override
	public Map<String, Object> addHelp(HelpAuto helpAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 先删除以前信息
			HelpAuto help = new HelpAuto();
			help.setIsDelete(SUConstants.IS_NOT_DELETE);
			help.setModifyTime(TmDateUtil.getTimeStamp());
			help.setModifyUser(Long.valueOf(helpAuto.getCreateUser()));
			int j = helpAutoMapper.updateIsDeleteKey(help);
			if(j <= 0){
				throw new Exception("帮助中心信息添加失败");
			}
			// 再添加新的信息
			helpAuto.setCreateTime(TmDateUtil.getTimeStamp());
			helpAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			int i = helpAutoMapper.insertSelective(helpAuto);
			if(i <= 0){
				throw new Exception("帮助中心信息添加失败");
			}
			map.putAll(CommonResponseUtils.successResponse("帮助中心信息添加成功!"));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>>>帮助中心信息添加失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * 更新帮助中心信息
	 */
	@Override
	public Map<String, Object> updateHelp(HelpAuto helpAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			helpAuto.setModifyTime(TmDateUtil.getTimeStamp());
			int i = helpAutoMapper.updateByPrimaryKeySelective(helpAuto);
			if(i <= 0){
				throw new Exception("帮助中心信息更新失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("帮助中心信息更新成功!"));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>>>帮助中心信息更新失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * 查询帮助中心信息
	 */
	@Override
	public Map<String, Object> queryHelp(HelpAuto helpAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			helpAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			HelpAuto helpInfo = helpAutoMapper.queryByPrimaryKey(helpAuto);
			map.putAll(CommonResponseUtils.successResponse(helpInfo));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>>>帮助中心信息查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * 删除帮助中心信息
	 */
	@Override
	public Map<String, Object> deleteHelp(Long helpId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			HelpAuto helpAuto = new HelpAuto();
			helpAuto.setHelpId(helpId);
			helpAuto.setIsDelete(SUConstants.IS_DELETE);
			int i = helpAutoMapper.updateByPrimaryKeySelective(helpAuto);
			if(i <= 0){
				throw new Exception("帮助中心信息删除失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("帮助中心信息删除成功!"));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>>>帮助中心信息删除失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
