package com.essential.coupon.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.coupon.model.auto.CouponAuto;
import com.essential.coupon.model.vo.CouponAutoVo;
import com.essential.coupon.model.vo.CouponNotUsedVo;
import com.essential.coupon.service.ICouponAutoService;
import com.essential.utils.CommonResponseUtils;

/**
 * 优惠券
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "coupon")
public class CouponAutoController {
	private static Logger logger = LoggerFactory.getLogger(CouponAutoController.class);

	@Autowired
	ICouponAutoService couponAutoService;

	/**
	 * 未使用的优惠券
	 * 
	 * @param couponAutoVo
	 * @return
	 * 
	 */
	@RequestMapping(value = "queryCouponNotUsed")
	@ResponseBody
	public Map<String, Object> queryCouponNotUsed(CouponAutoVo couponAutoVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (couponAutoVo.getUserId() == null) {
				return CommonResponseUtils.failureResponse("用户Id不能为空!");
			}
			return couponAutoService.queryCouponNotUsed(couponAutoVo);
		} catch (Exception e) {
			logger.info("===============>>>>>>>>>>>>>未使用的优惠券查询失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("未使用的优惠券查询失败!"));
		}
		return map;
	}

	/**
	 * 已失效的优惠券
	 * 
	 * @param couponAutoVo
	 * @return
	 */
	@RequestMapping(value = "queryCouponHasFailed")
	@ResponseBody
	public Map<String, Object> queryCouponHasFailed(CouponAutoVo couponAutoVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (couponAutoVo.getUserId() == null) {
				return CommonResponseUtils.failureResponse("用户Id不能为空!");
			}
			return couponAutoService.queryCouponHasFailed(couponAutoVo);
		} catch (Exception e) {
			logger.info("===============>>>>>>>>>>>>>已失效的优惠券查询失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("已失效的优惠券查询失败!"));
		}
		return map;
	}

	/**
	 * 新建优惠券
	 * 
	 * @param couponNotUsedVo
	 * @return
	 */
	@RequestMapping(value = "addCoupon")
	@ResponseBody
	public Map<String, Object> addCoupon(CouponNotUsedVo couponNotUsedVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(couponNotUsedVo.getLoginUser() ==  null){
				return CommonResponseUtils.failureResponse("登录用户Id不能为空!");
			}
			if (couponNotUsedVo.getCouponName() == null || "".equals(couponNotUsedVo.getCouponName())) {
				return CommonResponseUtils.failureResponse("优惠券名称不能为空!");
			}
			if (couponNotUsedVo.getCouponIsDisplay() == null) {
				return CommonResponseUtils.failureResponse("优惠券名称是否展示不能为空!");
			}
			if (couponNotUsedVo.getStartTime() == null || "".equals(couponNotUsedVo.getStartTime())) {
				return CommonResponseUtils.failureResponse("有效开始时间不能为空!");
			}
			if (couponNotUsedVo.getEndTime() == null || "".equals(couponNotUsedVo.getEndTime())) {
				return CommonResponseUtils.failureResponse("有效结束时间不能为空!");
			}
			if (couponNotUsedVo.getCouponType() == null) {
				return CommonResponseUtils.failureResponse("优惠券类型不能为空!");
			}
			if (couponNotUsedVo.getCouponType() == 1) {
				if (couponNotUsedVo.getMinimumAmount() == null) {
					return CommonResponseUtils.failureResponse("满送金额不能为空!");
				}
			}
			if (couponNotUsedVo.getCouponAmount() == null) {
				return CommonResponseUtils.failureResponse("优惠金额不能为空!");
			}
			if (couponNotUsedVo.getIssuingScope() == null) {
				return CommonResponseUtils.failureResponse("发放范围不能为空!");
			}
			if (couponNotUsedVo.getIssuingScope() == 3) {
				if (couponNotUsedVo.getRedeemCode() == null || "".equals(couponNotUsedVo.getRedeemCode())) {
					return CommonResponseUtils.failureResponse("兑换码不能为空!");
				}
			}
			return couponAutoService.addCoupon(couponNotUsedVo);
		} catch (Exception e) {
			logger.info("===============>>>>>>>>>>>>>新建优惠券失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("新建优惠券失败!"));
		}
		return map;
	}

	/**
	 * 更新优惠券
	 * 
	 * @param couponNotUsedVo
	 * @return
	 */
	@RequestMapping(value = "updateCoupon")
	@ResponseBody
	public Map<String, Object> updateCoupon(CouponNotUsedVo couponNotUsedVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(couponNotUsedVo.getLoginUser() ==  null){
				return CommonResponseUtils.failureResponse("登录用户Id不能为空!");
			}
			if (couponNotUsedVo.getCouponName() == null || "".equals(couponNotUsedVo.getCouponName())) {
				return CommonResponseUtils.failureResponse("优惠券名称不能为空!");
			}
			if (couponNotUsedVo.getCouponIsDisplay() == null) {
				return CommonResponseUtils.failureResponse("优惠券名称是否展示不能为空!");
			}
			if (couponNotUsedVo.getStartTime() == null || "".equals(couponNotUsedVo.getStartTime())) {
				return CommonResponseUtils.failureResponse("有效开始时间不能为空!");
			}
			if (couponNotUsedVo.getEndTime() == null || "".equals(couponNotUsedVo.getEndTime())) {
				return CommonResponseUtils.failureResponse("有效结束时间不能为空!");
			}
			if (couponNotUsedVo.getCouponType() == null) {
				return CommonResponseUtils.failureResponse("优惠券类型不能为空!");
			}
			if (couponNotUsedVo.getCouponType() == 1) {
				if (couponNotUsedVo.getMinimumAmount() == null) {
					return CommonResponseUtils.failureResponse("满送金额不能为空!");
				}
			}
			if (couponNotUsedVo.getCouponAmount() == null) {
				return CommonResponseUtils.failureResponse("优惠金额不能为空!");
			}
			if (couponNotUsedVo.getIssuingScope() == null) {
				return CommonResponseUtils.failureResponse("发放范围不能为空!");
			}
			if (couponNotUsedVo.getIssuingScope() == 3) {
				if (couponNotUsedVo.getRedeemCode() == null || "".equals(couponNotUsedVo.getRedeemCode())) {
					return CommonResponseUtils.failureResponse("兑换码不能为空!");
				}
			}
			return couponAutoService.updateCoupon(couponNotUsedVo);
		} catch (Exception e) {
			logger.info("===============>>>>>>>>>>>>>更新优惠券失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("更新优惠券失败!"));
		}
		return map;
	}

	/**
	 * 编辑优惠券（查询）
	 * 
	 * @param couponId
	 * @return
	 */
	@RequestMapping(value = "editCoupon")
	@ResponseBody
	public Map<String, Object> editCoupon(Long couponId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (couponId == null) {
				return CommonResponseUtils.failureResponse("优惠券Id不能为空!");
			}
			return couponAutoService.editCoupon(couponId);
		} catch (Exception e) {
			logger.info("===============>>>>>>>>>>>>>编辑优惠券（查询）失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("编辑优惠券（查询）失败!"));
		}
		return map;
	}

	/**
	 * 删除优惠券
	 * 
	 * @param couponId
	 * @param loginUser
	 * @return
	 */
	@RequestMapping(value = "deleteCoupon")
	@ResponseBody
	public Map<String, Object> deleteCoupon(Long couponId, Long loginUser) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (couponId == null) {
				return CommonResponseUtils.failureResponse("优惠券Id不能为空!");
			}
			return couponAutoService.deleteCoupon(couponId, loginUser);
		} catch (Exception e) {
			logger.info("===============>>>>>>>>>>>>>优惠券删除失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("优惠券删除失败!"));
		}
		return map;
	}

	/**
	 * 优惠券列表（平台）
	 * 
	 * @param couponAutoVo
	 * @param type
	 *            1-所有优惠券，2-未开始，3-进行中，4-已结束
	 * @return
	 */
	@RequestMapping(value = "couponList")
	@ResponseBody
	public Map<String, Object> couponList(CouponAutoVo couponAutoVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (couponAutoVo.getType() == null) {
				return CommonResponseUtils.failureResponse("查询类型不能为空!");
			}
			return couponAutoService.couponList(couponAutoVo);
		} catch (Exception e) {
			logger.info("===============>>>>>>>>>>>>>优惠券删除失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("优惠券删除失败!"));
		}
		return map;
	}

	/**
	 * 兑换优惠券
	 * 
	 * @param code
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "exchangecode")
	@ResponseBody
	public Map<String, Object> exchangecode(String code, long userId) {

		try {
			if(code == null || "".equals(code)){
				return CommonResponseUtils.failureResponse("兑换码不能为空!");
			}
			
			return couponAutoService.exchange(code, userId);
		} catch (Exception e) {

			logger.info("兑换优惠券失败");
			e.printStackTrace();

		}

		return CommonResponseUtils.failureResponse("优惠券已经失效");
	}
}