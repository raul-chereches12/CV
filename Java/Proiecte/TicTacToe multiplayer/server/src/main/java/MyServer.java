import java.io.*;
import java.net.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;





public class MyServer {
    private ServerSocket ss;
    private Socket s;
    DataInputStream din;





    public void createServer(int port){
        try{
            ss=new ServerSocket(port);

            s=ss.accept();//establishes connection
            System.out.println("Client connected");
            System.out.println();

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public String readInformation(){
        try{
            din = new DataInputStream(s.getInputStream());
            return din.readUTF();

        }catch (Exception e){
            System.out.println(e);}
        return "No information recived";
    }

    public void sendInformation(String data){
        try{
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(data);
            dout.flush();

        }catch (Exception e){
            System.out.println(e);
        }

    }


    public void stop(){
        try {
            System.out.println("inchidere program");
            din.close();
            s.close();
            ss.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }



    public static boolean verifyHash(String input)
    {
//input==password
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext.equals("hash");//aici verificam daca coincid cele 2 hash-uri

        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


}
