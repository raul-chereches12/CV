package pack_computer;

import pack_carte.Carte;
import pack_carte.Mana;

public class Score {
    //class for calculating the score
    //biggest problem would be to decide the value of the ace 11 or 1


    public static void update(Mana manaCurenta){


if((manaCurenta.size()==2)&&(manaCurenta.getMana().get(0).getValoare()==11)&&(manaCurenta.getMana().get(1).getValoare()==11))
    manaCurenta.setSuma(21);//blackjack

        int sum=0;
//calculating the sum where aces count 11
        for (Carte carte : manaCurenta.getMana()) {

            sum+=carte.getValoare();

        }

        System.out.println("actual sum:"+sum);

        int increment=0;
        boolean found = false;


while((increment<=manaCurenta.getAcesInHand())&&(found==false)) {
//executed AcesInHand+1 times
    //why?
    //example. if we have 2 aces we consider following values
    // 11 11
    // 11 1
    // 1  1

    if(sum-increment*10<=21) {
        System.out.println("updated sum: "+(sum-increment*10));
        manaCurenta.setSuma(sum-increment*10);
        found=true;
    }


    increment++;//next combination
}
//case where we didn`t found minimal sum
if(found==false){

    manaCurenta.setSuma(sum);

        }



    }


}
