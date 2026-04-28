package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

	public List<Wishlist> findByUserId(Integer userId);

	public Wishlist findByProductIdAndUserId(Integer productId, Integer userId);

}
