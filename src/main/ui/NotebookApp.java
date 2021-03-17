package ui;

import model.Notebook;
import model.NotebookEntry;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class NotebookApp {
    private static final String JSON_STORE = "./data/notebook.json";
    private Scanner input;
    private Notebook notebook;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String menu = "Main Menu.\n"
            + "1. Show Entries\n"
            + "2. Add Entry\n"
            + "3. Clear Entries\n"
            + "4. Show Notebook Size\n"
            + "5. Exit\n"
            + "6. Save Notebook\n"
            + "7. Load Notebook\n";

    // EFFECTS: keeps the NotebookApp running
    public NotebookApp() {
        notebook = new Notebook(10);
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
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
        } else if (command.equals("6")) {
            saveNotebook();
        } else if (command.equals("7")) {
            loadNotebook();
        }
    }

    // MODIFIES: this
    // EFFECTS: prints out a list of all of the current notebook entries, or empty message if empty
    public void showEntries() {
        if (notebook.getSize() == 0) {
            System.out.println("\nThis notebook is empty\n");
        } else {
            for (int j = 0; j < notebook.getSize(); j++) {
                System.out.println(notebook.printAllEntries(j) + "\n");
            }
            System.out.println("You have " + (notebook.getMaxSize() - notebook.getSize()) + " entries left\n");
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
            NotebookEntry newNote = new NotebookEntry(newEntryString);
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

    // MODIFIES: this
    // EFFECTS: outputs the size of the notebook
    public void showSize() {
        System.out.println(notebook.getSize());
    }

    // EFFECTS: saves the current notebook to a JSON file
    public void saveNotebook() {
        try {
            jsonWriter.open();
            jsonWriter.write(notebook);
            jsonWriter.close();
            System.out.println("Your notebook has been saved to" + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to save");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads the current notebook from a JSON file
    public void loadNotebook() {
        try {
            notebook = jsonReader.read();
            System.out.println("Loaded previous notebook from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to obtain previous notebook from " + JSON_STORE);
        }
    }
}
