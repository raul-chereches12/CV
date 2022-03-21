package ex1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ObservableTemperature extends JFrame  {
    private JTextArea temperature_display;
    ObservableTemperature(){




        temperature_display=new JTextArea();
        temperature_display.setBounds(150,200,100,25);
        this.add(temperature_display);

    }

    private List<ObserverTempSensor> sensors = new ArrayList<ObserverTempSensor>();

    public void changeState(int temp) {
        notifyAllObservers(temp);
        temperature_display.setText("Temperature: "+temp);
    }

    public void register(ObserverTempSensor observer){
        sensors.add(observer);
    }

    private void notifyAllObservers(int temp){
        for (ObserverTempSensor observer : sensors) {
            observer.update(temp);
        }
    }


}
