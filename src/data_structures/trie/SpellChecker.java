package data_structures.trie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SpellChecker {
    static Trie dict;

    public static void main(String[] args) {

        String dictPath = "src/data_structures/trie/dictionary.txt";
        String novelPath = "src/data_structures/trie/austinpowers.txt";

        // load dictionary into try
        dict = new Trie();

        // read dictionary.txt
        try (BufferedReader fin = new BufferedReader(new FileReader(dictPath))) {
            // read line and add to trie
            String word;

             do {
                word = fin.readLine();
                if (word != null) {
                    dict.add(word);
                }
            } while (word != null);

        } catch (IOException ex) {
            System.out.println(ex);
        }


        System.out.println("Dictionary: " + dict.getWords()); // Correct: 143091

        spellCheck(new File(novelPath));
    }

    public static void spellCheck(File file) {
        // check file for mispelled words
        int misspelled = 0;
        int words = 0;

        // read file
        try (Scanner scanner = new Scanner(file,"ISO-8859-1")) {
            // set word pattern
            scanner.useDelimiter("[^\\w']+"); // new word starts with anything but alphanumeric or apostrophe

            // read word and check against dictionary
            while (scanner.hasNext()) {
                String word = scanner.next();

                // clean word
                word = word.replaceAll("(\\d+[a-zA-Z]+)",""); // remove number + char
                word = word.replaceAll("[.,:;()?!#\"\t\n\r\\d]+", ""); // remove random chars
                word = word.replaceAll("^'([a-zA-Z])","$1"); // remove leading apostrophe
                if (word.matches("'")) { word = ""; }

                // skip empty words
                if (word.isEmpty()) { continue; }

                words++;

                // check word against dictionary
                if (!dict.check(word)) {
                    misspelled++;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        // print results
        System.out.println("Words: " + words);          // Correct: 19190
        System.out.println("Misspelled: " + misspelled); // Correct: 644
    }
}
