package algorithms;

import algorithms.Search;
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

        assertEquals(Search.binarySearch(numArr, 2),
                    true);
    }
}
