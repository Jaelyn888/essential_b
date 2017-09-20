package com.essential.management.system.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.StringCommonUtils;
import com.essential.common.utils.TmDateUtil;
import com.essential.management.system.dao.AboutAutoMapper;
import com.essential.management.system.model.auto.AboutAuto;
import com.essential.management.system.service.IAboutAutoService;
import com.essential.utils.CommonResponseUtils;

/**
 * 关于我们
 * 
 * @author czm
 *
 */
@Service
public class AboutAutoServiceImpl implements IAboutAutoService {
	private static Logger logger = LoggerFactory.getLogger(AboutAutoServiceImpl.class);

	@Autowired
	AboutAutoMapper aboutAutoMapper;

	@Override
	public Map<String, Object> saveOrUpdateAbout(AboutAuto aboutAuto) {
		Long aboutId=aboutAuto.getAboutId();
		if(StringCommonUtils.isInvalidateId(aboutId)){
			aboutAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			aboutAuto.setCreateTime(TmDateUtil.getTimeStamp());
			int i = aboutAutoMapper.insertSelective(aboutAuto);
			if (i <= 0) {
				throw new MyException("保存失败!");
			}
			return CommonResponseUtils.successResponse("保存成功!");
		}else {
			aboutAuto.setModifyTime(TmDateUtil.getTimeStamp());
			int i = aboutAutoMapper.updateByPrimaryKeySelective(aboutAuto);
			if (i <= 0) {
				throw new MyException("保存失败!");
			}
			return CommonResponseUtils.successResponse("保存成功!");
		}		

	}
	/**
	 * 添加关于我们信息
	 */
	@Override
	public Map<String, Object> addAbout(AboutAuto aboutAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			aboutAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			aboutAuto.setCreateTime(TmDateUtil.getTimeStamp());
			int i = aboutAutoMapper.insertSelective(aboutAuto);
			if (i <= 0) {
				throw new Exception("添加失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("添加成功!"));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>>关于我们信息添加失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	/**
	 * 更新关于我们信息
	 */
	@Override
	public Map<String, Object> updateAbout(AboutAuto aboutAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			aboutAuto.setModifyTime(TmDateUtil.getTimeStamp());
			int i = aboutAutoMapper.updateByPrimaryKeySelective(aboutAuto);
			if (i <= 0) {
				throw new Exception("更新失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("更新成功!"));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>>关于我们信息更新失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * 查询关于我们信息
	 */
	@Override
	public Map<String, Object> queryAbout(AboutAuto aboutAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			aboutAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			AboutAuto aboutInfo = aboutAutoMapper.queryByPrimaryKey(aboutAuto);
			map.putAll(CommonResponseUtils.successResponse(aboutInfo));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>>关于我们信息查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * 删除关于我们信息
	 */
	@Override
	public Map<String, Object> deleteAbout(Long[] aboutIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			for (int i = 0; i < aboutIds.length; i++) {
				AboutAuto aboutAuto = new AboutAuto();
				Long aboutId = aboutIds[i];
				aboutAuto.setAboutId(aboutId);
				aboutAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
				int j = aboutAutoMapper.updateByPrimaryKeySelective(aboutAuto);
				if (j <= 0) {
					throw new Exception("关于我们信息删除失败!");
				}
			}
			map.putAll(CommonResponseUtils.successResponse("关于我们信息删除成功!"));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>>关于我们信息删除失败:" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
