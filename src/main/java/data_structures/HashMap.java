package data_structures;

import data_structures.lists.SingleLinkedList;

public class HashMap<K, V> {

    private int INITIAL_SIZE = 10;
    private Pair<K, V>[] table;

    public HashMap() {
        table = new Pair[INITIAL_SIZE];
    }

    /**
     * Adds the key-value pair to the hashmap
     * @param key a key Object
     * @param value a value Object
     */
    public void add(K key, V value) {
        // get hash for key
        int hash = hash(key);

        // no collision yet
        if (table[hash] == null) {
            table[hash] = new Pair(key, value);
        }
        // iterate through collision list
        else {
            Pair<K,V> p = table[hash];

            // move to end
            while (p.next != null) {
                p = p.next;
            }

            // add new pair
            p.next = new Pair(key, value);
        }

        // check for resize
        if (keys().size() > table.length * .75) {
            resize();
        }
    }

    /**
     * Resizes the underlying array to double its previous size and copies the old values into it
     */
    private void resize() {
        Pair<K,V>[] old = table;
        table = new Pair[old.length * 2];

        for (int i = 0; i < old.length; i++) {

        }
    }

    /**
     * Removes the pair at the given key from the hashmap
     * @param key of the pair to be removed
     */
    public void remove(K key) {

        // ensure key exists
        if(find(key) == null) {
            return;
        }

        // get hash for key
        int hash = hash(key);

        // iterate through collision list
        Pair<K,V> p = table[hash];

        // move to key
        while (p.next != null && p.next.getKey() != key) {
            p = p.next;
        }

        // remove pair
        p.next = null;
    }

    /**
     * Finds the value of a key
     * @param key to search for
     * @return value of the given key
     */
    public V find(K key) {
        // get hash for key
        int hash = hash(key);

        // nothing at key
        if (table[hash] == null) {
            return null;
        }

        // iterate through collision list
        Pair<K,V> p = table[hash];
        while (p.getKey() != key) {
            // no more entries
            if (p.next == null) {
                return null;
            }
            // move to next
            p = p.next;
        }

        // key found
        return p.getValue();
    }

    /**
     * Returns all the keys in the hashmap
     * @return a SingleLinkedList of keys
     */
    public SingleLinkedList<K> keys() {
        SingleLinkedList<K> keys = new SingleLinkedList<>();

        // iterate through rows
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                // iterate through columns
                Pair<K,V> p = table[i];

                while (p != null) {
                    keys.add(p.getKey());
                    p = p.next;
                }

            }
        }

        return keys;
    }

    /**
     * Hashes the given key and returns a table index
     * @param key to be hashed
     * @return a table index
     */
    private int hash(K key) {
        int k = Math.abs(key.hashCode() % table.length);
        return k;
    }

    /**
     * For Testing: gets the size of the underlying array
     * @return int storage size
     */
    public int getStorage() {
        return table.length;
    }


    /**
     * A Key-Value Pair
     */
    private class Pair<K, V> {
        private K key;
        private V value;
        Pair next = null;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}



