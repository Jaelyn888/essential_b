/**
 * 
 */
package com.essential.bussiness.address.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.essential.bussiness.address.dao.ProvinceAutoMapper;
import com.essential.bussiness.address.model.auto.ProvinceAuto;
import com.essential.bussiness.address.model.vo.ProvinceVo;
import com.essential.bussiness.address.service.ICityService;
import com.essential.bussiness.address.service.IDistrictService;
import com.essential.bussiness.address.service.IProvinceService;
import com.essential.common.constants.SUConstants;
import com.essential.utils.CommonResponseUtils;
import com.googlecode.ehcache.annotations.Cacheable;

/**
 * @author Jaelyn
 * 省操作
 */
@Service
public class ProvinceServiceImpl implements IProvinceService {
	/**
	 * 省表 maper
	 */
	@Autowired
	private ProvinceAutoMapper provinceAutoMapper;
	
	@Autowired
	@Qualifier("cityServiceImpl")
	private ICityService cityServiceImpl;
	
	@Autowired
	@Qualifier("districtServiceImpl")
	private IDistrictService districtServiceImpl;
	/**
	 * 查询所有省市区（未完  待续）
	 * 
	 * @param Province
	 *            
	 * @return
	 */
	@Cacheable(cacheName="addressCache")
	public Map<String,Object> queryAreaList(Map<String,Object> map){
		try {			
			map.put(SUConstants.KEY_IS_DELETE, SUConstants.IS_NOT_DELETE);
			List<ProvinceVo> areaList=provinceAutoMapper.queryAreaList(map);
			return CommonResponseUtils.successResponse(areaList);

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
		
	}
	/**
	 * 查询所有省
	 * @param map
	 * @return
	 */
	@Override
	public Map<String,Object> queryProvinceList(Map<String,Object> map){
		try {
			map.put(SUConstants.KEY_IS_DELETE, SUConstants.IS_NOT_DELETE);
			List<ProvinceAuto> provinceVoList=provinceAutoMapper.queryProvinceList(map);
			return CommonResponseUtils.successResponse(provinceVoList);

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
		
	}
	
	/**
	 * 保存省
	 * @param map
	 * @return
	 */
	@Override
	public Map<String,Object> saveProvince(ProvinceAuto province){
		try {
			int num=provinceAutoMapper.insertSelective(province);
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

	/**
	 * update Province
	 * 
	 * @param Province
	 *            更新后的评论信息
	 * @return
	 */
	@Override
	public Map<String, Object> updateProvince(ProvinceAuto province){
		try {
			int num=provinceAutoMapper.updateByPrimaryKeySelective(province);
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
	 * @see com.essential.bussiness.address.service.impl.IProvinceService#deleteProvince(com.essential.bussiness.address.model.auto.ProvinceAuto)
	 */
	@Override
	public 	Map<String, Object> deleteProvince(ProvinceAuto province){
		try {
			int num=provinceAutoMapper.updateByPrimaryKeySelective(province);
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
	 * @see com.essential.bussiness.address.service.impl.IProvinceService#queryProvinceById(long)
	 */
	@Override
	public Map<String, Object> queryProvinceById(long provinceId) {
		try {
			ProvinceAuto provinceAuto=provinceAutoMapper.selectByPrimaryKey(provinceId);
			if (provinceAuto!=null) {
				return CommonResponseUtils.successResponse(provinceAuto);
			} else {
				return CommonResponseUtils.failureResponse();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}
	
}
