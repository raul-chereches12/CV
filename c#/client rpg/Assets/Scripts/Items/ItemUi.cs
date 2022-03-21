using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;
using UnityEngine.UI;

public class ItemUi : MonoBehaviour, IBeginDragHandler, IDragHandler, IEndDragHandler
{
    public Vector2 itemSelected;
    private RectTransform rectTransform;
    public bool dragEnded;

    public static bool addItem = false;
    public static bool deleteItem = false;

    private Vector2 positionOnInventory;
    private Image image;

    public static GameObject itemsGameObj;

    public static bool draggingItem = false;
    private void Start()
    {
        rectTransform = GetComponent<RectTransform>();
        image = GetComponent<Image>();
        itemsGameObj = gameObject.transform.parent.gameObject;
    }
    private void Update()
    {

        if (dragEnded == true)
        {
            if (InventoryUi.getHovering() == true)
            {//we dragged an item in the inventory


                rectTransform.position = positionOnInventory;
                

                //put element in the slot
                image.color = new Color32(255, 255, 255, 0);

                addItem = true;//tell that we have to add a new item

                //delete object
                Destroy(gameObject);

                dragEnded = false;
            }

        }



    }



    private float timeCount = 0.0f;

    public void OnBeginDrag(PointerEventData eventData)
    {
        draggingItem = true;
        rectTransform.position = new Vector2(eventData.position.x, eventData.position.y);

    }

    // Drag the selected item.
    public void OnDrag(PointerEventData data)
    {
        if (data.dragging)
        {
            // Object is being dragged.
            timeCount += Time.deltaTime;
            if (timeCount > 0.25f)
            {
                timeCount = 0.0f;
            }
        }
        rectTransform.position = new Vector2(data.position.x, data.position.y);
    }

    public void OnEndDrag(PointerEventData eventData)
    {

        //aici aflam spre care inventar ne am indreptat

       

        dragEnded = true;
        // aici o sa punem : daca nu este in inventar sa mearga inapoi la loc, sau daca nu are loc


        positionOnInventory = eventData.position;
       rectTransform.position = new Vector3(-1, -1);

    }

    public static bool isPointerOverItem()
    {

        return EventSystem.current.IsPointerOverGameObject();
    }

}