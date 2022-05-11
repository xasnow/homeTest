package com.xasnow.celue2;

/**
 * @author xasnow
 * @Date 2020/5/20
 */
public class Sheep implements Animal {
    @Override
    public void eat(String food) {
        System.out.println("我是绵羊，也需要" + food);
    }
}
