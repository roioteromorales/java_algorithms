package trees;

public class BinarySearchTree {
    Node root;

    BinarySearchTree(int ... data) {
        if (data.length < 1) {
            root = null;
        } else {
            for (int i = 0; i < data.length; i++) {
                insert(data[i]);
            }
        }
    }

    void insert(int data) {
        // create initial root node
        if (root == null) {
            root = new Node(data);
        }
        //
        else {
            Node iterator = root;

            // iterate until node is added
            while (true) {
                // check left node
                if (data < iterator.data) {
                    // move down one node
                    if (iterator.left != null) {
                        iterator = iterator.left;
                    }
                    // add new node
                    else if (iterator.left == null) {
                        iterator.left = new Node(data);
                        return;
                    }
                }
                // check right
                else {
                    // move down one node
                    if (iterator.right != null) {
                        iterator = iterator.right;
                    }
                    // add new node
                    else if (iterator.right == null) {
                        iterator.right = new Node(data);
                        return;
                    }
                }
            }
        }
    }

    void remove(int target) {
        // call helper remove method
        remove(target, root);
    }

    void remove(int target, Node node) {
        Node iterator = node;
        Node parent = null;

        // iterate to find the node to be removed
        while (iterator.data != target) {
            if (target < iterator.data) {
                parent = iterator;
                iterator = iterator.left;
            }
            else if (target > iterator.data) {
                parent = iterator;
                iterator = iterator.right;
            }

            if (iterator == null) {
                System.out.println("data not found.");
                return;
            }
        }

        System.out.println("...item found");
        // remove root node
        if (parent == null) {

        }
        // remove node with no children
        else if (iterator.left == null && iterator.right == null){
            System.out.println("...setting item to null");
             iterator = null;
        }

    }

    boolean search(int target) {
        // call the search helper method
        return search(target, root);
    }

    boolean search(int target, Node node) {
        // make sure end of branch hasn't been reached
        if (node != null) {
            // target found
            if (node.data == target) {
                return true;
            }
            // follow the left branch
            else if (target < node.data) {
                return search(target, node.left);
            }
            // follow the right branch
            else if (target > node.data) {
                return search(target, node.right);
            }
        }

        return false;
    }

    void print() {

        int level = 0;

        if (root == null) {
            System.out.println("The tree is empty");
        } else {
            // print
            System.out.print(root.data);

            // move down tree
            if (root.left != null) { print(root.left, level + 1); }
            if (root.right != null) { print(root.right, level + 1); }
            System.out.println();
        }
    }

    void print(Node node, int level) {
        // print
        System.out.println();

        for (int i = 0; i < level - 1; i++) {
            System.out.print("     ");
        }

        System.out.print("  --> " + node.data);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        // move down tree
        if (node.left != null) { print(node.left, level + 1); }
        if (node.right != null) { print(node.right, level + 1); }

    }

    int size(Node ... accum) {
        int count;
        Node iterator = null;

        // default to root
        if (accum.length != 1) {
            count = 0;
            iterator = root;
        }
        // iterate down with recursive calls
        if (accum.length == 1) {
            iterator = accum[0];
        }
        // base case (iterator is not a node)
        if (iterator == null) {
            return 0;
        }
        // increment case (iterator is a leaf)
        else if (iterator != null && iterator.left == null && iterator.right == null) {
            return 1;
        }
        // recursive call (iterator is a branch)
        else {
            return 1 + size(iterator.left) + size(iterator.right);
        }
    }

    private class Node {
        Node left;
        Node right;
        int data;

        Node (int data) {
            this.data = data;
        }
    }
}


