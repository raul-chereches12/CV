package ex5;

import java.util.ArrayList;

public class Controler {

    String stationName;

    ArrayList<Controler> neighbourControllerList=new ArrayList<Controler>();

    //storing station train track segments
    ArrayList<Segment> list = new ArrayList<Segment>();

    public Controler(String gara) {
        stationName = gara;
    }



    void addNeighbourControllerList(Controler s){
        neighbourControllerList.add(s);
    }

    void addControlledSegment(Segment s){
        list.add(s);
    }

    /**
     * Check controlled segments and return the id of the first free segment or -1 in case there is no free segment in this station
     *
     * @return
     */
    int getFreeSegmentId(){
        for(Segment s:list){
            if(s.hasTrain()==false)
                return s.id;
        }
        return -1;
    }

    public String controlStep(){
        //check which train must be sent
        for(Controler neighbour:neighbourControllerList) {
            for (Segment segment : list) {

                if (segment.hasTrain()) {

                    Train t = segment.getTrain();

                    if (t.getDestination().equals(neighbour.stationName)) {

                        //check if there is a free segment
                        int id = neighbour.getFreeSegmentId();
                        if (id == -1) {
                            return " Trenul +" + t.name + "din gara " + stationName + " nu poate fi trimis catre " + neighbour.stationName + ". Nici un segment disponibil!\n";

                        }
                        String text;
                        //send train
                        text="Trenul " + t.name + " pleaca din gara " + stationName + " spre gara " + neighbour.stationName+"\n";
                        segment.departTRain();
                        neighbour.arriveTrain(t, id);
                        return text;
                    }

                }
            }//.for
        }//.for 2 controller
return "";
    }//.


    public void arriveTrain(Train t, int idSegment){
        for(Segment segment:list){
            //search id segment and add train on it
            if(segment.id == idSegment)
                if(segment.hasTrain()==true){
                    System.out.println("CRASH! Train "+t.name+" colided with "+segment.getTrain().name+" on segment "+segment.id+" in station "+stationName);
                    return;
                }else{
                    System.out.println("Train "+t.name+" arrived on segment "+segment.id+" in station "+stationName);
                    segment.arriveTrain(t);
                    return;
                }
        }

        //this should not happen
        System.out.println("Train "+t.name+" cannot be received "+stationName+". Check controller logic algorithm!");

    }


    public String displayStationState(){
        String text="=== STATION "+stationName+" === \n";
        //System.out.println("=== STATION "+stationName+" ===");
        for(Segment s:list){
            if(s.hasTrain())
                text+="|----------ID="+s.id+"__Train="+s.getTrain().name+" to "+s.getTrain().destination+"__----------|\n";
            else
            text+="|----------ID="+s.id+"__Train=______ catre ________----------|\n";
        }
        return text;
    }


    public Segment getFreeSegmentOfid(int id_cautat){
        for(Segment s:list){
            if((s.hasTrain()==false)&&(s.id==id_cautat))
                return s;
        }
        return null;
    }

}
