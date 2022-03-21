using System.Collections;
using System.Collections.Generic;
using UnityEngine;



public class DepthSort : MonoBehaviour
{
    private Renderer renderer;
    private double IsometricRangePerYUnit = 0.5;
    private int imageHeight = 56;
    // Start is called before the first frame update
    void Start()
    {
        renderer = GetComponent<SpriteRenderer>();

       
    }

    // Update is called once per frame
    void Update()
    {

        if (renderer)
        {
            renderer.sortingOrder = -(int)(transform.position.y * 1 / IsometricRangePerYUnit - imageHeight / 2 );
           
        }
    }
}
