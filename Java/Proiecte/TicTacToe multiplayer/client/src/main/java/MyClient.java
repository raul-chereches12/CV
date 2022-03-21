import java.io.*;
import java.net.*;
public class MyClient {
    private String information;
    private Socket s;
    DataOutputStream dout;



    public void connect(String host, int port) {


        try {
            s = new Socket(host, port);//connect to server
            System.out.println("Connection succesful to <"+host+"> port: <"+port+"> ");
        } catch (Exception e)
        {
            System.out.println("Unable to connect to <"+host+"> port: <"+port+"> "+e);
        }

    }


    public void sendInformation(String data){
        try {
            dout = new DataOutputStream(s.getOutputStream());


            dout.writeUTF(data);
            dout.flush();


        }catch (Exception e){
            System.out.println("Nu s-a putut transfera informatia "+e);
        }

    }

    public String readInformation(){

        try {
            DataInputStream din = new DataInputStream(s.getInputStream());

            return din.readUTF();

        }catch (Exception e){
            System.out.println("Nu s-a putut citi informatia: "+e);
        }
        return "No information recived";
    }

    public void stop(){
        try {
            dout.close();
            s.close();
        }catch (Exception e){
            System.out.println("Nu s-a putut inchide client-ul "+e);
        }
    }

    public void tranferPackage(){
        //sync
        //pos
        //control
        //sym

    }

}

