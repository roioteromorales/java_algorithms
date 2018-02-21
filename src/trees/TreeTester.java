package trees;

public class TreeTester {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(5, 10, 4, 15, 20, 3, 12, 17, 1 ,4);

        System.out.println("Size: " + tree.size());

        tree.print();
    }

}
