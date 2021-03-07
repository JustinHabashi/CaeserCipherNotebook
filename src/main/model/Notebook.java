package model;

import org.json.JSONArray;
import org.json.JSONObject;

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

    // EFFECTS: gets the size of the notebook
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

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("maxSize", maxSize);
        json.put("notebookEntries", entriesToJson());
        return json;
    }

    // EFFECTS: returns notebookEntries in this notebook as JSON array
    private JSONArray entriesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (NotebookEntry ne : notebookEntries) {
            jsonArray.put(ne.toJson());
        }
        return jsonArray;
    }
}
