package ex2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View extends JFrame implements ActionListener {

    private static ArrayList<Product_Model> products = new ArrayList<Product_Model>();

JButton addNewProduct_Button,viewAvailbleProducts_Button,deleteProduct_Button,changeProductQuantity_Button;


JTextField console;//WHERE WE INTRODUCE NAMES TO ADD OR TO DELERE,OR TO CHANGE QUANTITY
JTextArea display;//WEHRE WE DISPLAY THE RESULT


    public void initWindow(){


        this.setSize(400,500);//400 width and 500 height
        this.setLayout(null);//using no layout managers
        this.setVisible(true);//making the frame visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addNewProduct_Button=new JButton("add new product");
        viewAvailbleProducts_Button=new JButton("view available products");
        deleteProduct_Button=new JButton("detele product");
        changeProductQuantity_Button=new JButton("change product quantity");

        addNewProduct_Button.addActionListener(this);
        viewAvailbleProducts_Button.addActionListener(this);
        deleteProduct_Button.addActionListener(this);
        changeProductQuantity_Button.addActionListener(this);

        this.add(addNewProduct_Button);
        this.add(viewAvailbleProducts_Button);
        this.add( deleteProduct_Button);
        this.add(changeProductQuantity_Button);

        addNewProduct_Button.setBounds(100,50,200,50);
        viewAvailbleProducts_Button.setBounds(100,100,200,50);
        deleteProduct_Button.setBounds(100,150,200,50);
        changeProductQuantity_Button.setBounds(100,200,200,50);


        console=new JTextField();
        console.setBounds(100,15,200,25);
        this.add(console);

        display=new JTextArea();
        display.setBounds(50,260,300,180);
        this.add(display);

        this.repaint();
    }
    View(){

        initWindow();
    }


    public void addNewProduct(Product_Model obj){

        products.add(obj);

    }

    public String viewAvailableProducts(){
        String string;
        System.out.println("Available products:");
        string="Available products:\n";
        for(Product_Model obj:products){
string+="NAME= "+obj.getName()+" QUANTITY= "+obj.getQuantity()+" PRICE= "+obj.getPrice()+"\n";

            System.out.println("NAME= "+obj.getName()+" QUANTITY= "+obj.getQuantity()+" PRICE= "+obj.getPrice());

        }

return string;
    }


    public void deleteProduct(String name){
        int index=-1;
        int i=0;
        System.out.println(name);
        for(Product_Model obj:products){


            if(obj.getName().equals(name)) {
                index = i;
                //System.out.println("am gasit");
            }

            i++;
        }

        if(index!=-1)
        products.remove(index);

    }

    public void changeProductQuantity(String name,int newQuantity){

        for(Product_Model obj:products){

            if(obj.getName().equals(name)){
                obj.setQuantity(newQuantity);
            }

        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==addNewProduct_Button){
            addNewProduct(new Product_Model(wordParser(0),Integer.parseInt(wordParser(1)),Integer.parseInt(wordParser(2))));

        }

        if(e.getSource()==viewAvailbleProducts_Button){

            display.setText(viewAvailableProducts());

        }


        if(e.getSource()==deleteProduct_Button){

            deleteProduct(wordParser(0));

        }


        if(e.getSource()==changeProductQuantity_Button){
            display.setText("Introduced Quantity: "+console.getText());
            changeProductQuantity(wordParser(0),Integer.parseInt(wordParser(1)));

        }
    }

    String wordParser(int index){



        String arr[] = console.getText().split(" ", 3);

            return arr[index];
    }

}
