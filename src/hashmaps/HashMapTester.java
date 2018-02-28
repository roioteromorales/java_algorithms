package hashmaps;

public class HashMapTester {

    public static void main(String[] args) {
        HashMap hashmap = new HashMap();

        hashmap.add("Apple", 2.5);
        hashmap.add("Avocado", 10.23464);
        hashmap.add("Pear", 5);
        hashmap.add("Mango", "Who Knows");

        hashmap.remove("Pear");

        System.out.println("Apple: " + hashmap.find("Apple"));
        System.out.println("Pear: " + hashmap.find("Pear"));
        System.out.println("Pineapple: " + hashmap.find("Pineapple"));
        System.out.println("Mango: " + hashmap.find("Mango"));
        System.out.println("Avocado: " + hashmap.find("Avocado"));
    }
}
