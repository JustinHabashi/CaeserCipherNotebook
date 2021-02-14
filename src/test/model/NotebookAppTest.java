package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotebookAppTest {
    private Notebook testNotebook;
    private NotebookEntry testNotebookEntry;

    @BeforeEach
    void runBefore() {
        testNotebook = new Notebook(10);
        testNotebookEntry = new NotebookEntry("test", 0);
    }

    @Test
    void testConstructor() {
        assertEquals(10, testNotebook.getMaxSize());
        assertEquals(0, testNotebook.getSize());
        assertEquals("test", testNotebookEntry.getEntry());
        assertEquals(0,testNotebookEntry.getCipher());
    }

    @Test
    void testAddEntry() {
        testNotebook.addEntry(new NotebookEntry("It works!", 3));
        assertEquals(1, testNotebook.getSize());
        testNotebook.addEntry(new NotebookEntry("It works again!", 3));
        assertEquals(2, testNotebook.getSize());
    }

    @Test
    void testMaxSize() {
        for (int i = 1; i <= testNotebook.getMaxSize(); i++) {
            testNotebook.addEntry(new NotebookEntry("It works!", 3));
        }
        assertEquals(10, testNotebook.getSize());
        testNotebook.addEntry(new NotebookEntry("It works!", 3));
        assertEquals(10, testNotebook.getSize());
    }

    @Test
    void testClearEntries() {
        for (int i = 1; i <= testNotebook.getMaxSize(); i++) {
            testNotebook.addEntry(new NotebookEntry("It works!", 3));
        }
        assertEquals(10, testNotebook.getSize());
        testNotebook.clearEntries();
        assertEquals(0, testNotebook.getSize());
    }

    @Test
    void testPrintAllEntries() {
        testNotebook.addEntry(new NotebookEntry("It works!", 3));
        assertEquals(testNotebook.printAllEntries(0),"It works!");
        testNotebook.addEntry(new NotebookEntry("Please work", 3));
        assertEquals(testNotebook.printAllEntries(1),"Please work");
    }
}