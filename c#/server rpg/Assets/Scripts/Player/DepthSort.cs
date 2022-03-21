using System.Collections;
using System.Collections.Generic;
using UnityEngine;



public class DepthSort : MonoBehaviour
{
    private Renderer renderer;
    private double IsometricRangePerYUnit = 0.25;
   
    // Start is called before the first frame update
    void Start()
    {
        renderer = GetComponent<SpriteRenderer>();

        transform.position += new Vector3(0, 0, -(LoadingBitmap.image.height * 2) - 1);//for 56=> -(56*2-1)

        //-114---->camera
        //-113----> trees and players
        //0 -112-----> terrain
        //this is for 56

       
    }

    // Update is called once per frame
    void Update()
    {

        if (renderer)
        {
             renderer.sortingOrder = (int)(transform.position.y * -1 / IsometricRangePerYUnit - LoadingBitmap.image.height);//for aspect
            
        }
    }
}
