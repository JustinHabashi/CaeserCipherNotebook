package persistence;

import model.Notebook;
import model.NotebookEntry;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// This reads the notebook the JSON stored in file
public class JsonReader {
    private String data;

    // EFFECTS: reader constructor with data
    public JsonReader(String data) {
        this.data = data;
    }

    // EFFECTS: reads notebook from the file and returns it
    public Notebook read() throws IOException {
        String jsonData = reader(data);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseNoteBook(jsonObject);
    }

    // EFFECTS: reads source file as string and returns
    private String reader(String data) throws IOException {
        StringBuilder content = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(data), StandardCharsets.UTF_8)) {
            stream.forEach(s -> content.append(s));
        }

        return content.toString();
    }

    // EFFECTS: parses notebook from JSON object and returns it
    private Notebook parseNoteBook(JSONObject jsonObject) {
        int maxSize = jsonObject.getInt("maxSize");
        Notebook nb = new Notebook(maxSize);
        addEntries(nb, jsonObject);
        return nb;
    }

    // MODIFIES: nb
    // EFFECTS: parses through all entries from JSON object and adds them to notebook
    private void addEntries(Notebook nb, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("notebookEntries");
        for (Object json : jsonArray) {
            JSONObject nextEntry = (JSONObject) json;
            addEntry(nb, nextEntry);
        }
    }

    // MODIFIES: nb
    // EFFECTS: parses entry from JSON object and adds it to notebook
    private void addEntry(Notebook nb, JSONObject jsonObject) {
        int cipher = jsonObject.getInt("cipher");
        String entry = jsonObject.getString("entry");
        NotebookEntry notebookEntry = new NotebookEntry(entry, cipher);
        nb.addEntry(notebookEntry);
    }
}
