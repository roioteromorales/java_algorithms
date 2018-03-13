package hashmaps;

import lists.SingleLinkedList;

public class HashMap<V> {
    private SingleLinkedList<Pair>[] table = new SingleLinkedList[26];

    /**
     * Adds the key-value pair to the hashmap
     * @param key a String
     * @param value any Object
     */
    public void add(String key, V value) {
        int hash = hash(key);

        // initialize collision linked list
        if (table[hash] == null) {
            table[hash] = new SingleLinkedList<Pair>();
        }

        table[hash].add(new Pair(key, value));
    }

    /**
     * Removes the pair at the given key from the hashmap
     * @param key of pair to be removed
     */
    public void remove(String key) {
        int hash = hash(key);

        // iterate through collision list
        for (int i = 0; i < table[hash].size(); i++) {
            // check for matching data;
            Pair p = table[hash].get(i);

            if (p.key == key) {
                // remove item
                table[hash].remove(i);
            }
        }
    }

    /**
     * Finds the value of a key
     * @param key to search for
     * @return value of the given key
     */
    public V find(String key) {
        int hash = hash(key);

        // iterate through collision list
        for (int i = 0; i < table[hash].size(); i++) {
            // check for matching data
            Pair p = table[hash].get(i);

            if (p.key.equals(key)) {
                // item found
                return p.value;
            }
        }

        // key not found
        return null;
    }

    /**
     * Returns all the keys in the hashmap
     * @return a SingleLinkedList of String keys
     */
    public SingleLinkedList<String> keys() {
        SingleLinkedList<String> keys = new SingleLinkedList<>();

        // iterate through rows
        for (int i = 0; i < table.length ; i++) {
            if (table[i] != null) {
                // iterate through columns
                for (int j = 0; j < table[i].size(); j++) {
                    // add key to list
                    keys.add(table[i].get(j).key);
                }
            }
        }

        return keys;
    }

    /**
     * Hashes a key to 26 locations based on first letter
     * @param key to be hashed
     * @return a hashed key String
     */
    private int hash(String key) {
        // get first char, make lowercase
        int c = (int)key.toLowerCase().charAt(0);
        // normalize to 0-25
        c -= 97;
        return c;
    }

    /**
     * A Key-Value Pair
     */
    private class Pair {
        String key;
        V value;

        Pair(String key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}