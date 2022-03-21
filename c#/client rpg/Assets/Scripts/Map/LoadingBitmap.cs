using UnityEngine;



public class LoadingBitmap : MonoBehaviour
{

    private static int[,] collisionArray;

    private Color grass;
    private Color cobblestone;
    private Color snow;
    private Color tree;

    public GameObject grass_GameObj;
    public GameObject cobble_isometric_GameObj;
    public GameObject grass_snow_GameObj;
    public GameObject tree_grass_isometric_GameObj;
    public GameObject grass_isometric_GameObj;


    private double IsometricRangePerYUnit = 0.5;




    private Texture2D image;

    // Start is called before the first frame update
    void Start()
    {
        initializeColors();

        //load image
        image = Resources.Load<Texture2D>("grass_cobble_snow");
        

        //cream matricea de coliziuni dupa bitmap-ul pozei
        collisionArray = new int[image.height, image.width];



        for (int i = 0; i < image.height; i++)
            for (int j = 0; j < image.width; j++)
            {
                Color32 pixel = image.GetPixel(i, j);

                

                build(pixel, i, j);//building the map

            }

        

    }

    // Update is called once per frame
    void Update()
    {




    }

    public void build(Color32 color, int i, int j)
    {
        //Debug.Log("grass snow: " + color.r + " " + color.g + " " + color.b);

        //where we build the map and collision matrix
        if ((color.r==grass.r)&&(color.g == grass.g) &&(color.b == grass.b))
        {
            Instantiate(grass_isometric_GameObj, new Vector3(  (float)0.5*(i+j)- image.height / 2, (float)0.25*(j-i), 0), Quaternion.identity);
            collisionArray[i, j] = 0;//liber
           
        }
        else if ((color.r == cobblestone.r) && (color.g == cobblestone.g) && (color.b == cobblestone.b))
        {

            Instantiate(cobble_isometric_GameObj, new Vector3((float)0.5 * (i + j) - image.height / 2, (float)0.25 * (j - i), 0), Quaternion.identity);
            collisionArray[i, j] = 1;//blocat
            
        }
        else if ((color.r == snow.r) && (color.g == snow.g) && (color.b == snow.b))
        {
            
            Instantiate(grass_snow_GameObj, new Vector3((float)0.5 * (i + j) - image.height/2, (float)0.25 * (j - i), 0), Quaternion.identity);
            collisionArray[i, j] = 0;//liber

        }
        else
        {
            Instantiate(tree_grass_isometric_GameObj, new Vector3((float)0.5 * (i + j) - image.height / 2, (float)0.25 * (j - i), 0), Quaternion.identity);
            collisionArray[i, j] = 1;//liber
            


        }



       
    }

    public void initializeColors()
    {

        grass = new Color(34 ,  177 ,  76 );
        cobblestone = new Color(127,  127 , 127);
        snow = new Color(255, 255, 255);
        tree = new Color(255, 242, 0);



    }

    public static int[,] getCollisionMatrix()
    {
        return collisionArray;
    }
    public static void showArray()
    {



        for(int i=0;i<56;i++)
            for(int j=0;j<56;j++)
            {
                Debug.Log(collisionArray[i,j]);
            }
    }

}
