package com.xasnow;

import java.util.ArrayList;
import java.util.Collections;

public class SwapDemo {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        Collections.swap(list, 0, 1);
        System.out.println(list);
    }

}
