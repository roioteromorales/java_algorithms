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

    /* BINARY SEARCH ALGORITHM WITH RECURSION
     * only supports sorted integer arrays
     */
    public static boolean binarySearch(int[] array, int target, int ... points) {
        // set boundaries
        int left = (points.length > 0) ? points[0] : 0;
        int right = (points.length > 1) ? points[1] : array.length - 1;
        int mid = (left + right) / 2;

        // if the boundaries cross, the element is not in the array
        if (left > right) { return false; }

        // recursion base case
        if (target == array[mid]) {

            return true; // target found
        }
        // if target is less than midpoint
        else if (target < array[mid]) {
            return binarySearch(array, target, left, mid - 1);
        }
        // if target is greater than midpoint
        else {
            return binarySearch(array, target, mid + 1, right);
        }
    }

    /* BINARY SEARCH ALGORITHM WITHOUT RECURSION
     * only supports sorted integer arrays
     */
    public static boolean binaryNonRecursiveSearch(int [] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int mid;

        // while boundaries do not cross
        while (left < right) {
            // get midpoint
            mid = (left + right) / 2;

            if (target == array[mid]) {
                return true; // target found
            }
            // if target is less than midpoint
            else if (target < array[mid]) {
                // adjust boundary
                right = mid - 1;
            }
            // if target is greater than midpoint
            else {
                // adjust boundary
                left = mid + 1;
            }
        }

        // item not found
        return false;
    }
}
