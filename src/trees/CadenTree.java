//package trees;
//
//import java.util.*;
//
///**
// *This program is part of the portfolio using a binary search tree as the primary data structure
// *@author Caden MacKenzie
// *
// *I worked in collaboration with Collin Hartland and Gillian Hyde
// *some methods were taken from examples in the book and modified
// */
//
//public class BinarySearchTree{
//
//    private BinarySearchTreeNode root;
//    int count = 0;
//    int zipCounter = 0;
//    int zipSum = 0;
//    int stateCounter = 0;
//    int stateSum = 0;
//
//    private class BinarySearchTreeNode{
//        BinarySearchTreeNode left;
//        BinarySearchTreeNode right;
//        Object data;
//
//
//        //constructor
//        public BinarySearchTreeNode(){
//            left = null;
//            right = null;
//            data = null;
//        }
//
//        public BinarySearchTreeNode(Object n){//contructor
//            left = null;
//            left = null;
//            data = n;
//        }
//
//        public void setLeft(BinarySearchTreeNode n){//set left node
//            left = n;
//        }
//
//        public void setRight(BinarySearchTreeNode n){//set right node
//            right = n;
//        }
//
//        public BinarySearchTreeNode getLeft(){//get left node
//            return left;
//        }
//
//        public BinarySearchTreeNode getRight(){//get right node
//            return right;
//        }
//
//        public void setData(Object dataIn){//set data to node
//            data = dataIn;
//        }
//
//        public Object getData(){
//            return data;
//        }
//    }
//
//    public BinarySearchTree(){
//        root = null;
//    }
//
//    public boolean isEmpty(){//check if tree is empty
//        return root == null;
//    }
//    /**
//     *Adds item to the beginning of list
//     *@param the item to be added
//     */
//    public void insertDataInt(int data){//insert data, number
//        root = insertDataInt(root, data);
//    }
//    /**
//     *Adds integer into tree
//     *@param the item to be added
//     *@param the root node
//     *@return new node returned to public method above (recursion)
//     */
//    private BinarySearchTreeNode insertDataInt(BinarySearchTreeNode node, int data){
//        if(node == null){
//            node = new BinarySearchTreeNode(data);
//        }
//        else{
//            if(data <= (int)node.getData()){
//                node.left = insertDataInt(node.left, data);
//            }
//            else{
//                node.right = insertDataInt(node.right, data);
//            }
//        }
//        count++;
//        return node;
//    }
//
//    public void insertDataString(String data){//insert data, string
//        root = insertDataString(root, data);
//    }
//    /**
//     *Adds string into tree
//     *@param the item to be added
//     *@param the root node
//     *@return new node returned to public method above (recursion)
//     */
//
//    private BinarySearchTreeNode insertDataString(BinarySearchTreeNode node, String data){
//        if(node == null){
//            node = new BinarySearchTreeNode(data);
//        }
//        else{
//            if(data.compareTo(node.getData().toString()) <= 0){
//                node.left = insertDataString(node.left, data);
//            }
//            else{
//                node.right = insertDataString(node.right, data);
//            }
//        }
//        count++;
//        return node;
//    }
//
//    public void delete(int x){//delete int
//        if(isEmpty()){
//            System.out.println("The tree is empty");
//        }
//        else if(search(x) == false){
//            System.out.println(x + " is not present in tree");
//        }
//        else{
//            root = delete(root, x);
//            System.out.println(x + " has been deleted from the tree");
//            count--;
//        }
//    }
//    /**
//     *Removes integer from tree
//     *@param the item to be removed
//     *@param the root node
//     *@return new node returned to public method above (recursion)
//     */
//    private BinarySearchTreeNode delete(BinarySearchTreeNode root, int x){//delete int
//        BinarySearchTreeNode present, present2, n;
//        if((int)root.getData() == x){
//            BinarySearchTreeNode rightNode, leftNode;
//            rightNode = root.getRight();
//            leftNode = root.getLeft();
//            if(leftNode == null && rightNode == null){
//                return null;
//            }
//            else if(leftNode == null){
//                present = rightNode;
//                return present;
//            }
//            else if(rightNode == null){
//                present = leftNode;
//                return present;
//            }
//            else{
//                present2 = rightNode;
//                present = rightNode;
//                while(present.getLeft() != null){
//                    present = present.getLeft();
//                }
//                present.setLeft(leftNode);
//                return present2;
//            }
//        }
//        if (x < (int)root.getData()){
//            n = delete(root.getLeft(), x);
//            root.setLeft(n);
//        }
//        else{
//            n = delete(root.getRight(), x);
//            root.setRight(n);
//        }
//        return root;
//    }
//
//    public void deleteString(String x){//delete int
//        if(isEmpty()){
//            System.out.println("The tree is empty");
//        }
//        else if(searchString(x) == false){
//            System.out.println(x + " is not present in tree");
//        }
//        else{
//            root = deleteString(root, x);
//            System.out.println(x + " has been deleted from the tree");
//        }
//    }
//    /**
//     *Removes string from tree
//     *@param the item to be removed
//     *@param the root node
//     *@return new node returned to public method above (recursion)
//     */
//    private BinarySearchTreeNode deleteString(BinarySearchTreeNode root, String x){//delete int
//        BinarySearchTreeNode present, present2, n;
//        if(root.getData().toString().equals(x)){
//            BinarySearchTreeNode rightNode, leftNode;
//            rightNode = root.getRight();
//            leftNode = root.getLeft();
//            if(leftNode == null && rightNode == null){
//                return null;
//            }
//            else if(leftNode == null){
//                present = rightNode;
//                return present;
//            }
//            else if(rightNode == null){
//                present = leftNode;
//                return present;
//            }
//            else{
//                present2 = rightNode;
//                present = rightNode;
//                while(present.getLeft() != null){
//                    present = present.getLeft();
//                }
//                present.setLeft(leftNode);
//                return present2;
//            }
//        }
//        if (x.compareTo(root.getData().toString()) < 0){
//            n = deleteString(root.getLeft(), x);
//            root.setLeft(n);
//        }
//        else{
//            n = deleteString(root.getRight(), x);
//            root.setRight(n);
//        }
//        return root;
//    }
//
//    public int countNodes(){//counts number of nodes
//        return countNodes(root);
//    }
//    /**
//     *Counts number of nodes in the tree
//     *@param the root node
//     *@return number of nodes (recursion)
//     */
//    private int countNodes(BinarySearchTreeNode r){
//        if (r == null){
//            return 0;
//        }
//        else{
//            int L = 1;
//            L =+ countNodes(r.getLeft());
//            L += countNodes(r.getRight());
//            return L;
//        }
//    }
//
//    public boolean search(int value){//search for certain element
//        return search(root, value);
//    }
//    /**
//     *Searches for a certain int by traversing tree
//     *@param the root node
//     *@param the value of the int
//     *@return whether or not the int is present
//     */
//    private boolean search(BinarySearchTreeNode c, int value){
//        boolean found = false;
//        while ((c != null) && !found){
//            int cvalue = (int)c.getData();
//            if (value < cvalue){
//                c = c.getLeft();
//            }
//            else if(value > cvalue){
//                c = c.getRight();
//            }
//            else{
//                found = true;
//                break;
//            }
//            found = search(c, value);
//        }
//        return found;
//    }
//
//    public boolean searchString(String value){//search for certain element
//        return searchString(root, value);
//    }
//    /**
//     *Searches for a certain string by traversing tree
//     *@param the root node
//     *@param the value of the string
//     *@return whether or not the string is present
//     */
//    private boolean searchString(BinarySearchTreeNode c, String value){
//        boolean found = false;
//        while ((c != null) && !found){
//            String cvalue = c.getData().toString();
//            if (value.compareTo(cvalue) < 0){
//                c = c.getLeft();
//            }
//            else if(value.compareTo(cvalue) > 0){
//                c = c.getRight();
//            }
//            else{
//                found = true;
//                break;
//            }
//            found = searchString(c, value);
//        }
//        return found;
//    }
//
//    public void inOrder(){//in order traversal of tree
//        inOrder(root);
//    }
//    /**
//     *Traverses tree in order and prints tree out
//     *@param the root node
//     *@return prints out the tree in order
//     */
//    private void inOrder(BinarySearchTreeNode c){
//        if (c != null){
//            inOrder(c.getLeft());
//            System.out.print(c.getData() + "\n");
//            inOrder(c.getRight());
//        }
//    }
//    /**
//     *Traverses tree in pre order and prints tree out
//     *@param the root node
//     *@return prints out the tree in pre order
//     */
//    public void preorder(){
//        preorder(root);
//    }
//    private void preorder(BinarySearchTreeNode c){
//        if( c != null){
//            System.out.print(c.getData() + "\n");
//            preorder(c.getLeft());
//            preorder(c.getRight());
//        }
//    }
//    /**
//     *Traverses tree in post order and prints tree out
//     *@param the root node
//     *@return prints out the tree in post order
//     */
//    public void postorder(){//postorder traversal
//        postorder(root);
//    }
//    private void postorder(BinarySearchTreeNode c){
//        if (c != null){
//            postorder(c.getLeft());
//            postorder(c.getRight());
//            System.out.print(c.getData() + "\n");
//        }
//    }
//    /**
//     *Finds the height of the tree
//     *is not working needs revision
//     */
//    public int findHeight(BinarySearchTreeNode height){//Function to find the height of the tree
//        if(height == null) {
//            return -1;
//        }
//        int leftheight = findHeight(height.getLeft());
//        int rightheight = findHeight(height.getRight());
//        if(leftheight > rightheight) {
//            return leftheight + 1;
//        }
//        else {
//            return rightheight + 1;
//        }
//    }
//    /**
//     *Recursive methods below find all individual donors that donated greater than X
//     *@param the root node
//     *@param the input amount
//     *@return prints all donors with amounts greater than X
//     */
//    public void getIndivid(int input){
//        getIndivid(root, input);
//    }
//    private void getIndivid(BinarySearchTreeNode z, int input){
//        BinarySearchTree treeGreaterX = new BinarySearchTree();
//        if (z != null){
//            DonorElement infoDonor = new DonorElement();
//            getIndivid(z.getLeft(), input);
//            Object donorInfo = z.getData();
//            String donorInfo2 = donorInfo.toString();
//
//            infoDonor.donorElement(donorInfo);
//            int cont = infoDonor.getDonation();
//            if (cont > input){
//                System.out.println(infoDonor.getFirstName() + " " + infoDonor.getLastName());
//
//            }
//            getIndivid(z.getRight(), input);
//
//        }
//        //treeGreaterX.inOrder();
//    }
//    /**
//     *Searches each donor information for matching zip code from user
//     *@param the root node
//     *@param the input zip code as a string
//     *@return prints out the list of donors with matching zip codes (recursion)
//     */
//    public void getZipCode(String zip){
//        getZipCode(root, zip);
//    }
//    private void getZipCode(BinarySearchTreeNode y, String zip){
//        BinarySearchTree matchingCode = new BinarySearchTree();
//        if (y != null){
//            DonorElement infoDonor = new DonorElement();
//            getZipCode(y.getLeft(), zip);
//            Object donorInfo = y.getData();
//            String donorInfo2 = donorInfo.toString();
//            infoDonor.donorElement(donorInfo);
//            String zip1 = infoDonor.getZipCode();
//            if(zip1.equals(zip)){
//                System.out.println(infoDonor.getFirstName() + " " + infoDonor.getLastName() + " " + infoDonor.getZipCode());
//            }
//            getZipCode(y.getRight(), zip);
//        }
//    }
//    /**
//     *Finds statistics on all individuals from a certain zip code
//     *@param the root node
//     *@param user input zip code as string
//     *@return prints out the average and total donation from zip code (recursion)
//     */
//    public void getZipCodeStats(String zip){
//        getZipCodeStats(root, zip);
//    }
//    private void getZipCodeStats(BinarySearchTreeNode x, String zip){
//        if (x != null){
//            DonorElement infoDonor = new DonorElement();
//            getZipCodeStats(x.getLeft(), zip);
//            Object donorInfo = x.getData();
//            String donorInfo2 = donorInfo.toString();
//            infoDonor.donorElement(donorInfo);
//            String zip1 = infoDonor.getZipCode();
//            int donation = infoDonor.getDonation();
//            if(zip1.equals(zip)){
//                zipSum = zipSum + donation;
//                zipCounter++;
//
//            }
//            getZipCodeStats(x.getRight(), zip);
//
//        }
//
//    }
//    public void zipCodeStats(){
//        if (zipCounter != 0){
//            System.out.println("Here is the total contribution in this area: " + zipSum);
//            int average = (zipSum/zipCounter);
//            System.out.println("The average contribution is: " + average);
//        }
//        else{
//            System.out.println("No donors from this area");
//        }
//    }
//    /**
//     *Same function as the zip code statistics
//     *@param the root node
//     *@param the user input state as a string
//     *@return prints out statistics
//     */
//    public void getStateStats(String state){
//        getStateStats(root, state);
//    }
//    private void getStateStats(BinarySearchTreeNode x, String state){
//        if (x != null){
//            DonorElement infoDonor = new DonorElement();
//            getStateStats(x.getLeft(), state);
//            Object donorInfo = x.getData();
//            String donorInfo2 = donorInfo.toString();
//            infoDonor.donorElement(donorInfo);
//            String state1 = infoDonor.getState();
//            int donation = infoDonor.getDonation();
//            if(state1.equalsIgnoreCase(state)){
//                stateSum = stateSum + donation;
//                stateCounter++;
//
//            }
//            getStateStats(x.getRight(), state);
//
//        }
//
//    }
//    public void stateStats(){
//        if (stateCounter != 0){
//            System.out.println("Here is the total contribution for this state: " + stateSum);
//            int average = (stateSum/stateCounter);
//            System.out.println("The average contribution is for this state: " + average);
//        }
//        else{
//            System.out.println("No donors from this state");
//        }
//    }
//
//    /**
//     *Searches all elements in tree and sorts by donation
//     *Failed method because the donation amount is a string
//     *@param the root node
//     *@return prints out new list in order of donation
//     */
//    public void getTopTen(){
//        getTopTen(root);
//    }
//    private void getTopTen(BinarySearchTreeNode t){
//        BinarySearchTree topTen = new BinarySearchTree();
//        if (t != null){
//            DonorElement infoDonor = new DonorElement();
//            getTopTen(t.getLeft());
//            getTopTen(t.getRight());
//            Object donorInfo = t.getData();
//            String donorInfo2 = donorInfo.toString();
//            infoDonor.donorElement(donorInfo);
//            //int donation = infoDonor.getDonation();
//            String newInfo = (infoDonor.getDonation() + "," + infoDonor.getFirstName() + "," + infoDonor.getLastName() + "," + infoDonor.getAddress() + "," + infoDonor.getCity() + "," + infoDonor.getState() + "," + infoDonor.getZipCode() + "," + infoDonor.getDate());
//            topTen.insertDataString(newInfo);
//        }
//
//        topTen.inOrder();
//    }
//
//
//
//
//}
