package com.revbookstore.dao;

import java.util.List;

import com.revbookstore.dto.UserDTO;
import com.revbookstore.entity.User;

public interface UserDAO {

	boolean hasUsername(String username);

	long createUser(User user);

	User getUserById(long id);

	User getUserByUsername(String username);

	List<UserDTO> getAllUsers();

	void manageUser(long userId, String string);

}
