/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.HeadlessException;
import javafx.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Ws119
 */
public class TimerDemo extends JFrame {

    private JLabel lbl1;
    private JLabel lbl2;
    private JButton btn1;
    private JButton btn2;
    private Timer t1;
    private Timer t2;
    int i = 0, j = 0;

    public TimerDemo() {
        prepareGUI();
    }

    public void prepareGUI() {

        lbl1 = new JLabel("0");
        lbl1.setBounds(10, 10, 100, 40);
        add(lbl1);

        lbl2 = new JLabel("0");
        lbl2.setBounds(120, 10, 100, 40);
        add(lbl2);

        btn1 = new JButton("Start");
        btn1.setBounds(10, 60, 80, 30);
        add(btn1);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (btn1.getText().equalsIgnoreCase("start")) {
                    startTimer1();
                    btn1.setText("Stop");
                }
                else{
                    t1.stop();
                    btn1.setText("Start");
                }
            }
        });

        btn2 = new JButton("Start");
        btn2.setBounds(120, 60, 80, 30);
        add(btn2);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (btn2.getText().equalsIgnoreCase("start")) {
                    startTimer2();
                    btn2.setText("Stop");
                }
                else{
                    t2.stop();
                    btn2.setText("Start");
                }
                
            }
        });

        setLayout(null);
        setSize(400, 300);
        setVisible(true);
    }

    public void startTimer1() {

        ActionListener listener = new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                lbl1.setText("" + i);
                i++;
            }
        };
        t1 = new Timer(100, listener);
        t1.start();
    }

    public void startTimer2() {

        ActionListener listener = new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                lbl2.setText("" + j);
                j++;
            }
        };
        t2 = new Timer(100, listener);
        t2.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TimerDemo td = new TimerDemo();

    }

}