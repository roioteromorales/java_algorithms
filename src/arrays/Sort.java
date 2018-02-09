package arrays;

public class Sort {

    /* BUBBLE SORT
     *
     */
    public static int[] bubbleSort(int[] array) {
        boolean sorted;

        if(array.length < 2) {
            return array;
        }

        // do at least once or until sorted
        do {
            sorted = true;
            // iterate through array
            for (int i = 1; i < array.length; i++) {
                // check if a pair is in the correct order
                if (array[i] >= array[i - 1]) {
                    continue;
                } else {
                    // swap if they are not
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    sorted = false;
                }
            }
        } while (!sorted);

        return array;
    }
}
