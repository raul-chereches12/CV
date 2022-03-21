package ex5;

public class Flower{
    int petal;

    private static int counting=0;
    Flower(){
        System.out.println("Flower has been created!");
        counting++;
    }



    public int numberOfConstructedObjects(){
        return counting;
    }
}