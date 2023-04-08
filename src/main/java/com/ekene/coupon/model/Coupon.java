package com.ekene.coupon.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;
@Getter
@Setter
public class Coupon {
    private int id;
    private String code;
    private BigDecimal discount;
    private String expDate;

    @Override
    public String toString() {
        return "<h2>Coupon Details</h2> " +
                "Coupon id: " + id +
                "<br/> code: " + code  +
                "<br/> discount: " + discount +
                "<br/> expDate: " + expDate +
                "<br/>";
    }
}
