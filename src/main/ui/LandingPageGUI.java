package ui;

import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LandingPageGUI extends JPanel {

    public static void createLandingPage() {
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

        JFrame frame = new JFrame("LandingPage");
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(null);
        frame.setResizable(false);
        ImageIcon tiktok = new ImageIcon("src/main/ui/image/tiktok logo.png");
        frame.setIconImage(tiktok.getImage());
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black); // BACKGROUND COLOUR
        frame.add(progress);
        frame.add(mainLabel);

    }


}
