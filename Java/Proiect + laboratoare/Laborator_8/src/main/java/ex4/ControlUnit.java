package ex4;

public class ControlUnit {

    private static ControlUnit singleton=null;


    public static ControlUnit getInstance() {
        if (singleton == null)
            singleton = new ControlUnit();

        return singleton;
    }
public void execute(){
    System.out.println("Control step executed");
}


    }


