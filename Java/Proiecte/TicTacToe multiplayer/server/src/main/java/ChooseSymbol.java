import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ChooseSymbol extends JFrame implements ActionListener {

    private JButton buttonX;
    private JButton button0;



    ChooseSymbol(){

        init();


    }


    public void init(){


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
        this.setLayout(null);

        buttonX=new JButton("X");//create button
         buttonX.setBounds(130,50,100, 40);

        button0=new JButton("0");//create button
        button0.setBounds(250,50,100, 40);


        buttonX.addActionListener(this);
        button0.addActionListener(this);




        this.add(buttonX);
        this.add(button0);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==buttonX){

            //
            TicTacToe.symbol="X";


        }

        if(e.getSource()==button0){
            TicTacToe.symbol="0";
          //

        }

this.dispose();
    }




}
