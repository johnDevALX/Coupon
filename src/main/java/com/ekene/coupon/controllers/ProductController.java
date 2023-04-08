package com.ekene.coupon.controllers;

import com.ekene.coupon.model.Coupon;
import com.ekene.coupon.model.Product;
import com.ekene.coupon.services.CouponService;
import com.ekene.coupon.services.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String couponCode = request.getParameter("couponCode");
        CouponService couponService = new CouponService();
        ProductService productService = new ProductService();
        Coupon coupon = couponService.findCoupon(couponCode);

        Product product = new Product();
        product.setName(productName);
        product.setDesc(description);
        product.setPrice(new BigDecimal(price).subtract(coupon.getDiscount()));
        productService.createProduct(product);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<b>Product Created</b>");
        out.println("<br/> <a href='CandP.jsp'>Home</a>");
    }
}
