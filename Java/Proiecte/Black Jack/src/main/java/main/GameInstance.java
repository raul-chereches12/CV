package main;

import exceptions.CardsLimitExcededException;
import gui.MyFrame;
import pack_carte.Mana;
import pack_carte.Pachet;
import pack_computer.ComputerAI;
import pack_computer.Logs;

public class GameInstance {


    private Pachet pachet = new Pachet();//pachetul de carti
    private final Mana manaPlayer = new Mana();//mainile de joc, initial goale
    private Mana manaCalculator = new Mana();
    private ComputerAI computer = new ComputerAI();
    private boolean active = true;


    public void startGame() throws InterruptedException {

        MyFrame gui = MyFrame.getInstance();//Graphic User Interface
        gui.initWindow();

        Pachet.initializareCarti();//se pun cartile in pachet
        Pachet.afisarePachet();
        Pachet.amestecareCarti(150);//se amesteca pachetul de 150 de ori


        boolean ok = true;
        while (ok) {

            String optiune = gui.getOption();

            Thread.sleep(50);

            if (optiune != "0") {

                clearConsole();
                gui.optionReset();

                switch (optiune) {
                    case "take card":
                        try {
                        manaPlayer.iaCarte();//se ia o carte nou
                        }catch (CardsLimitExcededException e){
                            System.out.println(e.getMessage());
                        }
                        gui.reDrawHand(manaPlayer, "player");
                        break;

                    case "stop":
                        //cazul in care calculatorul isi ia deciziile
                        if (!computer.isDecizie_luata())//daca nu s-a luat decizia deja
                            computer.manaCalculator(manaCalculator);//se verifica

                        gui.reDrawHand(manaCalculator, "computer");


                        ok = false;//vedem cine a castigat se executa comparareMaini()
                        //se inchide bucla aceasta
                        break;

                    case "show":
                        System.out.println(manaPlayer.afisareMana());
                        break;

                    case "4":
                        System.out.println("///////////////////////////////");
                        pachet.afisarePachet();
                        System.out.println("///////////////////////////////");
                        break;

                    default:
                        break;


                }
            }

        }
//partea finala in care jocul s-a terminat
        //terminarea partidei
        System.out.println(comparareMaini(manaPlayer, manaCalculator));//se vede castigatorul

        gui.writeConsole(comparareMaini(manaPlayer, manaCalculator));//se scrie catre consola din gui

        Logs.update(comparareMaini(manaPlayer, manaCalculator));//update the logs

//ending
        gui.endingScene();

        ok = true;
        //wait for new game
        while (ok) {

            String optiune = gui.getOption();
            Thread.sleep(50);

            if (optiune == "new game") {
                ok = false;
            }

        }

       gui.dispose();
       gui.deleteInstance();//delete instance of singleton to be able to create another unique one


    }

    public void stopGame() {
        //pt. oprirea buclei din meniu
        this.active = false;

    }

    String comparareMaini(Mana mana1, Mana mana2) {
        //afisare si comparare maini castigatoare
        String string;//ce returneaza
        if ((mana1.getSuma() <= 21) && (mana2.getSuma() <= 21)) {//caz comparare cand amandoua <=21
            if (mana1.getSuma() > mana2.getSuma()) {
                string = "A castigat Player-ul cu " + mana1.getSuma() + ", iar Calculatorul a pierdut cu " + mana2.getSuma() + " carti castigator: \n" + mana1.afisareMana();

            } else {
                string = "A castigat Calculatorul cu " + mana2.getSuma() + ", iar mana 1 a pierdut cu " + mana1.getSuma() + " carti castigator: \n" + mana2.afisareMana();

            }
        } else if (mana1.getSuma() > 21) {
            string = "A castigat Calculatorul cu " + mana2.getSuma() + " carti castigator: \n" + mana2.afisareMana();//caz mana1(player)>21

        } else {
            string = "A castigat Player-ul cu " + mana1.getSuma() + " , iar Calculatorul cu " + mana2.getSuma() + " carti castigator: \n" + mana1.afisareMana();//caz mana2(calculator)>21


        }
        string += "\n\n";
        string += "player:\n" + mana1.afisareMana() + "\n" + "calculator:\n" + mana2.afisareMana();

        return string;


    }


    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }

//    public Mana getManaPlayer() {
//        return manaPlayer;
//    }

//nefolositoare inca

//    public Mana getManaCalculator() {
//        return manaCalculator;
//    }

}
