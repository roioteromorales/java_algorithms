package algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchTest {
    private static final int SIZE = 1500000; // 1.5 million
    private int[] numArr = new int[SIZE];

    public SearchTest() {
        // generate data from 1 to SIZE
        for (int i = 0; i < SIZE; i++) {
            numArr[i] = i + 1;
        }
    }

    @Test
    public void testBinarySearch() {
        assertEquals(false, Search.binarySearch(numArr, 0));
        assertEquals(true, Search.binarySearch(numArr, 305000));
        assertEquals(true, Search.binarySearch(numArr, 805000));
        assertEquals(true, Search.binarySearch(numArr, 1205000));
        assertEquals(false, Search.binarySearch(numArr, 2500000));
    }

    @Test
    public void testParallelSearch() {
        assertEquals(false, Search.parallelSearch(numArr, 0));
        assertEquals(true, Search.parallelSearch(numArr, 305000));
        assertEquals(true, Search.parallelSearch(numArr, 805000));
        assertEquals(true, Search.parallelSearch(numArr, 1205000));
        assertEquals(false, Search.parallelSearch(numArr, 2500000));
    }
}
