package ex6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chronometer extends JFrame implements ActionListener {

    private JButton on_pause_Button;
    private JButton reset_Button;
    public static TextField display;
    private int miliseconds = 0;
    private int seconds = 0;
    private int minutes = 0;

    private boolean on=false;


    Chronometer() {

        initUI();
        initButtons();
initTextField();




    }

    public void initUI() {


        this.setResizable(false);
        this.getContentPane().setBackground(new Color(52, 152, 219));

        this.setTitle("Chrono-meter v1.0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(500, 500);
        this.setVisible(true);


    }
    public void initButtons(){
        on_pause_Button=new JButton("ON/PAUSE");
        reset_Button=new JButton("RESET");

        on_pause_Button.setBounds(150,100,175,25);
        reset_Button.setBounds(150,125,175,25);

        this.add(on_pause_Button);
        this.add(reset_Button);
        on_pause_Button.addActionListener(this);
        reset_Button.addActionListener(this);



    }





  public void run(){

synchronized (this) {

while(true) {
    try {
        Thread.sleep(0, 1);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }


    miliseconds++;

    if (miliseconds == 1001) {
        miliseconds = 0;
        seconds++;
    }

    if (seconds == 61) {

        seconds = 0;
        minutes++;

    }

    Chronometer.display.setText(minutes + ":" + seconds + ":" + miliseconds);


    if (on == true) {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    System.out.println(on);

}
}

   }

    public void initTextField(){

        display=new TextField();
        display.setBounds(185,150,100,25);
        this.add(display);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("am apasat buton");



        if(e.getSource()==reset_Button){
            On.resetChronometer();
            display.setText("00:00:0000");
        }

        if(e.getSource()==on_pause_Button){
            if(on==true) {
                on = false;
                unPause();
            }
            else
                on=true;

        }

    }

    public void unPause(){

        synchronized (this){

notify();

        }


    }



}