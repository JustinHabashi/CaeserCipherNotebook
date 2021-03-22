package ui;

import model.Notebook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotebookGUI extends JPanel implements ActionListener {
    private static int maxsize = 10;
    JButton addButton;

    //Beginning of the GUI

    //Creates and sets up the window frame.
    public static void createGUI() {
        // GUI NOTEBOOK
        Notebook guiNotebook = new Notebook(maxsize);

        // BOTTOM BRACKET PANEL
        JPanel bottomBracket = new JPanel();
        bottomBracket.setBackground(Color.white);
        bottomBracket.setBounds(0, 700, 600, 100);
        // MAIN TOP LEFT BRACKET
        JPanel topLeftBracket = new JPanel();
        topLeftBracket.setBackground(Color.gray);
        topLeftBracket.setBounds(0, 0, 300, 700);
        // MAIN TOP RIGHT BRACKET
        JPanel topRightBracket = new JPanel();
        topRightBracket.setBackground(Color.black);
        topRightBracket.setBounds(300,0,300,700);

        JButton addButton = new JButton();
        addButton.setBounds(505, 705, 80, 60);
        addButton.setText("Add");
        addButton.setBorder(BorderFactory.createEtchedBorder());
        addButton.setForeground(Color.green);
        addButton.setBackground(Color.black);
        addButton.addActionListener(f -> System.out.println("Pentagon = HACKED"));

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(475, 40));

        // add addButton.setEnabled(false) when it reaches max notebook size

        JFrame frame = new JFrame("NotebookApp");
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        ImageIcon tiktok = new ImageIcon("src/main/ui/image/tiktok logo.png");
        frame.setIconImage(tiktok.getImage());
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black); // BACKGROUND COLOUR
        frame.add(bottomBracket);
        frame.add(topLeftBracket);
        frame.add(topRightBracket);
        frame.add(addButton);
        frame.add(textField);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            //Add functionality for adding notebook entry
        }
    }
}
