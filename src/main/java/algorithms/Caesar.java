package algorithms;

public class Caesar {

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
