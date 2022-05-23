package com.xasnow.celue;

/**
 * @author xasnow
 * @Date 2020/5/20
 */
public class DealSina implements DealStrategy {
    @Override
    public void dealMythod(String option) {
        System.out.println("我是新浪" + option);
    }
}
