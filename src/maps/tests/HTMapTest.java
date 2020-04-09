package maps.tests;

import maps.HTMap;
import maps.MyMap;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HTMapTest {

    static MyMap<Integer, Integer> map = new HTMap<>();

    @Test
    @Order(1)
    void putTest() {
        assertEquals(0, map.size());
        for (int i = 0; i < 100; i++) {
            map.put(i, -i);
        }
        assertEquals(100, map.size());
    }

    @Test
    @Order(2)
    void getTest() {
        for (int i = 0; i < 100; i++) {
            assertTrue(map.contains(i));
            assertEquals(-i, map.get(i));
        }
        assertFalse(map.contains(100));
        assertNull(map.get(100));
    }

    @Test
    @Order(3)
    void clearTest() {
        map.clear();
        for (int i = 0; i < 100; i++) {
            assertFalse(map.contains(i));
        }
    }

    @Test
    public void functionalityTest() {
        MyMap<String, String> dictionary = new HTMap<>();
        assertEquals(0, dictionary.size());

        // can put objects in dictionary and get them
        dictionary.put("hello", "world");
        assertTrue(dictionary.contains("hello"));
        assertEquals("world", dictionary.get("hello"));
        assertEquals(1, dictionary.size());

        // putting with existing key updates the value
        dictionary.put("hello", "kevin");
        assertEquals(1, dictionary.size());
        assertEquals("kevin", dictionary.get("hello"));

        // putting key in multiple times does not affect behavior
        MyMap<String, Integer> studentIDs = new HTMap<>();
        studentIDs.put("sarah", 12345);
        assertEquals(1, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        studentIDs.put("alan", 345);
        assertEquals(2, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        assertEquals(345, studentIDs.get("alan").intValue());
        studentIDs.put("alan", 345);
        assertEquals(2, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        assertEquals(345, studentIDs.get("alan").intValue());
        studentIDs.put("alan", 345);
        assertEquals(2, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        assertEquals(345, studentIDs.get("alan").intValue());
        assertTrue(studentIDs.contains("sarah"));
        assertTrue(studentIDs.contains("alan"));

        // handle values being the same
        assertEquals(345, studentIDs.get("alan").intValue());
        studentIDs.put("evil alan", 345);
        assertEquals(345, studentIDs.get("evil alan").intValue());
        assertEquals(studentIDs.get("evil alan"), studentIDs.get("alan"));
    }
}