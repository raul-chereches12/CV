using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DepthSortTrees : MonoBehaviour
{

    private SpriteRenderer spriteRenderer;
    private double IsometricRangePerYUnit = 0.25;
    
    // Start is called before the first frame update
    void Start()
    {
        spriteRenderer = GetComponent<SpriteRenderer>();

        if (spriteRenderer)
        {
           spriteRenderer.sortingOrder = (int)(transform.position.y * -1 / IsometricRangePerYUnit - LoadingMap.image.height);//for aspect ==sorting
          // transform.position += new Vector3(0, 0, -113);//for collider ==z 

        }

    }

    // Update is called once per frame
    void Update()
    {
        

    }
}
