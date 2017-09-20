package com.essential.bussiness.shop.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.shop.controller.StoreManagementController;
import com.essential.bussiness.shop.dao.EntityShopAutoMapper;
import com.essential.bussiness.shop.model.auto.EntityShopAuto;
import com.essential.bussiness.shop.service.IStoreManagementService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;

/**
 * 门店管理（商家后台）Service
 * 
 * @author czm
 *
 */
@Service
public class StoreManagementServiceImpl implements IStoreManagementService {
	private static Logger logger = LoggerFactory.getLogger(StoreManagementServiceImpl.class);

	@Autowired
	EntityShopAutoMapper entityShopAutoMapper;

	/**
	 * 添加线下店铺地址
	 */
	@Override
	public Map<String, Object> addStoreAddressInfo(EntityShopAuto entityshopAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 添加地址信息
			entityshopAuto.setCreateTime(TmDateUtil.getTimeStamp());
			entityshopAuto.setModifyTime(TmDateUtil.getTimeStamp());
			entityshopAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			int i = entityShopAutoMapper.insertSelective(entityshopAuto);
			if (i <= 0) {
				// 返回添加失败的信息
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
				map.put(SUConstants.MSG_KEY, "添加失败");
			}
			// 返回添加成功的信息
			map.putAll(CommonResponseUtils.successResponse("添加线下店铺地址成功!"));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>>添加线下店铺地址失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * 查询店铺地址
	 */
	@Override
	public Map<String, Object> queryStoreInfo(HttpServletRequest request) {
		// 返回信息map
		Map<String, Object> outputMap = new HashMap<String, Object>();
		// 传入参数map
		Map<String, Object> inputEntityShopMap = new HashMap<String, Object>();
		// 店铺地址list
		List<EntityShopAuto> entityShopList = new ArrayList<EntityShopAuto>();
		try {
			String shopId = request.getParameter("shopId");
			String pageIndex = request.getParameter("pageIndex");
			int pageSize = 20;
			// 店铺Id
			inputEntityShopMap.put("shopId", Long.valueOf(shopId));
			inputEntityShopMap.put("pageIndex", Integer.valueOf(pageIndex));
			inputEntityShopMap.put("pageSize", pageSize);
			entityShopList = entityShopAutoMapper.queryByPrimaryKey(inputEntityShopMap);
			// 返回信息封装
			outputMap.putAll(CommonResponseUtils.successResponse(entityShopList));
			return outputMap;
		} catch (Exception e) {
			logger.info("====>>>>>添加线下店铺地址失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 删除店铺地址
	 */
	@Override
	public Map<String, Object> deleteStoreAddressInfo(Long[] entityshopIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			for (Long entityshopId : entityshopIds) {
				// 封装数据
				EntityShopAuto entityShopAuto = new EntityShopAuto();
				// 线下店铺id
				entityShopAuto.setEntityshopId(entityshopId);
				// 删除标志
				entityShopAuto.setIsDelete(SUConstants.IS_DELETE);
				int i = entityShopAutoMapper.updateByPrimaryKeySelective(entityShopAuto);
				if (i <= 0) {
					throw new Exception("=========>>>>>>修改店铺信息状态失败");
				}
			}
			map.putAll(CommonResponseUtils.successResponse("修改店铺信息状态成功!"));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>>店铺信息删除失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
