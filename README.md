# java_algorithms

This repository is for practicing algorithms and working with data structures in Java. Shout out to
[Harvard's CS50](https://cs50.harvard.edu/) for many of these program prompts.

## Arrays

### Search.java
This includes implementations of:
- **linear search**
- **binary search - recursive**
- **binary search - non recursive**

### Sort.java
This includes implementations of:
- **bubble sort**
- **insertion sort**
- **selection sort**
- **merge sort**

Every method can work with objects that extend Number.
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
This is a case-insensitive implementation of a [trie](https://en.wikipedia.org/wiki/Trie). Each node of the trie has an array
of children representing the 26 chars A-Z and the apostrophe char.

You can test by running *SpellChecker.Java.* The program takes in austinpowers.txt (part of the Austin Powers script) and
checks if any words are missing from the given dictionary.txt. Using a trie greatly improves the performance over nested for loops.
