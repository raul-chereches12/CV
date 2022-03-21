package ex4;

import java.io.*;

public class CarDealership {

Car createCar(String model,int price){
    Car car=new Car(model,price);

    System.out.println(car+" is running.");

return car;
}

    void storeCar(Car a, String storeRecipientName) throws IOException {
        ObjectOutputStream o =
                new ObjectOutputStream(
                        new FileOutputStream(storeRecipientName));

        o.writeObject(a);
        System.out.println(a+":I'll go faster");
    }

    Car takeCar(String storeRecipientName) throws IOException, ClassNotFoundException{
        ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream(storeRecipientName));
        Car x = (Car)in.readObject();
        System.out.println(x+":I'm ready to race");

        return x;
    }

}
