package lists;

public class AList<T> implements MyList<T> {
    private static final int FACTOR = 3;
    private T[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    @Override
    public void addLast(T x) {
        if (items.length == size) {
            int newLength = size * FACTOR;
            T[] expandedItems = (T[]) new Object[newLength];
            System.arraycopy(items, 0, expandedItems, 0, size);
            items = expandedItems;
        }
        items[size] = x;
        size++;
    }

    /** Returns the item from the back of the list. */
    @Override
    public T getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    @Override
    public T get(int i) {
        return items[i];
    }

    /** Sets the ith item in the list to value. */
    public void set(int i, T value) {
        items[i] = value;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        T itemToRemove = items[size - 1];
        items[size - 1] = null;
        size--;
        if (size < items.length / FACTOR) {
            int newLength = items.length / FACTOR;
            T[] shrinkedItems = (T[]) new Object[newLength];
            System.arraycopy(items, 0, shrinkedItems, 0, size);
            items = shrinkedItems;
        }
        return itemToRemove;
    }
}
