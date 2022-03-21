using System.Collections;
using System.Collections.Generic;
using UnityEngine;


public class CameraMovement : MonoBehaviour
{

    private static int pixelToUnits = 64;
    Vector2 mousePos;
    public int CameraSpeed = 5;
    private PlayerMovement playerScript;
    private bool lockCamera = false;
    private GameObject thePlayer;

    public float zoomLevel=5;
   

    // Start is called before the first frame update
    void Start()
    {

        thePlayer = GameObject.Find("vampire");
        playerScript = thePlayer.GetComponent<PlayerMovement>();

        //zoom a little bit

       Camera.main.orthographicSize = zoomLevel;

    }

    // Update is called once per frame
    void Update()
    {


       
        // Debug.Log(transform.position.x + " --- " + transform.position.y+", "+ thePlayer.transform.position.x + " --- " + thePlayer.transform.position.y);

        Vector2 pos = Input.mousePosition;



        if (Input.GetButtonDown("Fire1"))
        {
            
            lockCamera = true;//aici incercam sa centram cand apasam click
            //in cazul in care este centrat se va verifica distanta si daca este egala cu 20 , vom stii ca este centrat
        }

        if ((pos.x < 0.0) || (pos.x > Screen.width) || (pos.y < 0.0) || (pos.y > Screen.height))
        {
            //am iesit din "ecran" si trebuie sa indreptam camera in directia aceea

            transform.position += (Camera.main.ScreenToWorldPoint(pos)-transform.position).normalized*Time.deltaTime*CameraSpeed;

            lockCamera = false;


            }
            
        if (lockCamera == true)
        {

    
            transform.position = Vector2.Lerp(transform.position, thePlayer.transform.position, Time.deltaTime * 3);
            transform.position = new Vector3(transform.position.x, transform.position.y, -10);
        }

        
        
        if (Vector3.Distance(transform.position, thePlayer.transform.position) == 20)
        {
            lockCamera = false; //a fost adus in pozitia playerului
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
        float valueInPixels = unityUnits * pixelToUnits;
        valueInPixels = Mathf.Round(valueInPixels);
        float roundedUnityUnits = valueInPixels * (1 / pixelToUnits);
        return roundedUnityUnits;
    }

    public void centerCamera()
    {


    }

}
