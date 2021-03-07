package persistence;

import model.NotebookEntry;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkNotebookEntry(int cipher, String entry, NotebookEntry nbEntry) {
        assertEquals(cipher, nbEntry.getCipher());
        assertEquals(entry, nbEntry.getEntry());
    }
}
