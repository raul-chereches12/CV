package ex6;

public class On {

    public boolean on=true;

    private static int minutes;
    private static int seconds;
    private static int miliseconds;


    On(){

        On.miliseconds=0;
        On.seconds=0;
        On.minutes=0;

    }

    synchronized void startChronometer(){
try {
    while (on) {
        Thread.sleep(0,1);
        miliseconds++;
        if (miliseconds == 1001) {
            miliseconds = 0;
            seconds++;
        }
        if (seconds == 61) {

            seconds = 0;
            minutes++;

        }

        Chronometer.display.setText(minutes + ":" + seconds + ":" + miliseconds);
    }
}catch (Exception e)
{
    System.out.println(e);
}


    }

    public static void resetChronometer(){

        On.miliseconds=0;
        On.seconds=0;
        On.minutes=0;
    }

}
