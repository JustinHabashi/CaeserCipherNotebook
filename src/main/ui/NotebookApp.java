package ui;

import model.Notebook;
import model.NotebookEntry;
import java.util.Scanner;

public class NotebookApp {
    private NotebookEntry entry;
    private Scanner input;
    private static String menu;

    // EFFECTS: keeps the NotebookApp running
    public NotebookApp() {
        runNotebook();
    }

    // MODIFIES: this
    // EFFECTS: base program that runs while NotebookApp is active
    private void runNotebook() {
        boolean stillRunning = true;
        String command = null;

        while (stillRunning = true) {
            this.menu =
                    "Main Menu.\n"
                            + "1. Show Entries\n"
                            + "2. Add Entry\n"
                            + "3. Remove Entry"
                            + "4. Clear all Entries\n"
                            + "5. Exit";
            System.out.println(menu);
            command = input.next();

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
        if (Notebook.size() == 0) {
            System.out.println("\nThis notebook is empty\n");
        } else {
            Notebook.getAllEntries();
        }
    }

    public void addEntry() {
        // stub
    }

    public void removeEntry() {
        // stub
    }

    public void clearEntries() {
        // stub
    }
}
