package ex2;

public class Controller {

    public static void main(String[] args) {


        View produse=new View();

        produse.addNewProduct(new Product_Model("Branza",20,20));

        produse.addNewProduct(new Product_Model("Ciocolata",10,15));

        produse.viewAvailableProducts();



    }





}
