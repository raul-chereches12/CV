using System;
using System.Collections.Generic;
using UnityEngine;



public class LoadingMap : MonoBehaviour
{

    private static int[,] collisionArray;
    public static Chunk[,] chunksArray;


    private Color grass;
    private Color cobblestone;
    private Color snow;
    private Color tree;
    private Color empty;

    public GameObject cobble_isometric_GameObj;
    public GameObject tree_grass_isometric_GameObj;
    public GameObject grass_isometric_GameObj;
    public GameObject empty_isometric_GameObj;


    public static GameObject gameObjectAttachedTo;

    private Vector2 tile_down = new Vector3((float)0.5, -(float)0.25);//one down
    private Vector2 tile_right = new Vector3((float)0.5, (float)0.25);//one right



    public static int chunkSize = 3;//3 tiles

    public class Tile
    {


        public int sortingOrder { set; get; }
        public GameObject Type { set; get; }
        public Vector3 position { set; get; }


        public Tile(Vector3 position, GameObject type)
        {
            this.position = position;
            position.z = (int)(position.y * 1 / 0.25 - image.height);//for collider

            sortingOrder = (int)(position.y * -1 / 0.25 - image.height);//for aspect

            this.Type = type;
        }



    }


    //a 2x2 chunk
    public class Chunk
    {

        Stack<Tile> tilesStack;
        GameObject chunk;
        public bool active = false;


        public Chunk()
        {

            tilesStack = new Stack<Tile>();

        }

        //add
        public void addTile(Tile tile)
        {
            tilesStack.Push(tile);
        }
        //pop
        public Tile popTile()
        {
            return tilesStack.Pop();
        }


        public void InstantiateChunk()
        {
            //chunk = new GameObject("Chunk");
            //chunk.transform.parent = gameObjectAttachedTo.transform;//to ensure that chunk is placed properly

            foreach (Tile tile in tilesStack)
            {
                Instantiate(tile.Type, tile.position, Quaternion.identity);
            }

        }

        public void DestroyChunk()
        {

            foreach (Tile tile in tilesStack)
            {
                Destroy(tile.Type);

            }

        }


    }









    public static Texture2D image;

    // Start is called before the first frame update
    void Start()
    {
        initializeColors();

        gameObjectAttachedTo = gameObject;

        //load image
        image = Resources.Load<Texture2D>("empty_map");


        if ((image.height % chunkSize != 0) || (image.width % chunkSize != 0))
        {
            throw new Exception("Incorrect Map size !!! ");

        }


        //cream matricea de coliziuni dupa bitmap-ul pozei
        collisionArray = new int[image.height, image.width];



        ////////////////////////////////////////////////////////////////////////////
        //we have to ensure that map size is multiple of chunk size!!!!!!!!!!!     /
        ////////////////////////////////////////////////////////////////////////////

        chunksArray = new Chunk[image.height / chunkSize, image.width / chunkSize];


        for (int i = 0; i < image.height; i += chunkSize)
            for (int j = 0; j < image.width; j += chunkSize)
            {

                loadingChunk(i, j);//loading chunk into memory


            }


        /*
        for (int i = 0; i < image.height; i++)
            for (int j = 0; j < image.width; j++)
            {
                Color32 pixel = image.GetPixel(i, j);



                build(pixel, i, j);//building the map

            }
        */


        //show chunks

        //  foreach (Chunk c in chunksArray)
        // {
        //     Debug.Log(c);
        // }
        //



    }

    // Update is called once per frame
    void Update()
    {




    }

    public void build(Color32 color, int i, int j)
    {
        //Debug.Log("grass snow: " + color.r + " " + color.g + " " + color.b);
        GameObject newTile;
        //where we build the map and collision matrix
        if ((color.r == grass.r) && (color.g == grass.g) && (color.b == grass.b))
        {
            newTile = Instantiate(grass_isometric_GameObj, new Vector3((float)0.5 * (i + j) - image.height / 2, (float)0.25 * (j - i), 0), Quaternion.identity);
            collisionArray[i, j] = 0;//liber

        }
        else if ((color.r == cobblestone.r) && (color.g == cobblestone.g) && (color.b == cobblestone.b))
        {

            newTile = Instantiate(cobble_isometric_GameObj, new Vector3((float)0.5 * (i + j) - image.height / 2, (float)0.25 * (j - i), 0), Quaternion.identity);
            collisionArray[i, j] = 1;//blocat

        }
        else
        {
            newTile = Instantiate(tree_grass_isometric_GameObj, new Vector3((float)0.5 * (i + j) - image.height / 2, (float)0.25 * (j - i), 0), Quaternion.identity);
            collisionArray[i, j] = 1;//blocat



        }


        newTile.transform.parent = gameObject.transform;

    }

    private void loadingChunk(int starting_i, int starting_j)
    {
        //chunk by chunk
        //new chunk
        Chunk newChunk = new Chunk();

        Vector2 first_position = new Vector3((float)0.5 * (starting_i + starting_j) - image.height / 2, (float)0.25 * (starting_j - starting_i), 0);
        Vector2 first_collumn;


        for (int i = starting_i; i < chunkSize + starting_i; i++)//if 56 ----> 56 57 28 (3 tiles)
        {
            first_collumn = first_position;
            for (int j = starting_j; j < chunkSize + starting_j; j++)
            {


                Color32 color = image.GetPixel(i, j);
                GameObject gameObj;

                if ((color.r == grass.r) && (color.g == grass.g) && (color.b == grass.b))
                    gameObj = grass_isometric_GameObj;
                else if ((color.r == cobblestone.r) && (color.g == cobblestone.g) && (color.b == cobblestone.b))
                    gameObj = cobble_isometric_GameObj;
                else if ((color.r == tree.r) && (color.g == tree.g) && (color.b == tree.b))
                    gameObj = tree_grass_isometric_GameObj;
                else
                    gameObj = empty_isometric_GameObj;

                newChunk.addTile(new Tile(first_position, gameObj));

                first_position += tile_right;//one right

            }

            first_position = first_collumn + tile_down;//reset collumn + one tile down


        }


        //adding chunk;
        chunksArray[starting_i / chunkSize, starting_j / chunkSize] = newChunk;

    }

    public void initializeColors()
    {

        grass = new Color(34, 177, 76);
        cobblestone = new Color(127, 127, 127);
        snow = new Color(255, 255, 255);
        tree = new Color(255, 242, 0);
        empty = new Color(255, 255, 255);

    }

    public static int[,] getCollisionMatrix()
    {
        return collisionArray;
    }
    public static void showArray()
    {



        for (int i = 0; i < image.height; i++)
            for (int j = 0; j < image.width; j++)
            {
                Debug.Log(collisionArray[i, j]);
            }
    }

}
