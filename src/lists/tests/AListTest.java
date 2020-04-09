package lists.tests;

import lists.AList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AListTest {

    @Test
    void testAddLastGetLast() {
        AList<Integer> list = new AList<>();
        list.addLast(3);
        assertEquals(3, list.getLast());

        list.addLast(4);
        assertEquals(4, list.getLast());
    }

    @Test
    void testGet() {
        AList<Integer> list = new AList<>();
        list.addLast(3);
        list.addLast(4);
        assertEquals(3, list.get(0));
    }

    @Test
    void testSize() {
        AList<Integer> list = new AList<>();
        list.addLast(1);
        list.addLast(2);
        assertEquals(2, list.size());
    }

    @Test
    void testRemove() {
        AList<Integer> list = new AList<>();
        list.addLast(3);
        list.addLast(4);
        assertEquals(4, list.removeLast());
        assertEquals(1, list.size());
    }

    @Test
    void testAddResize() {
        AList<Integer> list = new AList<>();
        for (int i = 0; i < 50; i++) {
            list.addLast(i);
        }
        assertEquals(49, list.getLast());
        assertEquals(50, list.size());
        assertEquals(0, list.get(0));
        assertEquals(48, list.get(48));
    }

    @Test
    void testResize() {
        AList<Integer> list = new AList<>();
        for (int i = 0; i < 10000; i++) {
            list.addLast(i);
        }
        assertEquals(9999, list.removeLast());
        for (int i = 9999; i > 3; i--) {
            list.removeLast();
        }
        assertEquals(2, list.removeLast());
    }
}