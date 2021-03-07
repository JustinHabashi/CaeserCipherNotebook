package model;

import org.json.JSONObject;

// This class is the building block of a Notebook, complete with a cipher value for a Caesar cipher to be
// created later, and the string entry which is taken directly from the user.
public class NotebookEntry {

    private int cipher;
    private String entry;


    // EFFECTS: NotebookEntry constructor
    public NotebookEntry(String entry, int cipher) {
        this.entry = entry;
        this.cipher = 0;
    }

    // EFFECTS: getters for entry and cipher
    public String getEntry() {
        return entry;
    }

    public int getCipher() {
        return cipher;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("entry", entry);
        json.put("cipher", cipher);
        return json;
    }
}
