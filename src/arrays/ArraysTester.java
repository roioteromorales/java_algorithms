package arrays;

public class ArraysTester {
    public static final int SIZE = 1000;
    public static final int MIN = 0;
    public static final int MAX = 100;

    public static void main(String[] args) {
        // sample data
        int[] data = new int[SIZE];

        for (int i = 0; i < data.length; i++) {
            data[i] = (int)(Math.random() * MAX + MIN);
        }

        // test linear search
        int target = 50;
        System.out.println("Target " + target + " " + Search.linearSearch(data, target));

        target = 1000;
        System.out.println("Target " + target + " " + Search.linearSearch(data, target));

    }
}
