package com.xasnow.celue;

/**
 * @author xasnow
 * @Date 2020/5/20
 */
public class Main {
    public static void main(String[] args) {
        String model = "-----传递的公共模板内容";
        Context context = new Context(new DealSina());
        context.executeStrategy(model);

        Context context1 = new Context(new DealWeChat());
        context1.executeStrategy(model);
    }
}
