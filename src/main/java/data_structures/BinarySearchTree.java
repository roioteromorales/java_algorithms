package data_structures;

public class BinarySearchTree {
    Node root;
    int size;

    BinarySearchTree(int ... data) {
        // initialize empty tree
        if (data.length < 1) {
            root = null;
        }
        // initialize tree with given data
        else {
            for (int i = 0; i < data.length; i++) {
                insert(data[i]);
            }
        }
    }

    /**
     * Adds an Integer to the tree
     * @param data to be added
     */
    public void insert(int data) {
        // if the tree is empty
        if (root == null) {
            root = new Node(data);
            size++;
        }
        // start the recursive helper method
        else {
            insert(data, root);
        }
    }

    /** HELPER METHOD
     * Recursively adds an Integer to the tree
     * @param data to be added
     * @param node the root node
     * @return new node recursively
     */
    private Node insert(int data, Node node) {
        // create new node
        if (node == null) {
            node = new Node(data);
            size++;
        } else {
            // move to left of tree
            if (data <= node.data) {
                node.left = insert(data, node.left);
            }
            // move to right of tree
            else {
                node.right = insert(data, node.right);
            }
        }

        return node;
    }

    /**
     * Removes a value from the tree
     * @param target value to be removed
     */
    public void remove(int target) {
        // make sure node exists
        if (!search(target)) {
            return;
        }

        // start the recursive helper method
        remove(target, root);
    }

    /** HELPER METHOD
     * Recursively removes a value from the tree
     * @param target value to be removed
     * @param node node for recursive calls
     * @return node for recursive calls
     */
    private Node remove(int target, Node node) {

        // currently at the target Node
        if (node.data == target) {

            // currently at a leaf Node
            if (node.left == null && node.right == null) {
                // delete current Node
                size--;
                return null;
            }
            // no left branch
            else if (node.left == null) {
                // delete current Node and link to right branch
                size--;
                return node.right;
            }
            // no right branch
            else if (node.right == null) {
                // delete current Node and link to left branch
                size--;
                return node.left;
            }
            // two branches
            else {
                // get the smallest node that's bigger than left node
                // swap its value to the current node position then remove the old node

                // start at the top of the right branch
                Node smallest = node.right;

                // iterate down the left to the smallest node
                while (smallest.left != null) {
                    smallest = smallest.left;
                }

                // swap current data with smallest
                int temp = node.data;
                node.data = smallest.data;
                smallest.data = temp;

                // remove old smallest node
                node.right = remove(target, node.right);

                return node;
            }
        }

        // recursive calls
        if (target < node.data) {
            // move left
            node.left = remove(target, node.left);
        } else {
            // move right
            node.right = remove(target, node.right);
        }

        return node;
    }

    /**
     * Searches the tree for the target value
     * @param target Integer to search for
     * @return whether the target value was found
     */
    boolean search(int target) {
        // call the search helper method
        return search(target, root);
    }

    /** HELPER METHOD
     * Recursively searches the tree for the target value
     * @param target Integer to search for
     * @param node root of the tree
     * @return whether the target value was found
     */
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

    /**
     * Prints the tree
     */
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

    /** HELPER METHOD
     * Recursively prints the tree
     * @param node current node (recursion)
     * @param level current level (recursion)
     */
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

    /**
     * A Node of a Binary Tree
     */
    private class Node {
        Node left;
        Node right;
        int data;

        Node (int data) {
            this.data = data;
        }
    }
}



