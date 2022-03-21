using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour
{

    private string name { set; get; }
   

    //stats

    private int strength=0;
    private int agility = 0;
    private int stamina = 0;
    private int intelligence = 0;

    public bool isWarrior = false;
    public bool isMage = false;

    // Start is called before the first frame update
    void Start()
    {
        name = "unnamed";
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void initializeWarrior()
    {
        strength = 5;
        agility = 1;
        stamina = 10;
        intelligence = 1;

    }

    public void initializeMage()
    {
        strength = 5;
        agility = 1;
        stamina = 10;
        intelligence = 5;

    }

    Player()
    {
        if (isWarrior)
            initializeWarrior();
        else if (isMage)
            initializeMage();

    }



}
