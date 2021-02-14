package model;

public class NotebookEntry {

    private int entryId;
    private String entry;
    private int cipher;


    // EFFECTS: NotebookEntry constructor
    public NotebookEntry(String entry, int cipher) {
        this.entry = entry;
        entryId++;
        this.cipher = cipher;
    }

    // EFFECTS: getters
    public String getEntry() {
        return entry;
    }

    public int getEntryId() {
        return entryId;
    }

    public int getCipher() {
        return cipher;
    }

}
