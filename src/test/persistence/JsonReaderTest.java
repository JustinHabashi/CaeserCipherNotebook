package persistence;

import model.Notebook;
import model.NotebookEntry;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderMissingFile() {
        JsonReader missingReader = new JsonReader(".dara/hacks.json");
        try {
            Notebook nb = missingReader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // nothing
        }
    }

    @Test
    void testReaderEmptyNb() {
        JsonReader nbEmpty = new JsonReader("./data/testEmptyNb.json");
        try {
            Notebook nb = nbEmpty.read();
            assertEquals(10, nb.getMaxSize());
            assertEquals(0, nb.getSize());
        } catch (IOException e) {
            fail("Couldn't read from empty nb");
        }
    }

    @Test
    void testReaderRandomNb() {
        JsonReader nbRandom = new JsonReader("./data/testRandomNb.json");
        try {
            Notebook nb = nbRandom.read();
            assertEquals(10, nb.getMaxSize());
            List<NotebookEntry> entries = nb.getNotebookEntries();
            assertEquals(2, nb.getSize());
            checkNotebookEntry(0, "this could be anything", entries.get(0));
            checkNotebookEntry(0, "it doesn't matter what this one is", entries.get(1));
        } catch (IOException e) {
            fail("Could not read multiple entries from the Json");
        }
    }
}
