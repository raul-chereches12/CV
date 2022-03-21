using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Item : MonoBehaviour
{

    public static GameObject gameObj;
    private int id { get; set; }
    private string name { get; set; }
    private string type { get; set; }


    private void Start()
    {
        gameObj = gameObject;
    }
    Item(int id,string name,string type)
    {
        this.id = id;
        this.name = name;
        this.type = type;
            
    }


    public static Item loadItem(string type,string name)
    {
        int increment = 0;
        string[] lines = System.IO.File.ReadAllLines(@"G:\unity 3d\projects\client rpg\Assets\Items\"+type+"s.txt");
        /*
        foreach (string line in lines)
        {
            increment++;
            if (line == name)
            {
                return new Item(lines[increment-1]-'0',,);
            }
        }
        */


        return new Item((lines[0][0] - '0' )* 10+ lines[0][1]-'0', lines[1],lines[2]);

        return null;
    }

}
