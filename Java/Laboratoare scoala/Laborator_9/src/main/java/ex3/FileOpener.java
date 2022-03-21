package ex3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class FileOpener extends JFrame implements ActionListener {

    private JTextField textField = new JTextField();
    private JButton button = new JButton("Open File");
    private TextArea textArea = new TextArea();

    FileOpener() {
        JFrame ecran = new JFrame();


        ecran.setLayout(null);
        ecran.setTitle("Titlul ferestrei");
        ecran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ecran.setSize(400, 500);
        ecran.setVisible(true);

        button.addActionListener(this);
        button.setBounds(50, 200, 300, 50);
        textField.setBounds(50,25,100,50);
        textArea.setBounds(0,250,400,200);


        ecran.add(textField);
        ecran.add(button);
        ecran.add(textArea);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String textFieldValue = textField.getText();

        System.out.println(textFieldValue);

        if (textFieldValue == null) {
            textArea.setText("Nu am gasit nume!");
        } else {
            try {
                File myfile = new File("src/main/java/ex3/"+textFieldValue);
                Scanner myReader = new Scanner(myfile);
                if (myfile.exists()) {

                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        textArea.setText(data+"\n");
                    }
                    myReader.close();


                } else {
                    System.out.println("The file does not exist.");
                }

            } catch (Exception excep) {
                System.out.println(excep);
            }
        }


    }


    public static void main(String[] args) {
        FileOpener instanta = new FileOpener();


    }


}
