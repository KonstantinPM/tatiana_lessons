package lesson13;

import java.util.ArrayList;
import java.util.List;

public class CollectionOfString2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("tree");
        list.add("FOUR");
        List<String> list1 = filter(list);
        list1.forEach(System.out::println);
    }

    public static List<String> filter(List<String> list) {
        List<String> list1 = list.stream().filter(x -> x.equals(x.toLowerCase())).filter(x -> x.length() == 4).toList();
        return list1;
    }
}
