package pack_computer;


import exceptions.CardsLimitExcededException;
import pack_carte.Mana;
import pack_carte.Pachet;

import java.util.Random;

public class ComputerAI {

    private static int dificultate = 1;
    private boolean decizie_luata = false;

//aici se face mana calculatorului
    public void manaCalculator(Mana manaCurenta) {

        while (decizieCalculator(manaCurenta)) {
            //while true se tot ia carte
            try {
                manaCurenta.iaCarte();//se ia carte pt calculator
            }catch (CardsLimitExcededException e){
                System.out.println(e.getMessage());
            }

            decizieCalculator(manaCurenta);
        }


    }

    public boolean decizieCalculator(Mana manaCurenta) {


        if (manaCurenta.getSuma() >= 21) {
            decizie_luata = true;//ca nu cumva sa se mai poata lua decizia inca o data
            return false;//nu se mai ia carte se asteapta compararea cartilor pe masa
        } else {


            Random random = new Random(); // uses System.nanoTime() as seed
            int decizie = random.nextInt(130);

            int dif = 21 - manaCurenta.getSuma();

            if (decizie <= dif * 10)
                return true;//se mai ia o mana
            else {
                decizie_luata = true;
                return false;//nu se mai ia mana
            }

        }


    }


    public boolean isDecizie_luata() {
        return decizie_luata;
    }
}
