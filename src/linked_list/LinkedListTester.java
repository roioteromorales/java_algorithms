package linked_list;

public class LinkedListTester {

    public static void main(String[] args) {

        //SingleLinkedList list = new SingleLinkedList("Hello", "my", "name", "is");
        DoubleLinkedList list = new DoubleLinkedList("Hello", "my", "name", "is");

        System.out.println("Original List: " + list.toString());
        System.out.println("Original Size: " + list.size());

        list.add("Graham."); // Hello my name is Graham.
        System.out.println(list.toString());

        list.insert("Kevin", 4); // Hello my name is Kevin Graham.
        System.out.println(list.toString());

        list.remove(2); // Hello my is Kevin Graham
        System.out.println(list.toString());

        list.remove(1); // Hello is Kevin Graham
        System.out.println(list.toString());

        list.set(1, "I'm"); // Hello I'm Kevin Graham
        System.out.println(list.toString());

        System.out.println("Get Index 3: " + list.get(3)); // Graham.

    }
}
