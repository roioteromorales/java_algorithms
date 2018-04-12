package data_structures.lists;

public class ArrayList<T> {

    private final int INITIAL_SIZE = 10;
    private T[] array;
    private int size;

    /**
     * Creates an ArrayList
     */
    public ArrayList() {
        array = (T[])new Object[INITIAL_SIZE]; // initializes internal array of size 10
        size = 0; // no items yet
    }

    /**
     * Adds the given item to the ArrayList
     * @param item to add
     */
    public void add(T item) {

        // add item to array
        array[size] = item;

        // increment last
        size++;

        // check for resize
        resize();
    }

    /**
     * Gets the item at the given index
     * @param index of item
     * @return item at index
     */
    public T get(int index) {
        // ensure given index is valid
        if (index > array.length) {
            return null;
        }

        return array[index];
    }

    /**
     * Removes the item at the given index
     * @param index of item
     */
    public void remove(int index) {
        // ensure given index is valid
        if (index > array.length) {
            return;
        }

        // shift items back in array
        for (int i = index + 1; i <= size; i++) {
            array[i - 1] = array[i];
        }

        // set last element to null
        array[size] = null;

        // decrement last item index
        size--;

        // check for resize
        resize();
    }

    /**
     * Gets the size of the ArrayList
     * @return int size
     */
    public int size() {
        return size;
    }

    /**
     * Resizes the internal array to stay within 25% - 75% capacity
     */
    private void resize() {

        // set new length to current length
        int newLength = array.length;

        // check for growing
        if (size > .75 * array.length) {
            // new length will be twice the size
            newLength = array.length * 2;
        }
        // check for shrinking
        else if (size < .25 * array.length) {
            // newLength will be half the size with a minimum of 10
            newLength = Math.max(INITIAL_SIZE, (int)(array.length * .5));
        }

        // check for resize
        if (newLength != array.length) {
            T[] oldArray = array;
            array = (T[]) new Object[newLength];

            // copy old values
            for (int i = 0; i < size; i++) {
                array[i] = oldArray[i];
            }
        }

    }

}
