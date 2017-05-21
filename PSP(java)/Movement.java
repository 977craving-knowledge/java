import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Movement extends JFrame implements ActionListener {
	private JButton btn, btnX, btnY, btnXminus, btnYminus;
	int x, y;

	public Movement() {
		x = y = 100;
	}

	public void createGUI() {
		setSize(400, 400);
		setVisible(true);
		setLayout(null);
		btn = new JButton("Click");
		btn.setBounds(100, 100, 100, 40);
		add(btn);

		btnX = new JButton("X");
		btnX.setBounds(10, 10, 50, 50);
		add(btnX);

		btnY = new JButton("Y");
		btnY.setBounds(70, 10, 50, 50);
		add(btnY);

		btnXminus = new JButton("X-");
		btnXminus.setBounds(10, 70, 50, 50);
		add(btnXminus);

		btnYminus = new JButton("Y-");
		btnYminus.setBounds(70, 70, 50, 50);
		add(btnYminus);

		btnX.addActionListener(this);
		btnY.addActionListener(this);
		btnXminus.addActionListener(this);
		btnYminus.addActionListener(this);

	}

	public static void main(String[] args) {
		Movement m = new Movement();
		m.createGUI();
	}

	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		if (cmd.equalsIgnoreCase("x")) {
			x += 10;
		} else if (cmd.equalsIgnoreCase("y")) {
			y += 10;
		} else if (cmd.equalsIgnoreCase("y-")) {
			if (y > 130){
				y -= 10;
			}
		} else if (cmd.equalsIgnoreCase("x-")) {
			x -= 10;
		}
		btn.setBounds(x, y, 100, 40);
	}

}
