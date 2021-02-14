package model;

import java.util.LinkedList;

public class Notebook {

    // DISCLAIMER: This notebook layout used inspiration from the provided Teller app and
    //             a Github project found from lukaszsi titled JAVA-Notebook for the adding
    //             and viewing of entries

    private int maxSize;
    private LinkedList<NotebookEntry> notebookEntries;

    //EFFECTS: Notebook constructor
    public Notebook(int maxSize) {
        this.notebookEntries = new LinkedList<NotebookEntry>();
        this.maxSize = maxSize;
    }


    // MODIFIES: this
    // EFFECTS: This method is called by NotebookApp to print out all entries
    public String printAllEntries(int index) {
        return notebookEntries.get(index).getEntry();
    }

        // EFFECTS: Getters for maxSize, size of notebook
    public int getMaxSize() {
        return maxSize;
    }

    public int getSize() {
        return notebookEntries.size();
    }

    // MODIFIES: this
    // EFFECTS: adds an entry to the back of the list
    public void addEntry(NotebookEntry newEntryString) {
        if (notebookEntries.size() < maxSize) {
            this.notebookEntries.add(newEntryString);
        } else {
            return;
        }
    }

    // MODIFIES: this
    // EFFECTS: clears out the content of notebookEntries without stopping the program
    public void clearEntries() {
        this.notebookEntries.clear();
    }
}
