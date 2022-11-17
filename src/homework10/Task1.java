package homework10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        ArrayList <String> id = new ArrayList<String>();
        id.add("1");
        id.add("1");
        id.add("1");
        id.add("2");
        id.add("1");
        id.add("1");
        id.add("1");
        id.add("3");
        id.add("3");
        System.out.println(id);
        Set <String> set = new HashSet<>(id);
        id.clear();
        id.addAll(set);
        System.out.println(id);
    }
}
