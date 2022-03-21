using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class InfoUi : MonoBehaviour
{
    //to be attached to text

    private static Text infoText;

    // Start is called before the first frame update
    void Start()
    {
        infoText = GetComponent<Text>();
    }

    // Update is called once per frame
    void Update()
    {
       
    }

    public static void getInfo(GameObject gameObj)
    {

        if (gameObj.name == "sword_ranseur_dropped")
        {
            infoText.text = "Obiect: sabie\n\n\n" + "Daune: 15\n" + "Ranseur of Hatred";
        }else if (gameObj.name == "grass_isometric(Clone)")
        {
            infoText.text = "\n\n\n just iarba";
        }
        else
        infoText.text = "nimic";
    }


}
