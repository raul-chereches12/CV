public class Diagrama {
    //nu conteaza
}


class A extends B{
}

class B {
    private String param;
    private E classE;//agregare( ne folosim de un obiect existent primit de exemplu ca paramentru prin cosntructor)
    private D classD;

    B(){

    }


    B(E classE){
        this.classE=classE;
    }

    public void x(){
    }

    public void y(){

    }

}

class C{
    private B classB;

    C(){
        this.classB=new B(new E());//compozitie (daca obiectul B depinde de clasa C , daca clasa C este stearsa(sau un obiect al ei)
        //si obiectul clasei B este sters.
    }

}

class D{
}

class E{
}

class U{
    //relatie de dependenta, ne folosim de clasa B(de metode etc..prin intermediul unui obiect de clasa B)

    private B classB;

    U(B classB){
        this.classB=classB;//doar pentru a face logica
    }

    public void algoritm(){

        classB.x();
        classB.y();//ne folosim de clasa B (depindem de ea)
    }


}


