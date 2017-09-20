package com.essential.management.version.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.management.version.dao.VersionAutoMapper;
import com.essential.management.version.model.auto.VersionAuto;
import com.essential.management.version.service.IVersionAutoService;
import com.essential.utils.CommonResponseUtils;

/**
 * 版本信息
 * 
 * @author czm
 *
 */
@Service
public class VersionAutoServiceImpl implements IVersionAutoService {
	private static Logger logger = LoggerFactory.getLogger(VersionAutoServiceImpl.class);

	@Autowired
	VersionAutoMapper versionAutoMapper;

	/**
	 * 查询版本信息
	 */
	@Override
	public Map<String, Object> queryVersion(VersionAuto versionAuto, Integer pageIndex, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (pageSize == null) {
				pageSize = 20;
			}
			if (pageIndex == null) {
				pageIndex = 1;
			} else {
				pageIndex = (pageIndex - 1) * pageSize;
			}
			Map<String, Object> inputMap = new HashMap<String, Object>();
			inputMap.put("pageIndex", pageIndex);
			inputMap.put("pageSize", pageSize);
			inputMap.put("isDelete", SUConstants.IS_NOT_DELETE);
			List<VersionAuto> versionAutoList = versionAutoMapper.queryByPrimaryKey(inputMap);
			map.putAll(CommonResponseUtils.successResponse(versionAutoList));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>版本信息查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * 添加版本信息
	 */
	@Override
	public Map<String, Object> addVersion(VersionAuto versionAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			versionAuto.setCreateTime(TmDateUtil.getTimeStamp());
			versionAuto.setIsDelete(SUConstants.IS_NOT_SELECT);
			int i = versionAutoMapper.insertSelective(versionAuto);
			if (i <= 0) {
				throw new Exception("版本信息添加失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("版本信息添加成功!"));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>版本信息添加失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * 更新版本信息
	 */
	@Override
	public Map<String, Object> updateVersion(VersionAuto versionAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			versionAuto.setModifyTime(TmDateUtil.getTimeStamp());
			int i = versionAutoMapper.updateByPrimaryKeySelective(versionAuto);
			if (i <= 0) {
				throw new Exception("版本信息更新失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("版本信息更新成功!"));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>版本信息更新失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * 删除版本信息
	 */
	@Override
	public Map<String, Object> deleteVersion(Long versionId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			VersionAuto versionAuto = new VersionAuto();
			versionAuto.setVersionId(versionId);
			versionAuto.setIsDelete(SUConstants.IS_DELETE);
			int i = versionAutoMapper.updateByPrimaryKeySelective(versionAuto);
			if (i <= 0) {
				throw new Exception("版本信息删除失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("版本信息删除成功!"));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>版本信息删除失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * 查询最新版本信息
	 */
	@Override
	public Map<String, Object> queryNewVersion() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			VersionAuto versionAuto = new VersionAuto();
			versionAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			versionAuto = versionAutoMapper.queryNewVersion(versionAuto);
			map.putAll(CommonResponseUtils.successResponse(versionAuto));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>最新版本信息查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
