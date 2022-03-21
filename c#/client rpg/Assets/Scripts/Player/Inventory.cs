using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Inventory : MonoBehaviour
{

    private static int emptySlots;
    public static GameObject parent;
    

   


    // Start is called before the first frame update
    void Start()
    {
        parent = gameObject;
        //loading items
       
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void countEmptySpaces()
    {
        emptySlots = 0;
        int i = 0;
      for(i = 0; i < 16; i++)
        {
            if (this.gameObject.transform.GetChild(i).gameObject.GetComponent<InventoryButton>().emptySlot == true)
            {
                emptySlots++;
            }
        }

    }

    public static Transform firstEmptySlot()
    {
        bool flag=false;
        int i;
        for (i = 0; i < 16; i++)
        {
            if (parent.transform.GetChild(0).GetChild(i).gameObject.GetComponent<InventoryButton>().emptySlot == true)
            {
                flag = true;
                break;
            }
        }

        if (flag == true)
            return parent.transform.GetChild(0).GetChild(i).gameObject.transform;
        else
            return null;


    }

    public int getEmptySlots()
    {

        return emptySlots;
    }


}
