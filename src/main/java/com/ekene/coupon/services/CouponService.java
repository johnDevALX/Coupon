package com.ekene.coupon.services;

import com.ekene.coupon.dao.CouponDao;
import com.ekene.coupon.model.Coupon;

import java.util.List;

public class CouponService {
    CouponDao couponDao = new CouponDao();
    public void saveCoupon(Coupon coupon){
        couponDao.save(coupon);
        System.out.println("Coupon Saved In Database Successfully");
    }

    public Coupon findCoupon(String code){
        Coupon coupon = couponDao.findByCode(code);
        System.out.println(coupon);
        System.out.println("Coupon Found In Database Successfully");
        return coupon;
    }
    public List<Coupon> printAll(){
        return couponDao.printAll();
    }
}
