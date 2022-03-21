package ex3;

public class Author {
    private
    String name;
    String email;
    char gender;


    public Author(String nume,String email,char gen){
this.name=nume;
this.email=email;
this.gender=gen;


    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return this.name+" ("+this.gender+")"+
                " at " + this.email;
    }


}
