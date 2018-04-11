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
        assertEquals(true, tree1.search(10));
        assertEquals(false, tree1.search(50));
        assertEquals(true, tree1.search(5));
    }

    @Test
    public void testRemove() {

        // two branches
        tree1.remove(15);
        assertEquals(false, tree1.search(15));
        assertEquals(11, tree1.size, 0);

        // root
        tree1.remove(5);
        assertEquals(false, tree1.search(5));
        assertEquals(10, tree1.size, 0);

        // not in tree
        tree1.remove(0);
        assertEquals(false, tree1.search(0));
        assertEquals(10, tree1.size, 0);

        // no children
        tree1.remove(17);
        assertEquals(false, tree1.search(17));
        assertEquals(9, tree1.size, 0);

        // one child
        tree1.remove(7);
        assertEquals(false, tree1.search(7));
        assertEquals(8, tree1.size, 0);

    }
}
