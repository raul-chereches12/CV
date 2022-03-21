package ex2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCircle {

@Test

    void testConstructor(){
    Circle cerc=new Circle(5);
    assertEquals(5,cerc.getRadius());
}
    @Test
    void testConstructor1(){
        Circle cerc1=new Circle(10,"yellow");
        assertEquals(10,cerc1.getRadius());
    }
    @Test
    void testArea(){
        Circle cerc2=new Circle(10,"yellow");
        assertEquals(Math.PI* 10*10,Math.PI* cerc2.getRadius()* cerc2.getRadius());

    }


}
