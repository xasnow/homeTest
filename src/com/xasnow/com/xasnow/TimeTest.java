package com.xasnow;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xasnow
 * @Date 2020/2/27
 */
public class TimeTest {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowFormatDate = sdf.format(date);
        StringBuilder valueBuilder = new StringBuilder(300);
        String insertAgentSql = valueBuilder.append("INSERT INTO AIM_AGENT(REGID, NAME, DESP, AGENTTYPE, IP, INSTANCE, INSTIME, LSRPORT, INSTUSER, MONITER, NOTE1, PLATNAME, AGENTSTATUS) VALUES")
                .append("('52','").append("agentname").append("','").append("agentname").append("','0','").append("192.123.12.12").append("','1','").append(nowFormatDate).append("','9004','1','1','1','AESB','1')").toString();
        System.out.println(insertAgentSql);


    }
}
