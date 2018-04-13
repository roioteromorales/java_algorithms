package data_structures;

public class DoubleLinkedList<T> {
    private Node start;

    public DoubleLinkedList(T ... data) {
        // no nodes
        if (data.length < 1) {
            start = null;
        }
        // convert parameters to nodes
        else {
            for (int i = 0; i < data.length; i++) {
                add(data[i]);
            }
        }
    }

    /**
     * Adds a new Node the given value to the end of the list
     * @param data to be added
     */
    public void add(T data) {
        insert(data, size());
    }

    /**
     * Inserts a Node with the given value at the given index
     * @param data to be added
     * @param index to add the Node
     */
    public void insert(T data, int index) {
        // create initial root node
        if (start == null) {
            start = new Node(data);
        } else {
            Node iterator = start;
            Node previous = null;

            if (index == 0) {
                start = new Node(data, start, null);
            }
            else if (index < size()) {
                // iterator through list to find index
                int count = 0;
                while (count != index) {

                    previous = iterator;
                    iterator = iterator.next;
                    count++;
                }

                // insert and relink
                previous.next = new Node(data, iterator, previous);
                iterator.prev = previous.next;

            }
            else {
                // iterate through list to end
                while (iterator.next != null) {
                    previous = iterator;
                    iterator = iterator.next;
                }

                // add node to end of list
                iterator.next = new Node(data);
                iterator.prev = previous;
            }
        }
    }

    /**
     * Removes the Node at the given index
     * @param index to remove the Node
     */
    public void remove(int index) {


        if (index == 0) {
            start = start.next;
        }
        else {
            try {
                Node iterator = start;
                Node previous = null;

                // iterator through list to find index
                int count = 0;
                while (count != index) {

                    previous = iterator;
                    iterator = iterator.next;
                    count++;
                }

                // remove and relink
                previous.next = iterator.next;
                iterator.next.prev = previous;

            } catch (NullPointerException ex) {
                System.out.println("invalid index");
            }

        }

    }

    /**
     * Returns the value at the give index
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
            System.out.println("invalid index");
            return null;
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

    /**
     * A Node of a Linked List
     */
    private class Node {
        T data;
        Node next;
        Node prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node(T data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
