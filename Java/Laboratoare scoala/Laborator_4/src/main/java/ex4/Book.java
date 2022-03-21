package ex4;

import ex2.Author;

import java.util.Arrays;

public class Book {
    private String name;
    private Author[] author;
    private double price;
    private int qtyInStock=0;

    public Book(String name,Author[] author,double price){
        this.name=name;
        this.author=author;
        this.price=price;
    }

    public Book(String name,Author[] author,double price,int qtyInStock){
        this.name=name;
        this.author=author;
        this.price=price;
        this.qtyInStock=qtyInStock;

    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }



    public void printAuthors(){
        int i;

        for(i=0;i< author.length;i++){
            System.out.print(author[i]+" ");
        }




    }


}
