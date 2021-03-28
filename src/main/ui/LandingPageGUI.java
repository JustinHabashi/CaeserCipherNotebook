package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;

// Landing page that the user first arrives at. Has a generic code photo
public class LandingPageGUI extends JPanel {
    NotebookGUI main = new NotebookGUI();
    JFrame frame = new JFrame("Landing Page");

    // MODIFIES: this
    // EFFECTS: creates a landing page to greet the user
    public void createLandingPage() {

        JTextField progress = new JTextField();
        progress.addKeyListener(new ProgressOnSpaceBar());

        ImageIcon code = new ImageIcon("src/main/ui/image/NewCodeMan2.png");
        JLabel mainLabel = new JLabel();
        mainLabel.setText("<html>Welcome to Justin's Caesar Cipher Notebook<br>   Press [SpaceBar] to continue</html>");
        mainLabel.setIcon(code);
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setHorizontalTextPosition(JLabel.CENTER);
        mainLabel.setVerticalTextPosition(JLabel.BOTTOM);
        mainLabel.setForeground(new Color(20,148,20));
        mainLabel.setFont(new Font("Segoe", Font.PLAIN,20));

        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //frame.setLayout(null);
        frame.setResizable(false);
        ImageIcon tiktok = new ImageIcon("src/main/ui/image/tiktok logo.png");
        frame.setIconImage(tiktok.getImage());
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black); // BACKGROUND COLOUR
        frame.add(progress);
        frame.add(mainLabel);

    }

    // EFFECTS: creates a landing page, meant to close this frame but an error is occuring
    public void goMain() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        main.createGUI();
        frame.dispose();
    }

}
