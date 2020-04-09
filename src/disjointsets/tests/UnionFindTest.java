package disjointsets.tests;

import disjointsets.UnionFind;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UnionFindTest {

    static UnionFind unionFind = new UnionFind(1000);

    @Test
    @Order(1)
    void testInitialState() {
        for (int i = 0; i < 1000; i++) {
            for (int j = i + 1; j < 1000; j++) {
                assertFalse(unionFind.connected(i, j));
            }
        }
    }

    @Test
    @Order(2)
    void testUnion() {
        for (int i = 0; i < 30; i++) {
            unionFind.union(999, i);
        }
        assertEquals(31,unionFind.sizeOf(0));

        for (int i = 100; i < 140; i++) {
            unionFind.union(998, i);
        }
        assertEquals(41, unionFind.sizeOf(129));

        unionFind.union(999, 998);
        assertTrue(unionFind.connected(0, 100));
        assertTrue(unionFind.connected(999, 998));
        assertEquals(72, unionFind.sizeOf(0));
    }

    @Test
    @Order(3)
    void testUnionSameSet() {
        unionFind.union(0, 1);
        assertEquals(72, unionFind.sizeOf(0));

        unionFind.union(1, 1);
        assertEquals(72, unionFind.sizeOf(0));

        unionFind.union(500, 500);
        assertEquals(1, unionFind.sizeOf(500));
    }

    @Test
    void testPathCompression() {
        UnionFind unionFind1 = new UnionFind(10);

        unionFind1.union(1, 0);
        unionFind1.union(2, 1);
        unionFind1.union(3, 2);

        unionFind1.union(6, 5);
        unionFind1.union(7, 6);

        int largerRoot = unionFind1.find(0);

        unionFind1.union(3, 6);
        assertTrue(unionFind1.connected(6, 3));
        assertEquals(largerRoot, unionFind1.parent(6));
    }
}
