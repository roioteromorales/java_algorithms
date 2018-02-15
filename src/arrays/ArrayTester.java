package arrays;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

public class ArrayTester {
    public static final int SIZE = 10;
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

        // test search
        int target = 5;
        System.out.println("LinearSearch: " + target + " " + Search.linearSearch(dataSorted, target));
        System.out.println("BinarySearch: " + target + " " + Search.binarySearch(dataSorted, target));
        System.out.println("BinaryNonRecursiveSearch: " + target + " " + Search.binaryNonRecursiveSearch(dataSorted, target));

        System.out.println();

        target = 1500;
        System.out.println("LinearSearch: " + target + " " + Search.linearSearch(dataSorted, target));
        System.out.println("BinarySearch: " + target + " " + Search.binarySearch(dataSorted, target));
        System.out.println("BinaryNonRecursiveSearch: " + target + " " + Search.binaryNonRecursiveSearch(dataSorted, target));


        // test sort
        System.out.println("\nSORT");

        System.out.println("\nOriginal: ");
        printArray(dataUnsorted);

        System.out.println("\n\nSorted: ");
        Sort.mergeSort(dataUnsorted);
        printArray(dataUnsorted);

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(String.format("%02d", array[i]) + " ");
            if (i > 0 && (i + 1) % 30 == 0) {
                System.out.println();
            }
        }
    }

}
