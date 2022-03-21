package arduino_control;

import java.io.IOException;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

/**
 * Simple application that is part of an tutorial.
 * The tutorial shows how to establish a serial connection between a Java and Arduino program.
 * @author Michael Schoeffler (www.mschoeffler.de)
 *
 */
class Led_Blink {

    public static void main(String[] args) throws IOException, InterruptedException {
boolean active=true;
        SerialPort sp = SerialPort.getCommPort("COM5"); // device name TODO: must be changed
        sp.setComPortParameters(9600, 8, 1, 0); // default connection settings for Arduino
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0); // block until bytes can be written

        if (sp.openPort()) {
            System.out.println("Port is open :)");
        } else {
            System.out.println("Failed to open port :(");
            return;
        }
        //Scanner scan =new Scanner(System.in);
        MyFrame gui=new MyFrame();

        while(active){


            //if(gui.getChange()==1) {//s-a schimbat
                if (gui.isOn()) {
                    sp.getOutputStream().write(1);
                    gui.resetChange();
                } else {
                    sp.getOutputStream().write(0);
                    gui.resetChange();
                }
          //  }
            sp.getOutputStream().flush();

if(gui.isOn())
            System.out.println("ON");
else
    System.out.println("OFF");
Thread.sleep(250);
           // if(option==3)
                //active=false;

        }
gui.dispose();

        if (sp.closePort()) {
            System.out.println("Port is closed :)");
        } else {
            System.out.println("Failed to close port :(");
            return;
        }


    }

}
