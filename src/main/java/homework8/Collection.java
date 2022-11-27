package homework8;

import java.util.Iterator;

public interface Collection {
    boolean delete(String o);

    String get(int index);

    boolean add(int index, String o);

    boolean add(String o);

    boolean contain(String o);

    boolean clear();

    int size();

    boolean equals(CollectionImpl collection);

    Iterator<String> getIterator();

}
