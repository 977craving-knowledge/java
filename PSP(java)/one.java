import javax.swing.*;
public class one extends JFrame {
	public static void main(String[] args){
		one frame = new one();
		frame.setSize(200, 200);
		frame.gui();
		}
	public void gui(){
		JOptionPane.showMessageDialog(null, "This is the first attempt.");
	}

}
