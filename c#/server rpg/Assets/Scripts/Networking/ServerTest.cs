using System;
using System.Collections;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Threading;
using UnityEngine;

public class ServerTest : MonoBehaviour
{




    private static bool isStopped = false;
    private Thread thread;
    private static AutoResetEvent resetEvent;


    //connected clients
    private static ArrayList connectedClients;

    public static string json = " ";

    private static bool spawnPlayer = false;

    private static Package package;





    // Start is called before the first frame update
    void Start()
    {

        connectedClients = new ArrayList();//connected clients arraylist

        resetEvent = new AutoResetEvent(false);

        thread = new Thread(listenerRun);//
        thread.Start();

    }

    // Update is called once per frame
    void Update()
    {


        resetEvent.Set();
       

        //wrapping the information
       
      
        if(spawnPlayer)
        {
            PlayersNetwork.spawnPlayer("raulika88");//we need to call from the MAIN thread
            spawnPlayer = false;
        }


    }



    public static void listenerRun()
    {
        TcpListener server = null;

        // Set the TcpListener on port 13000.
        Int32 port = 25565;
        IPAddress localAddr = IPAddress.Parse("192.168.1.100");

        // TcpListener server = new TcpListener(port);
        server = new TcpListener(localAddr, port);

        // Start listening for client requests.
        server.Start();

        while (!isStopped)
        {
            
            resetEvent.WaitOne();

            // Perform a blocking call to accept requests.
            // You could also use server.AcceptSocket() here.
            TcpClient client = server.AcceptTcpClient();

            if (client.Connected)
            {
                Debug.Log("Client connected! :" + client.ToString());
                connectedClients.Add(client);

                spawnPlayer = true;

                //PlayersNetwork.spawnPlayer("raulika88");//we need to call from the MAIN thread

                //create new handler thread

                ThreadStart thdstHandler = new ThreadStart(handlerRun);//
                Thread thdHandler = new Thread(thdstHandler);
                thdHandler.Start();
            }


        }
        // Stop listening for new clients.
        server.Stop();

    }




    public static void handlerRun()
    {
        
        // Buffer for reading data
        Byte[] bytes = new Byte[256];
        String data = null;

        //get the socket from array
        TcpClient client = (TcpClient)connectedClients[connectedClients.Count - 1];

        //package to be sent!!!
        package = new Package();

        while (!isStopped)
        {

            resetEvent.WaitOne();
            try
            {



                data = null;

                // Get a stream object for reading and writing
                NetworkStream stream = client.GetStream();

                int i;

                // Loop to receive all the data sent by the client.
                while ((i = stream.Read(bytes, 0, bytes.Length)) != 0)
                {
                    // Translate data bytes to a ASCII string.
                    data = System.Text.Encoding.ASCII.GetString(bytes, 0, i);
                    Debug.Log("Recieved: " + data +" frame: ");


                    //process informations (DESEARILZE)
                    package = JsonUtility.FromJson<Package>(data);
                    PlayersNetwork.positionBuffer[1] = package.playerPosition;//get player position 1-first caracter position


                    //  if (json != data)
                    //  {
                    //     Chat.chatString = data;
                    //  }


                    

                    // Process the data sent by the client.(SEARILZE)
                    package.playerPosition = PlayersNetwork.positionBuffer[0];//send server position 0-main
                    json = JsonUtility.ToJson(package);

                    

                    byte[] msg = System.Text.Encoding.ASCII.GetBytes(json);

                    // Send back a response.
                    stream.Write(msg, 0, msg.Length);
                    Debug.Log("Sent: " + json);
                }





            }
            catch (Exception e)
            {
                Debug.Log("Unexpected exception:" + e.ToString());

            }




        }
        // Shutdown and end connection
        
        client.Close();

    }

    private void OnApplicationQuit()
    {
        isStopped = true;
    }



}

[Serializable]
public class Package
{
    public Vector2 playerPosition;

   // public bool chatUpdate;
   // public string chat="";
   // public string playerName;

}
