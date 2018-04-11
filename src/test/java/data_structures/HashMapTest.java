package data_structures;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HashMapTest {

    HashMap<String, Number> hashmap = new HashMap();

    @Test
    public void testAddFindResize() {
        hashmap.add("Apple", 2.5);
        assertEquals(2.5, hashmap.find("Apple"));


        hashmap.add("Avocado", 10.23464);
        assertEquals(10.23464, hashmap.find("Avocado"));

        hashmap.add("Pear", 5);
        assertEquals(5, hashmap.find("Pear"));

        hashmap.add("Mango", 0);
        assertEquals(0, hashmap.find("Mango"));

        hashmap.add("Grapefruit", 1);
        hashmap.add("Banana", 2);
        hashmap.add("Grapes", 3);
        hashmap.add("Orange", 4);
        hashmap.add("Dragonfruit", 5);
        hashmap.add("Snakefruit", 6);
        hashmap.add("Pineapple", 7);
        hashmap.add("Coconut", 8);

        assertEquals(20, hashmap.getStorage());
    }

    @Test
    public void testRemove() {
        hashmap.remove("Pear");
        assertEquals(null, hashmap.find("Pear"));

        hashmap.remove("Orange");
        assertEquals(null, hashmap.find("Orange"));
    }

}
