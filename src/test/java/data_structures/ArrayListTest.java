package data_structures;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ArrayListTest {
    ArrayList<Integer> mylist = new ArrayList<>();

    @Test
    public void addGetRemoveTest() {
        mylist.add(1);
        assertEquals(1, (int)mylist.get(0));

        mylist.add(2);
        assertEquals(2, (int)mylist.get(1));

        mylist.remove(0);
        assertEquals(2, (int)mylist.get(0));

        mylist.remove(0);
        assertEquals(null, mylist.get(0));
    }

    @Test
    public void sizeResizeTest() {
        // add 30 numbers
        for (int i = 0; i < 30; i++) {
            mylist.add(i);
        }

        assertEquals(30, mylist.size());

        // remove odd numbers
        for (int i = 0; i < mylist.size(); i++) {
            if (mylist.get(i) % 2 == 1) {
                mylist.remove(i);
            }
        }

        assertEquals(15, mylist.size());

        // remove 11 more numbers (to test downsizing)
        for (int i = 0; i < 11; i++) {
            mylist.remove(0);
        }

    }

}
