package cryptography;

import java.io.*;

public class CryptoTest {

    public static void main(String[] args) {

        // test caesar cipher
        String unencryptedPath = "src/cryptography/.unencrypted.txt";
        String encryptedPath = "src/cryptography/.encrypted.txt";
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

    public static void writeFile(String text, String path) {

        // open writer
        try (BufferedWriter fout = new BufferedWriter(new FileWriter(path))) {
            // write text to file
            fout.write(text);
        } catch (IOException ex) {
            System.out.println("I/O Exception" + ex);
        }
    }
}
