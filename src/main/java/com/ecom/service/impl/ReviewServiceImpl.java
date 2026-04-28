package com.ecom.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.model.Product;
import com.ecom.model.ProductReview;
import com.ecom.model.UserDtls;
import com.ecom.repository.ProductRepository;
import com.ecom.repository.ProductReviewRepository;
import com.ecom.repository.UserRepository;
import com.ecom.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ProductReviewRepository reviewRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductReview saveReview(Integer productId, Integer userId, Integer rating, String reviewText) {
		UserDtls userDtls = userRepository.findById(userId).get();
		Product product = productRepository.findById(productId).get();

		ProductReview existingReview = reviewRepository.findByProductIdAndUserId(productId, userId);
		
		if (existingReview != null) {
			existingReview.setRating(rating);
			existingReview.setReviewText(reviewText);
			existingReview.setReviewDate(new Date());
			return reviewRepository.save(existingReview);
		}

		ProductReview review = new ProductReview();
		review.setProduct(product);
		review.setUser(userDtls);
		review.setRating(rating);
		review.setReviewText(reviewText);
		review.setReviewDate(new Date());

		return reviewRepository.save(review);
	}

	@Override
	public List<ProductReview> getReviewsByProduct(Integer productId) {
		return reviewRepository.findByProductId(productId);
	}

}
