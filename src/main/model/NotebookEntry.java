package model;

import model.CipherText;
import org.json.JSONObject;

import java.util.Random;

// This class is the building block of a Notebook, complete with a cipher value for a Caesar cipher to be
// created later, and the string entry which is taken directly from the user.
public class NotebookEntry {

    private final int MIN = 1;
    private final int MAX = 10;
    private Random ciphergen = new Random();
    private int cipher;
    private String entry;
    private String cipherEntry;
    private CipherText getCipherTextInt;
    CipherText cipherTextInt = new CipherText(entry, cipher);


    // EFFECTS: NotebookEntry constructor
    public NotebookEntry(String entry) {
        this.entry = entry;
        this.cipher = ciphergen.nextInt(MAX - MIN) + MIN;
        this.cipherEntry = cipherTextInt.convertCharListToCipher(entry, cipher);
    }

    // EFFECTS: getters for entry and cipher
    public String getEntry() {
        return entry;
    }

    public int getCipher() {
        return cipher;
    }

    public String getCipherEntry() {
        return cipherEntry;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("entry", entry);
        json.put("cipher", cipher);
        return json;
    }
}
