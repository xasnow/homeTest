package com.xasnow.celue2;

/**
 * @author xasnow
 * @Date 2020/5/20
 */
public class Tiger implements Animal {
    @Override
    public void eat(String food) {
        System.out.println("我是老虎，我需要" + food);
    }
}
