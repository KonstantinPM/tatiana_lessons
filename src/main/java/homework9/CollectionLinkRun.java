package homework9;

public class CollectionLinkRun {

    public static void main(String[] args) {
        CustomCollectionImpl list = new CustomCollectionImpl();
        list.add("A");
        list.delete(1);
        list.print();
        list.add("B");
        list.add("C");
        list.add("J");
        list.add("A");
        list.add("o");
        list.print();
        list.delete(6);
        list.print();
        System.out.println("___________________");
        System.out.println(list.contains("B"));
        System.out.println(list.contains(new String("B")));
        System.out.println(list.contains(null));
        list.add(null);
        System.out.println(list.contains(null));
        System.out.println("___________________");
        System.out.println(list.size());
        System.out.println("___________________");
        list.delete("A");
        list.delete("C");
        list.print();
        System.out.println("___________________");
        System.out.println(list.size());
        System.out.println("___________________");
        list.clear();
        System.out.println(list.size());
        System.out.println("___________________");
        System.out.println(list.contains("B"));
        System.out.println("___________________");
        list.delete(3);
        list.print();
        System.out.println("___________________");
        list.get(3);
        System.out.println("___________________");
        CustomCollectionImpl list2 = new CustomCollectionImpl();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("J");
        list.addAll(list2);
        list.print();

    }
}
