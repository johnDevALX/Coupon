package com.ekene.coupon.controllers;

import com.ekene.coupon.model.Coupon;
import com.ekene.coupon.services.CouponService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "CouponController", value = "/CouponController")
public class CouponController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
    private CouponService couponService = new CouponService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("create")){
            createCoupon(request, response);
        } else if (action.equals("find")) {
            findCoupon(request, response);
        }
    }

    private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String couponCode = request.getParameter("couponCode");
        String discount = request.getParameter("discount");
        String expiryDate = request.getParameter("expiryDate");

        Coupon coupon = new Coupon();
        coupon.setCode(couponCode);
        coupon.setDiscount(new BigDecimal(discount));
        coupon.setExpDate(expiryDate);
        couponService.saveCoupon(coupon);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<b>Coupon Created</b>");
        out.println("<br/> <a href='CandP.jsp'>Home</a>");
    }

    private void findCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String couponCode = request.getParameter("couponCode");
        Coupon coupon = couponService.findCoupon(couponCode);
        List<Coupon> couponList = couponService.printAll();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<b>Coupon Details</b>");
        out.println(coupon);
        for (Coupon coupon1: couponList) {
            out.println(coupon1);
        }
        out.println("<br/> <a href='CandP.jsp'>Home</a>");
    }
}
