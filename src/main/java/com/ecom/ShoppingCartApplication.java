package com.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

	@org.springframework.context.annotation.Bean
	public org.springframework.boot.CommandLineRunner initData(com.ecom.service.UserService userService, com.ecom.service.CouponService couponService) {
		return args -> {
			if(couponService.getAllCoupons().isEmpty()) {
				com.ecom.model.Coupon coupon = new com.ecom.model.Coupon();
				coupon.setCode("WELCOME20");
				coupon.setDiscountPercentage(20.0);
				// Set expiry to 30 days from now
				java.util.Calendar cal = java.util.Calendar.getInstance();
				cal.add(java.util.Calendar.DAY_OF_MONTH, 30);
				coupon.setExpiryDate(cal.getTime());
				coupon.setIsActive(true);
				couponService.saveCoupon(coupon);
			}

			if (!userService.existsEmail("admin@gmail.com")) {
				com.ecom.model.UserDtls admin = new com.ecom.model.UserDtls();
				admin.setName("Admin User");
				admin.setEmail("admin@gmail.com");
				admin.setMobileNumber("1234567890");
				admin.setPassword("admin123");
				admin.setAddress("Admin Address");
				admin.setCity("Admin City");
				admin.setState("Admin State");
				admin.setPincode("123456");
				admin.setProfileImage("ecom.png");
				userService.saveAdmin(admin);
			}
			if (!userService.existsEmail("user@gmail.com")) {
				com.ecom.model.UserDtls user = new com.ecom.model.UserDtls();
				user.setName("Normal User");
				user.setEmail("user@gmail.com");
				user.setMobileNumber("0987654321");
				user.setPassword("user123");
				user.setAddress("User Address");
				user.setCity("User City");
				user.setState("User State");
				user.setPincode("654321");
				user.setProfileImage("ecom.png");
				userService.saveUser(user);
			}
		};
	}

}
