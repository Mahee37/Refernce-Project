package com.revbookstore.service;

import java.util.List;

import com.revbookstore.dao.ProductDao;
import com.revbookstore.dao.UserDAO;
import com.revbookstore.dto.ProductManagementDTO;
import com.revbookstore.dto.UserDTO;
import com.revbookstore.util.DAOFactory;

public class AdminServiceImpl implements AdminService {

	private UserDAO userDao;
	private ProductDao productDao;

	public AdminServiceImpl(DAOFactory instance) {
		// TODO Auto-generated constructor stub
		userDao = instance.getUserDAO();
		productDao = instance.getProductDAO();
	}

	@Override
	public List<UserDTO> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public void blockUser(long userId) {
		userDao.manageUser(userId, "BLOCK");
	}

	@Override
	public void deleteUser(long userId) {
		userDao.manageUser(userId, "DELETE");
	}

	@Override
	public void activateUser(long userId) {
		userDao.manageUser(userId, "ACTIVE");

	}

	@Override
	public List<ProductManagementDTO> getAllProducts() {
		return productDao.getAllProductsForAdmin();
	}

}
