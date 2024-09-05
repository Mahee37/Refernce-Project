package com.revbookstore.service;

import java.util.List;

import com.revbookstore.dto.CartItem;

public interface CartService {
    boolean addToCart(long userId, long productId);

    List<CartItem> getCart(long userId);

    boolean checkoutCart(Long userId, String city, String address, String pincode, String phoneNumber,
                         String paymentMethod);

    boolean deleteCart(Long uid, long pid);

    void updateCartProductQuantity(Long uid, long pid, int quantity);

}
