package test_nr_carti;

import org.junit.Test;

import pack_carte.Carte;
import pack_carte.Pachet;

import static org.junit.Assert.*;



public class test {

    @Test

    public void test() {

      //  Pachet pachet = new Pachet();//pachetul de carti
        Pachet.initializareCarti();//se pun cartile in pachet

        Carte carte = Pachet.primaCarte();
        System.out.println(carte.afisareCarte());
        int i=0;

        try {


            while (carte != null) {


                i++;
                carte = Pachet.primaCarte();
            }
        }catch (Exception e){
            System.out.println(e);
        }


        assertEquals(52,i);//52 de carti in pachet



    }




}
