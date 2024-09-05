package com.revbookstore.dao;

import java.util.List;

import com.revbookstore.dto.ProductReview;
import com.revbookstore.entity.Review;

public interface ReviewDAO {

	int postReview(Review review);

	List<ProductReview> getProductReviews(long id);

	List<Review> getBuyerProductReviews(Long uid);

	void deleteReview(long pid, long userId);

}
