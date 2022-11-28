package lesson13;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lesson13.CollectionOfString2.filter;
import static org.junit.jupiter.api.Assertions.*;

class CollectionOfString2Test {

    @Test
    void filterTest() {
        List<String> list = new ArrayList<>();
        list.add("ONE");
        list.add("two");
        list.add("tree");
        List<String> list1 = filter(list);

        assertEquals(list1.get(0), "tree");
        assertNotNull(list1.get(0));
    }
}