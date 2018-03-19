package algorithms;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {
    public static final Number[] unsorted = {1, 5, 3, 7, 8, 4, 6, 10, 9, 2};
    public static final Number[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void testBubbleSort() {
        assertArrayEquals(Sort.bubbleSort(unsorted), sorted);
    }

    @Test
    public void testInsertionSort() {
        assertArrayEquals(Sort.insertionSort(unsorted), sorted);
    }

    @Test
    public void testSelectionSort() {
        assertArrayEquals(Sort.selectionSort(unsorted), sorted);
    }

    @Test
    public void testMergeSort() {
        assertArrayEquals(Sort.mergeSort(unsorted), sorted);
    }

    @Test
    public void testQuickSort() {
        assertArrayEquals(Sort.quickSort(unsorted), sorted);
    }
}
