
import algorithms.Search;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchTest {
    private static final int MILLION = 1000000; //
    private static final int SIZE = 150 * MILLION; // 150 million

    @Test
    void testBinarySearch() {
        // generate data from 1 to SIZE
        int[] numArr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numArr[i] = i + 1;
        }

        assertEquals(Search.binarySearch(numArr, 2),
                    true);
    }
}
