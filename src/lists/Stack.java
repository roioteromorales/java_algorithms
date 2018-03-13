package lists;

public class Stack<V> {
    private SingleLinkedList<V> list = new SingleLinkedList<>();

    /**
     * Adds an item to the stack
     * @param item to be added
     */
    public void push(V item) {
        // insert item into front of list
        list.insert(item, 0);
    }

    /**
     * Removes an item from the stack
     * @return the removed item
     */
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
