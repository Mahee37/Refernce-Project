package com.revbookstore.util;

import java.sql.DriverManager;

import com.revbookstore.dao.*;
import com.revbookstore.dao.impl.*;

public class DatabaseDAOFactory extends DAOFactory {
    private DataSource dataSource = () -> {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/revshop1", "root", "root");
    };

    DatabaseDAOFactory() {

    }

    @Override
    public ProductDao getProductDAO() {
        return new DatabaseProductDAO(dataSource);
    }

    @Override
    public UserDAO getUserDAO() {
        return new DatabaseUserDAO(dataSource);
    }

    @Override
    public BuyerDAO getBuyerDAO() {
        return new DatabaseBuyerDAO(dataSource);
    }

    @Override
    public ReviewDAO getReviewDAO() {
        return new DatabaseReviewDAO(dataSource);
    }

    @Override
    public ShappingCartDAO getShappingCartDAO() {
        return new DatabaseCartDAO(dataSource);
    }

    @Override
    public OrderDAO getOrderDAO() {
        return new DatabaseOrderDAO(dataSource);
    }

    @Override
    public RetailerDAO getRetailerDAO() {
        return new DatabaseRetailerDAO(dataSource);
    }
}
