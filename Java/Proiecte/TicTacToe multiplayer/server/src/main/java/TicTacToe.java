

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Random;

public class TicTacToe extends JFrame implements ActionListener {
    private static int[][] mat = new int[3][3];

    public static boolean gameActive;
    public static boolean sync;
    public static boolean haveControl;
    public static String symbol=null;
    public static int pozition=0;//pentru a vedea unde se schimba matricile
    public static JTextArea chatWindow;
    public static JTextField chatTextField, nameTextField;
    public static JButton chatButton;
    public static String chatString = "";
    public static boolean isTyping=false;

    public HashMap<Integer, JButton> hmap= new HashMap<>();

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
        haveControl=false;
        gameActive=sync=true;

        this.setLayout(null);
        this.setTitle("X si 0-server");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 520);
        this.setVisible(true);
        this.setResizable(false);


        init();
        initMat();
        initHashMap();


    }

    public void init() {
        JLabel nameLabel = new JLabel("Name: ");

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

        chatWindow = new JTextArea();
        chatTextField = new JTextField();
        chatButton = new JButton("send");
        nameTextField = new JTextField();

        chatButton.addActionListener(this);
        chatButton.setFont(new Font("Arial", Font.PLAIN, 10));

        nameLabel.setBounds(535, 1, 50, 20);
        nameTextField.setBounds(575, 3, 100, 20);
        chatWindow.setBounds(550, 25, 230, 430);
        chatTextField.setBounds(550, 460, 200, 20);
        chatButton.setBounds(750, 460, 35, 20);


        chatWindow.setLineWrap(true);

        this.add(nameLabel);
        this.add(nameTextField);
        this.add(chatTextField);
        this.add(chatButton);
        this.add(chatWindow);

        this.getRootPane().setDefaultButton(chatButton);

        this.repaint();


    }


//    public static void main(String[] args) {
//        new TicTacToe();
//        TicTacToe.printMat();
//
//    }

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

        if (e.getSource() == chatButton) {


            chatString += nameTextField.getText() + ": " + chatTextField.getText() + "\n";

            chatWindow.setText(chatString);

            chatTextField.setText("");

        }


        else if(haveControl){

        haveControl=false;//se ia controlul
        sync=false;

        JButton aux = new JButton();
        pozition = 0;
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

            aux.setText(symbol);
            if(symbol=="X")
            mat[pozition / 10 % 10 - 1][pozition % 10 - 1] = 1;
            else if (symbol=="0")
                mat[pozition / 10 % 10 - 1][pozition % 10 - 1] = 0;




    }else{
            System.out.println("It's not your TURN !!!");

        }

    }

    public void giveControl(){

        haveControl=true;

    }

    public void takeControl(){

        haveControl=false;

    }



    public void verifyForWinner(){

        if (verifyLine() == 1) {
            System.out.println("A castigat X");
            this.dispose();
            gameActive=false;
        } else if (verifyLine() == 0) {
            System.out.println("A castigat 0");
            this.dispose();
            gameActive=false;
        } else if (verifyLine() == -1) {
            System.out.println("Urmatorul player introduce: ");

        }

    }

    public int[] rollTheDice(){
        Random rand = new Random();
        int[] array=new int[2];

array[0]=rand.nextInt(1000);
array[1]=rand.nextInt(1000);
        System.out.println("numere extrase: ");
        System.out.println("server= "+array[0]);
        System.out.println("client= "+array[1]);

return array;

    }

    public void Sincronization(int lastChangedPosition) {
        JButton aux;
        aux = hmap.get(lastChangedPosition);
        aux.setFont(new Font("Arial", Font.PLAIN, 70));
        if (symbol == "X") {
            aux.setText("0");
        } else {
            aux.setText("X");
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





    public static int[][] getMat() {
        return mat;
    }

    public static void setMat(int[][] mat) {
        TicTacToe.mat = mat;
    }

    public void initHashMap(){

        hmap.put(11, button11);
        hmap.put(12, button12);
        hmap.put(13, button13);

        hmap.put(21, button21);
        hmap.put(22, button22);
        hmap.put(23, button23);

        hmap.put(31, button31);
        hmap.put(32, button32);
        hmap.put(33, button33);

    }


}
