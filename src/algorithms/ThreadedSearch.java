package algorithms;

import java.util.concurrent.*;

public class ThreadedSearch {
    private static final int MILLION = 1000000; //
    private static final int SIZE = 150 * MILLION; // 150 million

    public static void main(String[] args) {

        // generate data from 1 to SIZE
        int[] numArr = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            numArr[i] = i + 1;
        }

        // test threaded search
        search(numArr, 0);        // Not Found
        search(numArr, 3050000);  // Found
        search(numArr, 8050000);  // Found
        search(numArr, 12050000); // Found
        search(numArr, 25000000); // Not Found

    }

    /**
     * Searches through the data array for a given target using multi-threaded linear search
     * @param data to be searched
     * @param target to search for
     * @return true if the data is found, false if it is not
     */
    public static boolean search(int[] data, int target) {
        try {
            // time search
            long startTime = System.nanoTime();

            // split search into separate tasks less than 1 Million items
            int tasks = (data.length / MILLION);
            if (tasks == 0) { tasks++; } // ensure there is at least one thread

            int taskSize = data.length / tasks;

            // instantiate outer class so that inner class can be instantiated
            ThreadedSearch selfReference = new ThreadedSearch();

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
            System.out.print("\nSearching for " + target);

            boolean found = false;

            for (int i = 0; i < tasks; i++) {
                // pull in result when thread is finished
                boolean result = (boolean)futureArray[i].get();

                // target found
                if (result) {
                    found = true;
                    System.out.println("...found at " + ((i * taskSize) / MILLION) + " million to "
                                       + (((i * taskSize) + taskSize) / MILLION) + " million.");
                }
            }

            // target not found
            if(!found) {
                System.out.println("...not found.");
            }

            // print time
            long elapsedTime = (System.nanoTime() - startTime) / 1000000;
            System.out.println("Time: " + elapsedTime + " milliseconds.");
            System.out.println("------------------------------------------\n");

             // shutdown threading
            service.shutdown();

            // return boolean result
            return found;

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
                if (data[i] == target) {
                    return true;
                }
            }
            return false;
        }
    }
}


