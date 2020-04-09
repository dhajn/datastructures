package maps;

public class BSTMap<K extends Comparable<K>, V> implements MyMap<K, V> {
    class Node {
        private K key;
        private V value;
        private Node left, right;
        private int size;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            size = 1;
        }
    }

    private Node root;

    /**
     * Initializes an empty map.
     */
    public BSTMap() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Attempting to insert a null key");
        }
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else { // key already in map, update value
            node.value = value;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Searching for a null key");
        }
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    @Override
    public boolean contains(K key) {
        return (get(key) != null);
    }

    /**
     * Prints key-value pairs to standard output in ascending order.
     */
    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.println(node.key + " : " + node.value);
        printInOrder(node.right);
    }

    @Override
    public void clear() {
        root = null;
    }
}
