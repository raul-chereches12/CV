package ex4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    private static int[][] mat = new int[3][3];

    JButton button11 = new JButton();
    JButton button12 = new JButton();
    JButton button13 = new JButton();
    JButton button21 = new JButton();
    JButton button22 = new JButton();
    JButton button23 = new JButton();
    JButton button31 = new JButton();
    JButton button32 = new JButton();
    JButton button33 = new JButton();


    private boolean state = false;


    TicTacToe() {


        this.setLayout(null);
        this.setTitle("X si 0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(515, 520);
        this.setVisible(true);

        init();
        initMat();


    }

    public void init() {


        button11.setBounds(0, 0, 166, 166);

        button12.setBounds(166, 0, 166, 166);

        button13.setBounds(333, 0, 166, 166);

        button21.setBounds(0, 166, 166, 166);

        button22.setBounds(166, 166, 166, 166);

        button23.setBounds(333, 166, 166, 166);

        button31.setBounds(0, 333, 166, 166);

        button32.setBounds(166, 333, 166, 166);

        button33.setBounds(333, 333, 166, 166);


        this.add(button11);
        this.add(button12);
        this.add(button13);
        this.add(button21);
        this.add(button22);
        this.add(button23);
        this.add(button31);
        this.add(button32);
        this.add(button33);


        button11.addActionListener(this);
        button12.addActionListener(this);
        button13.addActionListener(this);
        button21.addActionListener(this);
        button22.addActionListener(this);
        button23.addActionListener(this);
        button31.addActionListener(this);
        button32.addActionListener(this);
        button33.addActionListener(this);


    }


    public static void main(String[] args) {
        new TicTacToe();
        TicTacToe.printMat();

    }

    void initMat() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                mat[i][j] = -1;
            }
    }

    static public void printMat() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("\n");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton aux = new JButton();
        int pozition = 0;
        if (e.getSource() == button11) {
            aux = button11;
            pozition = 11;
        } else if (e.getSource() == button12) {
            aux = button12;
            pozition = 12;
        } else if (e.getSource() == button13) {
            aux = button13;
            pozition = 13;

        } else if (e.getSource() == button21) {
            aux = button21;
            pozition = 21;

        } else if (e.getSource() == button22) {
            aux = button22;
            pozition = 22;

        } else if (e.getSource() == button23) {
            aux = button23;
            pozition = 23;

        } else if (e.getSource() == button31) {
            aux = button31;
            pozition = 31;

        } else if (e.getSource() == button32) {
            aux = button32;
            pozition = 32;

        } else if (e.getSource() == button33) {
            aux = button33;
            pozition = 33;

        }
        aux.setFont(new Font("Arial", Font.PLAIN, 70));
        if (state == false) {
            aux.setText("0");
            state = true;
            mat[pozition / 10 % 10 - 1][pozition % 10 - 1] = 0;
        } else {
            aux.setText("X");
            state = false;
            mat[pozition / 10 % 10 - 1][pozition % 10 - 1] = 1;
        }


        System.out.println("\n");
        printMat();
        if(verifyLine()==1){
            System.out.println("A castigat X");
            this.dispose();
        }
        else if(verifyLine()==0){
            System.out.println("A castigat 0");
            this.dispose();
        }
            else if(verifyLine()==-1){
            System.out.println("Urmatorul player introduce: ");

        }

    }


    public int verifyLine() {


        //horizontal
        int ok = 1;
        int sign = mat[0][0];
        for (int j = 0; j < 3; j++) {

            if (mat[0][j] != sign)
                ok = 0;
        }
        if (ok == 1) {
            return sign;
        }

        sign = mat[0][2];
        ok = 1;
        for (int j = 0; j < 3; j++) {

            if (mat[j][2] != sign)
                ok = 0;
        }
        if (ok == 1) {
            return sign;
        }

        sign = mat[2][2];
        ok = 1;
        for (int j = 0; j < 3; j++) {

            if (mat[2][2 - j] != sign)
                ok = 0;
        }
        if (ok == 1) {
            return sign;
        }

        sign = mat[2][0];
        ok = 1;
        for (int j = 0; j < 3; j++) {

            if (mat[2 - j][0] != sign)
                ok = 0;
        }
        if (ok == 1) {
            return sign;
        }
//verticals
        sign = mat[1][0];
        ok = 1;
        for (int j = 0; j < 3; j++) {

            if (mat[1][j] != sign)
                ok = 0;
        }
        if (ok == 1) {
            return sign;
        }

        sign = mat[0][1];
        ok = 1;
        for (int j = 0; j < 3; j++) {

            if (mat[j][1] != sign)
                ok = 0;
        }
        if (ok == 1) {
            return sign;
        }
//diagonals
        sign = mat[0][0];
        ok = 1;
        for (int j = 0; j < 3; j++) {

            if (mat[j][j] != sign)
                ok = 0;
        }
        if (ok == 1) {
            return sign;
        }

        sign = mat[0][2];
        ok = 1;
        for (int j = 0; j < 3; j++) {

            if (mat[j][2 - j] != sign)
                ok = 0;
        }
        if (ok == 1) {
            return sign;
        }



    return -1;

    }



}
