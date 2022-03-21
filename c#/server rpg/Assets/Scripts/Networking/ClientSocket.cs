using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using System.Text.RegularExpressions;

public class ClientSocket : MonoBehaviour
{

    //private Vector3 playerPosition;
    private static IPHostEntry host = Dns.GetHostEntry("localhost");
    private static IPAddress ipAddress = host.AddressList[0];
    private IPEndPoint remoteEP = new IPEndPoint(ipAddress, 11000);
    private static Socket sender = new Socket(ipAddress.AddressFamily,
                SocketType.Stream, ProtocolType.Tcp);

    private byte[] bytes = new byte[1024];
    private int bytesRec;

    private int frame = 0;

    bool isStopped = false;
    private Thread thread;

    private static AutoResetEvent resetEvent;

    private static Vector3 playerPosition;

    private Rigidbody2D myRigidbody;


    // Start is called before the first frame update
    void Start()
    {
        myRigidbody = GetComponent<Rigidbody2D>();
        resetEvent = new AutoResetEvent(false);

        StartClient();

        thread = new Thread(Run);
        thread.Start();


    }

    // Update is called once per frame
    void Update()
    {
        resetEvent.Set();

        frame++;

        myRigidbody.MovePosition(
           playerPosition
           );


    }

    public static void StartClient()
    {
        

        try
        {
            // Connect to a Remote server  
            // Get Host IP Address that is used to establish a connection  
            // In this case, we get one IP address of localhost that is IP : 127.0.0.1  
            // If a host has multiple addresses, you will get a list of addresses  
            IPHostEntry host = Dns.GetHostEntry("localhost");
            IPAddress ipAddress = host.AddressList[0];
            IPEndPoint remoteEP = new IPEndPoint(ipAddress, 11000);

            

            // Connect the socket to the remote endpoint. Catch any errors.    
            try
            {
                // Connect to Remote EndPoint  
                sender.Connect(remoteEP);

                Debug.Log("Socket connected to "+sender.RemoteEndPoint.ToString());

                

                // Receive the response from the remote device.    
                //int bytesRec = sender.Receive(bytes);
               // String message = Encoding.ASCII.GetString(bytes, 0, bytesRec);
               // Debug.Log("Echoed test = "+message);

               
            }
            catch (ArgumentNullException ane)
            {
                Console.WriteLine("ArgumentNullException : {0}", ane.ToString());
            }
            catch (SocketException se)
            {
                Console.WriteLine("SocketException : {0}", se.ToString());
            }
            catch (Exception e)
            {
                Console.WriteLine("Unexpected exception : {0}", e.ToString());
            }

        }
        catch (Exception e)
        {
            Console.WriteLine(e.ToString());
        }
    }

    public void closeClient()
    {



        // Release the socket.    
        sender.Shutdown(SocketShutdown.Both);
        sender.Close();


    }

    public void Run()
    {
        var regex = new Regex(@"^-?[0-9]*(?:\.-?[0-9]*)?$");

        while (!isStopped)
        {
            resetEvent.WaitOne();
            
            bytesRec = sender.Receive(bytes);
                String playerPosition_x = Encoding.ASCII.GetString(bytes, 0, bytesRec);


            bytesRec = sender.Receive(bytes);
                String playerPosition_y = Encoding.ASCII.GetString(bytes, 0, bytesRec);



            //if (frame > 30)
            //{
            //    frame = 0;
            //    Debug.Log("postion x: " + playerPosition_x + " position y: " + playerPosition_y);
            //    Debug.Log("\n");
           // }


            
            
            if(regex.IsMatch(playerPosition_x)&& regex.IsMatch(playerPosition_y)) { 

                playerPosition.x = Convert.ToSingle(playerPosition_x);
                playerPosition.y = Convert.ToSingle(playerPosition_y);

        }



    }


    }

    public void OnApplicationQuit()
    {
        thread.Abort();
        isStopped = true;
        closeClient();
    }

}
