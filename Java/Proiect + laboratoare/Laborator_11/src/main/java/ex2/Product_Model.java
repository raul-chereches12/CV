package ex2;

import java.util.ArrayList;
import java.util.List;

public class Product_Model {

    private String name;
    private int quantity;
    private int price;



Product_Model(String name,int quantity,int price){
    this.name=name;
    this.quantity=quantity;
    this.price=price;

}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
