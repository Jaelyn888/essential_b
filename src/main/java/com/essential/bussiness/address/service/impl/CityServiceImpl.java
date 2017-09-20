/**
 * 
 */
package com.essential.bussiness.address.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.address.dao.CityAutoMapper;
import com.essential.bussiness.address.model.auto.CityAuto;
import com.essential.bussiness.address.model.vo.CityVo;
import com.essential.bussiness.address.service.ICityService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * @author Jaelyn
 * 省操作
 */
@Service
public class CityServiceImpl implements ICityService {
	/**
	 * 省表 maper
	 */
	@Autowired
	private CityAutoMapper cityAutoMapper;
	
	/* (non-Javadoc)
	 * @see com.essential.bussiness.address.service.impl.CityService#queryAllCity(java.util.Map)
	 */
	@Override
	public Map<String,Object> queryCityVoListByParentId(CityAuto cityAuto){
		try {
			
			List<CityAuto> cityList=queryCityListByParentId(cityAuto);
			List<CityVo> cityVoList=DTOUtils.map(cityList, CityVo.class);
			return CommonResponseUtils.successResponse(cityVoList);

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
		
	}
	
	public List<CityAuto> queryCityListByParentId(CityAuto cityAuto){
		try {
			cityAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<CityAuto> cityList=cityAutoMapper.selectCityListByParentId(cityAuto);
			return cityList;

		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<CityAuto>();
		}
		
	}
	

	/* (non-Javadoc)
	 * @see com.essential.bussiness.address.service.impl.CityService#saveCity(com.essential.bussiness.address.model.auto.CityAuto)
	 */
	@Override
	public Map<String,Object> saveCity(CityAuto city){
		try {
			int num=cityAutoMapper.insertSelective(city);
			if (num > 0) {
				return CommonResponseUtils.successResponse("保存成功",null);
			} else {
				return CommonResponseUtils.failureResponse("保存失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

		

	}

	/* (non-Javadoc)
	 * @see com.essential.bussiness.address.service.impl.CityService#updateCity(com.essential.bussiness.address.model.auto.CityAuto)
	 */
	@Override
	public Map<String, Object> updateCity(CityAuto city){
		try {
			int num=cityAutoMapper.updateByPrimaryKeySelective(city);
			if (num > 0) {
				return CommonResponseUtils.successResponse("更新成功",null);
			} else {
				return CommonResponseUtils.failureResponse();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}

	/* (non-Javadoc)
	 * @see com.essential.bussiness.address.service.impl.CityService#deleteCity(com.essential.bussiness.address.model.auto.CityAuto)
	 */
	@Override
	public 	Map<String, Object> deleteCity(CityAuto city){
		try {
			int num=cityAutoMapper.updateByPrimaryKeySelective(city);
			if (num > 0) {
				return CommonResponseUtils.successResponse("删除成功",null);
			} else {
				return CommonResponseUtils.failureResponse("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}

	/* (non-Javadoc)
	 * @see com.essential.bussiness.address.service.impl.CityService#selectCityById(long)
	 */
	@Override
	public Map<String, Object> selectCityById(long cityId) {
		try {
			CityAuto cityAuto=cityAutoMapper.selectByPrimaryKey(cityId);
			if (cityAuto!=null) {
				CityVo cityVo=new CityVo();
				DTOUtils.map(cityAuto, cityVo);
				return CommonResponseUtils.successResponse(cityVo);
			} else {
				return CommonResponseUtils.failureResponse();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}
	
}
