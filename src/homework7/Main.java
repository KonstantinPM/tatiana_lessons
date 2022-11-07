package homework7;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add(0,"R");
        list.printArr();
        list.add(7,"T");
        System.out.println();
        list.printArr();
        System.out.println();
        list.delete(1);
        list.printArr();
        System.out.println();
        list.delete("B");
        list.printArr();
        System.out.println();
        list.delete("C");
        list.printArr();
    }
}
