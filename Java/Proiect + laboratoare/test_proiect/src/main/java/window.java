import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window extends JFrame implements ActionListener{

    private JButton button1;
    public TextArea textArea1,textArea2;
    private String sir;
    public int itteration=1;
    public Boolean asteapta=true;


    window(){

        init();


    }


    public void init(){


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
        this.setLayout(null);

        //button1=new JButton("click");//create button
       // button1.setBounds(130,50,100, 40);


       //button1.addActionListener(this);

        textArea1=new TextArea();
        textArea1.setBounds(50,0,250,100);

        textArea2=new TextArea();
        textArea2.setBounds(50,120,250,100);


        //this.add(button1);
        this.add(textArea1);
        this.add(textArea2);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button1){

            sir=textArea1.getText();
            System.out.println(sir);

        }


    }


    public void itterate(){

        itteration++;


    }





}
