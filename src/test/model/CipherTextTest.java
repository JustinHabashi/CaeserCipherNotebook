package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CipherTextTest {
    private ArrayList<Character> testArrayList;
    private String testString;
    private NotebookEntry testNotebookEntry;

    @BeforeAll
    void testList() {
        testArrayList = new ArrayList<>(
                Arrays.asList('T', 'E', 'S', 'T'));
        testString = "I shouldn't work";
    }

    @Test
    void testConvertStringToCharList() {
        //assertEquals(testArrayList.);
    }
}