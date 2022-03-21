using System.Collections;
using System.Collections.Generic;
using System.IO;
using UnityEngine;

public class LoadingMap : MonoBehaviour
{
    public int height;
    public int width;
    private char[,] gameMap = new char[10, 10];


   
    public GameObject grass;
    public GameObject rock;


    // Start is called before the first frame update
    void Start()
    {
        createMatrix();
       createMap();

        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    void createMatrix()
    {




        System.IO.StreamReader file =
    new System.IO.StreamReader(@"Assets\Maps\map1.txt");

        string input = file.ReadToEnd();

        int i = 0, j = 0;
        
        foreach (var row in input.Split('\n'))
        {
            j = 0;
            foreach (var col in row)
            {
                if ((col >= 'a') && (col <= 'z'))
                {
                    gameMap[i, j] = col;
                    j++;
                }
            }
            i++;
        }

        file.Close();





     //   for (i = 0; i < height; i++) {
     //    for (j = 0; j < width; j++)
     //         Debug.Log(gameMap[i, j]);
     //    Debug.Log("\n");
   // }

    }

    void createMap()
    {


        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
            {
                switch (gameMap[i, j]) {
                    case 'g':
                Instantiate(grass, new Vector3(i - height / 2, j - width / 2, 0), Quaternion.identity);
                        break;

                    case 'r':
                        Instantiate(rock, new Vector3(i - height / 2, j - width / 2, 0), Quaternion.identity);
                        break;

                }

        }
       }
        


       // Instantiate(grass, new Vector3(0, 0, 0), Quaternion.identity);
    }


}
