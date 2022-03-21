package ex4;

import javax.swing.*;
import java.awt.*;

public class Arena extends JFrame {

    Arena(){

        initArena();


    }

    public void initArena(){





        this.setResizable(false);
        this.getContentPane().setBackground(new Color(139,69,19));

        this.setTitle("Battle Robot Arena v1.0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(500, 500);
        this.setVisible(true);



    }





}
