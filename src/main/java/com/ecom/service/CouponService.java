package com.ecom.service;

import java.util.List;

import com.ecom.model.Coupon;

public interface CouponService {

	public Coupon saveCoupon(Coupon coupon);

	public List<Coupon> getAllCoupons();

	public Coupon getCouponByCode(String code);

	public void deleteCoupon(Integer id);

}
