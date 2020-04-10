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
        assertTrue(map.isEmpty());
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
        assertTrue(map.isEmpty());
    }

    @Test
    @Order(4)
    public void functionalityTest() {
        MyMap<String, String> dictionary = new HTMap<>();
        assertEquals(0, dictionary.size());
        dictionary.put("hello", "world");
        dictionary.put("hello", "kevin");
        assertEquals(1, dictionary.size());
        assertEquals("kevin", dictionary.get("hello"));
        MyMap<String, Integer> names = new HTMap<>();
        names.put("alan", 345);
        names.put("alan", 345);
        assertEquals(1, names.size());
        assertEquals(345, names.get("alan"));
        names.put("alan", 345);
        assertEquals(1, names.size());
        assertEquals(345, names.get("alan"));
        assertEquals(345, names.get("alan"));
        names.put("evil alan", 345);
        assertEquals(345, names.get("evil alan"));
        assertEquals(names.get("evil alan"), names.get("alan"));
    }
}