import com.fazecast.jSerialComm.SerialPort;

import java.awt.*;
import java.io.IOException;

/**
 * Simple application that is part of an tutorial.
 * The tutorial shows how to establish a serial connection between a Java and Arduino program.
 * @author Michael Schoeffler (www.mschoeffler.de)
 *
 */
class Transmision extends Thread{

    public void run()  {
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

int grade;
        while(active){
            try {
grade=(int)(180-(Car.turation)/44.4444);
             //   sp.getOutputStream().write((byte)Car.turation);


          //      System.out.printf("0x%02X \n",(byte)Car.turation );

               sp.getOutputStream().write((byte)grade);




                System.out.println(grade);
                System.out.println(Car.turation);
    Thread.sleep(16,666);//timp de asteptare pentru a ajunge in pozitia curenta


}catch (Exception e){
    System.out.println(e);
}

        }


        if (sp.closePort()) {
            System.out.println("Port is closed :)");
        } else {
            System.out.println("Failed to close port :(");
            return;
        }


    }

}

