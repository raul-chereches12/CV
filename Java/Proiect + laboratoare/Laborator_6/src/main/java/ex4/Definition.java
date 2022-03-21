package ex4;

public class Definition {

    private String description;

    public Definition(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.description+" ";

    }
}
