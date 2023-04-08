package com.ekene.coupon.services;

import com.ekene.coupon.dao.ProductDao;
import com.ekene.coupon.model.Product;

public class ProductService {
    ProductDao productDao = new ProductDao();
    public void createProduct(Product product){
        productDao.save(product);
        System.out.println("Product Saved In Database Successfully");
    }
}
