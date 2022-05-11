package com.xasnow;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.trimToSize();
        list.add(3);
        System.out.println(list);

        Collections.swap(list, 1, 2);
        System.out.println(list
        );
    }
}
