package linked_list;

public class SingleLinkedList {
    private Node start;

    public SingleLinkedList(String ... data) {
        if (data.length < 1) {
            start = null;
        } else {
            for (int i = 0; i < data.length; i++) {
                add(data[i]);
            }
        }
    }

    // Adds the given data to the end of the list
    public void add(String data) {
        if (start == null) {
            start = new Node(data);
        } else {
            Node iterator = start;

            // iterator through list to find last node
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = new Node(data);
        }
    }

    // Removes the node at the given index
    public void remove(int index) { // SHOULD THIS THROW EXCEPTION??
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

    // Returns the value at the given index
    public String get(int index) {
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
            return "invalid index";
        }

    }

    // Sets the value of the given index to the given data
    public void set(int index, String data) {
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

    // Returns the size of the list
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

    // Converts list values into String
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

    private class Node {
        String data;
        Node next;

        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(String data) {
            this.data = data;
            this.next = null;
        }

        public Node(String data, Node node) {
            this.data = data;
            this.next = node;
        }
    }

}


