package lesson13;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lesson13.CollectionOfString1.filteredMapOutput;
import static org.junit.jupiter.api.Assertions.*;


class CollectionOfString1Test {

    @Test
    void filteredMapOutputTest() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        List<String> list1 = filteredMapOutput(list);

        assertEquals(list1.get(0),"ONE");
        assertTrue(list1.contains("TWO"));
    }
}