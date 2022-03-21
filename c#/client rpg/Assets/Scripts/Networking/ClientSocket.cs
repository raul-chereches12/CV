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

    private byte[] bytes = new byte[1024];
    private static IPHostEntry host = Dns.GetHostEntry("localhost");
    private static IPAddress ipAddress = host.AddressList[0];
    private IPEndPoint remoteEP = new IPEndPoint(ipAddress, 11000);
    private static Socket sender = new Socket(ipAddress.AddressFamily,
                SocketType.Stream, ProtocolType.Tcp);

    private static Socket handler = null;
    private static byte[] msg;

    private int bytesRec;

    private int frame = 0;

    bool isStopped = false;
    private Thread thread;

    private static AutoResetEvent resetEvent;

   

    


    // Start is called before the first frame update
    void Start()
    {
        
        resetEvent = new AutoResetEvent(false);

        StartClient();

        thread = new Thread(Run);
        thread.Start();


    }

    // Update is called once per frame
    void Update()
    {
        resetEvent.Set();

        

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
                handler = sender.Accept();

                Debug.Log("Socket connected to "+sender.RemoteEndPoint.ToString());

                
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


            //recieve info
            bytesRec = sender.Receive(bytes);
             String json = Encoding.ASCII.GetString(bytes, 0, bytesRec);
            //Desearize information
             networkPackage recivedInformation = JsonUtility.FromJson<networkPackage>(json);
             Debug.Log(recivedInformation);



            //process informations
           // if (Chat.chatString != json)
           //  {
          //       Chat.chatString = json;
          //   }


            //sending part
            //wrap up the information
            networkPackage information = new networkPackage();
          //  information.chatString = Chat.chatString;
            json = JsonUtility.ToJson(information);
            //Send info
          //  msg = Encoding.ASCII.GetBytes(Chat.chatString);
            handler.Send(msg);



        }


    }

    public void OnApplicationQuit()
    {
        thread.Abort();
        isStopped = true;
        closeClient();
    }

}


[Serializable]
class networkPackage
{
    public string chatString;



}
