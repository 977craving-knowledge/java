import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorSwing extends JFrame {

	JButton b[];
	JPanel pan;
	JFrame mainFrame;
	JTextField txt;
	String prev, curr, operation;
	String keys[] = { "On", "Del", "AC", "+", "7", "8", "9", "-", "4", "5",
			"6", "/", "1", "2", "3", "*", ".", "0", "=", "%" };
	boolean on;
	boolean dot;
	
	int x, y, w, h, xGap, yGap,fWidth;
	

	public CalculatorSwing() {
		prev = curr = operation = "";
		dot = true;
		pan = new JPanel();
		b = new JButton[keys.length];
		txt = new JTextField("");
		on = false;
		setFrame();
		x = 10;
		y = 50;
		w = h = 50;
		xGap = yGap = h + 5;
		fWidth=210;
		setSize(fWidth+w, 370);
		setTitle("My Calculator");
	}

	public static void main(String[] args) {
		CalculatorSwing calc = new CalculatorSwing();
		calc.showTextField();
		calc.showButtons();
	}

	private void setFrame() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(pan);
		setResizable(true);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private void callOn() {
		on = true;
		txt.setText("0.");
		prev = "";
		curr = "";

		b[0].setText("Off");
	}

	private void callOff() {
		on = false;
		txt.setText("");
		prev = "";
		curr = "";
		b[0].setText("On");
	}

	private void callOperation(String opt) {
		dot = true;
		if (opt.equalsIgnoreCase("=")) {
			double result = 0;
			try {
				if (operation.equalsIgnoreCase("+")) {
					result = (Double.parseDouble(prev) + Double
							.parseDouble(curr));
				} else if (operation.equalsIgnoreCase("-")) {
					result = (Double.parseDouble(prev) - Double
							.parseDouble(curr));
				} else if (operation.equalsIgnoreCase("/")) {
					result = (Double.parseDouble(prev) / Double
							.parseDouble(curr));
				} else if (operation.equalsIgnoreCase("*")) {
					result = (Double.parseDouble(prev) * Double
							.parseDouble(curr));
				} else if (operation.equalsIgnoreCase("%")) {
					result = (Double.parseDouble(prev) % Double
							.parseDouble(curr));
				}
			} catch (Exception e) {
				prev = "";
				curr = "";
				txt.setText("Barbaad Julaka");
			}
			prev = "" + result;
			txt.setText(prev);
			curr = "";
		} else {
			prev = txt.getText();
			txt.setText("0.");
			curr = "";
			operation = opt;
		}
	}

	private void callDigits(String btn_txt) {
		if (on) {
			curr = curr + btn_txt;
			txt.setText(curr);
			curr = txt.getText();
		}
	}

	private void calculate(String opt) {
		System.out.println("" + opt);
		if (opt.equalsIgnoreCase(".")) {
			if (dot) {
				callDigits(opt);
				dot = false;
			}
		} else if (opt.equalsIgnoreCase("Del")) {
			if (curr.length() > 0) {
				curr = curr.substring(0, curr.length() - 1);
			}
			txt.setText(curr);
			curr = txt.getText();
		} else if (opt.equalsIgnoreCase("AC")) {
			if (on) {
				prev = "";
				curr = "";
				txt.setText("0.");
				operation = "";
			}
		} else if (opt.equalsIgnoreCase("On")) {
			callOn();
		} else if (opt.equalsIgnoreCase("Off")) {
			callOff();
		} else if (opt.equalsIgnoreCase("+") || opt.equalsIgnoreCase("-")
				|| opt.equalsIgnoreCase("/") || opt.equalsIgnoreCase("*")
				|| opt.equalsIgnoreCase("%") || opt.equalsIgnoreCase("=")) {
			callOperation(opt);
		} else {
			callDigits(opt);
		}
	}

	private void buttonAction(final JButton b) {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String btn_txt = b.getText();
				calculate(btn_txt);
			}
		});
	}

	private void showButtons() {
		System.out.println("show Buttons");
		
		pan.setLayout(null);
		for (int i = 0; i < keys.length; i++) {
			b[i] = new JButton(keys[i]);
			buttonAction(b[i]);
			pan.add(b[i]);
			b[i].setBounds(x, y, w, h);
			x += xGap;
			if (x > fWidth) {
				x = 10;
				y += yGap;
			}
		}
	}

	private void showTextField() {
		//txt.setSize(100, 25);
		pan.setLayout(null);
		pan.add(txt);
		txt.setBounds(10, 10, 210, 30);
	}
}