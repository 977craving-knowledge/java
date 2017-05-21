// This program uses 2 graphics files.
// These are referred to in the body of the program.
// They must be in the same folder as the class file.
// Suitable files are present in this folder

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SuffleDice extends JFrame implements ActionListener {

	private JButton suffleBtn;
	private JPanel panel,panel1;

	private ImageIcon one, two, three, four, five, six;

	public static void main(String[] args) {
		SuffleDice demo = new SuffleDice();
		demo.setSize(250, 250);
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
		
		panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(100, 100));
		panel1.setBackground(Color.white);
		window.add(panel1);


		suffleBtn = new JButton("Suffle");
		window.add(suffleBtn);
		suffleBtn.addActionListener(this);

		String path = "E://Selection/src/";
		one = new ImageIcon(path + "one.jpg");
		two = new ImageIcon(path + "two.jpg");
		three = new ImageIcon(path + "three.jpg");
		four = new ImageIcon(path + "four.jpg");
		five = new ImageIcon(path + "five.jpg");
		six = new ImageIcon(path + "six.jpg");
	}

	public void actionPerformed(ActionEvent event) {
		Graphics paper = panel.getGraphics();
		Graphics paper1 = panel1.getGraphics();
		
		Random r = new Random();
		Thread th = new Thread();
		for (int i = 0; i < 10; i++) {
			try {
				th.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int rnd = r.nextInt(5) + 1;
			if (rnd == 1) {
				one.paintIcon(this, paper, 0, 0);
			} else if (rnd == 2) {
				two.paintIcon(this, paper, 0, 0);
			} else if (rnd == 3) {
				three.paintIcon(this, paper, 0, 0);
			} else if (rnd == 4) {
				four.paintIcon(this, paper, 0, 0);
			} else if (rnd == 5) {
				five.paintIcon(this, paper, 0, 0);
			} else {
				six.paintIcon(this, paper, 0, 0);
			}
			
			rnd = r.nextInt(5) + 1;
			if (rnd == 1) {
				one.paintIcon(this, paper1, 0, 0);
			} else if (rnd == 2) {
				two.paintIcon(this, paper1, 0, 0);
			} else if (rnd == 3) {
				three.paintIcon(this, paper1, 0, 0);
			} else if (rnd == 4) {
				four.paintIcon(this, paper1, 0, 0);
			} else if (rnd == 5) {
				five.paintIcon(this, paper1, 0, 0);
			} else {
				six.paintIcon(this, paper1, 0, 0);
			}
		}
	}

}
