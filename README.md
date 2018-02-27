# java_algorithms

This repository is for practicing algorithms and working with data structures in Java. Shout out to
[Harvard's CS50](https://cs50.harvard.edu/) for many of these program prompts.

## Arrays

### Search.java
This includes implementations of:
- **linear search -** this is an inefficient (stupid search) algorithm that simply iterates from beginning to end until the element is found
- **binary search - recursive -** this algorithm recursively divides the search in half until the element is found.
- **binary search - non recursive-** this algorithm searches an array by continuing to narrow the search boundaries by half
until the element is found.

### Sort.java
This includes implementations of:
- **bubble sort -** this comparison-based algorithm iteratively swaps pairs of elements until the array is sorted.
- **insertion sort** this comparison-based algorithm inserts each eliminated of the unsorted portion of the array into the
correct position in the sorted portion of the array.
- **selection sort -** this algorithm selects the smallest element of the unsorted portion of the array and places it in
the last position of the sorted portion of the array.
- **merge sort -** this is a divide and conquer algorithm that focuses on combining arrays that were presorted using recursion.
- **quick sort -** this is another divide and conquer algorithm that focuses on recursively choosing pivot points and swapping
elements so that smaller elements are left of the pivot point and larger elements are to the right.

Every method can work with Objects that extend Number.
You can test by running *ArrayTester.java*.

## Linked Lists
A [Linked List](https://en.wikipedia.org/wiki/Linked_list) is a linear data structure made up of a
collection of nodes, with one pointing to the next in sequence.

### SingleLinkedList.java
This is an implementation of generic single linked lists. Each node only references the next node.

### DoubleLinkedList.java
This is an implementation of generic double linked lists. This furthers the functionality of a single linked list by implementing
a reference to the previous node in addition to the next node.

You can test both types of linked lists by running *LinkedListTester.java*.

## Cryptography

### Caesar.java

This [Caesar Cipher](https://en.wikipedia.org/wiki/Caesar_cipher) implementation can encrypt/decrypt a string by passing
it to the *crypt method* with a key (negative key for decryption). You can test by running *CryptoTest.java*.

## Miscellaneous

### CreditCardValidator.java

The *validate method* returns a String indicating if the given number is AMEX, MASTERCARD, VISA or INVALID. The algorithm
checks the leading digits for the card type and uses the [Luhn Algorithm](https://en.wikipedia.org/wiki/Luhn_algorithm) to
ensure the credit card number is valid.

## Trees

### BinarySearchTree.java
This is an integer implementation of a sorted [Binary Search Tree (BST)](https://en.wikipedia.org/wiki/Binary_search_tree). A binary tree starts from a root node, and has
references to a left and right child node. A BST is a binary tree that requires the right child node to be greater than the left.

You can test by running *BinaryTreeTester.java*.

### Trie.java
This is a case-insensitive implementation of a [Trie](https://en.wikipedia.org/wiki/Trie). Each node of the trie has an array
of children representing the chars A-Z and the apostrophe char. A String is represented in the Trie with each char being a node,
and the final char/node has a boolean isWord set to true to indicate this position in the tree is a valid word.

You can test by running *SpellChecker.Java.* The program takes in austinpowers.txt (part of the Austin Powers script) and
checks if any words are missing from the given dictionary.txt. Using a trie greatly improves the performance over nested for
loops.
