package arrays;

public class Search {

    /* LINEAR SEARCH ALGORITHM
     * only supports integers
     */
    public static boolean linearSearch(int[] array, int target) {
       for (int n : array) {
           if (n == target) { return true; }
       }
       return false;
    }

    /* BINARY SEARCH ALGORITHM
     * only supports sorted arrays and integers
     */
    public static boolean binarySearch(int[] array, int target, int ... points) {
        // set boundaries
        int left = (points.length > 0) ? points[0] : 0;
        int right = (points.length > 1) ? points[1] : array.length - 1;
        int mid = array[(left + right) / 2];

        // if the boundaries cross, the element is not in the array
        if (left > right) { return false; }

        // recursion base case
        if (target == mid) {
            return true; // target found
        }
        // if target is less than midpoint
        else if (target < mid) {
            return binarySearch(array, target, left, mid - 1);
        }
        // if target is greater than midpoint
        else {
            return binarySearch(array, target, mid + 1, right);
        }
    }

}
