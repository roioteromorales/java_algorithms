import algorithms.Sort;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SortTest {
    public static final Number[] unsorted = {1, 5, 3, 7, 8, 4, 6, 10, 9, 2};
    public static final Number[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    void testBubbleSort() {
        assertEquals(Sort.bubbleSort(unsorted), sorted);
    }
}
