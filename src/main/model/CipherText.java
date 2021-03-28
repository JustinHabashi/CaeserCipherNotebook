package model;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.toLowerCase;

// CipherText class that converts an entry and cipher value into a ciphered code
// most functionality is extended through the notebook class which allows the printing
public class CipherText {
    String nbEntry;
    Integer cipherValue;
    ArrayList<Character> alphabet = new ArrayList<>(
            Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                    'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));

    // CONSTRUCTOR
    public CipherText(String nbEntry, int cipherValue) {
        this.nbEntry = nbEntry;
        this.cipherValue = cipherValue;
    }

    // MODIFIES: this
    // EFFECTS: Converts the nbEntry string to a list of characters
    public ArrayList<Character> convertStringToCharList(String nbEntry) {
        ArrayList<Character> chars = new ArrayList<>();

        for (char ch : nbEntry.toCharArray()) {
            chars.add(ch);
        }
        return chars;
    }

    // MODIFIES: this
    // EFFECTS: converts the list of characters to a string
    private String convertArrayListToString(ArrayList<Character> list) {
        StringBuilder cipherString = new StringBuilder(list.size());
        for (Character cha : list) {
            cipherString.append(cha);
        }
        return cipherString.toString();
    }

    // MODIFIES: this
    // EFFECTS: This is the main cipher program. It takes the cipher value and applies it to the list of chars
    // by cycling through the alphabet component
    public String convertCharListToCipher(String nbEntry, int cipherValue) {
        // List of characters converted from nbEntry
        ArrayList<Character> chars = convertStringToCharList(nbEntry);
        // List of ciphered characters to be converted from the nbEntry list
        ArrayList<Character> cipherChar = new ArrayList<>();

        for (int t = 0; chars.size() > 0; t++) {
            if (chars.get(0) == alphabet.get(t) || chars.get(0) == toLowerCase(alphabet.get(t))) {
                if (isLowerCase(chars.get(0))) {
                    cipherChar.add(toLowerCase(alphabet.get((t + cipherValue) % 26)));
                    chars.remove(0);
                    t = -1;
                } else {
                    cipherChar.add(alphabet.get((t + cipherValue) % 26));
                    chars.remove(0);
                    t = -1;
                }
            } else if (t == 25) {
                cipherChar.add(chars.get(0));
                chars.remove(0);
                t = -1;
            }
        }
        return convertArrayListToString(cipherChar);
    }
}
