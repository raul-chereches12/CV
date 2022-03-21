package ex1;

class Cofee{
    private int temp;
    private int conc;
private static int numberOfInstances=0;

    Cofee(int t,int c){
        temp = t;
        conc = c;
        numberOfInstances++;
    }

    public static int getNumberOfInstances() {
        return numberOfInstances;
    }

    int getTemp(){return temp;}
    int getConc(){return conc;}
    public String toString(){return "[cofee temperature="+temp+":concentration="+conc+"]";}
}//.class
