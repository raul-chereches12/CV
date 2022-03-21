package pack_carte;

import exceptions.CardsLimitExcededException;
import pack_computer.Score;

import java.util.Vector;

public class Mana {

    private Vector<Carte> mana = new Vector<Carte>();
    private int suma = 0;
    private int acesInHand=0;

    public void iaCarte() throws CardsLimitExcededException{//se ia prima carte din mana si in acelasi timp se face si suma

        if(mana.size()>=5)
        throw new CardsLimitExcededException();

Carte carte=Pachet.primaCarte();

if(carte.getValoare()==11){
    acesInHand++;
}
mana.add(carte);

        Score.update(this);

//        if (who == "computer") {
//            if ((carte.getValoare() == 11) && (mana.size() == 0))
//                suma += 11;//cazul in care se considera asul 11
//            else if ((carte.getValoare() == 11) && (mana.size() > 0)) {
//                suma += 1;//cazul in care se considera asul 1
//                carte.setValoare(1);
//            } else {
//                //cazul in care nu este as
//                suma += carte.getValoare();
//                mana.add(carte);//se adauga cartea la mana
//            }
//        } else if (who == "player") {
//            suma += carte.getValoare();
//            mana.add(carte);//se adauga cartea la mana
//        }


    }

    public Vector<Carte> getMana() {
        return mana;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma=suma;
    }

    public int getAcesInHand() {
        return acesInHand;
    }

    public String afisareMana() {
        String s = "";
        for (Carte o : mana) {

            s += o.getValoare() + " " + o.getCuloare() + " " + o.getDenumire() + " \n";


        }
        return s;
    }

    public int size() {
        return mana.size();
    }

}
