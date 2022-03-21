using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Chat : MonoBehaviour
{
    private InputField inputField;
    private Text textWindow;
    public Button button;
    public static string chatString;
    // Start is called before the first frame update
    void Start()
    {
        chatString = " ";
        inputField = GetComponentInChildren<InputField>();
        button.onClick.AddListener(Send);
        textWindow = GetComponent<Text>();


    }

    // Update is called once per frame
    void Update()
    {

        if (chatString != " ")
            textWindow.text = chatString;

    }

    private void Send()
    {
        chatString += "ionel" + ": " + inputField.text+"\n";
        inputField.text = "";


        ServerTest.json = chatString;

       

    }




}
