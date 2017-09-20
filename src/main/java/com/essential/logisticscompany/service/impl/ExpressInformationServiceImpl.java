package com.essential.logisticscompany.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.logisticscompany.dao.ExpressInformationAutoMapper;
import com.essential.logisticscompany.model.auto.ExpressInformationAuto;
import com.essential.logisticscompany.model.vo.ExpressInformationVo;
import com.essential.logisticscompany.service.IExpressInformationService;
import com.essential.utils.CommonResponseUtils;

@Service
public class ExpressInformationServiceImpl implements IExpressInformationService {
	private static Logger logger = LoggerFactory.getLogger(ExpressInformationServiceImpl.class);

	@Autowired
	ExpressInformationAutoMapper expressInformationAutoMapper;

	/**
	 * 查询快递公司信息列表
	 */
	@Override
	public Map<String, Object> queryExpressInfo(ExpressInformationVo expressInformationVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer pageIndex = expressInformationVo.getPageIndex();
			Integer pageSize = expressInformationVo.getPageSize();
			// if (pageIndex == null) {
			// pageIndex = 1;
			// }
			// if (pageSize == null) {
			// pageSize = 12;
			// }
			if (pageIndex != null && pageSize != null) {
				expressInformationVo.setPageIndex((pageIndex - 1) * pageSize);
				expressInformationVo.setPageSize(pageSize);
			}
			expressInformationVo.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<ExpressInformationAuto> expressInformationAutoList = expressInformationAutoMapper.queryExpressInfo(expressInformationVo);
			map.putAll(CommonResponseUtils.successResponse(expressInformationAutoList));
			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>查询快递公司信息列表失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加快递公司信息
	 */
	@Override
	public Map<String, Object> addExpressInfo(ExpressInformationAuto expressInformationAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			expressInformationAuto.setCreateTime(TmDateUtil.getTimeStamp());
			expressInformationAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			int i = expressInformationAutoMapper.insertSelective(expressInformationAuto);
			if (i <= 0) {
				throw new Exception("添加快递公司信息失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("添加快递公司信息成功!"));
			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>添加快递公司信息失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 更新快递公司信息
	 */
	@Override
	public Map<String, Object> updateExpressInfo(ExpressInformationAuto expressInformationAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			expressInformationAuto.setModifyTime(TmDateUtil.getTimeStamp());
			int i = expressInformationAutoMapper.updateByPrimaryKeySelective(expressInformationAuto);
			if (i <= 0) {
				throw new Exception("更新快递公司信息失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("更新快递公司信息成功!"));
			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>更新快递公司信息失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除快递公司信息
	 */
	@Override
	public Map<String, Object> deleteExpressInfo(Long[] expressIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			for (int i = 0; i < expressIds.length; i++) {
				Long expressId = expressIds[i];
				if (expressId == null) {
					throw new Exception("快递公司信息Id不能为空");
				}
				ExpressInformationAuto expressInformationAuto = new ExpressInformationAuto();
				expressInformationAuto.setExpressId(expressId);
				expressInformationAuto.setIsDelete(SUConstants.IS_DELETE);
				int j = expressInformationAutoMapper.updateByPrimaryKeySelective(expressInformationAuto);
				if (j <= 0) {
					throw new Exception("删除快递公司信息失败!");
				}
			}
			map.putAll(CommonResponseUtils.successResponse("删除快递公司信息成功!"));
			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>删除快递公司信息失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
