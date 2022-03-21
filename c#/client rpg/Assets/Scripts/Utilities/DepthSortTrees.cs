using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DepthSortTrees : MonoBehaviour
{

    private SpriteRenderer spriteRenderer;
    private double IsometricRangePerYUnit = 0.5;
    private int imageHeight = 56;
    // Start is called before the first frame update
    void Start()
    {
        spriteRenderer = GetComponent<SpriteRenderer>();

        if (spriteRenderer)  
        spriteRenderer.sortingOrder = -(int)(transform.position.y * 1 / IsometricRangePerYUnit - imageHeight / 2 );
            
       
    }

    // Update is called once per frame
    void Update()
    {
        

    }
}
