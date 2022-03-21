package ex1;

public class Robot {


    int x;

    public Robot(){
        this.x=1;

    }

    public void Change(int k){
        if(k>=1)
            this.x=k;

    }

    public int getX() {
        return x;
    }

    public void afisare(){

        System.out.println("pozitia este: "+x);



    }


}
