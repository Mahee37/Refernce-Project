package com.revbookstore.service;

import java.util.List;

import com.revbookstore.dto.ProductManagementDTO;
import com.revbookstore.dto.UserDTO;

public interface AdminService {

	List<UserDTO> getAllUsers();

	void blockUser(long userId);

	void deleteUser(long userId);

	void activateUser(long userId);

	List<ProductManagementDTO> getAllProducts();

}
