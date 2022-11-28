package lesson13;

import java.util.ArrayList;
import java.util.List;

public class CollectionOfIntegers {
    public static void main(String[] args) {
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        newList.add(4);
        newList.add(56);
        newList.add(7);
        newList.add(34);
        newList.add(67);
        newList.add(57);
        System.out.println(averageOfCollection(newList));
    }
    public static Integer averageOfCollection(List<Integer> list) {
        Integer sum = list.stream().reduce(0, Integer::sum);
        Integer size = list.size();
        return (sum / size);
    }
}
