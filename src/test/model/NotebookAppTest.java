package model;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class NotebookAppTest {
    private Notebook testNotebook;

    @BeforeEach
    void runBefore() {
        testNotebook = new Notebook(10);
    }
}