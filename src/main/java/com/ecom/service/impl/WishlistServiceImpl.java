package com.ecom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ecom.model.Product;
import com.ecom.model.UserDtls;
import com.ecom.model.Wishlist;
import com.ecom.repository.ProductRepository;
import com.ecom.repository.UserRepository;
import com.ecom.repository.WishlistRepository;
import com.ecom.service.WishlistService;

@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private WishlistRepository wishlistRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Wishlist saveWishlist(Integer productId, Integer userId) {
		UserDtls userDtls = userRepository.findById(userId).get();
		Product product = productRepository.findById(productId).get();

		Wishlist existing = wishlistRepository.findByProductIdAndUserId(productId, userId);
		if (!ObjectUtils.isEmpty(existing)) {
			return existing;
		}

		Wishlist wishlist = new Wishlist();
		wishlist.setProduct(product);
		wishlist.setUser(userDtls);
		return wishlistRepository.save(wishlist);
	}

	@Override
	public List<Wishlist> getWishlistsByUser(Integer userId) {
		return wishlistRepository.findByUserId(userId);
	}

	@Override
	public void removeWishlist(Integer id) {
		Wishlist wishlist = wishlistRepository.findById(id).orElse(null);
		if(wishlist != null) {
			wishlistRepository.delete(wishlist);
		}
	}

}
