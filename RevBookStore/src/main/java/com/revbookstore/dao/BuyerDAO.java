package com.revbookstore.dao;

import com.revbookstore.entity.Buyer;

public interface BuyerDAO {
	void createBuyer(Buyer buyer);

	Buyer getBuyerByUserId(long userId);
}
