package ui;

import model.Notebook;
import model.NotebookEntry;
import java.util.Scanner;

public class NotebookApp {
    private Scanner input;
    private Notebook notebook;
    private static final String menu = "Main Menu.\n"
            + "1. Show Entries\n"
            + "2. Add Entry\n"
            + "3. Clear Entries\n"
            + "4. Show Notebook Size\n"
            + "5. Exit";

    // EFFECTS: keeps the NotebookApp running
    public NotebookApp() {
        notebook = new Notebook(10);
        input = new Scanner(System.in);
        runNotebook();
    }

    // MODIFIES: this
    // EFFECTS: base program that runs while NotebookApp is active
    private void runNotebook() {
        boolean stillRunning = true;
        String command = null;

        while (stillRunning) {
            System.out.println(menu);
            command = input.nextLine();

            if (command.equals("5")) {
                stillRunning = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("1")) {
            showEntries();
        } else if (command.equals("2")) {
            addEntry();
        } else if (command.equals("3")) {
            clearAllEntries();
        } else if (command.equals("4")) {
            showSize();
        }
    }

    // EFFECTS: prints out a list of all of the current notebook entries, or empty message if empty
    public void showEntries() {
        if (notebook.getSize() == 0) {
            System.out.println("\nThis notebook is empty\n");
        } else {
            notebook.printAllEntries();
        }
    }

    // MODIFIES: this
    // EFFECTS: adds an entry to notebook after previous entries
    public void addEntry() {
        if (notebook.getSize() >= notebook.getMaxSize()) {
            System.out.println("\nThis notebook is full\n");
        } else {
            System.out.println("\nWrite note: ");
            String newEntryString = input.nextLine();
            NotebookEntry newNote = new NotebookEntry(newEntryString, 3);
            notebook.addEntry(newNote);
            System.out.println("\nAdded");
        }
    }


    // MODIFIES: this
    // EFFECTS: removes all inputs in the notebook
    public void clearAllEntries() {
        System.out.println("\nAre you sure you want to clear all notes? y/n\n");
        String command = input.nextLine();
        if (command.equals("y")) {
            System.out.println("It's never too late to start over");
            notebook.clearEntries();
        } else {
            return;
        }
    }

    public void showSize() {
        System.out.println(notebook.getSize());
    }
}
