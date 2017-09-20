package com.essential.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.TmDateUtil;
import com.essential.user.dao.UserReceiptAddressAutoMapper;
import com.essential.user.model.auto.UserReceiptAddressAuto;
import com.essential.user.model.vo.UserReceiptAddressVo;
import com.essential.user.service.IUserReceiptAddressService;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * 用户收货地址
 * 
 * @author Jaelyn
 *
 */
@Service
public class UserReceiptAddressServiceImpl implements IUserReceiptAddressService {
	/**
	 * 收货地址
	 */
	@Autowired
	private UserReceiptAddressAutoMapper userReceiptAddressAutoMapper;

	/*
	 * 获取所有收货信息
	 * 
	 * @see com.essential.user.service.impl.IUserReceiptAddressService#
	 * queryAllAddressByUserId
	 * (com.essential.user.model.auto.UserReceiptAddressAuto)
	 */
	@Override
	public Map<String, Object> queryAllAddressByUserId(UserReceiptAddressAuto userReceiptAddressAuto) {

		try {
			userReceiptAddressAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<UserReceiptAddressAuto> receiptAddressList = userReceiptAddressAutoMapper.queryAddressListByUserId(userReceiptAddressAuto);
			List<UserReceiptAddressVo> addressVoList = DTOUtils.map(receiptAddressList, UserReceiptAddressVo.class);
			return CommonResponseUtils.successResponse(addressVoList);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}

	/**
	 * 保存或更新收货地址
	 */
	@Override
	public Map<String, Object> saveOrUpdateAddress(UserReceiptAddressAuto userReceiptAddressAuto) {

		try {
			Long addressId = userReceiptAddressAuto.getAddressId();
			if (addressId == null) {
				return saveAddress(userReceiptAddressAuto);
			} else {
				return updateAddress(userReceiptAddressAuto);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.essential.user.service.impl.IUserReceiptAddressService#saveAddress
	 * (com.essential.user.model.auto.UserReceiptAddressAuto)
	 */
	@Override
	public Map<String, Object> saveAddress(UserReceiptAddressAuto userReceiptAddressAuto) {

		try {
			// Integer isDefault = userReceiptAddressAuto.getIsdefault();
			// if (isDefault !=null&&isDefault>= 0) {
			// cancelDefaultAddress(userReceiptAddressAuto.getUserId());
			// }
			String timeStamp = TmDateUtil.getTimeStamp();
			userReceiptAddressAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			userReceiptAddressAuto.setIsdefault(0);
			userReceiptAddressAuto.setModifyTime(timeStamp);
			userReceiptAddressAuto.setModifyUserId(userReceiptAddressAuto.getUserId());
			String procincesRegions = userReceiptAddressAuto.getProvincesRegions()==null?"":userReceiptAddressAuto.getProvincesRegions();
			String detail = userReceiptAddressAuto.getDetail()==null?"": userReceiptAddressAuto.getDetail();
			userReceiptAddressAuto.setConsigneeAddress(procincesRegions + detail);
			int num = 0;
			userReceiptAddressAuto.setCreateTime(timeStamp);
			// userReceiptAddressAuto.setCreateUserId(userReceiptAddressAuto.getUserId());
			num = userReceiptAddressAutoMapper.insert(userReceiptAddressAuto);
			if (num > 0) {
				UserReceiptAddressVo userReceiptAddressVo = new UserReceiptAddressVo();
				DTOUtils.map(userReceiptAddressAuto, userReceiptAddressVo);
				return CommonResponseUtils.successResponse("保存成功", userReceiptAddressVo);
			} else {
				return CommonResponseUtils.failureResponse("保存失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.essential.user.service.impl.IUserReceiptAddressService#updateAddress
	 * (com.essential.user.model.auto.UserReceiptAddressAuto)
	 */
	@Override
	public Map<String, Object> updateAddress(UserReceiptAddressAuto userReceiptAddressAuto) {
		try {
			String timeStamp = TmDateUtil.getTimeStamp();
			// Long addressId = userReceiptAddressAuto.getAddressId();
			// Integer isDefault = userReceiptAddressAuto.getIsdefault();
			// if (isDefault !=null&&isDefault>= 0) {
			// cancelDefaultAddress(userReceiptAddressAuto.getUserId());
			// }
			//userReceiptAddressAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			userReceiptAddressAuto.setModifyTime(timeStamp);
			userReceiptAddressAuto.setModifyUserId(userReceiptAddressAuto.getUserId());
			String procincesRegions = userReceiptAddressAuto.getProvincesRegions()==null?"":userReceiptAddressAuto.getProvincesRegions();
			String detail = userReceiptAddressAuto.getDetail()==null?"": userReceiptAddressAuto.getDetail();
			userReceiptAddressAuto.setConsigneeAddress(procincesRegions + detail);
			int num = 0;
			num = userReceiptAddressAutoMapper.updateByPrimaryKeySelective(userReceiptAddressAuto);
			if (num > 0) {
				UserReceiptAddressVo userReceiptAddressVo = new UserReceiptAddressVo();
				DTOUtils.map(userReceiptAddressAuto, userReceiptAddressVo);
				return CommonResponseUtils.successResponse("修改成功", userReceiptAddressVo);
			} else {
				return CommonResponseUtils.failureResponse("修改失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.essential.user.service.impl.IUserReceiptAddressService#deleteAddress
	 * (com.essential.user.model.auto.UserReceiptAddressAuto)
	 */
	@Override
	public Map<String, Object> deleteAddress(UserReceiptAddressAuto userReceiptAddressAuto) {

		try {
			int num = userReceiptAddressAutoMapper.deleteByPrimaryKey(userReceiptAddressAuto.getAddressId());
			if (num > 0) {
				Long addressId = userReceiptAddressAuto.getAddressId();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("addressId", addressId);
				map.put(SUConstants.MSG_KEY, "删除成功");
				return CommonResponseUtils.successResponse("删除成功", map);
			} else {
				return CommonResponseUtils.failureResponse("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.essential.user.service.impl.IUserReceiptAddressService#queryAddressById
	 * (long)
	 */
	@Override
	public Map<String, Object> queryAddressById(long addressId) {
		try {
			UserReceiptAddressAuto userReceiptAddressAuto = userReceiptAddressAutoMapper.selectByPrimaryKey(addressId);
			if (userReceiptAddressAuto != null) {
				return CommonResponseUtils.successResponse(userReceiptAddressAuto);
			} else {
				return CommonResponseUtils.failureResponse();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.essential.user.service.impl.IUserReceiptAddressService#
	 * queryDefaultOrRecommendAddress(java.lang.Long)
	 */
	@Override
	public UserReceiptAddressVo queryDefaultOrRecommendAddress(Long userId) {
		try {
			UserReceiptAddressAuto defaultAddress = queryDefaultAddress(userId);
			UserReceiptAddressVo userAddressVo = new UserReceiptAddressVo();
			if (defaultAddress == null) {
				defaultAddress = userReceiptAddressAutoMapper.queryRecommendAddress(userId);
			}
			if (defaultAddress != null) {
				DTOUtils.map(defaultAddress, userAddressVo);
				return userAddressVo;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 查找设置的默认地址
	 * 
	 * @param userId
	 * @return po
	 */
	private UserReceiptAddressAuto queryDefaultAddress(long userId) {
		UserReceiptAddressAuto userReceiptAddressAutoRequst = new UserReceiptAddressAuto();
		userReceiptAddressAutoRequst.setUserId(userId);
		userReceiptAddressAutoRequst.setIsdefault(1);
		userReceiptAddressAutoRequst.setIsDelete(SUConstants.IS_NOT_DELETE);
		UserReceiptAddressAuto userReceiptAddressAuto = userReceiptAddressAutoMapper.queryDefaultAddress(userReceiptAddressAutoRequst);
		return userReceiptAddressAuto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.essential.user.service.impl.IUserReceiptAddressService#setDefaultAddress
	 * (com.essential.user.model.auto.UserReceiptAddressAuto)
	 */
	@Override
	public Map<String, Object> setDefaultAddress(UserReceiptAddressAuto userReceiptAddressAuto) {
		try {
			// 查找以前默认地址并取消
			cancelDefaultAddress(userReceiptAddressAuto.getUserId());

			userReceiptAddressAuto.setModifyTime(TmDateUtil.getTimeStamp());
			userReceiptAddressAuto.setIsdefault(1);
			int num = userReceiptAddressAutoMapper.updateByPrimaryKeySelective(userReceiptAddressAuto);
			if (num > 0) {
				return CommonResponseUtils.successResponse("设置成功", userReceiptAddressAuto);
			} else {
				throw new MyException("设置失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("设置失败");
		}

	}

	/**
	 * 取消默认地址
	 * 
	 * @param userId
	 */
	@Override
	public void cancelDefaultAddress(Long userId) {
		try {
			UserReceiptAddressAuto defaultAddress = new UserReceiptAddressAuto();
			// defaultAddress.setIsdefault(0);
			defaultAddress.setModifyTime(TmDateUtil.getTimeStamp());
			defaultAddress.setUserId(userId);
			defaultAddress.setIsdefault(0);
			int num=userReceiptAddressAutoMapper.cancelDefaultAddress(defaultAddress);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
