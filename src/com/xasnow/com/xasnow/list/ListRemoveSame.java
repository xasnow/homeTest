package com.xasnow.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xasnow
 * @Date 2019/12/19
 */
public class ListRemoveSame {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1, 2, 6, 4};
        System.out.println("原始数据： " + Arrays.toString(arr));
        //方式一：
        List<Integer> collect = Arrays.stream(arr).distinct().boxed().collect(Collectors.toList());
        System.out.println("Stream去重： " + collect);

        ArrayList<int[]> collect1 = Stream.of(arr).collect(Collectors.toCollection(ArrayList::new));
        //方式二:
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        // 从list中索引为0开始往后遍历
        for (int i = 0; i < list.size() - 1; i++) {
            // 从list中索引为 list.size()-1 开始往前遍历
            for (int j = list.size() - 1; j > i; j--) {
                // 进行比较
                if (list.get(j).equals(list.get(i))) {
                    // 去重
                    list.remove(j);
                }
            }
        }
        System.out.println("原始遍历去重： " + list);
    }
}
