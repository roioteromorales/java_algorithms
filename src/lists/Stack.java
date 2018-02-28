package lists;

public class Stack<V> {
    private SingleLinkedList<V> list = new SingleLinkedList<>();

    // adds item to stack
    public void push(V item) {
        // insert item into front of list
        list.insert(item, 0);
    }

    // removes and returns item from stack
    public V pop() {
        try {
            // get first item
            V item = list.get(0);
            // remove first item
            list.remove(0);
            // return first item
            return item;
        } catch (NullPointerException ex) {
            System.out.println("Exception" + ex);
            return null;
        }
    }


}
