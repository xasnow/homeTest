package com.xasnow.decimal;

import java.math.BigDecimal;

/**
 * @author wucheng
 * @Date 2020/9/2
 */
public class BigDecimalDemol {
    public static void main(String[] args) {
        BigDecimal e = BigDecimal.ZERO;
        e.setScale(3);
        BigDecimal add = e.add(new BigDecimal(10.1));
        System.out.println(add);

        BigDecimal multiply = new BigDecimal(100).multiply(null);
        System.out.println(multiply);
        System.out.println(111111111);
        System.out.println(multiply);

    }
}
