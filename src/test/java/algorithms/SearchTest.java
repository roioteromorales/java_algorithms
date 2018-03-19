package algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchTest {
    private static final int SIZE = 150000000; // 150 million

    @Test
    public void testBinarySearch() {
        // generate data from 1 to SIZE
        int[] numArr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numArr[i] = i + 1;
        }

        // tests
        assertEquals(Search.binarySearch(numArr, 0), false);
        assertEquals(Search.binarySearch(numArr, 30500000), true);
        assertEquals(Search.binarySearch(numArr, 80500000), true);
        assertEquals(Search.binarySearch(numArr, 120500000), true);
        assertEquals(Search.binarySearch(numArr, 250000000), false);
    }

    @Test
    public void testParallelSearch() {
        // generate data from 1 to SIZE
        int[] numArr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numArr[i] = i + 1;
        }

        //tests
        assertEquals(Search.parallelSearch(numArr, 0), false);
        assertEquals(Search.parallelSearch(numArr, 30500000), true);
        assertEquals(Search.parallelSearch(numArr, 80500000), true);
        assertEquals(Search.parallelSearch(numArr, 120500000), true);
        assertEquals(Search.parallelSearch(numArr, 250000000), false);
    }
}
