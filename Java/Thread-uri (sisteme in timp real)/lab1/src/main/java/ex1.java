


public class ex1 {

   private numarComplex nr1;
   private numarComplex nr2;

   public void setnr1(int r, int i){
       nr1=new numarComplex(r,i);
   }
    public void setnr2(int r, int i){
        nr2=new numarComplex(r,i);
    }

   public numarComplex sumaComplex(numarComplex nr1,numarComplex nr2){

return new numarComplex(nr1.real+nr2.real,nr1.imaginar+nr2.imaginar);
    }


    public numarComplex produsComplex(numarComplex nr1,numarComplex nr2){

        return new numarComplex(nr1.real*nr2.real-nr1.imaginar* nr2.imaginar,nr1.real*nr2.imaginar+nr1.imaginar*nr2.real);
    }


    public static void main(String[] args) {

       ex1 lab1= new ex1();
       lab1.setnr1(1,5);
       lab1.setnr2(5,5);

        lab1.sumaComplex(lab1.nr1, lab1.nr2).afisare();
       lab1.produsComplex(lab1.nr1, lab1.nr2).afisare();


    }

}
