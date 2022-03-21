using System.Collections;
using System.Collections.Generic;
using UnityEngine;


public class CameraMovement : MonoBehaviour
{

 
    Vector2 mousePos;
    public int CameraSpeed = 5;

    public static bool lockCamera = false;

    private int zPosition;

    public float zoomLevel=5;
   

    // Start is called before the first frame update
    void Start()
    {
        zPosition = -1*(LoadingMap.image.height * 2) - 2;//one unit past player
        transform.position = new Vector3(transform.position.x, transform.position.y, zPosition);
        //playerScript = thePlayer.GetComponent<PlayerMovement>();

        //zoom a little bit

       Camera.main.orthographicSize = zoomLevel;

    }

    // Update is called once per frame
    void Update()
    {



        // Debug.Log(transform.position.x + " --- " + transform.position.y+", "+ thePlayer.transform.position.x + " --- " + thePlayer.transform.position.y);

        if (lockCamera == false) {  
        Vector2 pos = Input.mousePosition;
        if ((pos.x < 0.0) || (pos.x > Screen.width) || (pos.y < 0.0) || (pos.y > Screen.height))
        {
            //am iesit din "ecran" si trebuie sa indreptam camera in directia aceea

            transform.position += (Camera.main.ScreenToWorldPoint(pos)-transform.position).normalized*Time.deltaTime*CameraSpeed;

           // Debug.Log("atingem");

            }
        }

        //scroll zoom
        /*

        float scroll = Input.GetAxis("Mouse ScrollWheel");
        if (scroll != 0.0f)
        {
            targetOrtho -= scroll * zoomSpeed;
            targetOrtho = Mathf.Clamp(targetOrtho, minOrtho, maxOrtho);
        }

        Camera.main.orthographicSize = Mathf.MoveTowards(Camera.main.orthographicSize, targetOrtho, smoothSpeed * Time.deltaTime);
        */


    }



    public static float RoundToNearestPixel(float unityUnits)
    {
        int pixelToUnits = 64;
        float valueInPixels = unityUnits * pixelToUnits;
        valueInPixels = Mathf.Round(valueInPixels);
        float roundedUnityUnits = valueInPixels * (1 / pixelToUnits);
        return roundedUnityUnits;
    }

    

}
