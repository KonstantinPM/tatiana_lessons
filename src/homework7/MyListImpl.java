package homework7;

import java.util.Arrays;

public class MyListImpl implements MyList {

    private static final int INIT_SIZE = 16;
    private String[] array;
    private int size = 0;


    public MyListImpl() {
        array = new String[INIT_SIZE];
    }

    public MyListImpl(int initSize) {
        array = new String[initSize];
    }

    private void resize(int newLength) {
        String[] newArray = new String[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public boolean add(String value) {
        return add(size, value);
    }

    @Override
    public boolean add(int index, String value) {
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
        array[index] = value;
        size++;
        return true;
    }

    @Override
    public String get(int index) {
        for (String s : array) {
            if (s.equals(array[index])) {
                return s;
            }
        }
        return "Элемент не найден";

    }

    @Override
    public boolean delete(int index) {
        if (index < size) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            array[size - 1] = null;
            size--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return delete(i);
            }
        }
        return false;
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

}
