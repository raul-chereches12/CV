package ex1;

import java.util.Random;

class TemperatureControl extends ObservableTemperature implements Runnable{

    void changeTemperature(){
        System.out.println("Temperature has been changed!");
        this.changeState(new Random().nextInt(60)-20);//bound -20.....40 degrees
    }

    @Override
    public void run() {
        
        while (true) {
            changeTemperature();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
