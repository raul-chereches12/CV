using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Chat : MonoBehaviour
{
    private static InputField inputField;
    private static Text textWindow;
    public Button button;
    public static string chatString;
    private string auxString;
    //public static GameObject gameObj;
   
    // Start is called before the first frame update
    void Start()
    {
        

        chatString = " ";
        inputField= GetComponentInChildren<InputField>();
        button.onClick.AddListener(Send);
        textWindow = GetComponent<Text>();


    }

    // Update is called once per frame
    void Update()
    {

        if (chatString != " ")
            textWindow.text = chatString;


    }

    private static void Send()
    {
        
        chatString += Player.getName() + ": " + inputField.text+"\n";
        inputField.text = "";

        ClientTest.json = chatString;

       

    }




}
