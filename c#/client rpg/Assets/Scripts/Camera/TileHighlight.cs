using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TileHighlight : MonoBehaviour
{

    private GameObject lastGameobject=null;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update() {

        
            
            Vector3 mousePos = Camera.main.ScreenToWorldPoint(Input.mousePosition);
            Vector2 mousePos2D = new Vector2(mousePos.x, mousePos.y);

            RaycastHit2D hit = Physics2D.Raycast(mousePos2D, Vector2.zero);
            if (hit.collider != null)
            {
                if (lastGameobject != null)
                    lastGameobject.GetComponent<SpriteRenderer>().color = Color.white;
                // Destroy(hit.collider.gameObject, 0f);
               lastGameobject = hit.collider.gameObject;
                lastGameobject.GetComponent<SpriteRenderer>().color = new Color32(150,150,150,255);
                
                
            }
        


        
    }


    




}
