package com.xasnow.jdk;

/**
 * @author xasnow
 * @Date 2020/2/26
 */

import java.util.regex.*;

class RegexExample1 {
    public static void main(String args[]) {
        String content = "192.178.12.123";

        String pattern = "(\\d+)$";

//        boolean isMatch = Pattern.matches(pattern, content);
        Pattern compile = Pattern.compile(pattern);
        Matcher matches = compile.matcher(content);
        if (matches.find()) {
            String group = matches.group(1);
        } else {

        }
        boolean isExist = matches.find();
        String group = matches.group(1);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + group);
    }
}