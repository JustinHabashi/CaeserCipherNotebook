package model;

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


}
