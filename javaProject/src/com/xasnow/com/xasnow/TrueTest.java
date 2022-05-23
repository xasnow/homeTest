package com.xasnow;

public class TrueTest {
    public static void main(String[] args) {
        int i = 1;
        while (true) {
            if (i % 100 == 0) {
                System.out.println(i++);
            }
            i++;
        }
    }
}
