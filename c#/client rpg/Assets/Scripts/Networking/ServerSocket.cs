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
            Socket listener = new Socket(ipAddress.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
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
                //send player position x
                msg = Encoding.ASCII.GetBytes(playerPosition.x.ToString());
                handler.Send(msg);

                //send player position y
                msg = Encoding.ASCII.GetBytes(playerPosition.y.ToString());
                handler.Send(msg);
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

