using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TilesRenderer : MonoBehaviour
{

    //we represent the rendering zone as a rectangle so we have length and width

    //  ----------------
    //  |              |
    //  |              |
    //  |              |
    //  ----------------

    //in this case : length 16 AND width 3

    private int Length=3;
    private int Width=3;
    private int frame = 0;
   

    private 
    



    // Start is called before the first frame update
    void Start()
    {

        //for (int i = 0; i < 19; i++)
        //    for (int j = 0; j < 19; j++)
        //        LoadingBitmap.chunksArray[i, j].InstantiateChunk();


    }

    // Update is called once per frame
    void Update()
    {
        frame++;

        if (frame % 30 == 0)
        {
            
            ScanAround();

            frame = 0;
        }
        
    }


    private void ScanAround()
    {



        //scan and update the INSTANTIATE queue and DESTORY queue

        //here we convert world coordinates to chunk matrix

        int starting_i = (int)(transform.position.x - transform.parent.position.x - 2 * transform.position.y - transform.parent.position.y + LoadingMap.image.height / 2) / LoadingMap.chunkSize;
        int starting_j = (int)(transform.position.x - transform.parent.position.x + 2 * transform.position.y - transform.parent.position.y + LoadingMap.image.height / 2 )/ LoadingMap.chunkSize;

       
        
        //coordinates in chunk array
        starting_i -= Length / 2;
        starting_i -= Width / 2;

        for (int i=starting_i;i< starting_i+Length; i++)
            for(int j=starting_j;j< starting_j+Width; j++)
            {
                
                
                if (!LoadingMap.chunksArray[i, j].active)
                {
                    LoadingMap.chunksArray[i, j].active = true;
                    LoadingMap.chunksArray[i, j].InstantiateChunk();
                    //Debug.Log("Looking at chunks from : [" + i + "] , [" + j + "]");

                }
                
            }

       // Debug.Log("--------------------------------------------------------------->");
        

        /*
        if (!LoadingBitmap.chunksArray[starting_i, starting_j].active)
        {
            LoadingBitmap.chunksArray[starting_i, starting_j].active = true;
            LoadingBitmap.chunksArray[starting_i, starting_j].InstantiateChunk();
           Debug.Log("Looking at chunks from :");

        }
        */


    }
        




    }

