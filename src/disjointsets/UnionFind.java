package disjointsets;

public class UnionFind {

    private int[] itemParents;


    /**
     * Creates an UnionFind data structure holding n vertices.
     * Initially, all vertices are in disjoint sets.
     * @param n Number of vertices in data structure
     */
    public UnionFind(int n) {
        itemParents = new int[n];
        for (int i = 0; i < n; i++) {
            itemParents[i] = -1;
        }
    }


    /**
     * Throws IllegalArgumentException if v1 is not a valid index.
     * @param v1 Vertex to be validated
     */
    public void validate(int v1) {
        if (v1 < 0 || v1 >= itemParents.length) {
            throw  new IllegalArgumentException("Index not in data structure");
        }
    }


    /**
     * Determines number of elements in the set that v1 belongs to.
     * @param v1 Vertex to evaluate
     * @return Size of set that given vertex belongs to
     */
    public int sizeOf(int v1) {
        validate(v1);
        return (-1 * parent(find(v1)));
    }


    /**
     * Returns the parent of v1.
     * @param v1 Vertex to evaluate
     * @return Parent of v1, or, if v1 is the root of a tree, negative size of the tree for which v1 is the root
     */
    public int parent(int v1) {
        validate(v1);
        return itemParents[v1];
    }


    /** Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        validate(v1);
        validate(v2);
        return (find(v1) == find(v2));
    }


    /** Connects two elements v1 and v2 together. */
    public void union(int v1, int v2) {
        validate(v1);
        validate(v2);

        int root1 = find(v1);
        int root2 = find(v2);

        if (root1 == root2) {
            return;
        }

        if (itemParents[root1] > itemParents[root2]) { // if tree 1 is smaller or equal to tree 2, link tree 1 to tree 2
            itemParents[root2] += itemParents[root1];
            itemParents[root1] = root2;
        } else {
            itemParents[root1] += itemParents[root2];
            itemParents[root2] = root1;
        }
    }


    /**
     * Returns the root of the set v1 belongs to.
     * Path compression is employed, connecting each visited item to the root.
     * @return Root of the set the given vertex belongs to
     */
    public int find(int v1) {
        validate(v1);
        if (parent(v1) >= 0) {
            itemParents[v1] = find(parent(v1));
        }
        return parent(v1) < 0 ? v1 : parent(v1);
    }
}
