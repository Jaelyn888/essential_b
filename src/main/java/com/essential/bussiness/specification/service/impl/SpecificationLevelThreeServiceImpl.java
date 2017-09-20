package com.essential.bussiness.specification.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.specification.dao.SpecificationLevelThreeAutoMapper;
import com.essential.bussiness.specification.model.auto.SpecificationLevelThreeAuto;
import com.essential.bussiness.specification.service.ISpecificationLevelThreeService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
/**
 * 
 * @author cpx
 *三级规格业务
 */
@Service
public class SpecificationLevelThreeServiceImpl implements
		ISpecificationLevelThreeService {
	private static Logger logger = LoggerFactory
			.getLogger(SpecificationLevelThreeServiceImpl.class);
	@Autowired
	SpecificationLevelThreeAutoMapper specificationLevelThreeAutoMapper;
	//增加三级规格
	@Override
	public Map<String,Object> add(SpecificationLevelThreeAuto specificationLevelThreeAuto) {							
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			specificationLevelThreeAuto.setCreateTime(TmDateUtil.getTimeStamp());
			specificationLevelThreeAuto.setModifyTime(TmDateUtil.getTimeStamp());
			
		int i=specificationLevelThreeAutoMapper.insert(specificationLevelThreeAuto);
			if (i > 0) {
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
				return map;
			}
		} catch (Exception e) {
			logger.info("新增三级规格失败:", e);
			e.printStackTrace();
		}

		map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
		map.put(SUConstants.MSG_KEY, "新增三级级规格失败");

		return map;
	}
	//删除三级规格
	@Override
	public Map<String,Object> delete(SpecificationLevelThreeAuto specificationLevelThreeAuto) {		
		Map<String,Object> map = new HashMap<String,Object>();
		specificationLevelThreeAuto.setIsDeleted(SUConstants.IS_DELETE);
				if(specificationLevelThreeAuto.getSpecificationValueid()==null){
					map.put(SUConstants.MSG_KEY, "三级规格ID为空,删除三级规格信息失败");
					map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
				
					return map;
				}
				
				try {
					specificationLevelThreeAuto.setModifyTime(TmDateUtil.getTimeStamp());
				int i=specificationLevelThreeAutoMapper.updateByPrimaryKeySelective(specificationLevelThreeAuto);
					if(i>0){
						map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
						map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
						
						return map;
					}
					
				} catch (Exception e) {
					logger.info("删除三级规格信息失败:", e);
					e.printStackTrace();
				}
				
				map.put(SUConstants.MSG_KEY, "删除三级规格信息失败");
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
				return map;
	}
	//修改三级规格
	@Override
	public  Map<String,Object> update(SpecificationLevelThreeAuto specificationLevelThreeAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (specificationLevelThreeAuto.getSpecificationValueid() == null) {
			map.put(SUConstants.MSG_KEY, "三级规格ID为空,修改三级规格信息失败");
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);

			return map;
		}

		try {
			int i=specificationLevelThreeAutoMapper.updateByPrimaryKeySelective(specificationLevelThreeAuto);
			if (i > 0) {
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);

				return map;
			}

		} catch (Exception e) {
			logger.info("修改三级规格信息失败:", e);
			e.printStackTrace();
		}

		map.put(SUConstants.MSG_KEY, "修改三级规格信息失败");
		map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
		return map;
	}
	//查询三级规格
	@Override
	public Map<String,Object> query(SpecificationLevelThreeAuto specificationLevelThreeAuto) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<SpecificationLevelThreeAuto> list=new ArrayList<SpecificationLevelThreeAuto>();
		
		try {
			list= specificationLevelThreeAutoMapper.queryAll(specificationLevelThreeAuto);
			map.put(SUConstants.MSG_KEY,SUConstants.MSG_SUCCESS_VALUE);
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
			map.put("info",list);
			return map;
			
			
		} catch (Exception e) {
			logger.info("查询三级规格失败",e);
			map.put(SUConstants.MSG_KEY, "查询三级规格失败");
			map.put(SUConstants.CODE_KEY,SUConstants.CODE_FAIL_VALUE);
			e.printStackTrace();
		}
		
		return map;					
	}

}
