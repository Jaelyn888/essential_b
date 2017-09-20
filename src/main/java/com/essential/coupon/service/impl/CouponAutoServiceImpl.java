package com.essential.coupon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.coupon.dao.CouponAutoMapper;
import com.essential.coupon.dao.CouponUserReceiveAutoMapper;
import com.essential.coupon.model.auto.CouponAuto;
import com.essential.coupon.model.auto.CouponUserReceiveAuto;
import com.essential.coupon.model.vo.CouponAutoVo;
import com.essential.coupon.model.vo.CouponNotUsedListVo;
import com.essential.coupon.model.vo.CouponNotUsedVo;
import com.essential.coupon.service.ICouponAutoService;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * 优惠券接口实现类
 * 
 * @author czm
 *
 */
@Service
public class CouponAutoServiceImpl implements ICouponAutoService {
	private static Logger logger = LoggerFactory.getLogger(CouponAutoServiceImpl.class);
	@Autowired
	CouponAutoMapper couponAutoMapper;
	@Autowired
	CouponUserReceiveAutoMapper couponUserReceiveAutoMapper;

	/**
	 * 未使用的优惠券
	 */
	@Override
	public Map<String, Object> queryCouponNotUsed(CouponAutoVo couponAutoVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			CouponNotUsedListVo couponNotUsedListVo = new CouponNotUsedListVo();
			List<CouponNotUsedVo> couponList = new ArrayList<CouponNotUsedVo>();

			// 页数
			Integer pageIndex = couponAutoVo.getPageIndex();
			// 条数
			Integer pageSize = couponAutoVo.getPageSize();
			if (pageIndex == null) {
				pageIndex = 1;
			}
			if (pageSize == null) {
				pageSize = SUConstants.PAGE_COUNT;
			}
			pageIndex = (pageIndex - 1) * pageSize;
			couponAutoVo.setPageIndex(pageIndex);
			couponAutoVo.setPageSize(pageSize);

			// 全用户
			List<CouponAuto> couponAllUserList = couponAutoMapper.queryCouponNotUsedAllUser(couponAutoVo);
			if (couponAllUserList != null && couponAllUserList.size() > 0) {
				for (int i = 0; i < couponAllUserList.size(); i++) {
					CouponNotUsedVo couponNotUsedVo = new CouponNotUsedVo();
					CouponAuto couponAllUser = couponAllUserList.get(i);
					DTOUtils.map(couponAllUser, couponNotUsedVo);
					couponList.add(couponNotUsedVo);
				}
			}

			// 新用户
			List<CouponAuto> couponNewUserList = couponAutoMapper.queryCouponNotUsedNewUser(couponAutoVo);
			if (couponNewUserList != null && couponNewUserList.size() > 0) {
				for (int i = 0; i < couponNewUserList.size(); i++) {
					CouponNotUsedVo couponNotUsedVo = new CouponNotUsedVo();
					CouponAuto couponNewUser = couponNewUserList.get(i);
					DTOUtils.map(couponNewUser, couponNotUsedVo);
					couponList.add(couponNotUsedVo);
				}
			}

			// 兑换
			List<CouponAuto> couponReceiveList = couponAutoMapper.queryCouponNotUsedReceive(couponAutoVo);
			if (couponReceiveList != null && couponReceiveList.size() > 0) {
				for (int i = 0; i < couponReceiveList.size(); i++) {
					CouponNotUsedVo couponNotUsedVo = new CouponNotUsedVo();
					CouponAuto couponReceiveUser = couponReceiveList.get(i);
					DTOUtils.map(couponReceiveUser, couponNotUsedVo);
					couponList.add(couponNotUsedVo);
				}
			}
			couponNotUsedListVo.setCouponList(couponList);
			map.putAll(CommonResponseUtils.successResponse(couponNotUsedListVo));
			return map;
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>未使用的优惠券查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 已失效的优惠券
	 */
	@Override
	public Map<String, Object> queryCouponHasFailed(CouponAutoVo couponAutoVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			CouponNotUsedListVo couponNotUsedListVo = new CouponNotUsedListVo();
			List<CouponNotUsedVo> couponList = new ArrayList<CouponNotUsedVo>();

			// 页数
			Integer pageIndex = couponAutoVo.getPageIndex();
			// 条数
			Integer pageSize = couponAutoVo.getPageSize();
			if (pageIndex == null) {
				pageIndex = 1;
			}
			if (pageSize == null) {
				pageSize = SUConstants.PAGE_COUNT;
			}
			pageIndex = (pageIndex - 1) * pageSize;
			couponAutoVo.setPageIndex(pageIndex);
			couponAutoVo.setPageSize(pageSize);

			// 全用户
			List<CouponAuto> couponAllUserList = couponAutoMapper.queryCouponHasFailedAllUser(couponAutoVo);
			if (couponAllUserList != null && couponAllUserList.size() > 0) {
				for (int i = 0; i < couponAllUserList.size(); i++) {
					CouponNotUsedVo couponNotUsedVo = new CouponNotUsedVo();
					CouponAuto couponAllUser = couponAllUserList.get(i);
					DTOUtils.map(couponAllUser, couponNotUsedVo);
					couponList.add(couponNotUsedVo);
				}
			}

			// 新用户
			List<CouponAuto> couponNewUserList = couponAutoMapper.queryCouponHasFailedNewUser(couponAutoVo);
			if (couponNewUserList != null && couponNewUserList.size() > 0) {
				for (int i = 0; i < couponNewUserList.size(); i++) {
					CouponNotUsedVo couponNotUsedVo = new CouponNotUsedVo();
					CouponAuto couponNewUser = couponNewUserList.get(i);
					DTOUtils.map(couponNewUser, couponNotUsedVo);
					couponList.add(couponNotUsedVo);
				}
			}

			// 兑换
			List<CouponAuto> couponReceiveList = couponAutoMapper.queryCouponHasFailedReceive(couponAutoVo);
			if (couponReceiveList != null && couponReceiveList.size() > 0) {
				for (int i = 0; i < couponReceiveList.size(); i++) {
					CouponNotUsedVo couponNotUsedVo = new CouponNotUsedVo();
					CouponAuto couponReceiveUser = couponReceiveList.get(i);
					DTOUtils.map(couponReceiveUser, couponNotUsedVo);
					couponList.add(couponNotUsedVo);
				}
			}
			couponNotUsedListVo.setCouponList(couponList);
			map.putAll(CommonResponseUtils.successResponse(couponNotUsedListVo));
			return map;
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>已失效的优惠券查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 新建优惠券
	 */
	@Override
	public Map<String, Object> addCoupon(CouponNotUsedVo couponNotUsedVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			CouponAuto couponAuto = new CouponAuto();
			DTOUtils.map(couponNotUsedVo, couponAuto);
			couponAuto.setCreateTime(TmDateUtil.getTimeStamp());
			couponAuto.setCreateUser(couponNotUsedVo.getLoginUser());
			int i = couponAutoMapper.insertSelective(couponAuto);
			if (i <= 0) {
				throw new Exception("新建优惠券失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("新建优惠券成功!"));
			return map;
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>新建优惠券失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 更新优惠券
	 */
	@Override
	public Map<String, Object> updateCoupon(CouponNotUsedVo couponNotUsedVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			CouponAuto couponAuto = new CouponAuto();
			DTOUtils.map(couponNotUsedVo, couponAuto);
			couponAuto.setModifyTime(TmDateUtil.getTimeStamp());
			couponAuto.setModifyUser(couponNotUsedVo.getLoginUser());
			int i = couponAutoMapper.updateByPrimaryKey(couponAuto);
			if (i <= 0) {
				throw new Exception("更新优惠券失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("更新优惠券成功!"));
			return map;
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>更新优惠券失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 编辑优惠券（查询）
	 */
	@Override
	public Map<String, Object> editCoupon(Long couponId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			CouponAuto couponAuto = couponAutoMapper.selectByPrimaryKey(couponId);
			map.putAll(CommonResponseUtils.successResponse(couponAuto));
			return map;
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>编辑优惠券（查询）失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除优惠券
	 */
	@Override
	public Map<String, Object> deleteCoupon(Long couponId, Long loginUser) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			CouponAuto couponAuto = new CouponAuto();
			couponAuto.setCouponId(couponId);
			couponAuto.setModifyTime(TmDateUtil.getTimeStamp());
			couponAuto.setModifyUser(loginUser);
			couponAuto.setIsDelete(SUConstants.IS_DELETE);
			int i = couponAutoMapper.updateIsdelete(couponAuto);
			if (i <= 0) {
				throw new Exception("优惠券删除失败!");
			}
			map.putAll(CommonResponseUtils.successResponse("优惠券删除成功!"));
			return map;
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>优惠券删除失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 优惠券列表（平台）
	 */
	@Override
	public Map<String, Object> couponList(CouponAutoVo couponAutoVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			if ("".equals(couponAutoVo.getCouponName())) {
				couponAutoVo.setCouponName(null);
			}
			List<CouponAuto> couponList = couponAutoMapper.querycouponList(couponAutoVo);
			map.putAll(CommonResponseUtils.successResponse(couponList));
			return map;
		} catch (Exception e) {
			logger.info("===========>>>>>>>>>优惠券列表查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 领取优惠券(手机端)
	 */
	@Override
	public Map<String, Object> exchange(String code, long userId) {
		try {
			// 查询优惠券是否存在
			CouponUserReceiveAuto couponUser =new CouponUserReceiveAuto();
			couponUser.setUserId(userId);
			couponUser.setCouponId(couponAutoMapper.selectCouponId(code).getCouponId());
			CouponUserReceiveAuto bc=	couponUserReceiveAutoMapper.verifyrepetition(couponUser);
		if(!(bc==null))
		{
			
			return CommonResponseUtils.failureResponse("优惠券已经领取过了");
		}
			
			
			CouponAuto couponAuto = couponAutoMapper.querycouponisexist(code);
			//
			if (couponAuto != null) {
				CouponUserReceiveAuto couponUserReceiveAuto = new CouponUserReceiveAuto();
				// 添加未删除标示
				couponUserReceiveAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
				// 得到优惠券id
				couponUserReceiveAuto.setCouponId(couponAuto.getCouponId());
				// 得到用户id
				couponUserReceiveAuto.setUserId(userId);

				if (couponUserReceiveAutoMapper.insert(couponUserReceiveAuto) > 0) {

					return CommonResponseUtils.successResponse("领取优惠券成功");
				} else {
					return CommonResponseUtils.failureResponse("优惠券已经失效");

				}

			}
			// 兑换优惠券失败
			else {
				return CommonResponseUtils.failureResponse("优惠券已经失效");

			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
