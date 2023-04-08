package com.ekene.coupon.dao;

import com.ekene.coupon.model.Product;
import com.ekene.coupon.utility.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDao {
    public int save(Product product){
        int result = 0;
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement pr = connection.prepareStatement("INSERT INTO product(name, description, price) VALUES (?, ?, ?)");
            pr.setString(1, product.getName());
            pr.setString(2, product.getDesc());
            pr.setBigDecimal(3, product.getPrice());
            result = pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
