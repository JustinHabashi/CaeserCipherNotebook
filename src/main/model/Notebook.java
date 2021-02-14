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

    // EFFECTS:
    public void printAllEntries() {
        for (int j = 0; j < getSize(); j++) {
            System.out.println(notebookEntries.get(j).getEntry() + "\n");
        }
    }

    public int getSize() {
        return notebookEntries.size();
    }

    public void addEntry(NotebookEntry newEntryString) {
        this.notebookEntries.add(newEntryString);
    }

    public void removeEntry(int index) {
        this.notebookEntries.remove(index);
    }

}
