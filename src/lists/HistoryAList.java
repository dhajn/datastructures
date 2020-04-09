package lists;

public class HistoryAList<T> extends AList<T> {
    private AList<T> deletedItems;

    public HistoryAList() {
        super();
        this.deletedItems = new AList<>();
    }

    public AList<T> getDeletedItems() {
        return deletedItems;
    }

    @Override
    public T removeLast() {
        T item = super.removeLast();
        deletedItems.addLast(item);
        return item;
    }
}
