package com.xasnow.celue3;

/**
 * @author xasnow
 * @Date 2020/5/20
 */
public class Road {
    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    private Travel travel;


    void forChooseMethod() {
        travel.chooseMethod();
    }
}
