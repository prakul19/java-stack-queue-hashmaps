import java.util.LinkedList;

class HashMap<K, V> {
    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Initial size of the hash map
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;

    @SuppressWarnings("unchecked")
    public HashMap() {
        // Initialize the bucket array
        buckets = new LinkedList[INITIAL_CAPACITY];
    }

    // Compute the index for a given key
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update value if key exists
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
    }

    // Retrieve a value by key
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        int index = getBucketIndex(key);
        if (buckets[index] == null) return null;
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value; // Return value if key found
            }
        }
        return null;
    }

    // Remove a key-value pair
    public void remove(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        int index = getBucketIndex(key);
        if (buckets[index] == null) return;
        buckets[index].removeIf(entry -> entry.key.equals(key)); // Remove entry if key matches
    }

    public static void main(String[] args) {
        // Creating a hash map instance
        HashMap<String, Integer> map = new HashMap<>();

        // Inserting key-value pairs
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // Retrieving values
        System.out.println("Value for key 'one': " + map.get("one"));
        System.out.println("Value for key 'four': " + map.get("four"));

        // Removing a key and checking again
        map.remove("two");
        System.out.println("Value for key 'two' after removal: " + map.get("two"));
    }
}

