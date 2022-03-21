import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        //temps
        boolean temp_server_sync;
        int temp_last_position;
        String temp_server_chat="";
        String ip="nothing";

        try {
            File myObj = new File("config.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                 ip = myReader.nextLine();
                System.out.println(ip);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        MyClient client = new MyClient();
        client.connect(ip, 25565);

        //create game Instance;
        TicTacToe ticTacToe_client = new TicTacToe();

//used to store the incoming data


        //hotaram simbolul

        TicTacToe.symbol= client.readInformation();

        //hotaram controlul

        TicTacToe.haveControl=Boolean.parseBoolean(client.readInformation());


        while (ticTacToe_client.gameActive == true) {

            try {
                Thread.sleep(33);//refresh time 1 second
            }catch (Exception e){
                System.out.println(e);
            }


            System.out.println("Information Package:");
            System.out.println("symbol="+TicTacToe.symbol);
            System.out.println("control="+TicTacToe.haveControl);
            System.out.println();
            //transmitem chat-ul

            temp_server_chat=client.readInformation();
            client.sendInformation(TicTacToe.chatString);

            if(temp_server_chat.length()>TicTacToe.chatString.length()){
                TicTacToe.chatString=temp_server_chat;
                TicTacToe.chatWindow.setText(temp_server_chat);
            }

            //verificam sync-urile si sincronizam

            temp_server_sync=Boolean.parseBoolean(client.readInformation());
            client.sendInformation(Boolean.toString(ticTacToe_client.sync));
            if(temp_server_sync==!TicTacToe.sync) {
                //adica exista o nesincronizare
                if (temp_server_sync == false) {
                    //s-a facut modificare in server(am pierdut controlul in server)
                    TicTacToe.haveControl = true;
                    //citim ultima pozitie a serverului
                    temp_last_position=Integer.parseInt(client.readInformation());
                    //sincronizam
                    ticTacToe_client.Sincronization(temp_last_position);
                }
                if (TicTacToe.sync == false) {
                    //transferam ultima pozitie
                    client.sendInformation(Integer.toString(TicTacToe.pozition));
                    TicTacToe.sync = !TicTacToe.sync;
                }
            }

        }

        client.stop();

    }

}

