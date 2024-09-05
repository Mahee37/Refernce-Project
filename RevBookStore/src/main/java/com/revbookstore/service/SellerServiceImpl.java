package com.revbookstore.service;

import java.util.List;

import com.revbookstore.dao.OrderDAO;
import com.revbookstore.dao.ProductDao;
import com.revbookstore.dao.RetailerDAO;
import com.revbookstore.dao.ReviewDAO;
import com.revbookstore.dto.ProductOrderDetail;
import com.revbookstore.dto.ProductReview;
import com.revbookstore.entity.Product;
import com.revbookstore.entity.Retailer;
import com.revbookstore.util.DAOFactory;

public class SellerServiceImpl implements SellerService {

	private ProductDao productDao;
	private OrderDAO orderDAO;
	private ReviewDAO reviewDAO;
	private RetailerDAO retailerDAO;

	public SellerServiceImpl(DAOFactory factory) {
		productDao = factory.getProductDAO();
		orderDAO = factory.getOrderDAO();
		reviewDAO = factory.getReviewDAO();
		retailerDAO = factory.getRetailerDAO();
	}

	@Override
	public List<Product> getProducts(Long id) {
		return productDao.getProductsByRetailer(id);
	}

	@Override
	public boolean addProduct(Long id, Product p) {
		return productDao.addProduct(id, p);
	}

	@Override
	public Product getProduct(Long sellerId, long pId) {
		return productDao.getProduct(sellerId, pId);
	}

	@Override
	public boolean updateProduct(Long id, Product p) {
		return productDao.updateProduct(id, p);
	}

	@Override
	public void deleteProduct(Long sellerId, long productId) {
		productDao.deleteProduct(sellerId, productId);
	}

	@Override
	public List<ProductOrderDetail> getOrders(Long id) {
		return orderDAO.getSellerOrders(id);
	}

	@Override
	public boolean updateOrderStatus(Long sellerId, long orderId, long productId, String status) {
		return orderDAO.updateProductOrderStatus(sellerId, orderId, productId, status);
	}

	@Override
	public List<ProductReview> getProductReviews(Long id) {
		return reviewDAO.getProductReviews(id);
	}

	@Override
	public Retailer getProfile(Long uid) {
		// TODO Auto-generated method stub
		return retailerDAO.getProfile(uid);
	}

	@Override
	public void updateProfile(Retailer retailer) {
		retailerDAO.updateProfile(retailer);

	}

}
