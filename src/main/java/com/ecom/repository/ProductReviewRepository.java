package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {

	public List<ProductReview> findByProductId(Integer productId);

	public ProductReview findByProductIdAndUserId(Integer productId, Integer userId);

}
