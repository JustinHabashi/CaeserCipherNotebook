package persistence;

import model.Notebook;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// class is used in NotebookApp to save a notebook to a JSON file
@SuppressWarnings("checkstyle:RightCurly")
public class JsonWriter {
    private static final int LENGTH = 4;
    private PrintWriter writer;
    private String jsonDestination;

    // EFFECTS: writer class constructor to write notebook to jsonDestination
    public JsonWriter(String jsonDestination) {
        this.jsonDestination = jsonDestination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; handles the FileNotFoundException if destination
    // file is not accessible
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(jsonDestination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of notebook to the jsonDestination
    public void write(Notebook nb) {
        JSONObject json = nb.toJson();
        saveToFile(json.toString(LENGTH));
    }

    // MODIFIES: this
    // EFFECTS: closes the writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECT: writes the string to the file destination
    private void saveToFile(String json) {
        writer.print(json);
    }
}
