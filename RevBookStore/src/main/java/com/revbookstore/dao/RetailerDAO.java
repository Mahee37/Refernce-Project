package com.revbookstore.dao;

import com.revbookstore.entity.Retailer;

public interface RetailerDAO {

	void createRetailer(Retailer s);

	Retailer getProfile(Long uid);

	void updateProfile(Retailer retailer);

}
