package java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wucheng
 * @Date 2020/7/25
 */
public class Java8Example3 {

    public static void main(String[] args) {

        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal(23.5)),
                new Item("apple", 20, new BigDecimal(32.5)),
                new Item("orange", 30, new BigDecimal(13.9)),
                new Item("orange", 20, new BigDecimal(32.5)),
                new Item("orange", 10, new BigDecimal(63.5)),
                new Item("orange", 50, new BigDecimal(41.5)),
                new Item("peach", 20, new BigDecimal(26.5)),
                new Item("peach", 30, new BigDecimal(32.5)),
                new Item("peach", 40, new BigDecimal(24.5)),
                new Item("peach", 10, new BigDecimal(12.5))
        );

        // 分组
        Map<BigDecimal, List<Item>> groupByPriceMap = items.stream()
                .collect(Collectors.groupingBy(Item::getPrice));
        System.out.println(groupByPriceMap);

        // 分组 转化List->Set
        Map<BigDecimal, Set<String>> result = items.stream()
                .collect(Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getName, Collectors.toSet())));
        System.out.println(result);
    }
}
