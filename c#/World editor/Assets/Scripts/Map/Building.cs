using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Building : MonoBehaviour
{

    private Vector3 tile_up = new Vector3(0, (float)0.5,0);//one up

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {


        if (Input.GetMouseButtonDown(0) && (!DropdownBlocks.isPointerOverInventory()))
        {
            
            Instantiate(DropdownBlocks.getCurrentBuildingBlock(), TileHighlight.getLastGameObject().transform.position+tile_up, Quaternion.identity);
            Destroy(TileHighlight.getLastGameObject());

        }
            

    }
}
