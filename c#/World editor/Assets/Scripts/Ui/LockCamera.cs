using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class LockCamera : MonoBehaviour
{

    public static Toggle toggle;
    // Start is called before the first frame update
    void Start()
    {

        toggle = GetComponent<Toggle>();
        Debug.Log(toggle);
        //Add listener for when the state of the Toggle changes, and output the state
        toggle.onValueChanged.AddListener(delegate {
            ToggleValueChanged(toggle);
        });

    }

    void ToggleValueChanged(Toggle change)
    {
        Debug.Log("psssss");
        CameraMovement.lockCamera = !CameraMovement.lockCamera;
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
