package ex4;

public class SerializareExemplu {
    public static void main(String[] args) throws Exception{
        CarDealership f = new CarDealership();

        Car masina1 = f.createCar("mercedes",40000);
        Car masina2 = f.createCar("5R",60000);

        f.storeCar(masina1,"mercedes.dat");
        f.storeCar(masina2,"bmw.dat");

        Car x = f.takeCar("mercedes.dat");
        Car y = f.takeCar("bmw.dat");

        System.out.println(x);
        System.out.println(y);
    }
}//.class
