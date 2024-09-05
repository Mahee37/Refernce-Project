package com.revbookstore.dao;

import java.util.List;
import java.util.Optional;

import com.revbookstore.dto.ProductManagementDTO;
import com.revbookstore.entity.Product;
import com.revbookstore.entity.Retailer;

public interface ProductDao {
	boolean addProduct(Long id, Product product);

	Optional<Product> getProduct(long id);

	List<Product> findProducts(String name, String category);

	List<Product> findProductsByCategory(String category);

	boolean deleteProduct(long id);

	boolean updateProduct(Long id, Product product);

	List<Product> getProductsByRetailer(Long id);

	Product getProduct(Long sellerId, long pId);

	void deleteProduct(Long sellerId, long productId);

	List<ProductManagementDTO> getAllProductsForAdmin();

	List<String> getCategories();

	Retailer getRetailer(long id);
}
