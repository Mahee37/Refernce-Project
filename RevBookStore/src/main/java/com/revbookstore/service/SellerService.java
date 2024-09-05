package com.revbookstore.service;

import java.util.List;

import com.revbookstore.dto.ProductOrderDetail;
import com.revbookstore.dto.ProductReview;
import com.revbookstore.entity.Product;
import com.revbookstore.entity.Retailer;

public interface SellerService {

	List<Product> getProducts(Long id);

	boolean addProduct(Long id, Product p);

	Product getProduct(Long sellerId, long pId);

	boolean updateProduct(Long id, Product p);

	void deleteProduct(Long sellerId, long productId);

	List<ProductOrderDetail> getOrders(Long id);

	boolean updateOrderStatus(Long id, long orderId, long productId, String status);

	List<ProductReview> getProductReviews(Long id);

	Retailer getProfile(Long uid);

	void updateProfile(Retailer retailer);

}
