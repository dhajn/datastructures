package lists;

public interface MyList<T> {

    void addLast(T item);
    T get(int index);
    int size();
    default T getLast() {
        return get(size() - 1);
    }
    default T getFirst() {
        return get(0);
    }
}
