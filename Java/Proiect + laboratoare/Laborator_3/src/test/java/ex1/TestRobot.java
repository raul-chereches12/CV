package ex1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRobot {

@Test
    void testConstrutor(){
    Robot robot =new Robot();
    assertEquals(1,robot.getX());


}

@Test

    void testChangeWhenValueIsHigherThan1(){
    Robot robot= new Robot();
    assertEquals(1,robot.getX());
    robot.Change(10);
    assertEquals(10,robot.getX());

}

@Test void testChangeWhenValueIsLowerThan1(){
    Robot robot= new Robot();
    assertEquals(1,robot.getX());
    robot.Change(-5);
    assertEquals(1,robot.getX());
}



}
