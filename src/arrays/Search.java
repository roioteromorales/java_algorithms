package arrays;

public class Search {

    public static boolean linearSearch(int[] array, int target) {
       for (int n : array) {
           if (n == target) { return true; }
       }
       return false;
    }
}
