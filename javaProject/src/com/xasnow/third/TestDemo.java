package third;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xasnow
 * @Date 2020/4/22
 */
public class TestDemo {

    public static void main(String[] args) {
        Map<Long, List<TranslationList>> translationListsConvertMap = new HashMap<>();
        ArrayList<TranslationList> translationLists = new ArrayList<>();
        TranslationList translationList1 = new TranslationList(1L, "b1", "c1");
        TranslationList translationList2 = new TranslationList(1L, "b2", "c2");
        TranslationList translationList13 = new TranslationList(2L, "b3", "c3");
        TranslationList translationList4 = new TranslationList(2L, "b4", "c4");
        translationLists.add(translationList1);
        translationLists.add(translationList2);
        translationLists.add(translationList13);
        translationLists.add(translationList4);
        List<TranslationList> translationListList;

//        method1(translationListsConvertMap, translationLists);
        // 改写
        method2(translationLists);

    }

    private static void method2(ArrayList<TranslationList> translationLists) {
        Map<Long, List<TranslationList>> map = translationLists.stream().collect(Collectors.toMap(TranslationList::getTranslationId,
                e -> new ArrayList<>(Arrays.asList(new TranslationList(e.getTranslationId(), e.getId(), e.getContent()))),
                (List<TranslationList> oldList, List<TranslationList> newList) -> {
                    oldList.addAll(newList);
                    return oldList;
                }));

        System.out.println(map.toString());
    }

    private static void method1(Map<Long, List<TranslationList>> translationListsConvertMap, ArrayList<TranslationList> translationLists) {
        List<TranslationList> translationListList;
        for (TranslationList translationList : translationLists) {
            if (translationListsConvertMap.containsKey(translationList.getTranslationId())) {
                // 包含key,取出value,然后再复制到自己里面
                translationListList = translationListsConvertMap.get(translationList.getTranslationId());
                translationListList.add(translationList);
            } else {
                // 不包含key,添加一次
                translationListList = new ArrayList<>();
                translationListList.add(translationList);
            }
            // map 填值， 没有的key，添加当前记录，
            translationListsConvertMap.put(translationList.getTranslationId(), translationListList);
        }
        System.out.println(translationListsConvertMap.toString());
    }
}
