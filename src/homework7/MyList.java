package homework7;

public interface MyList {
    boolean add(String value);

    boolean add(int index, String value);

    String get(int index);

    boolean delete(int index);

    boolean delete(String value);

}
