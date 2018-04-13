package data_structures;

public class SingleLinkedList<T> {
    private Node start;

    public SingleLinkedList(T ... data) {
        if (data.length < 1) {
            start = null;
        } else {
            for (int i = 0; i < data.length; i++) {
                add(data[i]);
            }
        }
    }

    /**
     * Adds a new Node the given data to the end of the list
     * @param data to be added
     */
    public void add(T data) {
        insert(data, size());
    }

    /**
     * Inserts a new Node with the given data at the given index
     * @param data to be added
     * @param index to put the Node
     */
    public void insert(T data, int index) {
        // create new root node
        if (start == null) {
            start = new Node(data);
        } else {

            Node iterator = start;
            Node previous = null;

            // insert new node in front
            if (index == 0) {
                start = new Node(data, start);
            }
            else if (index < size()) {
                // iterate through list to find index
                int count = 0;

                while (count != index) {
                    previous = iterator;
                    iterator = iterator.next;
                    count++;
                }

                // create new node linked to previous node
                previous.next = new Node(data, iterator);

            }
            else {
                // iterator through list to find last node
                while (iterator.next != null) {
                    iterator = iterator.next;
                }
                iterator.next = new Node(data);
            }
        }
    }

    /**
     * Removes the Node at the given index
     * @param index to put the Node
     */
    public void remove(int index) {
        if (index == 0) {
            start = start.next;
        } else {
            try {
                int count = 0;
                Node previous = null;
                Node iterator = start;

                // iterate until index is reached
                while (count != index) {
                    previous = iterator;
                    iterator = iterator.next;
                    count++;
                }

                // link previous node to the node after the current
                previous.next = iterator.next;
            } catch (NullPointerException ex) {
                System.out.println("invalid index");
            }
        }
    }

    /**
     * Returns the value at the given index
     * @param index to get the value
     * @return the value at the index
     */
    public T get(int index) {
        try {
            int count = 0;
            Node iterator = start;

            // iterate until index is reach
            while (count != index) {
                iterator = iterator.next;
                count++;
            }
            return iterator.data;

        } catch (NullPointerException ex) {
            return null; // list is empty
        }
    }

    /**
     * Sets the value of the given index to the given data
     * @param index to put the data
     * @param data to be set
     */
    public void set(int index, T data) {
        try {
            int count = 0;
            Node iterator = start;

            // iterate through list
            while (count != index) {
                iterator = iterator.next;
                count++;
            }

            // change data
            iterator.data = data;

        } catch (NullPointerException ex) {
            System.out.println("invalid index");
        }
    }

    /**
     * Determines the size of the list
     * @return an Integer size
     */
    public int size() {
        int count = 0;
        Node iterator = start;

        // iterate through list
        while (iterator != null) {
            count++;
            iterator = iterator.next;
        }

        return count;
    }

    /**
     * Converts the list into a String
     * @return a human readable String
     */
    public String toString() {
        Node iterator = start;
        String output = "";

        // iterate through list
        while (iterator != null) {
            output += iterator.data + " ";
            iterator = iterator.next;
        }

        return output;
    }

    public boolean isEmpty() {
        return isEmpty();
    }

    /**
     * A Node of a Linked List
     */
    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node node) {
            this.data = data;
            this.next = node;

        }
    }

}


