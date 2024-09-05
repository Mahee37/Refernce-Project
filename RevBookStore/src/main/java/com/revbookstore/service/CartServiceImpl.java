package com.revbookstore.service;

import com.revbookstore.dao.ShappingCartDAO;
import com.revbookstore.dto.CartItem;
import com.revbookstore.util.DAOFactory;

import java.util.LinkedList;

public class CartServiceImpl implements CartService {
    private ShappingCartDAO shappingCartDAO;

    public CartServiceImpl(DAOFactory daoFactory) {
        shappingCartDAO = daoFactory.getShappingCartDAO();
    }

    @Override
    public boolean deleteCart(Long uid, long pid) {
        return shappingCartDAO.deleteCart(uid, pid);
    }

    @Override
    public void updateCartProductQuantity(Long uid, long pid, int quantity) {
        shappingCartDAO.updateProductQuantity(uid, pid, quantity);
    }

    @Override
    public boolean addToCart(long userId, long productId) {
        return shappingCartDAO.addProduct(userId, productId) > 0;
    }

    @Override
    public LinkedList<CartItem> getCart(long userId) {
        return shappingCartDAO.getCartItemsForUserId(userId);
    }

    @Override
    public boolean checkoutCart(Long userId, String city, String address, String pincode, String phoneNumber,
                                String paymentMethod) {
        return shappingCartDAO.checkoutCart(userId, city, address, pincode, phoneNumber, paymentMethod);

    }
}
