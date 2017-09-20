/**
 * 
 */
package com.essential.bussiness.address.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.address.dao.DistrictAutoMapper;
import com.essential.bussiness.address.model.auto.CityAuto;
import com.essential.bussiness.address.model.auto.DistrictAuto;
import com.essential.bussiness.address.model.vo.CityVo;
import com.essential.bussiness.address.model.vo.DistrictVo;
import com.essential.bussiness.address.service.IDistrictService;
import com.essential.common.constants.SUConstants;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * @author Jaelyn
 * 区、县操作
 */
@Service
public class DistrictServiceImpl implements IDistrictService {
	/**
	 * 区、县表 maper
	 */
	@Autowired
	private DistrictAutoMapper districtAutoMapper;
	

	@Override
	public Map<String,Object> queryDistrictVoListByParentId(DistrictAuto districtAuto){
		try {
			
			List<DistrictAuto> cityList=queryDistrictListByParentId(districtAuto);
			List<DistrictVo> cityVoList=DTOUtils.map(cityList, DistrictVo.class);
			return CommonResponseUtils.successResponse(cityVoList);

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}	
	}
	
	public List<DistrictAuto> queryDistrictListByParentId(DistrictAuto districtAuto){
		try {
			districtAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<DistrictAuto> districtList=districtAutoMapper.queryDistrictListByParentId(districtAuto);
			return districtList;

		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<DistrictAuto>();
		}
		
	}
	/* (non-Javadoc)
	 * @see com.essential.bussiness.address.service.impl.IDistrictService#saveDistrict(com.essential.bussiness.address.model.auto.DistrictAuto)
	 */
	@Override
	public Map<String,Object> saveDistrict(DistrictAuto district){
		try {
			int num=districtAutoMapper.insertSelective(district);
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
	 * @see com.essential.bussiness.address.service.impl.IDistrictService#updateDistrict(com.essential.bussiness.address.model.auto.DistrictAuto)
	 */
	@Override
	public Map<String, Object> updateDistrict(DistrictAuto district){
		try {
			int num=districtAutoMapper.updateByPrimaryKeySelective(district);
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
	 * @see com.essential.bussiness.address.service.impl.IDistrictService#deleteDistrict(com.essential.bussiness.address.model.auto.DistrictAuto)
	 */
	@Override
	public 	Map<String, Object> deleteDistrict(DistrictAuto district){
		try {
			int num=districtAutoMapper.updateByPrimaryKeySelective(district);
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
	 * @see com.essential.bussiness.address.service.impl.IDistrictService#queryDistrictById(long)
	 */
	@Override
	public Map<String, Object> queryDistrictById(long districtId) {
		try {
			DistrictAuto districtAuto=districtAutoMapper.selectByPrimaryKey(districtId);	
			if (districtAuto!=null) {
				DistrictVo districtVo=new DistrictVo();
				DTOUtils.map(districtAuto, districtVo);
				return CommonResponseUtils.successResponse(districtAuto);
			} else {
				return CommonResponseUtils.failureResponse();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}
	
}
