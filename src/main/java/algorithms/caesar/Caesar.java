package algorithms.caesar;

import java.io.*;

public class Caesar {
    public static void main(String[] args) {

        // test caesar cipher
        String unencryptedPath = "src/algorithms/caesar/.unencrypted.txt";
        String encryptedPath = "src/algorithms/caesar/.encrypted.txt";
        int key = 13;

        // read plaintext
        String plaintext = readFile(unencryptedPath);
        System.out.println("Plaintext Read: " + plaintext);

        // encrypt with caesar cipher
        System.out.println("\n...encrypting");
        String ciphertext = Caesar.crypt(plaintext, key);

        // write encrypted text
        writeFile(ciphertext, encryptedPath);
        System.out.println("Ciphertext Saved: " + ciphertext);

        // decrypt the previously encrypted text
        System.out.println("\n...decrypting");
        System.out.println("Unencrypted Text: " + Caesar.crypt(readFile(encryptedPath), -key));

    }

    /**
     * Reads a file in String format
     * @param path the file can be reached
     * @return a String with the contents of the given file
     */
    public static String readFile(String path) {
        String data = "";
        String line;

        // open reader
        try (BufferedReader fin = new BufferedReader(new FileReader(path))) {
            // iterate through file line by line
            do {
                line = fin.readLine();
                // add current line to data
                if (line != null) { data += line; }
            } while (line != null);
        } catch (IOException ex) {
            System.out.println("I/O Exception " + ex);
        } catch (Exception ex2) {
            System.out.println("Exception " + ex2);
        }

        return data;
    }

    /**
     * Writes a String to a file
     * @param text to be written
     * @param path to write to
     */
    public static void writeFile(String text, String path) {

        // open writer
        try (BufferedWriter fout = new BufferedWriter(new FileWriter(path))) {
            // write text to file
            fout.write(text);
        } catch (IOException ex) {
            System.out.println("I/O Exception" + ex);
        }
    }

    /**
     * Encrypts/Decryptes a String using Caesar's Cipher with the given key
     * @param text to be encrypted/decrypted
     * @param key to shift the chars (negative for decryption)
     * @return a String with its chars shifted by key
     */
    public static String crypt(String text, int key) {
        String output = "";

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isUpperCase(c)) {
                c = (char)((c + key - 65 + 26) % 26 + 65);

            } else if (Character.isLowerCase(c)) {
                c = (char)((c + key - 97 + 26) % 26 + 97);
            }

            output += c;
        }

        return output;
    }

}
