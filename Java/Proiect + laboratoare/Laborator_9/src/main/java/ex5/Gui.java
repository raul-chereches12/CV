package ex5;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {



    JFrame f = new JFrame("Interfata Utilizator-Simulator Trenuri");
    private JButton button1 = new JButton("add Train");
    private JButton button2 = new JButton("Choose Segment");
    private JButton button3 = new JButton("Choose Destination");
    private static String areaText;
    TextArea consola = new TextArea();
    TextField consolaSegment = new TextField();
    TextField consolaDestinatie = new TextField();
    Controler c1;
    Controler c2;


    Gui(Controler c1,Controler c2) {
this.c1=c1;
this.c2=c2;
        windowsInit();
        initButtons();
        initTextConsoles();
        addComponentsToFrame();

    }


    public void windowsInit() {

        f.setLayout(null);
        f.setSize(1024, 768);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        JLabel img=new JLabel(new ImageIcon("src/main/resources/title_noBackground.png"));
        img.setBounds(0,0,823,175);
       f.add(img);
        f.repaint();


    }

    public void initButtons() {
        button1.setBounds(300,150,200,50);
        button2.setBounds(1024-500,150,200,25);
                button2.setEnabled(false);

        button3.setBounds(1024-500+200,150,200,25);
        button3.setEnabled(false);


    }

    public void initTextConsoles() {

        consola.setBounds(0, 200, 1024, 768 - 200);
        consolaSegment.setBounds(1024-500,175,200,25);
        consolaDestinatie.setBounds(1024-500+200,175,200,25);
        f.repaint();

    }

    public void addComponentsToFrame() {
        f.add(button1);
        f.add(button2);
        f.add(consola);
        f.add(button3);
        f.add(consolaSegment);
        f.add(consolaDestinatie);
        f.repaint();

    }
    public void writeConsole(String string){

        areaText=areaText+"\n"+string;

        consola.setText(areaText);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
String destinatie =consolaDestinatie.getText();
int idSegment= Integer.parseInt(consolaSegment.getText());


           if(destinatie=="Bucuresti"){

               if(c2.getFreeSegmentOfid(idSegment)!=null){
                   c2.getFreeSegmentOfid(idSegment).arriveTrain(new Train("Bucuresti","Cfr 1900"));
               }else{
                   System.out.println("fie nu s a gasit id-ul fie nu este loc de tren");
               }

           }
               else if(destinatie=="Cluj-Napoca")
            {
                if(c1.getFreeSegmentOfid(idSegment)!=null){
                    c1.getFreeSegmentOfid(idSegment).arriveTrain(new Train("Cluj-Napoca","Cfr 1900"));
                }else{
                    System.out.println("fie nu s a gasit id-ul fie nu este loc de tren");
                }

            }else System.out.println("Destinatie necunoscuta");


            this.writeConsole(c1.displayStationState());
            this.writeConsole(c2.displayStationState());
        }

    }
}
