package arrays;

public class Sort {

    /* BUBBLE SORT
     * only supports integer arrays
     */
    public static int[] bubbleSort(int[] array) {

        if (array.length < 2) {
            return array;
        }

        // iterate through array
        for (int i = 0; i < array.length; i++)
            // iterate through unsorted array
            for (int j = 0; j < array.length - i - 1; j++) {
                // check if a pair is in the incorrect order
                if (array[j] > array[j + 1]) {
                    // swap
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }

        return array;
    }





    /* INSERTION SORT
     * only supports integer arrays
     */
    public static int[] insertionSort(int[] array) {

        // iterate through original array
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            int j = i - 1;

            // push back to make room for num
            while (j >= 0 && array[j] > num) {
                array[j + 1] = array[j];
                j--;
            }

            // insert num
            array[j + 1] = num;
        }

        return array;
    }

    /* SELECTION SORT
     * only supports integer arrays
     */
    public static int[] selectionSort(int[] array) {
        int sorted = 0;

        // iterate until array is sorted
        while (sorted < array.length - 1) {
            int min = array[sorted];

            // find minimum item in unsorted portion of array
            for (int i = sorted; i < array.length; i++) {
                if (array[i] < array[min]) { min = i; }
            }

            // swap minimum item to front
            int temp = array[sorted];
            array[sorted] = array[min];
            array[min] = temp;

            sorted ++;
        }

        return array;
    }
}
