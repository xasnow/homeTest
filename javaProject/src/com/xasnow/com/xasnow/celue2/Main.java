package com.xasnow.celue2;

/**
 * @author xasnow
 * @Date 2020/5/20
 */
public class Main {
    public static void main(String[] args) {
        String food = "吃饭，睡觉";
        Zoo zoo = new Zoo(new Tiger());
        zoo.privateFood(food);

        Zoo zoo2 = new Zoo(new Sheep());
        zoo2.privateFood(food);
    }
}
