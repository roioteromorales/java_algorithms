package graphs;

public class FileCrawler {
    public static void main(String[] args) {
        System.out.println("\nThe path is " + BreadthFirstSearch.search("src","FileCrawler.java"));

        System.out.println();

        System.out.println("\nThe path is " + BreadthFirstSearch.search("trees","FileCrawler.java"));

        System.out.println();

        System.out.println("\nThe path is " + BreadthFirstSearch.search("src","README.me"));
    }
}
