package maps.tests;

import maps.MyMap;
import maps.BSTMap;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BSTMapTest {

    static MyMap<Integer, String> map = new BSTMap<>();

    @Test
    @Order(1)
    void testPutSize() {
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
        map.put(34, "thirty-four");
        assertFalse(map.isEmpty());
        assertEquals(1, map.size());
        map.put(12, "twelve");
        map.put(0, "zero");
        map.put(1, "one");
        map.put(43, "forty-three");
        map.put(20, "twenty");
        map.put(60, "sixty");
        assertEquals(7, map.size());
    }

    @Test
    @Order(2)
    void testContains() {
        assertTrue(map.contains(1));
        assertFalse(map.contains(33));
    }

    @Test
    @Order(3)
    void testGet() {
        assertEquals("zero", map.get(0));
        assertEquals("sixty", map.get(60));
        assertEquals("thirty-four", map.get(34));
        assertNull(map.get(33));
        //map.printInOrder();
    }

    @Test
    @Order(4)
    void testUpdate() {
        map.put(0, "new zero");
        assertEquals("new zero", map.get(0));
        //map.printInOrder();
    }

}