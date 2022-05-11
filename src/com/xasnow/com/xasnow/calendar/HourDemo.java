package com.xasnow.calendar;

import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @author wucheng
 * @Date 2020/9/2
 */
public class HourDemo {

    @Test
    public void getHour(){
        int hour = LocalDateTime.now().getHour();
        System.out.println(hour);

    }

    @Test
    public void compareTime(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime localDateTime = now.plusHours(1);
        System.out.println(localDateTime);
        boolean before = now.plusHours(1).isAfter(now);
        System.out.println(before);
    }
}
