using System.Collections;
using System.Collections.Generic;
using System.Threading;
using UnityEngine;
using UnityEngine.EventSystems;
public class PlayerMovement : MonoBehaviour
{
    // Start is called before the first frame update

    public float speed;
    private Vector3 change;

    private Rigidbody2D myRigidbody;


    private Vector2 mousePos;
    public bool isMoving = false;

    
    Stack<Tile> path = new Stack<Tile>();

    private Vector2 checkPoint=new Vector2(float.PositiveInfinity,float.PositiveInfinity);
    private GameObject gameObjectMouse,gameObjectPlayer;

    private int mapSize=56;









    void Start()
    {

        myRigidbody = GetComponent<Rigidbody2D>();
        Debug.Log("Resolution: "+ Screen.width+"x"+ Screen.height);
       

    }

    // Update is called once per frame
    void Update()
    {
        // Debug.Log("PosX: " + transform.position.x + " PosY: " + transform.position.y);
        
        if (Input.GetButtonDown("Fire1")&&(!InventoryUi.isPointerOverInventory()))//IS OVER ALL!!!(not just invetory)
        {
           
            mousePos = Camera.main.ScreenToWorldPoint(Input.mousePosition);

            RaycastHit2D hit = Physics2D.Raycast(mousePos, Vector2.zero);
            if (hit.collider != null)
            {
                gameObjectMouse = hit.collider.gameObject;
            }

            hit = Physics2D.Raycast(transform.position, Vector2.zero);
            if (hit.collider != null)
            {
                gameObjectPlayer = hit.collider.gameObject;
            }


             path = A_Star_PathFinding.findPath(convertScreenToMatrix(gameObjectPlayer.transform.position), convertScreenToMatrix(gameObjectMouse.transform.position));
           // Debug.Log(path);
            path.Pop();//pop our position
            
           isMoving = true;

            checkPoint = path.Pop().position;
            
            change = (convertMatrixToScreen(checkPoint)-(Vector2)transform.position ).normalized;

           
        }
        
        //0.25 cat sa se apropie de checkpoint
       
            if (Vector2.Distance(transform.position, convertMatrixToScreen(checkPoint)) < 0.125)
        {
            //next checkpoint

            checkPoint = path.Pop().position;
            change = (convertMatrixToScreen(checkPoint) - (Vector2)transform.position).normalized;

            if (path.Count == 0)
            {
                isMoving = false;
            }

        }
       // Debug.Log("distance to next checkpoint: "+Vector2.Distance(transform.position, convertMatrixToScreen(checkPoint)));
        
            if (isMoving==true)
        {
            
            MoveCharacter();
            
        }

        
          

    }

    public void FixedUpdate()
    {
        //change = new Vector3(1, 0, 0);
       // MoveCharacter();
    }





    void MoveCharacter()

    {
        
        myRigidbody.MovePosition(  transform.position + change * speed * Time.fixedDeltaTime  ); ;
        
        
       // transform.position = Vector2.Lerp(transform.position, convertMatrixToScreen(checkPoint) , Time.deltaTime*speed);

    }

    public Vector2 convertScreenToMatrix(Vector2 positionOnScreen)
    {

        //return i,j
        return new Vector2(positionOnScreen.x-2*positionOnScreen.y+mapSize/2, positionOnScreen.x + 2 * positionOnScreen.y+mapSize/2);
    }

    public Vector2 convertMatrixToScreen(Vector2 positionOnMatrix)
    {

        //return i,j
        return new Vector2((float)0.5 * (positionOnMatrix.x + positionOnMatrix.y) - mapSize / 2, (float)0.25 * (positionOnMatrix.y - positionOnMatrix.x));
    }


    


}

