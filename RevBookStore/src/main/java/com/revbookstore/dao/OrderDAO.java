package com.revbookstore.dao;

import java.util.List;

import com.revbookstore.dto.ProductOrderDetail;
import com.revbookstore.entity.Order;
import com.revbookstore.entity.OrderedProduct;

public interface OrderDAO {

	List<Order> getBuyerOrders(long userId);

	Order getOrderDetails(long userId, long orderId);

	List<OrderedProduct> getOrderedProducts(long userId, long orderId);

	List<ProductOrderDetail> getSellerOrders(Long id);

	boolean updateProductOrderStatus(Long sellerId, long orderId, long productId, String status);

}
