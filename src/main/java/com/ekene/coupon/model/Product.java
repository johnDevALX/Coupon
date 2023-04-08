package com.ekene.coupon.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;
@Getter
@Setter
@ToString
public class Product {
    private int id;
    private String name;
    private String desc;
    private BigDecimal price;
    private String couponCode;
}
