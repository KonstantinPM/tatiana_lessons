package lesson13;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lesson13.CollectionOfIntegers.averageOfCollection;
import static org.junit.jupiter.api.Assertions.*;

class CollectionOfIntegersTest {

    @Test
    void averageOfCollectionTest() {
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        newList.add(4);
        newList.add(56);
        newList.add(7);

        assertEquals(averageOfCollection(newList),17);
    }
}