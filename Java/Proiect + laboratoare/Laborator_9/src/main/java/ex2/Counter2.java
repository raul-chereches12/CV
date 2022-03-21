package ex2;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter2 extends JFrame implements ActionListener{
    private JTextField textField1= new JTextField();
    private JButton button= new JButton("COUNT");
    private static int counter=0;


    public Counter2() {

        JFrame frame= new JFrame();


        frame.setLayout(null);
        frame.setTitle("Button Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,500);
        frame.setVisible(true);

        button.setBounds(150,150,100,50);
        textField1.setBounds(150,10,125,50);
        textField1.setText("0");

        button.addActionListener(this);


        frame.add(textField1);
        frame.add(button);


frame.repaint();


    }


        @Override
        public void actionPerformed(ActionEvent e) {


            counter++;
            textField1.setText(counter + "");


        }




    public static void main(String[] args) {

        Counter2 count =new Counter2();


    }






}


