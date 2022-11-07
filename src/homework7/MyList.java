package homework7;

public class MyList {
    private static final int INIT_SIZE = 16;
    private String[] array;
    private int size = 1;
    private int lastIndex = 0;


    public MyList() {
        array = new String[INIT_SIZE];
    }

    public MyList(int initSize) {
        array = new String[initSize];
    }


    public void resize(int newLength) {
        String[] newArray = new String[newLength];
        System.arraycopy(array, 0, newArray, 0, size - 1);
        array = newArray;
    }

    public boolean add(String value) {
        return add(size - 1, value);
    }

    public boolean add(int index, String value) {
        if (index > array.length - 1) {
            return false;
        }
        if (size >= array.length) {
            resize(array.length * 2);
        }
        if (index <= lastIndex) {
            System.arraycopy(array, index, array, index + 1, lastIndex + 1 - index);
        }
        lastIndex = Math.max(lastIndex, index);
        array[index] = value;
        size++;
        return true;
    }

    public int get(String n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(n)) {
                return i;
            }
        }
        return -1;

    }

    public boolean delete(int index) {
        if (index < size) {
            for (int i = index; i < size; i++)
                array[i] = array[i + 1];
            array[size] = null;
            size--;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean delete(String value) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].equals(value)) {
                System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                return true;
            }
        }
        return false;
    }

    public void printArr() {
        for (String i : array) {
            if (i == null)
                continue;
            System.out.println(i);
        }
    }

}
