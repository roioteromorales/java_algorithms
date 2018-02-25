package cryptography;

public class Caesar {
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
