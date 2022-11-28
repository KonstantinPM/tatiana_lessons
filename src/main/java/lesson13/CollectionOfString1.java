package lesson13;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionOfString1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("tree");
        list.add("four");
        List<String> list1 = filteredMapOutput(list);
        HashMap<String, String> myHashMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            myHashMap.put(list.get(i), list1.get(i));

        }
        for (Map.Entry<String, String> entry : myHashMap.entrySet()) {
            System.out.println("{" + entry.getKey() + "}" + ":" + "{" + entry.getValue() + "}");
        }
    }

    public static List<String> filteredMapOutput(List<String> list) {
        List<String> list1 = list.stream().map(String::toUpperCase).toList();
        list1.forEach(System.out::println);
        return list1;

    }
}
