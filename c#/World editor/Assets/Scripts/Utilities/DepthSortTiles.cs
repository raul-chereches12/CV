using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DepthSortTiles : MonoBehaviour
{

    private SpriteRenderer spriteRenderer;
    private double IsometricRangePerYUnit = 0.25;
   
    // Start is called before the first frame update
    void Start()
    {
        //setting sorting order
        spriteRenderer = GetComponent<SpriteRenderer>();

        if (spriteRenderer)
        {
            spriteRenderer.sortingOrder = (int)(transform.position.y * -1 / IsometricRangePerYUnit - LoadingMap.image.height );//for aspect
            transform.position += new Vector3(0,0, (int)(transform.position.y * 1 / IsometricRangePerYUnit - LoadingMap.image.height ));//for collider
        }

    }

    // Update is called once per frame
    void Update()
    {
        

    }
}
