import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Subiect2_tot {
//Acesta este pe mail!

    public class Main {


        public static void main(String[] args) {
            new Window();
        }
    }


    public class Window extends JFrame implements ActionListener {

        private JButton button1;
        private JTextArea textArea1,textArea2;
        private String sir;





        Window(){

            init();
            repaint();

        }


        public void init(){


            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(400,400);
            this.setVisible(true);
            this.setLayout(null);

            button1=new JButton("click");//create button
            button1.setBounds(130,250,100, 40);


            button1.addActionListener(this);

            textArea1=new JTextArea();
            textArea1.setBounds(50,20,250,100);

            textArea2=new JTextArea();
            textArea2.setBounds(50,140,250,100);


            this.add(button1);
            this.add(textArea1);
            this.add(textArea2);

        }


        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==button1){
                sir=textArea1.getText();

                textArea2.setText(sir);

            }


        }





    }


}







