package lists;

public class SLList<T> implements MyList<T>{
    private class Node {
        private T item;
        private Node next;

        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    private Node sentinel;
    private int size;

    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList(T n) {
        this();
        sentinel.next = new Node(n, null);
        size++;
    }

    public void addFirst(T n) {
        sentinel.next = new Node(n, sentinel.next);
        size++;
    }

    public T getFirst() {
        return sentinel.next.item;
    }

    public void addLast(T n) {
        addLast(sentinel, n);
        size++;
    }

    private void addLast(SLList.Node node, T n) {
        if (node.next == null) {
            node.next = new Node(n, null);
        } else {
            addLast(node.next, n);
        }
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node currentPosition = sentinel;
        for (int i = 0; i <= index; i++) {
            currentPosition = currentPosition.next;
        }
        return currentPosition.item;
    }

    public int size() {
        return size;
    }
}
