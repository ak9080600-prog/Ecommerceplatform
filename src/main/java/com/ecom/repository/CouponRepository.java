package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	public Coupon findByCodeAndIsActiveTrue(String code);

}
