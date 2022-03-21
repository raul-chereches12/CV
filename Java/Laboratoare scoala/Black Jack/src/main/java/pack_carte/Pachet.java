package pack_carte;

import java.util.Collections;
import java.util.Vector;
import java.util.Random;

public class Pachet {

    private static Vector<Carte> pachet = new Vector<Carte>();


    public static void initializareCarti() {
        String[] culori = {"rosu", "negru"};
        String[] simbol = {"caro", "trefla", "inima", "pica"};
        String[] regal = {"valet", "dama", "popa", "as"};

        int i;
        int j;

        int valoare = 2;

        for (i = 2; i <= 14; i++) {//cartile 2 4 5 6 7 8 9 10 10 10 10
            if (i <= 10) {

                for (j = 0; j <= 3; j++) {

                    Carte carte_de_adaugat = new Carte();

                    carte_de_adaugat.setValoare(valoare);
                    carte_de_adaugat.setDenumire(simbol[j]);
                    carte_de_adaugat.setCuloare(culori[j % 2]);
                    pachet.add(carte_de_adaugat);

                }
                valoare++;

            } else {
                for (j = 0; j <= 3; j++) {
                    Carte carte_de_adaugat = new Carte();

                    if (j == 3) {
                        carte_de_adaugat.setValoare(11);
                        ;//caz as
                    } else
                        carte_de_adaugat.setValoare(10);

                    carte_de_adaugat.setDenumire(regal[j]);
                    carte_de_adaugat.setCuloare(simbol[i % 4]);

                    pachet.add(carte_de_adaugat);

                }


            }

        }
        //                      /\
//aici avem cartile de la 2-A---||


    }


    public static void afisarePachet() {
        int i = 0;
        for (Carte o : pachet) {
            i++;
            System.out.println(o.getValoare() + " " + o.getCuloare() + " " + o.getDenumire() + " ");

            if (i % 4 == 0)
                System.out.println();
        }

    }

    public static void amestecareCarti(int cicluri) {
        Random rand = new Random();

        for (int i = 1; i <= cicluri; i++) {
            int myRandNumber1 = rand.nextInt(51);
            int myRandNumber2 = rand.nextInt(51);
            Collections.swap(pachet, myRandNumber1, myRandNumber2);

        }


    }

    public static Carte primaCarte() {

        Carte aux = pachet.get(0);
        pachet.remove(0);

        return aux;

    }


}
