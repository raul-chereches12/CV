using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Windows.Forms;
using UnityEngine;
using UnityEngine.EventSystems;
using UnityEngine.UI;

public class DropdownBlocks : MonoBehaviour
{
    private static GameObject currentBuildingBlock;
    public Text TextBox;
    public Image icon;

    // Start is called before the first frame update
    void Start()
    {
        var dropdown = transform.GetComponent<Dropdown>();

        dropdown.options.Clear();

        List<string> items = new List<string>();
        //adding elements to list

        FolderBrowserDialog fbd = new FolderBrowserDialog();
        string[] BlockNames = Directory.GetFiles(@"G:\unity 3d\projects\World editor\Assets\Resources\Prefabs", "*.prefab")
                            .Select(Path.GetFileName)
                            .ToArray();

        //making image invisible at first
        icon.GetComponent<Image>().color = new Color32(255, 255, 225, 0);


        foreach (var item in BlockNames)
        {

            dropdown.options.Add(new Dropdown.OptionData() { text = item });
        }

        dropdown.onValueChanged.AddListener(delegate { DropdownItemSelected(dropdown); });
        Debug.Log(dropdown.options.Count);
    }

    void DropdownItemSelected(Dropdown dropdown)
    {
        //making image visible
        icon.GetComponent<Image>().color = new Color32(255, 255, 225, 255);

        int index = dropdown.value;//index for options
        TextBox.text = dropdown.options[index].text;//update textbox field

        //Removing extension .prefab
        string without = TextBox.text.Substring(0, TextBox.text.LastIndexOf('.'));
        currentBuildingBlock = Resources.Load("Prefabs/"+without) as GameObject;
      
        //drawing int the ui
        icon.sprite = currentBuildingBlock.GetComponent<SpriteRenderer>().sprite;
        Debug.Log(currentBuildingBlock);
        
    }

    public static GameObject getCurrentBuildingBlock()
    {
        
        return currentBuildingBlock;
    }

    public static bool isPointerOverInventory()
    {

        return EventSystem.current.IsPointerOverGameObject();
    }


    // Update is called once per frame
    void Update()
    {

    }

}
