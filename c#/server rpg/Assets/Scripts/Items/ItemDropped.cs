using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ItemDropped : MonoBehaviour
{

    public static bool cursorOnItem = false;
    public Image image;
    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

        

        Vector3 mousePos = Camera.main.ScreenToWorldPoint(Input.mousePosition);
        Vector2 mousePos2D = new Vector2(mousePos.x, mousePos.y);

        RaycastHit2D hit = Physics2D.Raycast(mousePos2D, Vector2.zero);

        if (hit.collider != null)
        {
            InfoUi.getInfo(hit.collider.gameObject);

            if (Input.GetMouseButtonDown(0)&&(hit.collider.gameObject==gameObject))
            {
                Destroy(hit.collider.gameObject);
                //if invetory not full
                //add item
                Transform button_transform = Inventory.firstEmptySlot();


                     button_transform.GetComponent<InventoryButton>().setFull();//occupy the slot
                                                                                 //draw the slot
               
                //Instantiate(image, gameObj_transform.position, Quaternion.identity).transform.SetParent(ItemUi.itemsGameObj.transform,false);

                Image imgSpawned = Instantiate(image) as Image;

                //set the parent
                imgSpawned.transform.SetParent(Item.gameObj.transform);
                //set the position of the button
                imgSpawned.transform.position = button_transform.position;

                //add the drag-drop script
                imgSpawned.gameObject.AddComponent<ItemUi>();

            }

        }


    }


}
