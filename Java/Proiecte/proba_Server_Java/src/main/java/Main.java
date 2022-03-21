public class Main {


    public static void main(String[] args) {

MyClient client =new MyClient();
MyServer server =new MyServer();

//open server
        server.createServer(6666);
        //connect to server
        client.connect("localhost",6666);

        server.sendInformation("am trimis de la server: raul are mere");
        System.out.println(client.readInformation());

        client.sendInformation("am trimis de la client: tudor are mere");
        System.out.println(server.readInformation());

        client.stop();
        server.stop();




    }

}
