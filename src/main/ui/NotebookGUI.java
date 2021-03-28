package ui;

import model.Notebook;
import model.NotebookEntry;
import persistence.JsonReader;
import persistence.JsonWriter;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


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
    JPanel bottomBracket = new JPanel();
    JPanel topLeftBracket = new JPanel();
    JPanel topRightBracket = new JPanel();

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/notebook.json";


    // MODIFIES: this
    // EFFECTS: sets the common attributes for all buttons
    public JButton setButtonAttributes(JButton jbut) {
        jbut.setBounds(20, 705, 70, 60);
        jbut.setForeground(Color.green);
        jbut.setBackground(Color.black);
        jbut.addActionListener(this);
        return jbut;
    }

    // MODIFIES: this
    // EFFECTS: Creates all the buttons
    private void makeButtons() {
        addButton = new JButton();
        addButton.setText("Add");
        setButtonAttributes(addButton);

        showCipherButton = new JButton();
        showCipherButton.setText("Show Cipher");
        setButtonAttributes(showCipherButton);

        removeButton = new JButton();
        removeButton.setText("Remove");
        setButtonAttributes(removeButton);

        saveButton = new JButton();
        saveButton.setText("Save");
        setButtonAttributes(saveButton);

        loadButton = new JButton();
        loadButton.setText("Load");
        setButtonAttributes(loadButton);

        showEntriesButton = new JButton();
        showEntriesButton.setText("Show Entries");
        setButtonAttributes(showEntriesButton);
    }

    // MODIFIES: this
    // EFFECTS: Creates the two lists lists
    private void makeLists() {
        entryList = new DefaultListModel();

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

    }

    // MODIFIES: this
    // EFFECTS: creates the user text field
    private void makeTextField() {
        textField = new JTextField(20);
        textField.setVisible(true);
        textField.setFont(new Font("Segoe", Font.PLAIN,20));
        textField.setForeground(Color.GREEN);
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.WHITE);
        textField.setPreferredSize(new Dimension(180, 30));
        textField.setHorizontalAlignment(JTextField.LEFT);
    }

    // MODIFIES: this
    // EFFECTS: makes the three brackets
    private void makeBrackets() {
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
        topLeftBracket.setBackground(Color.gray);
        topLeftBracket.setBounds(0, 0, 300, 700);
        topLeftBracket.add(list);
        // MAIN TOP RIGHT BRACKET
        topRightBracket.setBackground(Color.black);
        topRightBracket.setBounds(300,0,300,700);
        topRightBracket.add(clist);
    }

    public static void playMusic(String file) {
        InputStream music;
        try {
            music = new FileInputStream(new File(file));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    // MODIFIES: this
    // EFFECTS: Creates the GUI frame and adds all the former elements
    public void createGUI() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        playMusic("src/main/ui/sound/01. Twin Peaks Theme (Instrumental).wav");
        makeButtons();
        makeLists();
        makeTextField();
        makeBrackets();
        // BOTTOM BRACKET PANEL

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

    // MODIFIES: entryList and possibly clist if it is visible to the user
    // EFFECTS: sets the functionality for adding an element to both lists
    private void addItButton() {
        if (entryList.getSize() == guiNotebook.getMaxSize()) {
            textField.setText("You have reached max list size");
            Toolkit.getDefaultToolkit().beep();
        } else {
            entryList.addElement(textField.getText());
            guiNotebook.addEntry(new NotebookEntry(textField.getText()));
            if (clist.isVisible()) {
                cipherList.addElement(guiNotebook.addCipherEntry(guiNotebook.getSize() - 1));
            }
        }
    }

    // MODIFIES: entryList and cipherlist
    // EFFECTS: removes a selection from entrylist and cipherlist based on user selection
    private void removeItButton() {
        if (guiNotebook.getSize() == 0) {
            textField.setText("Make a Notebook Entry first");
        } else {
            int index = list.getSelectedIndex();
            entryList.remove(index);
            guiNotebook.removeEntry(index);
            cipherList.remove(index);
        }
    }

    // MODIFIES: json file
    // EFFECTS: saves the program
    private void saveItButton() {
        try {
            jsonWriter.open();
            jsonWriter.write(guiNotebook);
            jsonWriter.close();
            System.out.println("Your notebook has been saved to" + JSON_STORE);
        } catch (FileNotFoundException n) {
            System.out.println("Error: Unable to save");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads the program
    private void loadItButton() {
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
    }

    // EFFECTS: shows the cipher list
    private void showItCipherButton() {
        if (clist.isVisible()) {
            clist.setVisible(false);
        } else {
            cipherList.clear();
            for (int i = 0; i < guiNotebook.getSize(); i++) {
                cipherList.addElement(guiNotebook.addCipherEntry(i));
            }
            clist.setVisible(true);
        }
    }

    // EFFECTS: shows the cipher list
    private void showItEntriesButton() {
        if (list.isVisible()) {
            list.setVisible(false);
        } else {
            list.setVisible(true);
        }
    }

    // EFFECTS: overrides the action performed and scans for user click input
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addItButton();
        } else if (e.getSource() == removeButton) {
            removeItButton();
        } else if (e.getSource() == saveButton) {
            saveItButton();
        } else if (e.getSource() == loadButton) {
            loadItButton();
        } else if (e.getSource() == showCipherButton) {
            showItCipherButton();
        } else if (e.getSource() == showEntriesButton) {
            showItEntriesButton();
        }
    }
}
