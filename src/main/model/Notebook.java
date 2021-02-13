package model;

import java.util.LinkedList;

public class Notebook {

    private LinkedList<NotebookEntry> Notebook;
    private Notebook() {
        Notebook = new LinkedList<NotebookEntry>();
    }
    public int size = Notebook.size();                  // the current size of the notebook

    public String getAllEntries() {
        for (int j = 1; j <= size; j++) {
            System.out.println(Notebook.get(j));
        }


    }

}
