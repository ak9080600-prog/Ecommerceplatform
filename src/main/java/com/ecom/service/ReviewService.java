package com.ecom.service;

import java.util.List;

import com.ecom.model.ProductReview;

public interface ReviewService {

	public ProductReview saveReview(Integer productId, Integer userId, Integer rating, String reviewText);

	public List<ProductReview> getReviewsByProduct(Integer productId);

}
