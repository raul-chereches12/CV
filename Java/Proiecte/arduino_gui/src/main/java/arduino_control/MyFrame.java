package arduino_control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    private boolean on = false;
    private int change;

    MyFrame() {

        button = new JButton("LED ON/OFF");
        button.setBounds(200, 100, 100, 50);
        button.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
change=1;
        if (e.getSource() == button) {
            //cazul in care on==true
            on = !on;

        }


    }

    public boolean isOn() {
        return on;
    }


    public int getChange(){
        return this.change;
    }
    public void resetChange(){
        this.change=0;

    }

}
