package maps;

public interface MyMap<K, V> {
    /**
     * Returns true if the map is empty.
     * @return {@code true} if the map is empty, otherwise {@code false}
     */
    boolean isEmpty();

    /**
     * Determines size of the map.
     * @return Number of keys in the map
     */
    int size();

    /**
     * Inserts given key-value pair into the map.
     * @param key The key
     * @param value Value to be inserted at key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    void put(K key, V value);

    /**
     * Gets value stored at given key.
     * @param key The key
     * @return The value stored at {@code key}, or {@code null} if {@code key} is not in the map
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    V get(K key);

    /**
     * Checks if the map contains given key.
     * @param key The key
     * @return {@code true} if {@code key} is found in the map, otherwise {@code false}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    boolean contains(K key);

    /**
     * Clears all key-value mappings from the map (i.e. makes it empty).
     */
    void clear();
}
