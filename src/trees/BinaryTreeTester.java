package trees;

public class BinaryTreeTester {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(5, 10, 4, 15, 20, 3, 12, 17, 1 ,4);


        System.out.println("Size: " + tree.size());


        System.out.println("Search 15: " + tree.search(15));


        tree.remove(1);
        System.out.println("Removing 1...");


        System.out.println("Search 1: " + tree.search(1));


        tree.print();
    }

}
