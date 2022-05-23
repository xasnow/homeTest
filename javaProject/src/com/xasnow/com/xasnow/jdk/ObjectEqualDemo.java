package com.xasnow.jdk;

import java.util.Objects;

/**
 * @author xasnow
 * @Date 2020/1/1
 */
public class ObjectEqualDemo {
    public static void main(String[] args) {
        ObjectEqualDemo objectEqualDemo = new ObjectEqualDemo();
        ObjectEqualDemo objectEqualDemo2 = new ObjectEqualDemo();
        boolean equals = Objects.equals(objectEqualDemo, objectEqualDemo2);
        System.out.println(equals); //false
        boolean equals2 = Objects.equals(objectEqualDemo, objectEqualDemo);
        System.out.println(equals2); //true
    }
}
