import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Two extends JFrame implements ActionListener {
	private JButton button;
	private JFrame frame;
	private int mycount;
	
	public Two(){
		mycount = 1;
	}
	
	public void CreateGUI(){
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(400, 400);
		frame.setLayout(new FlowLayout());
		//frame.setBounds(10, 10, 80, 80);
		button = new JButton("Show");
		frame.add(button);
		frame.setTitle("My Frames");
		button.addActionListener (this);
		
	}
	
	public static void main(String args[]){
		Two t1 = new Two();
		t1.CreateGUI();
	}
	
	public void ActionPerformed(){
		mycount = mycount + 2;
		JOptionPane.showMessageDialog(null, "Final: " + mycount);
	}

}
