package com.ekene.coupon.dao;

import com.ekene.coupon.model.Coupon;
import com.ekene.coupon.model.Product;
import com.ekene.coupon.utility.ConnectionUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CouponDao {
    public static void main(String[] args) {
        CouponDao couponDao = new CouponDao();
        couponDao.printAll();
    }
    public int save(Coupon coupon){
        int result = 0;
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement pr = connection.prepareStatement("INSERT INTO coupon(code, discount, exp_date) VALUES (?, ?, ?)");
            pr.setString(1, coupon.getCode());
            pr.setBigDecimal(2, coupon.getDiscount());
            pr.setString(3, coupon.getExpDate());
            result = pr.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Coupon findByCode(String code) {
        Coupon coupon = new Coupon();
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM coupon WHERE code = ?");
            pr.setString(1, code);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()){
                coupon.setId(resultSet.getInt(1));
                coupon.setCode(resultSet.getString(2));
                coupon.setDiscount(resultSet.getBigDecimal(3));
                coupon.setExpDate(resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coupon;
    }

    public List<Coupon> printAll(){
        List<Coupon> couponList = new ArrayList<>();
        Coupon coupon = null;
        try(Connection connection = ConnectionUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, code, discount, exp_date FROM coupon");
        ){
            ResultSetMetaData metaData = resultSet.getMetaData();
            int count = metaData.getColumnCount();
            int id = 0;
            String code = "";
            BigDecimal discount = new BigDecimal(0.0);
            String exp_date = "";
            while (resultSet.next()){

                    coupon = new Coupon();
                    id = resultSet.getInt(1);
                    code = resultSet.getString(2);
                    discount = resultSet.getBigDecimal(3);
                    exp_date = resultSet.getString(4);


                    coupon.setId(id);
                    coupon.setCode(code);
                    coupon.setDiscount(discount);
                    coupon.setExpDate(exp_date);

                System.out.println(id + " " + code + " " + discount + " " + exp_date);
                couponList.add(coupon);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        couponList.forEach(System.out::println);
        return couponList;
    }
}
