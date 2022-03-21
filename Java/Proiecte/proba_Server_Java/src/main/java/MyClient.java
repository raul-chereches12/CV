import java.io.*;
import java.net.*;
public class MyClient {
    private String information;
    private Socket s;

    public static void main(String[] args) {
        MyClient client=new MyClient();

        client.connect("localhost",6666);

        System.out.println(client.readInformation());

        client.stop();




    }

    public void connect(String host, int port) {


        try {
             s = new Socket(host, port);//connect to server
        } catch (Exception e)
        {
            System.out.println("Nu s-a putut realiza conectiunea: "+e);
        }

    }


   public void sendInformation(String data){
try {
    DataOutputStream dout = new DataOutputStream(s.getOutputStream());


    dout.writeUTF(data);
    dout.flush();
    dout.close();

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
            s.close();
        }catch (Exception e){
            System.out.println("Nu s-a putut inchide client-ul "+e);
        }
    }

}
