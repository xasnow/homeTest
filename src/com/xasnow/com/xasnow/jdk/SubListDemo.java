package com.xasnow.jdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xasnow
 * @Date 2020/1/1
 */
public class SubListDemo {
    public static void main(String[] args) {


        List<String> list = new ArrayList<String>(2);
        list.add("guan");
        list.add("bao");
        String[] array = new String[list.size()];
        array = list.toArray(array);
        String s = Arrays.deepToString(array);
        System.out.println(s);

        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if ("2".equals(temp)) {
                System.out.println(temp);
                a.remove(temp);
            }
        }


    }
}
