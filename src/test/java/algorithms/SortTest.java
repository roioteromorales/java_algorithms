package algorithms;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {
    public static final Number[] unsorted = {1, 5, 3, 7, 8, 4, 6, 10, 9, 2};
    public static final Number[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void testBubbleSort() {
        assertArrayEquals(sorted, Sort.bubbleSort(unsorted));
    }

    @Test
    public void testInsertionSort() {
        assertArrayEquals(sorted, Sort.insertionSort(unsorted));
    }

    @Test
    public void testSelectionSort() {
        assertArrayEquals(sorted, Sort.selectionSort(unsorted));
    }

    @Test
    public void testMergeSort() {
        assertArrayEquals(sorted, Sort.mergeSort(unsorted));
    }

    @Test
    public void testQuickSort() {
        assertArrayEquals(sorted, Sort.quickSort(unsorted));
    }
}
