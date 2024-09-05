package com.revbookstore.service;

import com.revbookstore.dao.OrderDAO;
import com.revbookstore.dao.ProductDao;
import com.revbookstore.dao.ReviewDAO;
import com.revbookstore.dao.ShappingCartDAO;
import com.revbookstore.dto.ProductReview;
import com.revbookstore.entity.*;
import com.revbookstore.util.DAOFactory;

import java.util.List;
import java.util.Optional;

public class BuyerServiceImpl implements BuyerService {

	private ProductDao productDao;
	private ReviewDAO reviewDAO;
	private ShappingCartDAO shappingCartDAO;
	private OrderDAO orderDAO;
 
	public BuyerServiceImpl(DAOFactory daoFactory) {
		productDao = daoFactory.getProductDAO();
		reviewDAO = daoFactory.getReviewDAO();
		shappingCartDAO = daoFactory.getShappingCartDAO();
		orderDAO = daoFactory.getOrderDAO();
	}

	@Override
	public List<Product> getProducts(String reqParameter, String category) {
		return productDao.findProducts(reqParameter, category);
	}

	@Override
	public Optional<Product> getProduct(long pId) {
		return productDao.getProduct(pId);
	}

	@Override
	public boolean addReview(Review review) {
		return reviewDAO.postReview(review) > 0;
	}

	@Override
	public List<ProductReview> getProductReviews(long id) {
		return reviewDAO.getProductReviews(id);
	}

	@Override
	public boolean isProductInCart(Long userId, long id) {
		return shappingCartDAO.isProductInCart(userId, id);
	}

	@Override
	public List<Order> getBuyerOrders(long userId) {
		return orderDAO.getBuyerOrders(userId);
	}

	@Override
	public Order getOrderDetails(long userId, long orderId) {
		return orderDAO.getOrderDetails(userId, orderId);
	}

	@Override
	public List<OrderedProduct> getOrderedProducts(long userId, long orderId) {
		return orderDAO.getOrderedProducts(userId, orderId);
	}

	@Override
	public List<String> getProductCategories() {
		return productDao.getCategories();
	}

	@Override
	public Retailer getRetailerInfo(long id) {
		return productDao.getRetailer(id);
	}

	@Override
	public List<Review> getBuyerProductReviews(Long uid) {
		return reviewDAO.getBuyerProductReviews(uid);
	}

	@Override
	public void deleteReview(long rId, long userId) {
		reviewDAO.deleteReview(rId, userId);
	}
}
