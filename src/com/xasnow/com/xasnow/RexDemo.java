package com.xasnow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xasnow
 * @Date 2020/3/6
 */
public class RexDemo {
    public static void main(String[] args) {

        String str = "[{\"description\":\"成功码\", \"pid\":\"1\", \"id\":\"2\", \"type\":\"success\", \"value\":\"S\"}, {\"description\":\"失败码\", \"pid\":\"1\", \"id\":\"3\", \"type\":\"failed\", \"value\":\"F\"},{\"description\":\"超时码\", \"pid\":\"1\", \"id\":\"4\", \"type\":\"timeout\", \"value\":\"O\"}, {\"description\":\"其他\",\"pid\":\"1\", \"id\":\"5\", \"type\":\"other\", \"value\":\"T\"}]\n";
        String pattern = "(\\{.*\\})";

        System.out.println(pattern);
        Pattern compile = Pattern.compile(pattern);
        Matcher matches = compile.matcher(str);
        String nameValue = "";
        if (matches.find()) {
            nameValue = matches.group(1);
            System.out.println(nameValue);
        }

        CharSequence sequence = str.subSequence(1, str.length() - 2);
        String s = sequence.toString();
        System.out.println(s);
    }
}
