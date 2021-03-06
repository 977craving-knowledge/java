// This program uses 2 graphics files.
// These are referred to in the body of the program.
// They must be in the same folder as the class file.
// Suitable files are present in this folder

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HappySad extends JFrame implements ActionListener {

    private JButton happyButton, sadButton;
    private JPanel panel;

    private ImageIcon happyImage, sadImage;

    public static void main(String[] args) {
        HappySad demo = new HappySad();
        demo.setSize(175,175);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setBackground(Color.white);
        window.add(panel);

        happyButton = new JButton("happy");
        window.add(happyButton);
        happyButton.addActionListener(this);

        sadButton= new JButton("sad");
        window.add(sadButton);
        sadButton.addActionListener(this);
String path = "C//Users/Bosco/workspace/PSP(Week 2)/src/";
        happyImage = new ImageIcon(path + "happy.jpg");
        sadImage = new ImageIcon(path + "sad.jpg");
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        Object source = event.getSource();
        if (source == happyButton) {
            happyImage.paintIcon(this, paper, 0, 0);
        }
        else {
            sadImage.paintIcon(this, paper, 0, 0);
        }
    }
}
