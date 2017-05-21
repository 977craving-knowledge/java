import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Ws119
 */
public class BouncingButton extends JFrame {

    JButton btn;
    JLabel lbl;

    public BouncingButton() {
        btn = new JButton("O");
        lbl = new JLabel("TEST");
        setLayout(null);
        add(btn);
        btn.setBounds(10, 10, 50, 50);
        lbl.setBounds(100, 100, 300, 100);
        add(lbl);
        setVisible(true);
        setSize(400, 400);
    }

    @Override
    public void move(int x1, int y1) {
        //int x = (getHeight() / 2) - 10;
        int x = x1;
        int score = 0;
        int y = (getWidth() / 2) - 10;
        y = y1;
        int w = 20;
        int h = 20;
        int shift = 1;
        boolean left = true;
        boolean top = true;
        for (;;) {
            btn.setBounds(x, y, w, h);

            if (left) {
                x -= shift;
            } else {
                x += shift;
            }
            if (top) {
                y -= shift;
            } else {
                y += shift;
            }

            if (x <= 20) {
                left = false;
            }
            if (x >= getWidth() - 50) {
                left = true;
            }
            if (y <= 20) {
                top = false;
            }
            if (y >= getHeight() - 80) {
                top = true;
                lbl.setText("" + (score += 10));
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException i) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BouncingButton a = new BouncingButton();
        a.move(100, 300);
    }

}