package algorithms;

import java.util.concurrent.*;

public class Search {

    private static final int MILLION = 1000000; //
    private static final int SIZE = 150 * MILLION; // 150 million

    private static long startTime;
    private static long count;


    public static void main(String[] args) {

        // generate data from 1 to SIZE
        int[] numArr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numArr[i] = i + 1;
        }

        int[] testCases = {0, 30500000, 80500000, 120500000, 250000000}; // Output: False, True, True, True, False

        for (int target : testCases) {
            binarySearch(numArr, target);
            parallelSearch(numArr, target);
            System.out.println("\n-------------------------------------");
        }

    }

    /**
     * Searches through the array using Binary Search Recursively
     * @param array to be searched
     * @param target a number to search for
     * @param points used for recursion to track boundaries
     * @return whether the target is in the array
     */
    public static boolean binarySearch(int[] array, int target, int ... points) {

        // tracking data
        if (points.length <= 0) {
            startTime = System.nanoTime();
            count = 1;
            System.out.print("\nBinary Searching for " + target);
        }

        // set boundaries
        int left = (points.length > 0) ? points[0] : 0;
        int right = (points.length > 1) ? points[1] : array.length - 1;
        int mid = (left + right) / 2;

        // if the boundaries cross, the element is not in the array
        if (left > right) {
            System.out.println("...not found.");
            // print time
            long elapsedTime = (System.nanoTime() - startTime);
            System.out.println("Time: " + elapsedTime + " nanoseconds.");
            return false;
        }

        // recursion base case
        if (target == array[mid]) {
            System.out.println("...found after " + count + " steps");
            // print time
            long elapsedTime = (System.nanoTime() - startTime);
            System.out.println("Time: " + elapsedTime + " nanoseconds.");
            return true; // target found
        }
        // if target is less than midpoint
        else if (target < array[mid]) {
            count++;
            return binarySearch(array, target, left, mid - 1);
        }
        // if target is greater than midpoint
        else {
            count++;
            return binarySearch(array, target, mid + 1, right);
        }
    }

    /**
     * Searches through the array using Binary Search Non-Recursively
     * @param array to be searched
     * @param target a number to search for
     * @param <N> any Number Object
     * @return whether the target is in the array
     */
    public static <N extends Number> boolean binaryNonRecursiveSearch(N[] array, N target) {
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
            else if (target.doubleValue() < array[mid].doubleValue()) {
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

    /**
     * Searches through the data array for a given target using multi-threaded linear search
     * @param data to be searched
     * @param target to search for
     * @return true if the data is found, false if it is not
     */
    public static boolean parallelSearch(int[] data, int target) {
        try {
            // time search
            startTime = System.nanoTime();
            count = 0;

            // split search into 300 separate tasks
            int tasks = 300;
            int taskSize = data.length / tasks;

            // instantiate outer class so that inner class can be instantiated
            Search selfReference = new Search();

            // create tasks
            SearchTask[] taskArray = new SearchTask[tasks];
            for (int i = 0; i < tasks; i++) {
                int left = i * taskSize;
                int right = (i * taskSize) + taskSize;
                taskArray[i] = selfReference.new SearchTask(data, target, left, right);

                //System.out.println("Task " + (i + 1) + ": " + (left / MILLION) + " million to "
                //                   + (right / MILLION) + " million");
            }

            // run tasks
            ExecutorService service = Executors.newFixedThreadPool(3);
            Future[] futureArray = new Future[tasks];
            for (int i = 0; i < tasks; i++) {
                futureArray[i] = service.submit(taskArray[i]);
            }

            // determine results
            System.out.print("\nParallel Searching for " + target);

            for (int i = 0; i < tasks; i++) {
                // pull in result when thread is finished
                boolean result = (boolean)futureArray[i].get();

                // target found
                if (result) {
                    // print result
                    System.out.println("...found after " + count + " steps.");
                    long elapsedTime = (System.nanoTime() - startTime);
                    System.out.println("Time: " + elapsedTime + " nanoseconds.");

                    // shutdown threading
                    service.shutdown();
                    return true;
                }
            }

            // target not found
            System.out.println("...not found.");
            long elapsedTime = (System.nanoTime() - startTime);
            System.out.println("Time: " + elapsedTime + " nanoseconds.");

            service.shutdown();
            return false;

        } catch (InterruptedException ex1) {
            System.out.println("Search Failed.");
            System.out.println(ex1);
            return false;
        } catch (ExecutionException ex2) {
            System.out.println("Search Failed.");
            System.out.println(ex2);
            return false;
        }
    }

    /**
     * SearchTask searches chunks of data given to it for the target
     */
    private class SearchTask implements Callable<Boolean> {
        private int[] data;
        private int target;
        private int left;
        private int right;

        SearchTask(int[] data, int target, int left, int right) {
            this.data = data;
            this.target = target;
            this.left = left;
            this.right = right;
        }

        public Boolean call() {
            // search data within boundaries
            for (int i = left; i < right; i++) {
                count++;
                if (data[i] == target) {
                    return true;
                }
            }
            return false;
        }
    }
}
