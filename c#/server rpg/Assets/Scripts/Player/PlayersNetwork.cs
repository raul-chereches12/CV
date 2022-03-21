using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayersNetwork : MonoBehaviour
{


    public static List<Transform> connectedPlayers;
    public static Dictionary<int, Vector2> positionBuffer;

    private static Vector3 spawnPoint;

    public GameObject skin_1;
    public static GameObject currentSkin;


    private static GameObject gameObj;
    

        // Start is called before the first frame update
    void Start()
    {

        positionBuffer = new Dictionary<int, Vector2>();

        currentSkin = skin_1;

        connectedPlayers = new List<Transform>();

        gameObj = this.gameObject;//

        spawnPoint = new Vector3(0, 0, 0);

        //add main caracter first

        connectedPlayers.Add(this.gameObject.transform.GetChild(0));
        connectedPlayers[0].gameObject.GetComponent<Player>().name = "P_server";

        //add in position buffer
        positionBuffer.Add(0, new Vector2(0, 0));


    }

    // Update is called once per frame
    void Update()
    {



        if (connectedPlayers.Count > 1)
        {
            //here we update the positions in position buffer
            updateOurPosition();
            updatePlayersPosition();
        }


       
        
    }

    public static void spawnPlayer(string name)
    {

        //create and add new player;
        var newPlayer = Instantiate(currentSkin, spawnPoint, Quaternion.identity);
        newPlayer.transform.parent = gameObj.transform;

        connectedPlayers.Add(newPlayer.transform);//add player`s transform 
        connectedPlayers[1].gameObject.GetComponent<Player>().name = name;//set the name


        //add in position buffer
        positionBuffer.Add(1,new Vector2(0, 0));


    }

    private void updateOurPosition()
    {
        positionBuffer[0] = connectedPlayers[0].position;
    }


    private void updatePlayersPosition()
    {
        connectedPlayers[1].position = positionBuffer[1];
    }


}
