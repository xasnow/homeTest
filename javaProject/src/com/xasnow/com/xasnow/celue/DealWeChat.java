package com.xasnow.celue;

/**
 * @author xasnow
 * @Date 2020/5/20
 */
public class DealWeChat implements DealStrategy {
    @Override
    public void dealMythod(String option) {
        System.out.println("我是微信" + option);
    }
}
