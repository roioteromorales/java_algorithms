package data_structures;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BinarySearchTreeTest {

    BinarySearchTree tree1 = new BinarySearchTree(5, 10, 4, 15, 20, 3, 12, 17, 1, 2, 7, 8);

    @Test
    public void testSize() {
        assertEquals(tree1.size, 12);
        assertEquals(new BinarySearchTree(1, 2).size, 2);
        assertEquals(new BinarySearchTree().size,0);
    }

    @Test
    public void testSearch() {
        assertEquals(tree1.search(10), true);
        assertEquals(tree1.search(50), false);
        assertEquals(tree1.search(5), true);
    }

    @Test
    public void testRemove() {

        // two branches
        tree1.remove(15);
        assertEquals(tree1.search(15), false);
        assertEquals(tree1.size, 11);

        // root
        tree1.remove(5);
        assertEquals(tree1.search(5), false);
        assertEquals(tree1.size, 10);

        // not in tree
        tree1.remove(0);
        assertEquals(tree1.search(0), false);
        assertEquals(tree1.size, 10);

        // no children
        tree1.remove(17);
        assertEquals(tree1.search(17), false);
        assertEquals(tree1.size, 9);

        // one child
        tree1.remove(7);
        assertEquals(tree1.search(7), false);
        assertEquals(tree1.size, 8);

    }
}
