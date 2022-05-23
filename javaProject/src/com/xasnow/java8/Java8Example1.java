package java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wucheng
 * @Date 2020/7/25
 */
public class Java8Example1 {

    public static void main(String[] args) {

        List<String> items = Arrays.asList(
                "apple", "apple",
                "orange", "orange", "orange",
                "blueberry",
                "peach", "peach", "peach", "peach"
        );

        // 分组，计数
        Map<String, Long> result = items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);

        Map<String, Long> finalMap = new LinkedHashMap<>();
        // 排序
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);
    }
}
