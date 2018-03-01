package lists;

public class Queue<V> {
    private SingleLinkedList<V> list = new SingleLinkedList<>();

    // adds item to stack
    public void enqueue(V item) {
        // insert item into front of list
        list.add(item);
    }

    // removes and returns item from stack
    public V dequeue() {
        try {
            // get last item
            V item = list.get(0);
            // remove first item
            list.remove(0);
            // return first item
            return item;
        } catch (NullPointerException ex) {
            return null;
        }
    }
}
