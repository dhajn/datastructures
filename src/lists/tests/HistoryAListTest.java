package lists.tests;

import lists.HistoryAList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoryAListTest {

    @Test
    void removeLastTest() {
        HistoryAList<Integer> list = new HistoryAList<>();
        list.addLast(1);
        list.removeLast();
        assertEquals(1, list.getDeletedItems().getFirst());
    }
}