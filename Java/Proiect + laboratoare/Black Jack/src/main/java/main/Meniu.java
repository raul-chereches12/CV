package main;

public class Meniu {

    public static void main(String[] args) {

        int partida = 1;

        while (true) {
            GameInstance blackjack = new GameInstance();

            System.out.println("A inceput partida numarul: " + partida);


            try {
                blackjack.startGame();

            } catch (Exception e) {
                System.out.println(e.getCause());
            }


            partida++;
        }

    }


}
