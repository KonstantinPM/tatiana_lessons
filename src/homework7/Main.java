package homework7;

public class Main {
    public static void main(String[] args) {
        MyListImpl list = new MyListImpl();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.delete(2);
        System.out.println(list);
        list.add(10, "g");
        System.out.println(list);
        list.add(5, "null");
        System.out.println(list);
        list.add(7, "T");
        System.out.println();
        System.out.println(list);
        System.out.println();
        list.delete(1);
        System.out.println(list);
        System.out.println();
        list.delete("D");
        System.out.println(list);
        System.out.println();
        System.out.println(list.get(2));


    }
}
