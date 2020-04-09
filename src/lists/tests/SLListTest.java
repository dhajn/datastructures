package lists.tests;

import lists.SLList;
import lists.MyList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SLListTest {

    @Test
    void getTest() {
        MyList<Integer> list = new SLList<>();
        list.addLast(1);
        list.addLast(2);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }
}