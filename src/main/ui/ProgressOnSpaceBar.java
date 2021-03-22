package ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static ui.NotebookGUI.createGUI;

public class ProgressOnSpaceBar extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();
        if (ch == ' ') {
            createGUI();
        }
        if (event.getKeyCode() == KeyEvent.VK_HOME) {
            createGUI();
        }
    }
}
