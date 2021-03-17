package persistence;

import model.Notebook;
import model.NotebookEntry;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Notebook nb = new Notebook(10);
            JsonWriter invalidWrite = new JsonWriter("./data/\0illegalpath.json");
            invalidWrite.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // nothing
        }
    }

    @Test
    void testWriterEmptyNb() {
        try {
            Notebook nb = new Notebook(10);
            JsonWriter write = new JsonWriter("./data/testEmptyNb.json");
            write.open();
            write.write(nb);
            write.close();

            JsonReader read = new JsonReader("./data/testEmptyNb.json");
            nb = read.read();
            assertEquals(10, nb.getMaxSize());
            assertEquals(0, nb.getSize());
        } catch (IOException e) {
            fail("Exception was thrown");
        }
    }

    @Test
    void testRandomNb() {
        try {
            Notebook nb = new Notebook(10);
            nb.addEntry(new NotebookEntry("this could be anything"));
            nb.addEntry(new NotebookEntry("it doesn't matter what this one is"));
            JsonWriter write = new JsonWriter("./data/testRandomNb.json");
            write.open();
            write.write(nb);
            write.close();

            JsonReader reader = new JsonReader("./data/testRandomNb.json");
            nb = reader.read();
            assertEquals(10, nb.getMaxSize());
            List<NotebookEntry> notesInside = nb.getNotebookEntries();
            assertEquals(2, notesInside.size());
            checkNotebookEntry(0, "this could be anything", notesInside.get(0));
            checkNotebookEntry(0, "it doesn't matter what this one is", notesInside.get(1));
        } catch (IOException e) {
            fail("Exception detected");
        }
    }
}
