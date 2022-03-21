using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;

public class ServerSocket : MonoBehaviour
{


    private static IPHostEntry host = Dns.GetHostEntry("localhost");
    private static IPAddress ipAddress = host.AddressList[0];
    private static IPEndPoint localEndPoint = new IPEndPoint(ipAddress, 11000);
    private static Socket listener = new Socket(ipAddress.AddressFamily, SocketType.Stream, ProtocolType.Tcp);

    private static byte[] bytes = new byte[1024];
    private static int bytesRec;
    


    private static Socket handler=null;

    private static byte[] msg;

    private static Vector3 playerPosition;

    private static bool isStopped = false;

    private Thread thread;

    private static AutoResetEvent resetEvent;

    



    // Start is called before the first frame update
    void Start()
    {

        resetEvent = new AutoResetEvent(false);

        playerPosition = new Vector3(0,0,0);
        StartServer();

        thread = new Thread(Run);
        thread.Start();

        Debug.Log("Serverul a pornit ! ! !");
        Debug.Log("\n");

    }

    // Update is called once per frame
    void Update()
    {

        resetEvent.Set();
        playerPosition = transform.position;




       
    
    }

    public static void StartServer()
    {
        
        // Get Host IP Address that is used to establish a connection  
        // In this case, we get one IP address of localhost that is IP : 127.0.0.1  
        // If a host has multiple addresses, you will get a list of addresses  
        IPHostEntry host = Dns.GetHostEntry("localhost");
        IPAddress ipAddress = host.AddressList[0];
        IPEndPoint localEndPoint = new IPEndPoint(ipAddress, 11000);


        try
        {
           
            // Create a Socket that will use Tcp protocol      
            listener = new Socket(ipAddress.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
            // A Socket must be associated with an endpoint using the Bind method  
            listener.Bind(localEndPoint);
            // Specify how many requests a Socket can listen before it gives Server busy response.  
            // We will listen 10 requests at a time  
            listener.Listen(10);

            Debug.Log("Waiting for a connection...");
            handler = listener.Accept();







        }
        catch (Exception e)
        {
            Console.WriteLine(e.ToString());
        }

        Console.WriteLine("\n Press any key to continue...");
        Console.ReadKey();
    }

    public static void closeServer()
    {

        handler.Shutdown(SocketShutdown.Both);
        handler.Close();

    }


    public static void Run()
    {
        while (!isStopped)
        {
            resetEvent.WaitOne();

            try {
                
                //sending part
                //wrap up the information
                networkPackage information = new networkPackage();
               information.chatString = Chat.chatString;
                string json = JsonUtility.ToJson(information);
                //Send info
                msg = Encoding.ASCII.GetBytes((string)Chat.chatString);
                handler.Send(msg);

                //halt

                //reciving part
                //recieve info
                bytesRec = listener.Receive(bytes);
                json = Encoding.ASCII.GetString(bytes, 0, bytesRec);
                //Desearize information
                networkPackage recivedInformation = JsonUtility.FromJson<networkPackage>(json);
                Debug.Log(recivedInformation);

                //process informations
                if (Chat.chatString != json)
                {
                    Chat.chatString = json;
                }





            }
            catch (Exception e)
            {
                Debug.Log("Unexpected exception:"+e.ToString());

            }


    }

    }

    public void OnApplicationQuit()
    {
        thread.Abort();
        isStopped = true;
        closeServer();

    }




}

[Serializable]
class networkPackage
{
    public string chatString;



}

