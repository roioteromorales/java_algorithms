package trees;

public class Trie {
    private Node root = new Node();
    private int words = 0;

    Trie() {

    }

    public void add(String word) {
        // fix case
        word = word.toLowerCase();

        // start iterator at root
        Node iterator = root;

        // iterate through word
        for (int i = 0; i < word.length(); i++) {

            // get current letter
            char letter = word.charAt(i);

            // fix letter
            if (letter == 39) {
                // convert to apostrophe 26
                letter = 26;
            }
            else {
                // convert from ascii to 0-25
                letter -= 97;
            }

            // create new branch if it does not exist
            if (iterator.children[letter] == null) {
                iterator.children[letter] = new Node();
            }

            // move down the trie
            iterator = iterator.children[letter];
        }

        iterator.isWord = true;
        words++;
    }

    public boolean check(String word) {
        // fix case
        word = word.toLowerCase();

        // start iterator at root
        Node iterator = root;

        // iterate through word
        for (int i = 0; i < word.length(); i++) {

            // get current letter
            char letter = word.charAt(i);

            // fix letter
            if (letter == 39) {
                // convert to apostrophe 26
                letter = 26;
            }
            else {
                // convert from ascii to 0-25
                letter -= 97;
            }

            // if child doesn't exist, neither does word
            if (iterator.children[letter] == null) {
                return false;
            }

            // move down the trie
            iterator = iterator.children[letter];
        }

        // check if we found word
        if (iterator.isWord) {
            return true;
        }

        return false;
    }

    public int getWords() {
        return words;
    }

    private class Node {
        Node[] children = new Node[27]; // children representing chars A-Z, 26 represents apostrophe
        boolean isWord;
    }
}
