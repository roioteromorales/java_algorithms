package linked_list;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

public class LinkedListTester {

    public static void main(String[] args) {

        SingleLinkedList list = new SingleLinkedList("Hello", "my", "name", "is", "Kevin");

        list.add("Graham.");

        System.out.println("\nList: " + list.toString());
        System.out.println("Size: " + list.size());

        System.out.println("\nItem at index 2: " + list.get(2)); // test good index
        System.out.println("Item at index 4: " + list.get(6)); // test bad index

        list.remove(2);
        System.out.println("\nDelete index 2: " + list.toString());

        list.set(1, "TEST");
        System.out.println("\nChange index 1: " + list.toString());

        // Test Empty List
        System.out.println("\nSize of empty list: " + new SingleLinkedList().size());
        System.out.println("Print empty list: " + new SingleLinkedList().toString());
        System.out.println("Get index of empty list: " + new SingleLinkedList().get(4));
        new SingleLinkedList().set(4, "Test");
        new SingleLinkedList().remove(4);

    }
}
