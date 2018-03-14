package algorithms;

import algorithms.Sort;

public class ArrayTester {
    public static final int SIZE = 1000000;
    public static final int MIN = 0;
    public static final int MAX = 100;

    public static Number[] dataUnsorted = new Number[SIZE];
    public static Number[] dataSorted = new Number[SIZE];

    public static void main(String[] args) {
        // sample unsorted integer data
        for (int i = 0; i < dataUnsorted.length; i++) {
            if (i % 2 == 0) {
                dataUnsorted[i] = Math.random() * MAX + MIN;
            } else {
                dataUnsorted[i] = (int)(Math.random() * MAX + MIN);
            }
        }

        //sample sorted integer data
        for (int i = 0; i < dataSorted.length; i++) {
            dataSorted[i] = i;
        }

        // test search
//        int target = 5;
//        System.out.println("LinearSearch: " + target + " " + Search.linearSearch(dataSorted, target));
//        System.out.println("BinarySearch: " + target + " " + Search.binarySearch(dataSorted, target));
//        System.out.println("BinaryNonRecursiveSearch: " + target + " " + Search.binaryNonRecursiveSearch(dataSorted, target));
//
//        System.out.println();
//
//        target = 1500;
//        System.out.println("LinearSearch: " + target + " " + Search.linearSearch(dataSorted, target));
//        System.out.println("BinarySearch: " + target + " " + Search.binarySearch(dataSorted, target));
//        System.out.println("BinaryNonRecursiveSearch: " + target + " " + Search.binaryNonRecursiveSearch(dataSorted, target));


        // test sort
        System.out.println("\nSORT");

        System.out.println("\nOriginal: ");
        //printArray(dataUnsorted);

        System.out.println("\n\nSorted: ");
        Sort.bubbleSort(dataUnsorted);

    }

    public static <N extends Number> void printArray( N[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if (i > 0 && (i + 1) % 30 == 0) {
                System.out.println();
            }
        }
    }

}
