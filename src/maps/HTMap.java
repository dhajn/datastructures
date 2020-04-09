package maps;

public class HTMap<K, V> implements MyMap<K, V> {

    private MapEntry<K, V>[] buckets;
    private double loadFactor;
    private int initialSize;
    private int size;

    private class MapEntry<K, V> {
        K key;
        V value;
        MapEntry<K, V> next;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Creates an empty hash map with given initial number of buckets, resizing at given load factor.
     * @param initialSize Initial number of buckets in hash table
     * @param loadFactor Maximum load factor, when reached, number of buckets is doubled
     */
    public HTMap(int initialSize, double loadFactor) {
        buckets = (MapEntry<K, V>[]) new MapEntry[initialSize];
        this.initialSize = initialSize;
        this.loadFactor = loadFactor;
        size = 0;
    }

    /**
     * Creates an empty hash map with given initial number of buckets.
     * @param initialSize Initial number of buckets in hash table
     */
    public HTMap(int initialSize) {
        this(initialSize, 0.75);
    }

    /**
     * Creates an empty hash map.
     */
    public HTMap() {
        this(16);
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public int size() {
        return size;
    }

    private int getBucket(K key, int bucketsCount) {
        int hash = key.hashCode() & 0x7FFFFFFF;
        return hash % bucketsCount;
    }

    private int getBucket(K key) {
        return getBucket(key, buckets.length);
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Attempting to insert a null key");
        }

        if (size / buckets.length > loadFactor) {
            doubleBuckets();
        }

        int bucket = getBucket(key);
        MapEntry<K, V> entry = buckets[bucket];
        while (entry != null) { // if the bucket is not empty, check if the key is present and if so, update its value
            if (entry.key == key) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        } // if the key is not present, create a new entry
        entry = buckets[bucket];
        buckets[bucket] = new MapEntry<>(key, value);
        buckets[bucket].next = entry;
        size++;
    }

    private void doubleBuckets() {
        MapEntry<K, V>[] newBuckets = (MapEntry<K, V>[]) new MapEntry[buckets.length * 2];
        MapEntry<K, V> entry;
        for (MapEntry<K, V> bucket : buckets) {
            entry = bucket;
            while (entry != null) {
                putInNewBucket(newBuckets, entry.key, entry.value);
                entry = entry.next;
            }
        }
        buckets = newBuckets;
    }

    private void putInNewBucket(MapEntry<K, V>[] newBuckets, K key, V value) {
        int bucket = getBucket(key, newBuckets.length);
        MapEntry<K, V> oldFirst = newBuckets[bucket];
        newBuckets[bucket] = new MapEntry<>(key, value);
        newBuckets[bucket].next = oldFirst;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Searching for a null key");
        }

        int bucket = getBucket(key);
        MapEntry<K, V> entry = buckets[bucket];
        while (entry != null) {
            if (entry.key == key) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public void clear() {
        buckets = (MapEntry<K, V>[]) new MapEntry[initialSize];
    }
}
