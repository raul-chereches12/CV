using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PlayerName : MonoBehaviour
{

    private RectTransform rectTransform;
    // Start is called before the first frame update
    void Start()
    {
        rectTransform=GetComponent<RectTransform>();

        gameObject.GetComponent<Text>().text = transform.parent.parent.GetComponent<Player>().name;//set the text name
    }

    // Update is called once per frame
    void Update()
    {
        

       

    }
}
