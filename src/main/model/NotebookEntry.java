package model;

public class NotebookEntry {
    private String entry;
    private int cipher;
    private boolean isEncrypt;

    // EFFECTS: Blank NotebookEntry initialized
    public NotebookEntry(String entry, int cipher) {
        this.entry = entry;
        this.cipher = cipher;
        isEncrypt = false;
    }

    // EFFECTS: getters
    public String getEntry() {
        return entry;
    }

    public int getCipher() {
        return cipher;
    }

    public boolean getIsEncrypt() {
        return isEncrypt;
    }
}
