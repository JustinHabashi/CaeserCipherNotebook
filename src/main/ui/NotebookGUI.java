package ui;

import model.Notebook;
import model.NotebookEntry;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


// this class controls the majority of all GUI functionality on the main page
// all components of the Jframe are contained within
// ActionListener is extended and fleshed out in the bottom portion
public class NotebookGUI extends JPanel implements ActionListener {

    JButton addButton;
    JButton removeButton;
    JButton saveButton;
    JButton loadButton;
    JButton showCipherButton;
    JButton showEntriesButton;
    JTextField textField;
    DefaultListModel entryList;
    DefaultListModel cipherList;
    JList list;
    JList clist;
    Notebook guiNotebook = new Notebook(24);

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/notebook.json";


    //Beginning of the GUI

    //Creates and sets up the window frame.
    public void createGUI() {
        // GUI NOTEBOOK

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        addButton = new JButton();
        addButton.setBounds(20, 705, 70, 60);
        addButton.setText("Add");
        addButton.setForeground(Color.green);
        addButton.setBackground(Color.black);
        addButton.addActionListener(this);

        showCipherButton = new JButton();
        showCipherButton.setBounds(20, 705, 70, 60);
        showCipherButton.setText("Show Cipher");
        showCipherButton.setForeground(Color.green);
        showCipherButton.setBackground(Color.black);
        showCipherButton.addActionListener(this);

        removeButton = new JButton();
        removeButton.setBounds(20, 705, 70, 60);
        removeButton.setText("Remove");
        removeButton.setForeground(Color.green);
        removeButton.setBackground(Color.black);
        removeButton.addActionListener(this);

        saveButton = new JButton();
        saveButton.setBounds(20, 705, 70, 60);
        saveButton.setText("Save");
        saveButton.setForeground(Color.green);
        saveButton.setBackground(Color.black);
        saveButton.addActionListener(this);

        loadButton = new JButton();
        loadButton.setBounds(20, 705, 70, 60);
        loadButton.setText("Load");
        loadButton.setForeground(Color.green);
        loadButton.setBackground(Color.black);
        loadButton.addActionListener(this);

        showEntriesButton = new JButton();
        showEntriesButton.setText("Show Entries");
        showEntriesButton.setForeground(Color.green);
        showEntriesButton.setBackground(Color.black);
        showEntriesButton.addActionListener(this);

        textField = new JTextField(20);
        textField.setVisible(true);
        textField.setFont(new Font("Segoe", Font.PLAIN,20));
        textField.setForeground(Color.GREEN);
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.WHITE);
        textField.setPreferredSize(new Dimension(180, 30));
        textField.setHorizontalAlignment(JTextField.LEFT);

        entryList = new DefaultListModel();
        //entryList.setBounds(10, 10, 400, 600);

        cipherList = new DefaultListModel();

        list = new JList(entryList);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(10);
        list.setSelectionBackground(Color.WHITE);
        list.setBackground(Color.gray);
        list.setForeground(Color.WHITE);
        list.setFont(new Font("Arial",Font.PLAIN,20));

        clist = new JList(cipherList);
        clist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        clist.setSelectedIndex(0);
        clist.setVisibleRowCount(10);
        clist.setVisible(false);
        clist.setSelectionBackground(Color.WHITE);
        clist.setBackground(Color.BLACK);
        clist.setForeground(Color.GREEN);
        clist.setFont(new Font("Arial",Font.BOLD,20));


        // BOTTOM BRACKET PANEL
        JPanel bottomBracket = new JPanel();
        bottomBracket.setBackground(Color.white);
        bottomBracket.setBounds(0, 700, 600, 100);
        bottomBracket.add(textField);
        bottomBracket.add(addButton);
        bottomBracket.add(removeButton);
        bottomBracket.add(saveButton);
        bottomBracket.add(loadButton);
        bottomBracket.add(showCipherButton);
        bottomBracket.add(showEntriesButton);

        // MAIN TOP LEFT BRACKET
        JPanel topLeftBracket = new JPanel();
        topLeftBracket.setBackground(Color.gray);
        topLeftBracket.setBounds(0, 0, 300, 700);
        topLeftBracket.add(list);
        // MAIN TOP RIGHT BRACKET
        JPanel topRightBracket = new JPanel();
        topRightBracket.setBackground(Color.black);
        topRightBracket.setBounds(300,0,300,700);
        topRightBracket.add(clist);

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (entryList.getSize() == guiNotebook.getMaxSize()) {
                textField.setText("You have reached max list size");
                Toolkit.getDefaultToolkit().beep();
            } else {
                entryList.addElement(textField.getText().trim());
                guiNotebook.addEntry(new NotebookEntry(textField.getText()));
                if (clist.isVisible()) {
                    cipherList.addElement(guiNotebook.addCipherEntry(guiNotebook.getSize() - 1));
                }
            }

        } else if (e.getSource() == removeButton) {
            if (guiNotebook.getSize() == 0) {
                textField.setText("Make a Notebook Entry first");
            } else {
                int index = list.getSelectedIndex();
                entryList.remove(index);
                guiNotebook.removeEntry(index);
                cipherList.remove(index);
            }

        } else if (e.getSource() == saveButton) {
            try {
                jsonWriter.open();
                jsonWriter.write(guiNotebook);
                jsonWriter.close();
                System.out.println("Your notebook has been saved to" + JSON_STORE);
            } catch (FileNotFoundException n) {
                System.out.println("Error: Unable to save");
            }
        } else if (e.getSource() == loadButton) {
            try {
                guiNotebook = jsonReader.read();
                System.out.println("Loaded previous notebook from " + JSON_STORE);
                entryList.clear();
                for (int i = 0; i < guiNotebook.getSize(); i++) {
                    entryList.addElement(guiNotebook.printAllEntries(i));
                }

            } catch (IOException b) {
                System.out.println("Unable to obtain previous notebook from " + JSON_STORE);
            }
        } else if (e.getSource() == showCipherButton) {
            if (clist.isVisible()) {
                clist.setVisible(false);
            } else {
                cipherList.clear();
                for (int i = 0; i < guiNotebook.getSize(); i++) {
                    cipherList.addElement(guiNotebook.addCipherEntry(i));
                }
                clist.setVisible(true);
            }
        } else if (e.getSource() == showEntriesButton) {
            if (list.isVisible()) {
                list.setVisible(false);
            } else {
                list.setVisible(true);
            }
        }
    }
}
