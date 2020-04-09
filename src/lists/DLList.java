package lists;

public class DLList<T> implements MyList<T> {
    private class Node {
        private Node prev;
        private T item;
        private Node next;

        private Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
    private Node sentinel;
    private int size;

    public DLList() {
        sentinel = new Node(null, null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public DLList(T n) {
        this();
        addFirst(n);
    }

    private void insertAfter(Node prevNode, T n) {
        Node node = new Node(prevNode, n, prevNode.next);
        node.prev.next = node;
        node.next.prev = node;
        size++;
    }

    public void insertAfter(int index, T n) {
        if (index < 0 || index >= size)
            return;
        if (index == (size - 1)) {
            addLast(n);
            return;
        }
        Node currentPosition = sentinel;
        for (int i = 0; i <= index; i++)
            currentPosition = currentPosition.next;
        insertAfter(currentPosition, n);
    }

    public void addFirst(T n) {
        insertAfter(sentinel, n);
    }

    public T getFirst() {
        return sentinel.next.item;
    }

    public void addLast(T n) {
        insertAfter(sentinel.prev,n);
    }

    public T getLast() {
        return sentinel.prev.item;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        if (index == (size - 1))
            return getLast();
        Node currentPosition = sentinel;
        for (int i = 0; i <= index; i++)
            currentPosition = currentPosition.next;
        return currentPosition.item;
    }

    public int size() {
        return size;
    }
}
