package homework8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectionImplTest {
    @Test
    void successfulGet() {
        CollectionImpl collection = new CollectionImpl();
        collection.add(1,"testString");

        assertEquals(collection.get(0),"testString");
        assertNotNull(collection.get(0));
    }

    @Test
    void successfulDelete() {
        CollectionImpl collection = new CollectionImpl();
        collection.add(1,"testString");
        boolean result = collection.delete("testString");

        assertTrue(result);
        assertEquals(collection.size(),0);
    }

    @Test
    void successfulContain() {
        CollectionImpl collection = new CollectionImpl();
        collection.add(1,"testString");

        assertEquals(collection.contain("testString"), true);
        assertTrue(collection.contain("testString"));
    }

    @Test
    void successfulClear() {
        CollectionImpl collection = new CollectionImpl();
        collection.add(1,"testString");
        collection.clear();

        assertEquals(collection.size(),0);
    }

    @Test
    void successfulSize() {
        CollectionImpl collection = new CollectionImpl();
        collection.add(1,"testString");

        assertEquals(collection.size(),1);
        assertTrue(collection.size()==1);
    }

    @Test
    void successfulEaquels() {
        CollectionImpl collection = new CollectionImpl();
        collection.add(0,"testString");
        CollectionImpl collection1 = new CollectionImpl();
        collection1.add(0,"testString");

        assertEquals(collection.equals(collection1), true);
        assertNotNull(collection1, "testString");
    }

    @Test
    void successfulAdd() {
        CollectionImpl collection = new CollectionImpl();
        String testString = "Test";
        boolean result = collection.add(testString);

        assertTrue(result);
        assertEquals(collection.size(),1);
        assertEquals(collection.get(0),testString);
    }

    @Test
    void shouldReturnFalseIfIndexHigherThanArrayLength() {
        CollectionImpl collection = new CollectionImpl();
        boolean result = collection.add(16,"testString");

        assertFalse(result);
        assertEquals(collection.size(),0);

    }

}