package arrays;

public class ArrayTester {
    public static final int SIZE = 1000;
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
        testLinearSearch();

        // test binary search
        testBinarySearch();

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
}
