using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.EventSystems;// Required when using Event data.
using System;

public class InventoryButton : MonoBehaviour , IPointerEnterHandler
{
    public bool emptySlot { set; get; }
    Button btn;
    // Start is called before the first frame update
    void Start()
    {
        emptySlot = true;
        btn = this.gameObject.GetComponent<Button>();
     btn.onClick.AddListener(onClick);

    }

    private void onClick()
    {
        /*
        if (gameObject.GetComponent<InventoryButton>().emptySlot == false)
        {
            //stergem din inventar
            InventoryUi.droppingSlot = new Vector2(btn.name[0] - '0', btn.name[1] - '0');
        }
        */

    }

    // Update is called once per frame
    void Update()
    {

    }

    public void OnPointerEnter(PointerEventData eventData)
    {

        if (ItemUi.draggingItem) { 
            InventoryUi.droppingSlot = new Vector2(btn.name[0] - '0', btn.name[1] - '0');
            ItemUi.draggingItem = false;
        }


        Debug.Log(btn.name);
      

    }

    public void setFull()
    {

        emptySlot = false;
       
    }

    public void setEmpty()
    {

        emptySlot = true;
    }
}
