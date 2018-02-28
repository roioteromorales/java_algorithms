package hashmaps;

import lists.SingleLinkedList;

public class HashMap<V extends Comparable> {
    SingleLinkedList<Pair>[] table = new SingleLinkedList[26];

    public void add(String key, V value) {
        int hash = hash(key);

        // initialize collision linked list
        if (table[hash] == null) {
            table[hash] = new SingleLinkedList<Pair>();
        }

        table[hash].add(new Pair(key, value));
    }

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

    public V find(String key) {
        int hash = hash(key);

        // iterate through collision list
        for (int i = 0; i < table[hash].size(); i++) {
            // check for matching data
            Pair p = table[hash].get(i);

            if (p.key == key) {
                // item found
                return p.value;
            }
        }

        // key not found
        return null;
    }

    private int hash(String key) {
        // get first char, make lowercase
        int c = (int)key.toLowerCase().charAt(0);
        // normalize to 0-25
        c -= 97;
        return c;
    }

    private class Pair {
        String key;
        V value;

        Pair(String key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}