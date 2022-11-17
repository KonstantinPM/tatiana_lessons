package homework8;

import java.util.Iterator;

public class CollectionRun {
    public static void main(String[] args) {
        CollectionImpl list = new CollectionImpl();
        CollectionImpl list2 = new CollectionImpl();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        list2.add("E");
        System.out.println(list.equals(list2));
        list.add(5,"null");
        System.out.println(list);
        list.add(7,"T");
        System.out.println();
        System.out.println(list);
        System.out.println();
        list.delete("C");
        System.out.println(list);
        System.out.println();
        System.out.println(list.size());
        System.out.println();
        System.out.println(list.get(2));
        //list.clear();
        System.out.println(list);
        Iterator<String> iterator =list.getIterator();
        System.out.println("++++++++");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        
    }
}
