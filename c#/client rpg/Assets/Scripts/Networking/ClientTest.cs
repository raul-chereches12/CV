using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;
using System.Threading;
using System.Net.Sockets;

public class ClientTest : MonoBehaviour
{




    private static bool isStopped = false;
    private Thread thread;
    private static AutoResetEvent resetEvent;
    
    private static string auxString=" ";

    private static TcpClient client;
    private static NetworkStream stream;

    public static string json=" ";

    



    // Start is called before the first frame update
    void Start()
    {

        resetEvent = new AutoResetEvent(false);


        thread = new Thread(Run);
        thread.Start();



    }

    // Update is called once per frame
    void Update()
    {

        
        resetEvent.Set();

    }


    public static void Run()
    {

        // Create a TcpClient.
        // Note, for this client to work you need to have a TcpServer
        // connected to the same address as specified by the server, port
        // combination.
        Int32 port = 5001;
        client = new TcpClient("localhost", port);



        while (!isStopped)
        {
            resetEvent.WaitOne();

            //wrapping the information

            // infoPackage myObject = new infoPackage();
            //  myObject.chatString = auxString;
            //  string json = JsonUtility.ToJson(myObject);

            
                Connect("localhost",json);
            Debug.Log(auxString);

        }

        // Close everything.
        stream.Close();
        client.Close();


    }

    static void Connect(String server, String message)
    {
        try
        {
         
            // Translate the passed message into ASCII and store it as a Byte array.
            Byte[] data = System.Text.Encoding.ASCII.GetBytes(message);

            // Get a client stream for reading and writing.
            //  Stream stream = client.GetStream();

            stream = client.GetStream();

            // Send the message to the connected TcpServer.
            stream.Write(data, 0, data.Length);

            Debug.Log("Sent: " + message);


            // Receive the TcpServer.response.

            // Buffer to store the response bytes.
            data = new Byte[256];

            // String to store the response ASCII representation.
            String responseData = String.Empty;

            // Read the first batch of the TcpServer response bytes.
            Int32 bytes = stream.Read(data, 0, data.Length);
            responseData = System.Text.Encoding.ASCII.GetString(data, 0, bytes);
            Debug.Log("Recived: " + responseData);

            //process informations
            if (message!= responseData)
           {
                Chat.chatString = responseData;
           }

           
        }
        catch (ArgumentNullException e)
        {
            Console.WriteLine("ArgumentNullException: {0}", e);
        }
        catch (SocketException e)
        {
            Console.WriteLine("SocketException: {0}", e);
        }

        //Console.WriteLine("\n Press Enter to continue...");
       // Console.Read();
    }
   
    private void OnApplicationQuit()
    {

        isStopped = true;

    }

    [Serializable]

    class infoPackage
    {
        public string chatString;


    }





}
