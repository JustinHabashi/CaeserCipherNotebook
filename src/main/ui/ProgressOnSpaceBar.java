package ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProgressOnSpaceBar extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent event) {
        LandingPageGUI landing = new LandingPageGUI();

        char ch = event.getKeyChar();
        if (ch == ' ') {
            landing.goMain();
        }
        if (event.getKeyCode() == KeyEvent.VK_HOME) {
            landing.goMain();
        }
    }
}
