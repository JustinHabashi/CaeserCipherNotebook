package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotebookAppTest {
    private Notebook testNotebook;
    private NotebookEntry testNotebookEntry;
    private CipherText testCipherText;

    @BeforeEach
    void runBefore() {
        testNotebook = new Notebook(10);
        testNotebookEntry = new NotebookEntry("Test");
        testCipherText = new CipherText("This is my TEXTYEAH!#%^", 3);
    }

    @Test
    void testConstructor() {
        assertEquals(10, testNotebook.getMaxSize());
        assertEquals(0, testNotebook.getSize());
        assertEquals("Test", testNotebookEntry.getEntry());
    }

    @Test
    void testAddEntry() {
        testNotebook.addEntry(new NotebookEntry("It works!"));
        assertEquals(1, testNotebook.getSize());
        testNotebook.addEntry(new NotebookEntry("It works again!"));
        assertEquals(2, testNotebook.getSize());
    }

    @Test
    void testMaxSize() {
        for (int i = 1; i <= testNotebook.getMaxSize(); i++) {
            testNotebook.addEntry(new NotebookEntry("It works!"));
        }
        assertEquals(10, testNotebook.getSize());
        testNotebook.addEntry(new NotebookEntry("It works!"));
        assertEquals(10, testNotebook.getSize());
    }

    @Test
    void testClearEntries() {
        for (int i = 1; i <= testNotebook.getMaxSize(); i++) {
            testNotebook.addEntry(new NotebookEntry("It works!"));
        }
        assertEquals(10, testNotebook.getSize());
        testNotebook.clearEntries();
        assertEquals(0, testNotebook.getSize());
    }

    @Test
    void testPrintAllEntries() {
        testNotebook.addEntry(new NotebookEntry("It works!"));
        assertEquals(testNotebook.printAllEntries(0),"It works!");
        testNotebook.addEntry(new NotebookEntry("Please work"));
        assertEquals(testNotebook.printAllEntries(1),"Please work");
    }

    @Test
    void testRemoveEntry() {
        testNotebook.addEntry(new NotebookEntry("It works!"));
        assertEquals(testNotebook.printAllEntries(0),"It works!");
        testNotebook.removeEntry(0);
        assertEquals(testNotebook.getSize(), 0);
        testNotebook.addEntry(new NotebookEntry("It works!"));
        testNotebook.addEntry(new NotebookEntry("Delete This One!"));
        testNotebook.addEntry(new NotebookEntry("this one too"));
        testNotebook.removeEntry(1);
        assertEquals(testNotebook.printAllEntries(0),"It works!");
        assertEquals(testNotebook.printAllEntries(1),"this one too");
    }

    @Test
    void testAddCipherEntry() {
        testNotebook.addEntry(new NotebookEntry("!"));
        assertEquals(testNotebook.addCipherEntry(0), testNotebook.getNotebookEntries().get(0).getCipherEntry());
        testNotebook.addEntry(new NotebookEntry("$Pecial"));
        assertEquals(testNotebook.addCipherEntry(1), testNotebook.getNotebookEntries().get(1).getCipherEntry());
        testNotebook.addEntry(new NotebookEntry("NO THIS CAN'T BE RIGHT!@#%@#$@"));
        assertEquals(testNotebook.addCipherEntry(2), testNotebook.getNotebookEntries().get(2).getCipherEntry());
        testNotebook.addEntry(testNotebookEntry);
    }

    @Test
    void testConvertStringToCharList() {
        assertEquals(testCipherText.convertCharListToCipher(testCipherText.nbEntry, testCipherText.cipherValue),
                "Wklv lv pb WHAWBHDK!#%^");
    }
}