package com.ecom.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.model.Coupon;
import com.ecom.repository.CouponRepository;
import com.ecom.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponRepository;

	@Override
	public Coupon saveCoupon(Coupon coupon) {
		return couponRepository.save(coupon);
	}

	@Override
	public List<Coupon> getAllCoupons() {
		return couponRepository.findAll();
	}

	@Override
	public Coupon getCouponByCode(String code) {
		Coupon coupon = couponRepository.findByCodeAndIsActiveTrue(code);
		if (coupon != null && coupon.getExpiryDate().after(new Date())) {
			return coupon;
		}
		return null;
	}

	@Override
	public void deleteCoupon(Integer id) {
		Coupon coupon = couponRepository.findById(id).orElse(null);
		if (coupon != null) {
			couponRepository.delete(coupon);
		}
	}

}
