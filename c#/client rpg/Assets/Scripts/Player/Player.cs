using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour
{

    private static string name = "P_client";
    private Player player;//singleton

    //stats

    private int str=0;
    private int agi = 0;
    private int stamina = 0;
    private int dex = 0;

    // Start is called before the first frame update
    void Start()
    {
        if (player != null)
        {
            player = new Player();
        }
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public static string getName()
    {
        return name;
    }
}
