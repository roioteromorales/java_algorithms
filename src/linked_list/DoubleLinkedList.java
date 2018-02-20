package linked_list;

public class DoubleLinkedList<T> {
    private Node start;

    public DoubleLinkedList(T ... data) {
        if (data.length < 1) {
            start = null;
        } else {
            for (int i = 0; i < data.length; i++) {
                add(data[i]);
            }
        }
    }


    // Adds value to end of the list
    public void add(T data) {
        insert(data, size());
    }

    // Inserts value at the given index
    public void insert(T data, int index) {
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

                previous.next = new Node(data, iterator, previous);
                iterator.prev = previous.next;

            }
            else {
                // iterate through list to end
                while (iterator.next != null) {
                    previous = iterator;
                    iterator = iterator.next;
                }

                iterator.next = new Node(data);
                iterator.prev = previous;
            }
        }
    }

    public void remove(int index) {
        Node iterator = start;
        Node previous = null;

        if (index == 0) {
            start = start.next;
        }
        else {
            try {
                // iterator through list to find index
                int count = 0;
                while (count != index) {

                    previous = iterator;
                    iterator = iterator.next;
                    count++;
                }

                previous.next = iterator.next;
                iterator.next.prev = previous;

            } catch (NullPointerException ex) {
                System.out.println("invalid index");
            }

        }

    }

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
