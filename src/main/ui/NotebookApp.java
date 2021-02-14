package ui;

import model.Notebook;
import model.NotebookEntry;
import java.util.Scanner;

public class NotebookApp {
    private NotebookEntry entry;
    private int entrySignPost;
    private Scanner input;
    private Notebook notebook;
    private static final String menu = "Main Menu.\n"
            + "1. Show Entries\n"
            + "2. Add Entry\n"
            + "3. Remove Entry\n"
            + "4. Clear all Entries\n"
            + "5. Exit";

    // EFFECTS: keeps the NotebookApp running
    public NotebookApp() {
        notebook = new Notebook(10);
        input = new Scanner(System.in);
        entrySignPost = 1;
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
            removeEntry();
        } else if (command.equals("4")) {
            clearEntries();
        }
    }

    public void showEntries() {
        if (notebook.getSize() == 0) {
            System.out.println("\nThis notebook is empty\n");
        } else {
            notebook.printAllEntries();
        }
    }

    public void addEntry() {
        System.out.println("\nWrite note: ");
        String newEntryString = entrySignPost++ + ". " + input.nextLine();
        NotebookEntry newNote = new NotebookEntry(newEntryString, 3);
        notebook.addEntry(newNote);
        System.out.println("\nAdded");
    }

    // REQUIRES: an integer as an input
    // MODIFIES: this
    // EFFECTS: removes the specified notebookentry based on the id
    public void removeEntry() {
        System.out.println("\nWhich note would you like to remove: ");
        int response = input.nextInt();
        input.nextLine();
        if (response < 1 || response > notebook.getSize()) {
            System.out.println("\nNo entry with that number\n");
        } else {
            notebook.removeEntry(response);
        }
    }

    public void clearEntries() {
        // stub
    }
}
