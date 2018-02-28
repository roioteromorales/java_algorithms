package lists;

public class LinkedListTester {

    public static void main(String[] args) {

        //SingleLinkedList list = new SingleLinkedList("Hello", "my", "name", "is");
        DoubleLinkedList list = new DoubleLinkedList("Hello", "my", "name", "is");

        System.out.println("Original List: " + list.toString());    // Output: Original List: Hello my name is
        System.out.println("Original Size: " + list.size());        // Output: Original Size: 4

        list.add("Graham.");                                        // Output: Hello my name is Graham.
        System.out.println(list.toString());

        list.insert("Kevin", 4);                        // Output: Hello my name is Kevin Graham.
        System.out.println(list.toString());

        list.remove(2);                                       // Output: Hello my is Kevin Graham.
        System.out.println(list.toString());

        list.remove(1);                                       // Output: Hello is Kevin Graham.
        System.out.println(list.toString());

        list.set(1, "I'm");                                         // Output: Hello I'm Kevin Graham.
        System.out.println(list.toString());

        System.out.println("Get Index 3: " + list.get(3));          // Output: Get Index 3: Graham.




        //SingleLinkedList numList = new SingleLinkedList(5, 15, 20, 25);
        DoubleLinkedList numList = new DoubleLinkedList(5, 15, 20, 25);

        System.out.println("\nNumList: " + numList.toString());    // Output: Numlist: 5 15 20 25
        System.out.println("Size: " + numList.size());             // Output: Size: 4

        numList.add(30);                                           // Output: 5 15 20 25 30
        System.out.println(numList.toString());

        numList.insert(10, 1);                         // Output: 5 10 15 20 25 30
        System.out.println(numList.toString());

        numList.remove(2);                                   // Output: 5 10 20 25 30
        System.out.println(numList.toString());


    }
}
