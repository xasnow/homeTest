package utils;

import Steam.Student;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wucheng
 * @Date 2020/8/30
 */
public class DictMap {
    public static void main(String[] args) {
        Student zhang = new Student("1", "zhang", new BigDecimal(10));
        Student li = new Student("1", "li", new BigDecimal(20));
        Student wang = new Student("1", "wang", null);
        List<Student> students = Arrays.asList(zhang, li, wang);
        List<Dict> collect = students.stream().map(x -> {
            Dict dict = new Dict();
            dict.setKey(x.getId());
            dict.setValue(x.getName());
            return dict;
        }).collect(Collectors.toList());

        System.out.println(collect);
    }
}
