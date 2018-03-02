package lists;

public class Queue<V> {
    private SingleLinkedList<V> list = new SingleLinkedList<>();
    private boolean isEmpty;

    public Queue() {
        isEmpty = true;
    }
    // adds item to stack
    public void enqueue(V item) {
        // insert item into front of list
        list.add(item);
        isEmpty = false;
    }

    // removes and returns item from stack
    public V dequeue() {
        try {
            // get last item
            V item = list.get(0);

            // remove first item
            list.remove(0);

            // check if empty
            if (list.get(0) == null) {
                isEmpty = true;
            }

            // return first item
            return item;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
