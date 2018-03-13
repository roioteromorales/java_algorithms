package trees;

public class BinaryTreeTester {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(5, 10, 4, 15, 20, 3, 12, 17, 1, 2, 7, 8);

        System.out.println("Size: " + tree.size);

        System.out.println("Search 15: " + tree.search(15));

        System.out.println();

        tree.print();
        tree.remove(1);
        System.out.println("Removing 1...");

        System.out.println();

        tree.print();
        tree.remove(4);
        System.out.println("Removing 4...");

        tree.print();
        tree.remove(17);
        System.out.println("Removing 17...");

        tree.print();
        tree.remove(10);
        System.out.println("Removing 10...");

        tree.print();
        tree.remove(12);
        System.out.println("Removing 12...");




        tree.print();

        System.out.println("\nSize: " + tree.size);
        System.out.println("\nSearch 1: " + tree.search(1));
        System.out.println("\nSearch 4: " + tree.search(4));

    }

}
