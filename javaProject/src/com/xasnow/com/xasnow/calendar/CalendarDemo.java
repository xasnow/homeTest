package com.xasnow.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author xasnow
 * @Date 2020/1/14
 */
public class CalendarDemo {
    public static void main(String[] args) {
        String yyyyMMddHHmmss = ormatTime("yyyyMMddHHmmss");
        System.out.printf(yyyyMMddHHmmss);
    }


    public static String ormatTime(String format) {

        Calendar calendar = Calendar.getInstance();
        DateFormat df3 = new SimpleDateFormat("yyyyMMddhhmmssSSSSSS");
        String nowdatetime = null;
        if (format.equals("timestamp")) {
            nowdatetime = df3.format(calendar.getTime());
        } else if (format.equals("long")) {
            nowdatetime = String.valueOf(calendar.getTimeInMillis() / 1000);
        } else {
            DateFormat df = new SimpleDateFormat(format);
            nowdatetime = df.format(calendar.getTime());
        }
        return nowdatetime;
    }
}
