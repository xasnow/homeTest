package com.xasnow.celue3;

/**
 * @author xasnow
 * @Date 2020/5/20
 */
public class Main {
    public static void main(String[] args) {
        Road road = new Road();
        road.setTravel(new Train());
        road.forChooseMethod();
    }
}
