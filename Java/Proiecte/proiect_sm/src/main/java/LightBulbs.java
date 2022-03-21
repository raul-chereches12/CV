public class LightBulbs extends Thread{




    public void run(){

        while(true){
            System.out.println("luminile merg");

            if(Car.turation>=4000) {
                System.out.println("luminile se sting");
                Car.board.turration_light_switch();

            }
try{
    Thread.sleep(800);
}catch (Exception a){
    System.out.println(a);
}



        }




    }



}
