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

        // create new root node
        if (node == null) {
            node = new Node(data);
            size++;
        }

        // move to left of tree
        if (data < node.data) {
            node.left = insert(data, node.left);
        }
        // move to right of tree
        else if (data > node.data){
            node.right = insert(data, node.right);
        }
        // prevent duplicates
        else {
            return node;
        }

        return rebalanceInsert(node, data);
    }

    /** HELPER METHOD
     * Rebalances tree after insertion
     * @param node root
     * @param data data added
     * @return root of balanced tree
     */
    private Node rebalanceInsert(Node node, int data) {

        // get heights of child nodes
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // update height of node to the greatest of its child heights
        node.height = 1 + Math.max(leftHeight, rightHeight);

        // calculate balance factor of node
        int balanceFactor = leftHeight - rightHeight;

        // left is bigger and new node is less than left
        if (balanceFactor > 1 && data < node.left.data) {
            //
            return rotateRight(node);
        }
        // right is bigger and new node is greater than right
        if (balanceFactor < -1 && data > node.right.data) {
            //
            return rotateLeft(node);
        }
        // left is bigger and new node is greater than left
        if (balanceFactor > 1 && data > node.left.data) {
            // rotate left first to get to simple case
            node.left = rotateLeft(node.left);
            // then do simple rotation
            return rotateRight(node);
        }
        // right is bigger and new node is less than right
        if (balanceFactor < -1 && data < node.right.data) {
            // rotate right first to get to simple case
            node.right = rotateRight(node.right);
            // then do simple rotation
            return rotateLeft(node);
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
        System.out.println("removing " + target);
        root = remove(target, root);
    }

    /** HELPER METHOD
     * Recursively removes a value from the tree
     * @param target value to be removed
     * @param node node for recursive calls
     * @return node for recursive calls
     */
    private Node remove(int target, Node node) {

        // move recursively left
        if (target < node.data) {
            node.left = remove(target, node.left);
        }
        // move recursively right
        else if (target > node.data){
            node.right = remove(target, node.right);
        }
        // currently at the target Node
        else {

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
            }

        }

        return rebalanceRemove(node);
    }

    /** HELPER METHOD
     * Rebalances tree after removal
     * @param node root
     * @return root of balanced tree
     */
    private Node rebalanceRemove(Node node) {

        // update height
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        node.height = 1 + Math.max(leftHeight, rightHeight);

        // calculate balance factor of node
        int balanceFactor = leftHeight - rightHeight;

        // calculate left balance
        leftHeight = 0;
        rightHeight = 0;
        if (node.left != null) {
            leftHeight = height(node.left.left);
            rightHeight = height(node.left.right);
        }
        int balanceLeft = leftHeight - rightHeight;

        // calculate right balance
        leftHeight = 0;
        rightHeight = 0;
        if (node.right != null) {
            leftHeight = height(node.right.left);
            rightHeight = height(node.right.right);
        }
        int balanceRight = leftHeight - rightHeight;

        // rebalance
        if (balanceFactor > 1 && balanceLeft >= 0) {
            return rotateRight(node);
        }
        if (balanceFactor > 1 && balanceLeft < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balanceFactor < -1 && balanceRight <= 0) {
            node =  rotateLeft(node);
            return node;
        }
        if (balanceFactor < -1 && balanceRight > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    /** HELPER METHOD
     * Rotates the node's left to the node position
     * @param
     * @return
     */
    private Node rotateRight(Node node) {
        Node child = node.left; // node's left child
        Node grandChild = child.right; // node's left child's right child

        // rotate
        child.right = node;
        node.left = grandChild;

        // update heights
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        node.height = 1 + Math.max(leftHeight, rightHeight);

        leftHeight = height(child.left);
        rightHeight = height(child.right);
        child.height = 1 + Math.max(leftHeight, rightHeight);

        return child;
    }

    /** HELPER METHOD
     * Rotates the node's right to the node position
     * @param
     * @return
     */
    private Node rotateLeft(Node node) {
        Node child = node.right;
        Node grandChild = child.left;

        // rotate
        child.left = node;
        node.right = grandChild;

        // update heights
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        node.height = 1 + Math.max(leftHeight, rightHeight);

        leftHeight = height(child.left);
        rightHeight = height(child.right);
        child.height = 1 + Math.max(leftHeight, rightHeight);

        return child;
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

    /** HELPER METHOD
     * Gets the height of the given Node
     * @param node
     * @return
     */
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * Determines whether the tree has a logarithmic height
     * @return true if balanced, false if not balanced (the left and right side differ by more than 1)
     */
    public boolean isBalanced() {
        // get balance factor
        int balanceFactor = height(root.left) - height(root.right);

        // determine with the sides are within 1 level of each other
        return Math.abs(balanceFactor) <= 1;
    }

    /**
     * A Node of a Binary Tree
     */
    private class Node {
        Node left;
        Node right;
        int data;
        int height;

        Node (int data) {
            this.data = data;
            this.height = 1;
        }

    }
}



