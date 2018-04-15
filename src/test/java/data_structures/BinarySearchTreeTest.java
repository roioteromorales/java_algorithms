package data_structures;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class BinarySearchTreeTest {

    //          5
    //      4      10 (x)
    //                15 (y)
    //                   20
    // rebalanced
    //          5
    //      4         15 (y)
    //             10 (x)   20
    // keep inserting
    //              5
    //       4 (y)               15
    //   3 (x)            10            20
    // 1                      12    17
    // rebalanced
    //          5
    //     3                15
    //  1     4        10           20
    //                    12     17
    // keep inserting
    //          5
    //     3                15
    //  1     4        10            20
    //    2          7      12     17    21
    //                 8                    24
    //                                  23
    // rebalanced (part 1)
    //          5
    //     3                15
    //  1     4        10            20
    //    2          7      12     17    21
    //                 8                    23
    //                                        24
    // rebalanced (part 2)
    //          5
    //     3                15
    //  1     4        10            20
    //    2         7      12     17       23
    //                8                 21     24
    //                                             25
    // rebalance
    //          5
    //     3                15
    //  1     4        10                   23
    //    2         7      12         20        24
    //                8            17     21         25
    //

    BinarySearchTree tree1 = new BinarySearchTree(5, 10, 4, 15, 20, 3, 12, 17, 1, 2, 7, 8, 21, 24, 23, 25);

    @Test
    public void testSize() {
        assertEquals(tree1.size, 16);
        assertTrue(tree1.isBalanced());

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
        assertEquals(15, tree1.size, 0);
        assertTrue(tree1.isBalanced());

        // root
        tree1.remove(5);
        assertEquals(false, tree1.search(5));
        assertEquals(14, tree1.size, 0);
        assertTrue(tree1.isBalanced());

        // not in tree
        tree1.remove(0);
        assertEquals(false, tree1.search(0));
        assertEquals(14, tree1.size, 0);
        assertTrue(tree1.isBalanced());

        // no children
        tree1.remove(17);
        assertEquals(false, tree1.search(17));
        assertEquals(13, tree1.size, 0);
        assertTrue(tree1.isBalanced());

        // one child
        tree1.remove(7);
        assertEquals(false, tree1.search(7));
        assertEquals(12, tree1.size, 0);
        assertTrue(tree1.isBalanced());

        //               8 (x)
        //       3                  20 (y)
        //  1        4        10             23
        //    2                  12       21    24
        //                                         25

        tree1.remove(1);
        assertTrue(tree1.isBalanced());

        //                     20 (y)
        //         8 (x)                  23
        //      3       10            21      24
        //  2        4     12                     25

        tree1.remove(2);
        assertTrue(tree1.isBalanced());

        tree1.remove(3);
        assertTrue(tree1.isBalanced());

        tree1.remove(4);
        assertTrue(tree1.isBalanced());

        //                  20
        //         10               23
        //      8       12      21      24
        //                                  25

        assertEquals(8, tree1.size, 0);

    }
}
