package com.ecom.service;

import java.util.List;

import com.ecom.model.Wishlist;

public interface WishlistService {

	public Wishlist saveWishlist(Integer productId, Integer userId);

	public List<Wishlist> getWishlistsByUser(Integer userId);

	public void removeWishlist(Integer id);

}
