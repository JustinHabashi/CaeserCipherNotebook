package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// This Notebook model contains the functionality for a collection of Notebook Entries. It contains a
// max size for the notebook and necessary functionality.
public class Notebook {

    // DISCLAIMER: This notebook layout used inspiration from the provided Teller app and
    //             a Github project found from lukaszsi titled JAVA-Notebook for the adding
    //             and viewing of entries
    // FURTHER DISCLAIMER: for the saving and loading functionality, JsonSerializationDemo
    //                     was heavily used to establish framework.

    private int maxSize;
    private LinkedList<NotebookEntry> notebookEntries;

    //EFFECTS: Notebook constructor
    public Notebook(int maxSize) {
        this.notebookEntries = new LinkedList<NotebookEntry>();
        this.maxSize = maxSize;
    }

    // EFFECTS: returns a list of notebook entries in this notebook
    public List<NotebookEntry> getNotebookEntries() {
        return Collections.unmodifiableList(notebookEntries);
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

    public void removeEntry(int index) {
        this.notebookEntries.remove(index);
    }

    public String addCipherEntry(int index) {
        return notebookEntries.get(index).getCipherEntry();
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
