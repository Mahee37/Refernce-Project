package com.revbookstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.revbookstore.dao.BuyerDAO;
import com.revbookstore.entity.Buyer;
import com.revbookstore.util.DataSource;

public class DatabaseBuyerDAO implements BuyerDAO {

	private DataSource dataSource;

	public DatabaseBuyerDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void createBuyer(Buyer buyer) {
		try (var con = dataSource.getConnection()) {
			String query = "INSERT INTO buyers (user_id, pincode, phone_number) VALUES (?, ?, ?)";
			var stmt = con.prepareStatement(query);
			stmt.setLong(1, buyer.getUserId());
			stmt.setInt(2, buyer.getPincode());
			stmt.setString(3, buyer.getPhoneNumber());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Buyer getBuyerByUserId(long userId) {
		try (var con = dataSource.getConnection()) {
			String query = "SELECT * FROM buyers WHERE user_id = ?";
			var stmt = con.prepareStatement(query);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Buyer b = new Buyer();
				b.setId(rs.getLong("id"));
				b.setUserId(rs.getLong("user_id"));
				b.setPincode(rs.getInt("pincode"));
				b.setPhoneNumber(rs.getString("phone_number"));
				return b;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
