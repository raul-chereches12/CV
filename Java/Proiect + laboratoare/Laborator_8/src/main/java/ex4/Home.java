package ex4;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

abstract class Home {
    private Random r = new Random();
    private final int SIMULATION_STEPS = 20;

    private int presetValue = 15;//temperatura de referinta prestabilita

    protected abstract void setValueInEnvironment(Event event);

    protected abstract void controllStep();

    private Event getHomeEvent() {


        //randomly generate a new event;
        int k = r.nextInt(100);
        if (k < presetValue) {
            return new HeatEvent();

        } else if (k < 30) {
            return new CoolEvent();
        }
//        else if(k<30)
//            return new NoEvent();
        else if (k < 60) {
            switch (r.nextInt(4)) {

                case 0:
                    return new FireEvent(r.nextBoolean(), "baie");

                case 1:
                    return new FireEvent(r.nextBoolean(), "sufragerie");

                case 2:
                    return new FireEvent(r.nextBoolean(), "camera-noapte");

                case 3:
                    return new FireEvent(r.nextBoolean(), "debara");


                default:
                    return new NoEvent();
            }
        } else
            return new TemperatureEvent(r.nextInt(50));
    }

    public void simulate() {
        File file = new File("src/main/java/ex4/event_log.txt");

        try {
            FileWriter myFileWriter = new FileWriter("event_log.txt");
            int k = 0;
            while (k < SIMULATION_STEPS) {
                Event event = this.getHomeEvent();
                setValueInEnvironment(event);
                controllStep();


                myFileWriter.write("data: " + k + ".11.1999 Event:" + event + "\n");

                try {

                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }


                k++;

            }
            myFileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
