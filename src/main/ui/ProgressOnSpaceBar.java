package ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// This class manages the function to extend to the main page after the user
// is done with the landing page
public class ProgressOnSpaceBar extends KeyAdapter {

    // EFFECTS: opens the main page when landing page detects " "
    @Override
    public void keyPressed(KeyEvent event) {
        LandingPageGUI landing = new LandingPageGUI();

        char ch = event.getKeyChar();
        if (ch == ' ') {
            landing.goMain();
        }
    }
}
