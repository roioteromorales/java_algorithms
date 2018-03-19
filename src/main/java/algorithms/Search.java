package algorithms;

import java.util.concurrent.*;

public class Search {

    private static long startTime;
    private static long count;

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

            // split search into separate tasks
            int tasks = 1000;
            int taskSize = data.length / tasks;

            // instantiate outer class so that inner class can be instantiated
            Search selfReference = new Search();

            // completion service to run tasks and return results
            ExecutorService service = Executors.newFixedThreadPool(tasks);
            CompletionService<Boolean> threads = new ExecutorCompletionService<>(service);

            // build array of tasks
            SearchTask[] taskArray = new SearchTask[tasks];
            for (int i = 0; i < tasks; i++) {
                // determine boundaries
                int left = i * taskSize;
                int right = (i * taskSize) + taskSize;

                // create task
                taskArray[i] = selfReference.new SearchTask(data, target, left, right);

                // start thread
                threads.submit(taskArray[i]);
            }

            // determine results
            System.out.print("\nParallel Searching for " + target);

            for (int i = 0; i < tasks; i++) {

                // pull in result when thread is finished
                boolean result = threads.take().get();

                // target found
                if (result) {
                    // print result
                    System.out.println("...found after " + count + " steps.");
                    long elapsedTime = (System.nanoTime() - startTime);
                    System.out.println("Time: " + elapsedTime + " nanoseconds. (Threads checked: " + i + ")");

                    // shutdown threading
                    service.shutdown();
                    return true;
                }
            }

            // target not found
            System.out.println("...not found after " + count + " steps.");
            long elapsedTime = (System.nanoTime() - startTime);
            System.out.println("Time: " + elapsedTime + " nanoseconds. (Threads checked: " + tasks + ")");

            // shutdown threading
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
