package ex4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Car implements Serializable {

    private String model;
    private int price;

    Car(String model,int price){
        this.model=model;
        this.price=price;
    }

    @Override
    public String toString() {
        return "Masina[" +
                "model='" + model + '\'' +
                ", price=" + price +
                ']';
    }
}

