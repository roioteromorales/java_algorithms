# Java Algorithms & Data Structures

This repository is for practicing algorithms and working with data structures in Java. Shout out to
[Harvard's CS50](https://cs50.harvard.edu/) and *Grokking Algorithms* for many of these program prompts.

## Arrays

**Search.java** includes implementations of:
- **linear search -** an inefficient (stupid search) algorithm that simply iterates from beginning to end until
the element is found.
- **binary search (recursive) -** an algorithm that recursively divides the search in half until the element is found.
- **binary search (non-recursive) -** an algorithm that searches an array by continuing to narrow the search boundaries by half
until the element is found.

**Sort.java** includes implementations of:
- **bubble sort -** a comparison-based algorithm that iteratively swaps pairs of elements until the array is sorted.
- **insertion sort -** a comparison-based algorithm that inserts each eliminated of the unsorted portion of the array into the
correct position in the sorted portion of the array.
- **selection sort -** an algorithm that selects the smallest element of the unsorted portion of the array and places it in
the last position of the sorted portion of the array.
- **merge sort -** a divide and conquer algorithm that focuses on combining arrays that were presorted using recursion.
- **quick sort -** another divide and conquer algorithm that focuses on recursively choosing pivot points and swapping
elements so that smaller elements are left of the pivot point and larger elements are to the right.

Every method can work with Objects that extend Number. You can test by running *ArrayTester.java*.

## Cryptography

**Caesar.java** is an implementation of [Caesar Cipher](https://en.wikipedia.org/wiki/Caesar_cipher). It can encrypt/decrypt a string by passing
it to the *crypt method* with a key (negative key for decryption). You can test by running *CryptoTest.java*.

## Graphs

**FileCrawler.java** uses [Breadth First Search (BFS)](https://en.wikipedia.org/wiki/Breadth-first_search) to find the
filepath in the subdirectory of several different starting points. BFS uses a Queue (see [Lists](https://github.com/kevgraham/java_algorithms#lists))
to check subdirectories in the order in which they are found.

**FlightRoutes.java** uses [Dijkstra's Algorithm](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm) to find the shortest
set of AirAsia routes between two airports. The algorithm uses the [Haversine distance](https://en.wikipedia.org/wiki/Haversine_formula)
in kilometers between the latitude and longitude of airports for its weights. The program uses data I cleaned from [https://openflights.org/](https://openflights.org/).
The airport data is loaded from *airports.csv* into a hashmap (see [Hash Maps](https://github.com/kevgraham/java_algorithms#hash-maps)),
which is used to retrieve the latitude and longitude when calculating route distances for the routes in *routes.cvs*. For the algorithm,
Airports are nodes and Routes are edges.

## Hash Maps

**HashMap.java** is an implementation for a generic hashmap that uses an internal array, a simple *hash method* based on
the first character of the key and a **Single Linked List** (see [Lists](https://github.com/kevgraham/java_algorithms#lists))
for collisions. A private inner class called *Pair* is used to store two pieces of data within a linked list node.
You can test by running *HashMapTester.java*.

## Lists
A [Linked List](https://en.wikipedia.org/wiki/Linked_list) is a linear data structure made up of a
collection of nodes, with one pointing to the next in sequence.

**SingleLinkedList.java** is an implementation of generic single linked lists, with each node only references the next node.
This is used for collisions in the Hash Map implementation (see [Hashmaps](https://github.com/kevgraham/java_algorithms#hash-maps)).

**DoubleLinkedList.java** is an implementation of generic double linked lists. This furthers the functionality of a
single linked list by implementing a reference to the previous node in addition to the next node.

**Stack.java** is an implementation of a [generic stack](https://en.wikipedia.org/wiki/Stack_(abstract_data_type)), which is
a special list that utilizes a First-In-First-Out methodology.

**Queue.java** is an implementation of a [generic queue](https://en.wikipedia.org/wiki/Queue_(abstract_data_type)). which is
a special list that utilizes a Last-In-First-Out methodology.

## Miscellaneous

**CreditCardValidator.java** has a *validate method* that returns a String indicating if the given number is AMEX, MASTERCARD,
VISA or INVALID. The algorithm checks the leading digits for the card type and uses the [Luhn Algorithm](https://en.wikipedia.org/wiki/Luhn_algorithm) to
ensure the credit card number is valid.

## Trees

**BinarySearchTree.java** is an integer implementation of a sorted [Binary Search Tree (BST)](https://en.wikipedia.org/wiki/Binary_search_tree).
A binary tree starts from a root node, and has references to left and right child nodes. A BST is a binary tree that
requires the right child node to be greater than the left. You can test by running *BinaryTreeTester.java*.

**Trie.java** is a case-insensitive implementation of a [Trie](https://en.wikipedia.org/wiki/Trie). Each node of the trie has an array
of children representing the chars A-Z and the apostrophe char. A String is represented in the Trie with each char being a node,
and the final char/node has a boolean isWord set to true to indicate this position in the tree is a valid word.

**SpellChecker.java** uses a *Trie* to determine if any words in *austinpowers.txt* (part of the Austin Powers script) are
missing from the given *dictionary.txt*. Using a trie greatly improves the performance over nested for loops.

