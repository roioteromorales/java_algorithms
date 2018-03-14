package arrays;

import java.util.concurrent.*;

public class ThreadedSearch {
    private static final int SIZE = 15000000; // 15 million

    public static void main(String[] args) {

        // generate data from 1 to SIZE
        int[] numArr = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            numArr[i] = i + 1;
        }

        // test threaded search
        search(numArr, 0);     // Not Found
        search(numArr, 3000000);  // Found in 1/3
        search(numArr, 8000000);  // Found in 2/3
        search(numArr, 12000000); // Found in 3/3
        search(numArr, 20000000); // Not Found

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

            // split search into separate tasks
            int taskSize = data.length / 3;
            ThreadedSearch selfReference = new ThreadedSearch();
            SearchTask task1 = selfReference.new SearchTask(data, target, 0, taskSize);
            SearchTask task2 = selfReference.new SearchTask(data, target, taskSize, taskSize * 2);
            SearchTask task3 = selfReference.new SearchTask(data, target, taskSize * 2, taskSize * 3);

            // run tasks
            ExecutorService service = Executors.newFixedThreadPool(3);
            Future<Boolean> future1 = service.submit(task1);
            Future<Boolean> future2 = service.submit(task2);
            Future<Boolean> future3 = service.submit(task3);

            // determine results
            boolean result1 = future1.get();
            boolean result2 = future2.get();
            boolean result3 = future3.get();

            // print results
            System.out.print("\nSearching for " + target);

            if (result1) {
                System.out.println("...found in 1/3.");
            }

            if (result2) {
                System.out.println("...found in 2/3.");
            }

            if (result3) {
                System.out.println("...found in 3/3.");
            }

            if (!result1 && !result2 && !result3) {
                System.out.println("...not found.");
            }

            long elapsedTime = (System.nanoTime() - startTime) / 1000000;
            System.out.println("Time: " + elapsedTime + " milliseconds.");

             // shutdown threading
            service.shutdown();

            // return true if found in any task
            return result1 || result2 || result3;

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


