public class Subiect1 {
    //nimic
}

class K{

}
class M{

    private B classB;

    M(){

this.classB=new B();

    }

}
class L extends K{
    private int a;
    private M classM;

    public void b(){

    }

    public void i(){

    }


}

class A{

    private M classM;

    A(M classM){
        this.classM=classM;
    }

}

class B{



}

class X{
//relatie de dependenta

    public void met(L l){
        l.b();
        l.i();
        //ne folosim de metodele clasei L prin intermediul obiectului l
    }
}