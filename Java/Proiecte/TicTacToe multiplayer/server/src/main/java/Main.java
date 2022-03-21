import java.awt.*;

public class Main {


    public static void main(String[] args) {

//temps
        boolean temp_client_sync;
        int temp_last_position;
        String temp_client_chat="";

        MyServer server = new MyServer();
        server.createServer(25565);
        //create game Instance;
        TicTacToe ticTacToe_server = new TicTacToe();

        //hotaram simbolul

        new ChooseSymbol();

        while(TicTacToe.symbol==null){
            //asteptam sa se aleaga symbolul;

            try {
                Thread.sleep(1000);//refresh time 1 second
            }catch (Exception e){
                System.out.println(e);
            }

        }





        if (TicTacToe.symbol == "X") {
            server.sendInformation("0");
        } else {
            server.sendInformation("X");
        }

        ///////////hotaram cine incepe primul
        int[] rolledNumbers = ticTacToe_server.rollTheDice();

        if (rolledNumbers[0] > rolledNumbers[1]) {
            server.sendInformation("false");
            ticTacToe_server.giveControl();
            //se da controlul la server
        } else {
            server.sendInformation("true");
            ticTacToe_server.takeControl();
            //se ia controlul de la server
        }
        //////////

        while (ticTacToe_server.gameActive) {


            try {
                Thread.sleep(33);//refresh time 1 second
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Information Package:");
            System.out.println("symbol="+TicTacToe.symbol);
            System.out.println("control="+TicTacToe.haveControl);
            System.out.println();


            /////isTyping

            if(TicTacToe.chatTextField.getText().length()!=0){

                TicTacToe.chatWindow.setText(TicTacToe.chatString+
                        TicTacToe.nameTextField.getText()+": is Typing ...\n");

            }else{

            }

            //transmitem chat-ul

            server.sendInformation(TicTacToe.chatString);
            temp_client_chat=server.readInformation();

            if(temp_client_chat.length()>TicTacToe.chatString.length()){
                TicTacToe.chatString=temp_client_chat;
                TicTacToe.chatWindow.setText(temp_client_chat);
            }

//verificam sync-urile

            server.sendInformation(Boolean.toString(ticTacToe_server.sync));
            temp_client_sync=Boolean.parseBoolean(server.readInformation());
if(temp_client_sync==!TicTacToe.sync) {
    //adica exista o nesincronizare
    if (temp_client_sync == false) {
        //s-a facut modificare in client(am pierdut controlul in client)
        TicTacToe.haveControl = true;
        //citim ultima pozitie a clientului
        temp_last_position=Integer.parseInt(server.readInformation());
        //sincronizam
        ticTacToe_server.Sincronization(temp_last_position);
    }
    if (TicTacToe.sync == false) {
        //transferam ultima pozitie
        server.sendInformation(Integer.toString(TicTacToe.pozition));
        TicTacToe.sync = !TicTacToe.sync;
    }
}



        }


        server.stop();


    }

}
