package homework8;

public class CollectionImpl implements Collection {
    private static final int INIT_SIZE = 16;
    private String[] array;
    private int size = 0;
    private int lastIndex = 0;

    public CollectionImpl() {
        array = new String[INIT_SIZE];
    }

    public CollectionImpl(int initSize) {
        array = new String[initSize];
    }


    private void resize(int newLength) {
        String[] newArray = new String[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public boolean add(String o) {
        return add(size, o);
    }

    public boolean add(int index, String o) {
        if (index > array.length - 1) {
            return false;
        }
        if (size >= array.length) {
            resize(array.length * 2);
        }
        if (index <= size - 1) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        if (index > size - 1) {
            index = size;
        }
        array[index] = o;
        size++;
        return true;
    }

    public String get(int index) {
        for (String s : array) {
            if (s.equals(array[index])) {
                return s;
            }
        }
        return "Элемент не найден";

    }

    public boolean delete(String o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                array[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;

    }

    public boolean contain(String o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
            lastIndex = 0;
            size = 0;
        }
        return true;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= size - 1; i++) {
            stringBuilder.append(array[i]);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }


    public boolean equals(CollectionImpl collection) {
        if (size != collection.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(collection.get(i))) {
                return false;
            }
        }
        return true;
    }
}
