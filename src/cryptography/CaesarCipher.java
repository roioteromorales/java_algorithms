package cryptography;

public class CaesarCipher {

    public static void main(String[] args) {
        // test cipher
        String plaintext = "hello, world";
        int key = 13;


        System.out.println("Original: " + plaintext);

        System.out.println("\n...encrypting");
        String ciphertext = crypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);

        System.out.println("\n...decrypting");
        System.out.println("Plaintext: " + crypt(ciphertext, -key));

    }

    /* CAESAR CIPHER CRYPT
     * encrypts/decrypts the given text by the given key (negative for decryption)
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
