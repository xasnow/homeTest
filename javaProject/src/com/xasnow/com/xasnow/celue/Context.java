package com.xasnow.celue;

/**
 * @author xasnow
 * @Date 2020/5/20
 */
public class Context {
    private DealStrategy dealStrategy;

    public Context(DealStrategy dealStrategy) {
        this.dealStrategy = dealStrategy;
    }


    public void executeStrategy(String option) {
        dealStrategy.dealMythod(option);
    }
}
