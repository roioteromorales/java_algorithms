package arrays;

public class ArrayTester {
    public static final int SIZE = 100;
    public static final int MIN = 0;
    public static final int MAX = 100;

    public static int[] dataUnsorted = new int[SIZE];
    public static int[] dataSorted = new int[SIZE];

    public static void main(String[] args) {
        // sample unsorted integer data
        for (int i = 0; i < dataUnsorted.length; i++) {
            dataUnsorted[i] = (int)(Math.random() * MAX + MIN);
        }

        //sample sorted integer data
        for (int i = 0; i < dataSorted.length; i++) {
            dataSorted[i] = i;
        }

        // test linear search
        //testLinearSearch();

        // test binary search
        //testBinarySearch();

        // test bubble sort
        //testBubbleSort();

        // test insertion sort
        testInsertionSort();

    }

    public static void testLinearSearch() {
        System.out.println("\nLINEAR SEARCH");

        int target = 50;
        System.out.println("Target " + target + " " + Search.linearSearch(dataUnsorted, target));

        target = 1500;
        System.out.println("Target " + target + " " + Search.linearSearch(dataUnsorted, target));
    }

    public static void testBinarySearch() {
        System.out.println("\nBINARY SEARCH");

        int target = 50;
        System.out.println("Target " + target + " " + Search.binarySearch(dataSorted, target));

        target = 1500;
        System.out.println("Target " + target + " " + Search.binarySearch(dataSorted, target));
    }

    public static void testBubbleSort() {
        System.out.println("\nBUBBLE SORT");

        System.out.println("\nOriginal: ");
        for (int i = 0; i < dataUnsorted.length; i++) {
            System.out.print(String.format("%02d", dataUnsorted[i]) + " ");
            if (i > 0 && (i + 1) % 30 == 0) {
                System.out.println();
            }
        }

        System.out.println("\n\nBubble Sorted: ");
        int[] sorted = Sort.bubbleSort(dataUnsorted);

        for (int i = 0; i < sorted.length; i++) {
            System.out.print(String.format("%02d", sorted[i]) + " ");
            if (i > 0 && (i + 1) % 30 == 0) {
                System.out.println();
            }
        }
    }

    public static void testInsertionSort() {
        System.out.println("\nINSERTION SORT");

        System.out.println("\nOriginal: ");
        for (int i = 0; i < dataUnsorted.length; i++) {
            System.out.print(String.format("%02d", dataUnsorted[i]) + " ");
            if (i > 0 && (i + 1) % 30 == 0) {
                System.out.println();
            }
        }

        System.out.println("\n\nBubble Sorted: ");
        int[] sorted = Sort.insertionSort(dataUnsorted);

        for (int i = 0; i < sorted.length; i++) {
            System.out.print(String.format("%02d", sorted[i]) + " ");
            if (i > 0 && (i + 1) % 30 == 0) {
                System.out.println();
            }
        }
    }

}
