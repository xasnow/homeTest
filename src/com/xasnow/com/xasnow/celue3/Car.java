package com.xasnow.celue3;

/**
 * @author xasnow
 * @Date 2020/5/20
 */
public class Car implements Travel {
    @Override
    public void chooseMethod() {
        System.out.println("自驾出行。。。");
    }
}
