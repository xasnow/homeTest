package com.xasnow.celue2;

/**
 * @author xasnow
 * @Date 2020/5/20
 */
public class Zoo {
    private Animal animal;

    public Zoo(Animal animal) {
        this.animal = animal;
    }

    public void privateFood(String food) {
        animal.eat(food);
    }
}
