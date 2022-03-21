package ex5;

public class Simulator {

    public static void main(String[] args) {




        //build station Cluj-Napoca
        Controler c1 = new Controler("Cluj-Napoca");

        Segment s1 = new Segment(1);
        Segment s2 = new Segment(2);
        Segment s3 = new Segment(3);

        c1.addControlledSegment(s1);
        c1.addControlledSegment(s2);
        c1.addControlledSegment(s3);

        //build station Bucuresti
        Controler c2 = new Controler("Bucuresti");

        Segment s4 = new Segment(4);
        Segment s5 = new Segment(5);
        Segment s6 = new Segment(6);

        c2.addControlledSegment(s4);
        c2.addControlledSegment(s5);
        c2.addControlledSegment(s6);


        //add stations to gui
        Gui gui=new Gui(c1,c2);
        //connect the 2 controllers

        c1.addNeighbourControllerList(c2);
        c2.addNeighbourControllerList(c1);

        //testing

        Train t1 = new Train("Bucuresti", "IC-001");
        s1.arriveTrain(t1);

        Train t2 = new Train("Cluj-Napoca","R-002");
        s5.arriveTrain(t2);

//
        System.out.println(c1.displayStationState());
        System.out.println(c2.displayStationState());
        //
        gui.writeConsole(c1.displayStationState());
        gui.writeConsole(c2.displayStationState());
//
        System.out.println("\nStart train control\n");
        gui.writeConsole("\nStart train control\n");

        //execute 3 times controller steps
        for(int i = 0;i<3;i++){
            System.out.println("### Step "+i+" ###");
            System.out.println(c1.controlStep());
            System.out.println(c2.controlStep());

            gui.writeConsole("### Step "+i+" ###");
            gui.writeConsole(c1.controlStep());
            gui.writeConsole(c2.controlStep());
            gui.writeConsole("\n");
            gui.writeConsole(c1.displayStationState());
            gui.writeConsole(c2.displayStationState());

            System.out.println();
            System.out.println(c1.displayStationState());
            System.out.println(c2.displayStationState());
        }
    }
}
