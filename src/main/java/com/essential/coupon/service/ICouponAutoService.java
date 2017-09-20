package com.essential.coupon.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.coupon.model.auto.CouponAuto;
import com.essential.coupon.model.vo.CouponAutoVo;
import com.essential.coupon.model.vo.CouponNotUsedVo;

/**
 * 优惠券接口
 * 
 * @author czm
 *
 */
@Service
public interface ICouponAutoService {
	// 未使用的优惠券
	public Map<String, Object> queryCouponNotUsed(CouponAutoVo couponAutoVo);

	// 已失效的优惠券
	public Map<String, Object> queryCouponHasFailed(CouponAutoVo couponAutoVo);

	// 新建优惠券
	public Map<String, Object> addCoupon(CouponNotUsedVo couponNotUsedVo);

	// 更新优惠券
	public Map<String, Object> updateCoupon(CouponNotUsedVo couponNotUsedVo);

	// 编辑优惠券（查询）
	public Map<String, Object> editCoupon(Long couponId);

	// 删除优惠券
	public Map<String, Object> deleteCoupon(Long couponId, Long loginUser);

	// 优惠券列表（平台）
	public Map<String, Object> couponList(CouponAutoVo couponAutoVo);

	// 兑换优惠券(手机端)
	public Map<String, Object> exchange(String code, long userId);
}
