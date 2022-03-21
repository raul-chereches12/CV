using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;
using UnityEngine.UI;

public class InventoryUi : MonoBehaviour, IBeginDragHandler, IDragHandler, IEndDragHandler
{
    public static Vector2 droppingSlot;


    private RectTransform rectTransform;
    private static bool hovering=false;
    private EventTrigger trigger;

    public static int length = 4;
    public static int width = 4;

    public static GameObject activeInventory;

    public Image image;
    
   

    private Vector2 cornerBottomLeft, cornerTopRight;


    public static bool isPointerOverInventories=false;
    private bool inventoryHasMoved;
    





    private void Start()
    {
        rectTransform = GetComponent<RectTransform>();
        inventoryHasMoved = true;
        initializeTrigger();

        
    }
    private void Update()
    {
        

        if (ItemUi.addItem)
        {
            Transform gameObj_transform = this.gameObject.transform.GetChild((int)droppingSlot.x * width + (int)droppingSlot.y );//button`s transform

            gameObj_transform.GetComponent<InventoryButton>().setFull();//occupy the slot
            //draw the slot
            Debug.Log("CANVAS : " + ItemUi.itemsGameObj.name);
            //Instantiate(image, gameObj_transform.position, Quaternion.identity).transform.SetParent(ItemUi.itemsGameObj.transform,false);
         
            Image imgSpawned = Instantiate(image) as Image;

            imgSpawned.transform.SetParent(ItemUi.itemsGameObj.transform);
            imgSpawned.transform.position = gameObj_transform.position;
            imgSpawned.gameObject.AddComponent<ItemUi>();
          

            ItemUi.addItem = false;
        }

       
        
       
    }

    private Vector3 position;
        private float timeCount = 0.0f;

        public void OnBeginDrag(PointerEventData eventData)
        {
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
            rectTransform.position= new Vector2(data.position.x,data.position.y);
        }

        public void OnEndDrag(PointerEventData eventData)
        {
        rectTransform.position = new Vector3(eventData.position.x, eventData.position.y);
        inventoryHasMoved = true;
        }

    public static bool isPointerOverInventory()
    {
       
        return EventSystem.current.IsPointerOverGameObject();
    }

    public void EnterUI()
    {
        hovering = true;
    }
    public void ExitUI()
    {
        hovering = false;
    }

    public void initializeTrigger()
    {

        trigger = GetComponent<EventTrigger>();
        if (trigger != null)
        {
            EventTrigger.Entry enterUIEntry = new EventTrigger.Entry();
            // Pointer Enter
            enterUIEntry.eventID = EventTriggerType.PointerEnter;
            enterUIEntry.callback.AddListener((eventData) => { EnterUI(); });
            trigger.triggers.Add(enterUIEntry);

            //Pointer Exit
            EventTrigger.Entry exitUIEntry = new EventTrigger.Entry();
            exitUIEntry.eventID = EventTriggerType.PointerExit;
            exitUIEntry.callback.AddListener((eventData) => { ExitUI(); });
            trigger.triggers.Add(exitUIEntry);
        }
    }

    public static bool getHovering()
    {

        return hovering;
    }

   

   

    public bool pointerOnInventory()
    {
         

        if (inventoryHasMoved) { 
            //calculate new coordinates
        cornerBottomLeft = new Vector2(rectTransform.position.x - rectTransform.sizeDelta.x / 2, rectTransform.position.y - rectTransform.sizeDelta.y / 2);
        cornerTopRight = new Vector2(rectTransform.position.x + rectTransform.sizeDelta.x / 2, rectTransform.position.y + rectTransform.sizeDelta.y / 2);
            inventoryHasMoved = false;
    }
       
         
        Vector2 mousePos = Input.mousePosition;

        if ((mousePos.x >= cornerBottomLeft.x) && (mousePos.y >= cornerBottomLeft.y) && (mousePos.x <= cornerTopRight.x) && (mousePos.y <= cornerTopRight.y)) {
            return true;
        }
        else
        return false;
         
    }
    

    public GameObject getInstance()
    {
        return this.gameObject;
    }

    
    
    public static void setDroppingSlot(Vector2 vec)
    {
        droppingSlot = vec;

    }

    

}