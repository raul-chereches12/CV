using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PathFindingAlgorithm : MonoBehaviour
{

    //private List<Vector2> path = new List<Vector2>();

    private List< Vector2> possibleDirections = new List<Vector2>();

    private int[,] collisionMatrix=new int[56,56];

    private Vector2 Source = new Vector2(0, 0);
    private Vector2 Destination = new Vector2(54, 5);


    private bool active = true;

    static int maxNrOfTimes = 0;




    private Vector2 convertedToMap = new Vector2();

    // Start is called before the first frame update
    void Start()
    {

        

        //assign source, desination position
        
        myPriorityQueueClass.initialize();
        initializeRequirements();


        findPathWay(Source);

        
        
    }

    // Update is called once per frame
    void Update()
    {

        


    }


    public void findPathWay(Vector2 nextCell)
    {
        Debug.Log("------------------------");

        maxNrOfTimes++;
        if (maxNrOfTimes == 500)
            return;

        //desen
        convertedToMap.x = (float)0.5 * (nextCell.x + nextCell.y) - 56 / 2;
        convertedToMap.y = (float)0.25 * (nextCell.x - nextCell.y);

        RaycastHit2D hit = Physics2D.Raycast(new Vector2(convertedToMap.x + (float)0.125, convertedToMap.y), convertedToMap);

        GameObject lastGameobject;
        if (hit.collider != null)
        {
           // Debug.Log("am lovit");
            lastGameobject = hit.collider.gameObject;
            lastGameobject.GetComponent<SpriteRenderer>().color = new Color32(150, 150, 150, 255);

        }


        List<CellInfo> forSorting = new List<CellInfo>();




        if (nextCell == Destination)
            active = false;

        if (active == false)
            return;


        // path.Add(nextCell);//??? il luamm in considerare ca si drum
        // List<Vector2> currentPath = path ;//facem o copie a drumului


        collisionMatrix[(int)nextCell.x, (int)nextCell.y] = 3;//luat in considerare

        //calculate distances around, and choose the next temp cell
        //8 around;
        if (myPriorityQueueClass.length() != 0)
        {
            
            myPriorityQueueClass.Pop();//pop the first element(aka nextCell) and prepare for possible coming 8

        }


        
        
     
        //where we add new possible cells
        for (int i = 0; i<8; i++)
        {
            int x = (int)(nextCell.x + possibleDirections[i].x);
            int y = (int)(nextCell.y + possibleDirections[i].y);
            if ((x>=0)&& (y>=0))
           if ((collisionMatrix[x,y]!=1)&&(collisionMatrix[x, y] != 3))
            {
                    //3-deja adaugat
                    //0=liber, are rost sa calculam
                    collisionMatrix[x, y] = 3;
                forSorting.Add(new CellInfo(new Vector2(x, y), Vector2.Distance(nextCell + possibleDirections[i], Destination)));
                   
            }
            

        }

        //sortam forSorting

        forSorting.Sort((x, y) => x.distance().CompareTo(y.distance()));


        //where we add new sorted elements

        myPriorityQueueClass.Merge(forSorting);


        forSorting = null;//free memory




        //paint current cell


       
        
        findPathWay(myPriorityQueueClass.getFirst().position());
   
        
        

        
        
    }

    public void initializeRequirements()
    {
        /*
        collisionMatrix = new int[,] {
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 0, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
            { 0, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
            { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 1, 1, 0, 0, 0, 1, 0, 0, 1 }
    };
        */
         
        collisionMatrix=LoadingBitmap.getCollisionMatrix();
        
        possibleDirections.Add(new Vector2(-1, 0));//north
        possibleDirections.Add(new Vector2(+1, 0));//south
        possibleDirections.Add(new Vector2(0, 1));//east
        possibleDirections.Add(new Vector2(0, -1));//west

        possibleDirections.Add(new Vector2(-1, 1));//north-east
        possibleDirections.Add(new Vector2(-1, -1));//north-west
        possibleDirections.Add(new Vector2(+1, 1));//south-east
        possibleDirections.Add(new Vector2(+1, -1));//south-west


    }

  
}
class CellInfo
{

    private Vector2 Position;
    private float Distance;


    CellInfo()
    {

    }
public CellInfo(Vector2 position,float distance)
    {
        Position = position;
        Distance = distance;

    }
    public Vector2 position()
    {
        return Position;
    }

    public float distance()
    {
        return Distance;
    }

    public static void swap(CellInfo nr1,CellInfo nr2)
    {
        CellInfo aux;

        aux = nr1;
        nr1 = nr2;
        nr1 = aux;


    }

    public void drawThePath()
    {




    }
   



}

class myPriorityQueueClass
{

    static LinkedList<CellInfo> priorityQueue;
    public static int nr_elements=0;

   
    public static void initialize()
    {
        priorityQueue = new LinkedList<CellInfo>();
       
        priorityQueue.AddFirst(new CellInfo(new Vector2(float.MaxValue,float.MaxValue),float.PositiveInfinity));
    }

    public static CellInfo getFirst()
    {
        return priorityQueue.First.Value;

    }
    public static void Push(CellInfo aux)
    {
        
        priorityQueue.AddFirst(aux);

    }

    public static void Pop()
    {
        nr_elements--;
        priorityQueue.RemoveFirst();
    }
    public static int length()
    {

        return nr_elements;
    }

    public static void Merge(List<CellInfo> list)
    {
        var start = priorityQueue.First;

        list.ForEach(delegate (CellInfo info)
        {

            bool found = false;
            while ((start != null) && (found == false))
            {
                if (info.distance() <= start.Value.distance())
                {
                    nr_elements++;
                    priorityQueue.AddBefore(start, info);
                    start = start.Previous;
                    found = true;//inserted, next one

                }
                else
                    start = start.Next;
            }
        });
        myPriorityQueueClass.displayPriorityQueue();
        //move to next cell
        Debug.Log("next is :" + myPriorityQueueClass.getFirst().position() + " nr of elements: " + myPriorityQueueClass.nr_elements);

        while (nr_elements > 5) {
            nr_elements--;
        Debug.Log("removed: " + priorityQueue.Last.Value.distance());
        priorityQueue.RemoveLast();
    }
        

    }

    public static void displayPriorityQueue()
    {


        var start = priorityQueue.First;


        while ((start != null))
        {
            Debug.Log(start.Value.position()+ " ------- "+ start.Value.distance());
                start = start.Next;
        }
    }



}