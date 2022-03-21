package test_amestecare;

import org.junit.Test;
import pack_carte.Carte;
import pack_carte.Pachet;

import static org.junit.Assert.*;
import java.util.Vector;

public class test {



    @Test

    public void test(){
        int similarities=0;
new Pachet();

        Vector<Integer> cartiValori= new Vector<>();

        Pachet.initializareCarti();

        for(int i=1;i<=52;i++){
            cartiValori.add(Pachet.primaCarte().getValoare());
        }

        //pachet se sterge
        Pachet.initializareCarti();

        Pachet.amestecareCarti(150);
//se verifica inainte de amestecare valorile cartilor

       // Pachet.afisarePachet();//pachet amestecat

        for(int valoare:cartiValori){

    if(Pachet.primaCarte().getValoare()== valoare)
            similarities++;

        }


        System.out.println("similarities: "+similarities);

        boolean state=false;
        if(similarities<=15)
            state=true;

assertTrue(state);

    }


}
