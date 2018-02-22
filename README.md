# java_algorithms

This repository is for practicing algorithms and working with data structures in Java.

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

### SingleLinkedList.java
This is an implementation of generic single linked lists.


### DoubleLinkedList.java
This is an implementation of generic double linked lists.


You can test both types of linked lists by running *LinkedListTester.java*.
Methods include: add, insert, remove, get, set, size, toString.

## Cryptography

### Caesar.java

This [Caesar Cipher](https://en.wikipedia.org/wiki/Caesar_cipher) implementation can encrypt/decrypt a string by passing
it to the *crypt method* with a key (negative key for decryption).

You can test by running *CryptoTest.java*.

## Miscellaneous

### CreditCardValidator.java

The *validate method* returns a String indicating if the given number is AMEX, MASTERCARD, VISA or INVALID. The algorithm
checks the leading digits for the card type and uses the [Luhn Algorithm](https://en.wikipedia.org/wiki/Luhn_algorithm) to
ensure the credit card number is valid.

## Trees

### BinarySearchTree.java

This is an integer implementation of a sorted **Binary Search Tree**.
You can test by running *TreeTester.java*.