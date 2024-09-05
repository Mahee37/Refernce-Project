package com.revbookstore.service;

import com.revbookstore.entity.Buyer;
import com.revbookstore.entity.Retailer;
import com.revbookstore.entity.User;

public interface AuthenticationService {

	boolean hasUsername(String username);

	void createBuyer(Buyer buyer);

	long createUser(User user);

	User authenticate(String username, String password);

	void createRetailer(Retailer s);

}
