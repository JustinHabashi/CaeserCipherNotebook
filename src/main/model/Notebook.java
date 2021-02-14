package model;

import java.util.LinkedList;

public class Notebook {

    private int maxSize;
    private LinkedList<NotebookEntry> notebookEntries;

    public Notebook(int maxSize) {
        this.notebookEntries = new LinkedList<NotebookEntry>();
        this.maxSize = maxSize;
    }
                      // the current size of the notebook

    // MODIFIES: this
    // EFFECTS: This method is called by NotebookApp to print out all entries without linking
    //          NotebookApp to NotebookEntry limiting dependencies
    public void printAllEntries() {
        for (int j = 0; j < getSize(); j++) {
            System.out.println(notebookEntries.get(j).getEntry() + "\n");
        }
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
